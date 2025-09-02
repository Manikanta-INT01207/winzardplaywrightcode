package stepDefnitions.goalAchiever;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class selfgoalcreationSD extends BaseClass {


@Given("employee opens thier portal {string} and {string}")
public void employee_opens_thier_portal_and(String username, String password) {
   
	page.locator("//input[@formcontrolname='username']").fill(username);
    page.locator("//input[@formcontrolname='password']").fill(password);
    page.locator("//span[@class='mat-button-wrapper']").click();
    try {
        page.waitForSelector("//p[text()='User does not exist.']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE));
             page.locator("//span[text()='Ok']").click();
             page.locator("//span[text()='Login ']").click(); 
         
     } 
     catch (Exception ignored) {
       
     }
	
	
}
@Then("goes to the goal achiver portal")
public void goes_to_the_goal_achiver_portal() {
    
	page.locator("//button[@type='button']").click();
	page.locator("//span[text()='Goal Achiever']").click();
	
}
@Then("employees fill the data of {string} , {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
public void employees_fill_the_data_of_and(String goaltitle, String targettype, String bandtype, String weightage, String goaltype, String goalKPI, String target, String goalfrequencey, String startdate, String enddate, String keypoint, String subgoaldata) {
    
	
	String empnames="";
	//goalcreation(goaltitle, targettype, bandtype, weightage, goaltype, goalKPI, target, goalfrequencey, startdate, enddate, keypoint, subgoaldata);
	goalcreation(goaltitle, targettype, bandtype, weightage, goaltype, goalKPI, target, goalfrequencey, startdate, enddate, empnames, keypoint, subgoaldata);
	
}

	
}

