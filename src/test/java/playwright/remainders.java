package playwright;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.ElementHandle.ScrollIntoViewIfNeededOptions;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;

import base.BaseClass;

public class remainders extends BaseClass{

	public static void main(String[] args) {
		
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("//span[@class='mat-button-wrapper']").click();
		page.locator("//mat-icon[text()='menu']").click();
		Locator wellbeing=page.locator("//span[text()='Workforce Wellbeing']");
		wellbeing.scrollIntoViewIfNeeded();
		wellbeing.click();
		page.locator("//span[text()='Org']").click();
		ElementHandle header= page.waitForSelector("//tr[@class='mat-header-row ng-star-inserted']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
       List<ElementHandle> activerow=page.querySelectorAll("//tr[contains(@class,'ACTIVE ')]");
       System.out.println(activerow.size());
       ElementHandle remainder1 =  activerow.get(0);
       ElementHandle statusActive = remainder1.querySelector("//span[text()='ACTIVE']");
       statusActive.click();
      page.locator("//span[text()=' COMPLETED ']").click();
       
//       ElementHandle remainder=remainder1.querySelector("//mat-icon[text()=' notifications_none ']"); 
//       remainder.click();
//       page.locator("//span[text()='Send']").click();
//       
//      Locator successmessage=page.locator("//p[text()='Survey reminder sent successfully']");
//      try {
//		
//    	  successmessage.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
//    	  if(successmessage.isVisible()) {
//    		  System.out.println("Remainder sent successfully");
//    	  }
//    	  else {
//    		  System.out.println("remainder not seent please cross check");
//    	  }
//	} catch (Exception e) {
//		System.out.println("Error"+ e.getMessage());
//	}
       
	}
	
}
