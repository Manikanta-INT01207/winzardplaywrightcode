package playwright;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class goalResubmit extends BaseClass {

	public static void main(String[] args) {
        
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		ElementHandle table=page.waitForSelector("//table[@class='mat-table']", new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
//		List<ElementHandle> pendingGoalss=page.querySelectorAll("//tr[contains(@class,'REJECTED ')]");
//		System.out.println(pendingGoalss.size());
//		for (ElementHandle pendinggoal : pendingGoalss) {
//			List<ElementHandle>pendinggoaledit=pendinggoal.querySelectorAll("//td//mat-icon[@id='edit-goal-btn']");
//			for (ElementHandle pendingedit : pendinggoaledit) {
//			    pendingedit.click();
//			    page.locator("//span[text()='Save']").click();
//			    page.waitForTimeout(3000);
//			    page.locator("//mat-icon[text()='close']").click();
//			    break;
//			}
//			
//		}
		Locator rejectedrows=page.locator("//tr[contains(@class,'REJECTED')]//mat-icon[@id='edit-goal-btn']");
		System.out.println(rejectedrows.count());
		while(rejectedrows.count()>0) {
		rejectedrows.first().click();
		//	page.locator("//tr[contains(@class,'REJECTED')]//mat-icon[@id='edit-goal-btn']").click();
			 page.locator("//span[text()='Save']").click();
			    page.waitForTimeout(3000);
			    page.locator("//mat-icon[text()='close']").click();
		}
	}

}
