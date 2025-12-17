package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class bulkGoalNegativeCaseSD extends BaseClass{

	@Then("admin intentionally not add employees from {string} filters  {string}  and {string}  empid {string}")
	public void admin_intentionally_not_add_employees_from_filters_and_empid(String customemployee, String category, String subcategory, String empIDs) {
	   
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.getByText("Bulk Goals").click();
		page.getByText("+ Create Bulk Goals").click();
      
		
		
		
		if (customemployee.isEmpty()) {
			
		} else {
               selectCustomEmployee(customemployee);
		}
		
		if (category.isEmpty()||subcategory.isEmpty()) {
			
		} else {

			choosefilter(category, subcategory);
		}
		
		if (empIDs.isEmpty()) {
			
		} else {
           addingEmpsThroughIds(empIDs);
		}
	}
	@Then("admin intentionally missess to give any of these data in the bulk goals with {string} , {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void admin_intentionally_missess_to_give_any_of_these_data_in_the_bulk_goals_with_and(String goaltitle, String targettype, String bandtype, String weightage, String goaltype, String goalKPI, String target, String goalfrequencey, String startdate, String enddate, String keypoint, String subgoaldata) {
	   
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
