package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class createCompSD  extends BaseClass{

	@Then("admin clicks on the start new to create a new competencies")
	public void admin_clicks_on_the_start_new_to_create_a_new_competencies() {
		 page.locator("//div[text()='Create Competencies / Skills / Potential ']").click();
	        page.locator("//button[normalize-space()='+ Start New']").click();
	        
		
	}
	@Then("admin adds the comptencies {string} and {string}")
	public void admin_adds_the_comptencies_and(String title, String description) {
	    
		String [] comps =title.split(",");
		String[]compdesc=description.split(",");
		for(int i=0;i<comps.length;i++) {
	        page.locator("//button[normalize-space()='+ Add competency']").click();
	        page.locator("//textarea[@placeholder='Enter the title']").last().click();
	        page.locator("//textarea[@placeholder='Enter the title']").last().fill(comps[i]);
	        page.locator("//textarea[@placeholder='Enter the description']").last().click();
	        page.locator("//textarea[@placeholder='Enter the description']").last().fill(compdesc[i]);
	        }
	        page.locator("//button[text()='Save']").click();
	      Locator successmessage=page.locator("//p[text()='Comepetencies added succesfully']");
	      successmessage.waitFor(new Locator .WaitForOptions().setState(WaitForSelectorState.VISIBLE));
	      assertTrue("comptencies not created ", successmessage.isVisible());
	}
	
}
