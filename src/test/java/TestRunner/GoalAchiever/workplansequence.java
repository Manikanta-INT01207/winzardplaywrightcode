package TestRunner.GoalAchiever;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import io.cucumber.junit.Cucumber;

@RunWith(Suite.class)
@SuiteClasses({
		
	NegativeCreateworkplanScenarioTR.class,
	createworkplanTR.class,
	workplanCommentsAndEditCommentsByManagerTR.class,
	workplanStatusChangeAndRatingByEmpTR.class,
	workplanStatusChangeAndRatingByEmpTR.class,
	workplanRatingByManagerTR.class,
	deleteWorkplanTR.class
		
		
		
})

public class workplansequence {

}
