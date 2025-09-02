package playwright;

import java.util.List;

import org.junit.Assert;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import base.BaseClass;

public class SelectedemployeeFeature extends BaseClass{

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
		page.waitForTimeout(2000);
//		choosefilter("Grade", "Grade-B");
//		page.waitForTimeout(3000);
//		Locator employee=page.locator("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		Assert.assertTrue("employee selection mismatched after adding the filters",employee.isVisible());
//		List<ElementHandle>firstcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		System.out.println("1st count"+firstcount.size());
//		addingEmpsThroughIds("CAP-01,CAP-03");
//		page.waitForTimeout(3000);
//		List<ElementHandle>secondcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		System.out.println("2nd count"+secondcount.size());
//		Assert.assertTrue("employee selection mismatched after adding the employee through ID's",secondcount.size()>firstcount.size());
//		selectCustomEmployee("CAP-37");
//		List<ElementHandle>thirdcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		int totalcount=(secondcount.size()+firstcount.size());
//		System.out.println("3rd count"+thirdcount.size());
//		Assert.assertTrue("employee selection mismatched after adding the custom employee",thirdcount.size()>totalcount);
//        

		
		// set 2 customemp > empID > filter
		
//		selectCustomEmployee("CAP-37");
//		Locator employee=page.locator("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		Assert.assertTrue("employee selection mismatched after adding the filters",employee.last().isVisible());
//		List<ElementHandle>firstcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		System.out.println("1st count: "+firstcount.size());
//		addingEmpsThroughIds("CAP-01,CAP-03");
//		page.waitForTimeout(3000);
//		List<ElementHandle>secondcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		System.out.println("2nd count: "+secondcount.size());
//		Assert.assertTrue("employee not displayed ",employee.last().isVisible());
//
//		Assert.assertTrue("employee selection mismatched after adding the employee through ID's",secondcount.size()>firstcount.size());
//
//		choosefilter("Grade","Grade-B");
//		List<ElementHandle>thirdcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
//		int totalcount=(secondcount.size()+firstcount.size());
//		System.out.println("3rd count"+thirdcount.size());
//		//Assert.assertTrue("employee not displayed ",employee.last().isVisible());
//
//		Assert.assertTrue("employee selection mismatched after adding the custom employee",thirdcount.size()>totalcount);
//     

		addingEmpsThroughIds("CAP-01,CAP-03");
		Locator employee=page.locator("//mat-card[@class='custom-card mat-card ng-star-inserted']");
		Assert.assertTrue("employee selection mismatched after adding the filters",employee.last().isVisible());
		List<ElementHandle>firstcount=page.querySelectorAll("//mat-card[@class='custom-card mat-card ng-star-inserted']");
		System.out.println("1st count: "+firstcount.size());
		

		
		
		
		
	}

}
