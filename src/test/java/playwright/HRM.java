package playwright;

import java.nio.file.Paths;

import org.openqa.selenium.Keys;

import base.BaseClass;

public class HRM extends BaseClass{

	public static void main(String[] args) {
        initializer();
		page.navigate("https://qa-current.247hrmstaging.com:8452/#/login");
		page.locator("//input[@formcontrolname='employeeId']").fill("HR001");
		page.locator("//input[@formcontrolname='password']").fill("sys");
		page.locator("//span[normalize-space()='LOGIN']").click();
		page.locator("//div[@class='buttons']").click();
		page.locator("//mat-icon[text()='cloud_upload']").click();
		page.locator("//span[text()='Daily Attendance']").click();
		page.locator("//input[@placeholder='Select items']").click();
		page.locator("(//mat-checkbox[contains(@class,'checkbox')])[1]").click();
		page.waitForTimeout(2000);
		page.locator("(//input[@placeholder='Search'])[1]").fill("251203");
		page.keyboard().press("Enter");
        page.locator("//mat-checkbox[@class='mat-checkbox mat-accent']").click();
        page.locator("//div[@class='page-header']").click();
       // page.setInputFiles("input[type='file']", Paths.get("C:\\Users\\nrpra\\Downloads\\DailyAttendanceTemplate.xlsx"));
        page.locator("//input[@type='file']").setInputFiles(Paths.get("C:\\Users\\nrpra\\Downloads\\DailyAttendanceTemplate.xlsx"));

        page.locator("(//hrm-button[@class='ng-star-inserted'])[2]").click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
