package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class workplanStatusChangeAndRatingByEmployeeSD extends BaseClass{

	@Then("employees checks the status fucntionality then move it complete later gives the self rating {string}")
	public void employees_checks_the_status_fucntionality_then_move_it_complete_later_gives_the_self_rating(String rating) {
	    
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.locator("#workplan-status").click();
		page.locator("//span[normalize-space()='INACTIVE']").click();
		Locator confirmmessage=page.getByText("Successfully updated");
		
		confirmmessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
		assertTrue("status not changed", confirmmessage.isVisible());

		page.locator("#workplan-status").click();
		page.locator("//span[normalize-space()='ACTIVE']").click();
		Locator confirmmessage1=page.getByText("Successfully updated");
		
		confirmmessage1.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
		assertTrue("status not changed", confirmmessage1.isVisible());
		
		page.locator("#workplan-status").click();
		page.locator("//span[normalize-space()='COMPLETED']").click();
		Locator confirmmessage2=page.getByText("Successfully updated");
		
		confirmmessage2.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
		assertTrue("status not changed", confirmmessage2.isVisible());
		page.waitForTimeout(2000);
		page.locator("#workplan-edit-icon").click();
		
		if (rating.equalsIgnoreCase("1")) {
			page.locator("(//mat-icon[@id='content'])[1]").click();
		} else if (rating.equalsIgnoreCase("2")) {
			page.locator("(//mat-icon[@id='content'])[2]").click();

		} 
		else if (rating.equalsIgnoreCase("3")) {
			page.locator("(//mat-icon[@id='content'])[3]").click();

		}
		else if (rating.equalsIgnoreCase("4")) {
			page.locator("(//mat-icon[@id='content'])[4]").click();

		}

		else if (rating.equalsIgnoreCase("5")) {
			page.locator("(//mat-icon[@id='content'])[5]").click();

		}
		
		   page.getByText("Save").click();
			
					Locator confirmmsg3 = page.getByText("Workplan updated succesfully.");
					confirmmsg3.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
					assertTrue("workplan ratings not updated", confirmmsg3.isVisible());
				    page.locator("#workplan-close-btn").click();

	}

	
}
