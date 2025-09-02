package stepDefnitions.goalAchiever;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SupervisorDeleteGoalsSD extends BaseClass{


@Given("supervisor logs into their portal with {string} and {string}")
public void supervisor_logs_into_their_portal_with_and(String username, String password) {
   
	page.locator("//input[@formcontrolname='username']").fill(username);
    page.locator("//input[@formcontrolname='password']").fill(password);
    page.locator("//span[@class='mat-button-wrapper']").click();
    try {
        page.waitForSelector("//p[text()='User does not exist.']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE));
             page.locator("//span[text()='Ok']").click(); 
             page.locator("//span[text()='Login ']").click(); 
         
     } 
     catch (Exception ignored) {
       
     }
	
}
@Then("supervisor goes to the team goals tab and selects the employee {string}")
public void supervisor_goes_to_the_team_goals_tab_and_selects_the_employee(String empID) {
    
	page.locator("//button[@type='button']").click();
	page.locator("//span[text()='Goal Achiever']").click();
	page.locator("//span[normalize-space()='Team Goals']").click();
	page.waitForTimeout(3000);
	Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
	if(!leftpanel.isVisible()) {
		page.locator("//mat-icon[text()='refresh']").click();
		leftpanel.waitFor();
	}
	page.locator("#emp-search-bar").click();
	page.locator("#emp-search-bar").fill(empID);
	page.locator("//div[@class='name']").click();
	Locator goaltable=page.locator("//table[@class='mat-table']");
	goaltable.waitFor();
	
}
@Then("deletes the goals of the particular employees")
public void deletes_the_goals_of_the_particular_employees() {
   
	Locator goals=page.locator("(//mat-icon[text()='delete'])[1]");
	while (goals.isVisible()) {
		page.locator("(//mat-icon[text()='delete'])[1]").click();
		page.locator("//span[text()='Yes']").click();
		Locator message=page.locator("//p[text()='Goal Deleted Succesfully!!']");
		message.waitFor();
		if(message.isVisible()) {
			System.out.println(message.innerText());
			message.waitFor(new Locator.WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

		}
		else {
			System.out.println("goal not deleted");
		}
	}

	
}

	
}
