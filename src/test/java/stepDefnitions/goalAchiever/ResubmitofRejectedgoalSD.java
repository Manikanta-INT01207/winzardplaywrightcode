package stepDefnitions.goalAchiever;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ResubmitofRejectedgoalSD extends BaseClass {

	@Given("employee view their goals by going to thier portal with {string} and {string}")
	public void employee_view_their_goals_by_going_to_thier_portal_with_and(String username, String password) {
	    
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
	@Then("employee  resubmits the rejected goal")
	public void employee_resubmits_the_rejected_goal() {
	   
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		Locator rejectedrows=page.locator("//tr[contains(@class,'REJECTED')]//mat-icon[@id='edit-goal-btn']");
		System.out.println(rejectedrows.count());
		while(rejectedrows.count()>0) {
		rejectedrows.first().click();
		//	page.locator("//tr[contains(@class,'REJECTED')]//mat-icon[@id='edit-goal-btn']").click();
			 page.locator("//span[text()='Save']").click();
			    page.waitForTimeout(3000);
			    page.locator("//mat-icon[text()='close']").click();

	}
}
}