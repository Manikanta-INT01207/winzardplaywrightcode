package playwright;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class GoalapprovalORreject extends BaseClass {

	public static void main(String[] args) {
		
		initializer();
		page.navigate("https://capgemini.247hrm.co/");
		page.locator("#user-name").fill("sneha@winzard.io");
		page.locator("#password").fill("Winzard@2024");
		page.getByText("LOGIN").click();
		
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.locator("//span[text()='Team Goals ']").click();
		
		String selectionType ="Grid view";
		String approvalType="one by one";
		String EmpId= "CAP-47";
		String status ="reject";
		if (selectionType .equalsIgnoreCase("Employee-wise")) {
			Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
			if(!leftpanel.isVisible()) {
				page.locator("//mat-icon[text()='refresh']").click();
				leftpanel.waitFor();
			}
			
			if(approvalType.equalsIgnoreCase("one by one")) {
				page.locator("#emp-search-bar").click();
				page.locator("#emp-search-bar").fill(EmpId);
				page.locator("//div[@class='name']").click();
				page.locator("//span[normalize-space(text()) = 'Filter by']").click();
				page.locator("//span[normalize-space(text())='Approvals']").click();
				page.locator("//mat-select[@aria-label='Items per page:']").click();
				page.locator("//span[text()='100']").click();
				
				Locator approvallists=page.locator("//div[@class='s-APPROVAL_PENDING']");
				while(approvallists.count()>0) {
					approvallists.first().click();

					//page.locator("//span[normalize-space(text())='Approved']").click();


					if(status .equalsIgnoreCase("Approve")) {
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




				}

			}
			else if (approvalType.equalsIgnoreCase("bulk")) {
				
				page.locator("#emp-search-bar").click();
				page.locator("#emp-search-bar").fill(EmpId);
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
		else if(selectionType.equalsIgnoreCase("Grid view")){
			page.locator("//mat-icon[text()='group']").click();
			page.waitForTimeout(3000);
			Locator header= page.locator("//tr[contains(@class,'header-row')]");
			header.waitFor();
			
			Locator disablebutton=page.locator("(//button[contains(@class,'disable-click')])[1]");
			if (disablebutton.isVisible()) {
				page.locator("//mat-icon[text()='person']").click();
				page.locator("//mat-icon[text()='refresh']").click();
				page.locator("//mat-icon[text()='group']").click();
				//Locator header= page.locator("//tr[contains(@class,'header-row')]");
				header.waitFor();

			} else {

			}
			
			
			
			if(approvalType.equalsIgnoreCase("one by one")) {
				
				page.locator("//app-select-search[@ng-reflect-label='Select the employees']").click();
				List<ElementHandle>empslist=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle empscodes : empslist) {
					if (empscodes.innerText().contains(EmpId)) {
						empscodes.click();
						break;
					}
				}
				
				page.locator("//span[normalize-space(text()) = 'Filter by']").click();
				page.locator("//span[normalize-space(text())='Approvals']").click();
				page.locator("//mat-select[@aria-label='Items per page:']").click();
				page.locator("//span[text()='100']").click();
				Locator approvallists=page.locator("//div[@class='s-APPROVAL_PENDING']");
				while(approvallists.count()>0) {
					
					for(int i=0;i<approvallists.count();i++) {
						
					
					
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

                      page.locator("//mat-icon[text()='refresh']").click();
                      
                      page.locator("//app-select-search[@ng-reflect-label='Select the employees']").click();
      				List<ElementHandle>empslistt=page.querySelectorAll("//span[@class='mat-option-text']");
      				for (ElementHandle empscodes : empslistt) {
      					if (empscodes.innerText().contains(EmpId)) {
      						empscodes.click();
      						break;
      					}
      				}
                      

				}
				}

			}
			else if (approvalType.equalsIgnoreCase("bulk")) {
				
				page.locator("//app-select-search[@ng-reflect-label='Select the employees']").click();
				List<ElementHandle>empslist=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle empscodes : empslist) {
					if (empscodes.innerText().contains(EmpId)) {
						empscodes.click();
						break;
					}
				}
				
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
