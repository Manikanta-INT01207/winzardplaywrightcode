package stepDefnitions.wellbeingStepdef;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WellBeingDefaultSurvey extends BaseClass{
   String beforeemployeeCount;
//	@Given("user is on the workforce wellbeing page")
//	public void user_is_on_the_workforce_wellbeing_page() {
//	    
//		
//		page.locator("//mat-icon[text()='menu']").click();
//		Locator wellbeing = page.locator("//span[text()='Workforce Wellbeing']");
//		wellbeing.scrollIntoViewIfNeeded(); 
//		wellbeing.click();
//	}
   
   @Given("user is on the workforce wellbeing page {string} and {string}")
   public void user_is_on_the_workforce_wellbeing_page_and(String username, String password) {
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

   
	@Then("user clicks the org tab to initiate survey")
	public void user_clicks_the_org_tab_to_initiate_survey() {
	    
		page.locator("//span[text()='Org']").click();
		 page.waitForTimeout(3000);
       page.locator("//button[text()='+ Start New']").click();

	}
	@Then("admin adds the employees through {string} either through filters {string} and {string} and through {string}")
	public void admin_adds_the_employees_through_either_through_filters_and_and_through(String customEmp, String category, String subcategory, String empIDS) {
	   
		page.waitForTimeout(2000);
        selectCustomEmployee(customEmp);
        choosefilter(category,subcategory);
        addingEmpsThroughIds(empIDS);
        Locator beforeSelectempscount=page.locator("//div[@class='stepper-heading ng-star-inserted']");
		beforeemployeeCount=beforeSelectempscount.innerText();
		System.out.println(beforeemployeeCount);
		
	}
	@Then("clicks on the next button to create an wellbeing default survey")
	public void clicks_on_the_next_button_to_create_an_wellbeing_default_survey() {
		 page.locator("//button[text()='Next']").click();
	}
	@Then("user selects the {string} and {string}")
	public void user_selects_the_and(String startdate, String enddate) {
		page.locator("//input[@formcontrolname='startDate']").click();
        selectcalander(startdate);
        page.locator("//input[@formcontrolname='endDate']").click();
        selectcalander(enddate);
	}
	@Then("user clicks on the initiate button")
	public void user_clicks_on_the_initiate_button() {
	   
		page.locator("//button[text()=' Initiate']").click();
		
		ElementHandle active = page.waitForSelector("xpath=//span[text()='ACTIVE']",new Page.WaitForSelectorOptions().setTimeout(240_000).setState(WaitForSelectorState.VISIBLE));
		List<ElementHandle> Activerows=page.querySelectorAll("//tr[@ng-reflect-klass='row-ACTIVE']");

		boolean survey=false;
		Outer:
			for (ElementHandle activerow : Activerows) {
				List<ElementHandle> activecolumns=activerow.querySelectorAll("td");
				for (ElementHandle activecol : activecolumns) {
					List<ElementHandle> span=activecol.querySelectorAll("//span[@class='due-cell']");
					for (ElementHandle spans : span) {
						if(beforeemployeeCount.contains(spans.innerText())) {
							System.out.println(spans.innerText());
							System.out.println("survey created successfully ");
							survey=true;
							break Outer;

						}
					}
				}
			}
		if(!survey) {
			System.out.println("Survey created successfully but employee count is mismatched");
		}
	}


	
	
}
