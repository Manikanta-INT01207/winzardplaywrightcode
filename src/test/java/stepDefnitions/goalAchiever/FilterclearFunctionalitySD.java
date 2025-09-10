package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class FilterclearFunctionalitySD extends BaseClass {

	String EmpIDemp;
	String customemp;
	
	@Then("admin adds the filters {string} and {string} then {string} later {string}")
	public void admin_adds_the_filters_and_then_later(String category, String subcategory, String EmpIDs, String customEmp) {
		choosefilter("Grade","Grade A");
		addingEmpsThroughIds("CAP-01,CAP-02");
		 EmpIDemp=page.locator("//mat-card//span[@class='title']").last().textContent();
		
		page.waitForTimeout(2000);
		selectCustomEmployee("CAP-37");
		 customemp=page.locator("//mat-card//span[@class='title']").last().textContent();

		
		
	}
	@Then("admin clears the filters")
	public void admin_clears_the_filters() {
	   
		page.locator("//mat-icon[normalize-space(text())='cancel']").click();
		assertTrue("employee not displayed after emps added throuh filters ",page.locator("//mat-card//span[text()='"+customemp+"']").isVisible());
		assertTrue("empID employee not displayed after adding emps through filters  ",page.locator("//mat-card//span[text()='"+EmpIDemp+"']").isVisible());

	}
}
