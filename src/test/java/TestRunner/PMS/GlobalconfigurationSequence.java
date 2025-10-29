package TestRunner.PMS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
		{
		CreateFormsTR.class,
		createCompTR.class,
		assignCompConditionTR.class,
		assignCompEmpLevelTR.class,
		createRecmTR.class,
		createworkflowsconditionlvlTR.class,
		createworkflowsEMPlvlTR.class
		
		}
		)
public class GlobalconfigurationSequence {

}
