package TestRunner.GoalAchiever;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = {"feature-files/goalAchiever/EmpselectionInBulkGoal1.feature"},
		glue= {"stepDefnitions","Hooksteps"},
		plugin= {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}




		)

public class Empselectionbulkgoal1TR {

}
