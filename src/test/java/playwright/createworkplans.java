package playwright;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class createworkplans extends BaseClass{

	public static void main(String[] args) {

		String IFvalue="3";

		initializer();
		page.navigate("https://capgemini.winzard.io/");
		page.locator("#user-name").fill("manikantap+1@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.getByText("LOGIN").click();
		page.locator("button[data-toggle='minimize']").click();
		page.getByText("Goal Achiever").click();
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.getByText("+ Create WorkPlan").click();
		//	page.locator("#workplan-edit-icon").click();
		page.getByPlaceholder("Enter an title").fill("workplan");
		page.getByPlaceholder("Describe your workplan").fill("desc");
		page.getByPlaceholder("Mention Challenges to achieve").fill("support");
		page.getByPlaceholder("Measurable metric used to Achieve").fill("KPI");
		page.getByPlaceholder("Enter the target / KRA").fill("1000");
		page.locator("input[formcontrolname='startDate']").click();
		selectcalander("28-Nov-2025");
		page.locator("input[formcontrolname='endDate']").click();
		selectcalander("28-Dec-2025");
		page.locator("#workPlanIFactor").click();
		List<ElementHandle>Importancefactordropdown=page.querySelectorAll("//span[@class='mat-option-text']");

		for (ElementHandle IFDD : Importancefactordropdown) {
			System.out.println(IFDD.innerText());
			if(IFDD.innerText().trim().equalsIgnoreCase(IFvalue)) {
				IFDD.click();
				break;

			}
		}
		page.getByPlaceholder("Enter the achievement").fill("Achievement");
		page.getByText("Save").click();
		Locator savemessage = page.getByText("Workplan added succesfully.");
		savemessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		assertTrue("workplan not created", savemessage.isVisible());

			page.locator("#workplan-edit-icon").click();
			page.locator("#commentCreation").click();
			page.locator("(//mat-icon[text()='delete'])[1]").click();
			page.locator("//span[normalize-space()='Yes']").click();
			
			Locator msg=page.getByText("Comment Deleted Succesfully!!");
			msg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
			assertTrue("Comment not deleted check the message in UI", msg.isVisible());

			page.locator("#commentCreation").click();
            page.locator("#comment-text-0").fill("emp comment");
    		page.getByText("Save").click();
    		
    		Locator confirmmsg = page.getByText("Workplan updated succesfully.");
    		confirmmsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
    		assertTrue("workplan not created", confirmmsg.isVisible());

		    page.locator("#workplan-close-btn").click();



	}
}
