package TestRunner.GoalAchiever;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	Empselectionbulkgoal1TR.class,
	EmpselectionbulkGoal2TR.class,
	FilterClearFunctionalityTR.class,
	bulkgoalcreationTR.class,
	bulkgoalSearchFunctionalityTR.class,
	AdminBulkgoalDeletionTR.class,
	bulkGoalNegativeCaseTR.class
	
	
})

public class bulkgoalsSequence {

}
