package playwright;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class initiateassessmentPMS extends BaseClass{

	public static void main(String[] args) {


		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//mat-icon[normalize-space(text())='menu']").click();
		Locator pms=page.locator("//span[text()='Performance Management']");
		pms.scrollIntoViewIfNeeded();
		pms.click();
		page.locator("//a[normalize-space()='Initate Assessment']").click();
		page.locator("//button[normalize-space()='+ Start New']").click();

		String title="new title";
		String startdate="4-sep-2025";
		String enddate="12-dec-2025";
		
		String appraisalstartdate="1-oct-2025";
		String appraisalenddate="30-nov-2025";

		
		String hierarchy="standard";

		String finalauthority="Reporting Manager";
		String configurationtype="condition";
		
		String [] recomm= {"title","promotion"};

		String [] reviewtypes= {"Custom Forms","performance","Competencies / Skills / Potential"};
		String [] weightage = {"40","30","10"};
		
		String headofcompany="CAP-01";

		page.locator("//input[@formcontrolname='assessmentTitle']").fill(title);
		page.locator("//input[@formcontrolname='startDate']").click();
		selectcalander(startdate);
		page.locator("//input[@formcontrolname='endDate']").click();
		selectcalander(enddate);

		//		if (hierarchy.equalsIgnoreCase("standard")) {
		//			
		//			page.locator("//div[text()='Standard ']").click();
		//		} 
		//		else if(hierarchy.equalsIgnoreCase("Inculde Skip Level")){
		//			
		//           page.locator("//div[text()='Inculde Skip Level ']").click();
		//           
		//		}
		//		else if(hierarchy.equalsIgnoreCase("Global Configuration")){
		//			page.locator("//div[text()='Global Configuration']").click();
		//		}

		if (reviewtypes.length>1) {
			for (int i = 0; i < reviewtypes.length; i++) {
				page.locator("//mat-select[contains(@class,'invalid')and not(@formcontrolname='reviewRatingAccess')and not(@formcontrolname='globalSettingType')]").click();
				List<ElementHandle> reviewopts=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle reviewoptions : reviewopts) {

					if (reviewoptions.innerText().equalsIgnoreCase(reviewtypes[i])) {
						reviewoptions.click();

					}

				}
				page.locator("//input[@formcontrolname='weightage']").last().fill(weightage[i]);

				if(i==reviewtypes.length-1) {
					break;
				}

				page.locator("//button[text()='+Add Review']").click();

			}
		}
		else {
			page.locator("//mat-select[contains(@class,'invalid')and not(@formcontrolname='reviewRatingAccess')and not(@formcontrolname='globalSettingType')]").click();
			List<ElementHandle> reviewopts=page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle reviewoptions : reviewopts) {

				if (reviewoptions.innerText().equalsIgnoreCase(reviewtypes[0])) {
					reviewoptions.click();

				}

			}
			page.locator("//input[@formcontrolname='weightage']").last().fill(weightage[0]);
		}


		if (hierarchy.equalsIgnoreCase("standard")) {

			page.locator("//div[text()='Standard ']").click();
			page.locator("//mat-select[@formcontrolname='reviewRatingAccess']").click();
			List<ElementHandle> auths =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle finalauth : auths) {
				if (finalauth.innerText().equalsIgnoreCase(finalauthority)) {
					finalauth.click();
				}
			}

		} 
		else if(hierarchy.equalsIgnoreCase("Inculde Skip Level")){

			page.locator("//div[text()='Inculde Skip Level ']").click();
			page.locator("//mat-select[@formcontrolname='reviewRatingAccess']").click();
			List<ElementHandle> auths =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle finalauth : auths) {
				if (finalauth.innerText().equalsIgnoreCase(finalauthority)) {
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
			if (contype.innerText().equalsIgnoreCase(configurationtype)) {
				contype.click();
			}
		}
         
		}
        if (recomm[0].isBlank()) {
			
		}
        else {
		page.locator("//mat-select[@formcontrolname='recommendations']").click();
		List<ElementHandle> rec=page.querySelectorAll("//span[@class='mat-option-text']");
        for (ElementHandle recommendations : rec) {
			for (int i = 0; i < recomm.length; i++) {
				if (recommendations.innerText().equalsIgnoreCase(recomm[i])) {
					recommendations.click();
				}
			}
		}
        page.keyboard().press("Escape");
        }
        page.locator("//button[text()='Next']").click();
        
        choosefilter("Grade","Grade A");
        addingEmpsThroughIds("CAP-37");
        selectCustomEmployee("CAP-02");
        page.locator("//button[text()='Next']").click();
        
		page.locator("//input[@formcontrolname='assessmentStartDate']").click();
		selectcalander(appraisalstartdate);
		page.locator("//input[@formcontrolname='assessmentEndDate']").click();
		selectcalander(appraisalenddate);
		
		Locator hocc=page.locator("//mat-select[contains(@class,'invalid')]");
		if(hocc.isVisible()) {
			hocc.click();
		List<ElementHandle>hoc=page.querySelectorAll("//span[@class='mat-option-text']");
		for (ElementHandle HOC : hoc) {
			if (HOC.innerText().contains(headofcompany)) {
			
				HOC.click();
			}
		}
	}
		page.locator("//button[text()='Save']").click();
		
		Locator successmessage =page.locator("//p[text()='Appraisals Initiated succesfully']");
		successmessage.waitFor(new Locator.WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		assertTrue("appraisal not created",successmessage.isVisible());
	}

}
