package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class editrecommendationSD extends BaseClass {


	@Then("admin opens the existing recommendation {string}")
	public void admin_opens_the_existing_recommendation(String recommendation) {

		page.locator("//div[text()='Recommendations']").click();
		page.locator("//span[text()='"+recommendation+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();


	}
	@Then("admin changes the {string} , {string} in it then saves the recommendation")
	public void admin_changes_the_in_it_then_saves_the_recommendation(String recommendationTitle, String description) {
		page.locator("//input[@formcontrolname='recommendationName']").fill(recommendationTitle);
		page.locator("//textarea[@placeholder='Enter the description']").last().fill(description);
		page.locator("//button[text()='Update']").click();

	}
	@Then("admin admin opens the edited recommendation {string} to make sure changes are reflected or not")
	public void admin_admin_opens_the_edited_recommendation_to_make_sure_changes_are_reflected_or_not(String recommendationTitle) {

		Locator successmessage= page.locator("//p[text()='Recommendations updated succesfully']");
		successmessage.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		assertTrue("competencies not updated",successmessage.isVisible());
		page.locator("//span[text()='Ok']").click();
		page.locator("//span[text()='"+recommendationTitle+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();
		page.waitForTimeout(2000);
	}
}
