package playwright;
import java.util.List;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class ViewportSizeExample extends BaseClass{
	public static void main(String[] args) {

		initializer();
		page.navigate("https://capgemini.winzard.io");
		page.locator("//input[@formcontrolname='username']").fill("anirudha@interbiz.in");

		// Step 7: Fill in the password
		page.locator("//input[@formcontrolname='password']").fill("Winzard@2024");

		// Step 8: Click the login button
		page.locator("//span[@class='mat-button-wrapper']").click();
		page.locator("//mat-icon[text()='menu']").click();
        
		Locator engagement = page.locator("//span[text()='Workforce Wellbeing']");

        // Step 12: Scroll to the menu item to make sure it's visible
        engagement.scrollIntoViewIfNeeded(); 

        // Step 13: Click the "Workforce Engagement" option
        engagement.click();
       
        page.locator("//span[text()='Org']").click();
        page.waitForTimeout(3000);
        page.locator("//button[text()='+ Start New']").click();
        page.waitForTimeout(2000);
        selectCustomEmployee("CAP-37");
        choosefilter("Grade", "GRADE A");
        
        page.locator("//button[text()='Next']").click();
        page.locator("//input[@formcontrolname='startDate']").click();
       selectcalander("24-JUL-2025");
       page.locator("//input[@formcontrolname='endDate']").click();
       selectcalander("30-AUG-2025");
       page.locator("//span[text()='Add Custom Questions ']").click();
       page.locator("//button[text()=' Next']").click();
       addcustomQuestions(3, "free text,rating,Subquestions", 4, "sub-1,sub-2,sub-3,sub-4");
//       
//        ElementHandle active = page.waitForSelector("xpath=//span[text()='ACTIVE']",new Page.WaitForSelectorOptions().setTimeout(240_000).setState(WaitForSelectorState.VISIBLE));
//		List<ElementHandle> Activerows=page.querySelectorAll("//tr[@ng-reflect-klass='row-ACTIVE']");
//        String beforeemployeeCount="4";
//		boolean survey=false;
//		Outer:
//			for (ElementHandle activerow : Activerows) {
//				List<ElementHandle> activecolumns=activerow.querySelectorAll("td");
//				for (ElementHandle activecol : activecolumns) {
//					List<ElementHandle> span=activecol.querySelectorAll("//span[@class='due-cell']");
//					for (ElementHandle spans : span) {
//						if(beforeemployeeCount.contains(spans.innerText())) {
//							System.out.println(spans.innerText());
//							System.out.println("survey created successfully ");
//							survey=true;
//							break Outer;
//
//						}
//					}
//				}
//			}
//		if(!survey) {
//			System.out.println("Survey created successfully but employee count is mismatched");
//		}
//
	}
       
	}
