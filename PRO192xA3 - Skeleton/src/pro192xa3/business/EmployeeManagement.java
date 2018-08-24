/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import pro192xa3.entity.EDegree;
import pro192xa3.entity.EPosition;
import pro192xa3.entity.Employee;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;


/**
 *
 * @author hp
 */
public class EmployeeManagement {

    //store all staff/teacher
    ArrayList<Employee> listE;

    public EmployeeManagement() {        
        listE = new ArrayList<>();
        read();
    }

    public void addEmployee(Employee emp) {
        //add emp to listE
        //your code
    	listE.add(emp);
    	write(emp);
    }
    //search by staff/teacher's name
    public ArrayList<Employee> searchByName(String name) {
        //store all matching staff or teacher
        ArrayList<Employee> empFound = new ArrayList<>();
        //your code
        //tim ten nhan vien co chua chuoi tim kiem, khong phan biet hoa thuong
        for (Employee d : listE) {
        	if (d.getFullName().toLowerCase().contains(name.toLowerCase())) {
        		empFound.add(d);
        	}
        }
        return empFound;
    }
    //search by staff/teacher's department/faculty
    public ArrayList<Employee> searchByDept(String dept) {
        ArrayList<Employee> empFound = new ArrayList<>();
        //your code
        //tim phong/khoa co chua chuoi tim kiem, khong phan biet hoa thuong
        for (Employee d : listE) {
        	if (d instanceof Staff) {
        		if (((Staff) d).getDepartment().toLowerCase().contains(dept.toLowerCase())) {
        			empFound.add(d);
        		}
        	} 
        	if (d instanceof Teacher) {
        		if (((Teacher) d).getFaculty().toLowerCase().contains(dept.toLowerCase())) {
        			empFound.add(d);
        		}
        	}
        }
        return empFound;
    }

    public ArrayList<Employee> listAll() {
        //sort the list of staff/teacher before return
        //your code
    	Collections.sort(listE);
        return listE;
    }  
    
    public void read() {
    	BufferedReader br = null;
    	try {
			br = new BufferedReader(new FileReader("data.txt"));
			String line;
			while ((line = br.readLine()) != null) {							
				String[] parts = line.split(", ");
				if (parts.length != 8 || (!parts[0].equals("Staff") && !parts[0].equals("Teacher"))) {
					System.out.println("Invalid data");
					continue;
				} else {
					String notice = "Notice: ";
					int err = 0;
					if (parts[1].trim().equals("")) {
						notice = notice.concat("Empty_name ");
						err++;
					}
					if (parts[2].trim().equals("")) {
						notice = notice.concat("Empty_Dept/Fal ");
						err++;
					}
					if (parts[3].trim().equals("")) {
						notice = notice.concat("Empty_Pos/Deg ");
						err++;
					}
					try {
						Float.parseFloat(parts[4]);
					} catch (NumberFormatException e) {
						notice = notice.concat("Invalid_sal.ratio ");
						err++;
					}
					try {
						Float.parseFloat(parts[5]);
					} catch (NumberFormatException e) {
						notice = notice.concat("Invalid_allowance ");
						err++;
					}
					if (parts[0].equals("Staff")) {
						try {
							Float.parseFloat(parts[6]);
						} catch (NumberFormatException e) {
							notice = notice.concat("Invalid_noOfWorkingDay ");
							err++;
						}
					} else {
						try {
							Integer.parseInt(parts[6]);
						} catch (NumberFormatException e) {
							notice = notice.concat("Invalid_teachingHour");
							err++;
						}
					}
					
					if (err > 0) {
						System.out.println(notice);
						continue;
					}
					if (parts[0].startsWith("S")) {						
						Staff s = new Staff();
						s.setFullName(parts[1]);
						s.setDepartment(parts[2]);
						s.setPosition(EPosition.setPos(parts[3]));
						s.setSalaryRatio(Float.parseFloat(parts[4]));
						s.setAllowance(Float.parseFloat(parts[5]));
						s.setNoOfWorkingDay(Float.parseFloat(parts[6]));
						listE.add(s);						
						
					} else {
						Teacher t = new Teacher();
						t.setFullName(parts[1]);
						t.setFaculty(parts[2]);
						t.setDegree(EDegree.setDeg(parts[3]));;
						t.setSalaryRatio(Float.parseFloat(parts[4]));
						t.setAllowance(Float.parseFloat(parts[5]));
						t.setTeachingHours(Integer.parseInt(parts[6]));
						listE.add(t);
					}
				}
			}				
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
    }
    
    public void write(Employee emp) {
    	PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter("data.txt", true)));
			if(emp instanceof Staff) {
				pw.println("Staff, " + emp);
			} else {
				pw.println("Teacher, " + emp);
			}		
					
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
    }

}
