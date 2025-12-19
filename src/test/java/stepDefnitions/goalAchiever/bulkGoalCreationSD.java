package stepDefnitions.goalAchiever;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class bulkGoalCreationSD extends BaseClass {

	@Given("admin login to the their portal {string} and {string}")
	public void admin_login_to_the_their_portal_and(String username, String password) {
	    
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
	@Then("admin adds employees from {string} filters  {string}  and {string}  empid {string}")
	public void admin_adds_employees_from_filters_and_empid(String customemployee, String category, String subcategory, String empIDs) {
	    
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		
		page.locator("//span[normalize-space()='Bulk Goals']").click();
		
		page.locator("//button[contains(@id,'goal-creation')]").click();
        page.locator("(//mat-icon[text()='close'])[2]").click();
		
		page.locator("//button[contains(@id,'goal-creation')]").click();
		page.waitForTimeout(2000);
		choosefilter(category, subcategory);
		addingEmpsThroughIds(empIDs);
		selectCustomEmployee(customemployee);

	}
	@Then("admin creates the bulk goals with {string} , {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void admin_creates_the_bulk_goals_with_and(String goaltitle, String targettype, String bandtype, String weightage, String goaltype, String goalKPI, String target, String goalfrequencey, String startdate, String enddate, String keypoint, String subgoaldata) {
	    
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
		page.keyboard().press("Escape");
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
		page.locator("(//mat-select[@formcontrolname='type'])[" + (i+2) + "]").click();
		List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
		for (ElementHandle goaltype1 : goaltypes) {
			String targetgoaltype=goaltype1.innerText().trim();
			if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
				goaltype1.click();
				break;
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
		page.locator("(//input[@formcontrolname='startDate'])["+ (i+2) +"]").click();
		selectcalander(actualstartdate[i]);
		page.locator("(//input[@formcontrolname='endDate'])["+ (i+2) +"]").click();
		selectcalander(actualenddate[i]);
	
		
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
			
			int bandindex = i+1;
			
		   Locator bandtype11=page.locator("(//mat-select[@formcontrolname='bandType'])["+(bandindex)+"]");
			if(bandtype11.isVisible()) {
			bandtype11.click();
			List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle bandtype1 : bandtypes) {
				String targetbandtype=bandtype1.innerText().trim();
				if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
					bandtype1.click();
					break;
				}
			}
			}
			else {
				   Locator bandtype12=page.locator("(//mat-select[@formcontrolname='bandType'])["+(bandindex-1)+"]");
					if(bandtype12.isVisible()) {
					bandtype12.click();
					List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
					for (ElementHandle bandtype1 : bandtypes) {
						String targetbandtype=bandtype1.innerText().trim();
						if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
							bandtype1.click();
							break;
						}
					}
					}
			}
			
			
			page.locator("(//input[@formcontrolname='weightage'])["+ (i+2) +"]").fill(actualweightage[i]);
			page.locator("(//mat-select[@formcontrolname='type'])["+ (i+2) +"]").click();
			List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
			for (ElementHandle goaltype1 : goaltypes) {
				String targetgoaltype=goaltype1.innerText().trim();
				if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
					goaltype1.click();
					break;
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
			page.locator("(//input[@formcontrolname='startDate'])["+ (i+2) +"]").click();
			selectcalander(actualstartdate[i]);
			page.locator("(//input[@formcontrolname='endDate'])["+ (i+2) +"]").click();
			selectcalander(actualenddate[i]);
			
			
			
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
		ElementHandle successmessage=page.waitForSelector("//p[text()='Bulk Goal Added Successfully']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
     if(successmessage.isVisible()) {
    	 System.out.println("goals created successfully");
     }
     else {
    	 System.out.println("goals not created successfully");
     }
		
		
	}
	
}
