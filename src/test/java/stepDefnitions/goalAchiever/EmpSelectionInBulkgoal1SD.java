package stepDefnitions.goalAchiever;

import java.util.List;

import org.junit.Assert;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EmpSelectionInBulkgoal1SD extends BaseClass{


@Given("admin logs to profile with credintials {string} and {string}")
public void admin_logs_to_profile_with_credintials_and(String username, String password) {
   
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
@Then("admin goes to their bulk goal tab")
public void admin_goes_to_their_bulk_goal_tab() {
   
	page.locator("//button[@type='button']").click();
	page.locator("//span[text()='Goal Achiever']").click();
	page.locator("//span[normalize-space(text())='Bulk Goals']").click();
	page.locator("#bulk-goal-creation").click();
	page.locator("(//mat-icon[normalize-space(text())='close'])[2]").click();
	page.locator("#bulk-goal-creation").click();
	page.waitForTimeout(2000);
	
}
@Then("admin checks the employee selection functionality by adding filter {string} and {string} then {string} later {string}")
public void admin_checks_the_employee_selection_functionality_by_adding_filter_and_then_later(String category, String subcategory , String EmpIDs, String customemp) {
	choosefilter(category, subcategory);
	page.waitForTimeout(3000);
	Locator employee=page.locator("//mat-card[@class='custom-card mat-card ng-star-inserted']");
	Assert.assertTrue("employee selection mismatched after adding the filters",employee.last().isVisible());
	List<ElementHandle>firstcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
	System.out.println("1st count"+firstcount.size());
	addingEmpsThroughIds(EmpIDs);
	page.waitForTimeout(3000);
	List<ElementHandle>secondcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
	System.out.println("2nd count"+secondcount.size());
	Assert.assertTrue("employee selection mismatched after adding the employee through ID's",secondcount.size()>firstcount.size());
	selectCustomEmployee(customemp);
	List<ElementHandle>thirdcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
	//int totalcount=(secondcount.size()+firstcount.size());
	System.out.println("3rd count"+thirdcount.size());
	Assert.assertTrue("employee selection mismatched after adding the custom employee",thirdcount.size()>secondcount.size());

	
}

	
}
