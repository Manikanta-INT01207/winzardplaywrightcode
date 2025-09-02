package stepDefnitions.wellbeingStepdef;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class wellbeingremaindersSending extends BaseClass {

	

//@Given("Admin opens the wellbeing portal")
//public void admin_opens_the_wellbeing_portal() {
//	page.locator("//span[@class='mat-button-wrapper']").click();
//	page.locator("//mat-icon[text()='menu']").click();
//	Locator wellbeing=page.locator("//span[text()='Workforce Wellbeing']");
//	wellbeing.scrollIntoViewIfNeeded();
//	wellbeing.click();
//	page.locator("//span[text()='Org']").click();
//	
//}
	@Given("Admin opens the wellbeing portal with their {string} and {string}")
	public void admin_opens_the_wellbeing_portal_with_their_and(String username, String password) {
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
     	Locator wellbeing=page.locator("//span[text()='Workforce Wellbeing']");
     	wellbeing.scrollIntoViewIfNeeded();
     	wellbeing.click();
     	page.locator("//span[text()='Org']").click();
     	
	}
	
@Then("admin sends the remainders for the due employees of a active survey")
public void admin_sends_the_remainders_for_the_due_employees_of_a_active_survey() {
   
	ElementHandle header= page.waitForSelector("//tr[@class='mat-header-row ng-star-inserted']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
    List<ElementHandle> activerow=page.querySelectorAll("//tr[contains(@class,'ACTIVE ')]");
    System.out.println(activerow.size());
    ElementHandle remainder1 =  activerow.get(0);
    ElementHandle remainder=remainder1.querySelector("//mat-icon[text()=' notifications_none ']"); 
    remainder.click();
    page.locator("//span[text()='Send']").click();
    
   Locator successmessage=page.locator("//p[text()='Survey reminder sent successfully']");
   
		
 	  successmessage.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
 	  if(successmessage.isVisible()) {
 		  System.out.println("Remainder sent successfully");
 	  }
 	  else {
 		  System.out.println("remainder not seent please cross check");
 	  }
	
    
}
	
}
