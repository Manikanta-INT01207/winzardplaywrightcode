package stepDefnitions.goalAchiever;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class goalApproveRejectSD extends BaseClass {

	@Given("supervisor opens the team goal portal with their credentials {string} and {string}")
	public void supervisor_opens_the_team_goal_portal_with_their_credentials_and(String username, String password) {
	   
		page.locator("//input[@formcontrolname='username']").fill(username);
	    page.locator("//input[@formcontrolname='password']").fill(password);
	    page.locator("//span[@class='mat-button-wrapper']").click();
	    try {
	        page.waitForSelector("//p[text()='User does not exist.']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE));
	             page.locator("//span[text()='Ok']").click(); 
	             page.locator("//span[text()='Login ']").click(); 
	         
	     } 
	     catch (Exception ignored) {
	       
	     }
		
		
		
	}
	@Then("supervisor goes through {string} if employee-wise enter the {string}  then {string} later {string}")
	public void supervisor_goes_through_if_employee_wise_enter_the_then_later(String selectionType, String EmpId, String approvalType, String status) {
	   
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.locator("//span[text()='Team Goals ']").click();
		
		if (selectionType.equalsIgnoreCase("Employee-wise")) {
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
			Locator header= page.locator("//tr[contains(@class,'header-row')]");
			header.waitFor();
			if(approvalType.equalsIgnoreCase("one by one")) {
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
			else if (approvalType.equalsIgnoreCase("bulk")) {
				
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
