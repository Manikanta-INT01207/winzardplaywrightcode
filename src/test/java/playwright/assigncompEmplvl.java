package playwright;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class assigncompEmplvl extends BaseClass{

	public static void main(String[] args) {
		String comptitle="dummycomp";
		String[] comps= {"creativity","collaboration","Learning agility","delegation","descison making"};
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//mat-icon[normalize-space(text())='menu']").click();
		Locator pms=page.locator("//span[text()='Performance Management']");
		pms.scrollIntoViewIfNeeded();
		pms.click();
        page.locator("//a[normalize-space(text())='Global Configuration']").click();
        page.locator("//div[text()='Assign Competencies / Skills / Potential']").click();
        page.locator("//mat-select[@placeholder='Select type']").click();
        page.locator("//span[text()='Employee ']").click();
        page.locator("//button[text()=' + Start New']").click();
        
        page.waitForTimeout(2000);
        
        selectCustomEmployee("CAP-37");
        addingEmpsThroughIds("CAP-05");
        choosefilter("Grade","Grade A");
	
        page.locator("//input[@formcontrolname='competencyTitle']").fill(comptitle);
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
