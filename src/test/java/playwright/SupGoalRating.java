package playwright;

import java.util.List;
import java.util.Random;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class SupGoalRating extends BaseClass{

	public static void main(String[] args) {
		
		String empcode="CAP-01";
		
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.waitForTimeout(1000);
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.locator("//span[normalize-space()='Team Goals']").click();
		Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
		if(!leftpanel.isVisible()) {
			page.locator("//mat-icon[text()='refresh']").click();
			leftpanel.waitFor();
		}
		page.locator("#emp-search-bar").click();
		page.locator("#emp-search-bar").fill(empcode);
		page.locator("//div[@class='name']").click();
		
		Locator table=page.locator("//table[@class='mat-table']");
		 table.waitFor();
//		 page.locator("//span[normalize-space(text()) = 'Filter by']").click();
//			page.locator("//span[normalize-space(text())='Sub Goals Pending']").click();
//			page.locator("//mat-select[@aria-label='Items per page:']").click();
//			page.locator("//span[text()='100']").click();
//			table.waitFor();
		//	page.locator("(//mat-icon[@id='edit-goal-btn'])[1]").click();

		
		List<ElementHandle> goals=page.querySelectorAll("//mat-icon[contains(@class,'edit-icon')]");
		System.out.println(goals.size());
		for (int i=0;i<goals.size();i++) {
			//goals.get(i).click();
			page.locator("(//mat-icon[@id='edit-goal-btn'])["+(i+1)+"]").click();
		
		List<ElementHandle> subgoalsdata=page.querySelectorAll("//textarea[contains(@class,'valid') and contains(@formcontrolname,'supervisorAchievement')]");
		for (ElementHandle subgoals : subgoalsdata) {
			subgoals.fill("220");
			List<ElementHandle> ratingboxes =page.querySelectorAll("//div[@class='col-md-6 ng-tns-c26-16 ng-star-inserted']");
			for (ElementHandle ratingbox : ratingboxes) {
				List<ElementHandle> ratingss=ratingbox.querySelectorAll("//mat-icon[contains(@class,'active') and contains(@id,'supervisor-rating')]");
				List<ElementHandle>ratings1=ratingbox.querySelectorAll("//div[@class='empty-ratings']");
				//System.out.println(ratingss.size());
				if(ratingss.isEmpty()&&ratings1.isEmpty()) {
					List<ElementHandle> targetratingss=ratingbox.querySelectorAll("//mat-icon");
					Random num=new Random();
					int randrating=num.nextInt(targetratingss.size());
					ElementHandle chooserating=targetratingss.get(randrating);
					chooserating.click();
					
					break;
				}
			}
		}
		page.locator("//span[text()='Save']").click();
		ElementHandle successmessage=page.waitForSelector("//p[text()='Goals Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		if(successmessage.isVisible()) {
			System.out.println("successfully given the data");
		}
		else {
			System.out.println("data is not given please check the code");
		}
		ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

		page.locator("//mat-icon[text()='close']").click();
		}

		
	}

}
