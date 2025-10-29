package stepDefnitions.PMS;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class CreateFomsSD extends BaseClass{

	@Then("admin goes to PMS module")
	public void admin_goes_to_pms_module() {
		page.locator("//mat-icon[normalize-space(text())='menu']").click();
		Locator pms=page.locator("//span[text()='Performance Management']");
		pms.scrollIntoViewIfNeeded();
		pms.click();	
	}
	@Then("admin goes to global configuration tab then goes to create forms tab")
	public void admin_goes_to_global_configuration_tab_then_goes_to_create_forms_tab() {
		 page.locator("//a[normalize-space(text())='Global Configuration']").click();
	       
	       
		
	}
	@Then("admin clicks on the start new to create a new form")
	public void admin_clicks_on_the_start_new_to_create_a_new_form() {
	    
		 page.locator("//div[text()='Create Forms']").click();
	        page.locator("//button[normalize-space(text())='+ Start New']").click();
	}
	@Then("admin adds the sections {string}, {string} , {string} , {string} ,{string} , {string}, {string}, {string} , {string} , {string}, {string}, {string}, {string}")
	public void admin_adds_the_sections(String formtitle, String sectionscount, String sectiontypes, String sectiontitle, String weightage, String othersSecquestions, String othersSecdescription, String subqstnstyps, String dropdownquestionoptions, String ratingQuestions, String ratingDescriptions, String ratingCommentQuestions, String ratingCommentQuestionsDescription) {
	    
page.locator("//input[@formcontrolname='title']").fill(formtitle);
        
        int sectioncount=3;
        String [] sectionTitle= sectiontitle.split(",");
        String []sectiontypee=sectiontypes.split(",");
        String [] weightagee=weightage.split(",");
        String [] subqstnstypes= subqstnstyps.split(",");
        String [] dropdownquestionOptions= dropdownquestionoptions.split(",");

        String []ratequestions= ratingQuestions.split(",");
        String []ratecommentquestion=ratingCommentQuestions.split(",");
        
        String [] ratedesc= ratingDescriptions.split(",");
        String [] ratecommentdesc= ratingCommentQuestionsDescription.split(",");
        
        String[] []ratingAndratingcommentQuestions= {ratequestions,ratecommentquestion};
        String[] []ratingAndratingCommentdescriptions= {ratedesc,ratecommentdesc};
        
        for(int a=0;a<sectioncount;a++) {
        
        	if(sectiontypee[a].equalsIgnoreCase("others")) {
        page.locator("//button[normalize-space(text())='+ Add Sections']").click();
        page.locator("//mat-panel-title[@class='mat-expansion-panel-header-title']").last().click();
        page.locator("//textarea[@formcontrolname='parameterTitle']").last().fill(sectionTitle[a]);
        page.locator("//mat-select[@role='listbox']").last().click();
        
      
        int qcount=3;
        String [] otherssecquestions= othersSecquestions.split(",");
        String[] otherssecdescription= othersSecdescription.split(",");
        List<ElementHandle>sectionTypes=page.querySelectorAll("//span[@class='mat-option-text']");
        for (ElementHandle sctntyp : sectionTypes) {
			
        if(	sctntyp.innerText().equalsIgnoreCase(sectiontypee[a])) {
        	sctntyp.click();

        	break;
        }
        	
		}
        
        for(int i=0;i<qcount;i++) {
        
        page.locator("//button[text()='+Add Question']").last().click();
        page.locator("//textarea[@formcontrolname='questionTitle']").last().fill(otherssecquestions[i]);
        page.locator("//textarea[@formcontrolname='description']").last().fill(otherssecdescription[i]);
        page.locator("//div[@class='mat-select-value']").last().click();
        
        List<ElementHandle> subquestiontypes=page.querySelectorAll("//span[@class='mat-option-text']");
        for (ElementHandle subqstntypes : subquestiontypes) {
        	
			if (subqstntypes.innerText().contains(subqstnstypes[i])) {
				subqstntypes.click();
				System.out.println("element clicked "+subqstntypes.innerText());
				break;
			}
			
			
		}
        if (subqstnstypes[i].equalsIgnoreCase("dropdown")) {
        	
        	for(int c=0;c<dropdownquestionOptions.length;c++) {
			page.locator("//input[@placeholder='Add New options...']").click();
			page.locator("//input[@placeholder='Add New options...']").fill(dropdownquestionOptions[c]);
			page.keyboard().press("Enter");
        	}
		}
        }
        
        	}
        	else {
        		
        		page.locator("//button[normalize-space(text())='+ Add Sections']").click();
                page.locator("//mat-panel-title[@class='mat-expansion-panel-header-title']").last().click();
                page.locator("//textarea[@formcontrolname='parameterTitle']").last().fill(sectionTitle[a]);
                page.locator("//mat-select[@role='listbox']").last().click();
                
              
               
             
               // String [] questions= {"Question-1","question-2","Question-3"};
               // String[] description= {"desc-1","desc-2","desc-3"};
                List<ElementHandle>sectionTypes=page.querySelectorAll("//span[@class='mat-option-text']");
                for (ElementHandle sctntyp : sectionTypes) {
        			
                if(	sctntyp.innerText().equalsIgnoreCase(sectiontypee[a])) {
                	sctntyp.click();
                	Locator weightage1=page.locator("//input[@formcontrolname='weightage']").last();
                	if (weightage1.isVisible()) {
        				weightage1.fill(weightagee[a]);
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
       	
        	}
	}
        
        page.locator("//button[normalize-space()='Save']").click();
        Locator successmessage = page.locator("//p[text()='Form created successfully']");
        successmessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertTrue("form not created",successmessage.isDisabled() );
		
		
	}
	
}
