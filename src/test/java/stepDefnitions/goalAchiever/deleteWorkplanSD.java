package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class deleteWorkplanSD extends BaseClass {


@Then("opens a goal to view the workplan then deletes the workplan")
public void opens_a_goal_to_view_the_workplan_then_deletes_the_workplan() {
    
	page.locator("(//mat-icon[text()=' navigate_next '])[1]").click();
	page.locator("//mat-icon[text()='delete']").click();
	page.getByText("YES").click();
	
	Locator msg=page.getByText("Workplan Deleted Succesfully!!");
	msg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
	assertTrue("workplan not deleted", msg.isVisible());
}

}
