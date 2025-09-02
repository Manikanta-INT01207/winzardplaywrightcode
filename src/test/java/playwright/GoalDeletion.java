package playwright;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class GoalDeletion extends BaseClass{

	public static void main(String[] args) {

		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		//page.locator("//span[normalize-space()='Team Goals']").click();
		page.locator("//span[normalize-space()='Bulk Goals']").click();
//		Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
//		if(!leftpanel.isVisible()) {
//			page.locator("//mat-icon[text()='refresh']").click();
//			leftpanel.waitFor();
//		}
//		page.locator("#emp-search-bar").click();
//		page.locator("#emp-search-bar").fill("CAP-02");
//		page.locator("//div[@class='name']").click();
		page.locator("//span[normalize-space()='Bulk']").click();
		Locator goaltable=page.locator("//table[contains(@class,'mat-table')]");
		goaltable.waitFor();
		Locator goals=page.locator("(//mat-icon[text()='delete'])[1]");
		while (goals.isVisible()) {
			page.locator("(//mat-icon[text()='delete'])[1]").click();
			page.locator("//span[text()='Yes']").click();
			Locator message=page.locator("//p[text()='Bulk Goal Deleted Succesfully!!']");
			message.waitFor();
			if(message.isVisible()) {
				System.out.println(message.innerText());
				message.waitFor(new Locator.WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

			}
			else {
				System.out.println("goal not deleted");
			}
		}
	
	}

}
