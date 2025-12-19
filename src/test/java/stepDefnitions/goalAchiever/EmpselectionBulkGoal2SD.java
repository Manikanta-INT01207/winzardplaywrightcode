package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class EmpselectionBulkGoal2SD extends BaseClass {


@Then("admins checks the selection functionality by adding {string}  then {string}  later filters {string} and {string}")
public void admins_checks_the_selection_functionality_by_adding_then_later_filters_and(String customemp, String empIDs, String category, String subcategory) {

	selectCustomEmployee(customemp);
	Locator employee=page.locator("//mat-card[@class='custom-card mat-card ng-star-inserted']");
	Assert.assertTrue("employee selection mismatched after adding the custom employee",employee.last().isVisible());

	String customemp1=page.locator("//mat-card//span[@class='title']").textContent();
	System.out.println(customemp1);
	System.out.println("//mat-card//span[text()='"+customemp1+"']");
	assertTrue("employee not displayed after added throuh custom emp",page.locator("//mat-card//span[text()='"+customemp1+"']").isVisible());
	
	addingEmpsThroughIds(empIDs);
	page.waitForTimeout(3000);
	List<ElementHandle>secondcount=page.querySelectorAll("//mat-card//span[@class='title']");
	String EmpIDemp=page.locator("//mat-card//span[@class='title']").last().textContent();
	System.out.println("2nd count emps "+EmpIDemp);
	for (ElementHandle scndcount : secondcount) {
		System.out.println(scndcount.innerText());

	}
	assertTrue("empID employee not displayed after adding through EmpID bar ",page.locator("//mat-card//span[text()='"+EmpIDemp+"']").isVisible());

	assertTrue("employee not displayed after emps added throuh EmpID bar ",page.locator("//mat-card//span[text()='"+customemp1+"']").isVisible());


//	Assert.assertTrue("employee selection mismatched after adding the employee through ID's",secondcount.size()>firstcount.size());

	choosefilter(category,subcategory);
	page.waitForTimeout(5000);
	List<ElementHandle>thirdcount=page.querySelectorAll("//mat-card//span[@class='title']");
	for (ElementHandle thrdcount : thirdcount) {
		
		assertTrue("empID employee not displayed",thrdcount.isVisible());
		System.out.println(thrdcount.innerText());
	}
	
	page.waitForTimeout(3000);
	assertTrue("empID employee not displayed after adding emps through filters  ",page.locator("//mat-card//span[contains(text(),'"+EmpIDemp+"')]").isVisible());

	assertTrue("employee not displayed after emps added throuh filters ",page.locator("//mat-card//span[contains(text(),'"+customemp+"')]").isVisible());

	
	
}
	
}
