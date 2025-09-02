package TestRunner.Engagement;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	EngagementCustomsurvey.class,
	EngagementSurveyfilling.class,
	EngagementRemaindersTR.class,
	EngagementDueEmpsurveyfillingTR.class,
	EngagementStatusChange.class,
	EngagmentInsightsgenerateTR.class
	
	
	
	
})
public class EngagementSequence {

}
