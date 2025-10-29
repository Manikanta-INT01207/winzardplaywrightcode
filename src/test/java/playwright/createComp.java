package playwright;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class createComp extends BaseClass{

	public static void main(String[] args) {

		String []comps= {"comp-1","comp-2","comp-3"};
		String []compdesc= {"comp desc-1","comp desc-2","comp-desc-3"};
		
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
        page.locator("//button[normalize-space()='+ Start New']").click();
        
        for(int i=0;i<comps.length;i++) {
        page.locator("//button[normalize-space()='+ Add competency']").click();
        page.locator("//textarea[@placeholder='Enter the title']").last().click();
        page.locator("//textarea[@placeholder='Enter the title']").last().fill(comps[i]);
        page.locator("//textarea[@placeholder='Enter the description']").last().click();
        page.locator("//textarea[@placeholder='Enter the description']").last().fill(compdesc[i]);
        }
        page.locator("//button[text()='Save']").click();
      Locator successmessage=page.locator("//p[text()='Comepetencies added succesfully']");
      successmessage.waitFor(new Locator .WaitForOptions().setState(WaitForSelectorState.VISIBLE));
      assertTrue("comptencies not created ", successmessage.isVisible());
	}

}
