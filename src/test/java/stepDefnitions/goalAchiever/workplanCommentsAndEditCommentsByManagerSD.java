package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class workplanCommentsAndEditCommentsByManagerSD extends BaseClass{

	@Then("goes to the team goals and search the employee goals using {string}")
	public void goes_to_the_team_goals_and_search_the_employee_goals_using(String empID) {
	    
		page.getByText("Team Goals").click();
		Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
		if(!leftpanel.isVisible()) {
			page.locator("//mat-icon[text()='refresh']").click();
			leftpanel.waitFor();
		}
		page.locator("#emp-search-bar").click();
		page.locator("#emp-search-bar").fill(empID);
		page.locator("//div[@class='name']").click();

		Locator table=page.locator("//table[@class='mat-table']");
		table.waitFor();

	}
	@Then("opens the particular goal and views the workplan of that goal then gives the {string} and {string}")
	public void opens_the_particular_goal_and_views_the_workplan_of_that_goal_then_gives_the_and(String supervisorcomments, String supervisoroverallcomments) {
	    
		page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
		page.locator("#workplan-edit-icon").click();
        page.locator("#workPlancomments").fill(supervisorcomments);
        page.locator("#commentSupervisorDescription").fill(supervisoroverallcomments);
        page.getByText("Save").click();
		
		Locator confirmmsg = page.getByText("Workplan updated succesfully.");
		confirmmsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		assertTrue("workplan not created", confirmmsg.isVisible());

	    page.locator("#workplan-close-btn").click();
	}
	@Then("upadtes the {string} and {string}")
	public void upadtes_the_and(String updatedsupervisorcomments, String updatedsupervisoroverallcomments) {
	    
		page.locator("#workplan-edit-icon").click();
		 page.locator("#workPlancomments").fill(updatedsupervisorcomments);
	        page.locator("#commentSupervisorDescription").fill(updatedsupervisoroverallcomments);
	        page.getByText("Save").click();
			
			Locator confirmmsg2 = page.getByText("Workplan updated succesfully.");
			confirmmsg2.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
			assertTrue("workplan not created", confirmmsg2.isVisible());

		    page.locator("#workplan-close-btn").click();

	}

	
	
}
