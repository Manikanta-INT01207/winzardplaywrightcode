package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class AssignCompEmpLevel extends BaseClass{


@Then("admin selects the employee level to assign competencies")
public void admin_selects_the_employee_level_to_assign_competencies() {
    
	page.locator("//div[text()='Assign Competencies / Skills / Potential']").click();
    page.locator("//mat-select[@placeholder='Select type']").click();
    page.locator("//span[text()='Employee ']").click();
    page.locator("//button[text()=' + Start New']").click();
    
	
}
	
@Then("admin adds the employees through {string} , {string}, filters {string} ,{string} then adds the {string} and {string}")
public void admin_adds_the_employees_through_filters_then_adds_the_and(String customemployee, String EmpiID, String category, String subcategory, String title, String competencies) {
   
	String [] comps =competencies.split(",");
	page.waitForTimeout(2000);
    
//    selectCustomEmployee(customemployee);
//    addingEmpsThroughIds(EmpiID);
//    choosefilter(category,subcategory);
    
    
    if(EmpiID.isBlank()) {
		System.out.println("no empid is assigned");
	}
	else {
		addingEmpsThroughIds(EmpiID);
	}


	if(customemployee.isBlank()) {
		System.out.println("no custemp is assigned");
	}
	else {
		selectCustomEmployee(customemployee);

	}

	if (category.isBlank()&&subcategory.isBlank()) {

	} else {
		choosefilter(category,subcategory);
	}

    

    page.locator("//input[@formcontrolname='competencyTitle']").fill(title);
    page.locator("(//mat-select[@role='listbox'])[2]").click();
    
    List<ElementHandle> checkboxess=page.querySelectorAll("//span[@class='mat-option-text']");
    for (ElementHandle checkbox : checkboxess) {
    	for(int i =0;i<comps.length;i++) {
    		
    		if(checkbox.innerText().equalsIgnoreCase(comps[i])) {
    			checkbox.click();
    		}
    		
    		
    	}
    	
		
	}
    page.keyboard().press("Escape");
    page.locator("//button[text()='Create']").click();
    Locator successmessage=page.locator("//p[text()='Competencies assigned successfully']");
    successmessage.waitFor(new Locator .WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    assertTrue("assign comptencies not working ", successmessage.isVisible());

}
}
