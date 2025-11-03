package playwright;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class editcompetencies  extends BaseClass{

	public static void main(String[] args) {

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
        page.locator("//div[text()='Create Competencies / Skills / Potential ']").click();
        
        String compname="dum";
        String comptitle="dummy";
        String compdesc="dum";
        page.locator("//span[text()='"+compname+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();
        page.locator("//input[@formcontrolname='competencyName']").last().fill(comptitle);
        page.locator("//textarea[@placeholder='Enter the description']").last().fill(compdesc);
        page.locator("//button[text()='Update']").click();
        
        Locator successmessage=page.locator("//p[text()='Competency updated succesfully']");
        successmessage.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
        assertTrue("competencies not updated",successmessage.isVisible());
        page.locator("//span[text()='Ok']").click();
        page.locator("//span[text()='"+comptitle+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();

		
	}

}
