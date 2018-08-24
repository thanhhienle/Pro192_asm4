package pro192xa3.junittest;

import static org.junit.Assert.*;

import org.junit.Test;

import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

public class TestGetSalary {

	@Test
	public void testStaffGetSalary() {
		Staff staff = new Staff();		
		staff.setSalaryRatio(31);
		staff.setAllowance(2000);
		staff.setNoOfWorkingDay(24);
		float result = staff.getSalary();
		
		assertEquals(25350, result, 0.0f);		
	}
	
	@Test
	public void testTeacherGetSalary() {
		Teacher teacher = new Teacher();
		teacher.setSalaryRatio(26);
		teacher.setAllowance(500);
		teacher.setTeachingHours(45);
		float result = teacher.getSalary();
		
		assertEquals(21505, result, 0.0f);
	}

}
