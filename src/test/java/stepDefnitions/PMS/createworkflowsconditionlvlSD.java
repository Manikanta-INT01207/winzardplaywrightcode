package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class createworkflowsconditionlvlSD extends BaseClass{

	@Then("admin goes to the create workflows and assign forms tab")
	public void admin_goes_to_the_create_workflows_and_assign_forms_tab() {
		page.locator("//a[normalize-space(text())='Global Configuration']").click();
		page.locator("//div[text()='Create Workflows & Assign Forms']").click();

	}
	@Then("admin clicks on the start new and enter the workflow title {string}")
	public void admin_clicks_on_the_start_new_and_enter_the_workflow_title(String title) {

		page.locator("//button[normalize-space()='+ Start New']").click();
		page.locator("//input[@formcontrolname='flowTitle']").fill(title);
	}
	@Then("admin adds the forms {string} and {string}")
	public void admin_adds_the_forms_and(String forms, String weightage) {

		String[] formsss= forms.split(",");
		String[] weightages=weightage.split(",") ;
		
		for(int i=0;i<formsss.length;i++) {
			int index=2+i;
			page.locator("//button[normalize-space()='+ Add Forms']").click();
			page.locator("(//mat-select[@role='listbox'])["+index+"]").last().click();
			List<ElementHandle> formtext= page.querySelectorAll("//span[@class='mat-option-text']");

			for (ElementHandle formtexts : formtext) {
				if(formtexts.innerText().equalsIgnoreCase(formsss[i])) {
					formtexts.click();
				}

			}
			page.locator("//input[@formcontrolname='weightage']").last().fill(weightages[i]);
		}
	}
	@Then("admin adds the  {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void admin_adds_the(String hierarchy, String selfforms, String RMforms, String skiplevelmanagerforms, String reviwerlevels, String reviewersempIDs, String reviewer1forms, String reviewer2forms, String reviewer3forms) {

		String[]hierarchys= hierarchy.split(",");
		String [] selfform= selfforms.split(",");
		String[] RMform= RMforms.split(",");
		String[] SKFORM= skiplevelmanagerforms.split(",");

		String[] reviewerLevels= reviwerlevels.split(",");
		String[] reviewerEmpID= reviewersempIDs.split(",");
		String[] reviewer1formss=reviewer1forms.split(",") ;
		String[] reviewer2formss= reviewer2forms.split(",");
		String[] reviewer3formss= reviewer3forms.split(",");
		
	

		
		for(int j =0;j<hierarchys.length;j++) {
			if(hierarchys[j].equalsIgnoreCase("self")) {
				page.locator("(//div[@class='mat-radio-label-content'])[1]").click();
				page.locator("//mat-select[contains(@class,'invalid')]").click();
				List<ElementHandle>selfformss=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle SF : selfformss) {
					for(int s=0;s<selfform.length;s++) {
						if (SF.innerText().equalsIgnoreCase(selfform[s])) {
							SF.click();
						}
					}
				}
				page.keyboard().press("Escape");
				System.out.println("self clicked");
			}
			else if (hierarchys[j].equalsIgnoreCase("without self")) {

				page.locator("(//div[@class='mat-radio-label-content'])[2]").click();
				System.out.println("self not clicked");
			}
			else if (hierarchys[j].equalsIgnoreCase("reporting manager")) {
				page.locator("//span[text()='Immediate Reporting Manager']").click();
				page.locator("//mat-select[contains(@class,'invalid')]").click();
				List<ElementHandle>rmforms=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle RMF : rmforms) {
					for(int r=0;r<RMform.length;r++) {
						if (RMF.innerText().equalsIgnoreCase(RMform[r])) {
							RMF.click();
						}
					}
				}
				page.keyboard().press("Escape");
				System.out.println("RM clicked");

			}
			else if (hierarchys[j].equalsIgnoreCase("without reporting manager")) {
				System.out.println("RM not clicked");
			}
			else if (hierarchys[j].equalsIgnoreCase("skip level manager")) {
				page.locator("//span[text()='Skip Level Manager']").click();

				page.locator("(//mat-select[contains(@class,'valid')])[5]").click();
				List<ElementHandle>skipforms=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle SKF : skipforms) {
					for(int r=0;r<SKFORM.length;r++) {
						if (SKF.innerText().equalsIgnoreCase(SKFORM[r])) {
							SKF.click();
						}
					}
				}
				page.keyboard().press("Escape");
				System.out.println("skip level clicked");
			}
			else if (hierarchys[j].equalsIgnoreCase("without skip level manager")) {

			}
			else if (hierarchys[j].equalsIgnoreCase("Reviewer-1")) {
				page.locator("//button[text()='+ Add New Reviewer']").click();
				page.locator("//input[contains(@class,'invalid')]").last().click();
				page.locator("//input[contains(@class,'invalid')]").fill(reviewerLevels[0]);
				page.locator("//mat-select[contains(@class,'invalid')]").click();
				List<ElementHandle>empslist=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle empscodes : empslist) {
					if (empscodes.innerText().contains(reviewerEmpID[0])) {
						empscodes.click();
					}
				}
				page.locator("//app-select-search[@formcontrolname='forms']").last().click();

				List<ElementHandle>reviewerforms=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle RVF : reviewerforms) {
					for(int rr=0;rr<reviewer1formss.length;rr++) {
						if (RVF.innerText().equalsIgnoreCase(reviewer1formss[rr])) {
							RVF.click();
						}

					}
				}
				page.keyboard().press("Escape");



			}
			else if (hierarchys[j].equalsIgnoreCase("Reviewer-2")) {
				page.locator("//button[text()='+ Add New Reviewer']").click();
				page.locator("//input[contains(@class,'invalid')]").last().click();
				page.locator("//input[contains(@class,'invalid')]").fill(reviewerLevels[1]);
				page.locator("//mat-select[contains(@class,'invalid')]").click();
				List<ElementHandle>empslist=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle empscodes : empslist) {
					if (empscodes.innerText().contains(reviewerEmpID[1])) {
						empscodes.click();
					}
				}
				page.locator("//app-select-search[@formcontrolname='forms']").last().click();

				List<ElementHandle>reviewerforms=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle RVF : reviewerforms) {
					for(int rr=0;rr<reviewer2formss.length;rr++) {
						if (RVF.innerText().equalsIgnoreCase(reviewer2formss[rr])) {
							RVF.click();
						}

					}
				}
				page.keyboard().press("Escape");



			}
			else if (hierarchys[j].equalsIgnoreCase("Reviewer-3")) {
				page.locator("//button[text()='+ Add New Reviewer']").click();
				page.locator("//input[contains(@class,'invalid')]").last().click();
				page.locator("//input[contains(@class,'invalid')]").fill(reviewerLevels[1]);
				page.locator("//mat-select[contains(@class,'invalid')]").click();
				List<ElementHandle>empslist=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle empscodes : empslist) {
					if (empscodes.innerText().contains(reviewerEmpID[2])) {
						empscodes.click();
					}
				}
				page.locator("//app-select-search[@formcontrolname='forms']").last().click();

				List<ElementHandle>reviewerforms=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle RVF : reviewerforms) {
					for(int rr=0;rr<reviewer3formss.length;rr++) {
						if (RVF.innerText().equalsIgnoreCase(reviewer3formss[rr])) {
							RVF.click();
						}

					}
				}
				page.keyboard().press("Escape");



			}

			else {
				System.out.println("update the hierarchy");
			}
		}
		
	}
	@Then("admin adds the {string}")
	public void admin_adds_the(String finalauthority) {

		String[] finalauthoritys= finalauthority.split(",");
		
		page.locator("//mat-select[@id='mat-select-4']").click();
		List<ElementHandle>finalauth=page.querySelectorAll("//span[@class='mat-option-text']");
		for (ElementHandle finalauthss : finalauth) {
			for(int fa=0;fa<finalauthoritys.length;fa++) {
				if (finalauthss.innerText().trim().equalsIgnoreCase(finalauthoritys[fa])) {
					finalauthss.click();
				}

			}
		}
		page.keyboard().press("Escape");
		
		
		
		
		

		

	}

@Then("admins adds the employees through filters {string} and {string}")
public void admins_adds_the_employees_through_filters_and(String department, String subdepartment) {
	page.waitForTimeout(2000);
	choosefilter(department, subdepartment);
	page.locator("//button[text()='Create']").click();
	
	Locator successmessage=page.locator("//p[text()='Workflow created']");
    successmessage.waitFor(new Locator .WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    assertTrue("workflow not created ", successmessage.isVisible());

}




}
