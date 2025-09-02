package playwright;


import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class goalStatus extends BaseClass{

	public static void main(String[] args) {
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.locator("//span[text()='Team Goals ']").click();
		String selection = "Employee-Wise";
		String approvaltype="one by one";
		String empcode="CAP-01";
		String status="reject";
		

		if (selection.equalsIgnoreCase("Employee-wise")) {
			Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
			if(!leftpanel.isVisible()) {
				page.locator("//mat-icon[text()='refresh']").click();
				leftpanel.waitFor();
			}
			

			if(approvaltype.equalsIgnoreCase("one by one")) {
				page.locator("#emp-search-bar").click();
				page.locator("#emp-search-bar").fill(empcode);
				page.locator("//div[@class='name']").click();
				page.locator("//span[normalize-space(text()) = 'Filter by']").click();
				page.locator("//span[normalize-space(text())='Approvals']").click();
				page.locator("//mat-select[@aria-label='Items per page:']").click();
				page.locator("//span[text()='100']").click();
				Locator approvallists=page.locator("//div[@class='s-APPROVAL_PENDING']");
				while(approvallists.count()>0) {
					approvallists.first().click();

					//page.locator("//span[normalize-space(text())='Approved']").click();


					if(status.equalsIgnoreCase("Approve")) {
						page.locator("//span[normalize-space(text())='Approved']").click();
						ElementHandle successmessage=page.waitForSelector("//p[text()='Goal Status Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
						if(successmessage.isVisible()) {
							System.out.println(successmessage.innerText());
						}
						else {
							System.out.println("goal not approved");
						}
						ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

					}
					else if (status.equalsIgnoreCase("reject")) {
						page.locator("//span[normalize-space(text())='Rejected']").click();
						ElementHandle successmessage=page.waitForSelector("//p[text()='Goal Status Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
						if(successmessage.isVisible()) {
							System.out.println(successmessage.innerText());
						}
						else {
							System.out.println("goal not approved");
						}
						ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

					}




					//			ElementHandle successmessage=page.waitForSelector("//p[text()='Goal Status Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
					//			if(successmessage.isVisible()) {
					//				System.out.println("goal approved");
					//			}
					//			else {
					//				System.out.println("goal not approved");
					//			}
					//			ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

				}

			}
			else if (approvaltype.equalsIgnoreCase("bulk")) {
				
				page.locator("#emp-search-bar").click();
				page.locator("#emp-search-bar").fill(empcode);
				page.locator("//div[@class='name']").click();
				page.locator("//span[normalize-space(text()) = 'Filter by']").click();
				page.locator("//span[normalize-space(text())='Approvals']").click();
				page.locator("//mat-select[@aria-label='Items per page:']").click();
				page.locator("//span[text()='100']").click();
				page.locator("#mat-checkbox-1").click();
				if(status.equalsIgnoreCase("Approve")) {
					page.locator("//span[normalize-space(text())='Approve']").click();
					ElementHandle successmessage=page.waitForSelector("//p[text()='Goal has been approved successfully.']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
					if(successmessage.isVisible()) {
						System.out.println(successmessage.innerText());
					}
					else {
						System.out.println("goal not approved");
					}

				}
				else if (status.equalsIgnoreCase("reject")) {
					page.locator("//span[normalize-space(text())='Reject']").click();
					ElementHandle successmessage=page.waitForSelector("//p[text()='Goal has been rejected successfully.']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
					if(successmessage.isVisible()) {
						System.out.println(successmessage.innerText());
					}
					else {
						System.out.println("goal not approved");
					}

				}
			}
		}
		else if(selection.equalsIgnoreCase("Grid view")){
			page.locator("//mat-icon[text()='group']").click();
			Locator header= page.locator("//tr[contains(@class,'header-row')]");
			header.waitFor();
			if(approvaltype.equalsIgnoreCase("one by one")) {
//				page.locator("#emp-search-bar").click();
//				page.locator("#emp-search-bar").fill(empcode);
//				page.locator("//div[@class='name']").click();
				page.locator("//span[normalize-space(text()) = 'Filter by']").click();
				page.locator("//span[normalize-space(text())='Approvals']").click();
				page.locator("//mat-select[@aria-label='Items per page:']").click();
				page.locator("//span[text()='100']").click();
				Locator approvallists=page.locator("//div[@class='s-APPROVAL_PENDING']");
				while(approvallists.count()>0) {
					approvallists.first().click();

					//page.locator("//span[normalize-space(text())='Approved']").click();


					if(status.equalsIgnoreCase("Approve")) {
						page.locator("//span[normalize-space(text())='Approved']").click();
						ElementHandle successmessage=page.waitForSelector("//p[text()='Goal Status Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
						if(successmessage.isVisible()) {
							System.out.println(successmessage.innerText());
						}
						else {
							System.out.println("goal not approved");
						}
						ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

					}
					else if (status.equalsIgnoreCase("reject")) {
						page.locator("//span[normalize-space(text())='Rejected']").click();
						ElementHandle successmessage=page.waitForSelector("//p[text()='Goal Status Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
						if(successmessage.isVisible()) {
							System.out.println(successmessage.innerText());
						}
						else {
							System.out.println("goal not approved");
						}
						ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

					}




					//			ElementHandle successmessage=page.waitForSelector("//p[text()='Goal Status Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
					//			if(successmessage.isVisible()) {
					//				System.out.println("goal approved");
					//			}
					//			else {
					//				System.out.println("goal not approved");
					//			}
					//			ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

				}

			}
			else if (approvaltype.equalsIgnoreCase("bulk")) {
				
				page.locator("//span[normalize-space(text()) = 'Filter by']").click();
				page.locator("//span[normalize-space(text())='Approvals']").click();
				page.locator("//mat-select[@aria-label='Items per page:']").click();
				page.locator("//span[text()='100']").click();
				page.locator("#mat-checkbox-1").click();
				if(status.equalsIgnoreCase("Approve")) {
					page.locator("//span[normalize-space(text())='Approve']").click();
					ElementHandle successmessage=page.waitForSelector("//p[text()='Goal has been approved successfully.']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
					if(successmessage.isVisible()) {
						System.out.println(successmessage.innerText());
					}
					else {
						System.out.println("goal not approved");
					}

				}
				else if (status.equalsIgnoreCase("reject")) {
					page.locator("//span[normalize-space(text())='Reject']").click();
					ElementHandle successmessage=page.waitForSelector("//p[text()='Goal has been rejected successfully.']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
					if(successmessage.isVisible()) {
						System.out.println(successmessage.innerText());
					}
					else {
						System.out.println("goal not approved");
					}

				}
			}
		}
	}
}
