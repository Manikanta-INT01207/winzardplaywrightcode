package playwright;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class assignWorkflows extends BaseClass {

	public static void main(String[] args) {

		String[] forms= {"self form","FORM 1"};
		String[] weightage= {"30","40"};

		String[]hierarchy= {"without self","Reviewer-1","Reviewer-2"};
		String[] finalauthority= {"Reviewer - 1","Reviewer - 2"};

		String [] selfform= {"self form","FORM 1"};
		String[] RMform= {"FORM 1"};
		String[] SKFORM= {"FORM 1","self form"};

		String[] reviewerLevels= {"L1","L2","L3"};
		String[] reviewerEmpID= {"CAP-37","CAP-38","CAP-39"};
		String[] reviewer1forms= {"no form"};
		String[] reviewer2forms= {"no forms"};

		System.out.println(reviewer2forms.length);
		String[] reviewer3forms= {"self form","FORM 1"};


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
		page.locator("//div[text()='Create Workflows & Assign Forms']").click();

		page.locator("//mat-select[@placeholder='Select type']").click();
		page.locator("//span[text()='Employee ']").click();

		page.locator("//button[normalize-space()='+ Start New']").click();



		page.locator("//input[@formcontrolname='flowTitle']").fill("grade-A workflow");



		for(int i=0;i<forms.length;i++) {
			int index=2+i;
			page.locator("//button[normalize-space()='+ Add Forms']").click();
			page.locator("(//mat-select[@role='listbox'])["+index+"]").last().click();
			List<ElementHandle> formtext= page.querySelectorAll("//span[@class='mat-option-text']");

			for (ElementHandle formtexts : formtext) {
				if(formtexts.innerText().equalsIgnoreCase(forms[i])) {
					formtexts.click();
				}

			}
			page.locator("//input[@formcontrolname='weightage']").last().fill(weightage[i]);
		}

		for(int j =0;j<hierarchy.length;j++) {
			if(hierarchy[j].equalsIgnoreCase("self")) {
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
			else if (hierarchy[j].equalsIgnoreCase("without self")) {

				page.locator("(//div[@class='mat-radio-label-content'])[2]").click();
				System.out.println("self not clicked");
			}
			else if (hierarchy[j].equalsIgnoreCase("reporting manager")) {
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
			else if (hierarchy[j].equalsIgnoreCase("without reporting manager")) {
				System.out.println("RM not clicked");
			}
			else if (hierarchy[j].equalsIgnoreCase("skip level manager")) {
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
			else if (hierarchy[j].equalsIgnoreCase("without skip level manager")) {

			}
			else if (hierarchy[j].equalsIgnoreCase("Reviewer-1")) {
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
					for(int rr=0;rr<reviewer1forms.length;rr++) {
						if (RVF.innerText().equalsIgnoreCase(reviewer1forms[rr])) {
							RVF.click();
						}

					}
				}
				page.keyboard().press("Escape");



			}
			else if (hierarchy[j].equalsIgnoreCase("Reviewer-2")) {
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
					for(int rr=0;rr<reviewer2forms.length;rr++) {
						if (RVF.innerText().equalsIgnoreCase(reviewer2forms[rr])) {
							RVF.click();
						}

					}
				}
				page.keyboard().press("Escape");



			}
			else if (hierarchy[j].equalsIgnoreCase("Reviewer-3")) {
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
					for(int rr=0;rr<reviewer3forms.length;rr++) {
						if (RVF.innerText().equalsIgnoreCase(reviewer3forms[rr])) {
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

		page.locator("//mat-select[@id='mat-select-4']").click();
		List<ElementHandle>finalauth=page.querySelectorAll("//span[@class='mat-option-text']");
		for (ElementHandle finalauthss : finalauth) {
			for(int fa=0;fa<finalauthority.length;fa++) {
				if (finalauthss.innerText().trim().equalsIgnoreCase(finalauthority[fa])) {
					finalauthss.click();
				}

			}
		}
		page.keyboard().press("Escape");

		String empid="";
		if(empid.isBlank()) {
			System.out.println("no empid is assigned");
		}
		else {
			addingEmpsThroughIds(empid);
		}
		
		String custemp="";
		if(custemp.isBlank()) {
			System.out.println("no custemp is assigned");
		}
		else {
			BaseClass.selectCustomEmployee(custemp);

		}
		
		
		
//		page.waitForTimeout(2000);
//		choosefilter("Grade","Grade-F");

		page.locator("//button[text()='Create']").click();

		Locator successmessage=page.locator("//p[text()='Workflow created']");
		successmessage.waitFor(new Locator .WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertTrue("workflow not created ", successmessage.isVisible());

	}

}
