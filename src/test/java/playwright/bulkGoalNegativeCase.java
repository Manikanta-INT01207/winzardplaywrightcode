package playwright;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class bulkGoalNegativeCase extends BaseClass{

	public static void main(String[] args) {

	 initializer();
	 page.navigate("https://capgemini.247hrm.co/");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.getByText("Bulk Goals").click();
		page.getByText("+ Create Bulk Goals").click();

		String goaltitle="title";
		String targettype="numeric";
		String bandtype="upper band";
		String weightage="40";
		String goaltype="financial";
		String goalKPI="kpi-3";
		String target="4000";
		String goalfrequencey="monthly";
		String startdate="1-Apr-2025";
		String enddate="30-Dec-2025";
		String keypoint="key point-1";
		String subgoaldata="1000";
		String empnames="CAP-38";
		
		
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
		String actualkeypoint[]=keypoint.split(",");
		
		selectCustomEmployee(empnames);
		
		for(int i=0;i<actualtitle.length;i++) {
		
		Locator goal=page.locator("(//span[@class='mat-content'])[" + (i+1) + "]");
		if(goal.isVisible()) {
			page.locator("(//span[@class='mat-content'])[" + (i+1) + "]").click();
		}
		
	page.locator("(//input[@formcontrolname='goalTitle'])[" + (i+2) + "]").click();
	page.locator("(//input[@formcontrolname='goalTitle'])[" + (i+2) + "]").fill(actualtitle[i]);
	page.locator("(//mat-select[@formcontrolname='targetType'])[" + (i+2) + "]").click();
	if(actualtargettype[i].equalsIgnoreCase("Alphanumeric")) {
	List<ElementHandle> targetdrodowns=page.querySelectorAll("//span[@class='mat-option-text']");
	for (ElementHandle targetdropdown : targetdrodowns) {
		String targetelement=targetdropdown.innerText();
		if(targetelement.equalsIgnoreCase(actualtargettype[i])) {
			targetdropdown.click();
			break;
		}
	}
	
	page.locator("(//input[@formcontrolname='weightage'])[" + (i+2) + "]").fill(actualweightage[i]);
	
	if (actualgoaltype[i].isEmpty()) {
		
	} else {
		page.locator("(//mat-select[@formcontrolname='type'])[" + (i+2) + "]").click();

		List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
		for (ElementHandle goaltype1 : goaltypes) {
			String targetgoaltype=goaltype1.innerText().trim();
			if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
				goaltype1.click();
				break;
			}
		}
	}
	
	
	
	page.locator("(//textarea[@formcontrolname='kpi'])[" + (i+2) + "]").fill(actualgoalkpi[i]);
	page.locator("(//textarea[@formcontrolname='target'])[" + (i+2) + "]").fill(actualtarget[i]);
	page.locator("(//mat-select[@formcontrolname='subGoalFrequency'])[" + (i+2) + "]").click();
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
		page.locator("(//input[@formcontrolname='startDate'])["+ (i+2) +"]").click();
		negativecalendar(actualstartdate[i]);
	}
	
	if (actualenddate[i].isEmpty()) {

	} else {
		page.locator("(//input[@formcontrolname='endDate'])["+ (i+2) +"]").click();
		negativecalendar(actualenddate[i]);
	}
	
	page.locator("(//textarea[@formcontrolname='subgoalDescription'])["+ (i+2) +"]").fill(actualkeypoint[i]);
	List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
	if(!subgoals.isEmpty()) {
		
		for (ElementHandle subgoal : subgoals) {
			subgoal.fill(subgoaldata);
		}
	}
	
	
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

			page.locator("(//mat-select[@formcontrolname='bandType'])["+(i+1)+"]").click();
			List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle bandtype1 : bandtypes) {
				String targetbandtype=bandtype1.innerText().trim();
				if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
					bandtype1.click();
					break;
				}
			}
		}
		
		
		
		
		page.locator("(//input[@formcontrolname='weightage'])["+ (i+2) +"]").fill(actualweightage[i]);
		if (actualgoaltype[i].isEmpty()) {
			
		} else {
			page.locator("(//mat-select[@formcontrolname='type'])[" + (i+2) + "]").click();
			List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle goaltype1 : goaltypes) {
				String targetgoaltype=goaltype1.innerText().trim();
				if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
					goaltype1.click();
					break;
				}
			}
		}
		
		page.locator("(//textarea[@formcontrolname='kpi'])["+ (i+2) +"]").fill(actualgoalkpi[i]);
		page.locator("(//textarea[@formcontrolname='target'])["+ (i+2) +"]").fill(actualtarget[i]);
		page.locator("(//mat-select[@formcontrolname='subGoalFrequency'])["+ (i+2) +"]").click();
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
			page.locator("(//input[@formcontrolname='startDate'])["+ (i+2) +"]").click();
			negativecalendar(actualstartdate[i]);
		}
		
		if (actualenddate[i].isEmpty()) {

		} else {
			page.locator("(//input[@formcontrolname='endDate'])["+ (i+2) +"]").click();
			negativecalendar(actualenddate[i]);
		}
		
		
		
		page.locator("(//textarea[@formcontrolname='subgoalDescription'])["+ (i+2) +"]").fill(actualkeypoint[i]);
		List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
		if(!subgoals.isEmpty()) {
			
			for (ElementHandle subgoal : subgoals) {
				subgoal.fill(subgoaldata);
			}
		}
		
	}
	if(goal.isVisible()) {
		page.locator("(//span[@class='mat-content'])[" + (i+1) + "]").click();
	}
	
	if(i==actualtitle.length-1) {
		
	}
	else {
	page.locator("//div[text()='Add New Goal']").click();
	}
}
	
	page.locator("//button[text()='Publish goal']").click();
	page.waitForTimeout(3000);
	Locator successmessage=page.getByText("Bulk Goal Added Successfully");
    assertFalse("goals created without mandatory fileds please check",successmessage.isVisible());
		
	}

}
