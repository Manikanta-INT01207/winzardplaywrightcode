package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import base.BaseClass;

public class survey extends BaseClass {

	public static void main(String[] args) {
		initializer();
		
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("[formcontrolname='username']").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator(".mat-button-wrapper").click();
		
		
	}
}
