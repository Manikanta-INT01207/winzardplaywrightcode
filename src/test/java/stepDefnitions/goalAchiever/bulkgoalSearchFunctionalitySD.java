package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class bulkgoalSearchFunctionalitySD  extends BaseClass{

	@Given("admin logs into thier account {string} and {string}")
	public void admin_logs_into_thier_account_and(String username, String password) {

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
	@Then("admin view a particular {string} goals then searches a goal with {string} to verify the search functionality")
	public void admin_view_a_particular_goals_then_searches_a_goal_with_to_verify_the_search_functionality(String empID, String goalTitle) {

		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.locator("//span[normalize-space()='Bulk Goals']").click();
		page.locator("//input[@id='org-level-emp-search-bar']").click();
		page.locator("//input[@id='org-level-emp-search-bar']").fill(empID);
		page.locator("//span[contains(text(),'"+empID+"')]").click();

		Locator searchbar1=page.locator("//input[@id='search-bar-empid']");
		searchbar1.click();
		searchbar1.fill(goalTitle);
		searchbar1.press("Enter");
		Locator goals2=page.locator("//tr[contains(@class,'row-ACTIVE')]");
		assertEquals("Expected exactly one active goal row", 1, goals2.count());

		if(goals2.count()>1) {
			System.out.println("search functionality failed");
		}
		else {

			page.locator("//td[normalize-space()='"+goalTitle+"']").click();
			System.out.println("search functionality working fine");
			page.locator("//mat-icon[text()='close']").click();
		}
		searchbar1.clear();
		assertEquals("Search bar should be empty.", "", searchbar1.inputValue());
		assertTrue("Expected more than one active goal row", goals2.count() > 1);
		if(goals2.count()>1) {
			System.out.println("search clear functionality working fine");
		}
		else {
			System.out.println("search clear functionality failed");

		}

		searchbar1.click();
		searchbar1.fill(goalTitle);
		searchbar1.press("Enter");
		page.locator("//mat-icon[text()='arrow_back']").click();
		page.locator("//input[@id='org-level-emp-search-bar']").click();
		page.locator("//input[@id='org-level-emp-search-bar']").fill(empID);
		page.locator("//span[contains(text(),'"+empID+"')]").click();
		page.waitForTimeout(2000);
		assertTrue("Expected more than one active goal row", goals2.count() > 1);


	}

}
