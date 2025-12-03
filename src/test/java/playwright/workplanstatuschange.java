package playwright;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class workplanstatuschange extends BaseClass {

	public static void main(String[] args) {

      String status="active";
		String rating="4";
		initializer();
		page.navigate("https://capgemini.winzard.io/");
		page.locator("#user-name").fill("manikantap+1@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.getByText("LOGIN").click();
		page.locator("button[data-toggle='minimize']").click();
		page.getByText("Goal Achiever").click();
		
//		page.getByText("Team Goals").click();
//		Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
//		if(!leftpanel.isVisible()) {
//			page.locator("//mat-icon[text()='refresh']").click();
//			leftpanel.waitFor();
//		}
//		page.locator("#emp-search-bar").click();
//		page.locator("#emp-search-bar").fill("CAP-39");
//		page.locator("//div[@class='name']").click();
//
//		Locator table=page.locator("//table[@class='mat-table']");
//		table.waitFor();
//
//		
		
		
		
		
		
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.locator("//mat-icon[text()='delete']").click();
		page.getByText("YES").click();
		
		Locator msg=page.getByText("Workplan Deleted Succesfully!!");
		msg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
		assertTrue("workplan not deleted", msg.isVisible());
		
	//	page.locator("#workplan-status").click();
//		List<ElementHandle>statuslist=page.querySelectorAll("//span[@class='mat-option-text']");
//		for (ElementHandle statuslists : statuslist) {
//			if (statuslists.innerText().equalsIgnoreCase(status)) {
//				statuslists.click();
//				break;
//			}
//		}
		
//		page.locator("//span[normalize-space()='INACTIVE']").click();
//		Locator confirmmessage=page.getByText("Successfully updated");
//		
//		confirmmessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
//		assertTrue("status not changed", confirmmessage.isVisible());
//
//		page.locator("#workplan-status").click();
//		page.locator("//span[normalize-space()='ACTIVE']").click();
//		Locator confirmmessage1=page.getByText("Successfully updated");
//		
//		confirmmessage1.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
//		assertTrue("status not changed", confirmmessage1.isVisible());
//		
//		page.locator("#workplan-status").click();
//		page.locator("//span[normalize-space()='COMPLETED']").click();
//		Locator confirmmessage2=page.getByText("Successfully updated");
//		
//		confirmmessage2.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
//		assertTrue("status not changed", confirmmessage2.isVisible());
//		page.waitForTimeout(2000);
	//	page.locator("#workplan-edit-icon").click();
	
	/*	if (rating.equalsIgnoreCase("1")) {
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
*/
		
	}

}
