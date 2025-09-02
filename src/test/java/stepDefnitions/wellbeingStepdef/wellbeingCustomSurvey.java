package stepDefnitions.wellbeingStepdef;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class wellbeingCustomSurvey extends BaseClass {

	String beforeemployeeCount;
//	@Given("Hr opens the wellbeing portal")
//	public void hr_opens_the_wellbeing_portal() {
//		page.locator("//mat-icon[text()='menu']").click();
//		Locator engagement = page.locator("//span[text()='Workforce Wellbeing']");
//        engagement.scrollIntoViewIfNeeded(); 
//        engagement.click();
//	}
	@Given("Hr opens the wellbeing portal {string} and {string}")
	public void hr_opens_the_wellbeing_portal_and(String username, String password) {
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

	
	@Then("hr clicks on org tab")
	public void hr_clicks_on_org_tab() {
	    
	
        
        page.locator("//span[text()='Org']").click();
		 page.waitForTimeout(3000);
       page.locator("//button[text()='+ Start New']").click();
	}
	@Then("hr adds the employees through {string} through filters {string} and {string} and through {string}")
	public void hr_adds_the_employees_through_through_filters_and_and_through(String customEmp, String category, String subcategory, String empIDS) {
	   
		page.waitForTimeout(2000);
        selectCustomEmployee(customEmp);
        choosefilter(category,subcategory);
        addingEmpsThroughIds(empIDS);
        Locator beforeSelectempscount=page.locator("//div[@class='stepper-heading ng-star-inserted']");
		beforeemployeeCount=beforeSelectempscount.innerText();
		System.out.println(beforeemployeeCount);
		
	}
	@Then("hr clicks on the next button to create")
	public void hr_clicks_on_the_next_button_to_create() {
		 page.locator("//button[text()='Next']").click();
	}
	@Then("hr selects the {string} and {string}  to create survey")
	public void hr_selects_the_and_to_create_survey(String startdate, String enddate) {
	    
		  page.locator("//input[@formcontrolname='startDate']").click();
	        selectcalander(startdate);
	        page.locator("//input[@formcontrolname='endDate']").click();
	        selectcalander(enddate);
	}
	@Then("hr clicks on the Add custom questions to add the questions")
	public void hr_clicks_on_the_add_custom_questions_to_add_the_questions() {
	   
		 page.locator("//span[text()='Add Custom Questions ']").click();
	       page.locator("//button[text()=' Next']").click();
	}
	@Then("hr add the custom questions  {string}, {string}, {string}, {string}")
	public void hr_add_the_custom_questions(String NoofQuestions, String Questiontype, String NoOFsubQuestions, String subquestions) {
	  
		 int questioncount=Integer.parseInt(NoofQuestions);
		   int subquestionscount=Integer.parseInt(NoOFsubQuestions);
			addcustomQuestions(questioncount,Questiontype,subquestionscount,subquestions);
	}
	@Then("hr clicks on the initiate tab to initate the survey")
	public void hr_clicks_on_the_initiate_tab_to_initate_the_survey() {
	    
		Locator initiate=page.locator("//span[text()=' INITIATE ']");
		initiate.click();
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
