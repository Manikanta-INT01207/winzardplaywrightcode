package playwright;

import java.util.List;
import java.util.Random;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class Surveyfilling  extends BaseClass{

	public static void main(String[] args) {

		initializer();
		page.navigate("https://capgemini.winzard.io");

      
        page.locator("//input[@formcontrolname='username']").fill("manikantap+2@interbiz.in");

       
        page.locator("//input[@formcontrolname='password']").fill("Winzard@2024");

       
        page.locator("//span[@class='mat-button-wrapper']").click();

    
        try {
           page.waitForSelector("//p[text()='User does not exist.']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE));
                page.locator("//span[text()='Ok']").click(); // Click OK on error dialog
                page.locator("//span[text()='Login ']").click(); // Retry login
            
        } 
        catch (Exception ignored) {
          
        }
        page.locator("//mat-icon[text()='menu']").click();
        Locator engagement = page.locator("//span[text()='Workforce Wellbeing']");
        engagement.scrollIntoViewIfNeeded(); 
        engagement.click();
        page.waitForTimeout(4000);
        Locator startNow = page.locator("//button[text()='Start Now']");
        startNow.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        startNow.click();
//        Locator questionsHeader = page.locator("(//div[@class='parent-row ng-star-inserted'])[1]");
//        if (!questionsHeader.isVisible()) {
//          
//            page.locator("//span[text()='Insights']").click();
//            page.locator("//span[text()='Self']").click();
//            page.locator("//button[text()='Start Now']").click();
//        }
       
        page.waitForTimeout(5000);
        List<ElementHandle> questionDivs = page.querySelectorAll("//div[@class='goal-body-row ng-star-inserted'][.//mat-radio-button or .//span[@class='mat-checkbox-label'] or .//textarea]" );

        System.out.println("Filtered question count: " + questionDivs.size());

        for (int i = 0; i < questionDivs.size(); i++) {
            ElementHandle question = questionDivs.get(i); // Get current question block
            System.out.println(question.innerText()); // Print question text
            System.out.println(i);  // Print question index

        
            List<ElementHandle> radiobuttons = question.querySelectorAll("mat-radio-button");
            boolean clicked = false;

           Random randomnum= new Random();
            if(!radiobuttons.isEmpty()) {
				System.out.println(radiobuttons.size());
				int indexnum = randomnum.nextInt(radiobuttons.size());
				System.out.println("radio option: "+indexnum);
				ElementHandle radio=radiobuttons.get(indexnum);
				radio.click();
                  
                    page.waitForTimeout(500); 

                    try {
                        ElementHandle options = question.querySelector(".questions-secs.ng-star-inserted");

                        if (options != null && options.isVisible()) {

                            List<ElementHandle> checkboxes = options.querySelectorAll(".mat-checkbox-label");
                            if (!checkboxes.isEmpty()) {
                                
                                ElementHandle checkbox = checkboxes.get(randomnum.nextInt(checkboxes.size()));
                                checkbox.click();
                                System.out.println("Clicked follow-up checkbox: " + checkbox.innerText());
                            }

                    
                            ElementHandle textarea = options.querySelector("textarea[formcontrolname='description']");
                            if (textarea != null) {
                                textarea.fill("free text after selecting follow-up option");
                            }
                        }
                    } catch (Exception e) {
                        
                    }
                }
            
            else {
           
            	ElementHandle freetextqstns= question.querySelector("#qdescription");
            	freetextqstns.fill("free text answer ");
            }
            
            if(i==8) {
            	page.locator("#nextBtn").click();
            	
            }
            
            
            }
        page.locator("#QuestionSubmitBtn").click();
       ElementHandle message= page.waitForSelector("//p[@class='ng-star-inserted']",new Page.WaitForSelectorOptions().setTimeout(3000).setState(WaitForSelectorState.VISIBLE) );
       if(message.isVisible()) {
    	   
    	   System.out.println("survey successfully submitted");
       }
       else {
    	   System.out.println("survey not filled please cross check");
       }
       
		}
		

	}


