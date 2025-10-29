package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class initiateAssessmentSD extends BaseClass{

	@Then("admin goes to initiate assessment tab and click on the start new to initiate assessment")
	public void admin_goes_to_initiate_assessment_tab_and_click_on_the_start_new_to_initiate_assessment() {
		page.locator("//a[normalize-space()='Initate Assessment']").click();
		page.locator("//button[normalize-space()='+ Start New']").click();


	}
	@Then("admin enters the assessment {string} , {string} and {string}")
	public void admin_enters_the_assessment_and(String title, String appraisalperiodstartdate, String appraisalperiodenddate) {
		page.locator("//input[@formcontrolname='assessmentTitle']").fill(title);
		page.locator("//input[@formcontrolname='startDate']").click();
		selectcalander(appraisalperiodstartdate);
		page.locator("//input[@formcontrolname='endDate']").click();
		selectcalander(appraisalperiodenddate);
	}
	@Then("admin enters the {string} and their {string}")
	public void admin_enters_the_and_their(String reviewtypes, String weightages) {

		String [] reviewtype=reviewtypes.split(",");
		String [] weightage=weightages.split(",");

		if (reviewtype.length>1) {
			for (int i = 0; i < reviewtype.length; i++) {
				page.locator("//mat-select[contains(@class,'invalid')and not(@formcontrolname='reviewRatingAccess')and not(@formcontrolname='globalSettingType')]").click();
				List<ElementHandle> reviewopts=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle reviewoptions : reviewopts) {

					if (reviewoptions.innerText().equalsIgnoreCase(reviewtype[i])) {
						reviewoptions.click();

					}

				}
				page.locator("//input[@formcontrolname='weightage']").last().fill(weightage[i]);

				if(i==reviewtype.length-1) {
					break;
				}

				page.locator("//button[text()='+Add Review']").click();

			}
		}
		else {
			page.locator("//mat-select[contains(@class,'invalid')and not(@formcontrolname='reviewRatingAccess')and not(@formcontrolname='globalSettingType')]").click();
			List<ElementHandle> reviewopts=page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle reviewoptions : reviewopts) {

				if (reviewoptions.innerText().equalsIgnoreCase(reviewtype[0])) {
					reviewoptions.click();

				}

			}
			page.locator("//input[@formcontrolname='weightage']").last().fill(weightage[0]);
		}

	}
	@Then("admin selects the {string} , {string} and {string}")
	public void admin_selects_the_and(String hierarchy, String authorityToFillEntireAssessment, String configurtaionType) {



		if (hierarchy.equalsIgnoreCase("standard")) {

			page.locator("//div[text()='Standard ']").click();
			page.locator("//mat-select[@formcontrolname='reviewRatingAccess']").click();
			List<ElementHandle> auths =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle finalauth : auths) {
				if (finalauth.innerText().equalsIgnoreCase(authorityToFillEntireAssessment)) {
					finalauth.click();
				}
			}

		} 
		else if(hierarchy.equalsIgnoreCase("Inculde Skip Level")){

			page.locator("//div[text()='Inculde Skip Level ']").click();
			page.locator("//mat-select[@formcontrolname='reviewRatingAccess']").click();
			List<ElementHandle> auths =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle finalauth : auths) {
				if (finalauth.innerText().equalsIgnoreCase(authorityToFillEntireAssessment)) {
					finalauth.click();
				}
			}

		}
		else if(hierarchy.equalsIgnoreCase("Global Configuration")){
			page.locator("//div[text()='Global Configuration']").click();
		}

		Locator configtype=page.locator("//mat-select[@formcontrolname='globalSettingType']");
		if (configtype.isVisible()) {
			page.locator("//mat-select[@formcontrolname='globalSettingType']").click();
			List<ElementHandle> configtypee=page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle contype : configtypee) {
				if (contype.innerText().equalsIgnoreCase(configurtaionType)) {
					contype.click();
				}
			}

		}


	}
	@Then("admin select the {string}")
	public void admin_select_the(String recommendations) {

		String [] recomm=recommendations.split(",");
		
		if (recomm[0].isBlank()) {

		}
		else {
			page.locator("//mat-select[@formcontrolname='recommendations']").click();
			List<ElementHandle> rec=page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle recommendation : rec) {
				for (int i = 0; i < recomm.length; i++) {
					if (recommendation.innerText().equalsIgnoreCase(recomm[i])) {
						recommendation.click();
					}
				}
			}
			page.keyboard().press("Escape");
		}
		page.locator("//button[text()='Next']").click();
	}
	@Then("admin selects the employees from through {string} , {string} and filters {string} , {string}")
	public void admin_selects_the_employees_from_through_and_filters(String customempID, String empIDs, String category, String subcategory) {


		if(empIDs.isBlank()) {
			System.out.println("no empid is assigned");
		}
		else {
			addingEmpsThroughIds(empIDs);
		}


		if(customempID.isBlank()) {
			System.out.println("no custemp is assigned");
		}
		else {
			selectCustomEmployee(customempID);

		}

		if (category.isBlank()&&subcategory.isBlank()) {

		} else {
			choosefilter(category, subcategory);
		}
		 page.locator("//button[text()='Next']").click();
	}
	@Then("admin enters the {string} , {string} and {string} for standard and skiplevel hierarchy")
	public void admin_enters_the_and_for_standard_and_skiplevel_hierarchy(String appraisalStartDate, String appraisalEndDate, String HOC) {

		page.locator("//input[@formcontrolname='assessmentStartDate']").click();
		selectcalander(appraisalStartDate);
		page.locator("//input[@formcontrolname='assessmentEndDate']").click();
		selectcalander(appraisalEndDate);
		
		Locator hocc=page.locator("//mat-select[contains(@class,'invalid')]");
		if(hocc.isVisible()) {
			hocc.click();
		List<ElementHandle>hoc=page.querySelectorAll("//span[@class='mat-option-text']");
		for (ElementHandle HOCc : hoc) {
			if (HOCc.innerText().contains(HOC)) {
			
				HOCc.click();
			}
		}
	}
		page.locator("//button[text()='Save']").click();
		
		Locator successmessage =page.locator("//p[text()='Appraisals Initiated succesfully']");
		successmessage.waitFor(new Locator.WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		assertTrue("appraisal not created",successmessage.isVisible());

	}


}
