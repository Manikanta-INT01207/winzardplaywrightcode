package stepDefnitions.wellbeingStepdef;

import java.util.List;
import java.util.Random;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WellbeingDueEmpSurveyfilling extends BaseClass{


	@Given("due employee goes to  wellebing portal {string} and {string}")
	public void due_employee_goes_to_wellebing_portal_and(String usernameeeee, String passwordsss) {
	   
//		page.locator("//div[text()='YP']").click(new Locator.ClickOptions().setForce(true));
//		page.waitForTimeout(1000); 
//		page.locator("//li[text()='Log-Out ']").click(new Locator.ClickOptions().setForce(true));
//		page.locator("//span[text()='Logout']").click();
//		page.waitForTimeout(3000);
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
	@Then("due employees opens the survey to fil it")
	public void due_employees_opens_the_survey_to_fil_it() {
	    
		page.locator("//mat-icon[text()='menu']").click();
        Locator engagement = page.locator("//span[text()='Workforce Wellbeing']");
        engagement.scrollIntoViewIfNeeded(); 
        engagement.click();
        page.waitForTimeout(4000);
        Locator startNow = page.locator("//button[text()='Start Now']");
        startNow.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        startNow.click();
	}
	@Then("due employee gives the rating and {string} and {string}")
	public void due_employee_gives_the_rating_and_and(String optionAnswer, String freeTextAnswer) {
	surveyfilling(optionAnswer, freeTextAnswer);
			
	}
	


	
}
