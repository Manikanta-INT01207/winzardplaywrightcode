package playwright;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class NegativeWorkplan extends BaseClass {

	public static void main(String[] args) {

		String IFvalue="2";
		
		initializer();
		page.navigate("https://capgemini.winzard.io/");
		page.locator("#user-name").fill("manikantap+1@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.getByText("LOGIN").click();
		page.locator("button[data-toggle='minimize']").click();
		page.getByText("Goal Achiever").click();
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.getByText("+ Create WorkPlan").click();

		page.getByPlaceholder("Enter an title").fill("");
		page.getByPlaceholder("Describe your workplan").fill("desc");
		page.getByPlaceholder("Mention Challenges to achieve").fill("support");
		page.getByPlaceholder("Measurable metric used to Achieve").fill("KPI");
		page.getByPlaceholder("Enter the target / KRA").fill("1000");
		page.locator("input[formcontrolname='startDate']").click();
		selectcalander("28-Nov-2025");
		page.locator("input[formcontrolname='endDate']").click();
		selectcalander("28-Dec-2025");
		
		if (IFvalue.isEmpty()) {
			
		} else {

			page.locator("#workPlanIFactor").click();
			List<ElementHandle>Importancefactordropdown=page.querySelectorAll("//span[@class='mat-option-text']");

			for (ElementHandle IFDD : Importancefactordropdown) {
				System.out.println(IFDD.innerText());
				if(IFDD.innerText().trim().equalsIgnoreCase(IFvalue)) {
					IFDD.click();
					break;

				}
			}

		}
		
		
				page.getByPlaceholder("Enter the achievement").fill("Achievement");
		page.getByText("Save").click();
		page.waitForTimeout(2000);
		Locator savemessage = page.getByText("Workplan added succesfully.");
		
		//savemessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		assertFalse("workplan created without data", savemessage.isVisible());

	}

}
