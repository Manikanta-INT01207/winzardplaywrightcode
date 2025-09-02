package stepDefnitions.goalAchiever;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TeamGoalsCreationSD extends BaseClass {

	@Given("supervisor opens their profile {string} and {string}")
	public void supervisor_opens_their_profile_and(String username, String password) {
	    
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
	@Then("supervisr goes to the team goals tab in goal achiver portal")
	public void supervisr_goes_to_the_team_goals_tab_in_goal_achiver_portal() {
	   
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		
		page.locator("//span[normalize-space()='Team Goals']").click();
		Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
		if(!leftpanel.isVisible()) {
			page.locator("//mat-icon[text()='refresh']").click();
			leftpanel.waitFor();
		}

		
	}
	@Then("supervisor  fill the data of {string} , {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} ,{string} and {string}")
	public void supervisor_fill_the_data_of_and(String goaltitle, String targettype, String bandtype, String weightage, String goaltype, String goalKPI, String target, String goalfrequencey, String startdate, String enddate, String empnames, String keypoint, String subgoaldata) {
	   
		goalcreation(goaltitle, targettype, bandtype, weightage, goaltype, goalKPI, target, goalfrequencey, startdate, enddate, empnames, keypoint, subgoaldata);
	}
}
