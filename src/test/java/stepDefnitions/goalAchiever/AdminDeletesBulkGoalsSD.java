package stepDefnitions.goalAchiever;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdminDeletesBulkGoalsSD extends BaseClass{

	
	@Given("admin opens thier portal with {string} and  {string}")
	public void admin_opens_thier_portal_with_and(String username, String password) {
	   
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
	@Then("admin goes to the buk goal tab")
	public void admin_goes_to_the_buk_goal_tab() {
	    
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.locator("//span[normalize-space()='Bulk Goals']").click();

		
	}
	@Then("admin delete the existing bulk goals")
	public void admin_delete_the_existing_bulk_goals() {
	  
		page.locator("//span[normalize-space()='Bulk']").click();
		page.locator("//mat-icon[text()='refresh']").click();
		Locator goaltable=page.locator("//table[contains(@class,'mat-table')]");
		goaltable.waitFor();
		Locator goals=page.locator("(//mat-icon[text()='delete'])[1]");
		while (goals.isVisible()) {
			page.locator("(//mat-icon[text()='delete'])[1]").click();
			page.locator("//span[text()='Yes']").click();
			Locator message=page.locator("//p[text()='Bulk Goal Deleted Succesfully!!']");
			message.waitFor();
			if(message.isVisible()) {
				System.out.println(message.innerText());
				message.waitFor(new Locator.WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

			}
			else {
				System.out.println("goal not deleted");
			}
		}

		
	}
}
