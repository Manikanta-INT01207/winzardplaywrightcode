package stepDefnitions.engagementStepdef;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class engagementDefaultSurveySD extends BaseClass{

	String beforeemployeeCount;
	
//	@Given("admin is in the engagement portal")
//	public void admin_is_in_the_engagement_portal() {
//	   
//		
//		page.locator("//mat-icon[text()='menu']").click();
//		Locator engagement = page.locator("//span[text()='Workforce Engagement']");
//        engagement.scrollIntoViewIfNeeded(); 
//        engagement.click();
//		
//	}

	@Given("admin is in the engagement portal {string} and {string}")
	public void admin_is_in_the_engagement_portal_and(String username, String password) {
	    
   
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
		Locator engagement = page.locator("//span[text()='Workforce Engagement']");
      engagement.scrollIntoViewIfNeeded(); 
      engagement.click();
		
		
	}
	
	@Then("admin clicks the org tab")
	public void admin_clicks_the_org_tab() {
	   
		  page.locator("//span[text()='Org']").click();
			 page.waitForTimeout(3000);
	        page.locator("//button[text()='+ Start New']").click();
	}

	@Then("admin selects or adds the employees through the {string} and {string} and {string} and {string}")
	public void admin_selects_or_adds_the_employees_through_the_and_and_and(String customEmployee, String category, String subCategory, String empIDs) {
	   
		page.waitForTimeout(2000);
        selectCustomEmployee(customEmployee);
        choosefilter(category,subCategory);
        addingEmpsThroughIds(empIDs);
        Locator beforeSelectempscount=page.locator("//div[@class='stepper-heading ng-star-inserted']");
		beforeemployeeCount=beforeSelectempscount.innerText();
		System.out.println(beforeemployeeCount);
	}

	@Then("admin enters the {string} and {string}")
	public void admin_enters_the_and(String startdate, String enddate) {
	    
        page.locator("//button[text()='Next']").click();
        page.locator("//input[@formcontrolname='startDate']").click();
        selectcalander(startdate);
        page.locator("//input[@formcontrolname='endDate']").click();
        selectcalander(enddate);

		
	}

	@Then("admin clicks the initiate tab to create the default engagement survey")
	public void admin_clicks_the_initiate_tab_to_create_the_default_engagement_survey() {
	   
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
