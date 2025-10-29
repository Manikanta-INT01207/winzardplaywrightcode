package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class createRecomSD extends BaseClass{

	@Then("admin clicks on the start new to create a new recommendations")
	public void admin_clicks_on_the_start_new_to_create_a_new_recommendations() {
	    
		page.locator("//div[text()='Recommendations']").click();
        page.locator("//button[normalize-space()='+ Start New']").click();
	}
	@Then("admin creates the recommendations by adding the {string} and {string}")
	public void admin_creates_the_recommendations_by_adding_the_and(String title, String description) {
		
		String[] rec=title.split(",");
		String [] recdesc=description.split(",");
		
		 for(int i=0;i<recdesc.length;i++) {
	            page.locator("//button[normalize-space()='+ Add recommendations']").click();
	            page.locator("//textarea[@placeholder='Enter the title']").last().click();
	            page.locator("//textarea[@placeholder='Enter the title']").last().fill(rec[i]);
	            page.locator("//textarea[@placeholder='Enter the description']").last().click();
	            page.locator("//textarea[@placeholder='Enter the description']").last().fill(recdesc[i]);
	            }
	        page.locator("//button[text()='Save']").click();
	        Locator successmessage=page.locator("//p[text()='Recommendations added succesfully']");
	        successmessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
	        assertTrue("recommendations not created", successmessage.isVisible());
	        
		
	}
	
}
