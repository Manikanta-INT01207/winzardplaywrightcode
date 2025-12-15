package stepDefnitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.nio.file.Files;
import java.nio.file.Path;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Video;
import com.microsoft.playwright.options.ScreenshotType;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
public class Hooksteps extends BaseClass {
    
	@Before
	public void setup() {
         initializer();
         page.navigate("https://capgemini.247hrm.co/");
//         page.locator("//input[@formcontrolname='username']").fill("anirudha@interbiz.in");
//         page.locator("//input[@formcontrolname='password']").fill("Winzard@2024");
//         page.locator("//span[@class='mat-button-wrapper']").click();
//         try {
//             page.waitForSelector("//p[text()='User does not exist.']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE));
//                  page.locator("//span[text()='Ok']").click(); // Click OK on error dialog
//                  page.locator("//span[text()='Login ']").click(); // Retry login
//              
//          } 
//          catch (Exception ignored) {
//            
//          }
	}
	
	@After
	public void teardown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        try {
	            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setType(ScreenshotType.PNG).setFullPage(true));
	            Allure.addAttachment("Screenshot - " + scenario.getName(), new ByteArrayInputStream(screenshot));
	        } catch (Exception e) {
	            System.err.println("Failed to take screenshot: " + e.getMessage());
	        }
	    }

	    try {
	        Video video = page.video();
	        
	        if (video != null) {
	            page.context().close(); 

	            // Now the video file is ready to be read
	            Path videoPath = video.path();
	            byte[] videoBytes = Files.readAllBytes(videoPath);
	            Allure.addAttachment("Execution Video - " + scenario.getName(), "video/webm", new ByteArrayInputStream(videoBytes), ".webm");
	            System.out.println("Video saved and attached: " + videoPath);
	        }
	    } catch (Exception e) {
	        System.err.println("Failed to save video: " + e.getMessage());
	    } finally {
	        // 3. Ensure browser and playwright are always closed, even if video attachment fails
	        try {
	            if (browser != null) {
	                browser.close();
	            }
	        } catch (Exception e) {
	            System.err.println("Failed to close browser: " + e.getMessage());
	        }
	        try {
	            if (playwrightt != null) {
	                playwrightt.close();
	            }
	        } catch (Exception e) {
	            System.err.println("Failed to close playwright: " + e.getMessage());
	        }
	    }
	}
}
