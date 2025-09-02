package stepDefnitions.goalAchiever;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MygoalsSearchFunctionalitySD extends BaseClass{

	@Given("employees logs into thier account {string} and {string}")
	public void employees_logs_into_thier_account_and(String username, String password) {
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
	@Then("employee searches a goal with {string} to verify the search functionality")
	public void employee_searches_a_goal_with_to_verify_the_search_functionality(String goalTitle) {

		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();

		searchgoal(goalTitle);
	
	}

	
}
