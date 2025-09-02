package playwright;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EngagementSurveyFilling {
    public static void main(String[] args) {
        // Step 1: Launch Playwright and create a browser instance
       Playwright playwright = Playwright.create();
            // Step 2: Launch Chromium browser (setHeadless(false) means UI will be visible)
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            
            // Step 3: Create a new browser context (like a fresh browser profile)
            BrowserContext context = browser.newContext(new Browser.NewContextOptions());

            // Step 4: Create a new tab/page within the browser
            Page page = context.newPage();
         

            // Step 5: Navigate to the given URL
            page.navigate("https://capgemini.winzard.io");

            // Step 6: Fill in the username
            page.locator("//input[@formcontrolname='username']").fill("manikantap+2@interbiz.in");

            // Step 7: Fill in the password
            page.locator("//input[@formcontrolname='password']").fill("Winzard@2024");

            // Step 8: Click the login button
            page.locator("//span[@class='mat-button-wrapper']").click();

            // Step 9: Handle "User does not exist" popup if it appears
            try {
                if (page.isVisible("//p[text()='User does not exist.']")) {
                    page.click("//span[text()='Ok']"); // Click OK on error dialog
                    page.click("//span[text()='Login ']"); // Retry login
                }
            } catch (Exception ignored) {
                // No action needed if the error doesn't show
            }

            // Step 10: Click on the hamburger menu icon
            page.locator("//mat-icon[text()='menu']").click();

            // Step 11: Locate the "Workforce Engagement" menu item
            Locator engagement = page.locator("//span[text()='Workforce Wellbeing']");

            // Step 12: Scroll to the menu item to make sure it's visible
            engagement.scrollIntoViewIfNeeded(); 

            // Step 13: Click the "Workforce Engagement" option
            engagement.click();

            // Step 14: Wait for the "Start Now" button to appear and then click it
            Locator startNow = page.locator("//button[text()='Start Now']");
            startNow.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            startNow.click();

            // Step 15: Check if the Questions section is visible; if not, navigate differently
            Locator questionsHeader = page.locator("(//div[text()='Questions'])[1]");

            if (!questionsHeader.isVisible()) {
                // Step 16: Go through Insights > Self path
                page.click("//span[text()='Insights']");
                page.click("//span[text()='Self']");
                page.click("//button[text()='Start Now']");
            }
            //page.pause();
            page.waitForTimeout(5000); // waits for 10 seconds
            // Step 17: Collect all question blocks that contain radio buttons, checkboxes, or textareas
            List<ElementHandle> questionDivs = page.querySelectorAll("//div[@class='goal-body-row ng-star-inserted'][.//mat-radio-button or .//span[@class='mat-checkbox-label'] or .//textarea]" );

            // Step 18: Print total number of filtered questions
            System.out.println("Filtered question count: " + questionDivs.size());

            // Step 19: Iterate over each question
            for (int i = 0; i < questionDivs.size(); i++) {
                ElementHandle question = questionDivs.get(i); // Get current question block
                System.out.println(question.innerText()); // Print question text
                System.out.println(i);  // Print question index

                // Step 20: Find all radio buttons in the question
             // Step 20: Find all radio buttons in the question
                List<ElementHandle> radiobuttons = question.querySelectorAll("mat-radio-button");
                boolean clicked = false;

//                if (!radios.isEmpty()) {
//                    // Filter enabled radio buttons
//                    List<ElementHandle> enabledRadios = new ArrayList<>();
//                    for (ElementHandle radio : radios) {
//                        String classAttr = radio.getAttribute("class");
//                        if (classAttr == null || !classAttr.contains("mat-radio-disabled")) {
//                            enabledRadios.add(radio);
//                        }
//                    }
//
//                    if (!enabledRadios.isEmpty()) {
//                        // Randomly pick one enabled radio and click
//                        ElementHandle selectedRadio = enabledRadios.get(new Random().nextInt(enabledRadios.size()));
//                        selectedRadio.click();
//                        clicked = true;
               Random randomnum= new Random();
                if(!radiobuttons.isEmpty()) {
    				System.out.println(radiobuttons.size());
    				int indexnum = randomnum.nextInt(radiobuttons.size());
    				System.out.println(indexnum);
    				ElementHandle radio=radiobuttons.get(indexnum);
    				radio.click();
                        // After clicking radio, check if follow-up options are now visible
                        page.waitForTimeout(500); // Wait briefly for dynamic content to load

                        try {
                            ElementHandle options = question.querySelector(".questions-secs.ng-star-inserted");

                            if (options != null && options.isVisible()) {
                                // Look for checkboxes
                                List<ElementHandle> checkboxes = options.querySelectorAll(".mat-checkbox-label");
                                if (!checkboxes.isEmpty()) {
                                    // Click a random checkbox
                                    ElementHandle checkbox = checkboxes.get(new Random().nextInt(checkboxes.size()));
                                    checkbox.click();
                                    System.out.println("Clicked follow-up checkbox: " + checkbox.innerText());
                                }

                                // Look for textarea
                                ElementHandle textarea = options.querySelector("textarea[formcontrolname='description']");
                                if (textarea != null) {
                                    textarea.fill("free text after selecting follow-up option");
                                }
                            }
                        } catch (Exception e) {
                            // Safe to ignore — optional follow-up not present
                        }
                    }
                }

        }
    }
