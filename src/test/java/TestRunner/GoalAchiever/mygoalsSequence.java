package TestRunner.GoalAchiever;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		
    selfGoalCreationTR.class,
    ApprovalorRejectionOfGoalTR.class,
    ResubmissionOfRejectedGoalTR.class,
    SearchFunctionalityMygoalsTabTR.class,
	EmpAchmntsRatingsTR.class,
	SupervisorAchmntsRatingsTR.class,
	selfGoalCreationNegativeCaseTR.class
		
		
		
		
		
})

public class mygoalsSequence {

}
