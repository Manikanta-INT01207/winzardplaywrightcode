package stepDefnitions.engagementStepdef;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EngagementStatuschangeSD extends BaseClass {


@Given("user opens the engagment portal {string} and {string}")
public void user_opens_the_engagment_portal_and(String username, String password) {
    
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
		Locator wellbeing = page.locator("//span[text()='Workforce Engagement']");
		wellbeing.scrollIntoViewIfNeeded(); 
		wellbeing.click();
}
@Then("user changes the status of the engagment survey")
public void user_changes_the_status_of_the_engagment_survey() {
   
	page.locator("//span[text()='Org']").click();
	ElementHandle header= page.waitForSelector("//tr[@class='mat-header-row ng-star-inserted']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));

	statuschange();

	
}
	
}
