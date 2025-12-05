package stepDefnitions.goalAchiever;

import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class bulkUploadSD extends BaseClass{

	@Then("admin goes to bulk goals tab then goes to upload in it")
	public void admin_goes_to_bulk_goals_tab_then_goes_to_upload_in_it() {
	    
		page.locator("button[data-toggle='minimize']").click();
		page.getByText("Goal Achiever").click();
		page.getByText("Bulk Goals").click();
		page.getByText("Upload").click();
		
	}
	@Then("admin downloads the all the templates later uploads the bulk goals through respective template {string}")
	public void admin_downloads_the_all_the_templates_later_uploads_the_bulk_goals_through_respective_template(String excelPath) {
page.locator("(//mat-select[@role='listbox'])[5]").click();
		
		List<ElementHandle>options=page.querySelectorAll("//mat-option");
		for(int i=1;i<=options.size();i++) {
			page.locator("(//mat-option[contains(@class,'mat-option')])["+i+"]").click();
			page.locator("//button[@class='custom-btn blue-btn']").click();
			page.locator("(//mat-select[@role='listbox'])[5]").click();
			if (i==options.size()) {
				page.keyboard().press("Escape");
			}
		}
	    page.locator("(//input[@type='file'])[2]").setInputFiles(Paths.get(excelPath));
        page.locator("//mat-icon[text()='check']").click();
        
        Locator message=page.getByText("Goals Uploaded Successfully.");
	    message.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
	    
	    assertTrue("goals not uploaded successfully please check it", message.isVisible());

		
	}

	
	
}
