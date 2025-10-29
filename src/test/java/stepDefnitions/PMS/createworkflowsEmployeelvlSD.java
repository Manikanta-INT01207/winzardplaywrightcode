package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class createworkflowsEmployeelvlSD extends BaseClass{


	@Then("admin goes to the create workflows and assign forms tab then selects the employee condition")
	public void admin_goes_to_the_create_workflows_and_assign_forms_tab_then_selects_the_employee_condition() {

		page.locator("//a[normalize-space(text())='Global Configuration']").click();
		page.locator("//div[text()='Create Workflows & Assign Forms']").click();
		page.locator("//mat-select[@placeholder='Select type']").click();
		page.locator("//span[text()='Employee ']").click();
	}
	@Then("admins adds the employees through filters {string} and {string} or {string} or {string}")
	public void admins_adds_the_employees_through_filters_and_or_or(String department, String subdepartment, String customemp, String empID) {

		if(empID.isBlank()) {
			System.out.println("no empid is assigned");
		}
		else {
			addingEmpsThroughIds(empID);
		}


		if(customemp.isBlank()) {
			System.out.println("no custemp is assigned");
		}
		else {
			selectCustomEmployee(customemp);

		}

		if (department.isBlank()&&subdepartment.isBlank()) {

		} else {
			choosefilter(department, subdepartment);
		}

		page.waitForTimeout(2000);

		page.locator("//button[text()='Create']").click();

		Locator successmessage=page.locator("//p[text()='Workflow created']");
		successmessage.waitFor(new Locator .WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertTrue("workflow not created ", successmessage.isVisible());


	}

}
