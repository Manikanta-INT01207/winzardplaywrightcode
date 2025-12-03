package playwright;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertTrue;

import base.BaseClass;

public class managerworkplan extends BaseClass{

	public static void main(String[] args) {

		String empcode="CAP-39";
		initializer();
		page.navigate("https://capgemini.winzard.io/");
		page.locator("#user-name").fill("sneha@winzard.io");
		page.locator("#password").fill("Winzard@2024");
		page.getByText("LOGIN").click();
		page.locator("button[data-toggle='minimize']").click();
		page.getByText("Goal Achiever").click();
		page.getByText("Team Goals").click();
		Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
		if(!leftpanel.isVisible()) {
			page.locator("//mat-icon[text()='refresh']").click();
			leftpanel.waitFor();
		}
		page.locator("#emp-search-bar").click();
		page.locator("#emp-search-bar").fill(empcode);
		page.locator("//div[@class='name']").click();

		Locator table=page.locator("//table[@class='mat-table']");
		table.waitFor();
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.locator("#workplan-edit-icon").click();
        page.locator("#workPlancomments").fill("mngr ovrl cmnt");
        page.locator("#commentSupervisorDescription").fill("suprvsr commnt");
        page.getByText("Save").click();
		
		Locator confirmmsg = page.getByText("Workplan updated succesfully.");
		confirmmsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		assertTrue("workplan not created", confirmmsg.isVisible());

	    page.locator("#workplan-close-btn").click();
	    
		page.locator("#workplan-edit-icon").click();
		 page.locator("#workPlancomments").fill("upadated mngr ovrl cmnt-1");
	        page.locator("#commentSupervisorDescription").fill("upadted suprvsr commnt-1");
	        page.getByText("Save").click();
			
			Locator confirmmsg2 = page.getByText("Workplan updated succesfully.");
			confirmmsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
			assertTrue("workplan not created", confirmmsg2.isVisible());

		    page.locator("#workplan-close-btn").click();

	    
		
	}

}
