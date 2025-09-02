package playwright;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class generateInsights extends BaseClass {

	public static void main(String[] args) {
		
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("//span[@class='mat-button-wrapper']").click();
		page.locator("//mat-icon[text()='menu']").click();
		Locator wellbeing=page.locator("//span[text()='Workforce Wellbeing']");
		wellbeing.scrollIntoViewIfNeeded();
		wellbeing.click();
		page.locator("//span[text()='Org']").click();
		ElementHandle header= page.waitForSelector("//tr[@class='mat-header-row ng-star-inserted']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
//     		
		String startDate = "May 20, 2025";
		String endDate = "May 30, 2025";

/*
		// XPath that finds a row with both start and end date
		
		page.locator("//mat-select[@aria-label='Items per page:']").click();
		page.locator("//span[text()='100']").click();
		
		List<ElementHandle> insight=page.querySelectorAll("//tr[td[normalize-space(text())='" + startDate + "'] and td[normalize-space(text())='" + endDate + "']]");
      System.out.println(insight.size());
		ElementHandle insightss=insight.get(0);
      ElementHandle generateinsight=insightss.querySelector("//span[text()='Generate']");
      generateinsight.click();
      page.waitForTimeout(2000);
      int j=3;
      String a = "Leadership,SuperAdmin,Custom Employees";
      String b[]=a.split(",");
      List<ElementHandle>checkboxesss =page.querySelectorAll("mat-checkbox");
      System.out.println(checkboxesss.size());
      for(int i =0; i<j;i++) {
//    	
//    	
//    	  
    	  for (ElementHandle checkbox : checkboxesss) {
//			
    		  ElementHandle targetcheckbox=checkbox.querySelector("span");
    		  if(targetcheckbox.innerText().equals(b[i])) {
    			  if(!targetcheckbox.isChecked()) {
    			  targetcheckbox.click();
    			  }
    		  
    		  if(b[i].equalsIgnoreCase("Custom Employees")) {
    			  
    			  page.locator("//input[@id='autoComplete']").click();
    			  page.locator("//input[@id='autoComplete']").fill("CAP-37");
    			  page.locator("//span[@class='mat-option-text']").click();

    		  }
    		  }
		}
    	  
     }
//      
//      
//      
//      
//      
            page.locator("#generateInsight").click();
//      
      Locator message=page.locator("//p[text()='Insight access updated successfully']");
      message.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
      if(message.isVisible()) {
    	  System.out.println("insights generated successfully");
      }
      else {
    	  System.out.println("insights not generated");
      }
      */
	      String a = "Leadership,SuperAdmin,Custom Employees";

int count = 3;
      String empid="CAP-37";
		
		generateInsights(startDate, endDate, count, a, empid);
		
	}
}
