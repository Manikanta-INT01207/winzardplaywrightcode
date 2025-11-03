package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class editcompetenciesSD extends BaseClass{


@Then("admin opens the existing  {string}")
public void admin_opens_the_existing(String competency) {
   
    page.locator("//div[text()='Create Competencies / Skills / Potential ']").click();
    String compname=competency;
    page.locator("//span[text()='"+compname+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();

}
@Then("admin changes the {string} , {string} in it then saves the comptency")
public void admin_changes_the_in_it_then_saves_the_comptency(String comptencyTitle, String description) {
   
	 page.locator("//input[@formcontrolname='competencyName']").last().fill(comptencyTitle);
     page.locator("//textarea[@placeholder='Enter the description']").last().fill(description);
     page.locator("//button[text()='Update']").click();
    
}
@Then("admin admin opens the edited comptency {string} to make sure changes are reflected or not")
public void admin_admin_opens_the_edited_comptency_to_make_sure_changes_are_reflected_or_not(String comptencyTitle) {
	 Locator successmessage=page.locator("//p[text()='Competency updated succesfully']");
     successmessage.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
     assertTrue("competencies not updated",successmessage.isVisible());
     page.locator("//span[text()='Ok']").click();
     page.locator("//span[text()='"+comptencyTitle+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();
     page.waitForTimeout(2000);

	
}

}
