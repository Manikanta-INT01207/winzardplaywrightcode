package playwright;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;

import base.BaseClass;

public class searchGoal extends BaseClass{

	static String goalname="goal-1";
	static String empcode="CAP-01";
	static String goaltab="My goals";
	public static void main(String[] args) {

		
		
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
			 
		
		
	 // team goals 
		
	  page.locator("//span[normalize-space()='Bulk Goals']").click();
//	  page.waitForTimeout(4000);
//	  Locator leftpanel=page.locator("//div[contains(@class,'cutsom-leftPanel')]");
//		if(!leftpanel.isVisible()) {
//			page.locator("//mat-icon[text()='refresh']").click();
//			leftpanel.waitFor();
//
//		}
//		page.locator("#emp-search-bar").click();
//		page.locator("#emp-search-bar").fill(empcode);
//		page.locator("//div[@class='name']").click();
	
	  page.locator("//input[@id='org-level-emp-search-bar']").click();
	  page.locator("//input[@id='org-level-emp-search-bar']").fill(empcode);
	  page.locator("//span[contains(text(),'"+empcode+"')]").click();
	  
		Locator searchbar1=page.locator("//input[@id='search-bar-empid']");
		searchbar1.click();
		searchbar1.fill(goalname);
		searchbar1.press("Enter");
		Locator goals2=page.locator("//tr[contains(@class,'row-ACTIVE')]");
		assertEquals("Expected exactly one active goal row", 1, goals2.count());

		if(goals2.count()>1) {
			System.out.println("search functionality failed");
		}
		else {
		
			page.locator("//td[normalize-space()='"+goalname+"']").click();
			System.out.println("search functionality working fine");
			page.locator("//mat-icon[text()='close']").click();
		}
		searchbar1.clear();
		 assertEquals("Search bar should be empty.", "", searchbar1.inputValue());
			assertTrue("Expected more than one active goal row", goals2.count() > 1);
		if(goals2.count()>1) {
			System.out.println("search clear functionality working fine");
		}
		else {
			System.out.println("search clear functionality failed");

		}
		
		searchbar1.click();
		searchbar1.fill(goalname);
		searchbar1.press("Enter");
		page.locator("//mat-icon[text()='arrow_back']").click();
		 page.locator("//input[@id='org-level-emp-search-bar']").click();
		  page.locator("//input[@id='org-level-emp-search-bar']").fill(empcode);
		  page.locator("//span[contains(text(),'"+empcode+"')]").click();
			assertTrue("Expected more than one active goal row", goals2.count() > 1);

		  
//		searchbar1.fill(goalname);
//		searchbar1.press("Enter");
//		page.locator("//div[@class='name']").click();
//		 assertEquals("Search bar should be empty.", "", searchbar1.inputValue());
//			assertTrue("Expected more than one active goal row", goals2.count() > 1);
//			
		
		//searchgoal("goal-2", "Team Goals");
		
	}
	public static void searchgoal(String goalname){
		
		
		Locator searchbar=page.locator("//input[@id='search-bar-empid']");
		searchbar.click();
		searchbar.fill(goalname);
		searchbar.press("Enter");
		Locator goals=page.locator("//tr[contains(@class,'row-ACTIVE')]");
		assertEquals("Expected exactly one active goal row", 1, goals.count());

		if(goals.count()>1) {
			System.out.println("search functionality failed");
		}
		else {
		
			page.locator("//td[normalize-space()='"+goalname+"']").click();
			System.out.println("search functionality working fine");
			page.locator("//mat-icon[text()='close']").click();
		}
		searchbar.clear();
		assertTrue("Expected more than one active goal row", goals.count() > 1);

		if(goals.count()>1) {
			System.out.println("search clear functionality working fine");
		}
		else {
			System.out.println("search clear functionality failed");

		}
		
		searchbar.click();
		searchbar.fill(goalname);
		searchbar.press("Enter");
		Locator goals1=page.locator("//tr[contains(@class,'row-ACTIVE')]");
		assertEquals("Expected exactly one active goal row", 1, goals1.count());
		if(goals1.count()>1) {
			System.out.println("search functionality failed");
		}
		else {
		
			page.locator("//td[normalize-space()='"+goalname+"']").click();
			System.out.println("search functionality working fine");
			page.locator("//mat-icon[text()='close']").click();
		}
		page.locator("//span[normalize-space()='Insights']").click();
		page.locator("//span[normalize-space()='My goals']").click();
		String searchText=searchbar.inputValue();
	 System.out.println("search bar text:"+searchbar.inputValue());
	 assertEquals("Search bar should be empty.", "", searchText);
	 
	}

}
