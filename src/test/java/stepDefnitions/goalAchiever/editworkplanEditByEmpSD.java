package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class editworkplanEditByEmpSD extends BaseClass{

	@Then("employee selects a goal to update workplan and clicks on update icon")
	public void employee_selects_a_goal_to_update_workplan_and_clicks_on_update_icon() {

		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.locator("#workplan-edit-icon").click();
	}
	@Then("employee updates  the workplan details of {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} and {string}")
	public void employee_updates_the_workplan_details_of_and(String title, String description, String challengesAndSupport, String KPI, String target, String startdate, String enddate, String importanceFactor, String achievement) {

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



	}
	@Then("employee updates the {string} and ticks the supervisor intervention checkbox")
	public void employee_updates_the_and_ticks_the_supervisor_intervention_checkbox(String comment) {
		page.locator("#comment-text-0").fill(comment);
		page.locator("(//div[@class='mat-checkbox-inner-container'])[1]").click();
		page.getByText("Save").click();

		Locator confirmmsg = page.getByText("Workplan updated succesfully.");
		confirmmsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		assertTrue("workplan not created", confirmmsg.isVisible());

		page.locator("#workplan-close-btn").click();

	}

}
