package playwright;

import static org.junit.Assert.assertTrue;

import base.BaseClass;

public class deleteempsBulkgoals extends BaseClass{

	public static void main(String[] args) {
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.locator("//span[normalize-space(text())='Bulk Goals']").click();
		page.locator("#bulk-goal-creation").click();
		page.locator("(//mat-icon[normalize-space(text())='close'])[2]").click();
		page.locator("#bulk-goal-creation").click();
		page.waitForTimeout(3000);
		
		choosefilter("Grade","Grade A");
		addingEmpsThroughIds("CAP-01,CAP-02");
		String EmpIDemp=page.locator("//mat-card//span[@class='title']").last().textContent();
		
		page.waitForTimeout(2000);
		selectCustomEmployee("CAP-37");
		String customemp=page.locator("//mat-card//span[@class='title']").last().textContent();
		System.out.println(customemp);
		System.out.println("//mat-card//span[text()='"+customemp+"']");
		page.locator("//mat-icon[normalize-space(text())='cancel']").click();
		assertTrue("employee not displayed after emps added throuh filters ",page.locator("//mat-card//span[text()='"+customemp+"']").isVisible());
		assertTrue("empID employee not displayed after adding emps through filters  ",page.locator("//mat-card//span[text()='"+EmpIDemp+"']").isVisible());

		
	}

}
