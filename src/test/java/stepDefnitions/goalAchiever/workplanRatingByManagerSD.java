package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class workplanRatingByManagerSD extends BaseClass{

	@Then("gives the ratings {string} to the workplan")
	public void gives_the_ratings_to_the_workplan(String rating) {
	   
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();

		page.locator("#workplan-edit-icon").click();
		
		if (rating.equalsIgnoreCase("1")) {
			page.locator("(//mat-icon[@id='workPlanSupervisorRating'])[1]").click();
		} else if (rating.equalsIgnoreCase("2")) {
			page.locator("(//mat-icon[@id='workPlanSupervisorRating'])[2]").click();

		} 
		else if (rating.equalsIgnoreCase("3")) {
			page.locator("(//mat-icon[@id='workPlanSupervisorRating'])[3]").click();

		}
		else if (rating.equalsIgnoreCase("4")) {
			page.locator("(//mat-icon[@id='workPlanSupervisorRating'])[4]").click();

		}

		else if (rating.equalsIgnoreCase("5")) {
			page.locator("(//mat-icon[@id='workPlanSupervisorRating'])[5]").click();

		}
		
		   page.getByText("Save").click();
			
					Locator confirmmsg3 = page.getByText("Workplan updated succesfully.");
					confirmmsg3.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
					assertTrue("workplan ratings not updated", confirmmsg3.isVisible());
				    page.locator("#workplan-close-btn").click();

	}

}
