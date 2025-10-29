package playwright;

import static org.junit.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.ElementHandle.ScrollIntoViewIfNeededOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class CreateForms extends BaseClass{

	public static void main(String[] args) {
		
		initializer();
		page.navigate("https://capgemini.winzard.io/authentication");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//mat-icon[normalize-space(text())='menu']").click();
		Locator pms=page.locator("//span[text()='Performance Management']");
		pms.scrollIntoViewIfNeeded();
		pms.click();
        page.locator("//a[normalize-space(text())='Global Configuration']").click();
        page.locator("//div[text()='Create Forms']").click();
        page.locator("//button[normalize-space(text())='+ Start New']").click();
        String formtitle="dummy-1";
        page.locator("//input[@formcontrolname='title']").fill(formtitle);
        
        int sectioncount=3;
        String [] sectiontitle= {"sectn-1","sectn-2","sectn-3"};
        String []sectiontypee={"Rating & Comment","Rating Scale","others"};
        String [] weightagee={"30","40",""};
        String [] subqstnstyps= {"Long","Short","dropdown"};
        String [] dropdownquestionoptions= {"1","2","3","4"};

        String []aa1= {"q1","q2"};
        String []bb1={"a1","a2","a3"};
        
        String[] []ratingAndratingcommentQuestions= {aa1,bb1};
        String[] []ratingAndratingCommentdescriptions= {{"d1","d2"},{"f1","f2","f3"}};
        
        for(int a=0;a<sectioncount;a++) {
        
        	if(sectiontypee[a].equalsIgnoreCase("others")) {
        page.locator("//button[normalize-space(text())='+ Add Sections']").click();
        page.locator("//mat-panel-title[@class='mat-expansion-panel-header-title']").last().click();
        page.locator("//textarea[@formcontrolname='parameterTitle']").last().fill(sectiontitle[a]);
        page.locator("//mat-select[@role='listbox']").last().click();
        
      
        int qcount=3;
        String [] othersSecquestions= {"long question","short question","dropdown question"};
        String[] othersSecdescription= {"long desc","short desc","drop down desc"};
        List<ElementHandle>sectionTypes=page.querySelectorAll("//span[@class='mat-option-text']");
        for (ElementHandle sctntyp : sectionTypes) {
			
        if(	sctntyp.innerText().equalsIgnoreCase(sectiontypee[a])) {
        	sctntyp.click();

        	break;
        }
        	
		}
        
        for(int i=0;i<qcount;i++) {
        
        page.locator("//button[text()='+Add Question']").last().click();
        page.locator("//textarea[@formcontrolname='questionTitle']").last().fill(othersSecquestions[i]);
        page.locator("//textarea[@formcontrolname='description']").last().fill(othersSecdescription[i]);
        page.locator("//div[@class='mat-select-value']").last().click();
        
        List<ElementHandle> subquestiontypes=page.querySelectorAll("//span[@class='mat-option-text']");
        for (ElementHandle subqstntypes : subquestiontypes) {
        	
			if (subqstntypes.innerText().contains(subqstnstyps[i])) {
				subqstntypes.click();
				System.out.println("element clicked "+subqstntypes.innerText());
				break;
			}
			
			
		}
        if (subqstnstyps[i].equalsIgnoreCase("dropdown")) {
        	
        	for(int c=0;c<dropdownquestionoptions.length;c++) {
			page.locator("//input[@placeholder='Add New options...']").click();
			page.locator("//input[@placeholder='Add New options...']").fill(dropdownquestionoptions[c]);
			page.keyboard().press("Enter");
        	}
		}
        }
        
        	}
        	else {
        		
        		page.locator("//button[normalize-space(text())='+ Add Sections']").click();
                page.locator("//mat-panel-title[@class='mat-expansion-panel-header-title']").last().click();
                page.locator("//textarea[@formcontrolname='parameterTitle']").last().fill(sectiontitle[a]);
                page.locator("//mat-select[@role='listbox']").last().click();
                
              
               
             
               // String [] questions= {"Question-1","question-2","Question-3"};
               // String[] description= {"desc-1","desc-2","desc-3"};
                List<ElementHandle>sectionTypes=page.querySelectorAll("//span[@class='mat-option-text']");
                for (ElementHandle sctntyp : sectionTypes) {
        			
                if(	sctntyp.innerText().equalsIgnoreCase(sectiontypee[a])) {
                	sctntyp.click();
                	Locator weightage=page.locator("//input[@formcontrolname='weightage']").last();
                	if (weightage.isVisible()) {
        				weightage.fill(weightagee[a]);
        			}
                	break;
                }
                	
        		}
                
          
                	
                	String[] secquestns=ratingAndratingcommentQuestions[a];
                	String[] secdesc=ratingAndratingCommentdescriptions[a];
                	for(int f=0;f<secquestns.length;f++) {
                		page.locator("//button[text()='+Add Question']").last().click();
                        page.locator("//textarea[@formcontrolname='questionTitle']").last().fill(secquestns[f]);
                        page.locator("//textarea[@formcontrolname='description']").last().fill(secdesc[f]);
                	}
                	
                
                
                
                
                
                
//                for(int i=0;i<a;i++) {
//                
//                page.locator("//button[text()='+Add Question']").last().click();
//                page.locator("//textarea[@formcontrolname='questionTitle']").last().fill(questions[i]);
//                page.locator("//textarea[@formcontrolname='description']").last().fill(description[i]);
//                
//                
//                }
//                
        		
        		
        		
        	}
	}
        
        page.locator("//button[normalize-space()='Save']").click();
        Locator saveButton = page.locator("//button[normalize-space()='Save']");
        saveButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertTrue("form not created",saveButton.isVisible() );
	}
}
