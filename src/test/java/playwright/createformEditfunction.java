package playwright;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BaseClass;

public class createformEditfunction extends BaseClass {

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

		String FORM="dum";
		String formtitle="dumm";
		String [] sectiontitle= {"sectn-1","sectn-2","sectn-3"};
		String []sectiontypee={"Rating & Comment","Rating Scale","others"};
		String [] weightagee={"30","40",""};
		String [] subqstnstyps= {"Long","Short","dropdown"};
		String [] dropdownquestionoptions= {"1","2","3","4"};

		String []aa1= {"q1","q2"};
		String []bb1={"a1","a2","a3"};

		String[] []ratingAndratingcommentQuestions= {aa1,bb1};
		String[] []ratingAndratingCommentdescriptions= {{"d1","d2"},{"f1","f2","f3"}};


		page.locator("//span[text()='"+FORM+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();

		page.locator("//input[@formcontrolname='title']").fill(formtitle);

		page.locator("//mat-expansion-panel-header[contains(@class,'valid')]").first().click();	

		for(int f=0;f<aa1.length;f++) {
			page.locator("//button[text()='+Add Question']").last().click();
			page.locator("//textarea[@formcontrolname='questionTitle']").last().fill(aa1[f]);
			page.locator("//textarea[@formcontrolname='description']").last().fill(bb1[f]);
		}
		page.locator("//button[text()='Save']").click();
		Locator successmessage=page.locator("//p[text()='Form updated successfully']");
		successmessage.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		assertTrue("unable to edit the forms", successmessage.isVisible());

		page.locator("//span[text()='"+formtitle+"']/ancestor::div[@class='task-col ng-star-inserted']//mat-icon[text()='edit']").click();

		page.locator("//mat-expansion-panel-header[contains(@class,'valid')]").first().click();	
		
		Locator latestquestion=page.locator("//textarea[@formcontrolname='questionTitle']").last();
		latestquestion.scrollIntoViewIfNeeded();
        page.waitForTimeout(2000);
        page.locator("//mat-icon[text()='close']").click();


	}

}
