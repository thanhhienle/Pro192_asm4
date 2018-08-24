package pro192xa3.junittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestGetSalary.class,
	TestSearchByName.class,
	TestSearchByDept.class })
public class JUnitTestSuit {

}
