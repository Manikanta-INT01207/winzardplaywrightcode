package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class selfGoalCreationNegativeCaseSD extends BaseClass{

	
	@Then("employees wantedly misses to fill the any data of {string} , {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void employees_wantedly_misses_to_fill_the_any_data_of_and(String goaltitle, String targettype, String bandtype, String weightage, String goaltype, String goalKPI, String target, String goalfrequencey, String startdate, String enddate, String subgoaldata) {
	   
		String actualtitle[]=goaltitle.split(",");
		String actualtargettype[]=targettype.split(",");
		String actualbandtype[]=bandtype.split(",");
		String actualweightage[]=weightage.split(",");
		String actualgoaltype[]=goaltype.split(",");
		String actualgoalkpi[]=goalKPI.split(",");
		String actualtarget[]=target.split(",");
		String actualfrequency[]=goalfrequencey.split(",");
		String actualstartdate[]=startdate.split(",");
		String actualenddate[]=enddate.split(",");
		//String actualkeypoint[]=keypoint.split(",");
		//String actualempnames[]=empnames.split(",");
		
		page.getByText("+ Create Goals").click();

		
		for(int i=0;i<actualtitle.length;i++) {

			page.locator("(//input[@id='goalTitle'])[2]").click();
			page.locator("(//input[@id='goalTitle'])[2]").fill(actualtitle[i]);
			page.keyboard().press("Escape");
			page.locator("(//mat-select[@formcontrolname='targetType'])[2]").click();
			if(actualtargettype[i].equalsIgnoreCase("Alphanumeric")) {
				List<ElementHandle> targetdrodowns=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle targetdropdown : targetdrodowns) {
					String targetelement=targetdropdown.innerText();
					if(targetelement.equalsIgnoreCase(actualtargettype[i])) {
						targetdropdown.click();
						break;
					}
				}
				
				page.locator("(//input[@formcontrolname='weightage'])[2]").fill(actualweightage[i]);
				
				if (actualgoaltype[i].isEmpty()) {
					
				} else {

					page.locator("(//mat-select[@id='goalType'])[2]").click();
					List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
					for (ElementHandle goaltype1 : goaltypes) {
						String targetgoaltype=goaltype1.innerText().trim();
						if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
							goaltype1.click();
							break;
						}
					}
				}
				
				
				

				page.locator("(//textarea[@id='goalKpi'])[2]").fill(actualgoalkpi[i]);
				page.locator("(//textarea[@formcontrolname='target'])[2]").fill(actualtarget[i]);
				page.locator("(//mat-select[@id='goalFrequency'])[2]").click();
				List<ElementHandle> goalfrequency =page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle goalfreq : goalfrequency) {
					String targetfrequency=goalfreq.innerText().trim();
					if(targetfrequency.equalsIgnoreCase(actualfrequency[i])) {
						goalfreq.click();
						break;
					}
				}
				
				if (actualstartdate[i].isEmpty()) {

				} else {
					page.locator("input[formcontrolname='startDate']").click();
					negativecalendar(actualstartdate[i]);
				}

				if (actualenddate[i].isEmpty()) {

				} else {
					page.locator("input[formcontrolname='endDate']").click();
					negativecalendar(actualenddate[i]);
				}

				
								
				
				
			//	page.locator("(//textarea[@formcontrolname='subgoalDescription'])[2]").fill(actualkeypoint[i]);
				List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
				if(!subgoals.isEmpty()) {

					for (ElementHandle subgoall : subgoals) {
						subgoall.fill(subgoaldata);
					}
				}
				page.waitForTimeout(2000);


			}
			else {

				List<ElementHandle> targetdrodowns=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle targetdropdown : targetdrodowns) {
					String targetelement=targetdropdown.innerText();
					if(targetelement.equalsIgnoreCase(actualtargettype[i])) {
						targetdropdown.click();
						break;
					}
				}
				
				if (actualbandtype[i].isEmpty()) {
					
				} else {

					page.locator("//mat-select[@formcontrolname='bandType']").click();
					List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
					for (ElementHandle bandtype1 : bandtypes) {
						String targetbandtype=bandtype1.innerText().trim();
						if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
							bandtype1.click();
							break;
						}
					}
				}
				
				page.locator("(//input[@formcontrolname='weightage'])[2]").fill(actualweightage[i]);
				
				if (actualgoaltype[i].isEmpty()) {
					
					
					
				} else {

					
					page.locator("(//mat-select[@id='goalType'])[2]").click();
					List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
					for (ElementHandle goaltype1 : goaltypes) {
						String targetgoaltype=goaltype1.innerText().trim();
						if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
							goaltype1.click();
							break;
						}
					}

				}
				

				
				page.locator("(//textarea[@id='goalKpi'])[2]").fill(actualgoalkpi[i]);
				page.locator("(//textarea[@formcontrolname='target'])[2]").fill(actualtarget[i]);
				page.locator("(//mat-select[@id='goalFrequency'])[2]").click();
				List<ElementHandle> goalfrequency =page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle goalfreq : goalfrequency) {
					String targetfrequency=goalfreq.innerText().trim();
					if(targetfrequency.equalsIgnoreCase(actualfrequency[i])) {
						goalfreq.click();
						break;
					}
				}
				
				if (actualstartdate[i].isEmpty()) {

				} else {
					page.locator("(//input[@formcontrolname='startDate'])[2]").click();
					negativecalendar(actualstartdate[i]);
				}

				if (actualenddate[i].isEmpty()) {

				} else {
					page.locator("(//input[@formcontrolname='endDate'])[2]").click();
					negativecalendar(actualenddate[i]);
				}
				
				
				
				
				
			//	page.locator("(//textarea[@formcontrolname='subgoalDescription'])[2]").fill(actualkeypoint[i]);
				List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
				if(!subgoals.isEmpty()) {

					for (ElementHandle subgoal:subgoals) {
						subgoal.fill(subgoaldata);
					}
				}
				page.waitForTimeout(2000);

				
			}

		}

		page.locator("//button[text()='Publish goal']").click();
		Locator successmessage=page.getByText("Please fill all mandatory fields");
		successmessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
		assertTrue("Goals created negative case failed please check it", successmessage.isVisible());
		
		page.waitForTimeout(2000);
		
	}
	
}
