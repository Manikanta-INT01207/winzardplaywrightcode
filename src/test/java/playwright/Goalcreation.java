package playwright;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class Goalcreation extends BaseClass{

	public static void main(String[]args) {
		initializer();
		page.navigate("https://capgemini.247hrm.co/");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		
	//	page.locator("//span[normalize-space()='Bulk Goals']").click();
//		Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
//		if(!leftpanel.isVisible()) {
//			page.locator("//mat-icon[text()='refresh']").click();
//			leftpanel.waitFor();
//		}
		
		
		
		String goaltitle="title-1,title-2,title-3";
		String targettype="numeric,amount,alphanumeric";
		String bandtype="upper band,upper band,lower band";
		String weightage="40,30,30";
		String goaltype="financial,financial,financial";
		String goalKPI="goal kpi -demo-1,kpi-2,kpi-3";
		String target="4000,6000,90";
		String goalfrequencey="monthly,quarterly,quarterly";
		String startdate="1-Apr-2025,4-Apr-2025,5-May-2025";
		String enddate="30-Dec-2025,28-Nov-2025,27-Sep-2025";
		String keypoint="key point-1,point-2,point-3";
		String subgoaldata="1000,2000";
		String empnames="CAP-01,CAP-02,CAP-04";
		
		
//		
	//page.locator("//button[contains(@id,'goal-creation')]").click();
//        page.locator("(//mat-icon[text()='close'])[2]").click();
//		
//		page.locator("//button[contains(@id,'goal-creation')]").click();
//		page.waitForTimeout(2000);
//		choosefilter("Grade", "Grade A");
//		addingEmpsThroughIds("CAP-03,CAP-04,CAP-05");
//		page.waitForTimeout(2000);
//
//		selectCustomEmployee("CAP-01");

		//		
		
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
		String actualempnames[]=empnames.split(",");
//		for(int i=0;i<actualtitle.length;i++) {
//			
//			Locator goal=page.locator("(//span[@class='mat-content'])[" + (i+1) + "]");
//			if(goal.isVisible()) {
//				page.locator("(//span[@class='mat-content'])[" + (i+1) + "]").click();
//			}
//			
//		page.locator("(//input[@formcontrolname='goalTitle'])[" + (i+2) + "]").click();
//		page.locator("(//input[@formcontrolname='goalTitle'])[" + (i+2) + "]").fill(actualtitle[i]);
//		page.locator("(//mat-select[@formcontrolname='targetType'])[" + (i+2) + "]").click();
//		if(actualtargettype[i].equalsIgnoreCase("Alphanumeric")) {
//		List<ElementHandle> targetdrodowns=page.querySelectorAll("//span[@class='mat-option-text']");
//		for (ElementHandle targetdropdown : targetdrodowns) {
//			String targetelement=targetdropdown.innerText();
//			if(targetelement.equalsIgnoreCase(actualtargettype[i])) {
//				targetdropdown.click();
//				break;
//			}
//		}
//		/*page.locator("//mat-select[@formcontrolname='bandType']").click();
//		List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
//		for (ElementHandle bandtype1 : bandtypes) {
//			String targetbandtype=bandtype1.innerText().trim();
//			if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
//				bandtype1.click();
//				break;
//			}
//		}
//		*/
//		page.locator("(//input[@formcontrolname='weightage'])[" + (i+2) + "]").fill(actualweightage[i]);
//		page.locator("(//mat-select[@formcontrolname='type'])[" + (i+2) + "]").click();
//		List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
//		for (ElementHandle goaltype1 : goaltypes) {
//			String targetgoaltype=goaltype1.innerText().trim();
//			if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
//				goaltype1.click();
//				break;
//			}
//		}
//		
//		page.locator("(//textarea[@formcontrolname='kpi'])[" + (i+2) + "]").fill(actualgoalkpi[i]);
//		page.locator("(//textarea[@formcontrolname='target'])[" + (i+2) + "]").fill(actualtarget[i]);
//		page.locator("(//mat-select[@formcontrolname='subGoalFrequency'])[" + (i+2) + "]").click();
//		List<ElementHandle> goalfrequency =page.querySelectorAll("//span[@class='mat-option-text']");
//		for (ElementHandle goalfreq : goalfrequency) {
//			String targetfrequency=goalfreq.innerText().trim();
//			if(targetfrequency.equalsIgnoreCase(actualfrequency[i])) {
//				goalfreq.click();
//				break;
//			}
//		}
//		page.locator("(//input[@formcontrolname='startDate'])["+ (i+2) +"]").click();
//		selectcalander(actualstartdate[i]);
//		page.locator("(//input[@formcontrolname='endDate'])["+ (i+2) +"]").click();
//		selectcalander(actualenddate[i]);
//		Locator empdropdrown=page.locator("(//mat-select[@id='goalAssignEmps'])[2]");
//		if(empdropdrown.isVisible()) {
//			empdropdrown.click();
//			page.locator("//mat-option[@aria-selected='true']").click();
//			List<ElementHandle> empslist=page.querySelectorAll("//span[@class='mat-option-text']");
//			for(int j=1;j<=actualempnames.length;j++) {
//			for (ElementHandle emplist : empslist) {
//				
//				if(emplist.innerText().contains(actualempnames[j-1])) {
//					emplist.click();
//					break;
//				}
//			}
//			}
//			page.keyboard().press("Escape");
//		}
//		
//		page.locator("(//textarea[@formcontrolname='subgoalDescription'])["+ (i+2) +"]").fill(actualkeypoint[i]);
//		List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
//		if(!subgoals.isEmpty()) {
//			
//			for (ElementHandle subgoal : subgoals) {
//				subgoal.fill(subgoaldata);
//			}
//		}
//		
//		Locator addtolist=page.locator("//button[text()='Add to list']");
//		if(addtolist.isVisible()) {
//		page.locator("//button[text()='Add to list']").click();
//		System.out.println("added to list");
////		page.locator("//button[text()='Publish goal']").click();
//		}
//		}
//		else {
//			
//			List<ElementHandle> targetdrodowns=page.querySelectorAll("//span[@class='mat-option-text']");
//			for (ElementHandle targetdropdown : targetdrodowns) {
//				String targetelement=targetdropdown.innerText();
//				if(targetelement.equalsIgnoreCase(actualtargettype[i])) {
//					targetdropdown.click();
//					break;
//				}
//			}
//			page.locator("(//mat-select[@formcontrolname='bandType'])["+(i+1)+"]").click();
//			List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
//			for (ElementHandle bandtype1 : bandtypes) {
//				String targetbandtype=bandtype1.innerText().trim();
//				if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
//					bandtype1.click();
//					break;
//				}
//			}
//			
//			page.locator("(//input[@formcontrolname='weightage'])["+ (i+2) +"]").fill(actualweightage[i]);
//			page.locator("(//mat-select[@formcontrolname='type'])["+ (i+2) +"]").click();
//			List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
//			for (ElementHandle goaltype1 : goaltypes) {
//				String targetgoaltype=goaltype1.innerText().trim();
//				if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
//					goaltype1.click();
//					break;
//				}
//			}
//			
//			page.locator("(//textarea[@formcontrolname='kpi'])["+ (i+2) +"]").fill(actualgoalkpi[i]);
//			page.locator("(//textarea[@formcontrolname='target'])["+ (i+2) +"]").fill(actualtarget[i]);
//			page.locator("(//mat-select[@formcontrolname='subGoalFrequency'])["+ (i+2) +"]").click();
//			List<ElementHandle> goalfrequency =page.querySelectorAll("//span[@class='mat-option-text']");
//			for (ElementHandle goalfreq : goalfrequency) {
//				String targetfrequency=goalfreq.innerText().trim();
//				if(targetfrequency.equalsIgnoreCase(actualfrequency[i])) {
//					goalfreq.click();
//					break;
//				}
//			}
//			page.locator("(//input[@formcontrolname='startDate'])["+ (i+2) +"]").click();
//			selectcalander(actualstartdate[i]);
//			page.locator("(//input[@formcontrolname='endDate'])["+ (i+2) +"]").click();
//			selectcalander(actualenddate[i]);
//			
//			Locator empdropdrown=page.locator("(//mat-select[@id='goalAssignEmps'])[2]");
//			if(empdropdrown.isVisible()) {
//				empdropdrown.click();
//				page.locator("//mat-option[@aria-selected='true']").click();
//				List<ElementHandle> empslist=page.querySelectorAll("//span[@class='mat-option-text']");
//				for(int j=1;j<=actualempnames.length;j++) {
//				for (ElementHandle emplist : empslist) {
//					
//					if(emplist.innerText().contains(actualempnames[j-1])) {
//						emplist.click();
//						break;
//					}
//				}
//				}
//				page.keyboard().press("Escape");
//			}
//			
//			page.locator("(//textarea[@formcontrolname='subgoalDescription'])["+ (i+2) +"]").fill(actualkeypoint[i]);
//			List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
//			if(!subgoals.isEmpty()) {
//				
//				for (ElementHandle subgoal : subgoals) {
//					subgoal.fill(subgoaldata);
//				}
//			}
//			Locator addtolist=page.locator("//button[text()='Add to list']");
//			if(addtolist.isVisible()) {
//			addtolist.click();
//			System.out.println("added to list");
//			}
//		}
//		if(goal.isVisible()) {
//			page.locator("(//span[@class='mat-content'])[" + (i+1) + "]").click();
//		}
//		
//		if(i==actualtitle.length-1) {
//			
//		}
//		else {
//		page.locator("//div[text()='Add New Goal']").click();
//		}
//	}
//		
//		page.locator("//button[text()='Publish goal']").click();
//		ElementHandle successmessage=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
//     if(successmessage.isVisible()) {
//    	 System.out.println("goals created successfully");
//     }
//     else {
//    	 System.out.println("goals not created successfully");
//     }
//		goalcreation(goaltitle, targettype, bandtype, weightage, goaltype, goalKPI, target, goalfrequencey, startdate, enddate, keypoint, subgoaldata);
		
	goalcreation(goaltitle, targettype, bandtype, weightage, goaltype, goalKPI, target, goalfrequencey, startdate, enddate, empnames, keypoint, subgoaldata);
		
}
}