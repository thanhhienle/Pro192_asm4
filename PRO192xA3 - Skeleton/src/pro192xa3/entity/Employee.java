/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.entity;

/**
 *
 * @author hp
 */
public abstract class Employee implements Comparable<Employee> {
    private String fullName;
    private float salaryRatio;//he so luong    
   
    private float allowance;//phu cap   
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getSalaryRatio() {
        return salaryRatio;
    }

    public void setSalaryRatio(float salaryRatio) {
        this.salaryRatio = salaryRatio;
    }

    public float getAllowance() {        
        return allowance;
    }

    public void setAllowance(float allowance) {
        this.allowance = allowance;
    } 
    
    public abstract float getSalary();
    @Override
    public int compareTo(Employee emp){
    	//so sanh ten nhan vien/giao vien khong phan biet hoa thuong
        return this.fullName.toLowerCase().compareTo(emp.fullName.toLowerCase());
    }
}
