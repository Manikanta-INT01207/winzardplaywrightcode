package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertFalse;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class NegativeCreateWorkplanSD extends BaseClass {

	@Then("employee misses to give the any of these workplan details of {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} and {string} then saves the workplan")
	public void employee_misses_to_give_the_any_of_these_workplan_details_of_and_then_saves_the_workplan(String title, String description, String challengesAndSupport, String KPI, String target, String startdate, String enddate, String importanceFactor, String achievement) {

		page.getByPlaceholder("Enter an title").fill(title);
		page.getByPlaceholder("Describe your workplan").fill(description);
		page.getByPlaceholder("Mention Challenges to achieve").fill(challengesAndSupport);
		page.getByPlaceholder("Measurable metric used to Achieve").fill(KPI);
		page.getByPlaceholder("Enter the target / KRA").fill(target);

		if (startdate.isEmpty()) {

		} else {
			page.locator("input[formcontrolname='startDate']").click();
			negativecalendar(startdate);
		}

		if (enddate.isEmpty()||startdate.isEmpty()||page.locator("(//mat-form-field[contains(@class,'disable-click') and not(contains(@class,'custom-input'))])").isVisible()) {

		} else {
			page.locator("input[formcontrolname='endDate']").click();
			negativecalendar(enddate);
		}


		if (importanceFactor.isEmpty()) {

		} else {

			page.locator("#workPlanIFactor").click();
			List<ElementHandle>Importancefactordropdown=page.querySelectorAll("//span[@class='mat-option-text']");

			for (ElementHandle IFDD : Importancefactordropdown) {
				System.out.println(IFDD.innerText());
				if(IFDD.innerText().trim().equalsIgnoreCase(importanceFactor)) {
					IFDD.click();
					break;

				}
			}

		}


		page.getByPlaceholder("Enter the achievement").fill(achievement);
		page.getByText("Save").click();
		page.waitForTimeout(2000);
		Locator savemessage = page.getByText("Workplan added succesfully.");

		//savemessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		assertFalse("workplan created without data", savemessage.isVisible());



	}





}
