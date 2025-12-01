package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class createworkplanSD extends BaseClass {

	@Then("employee selects a goal to create workplan and clicks on create workplan")
	public void employee_selects_a_goal_to_create_workplan_and_clicks_on_create_workplan() {
	   
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.getByText("+ Create WorkPlan").click();
	}
	@Then("employee add the workplan details of {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} and {string}")
	public void employee_add_the_workplan_details_of_and(String title, String description, String challengesAndSupport, String KPI, String target, String startdate, String enddate, String importanceFactor, String achievement) {
		page.getByPlaceholder("Enter an title").fill(title);
		page.getByPlaceholder("Describe your workplan").fill(description);
		page.getByPlaceholder("Mention Challenges to achieve").fill(challengesAndSupport);
		page.getByPlaceholder("Measurable metric used to Achieve").fill(KPI);
		page.getByPlaceholder("Enter the target / KRA").fill(target);
		page.locator("input[formcontrolname='startDate']").click();
		selectcalander("28-Nov-2025");
		page.locator("input[formcontrolname='endDate']").click();
		selectcalander("28-Dec-2025");
       page.locator("#workPlanIFactor").click();
       List<ElementHandle>Importancefactordropdown=page.querySelectorAll("//span[@class='mat-option-text']");
       
       for (ElementHandle IFDD : Importancefactordropdown) {
    	   System.out.println(IFDD.innerText());
		if(IFDD.innerText().trim().equalsIgnoreCase(importanceFactor)) {
		IFDD.click();
		break;

		}
	}
   page.getByPlaceholder("Enter the achievement").fill(achievement);
   page.getByText("Save").click();
   Locator savemessage = page.getByText("Workplan added succesfully.");
   savemessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
    assertTrue("workplan not created", savemessage.isVisible());

		
	}
	
	@Then("employee adds the comment and delete the comment to verify the functionality")
	public void employee_adds_the_comment_and_delete_the_comment_to_verify_the_functionality() {
	
		page.locator("#workplan-edit-icon").click();
		page.locator("#commentCreation").click();
		page.locator("(//mat-icon[text()='delete'])[1]").click();
		page.locator("//span[normalize-space()='Yes']").click();
		
		Locator msg=page.getByText("Comment Deleted Succesfully!!");
		msg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
		assertTrue("Comment not deleted check the message in UI", msg.isVisible());

	}
	@Then("employee adds another {string}")
	public void employee_adds_another(String comment) {
		page.locator("#commentCreation").click();
        page.locator("#comment-text-0").fill(comment);
		page.getByText("Save").click();
		
		Locator confirmmsg = page.getByText("Workplan updated succesfully.");
		confirmmsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		assertTrue("workplan not created", confirmmsg.isVisible());

	    page.locator("#workplan-close-btn").click();

	
	}
}
