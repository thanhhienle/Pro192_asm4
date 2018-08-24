package pro192xa3.junittest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pro192xa3.business.EmployeeManagement;
import pro192xa3.entity.EDegree;
import pro192xa3.entity.Employee;
import pro192xa3.entity.Teacher;

public class TestSearchByName {

	@Test
	public void testSearchByName() {
		String name = "phan minh huong";
		EmployeeManagement empMan = new EmployeeManagement();
		ArrayList<Employee> empFound = empMan.searchByName(name);
		
		ArrayList<Employee> expectedResult = new ArrayList<>();
		Teacher t = new Teacher();
		t.setFullName("Phan Minh Huong");
		t.setFaculty("funix");
		t.setDegree(EDegree.DOCTOR);
		t.setSalaryRatio(23);
		t.setAllowance(1000);
		t.setTeachingHours(23);
		expectedResult.add(t);		
		
		String text = empFound.get(0).toString();
		String text2 = expectedResult.get(0).toString();
		assertEquals(text, text2);
	}
	
	@Test
	public void testSearchByName2() {
		String name = "fake name";
		EmployeeManagement empMan = new EmployeeManagement();
		ArrayList<Employee> empFound = empMan.searchByName(name);
		
		assertEquals(empFound.size(), 0);
	}

}
