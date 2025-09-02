package TestRunner.Engagement;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"feature-files/Engagement/Engagementdueemployeesurveyfilling.feature"},
		glue = {"stepDefnitions","Hooksteps"},

		plugin = {"pretty",
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
		
		
		
		
		)

public class EngagementDueEmpsurveyfillingTR {

}
