package playwright;

import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class bulkUpload extends BaseClass{

	public static void main(String[] args) {

		//String xlpath="C:\\bulk upload +vedata\\MONTHLY Template (7).xlsx"; // monthly template path
		
	//	String xlpath="C:\\bulk upload +vedata\\QUARTERLY Template (9).xlsx";//quarterly template path
		
	//	String xlpath="C:\\bulk upload +vedata\\HALFYEARLY Template (2).xlsx";//halfyearly template path
		
		String xlpath="C:\\bulk upload +vedata\\YEARLY Template (1).xlsx";// yearly template
		
		initializer();
		page.navigate("https://capgemini.winzard.io/");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.getByText("LOGIN").click();
		page.locator("button[data-toggle='minimize']").click();
		page.getByText("Goal Achiever").click();
		page.getByText("Bulk Goals").click();
		page.getByText("Upload").click();
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
	    page.locator("(//input[@type='file'])[2]").setInputFiles(Paths.get(xlpath));
        page.locator("//mat-icon[text()='check']").click();
        
        Locator message=page.getByText("Goals Uploaded Successfully.");
	    message.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
	    
	    assertTrue("goals not uploaded successfully please check it", message.isVisible());
		
		
		
		
		
	}

}
