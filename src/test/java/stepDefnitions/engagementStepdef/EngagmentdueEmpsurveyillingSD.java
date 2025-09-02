package stepDefnitions.engagementStepdef;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EngagmentdueEmpsurveyillingSD extends BaseClass {

	@Given("due employee goes to  engagement portal {string} and {string}")
	public void due_employee_goes_to_engagement_portal_and(String usernameeeee, String passwordsss) {
	    
		page.locator("//input[@formcontrolname='username']").fill(usernameeeee);

	       
        page.locator("//input[@formcontrolname='password']").fill(passwordsss);

       
        page.locator("//span[@class='mat-button-wrapper']").click();

    
        try {
           page.waitForSelector("//p[text()='User does not exist.']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE));
                page.locator("//span[text()='Ok']").click(); // Click OK on error dialog
                page.locator("//span[text()='Login ']").click(); // Retry login
            
        } 
        catch (Exception ignored) {
          
        }
        
        System.out.println(usernameeeee);
		
	}
	@Then("due employees opens the engagement survey to fil it")
	public void due_employees_opens_the_engagement_survey_to_fil_it() {
		page.locator("//mat-icon[text()='menu']").click();
        Locator engagement = page.locator("//span[text()='Workforce Engagement']");
        engagement.scrollIntoViewIfNeeded(); 
        engagement.click();
        page.waitForTimeout(4000);
        Locator startNow = page.locator("//button[text()='Start Now']");
        startNow.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        startNow.click();
		
		
	}
	@Then("due employee gives the rating and {string} and {string} to the engagment survey then submits it")
	public void due_employee_gives_the_rating_and_and_to_the_engagment_survey_then_submits_it(String optionAnswer, String freeTextAnswer) {
	   
		
		surveyfilling(optionAnswer, freeTextAnswer);

	}
	
}
