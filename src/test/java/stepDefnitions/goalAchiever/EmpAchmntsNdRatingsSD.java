package stepDefnitions.goalAchiever;

import java.util.List;
import java.util.Random;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EmpAchmntsNdRatingsSD extends BaseClass{

	@Given("Employee logs into their profile with {string} and {string}")
	public void employee_logs_into_their_profile_with_and(String username, String password) {
	    
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
	@Then("Employee goes to goal achiever module")
	public void employee_goes_to_goal_achiever_module() {
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		Locator table=page.locator("//table[@class='mat-table']");
		 table.waitFor();
		
		
	   	}

	@Then("employee gives his sub goal {string} to the active subgoals")
	public void employee_gives_his_sub_goal_to_the_active_subgoals(String achievement) {
	    

	    
		List<ElementHandle> goals=page.querySelectorAll("//mat-icon[contains(@class,'edit-icon')]");
		System.out.println(goals.size());
		for (int i=0;i<goals.size();i++) {
			page.locator("(//mat-icon[@id='edit-goal-btn'])["+(i+1)+"]").click();
		
		List<ElementHandle> subgoalsdata=page.querySelectorAll("//textarea[contains(@class,'valid') and contains(@formcontrolname,'subgoalAchievement')]");
		for (ElementHandle subgoals : subgoalsdata) {
			subgoals.fill(achievement);
			List<ElementHandle> ratingboxes =page.querySelectorAll("//div[@class='col-md-6 ng-tns-c26-16 ng-star-inserted']");
			for (ElementHandle ratingbox : ratingboxes) {
				List<ElementHandle> ratingss=ratingbox.querySelectorAll("//mat-icon[contains(@class,'active') and contains(@id,'self-rating')]");
				List<ElementHandle>ratings1=ratingbox.querySelectorAll("//div[@class='empty-ratings']");
				//System.out.println(ratingss.size());
				if(ratingss.isEmpty()&&ratings1.isEmpty()) {
					List<ElementHandle> targetratingss=ratingbox.querySelectorAll("//mat-icon");
					Random num=new Random();
					int randrating=num.nextInt(targetratingss.size());
					ElementHandle chooserating=targetratingss.get(randrating);
					chooserating.click();
					
					break;
				}
			}
		}
		page.locator("//span[text()='Save']").click();
		ElementHandle successmessage=page.waitForSelector("//p[text()='Goals Updated Succesfully!!']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		if(successmessage.isVisible()) {
			System.out.println("successfully given the data");
		}
		else {
			System.out.println("data is not given please check the code");
		}
		ElementHandle successmessage1=page.waitForSelector("//p[@class='confirm-txt']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.DETACHED));

		page.locator("//mat-icon[text()='close']").click();
		}

		
	}


}
