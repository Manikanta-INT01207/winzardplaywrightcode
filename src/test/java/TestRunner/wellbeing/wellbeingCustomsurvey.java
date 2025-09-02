package TestRunner.wellbeing;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"feature-files/wellbeing/wellbeingCustomSurvey.feature"},

glue = {"stepDefnitions","Hooksteps"},

plugin = { "pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
monochrome=true

)
public class wellbeingCustomsurvey {

}
