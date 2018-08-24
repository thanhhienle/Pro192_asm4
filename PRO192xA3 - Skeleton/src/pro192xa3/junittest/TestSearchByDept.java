package pro192xa3.junittest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pro192xa3.business.EmployeeManagement;
import pro192xa3.entity.EDegree;
import pro192xa3.entity.EPosition;
import pro192xa3.entity.Employee;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

public class TestSearchByDept {

	@Test
	public void testSearchByDept() {
		String dept = "app.dept";
		EmployeeManagement empMan = new EmployeeManagement();
		ArrayList<Employee> empFound = empMan.searchByDept(dept);
		
		ArrayList<Employee> expectedResult = new ArrayList<>();
		Staff s = new Staff();
		s.setFullName("Tran Minh Tuan");
		s.setDepartment("App.Dept");
		s.setPosition(EPosition.HEAD);
		s.setSalaryRatio(20);
		s.setAllowance(2000);
		s.setNoOfWorkingDay(22);
		expectedResult.add(s);
		
		String text = empFound.get(0).toString();
		String text2 = expectedResult.get(0).toString();
		assertEquals(text, text2);
	}
	
	@Test
	public void testSearchByDept2() {
		String fal = "ngu van";
		EmployeeManagement empMan = new EmployeeManagement();
		ArrayList<Employee> empFound = empMan.searchByDept(fal);
		
		ArrayList<Employee> expectedResult = new ArrayList<>();
		Teacher t = new Teacher();
		t.setFullName("Vo Thanh Huy");
		t.setFaculty("Ngu Van");
		t.setDegree(EDegree.BACHELOR);
		t.setSalaryRatio(5);
		t.setAllowance(300);
		t.setTeachingHours(45);
		expectedResult.add(t);
		
		String text = empFound.get(0).toString();
		String text2 = expectedResult.get(0).toString();
		assertEquals(text, text2);		
	}
	
	@Test
	public void testSearchByDept3() {
		String dept = "unlisted dept";
		EmployeeManagement empMan = new EmployeeManagement();
		ArrayList<Employee> empFound = empMan.searchByDept(dept);
		
		assertEquals(empFound.size(), 0);
	}

}
