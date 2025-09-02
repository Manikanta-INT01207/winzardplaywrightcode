package stepDefnitions.wellbeingStepdef;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WellbeingInsightsgenerate extends BaseClass{

	
	
	@Given("user went to wellbeing portal {string} and {string}")
	public void user_went_to_wellbeing_portal_and(String username, String password) {
	   
		 page.locator("//input[@formcontrolname='username']").fill(username);
	      page.locator("//input[@formcontrolname='password']").fill(password);
	      page.locator("//span[@class='mat-button-wrapper']").click();
	      try {
	          page.waitForSelector("//p[text()='User does not exist.']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE));
	               page.locator("//span[text()='Ok']").click(); // Click OK on error dialog
	               page.locator("//span[text()='Login ']").click(); // Retry login
	           
	       } 
	       catch (Exception ignored) {
	         
	       }
			page.locator("//mat-icon[text()='menu']").click();
			Locator wellbeing = page.locator("//span[text()='Workforce Wellbeing']");
			wellbeing.scrollIntoViewIfNeeded(); 
			wellbeing.click();
	      
		}
		
	
	@Then("user generates the insights for particular survey using the dates {string} and {string} selects the access persons {string} and {string} and custom employee name {string} if you want to access to the particular person")
	public void user_generates_the_insights_for_particular_survey_using_the_dates_and_selects_the_access_persons_and_and_custom_employee_name_if_you_want_to_access_to_the_particular_person(String startdate, String enddate, String count, String personnames, String empid) {
	   
		int countt =Integer.parseInt(count);
		
		page.locator("//span[text()='Org']").click();
		ElementHandle header= page.waitForSelector("//tr[@class='mat-header-row ng-star-inserted']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));

		
     generateInsights(startdate, enddate,countt, personnames, empid);
     
     
		
	}
	
}
