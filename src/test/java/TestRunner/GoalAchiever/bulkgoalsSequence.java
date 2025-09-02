package TestRunner.GoalAchiever;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	bulkgoalcreationTR.class,
	bulkgoalSearchFunctionalityTR.class,
	EmpAchmntsRatingsTR.class,
	SupervisorAchmntsRatingsTR.class,
	AdminBulkgoalDeletionTR.class
	
	
})

public class bulkgoalsSequence {

}
