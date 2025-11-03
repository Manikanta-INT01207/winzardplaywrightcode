package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class editFormSD extends BaseClass {

	@Then("admin opens the form {string}")
	public void admin_opens_the_form(String formname) {
		
		String FORM=formname;


		page.locator("//span[text()='"+FORM+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();

		
	}
	@Then("admin changes the {string} and add questions {string} , {string} in it then saves the form")
	public void admin_changes_the_and_add_questions_in_it_then_saves_the_form(String formtitle, String questions, String description) {
	
		String []aa1= questions.split(",");
		String []bb1=description.split(",");

		
		page.locator("//input[@formcontrolname='title']").fill(formtitle);

		page.locator("//mat-expansion-panel-header[contains(@class,'valid')]").first().click();	

		for(int f=0;f<aa1.length;f++) {
			page.locator("//button[text()='+Add Question']").last().click();
			page.locator("//textarea[@formcontrolname='questionTitle']").last().fill(aa1[f]);
			page.locator("//textarea[@formcontrolname='description']").last().fill(bb1[f]);
		}
		page.locator("//button[text()='Save']").click();
		Locator successmessage=page.locator("//p[text()='Form updated successfully']");
		successmessage.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		assertTrue("unable to edit the forms", successmessage.isVisible());

	}
	@Then("admin admin opens the edited form {string} to make sure changes are reflected or not")
	public void admin_admin_opens_the_edited_form_to_make_sure_changes_are_reflected_or_not(String formtitle) {

		page.locator("//span[text()='"+formtitle+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();

		page.locator("//mat-expansion-panel-header[contains(@class,'valid')]").first().click();	
		
		Locator latestquestion=page.locator("//textarea[@formcontrolname='questionTitle']").last();
		latestquestion.scrollIntoViewIfNeeded();
        page.waitForTimeout(2000);
        page.locator("//mat-icon[text()='close']").click();
	}

	
}
