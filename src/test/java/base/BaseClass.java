package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

public class BaseClass {

	public static Playwright playwrightt ;
	public static Browser browser;
	public static Page page;
	public static void initializer() {
		playwrightt =Playwright.create();
		browser =playwrightt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null).setRecordVideoDir(Paths.get("videos/")).setRecordVideoSize(1280, 720));  
		page = context.newPage();		  
	}

	public static void selectdropdown(String value) {
		// List<WebElement> options=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@role='option']")));
		List<ElementHandle> options=page.querySelectorAll("//mat-option[@role='option']");
		for (ElementHandle option : options) {
			String text = option.innerText().trim();

			if(text.equalsIgnoreCase(value)) {
				option.click();
			}
		}
	} 

	public static void selectcalander(String date) {
		String startdate = date;

		//Split by hyphen
		String[] parts = startdate.split("-");

		String stday = parts[0];    // "01"
		String stmonth = parts[1];  // "apr"
		String styear = parts[2];   // "2024"

		//driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		page.locator("//button[@aria-label='Choose month and year']").click();
		//WebElement startyeartable=driver.findElement(By.xpath("//table[@class='mat-calendar-table']"));

		ElementHandle startyeartable = page.waitForSelector("//table[@class='mat-calendar-table']");

		//List<WebElement>startyearrows=startyeartable.findElements(By.tagName("tr"));
		List<ElementHandle> startyearrows =startyeartable.querySelectorAll("tr");
		for (ElementHandle styrrows : startyearrows) {
			List<ElementHandle>startyearcolumns=styrrows.querySelectorAll("td");
			for (ElementHandle styrcolmns : startyearcolumns) {
				String year=styrcolmns.innerText();
				if(year.equalsIgnoreCase(styear)) {
					styrcolmns.click();
					break;
				}
			}
		}

		ElementHandle  startmonthtable=page.waitForSelector("//table[@class='mat-calendar-table']");
		List<ElementHandle>startmonthrows=startmonthtable.querySelectorAll("tr");
		outer:
			for (ElementHandle stmnthrows : startmonthrows) {
				List<ElementHandle>startmonthcolumns=stmnthrows.querySelectorAll("td");
				for (ElementHandle stmnthcolmns : startmonthcolumns) {
					String month=stmnthcolmns.innerText();
					if(month.equalsIgnoreCase(stmonth)) {
						stmnthcolmns.click();
						break outer;
					}
				}
			}
		ElementHandle  startdatetable=page.waitForSelector("//table[@class='mat-calendar-table']");
		List<ElementHandle>startdaterows=startdatetable.querySelectorAll("tr");
		outer:
			for (ElementHandle stdtrows : startdaterows) {
				List<ElementHandle>startdatecolumns=stdtrows.querySelectorAll("td");
				for (ElementHandle stdtcolmns : startdatecolumns) {
					String datee=stdtcolmns.innerText();
					if(datee.equalsIgnoreCase(stday)) {
						stdtcolmns.click();
						break outer;
					}
				}
			}
	}

	//filters 
	public static void choosefilter(String leftPanelValue, String rightPanelValue) {

		// Click on the filter icon
		ElementHandle filterIcon = page.waitForSelector("//mat-icon[text()='filter_list']");
		filterIcon.click();

		// Find the left panel and select the matching filter
		List<ElementHandle> leftPanels = page.querySelectorAll("//div[@class='insights-filter-left']");
		boolean leftFound = false;

		OuterLeft:
			for (ElementHandle leftPanel : leftPanels) {
				List<ElementHandle> divs = leftPanel.querySelectorAll("div");
				for (ElementHandle div : divs) {
					List<ElementHandle> spans = div.querySelectorAll("span");
					for (ElementHandle span : spans) {
						String text = span.innerText().trim();
						System.out.println("Left Panel Option: " + text);
						if (text.equalsIgnoreCase(leftPanelValue)) {
							span.click();
							leftFound = true;
							break OuterLeft;
						}
					}
				}
			}

		if (!leftFound) {
			System.out.println("Please enter a valid left panel value: " + leftPanelValue);
			return;
		}
		else { 
			page.waitForTimeout(2000);
			List<ElementHandle> filterrightpanel = page.querySelectorAll("//mat-checkbox[@class='mat-checkbox mat-accent ng-star-inserted']");
			if(!filterrightpanel.isEmpty()) {
				boolean found =false;
				//List<ElementHandle> rightpanelelemnts=page.querySelectorAll("//mat-checkbox[@class='mat-checkbox mat-accent ng-star-inserted']");
				Outer:
					for (ElementHandle rightpnlelmnts : filterrightpanel) {
						List<ElementHandle>spanelements= rightpnlelmnts.querySelectorAll("span");
						for (ElementHandle spanele: spanelements) {
							String rightpan=spanele.innerText().trim();
							System.out.println(rightpan);
							if(rightpan.equalsIgnoreCase(rightPanelValue)) {
								spanele.click();
								found =true;
								break Outer;
							}
						}

					}  
				if(!found) {
					System.out.println("please enter the correct right panel value ");
				}
			}
		}

		// Click the "Apply Filters" button
		ElementHandle applyButton = page.waitForSelector("//span[text()=' Apply Filters ']");
		applyButton.click();


	} 


	//addemployees
	public static void addingEmpsThroughIds(String employeeIds)  {
		ElementHandle empids=page.waitForSelector("//textarea[@ng-reflect-placeholder='Enter the Employee Codes / IDs']");
		empids.click();
		empids.fill(employeeIds);
		page.waitForTimeout(4000);
		page.locator("//mat-icon[text()='done_all']").click();
	}

	//deleteemployees

	public static void deleteEmployees(String employeeNamesOrIds) throws Throwable {
		Thread.sleep(3000);
		Locator beforeSelectempscount = page.locator("//div[@class='stepper-heading ng-star-inserted']");
		String beforeempcount = beforeSelectempscount.innerText();
		System.out.println("Before deletion: " + beforeempcount);
		String[] deleteList = employeeNamesOrIds.split(",");
		for (String deleteemp : deleteList) {
			deleteemp = deleteemp.trim();
			boolean found = false;

			List<ElementHandle> empslist = page.querySelectorAll("//span[@class='name']");

			for (ElementHandle empdelete : empslist) {
				String[] words = empdelete.innerText().split("\\s+");
				for (String word : words) {
					if (word.equalsIgnoreCase(deleteemp)) {
						ElementHandle deleteIcon = empdelete.querySelector("./ancestor::div[@class='emp-row ng-star-inserted']//mat-icon[text()=' delete ']");
						deleteIcon.click();
						found = true;
						System.out.println("Deleted employee: " + deleteemp);
						break;
					}
				}
				if (found) break; // move to next employee
			}

			if (!found) {
				System.out.println("Employee not found: " + deleteemp);
			}
		}

		Locator afterSelectempscount = page.locator("//div[@class='stepper-heading ng-star-inserted']");
		String afterempcount = afterSelectempscount.innerText();
		System.out.println("After deletion: " + afterempcount);
	}
	//selectcustomemployee
	public static void selectCustomEmployee(String empname) {
		Locator searchempbar=page.locator("//input[contains(@id,'complete-search')]");
		searchempbar.click();
		page.waitForTimeout(2000);
		searchempbar.fill(empname);
		List<ElementHandle> disappearselect=page.querySelectorAll("//mat-option[@class='mat-option ng-star-inserted mat-option-disabled']");
		if(!disappearselect.isEmpty()) {
			System.out.println("employee is already added");

		}
		else {
			Locator searchempselect=page.locator("//span[@class='mat-option-text']");
			searchempselect.click();
		}
	}

	//addcustomquestions

	public static void addcustomQuestions(int noOfQuestions,String Questiontype,int NoOfSubquestions,String subQuestions) {
		int a = noOfQuestions;
		int b=NoOfSubquestions;

		String[] questionTypes = Questiontype.split(",\\s*");
		for (int i = 1; i <=a; i++) {
			page.locator("//button[text()='+Add Question']").click();

			String questiontype=questionTypes[i-1];
			String buttonId = "//button[@id='add-sub-ques-" + (i-1) + "-btn']";
			// String buttn="//button[@id='add-sub-ques-2-btn']";
			if(questiontype.equalsIgnoreCase("free text")) {
				Locator textboxes=  page.locator("(//textarea[contains(@class,'invalid')])");
				textboxes.click();
				textboxes.fill("free text question");
				String freetextXpath = "(//mat-radio-button[contains(@value, 'freeText')])[last()]";
				Locator freetextRadio = page.locator(freetextXpath);
				freetextRadio.scrollIntoViewIfNeeded(); 
				freetextRadio.click();
			}
			else if (questiontype.equalsIgnoreCase("rating")) {
				page.locator("//textarea[contains(@class,'invalid')]").fill("rating type question");

				String rationXpath = "(//mat-radio-button[contains(@value, 'radio')])[last()]";
				Locator ratingRadio = page.locator(rationXpath);

				ratingRadio.scrollIntoViewIfNeeded();
				ratingRadio.click();
			}


			else {
				page.locator("//textarea[contains(@class,'invalid')]").fill("rating type with sub question");
				//driver.findElement(By.xpath(rationXpath)).click();                   
				String rationXpath = "(//mat-radio-button[contains(@value, 'radio')])[last()]";
				Locator ratingRadio = page.locator(rationXpath);

				ratingRadio.scrollIntoViewIfNeeded();
				ratingRadio.click();
				for(int j=1;j<=b;j++) {
					String[] subquestiontype = subQuestions.split(",\\s*");
					Locator subQBtn = page.locator(buttonId);
					subQBtn.click();
					page.locator("//input[contains(@class,'ng-invalid')]").fill(subquestiontype[j-1]);
				}

			}
		}

	}

	//insights generate

	public static void generateInsights(String startdate,String enddate,int count ,String persons, String customemp) {

		page.waitForTimeout(5000);	
		String startDatee = startdate;
		String endDatee = enddate;

		page.locator("//mat-select[@aria-label='Items per page:']").click();
		page.locator("//span[text()='100']").click();
		List<ElementHandle> insight=page.querySelectorAll("//tr[td[normalize-space(text())='" + startDatee + "'] and td[normalize-space(text())='" + endDatee + "']]");
		ElementHandle insightss=insight.get(0);
		ElementHandle generateinsight=insightss.querySelector("//span[text()='Generate']");
		generateinsight.click();
		page.waitForTimeout(2000);
		int j=count;
		String a = persons;
		String b[]=a.split(",");
		List<ElementHandle>checkboxesss =page.querySelectorAll("mat-checkbox");
		System.out.println(checkboxesss.size());
		for(int i =0; i<j;i++) {



			for (ElementHandle checkbox : checkboxesss) {

				ElementHandle targetcheckbox=checkbox.querySelector("span");
				if(targetcheckbox.innerText().equalsIgnoreCase(b[i])) {
					if(!targetcheckbox.isChecked()) {
						targetcheckbox.click();
					}

					if(b[i].equalsIgnoreCase("Custom Employees")) {

						page.locator("//input[@id='autoComplete']").click();
						page.locator("//input[@id='autoComplete']").fill(customemp);
						page.locator("//span[@class='mat-option-text']").click();

					}
				}
			}

		}






		page.locator("#generateInsight").click();

		Locator message=page.locator("//p[@class='confirm-txt']");
		message.waitFor(new WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		if(message.isVisible()) {
			System.out.println("insights generated successfully");
		}
		else {
			System.out.println("insights not generated");
		}


	}

	//status change

	public static void statuschange() {
		List<ElementHandle> activerow=page.querySelectorAll("//tr[contains(@class,'ACTIVE ')]");
		System.out.println(activerow.size());
		ElementHandle remainder1 =  activerow.get(0);
		ElementHandle statusActive = remainder1.querySelector("//span[text()='ACTIVE']");
		statusActive.click();
		page.locator("//span[text()=' COMPLETED ']").click();
	}

	//survey filling 

	public static void surveyfilling(String optionstext,String freetextanswer) {

		page.waitForTimeout(5000);
		List<ElementHandle> questionDivs = page.querySelectorAll("//div[@class='goal-body-row ng-star-inserted'][.//mat-radio-button or .//span[@class='mat-checkbox-label'] or .//textarea]" );

		System.out.println("Filtered question count: " + questionDivs.size());

		for (int i = 0; i < questionDivs.size(); i++) {
			ElementHandle question = questionDivs.get(i); // Get current question block
			System.out.println(question.innerText()); // Print question text
			System.out.println(i);  // Print question index


			List<ElementHandle> radiobuttons = question.querySelectorAll("mat-radio-button");


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
							textarea.fill(optionstext);
						}
					}
				} catch (Exception e) {

				}
			}

			else {

				ElementHandle freetextqstns= question.querySelector("#qdescription");
				freetextqstns.fill(freetextanswer);
			}

			if(i==8) {
				page.locator("#nextBtn").click();

			}


		}
		page.locator("#QuestionSubmitBtn").click();
		ElementHandle message= page.waitForSelector("//p[@class='ng-star-inserted']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE) );
		if(message.isVisible()) {

			System.out.println("survey successfully submitted");
		}
		else {
			System.out.println("survey not filled please cross check");
		}


	}

	// goal creation

	public static void goalcreation(String goaltitle,String targettype, String bandtype, String weightage, String goaltype, String goalKPI , String target, String goalfrequencey, String startdate, String enddate,String empnames ,String keypoint, String subgoaldata) {

		page.locator("//button[contains(@id,'goal-creation')]").click();
		String actualtitle[]=goaltitle.split(",");
		String actualtargettype[]=targettype.split(",");
		String actualbandtype[]=bandtype.split(",");
		String actualweightage[]=weightage.split(",");
		String actualgoaltype[]=goaltype.split(",");
		String actualgoalkpi[]=goalKPI.split(",");
		String actualtarget[]=target.split(",");
		String actualfrequency[]=goalfrequencey.split(",");
		String actualstartdate[]=startdate.split(",");
		String actualenddate[]=enddate.split(",");
		String actualempnames[]=empnames.split(",");

		String actualkeypoint[]=keypoint.split(",");

		for(int i=0;i<actualtitle.length;i++) {

			page.locator("(//input[@id='goalTitle'])[2]").click();
			page.locator("(//input[@id='goalTitle'])[2]").fill(actualtitle[i]);
			page.keyboard().press("Escape");
			page.locator("(//mat-select[@formcontrolname='targetType'])[2]").click();
			if(actualtargettype[i].equalsIgnoreCase("Alphanumeric")) {
				List<ElementHandle> targetdrodowns=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle targetdropdown : targetdrodowns) {
					String targetelement=targetdropdown.innerText();
					if(targetelement.equalsIgnoreCase(actualtargettype[i])) {
						targetdropdown.click();
						break;
					}
				}
				/*page.locator("//mat-select[@formcontrolname='bandType']").click();
  		List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
  		for (ElementHandle bandtype1 : bandtypes) {
  			String targetbandtype=bandtype1.innerText().trim();
  			if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
  				bandtype1.click();
  				break;
  			}
  		}
				 */
				page.locator("(//input[@formcontrolname='weightage'])[2]").fill(actualweightage[i]);
				page.locator("(//mat-select[@id='goalType'])[2]").click();
				List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle goaltype1 : goaltypes) {
					String targetgoaltype=goaltype1.innerText().trim();
					if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
						goaltype1.click();
						break;
					}
				}

				page.locator("(//textarea[@id='goalKpi'])[2]").fill(actualgoalkpi[i]);
				page.locator("(//textarea[@formcontrolname='target'])[2]").fill(actualtarget[i]);
				page.locator("(//mat-select[@id='goalFrequency'])[2]").click();
				List<ElementHandle> goalfrequency =page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle goalfreq : goalfrequency) {
					String targetfrequency=goalfreq.innerText().trim();
					if(targetfrequency.equalsIgnoreCase(actualfrequency[i])) {
						goalfreq.click();
						break;
					}
				}
				page.locator("(//input[@formcontrolname='startDate'])[2]").click();
				selectcalander(actualstartdate[i]);
				page.locator("(//input[@formcontrolname='endDate'])[2]").click();
				selectcalander(actualenddate[i]);
				
				Locator empdropdrown=page.locator("(//mat-select[@id='goalAssignEmps'])[2]");
				if(empdropdrown.isVisible()) {
					empdropdrown.click();
					page.locator("//mat-option[@aria-selected='true']").click();
					List<ElementHandle> empslist=page.querySelectorAll("//span[@class='mat-option-text']");
					for(int j=1;j<=actualempnames.length;j++) {
					for (ElementHandle emplist : empslist) {
						
						if(emplist.innerText().contains(actualempnames[j-1])) {
							emplist.click();
							break;
						}
					}
					}
					page.keyboard().press("Escape");
				}
				
				page.locator("(//textarea[@formcontrolname='subgoalDescription'])[2]").fill(actualkeypoint[i]);
				List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
				if(!subgoals.isEmpty()) {

					for (ElementHandle subgoall : subgoals) {
						subgoall.fill(subgoaldata);
					}
				}
				page.waitForTimeout(3000);
				page.locator("//button[text()='Add to list']").click();
				Locator latestGoal = page.locator("//mat-card[@class='custom-card mat-card ng-star-inserted']").last();
				latestGoal.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

				System.out.println("added to list");


			}
			else {

				List<ElementHandle> targetdrodowns=page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle targetdropdown : targetdrodowns) {
					String targetelement=targetdropdown.innerText();
					if(targetelement.equalsIgnoreCase(actualtargettype[i])) {
						targetdropdown.click();
						break;
					}
				}
				page.locator("//mat-select[@formcontrolname='bandType']").click();
				List<ElementHandle> bandtypes =page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle bandtype1 : bandtypes) {
					String targetbandtype=bandtype1.innerText().trim();
					if(targetbandtype.equalsIgnoreCase(actualbandtype[i])) {
						bandtype1.click();
						break;
					}
				}

				page.locator("(//input[@formcontrolname='weightage'])[2]").fill(actualweightage[i]);
				page.locator("(//mat-select[@id='goalType'])[2]").click();
				List<ElementHandle> goaltypes =page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle goaltype1 : goaltypes) {
					String targetgoaltype=goaltype1.innerText().trim();
					if(targetgoaltype.equalsIgnoreCase(actualgoaltype[i])) {
						goaltype1.click();
						break;
					}
				}

				page.locator("(//textarea[@id='goalKpi'])[2]").fill(actualgoalkpi[i]);
				page.locator("(//textarea[@formcontrolname='target'])[2]").fill(actualtarget[i]);
				page.locator("(//mat-select[@id='goalFrequency'])[2]").click();
				List<ElementHandle> goalfrequency =page.querySelectorAll("//span[@class='mat-option-text']");
				for (ElementHandle goalfreq : goalfrequency) {
					String targetfrequency=goalfreq.innerText().trim();
					if(targetfrequency.equalsIgnoreCase(actualfrequency[i])) {
						goalfreq.click();
						break;
					}
				}
				page.locator("(//input[@formcontrolname='startDate'])[2]").click();
				selectcalander(actualstartdate[i]);
				page.locator("(//input[@formcontrolname='endDate'])[2]").click();
				selectcalander(actualenddate[i]);
				
				Locator empdropdrown=page.locator("(//mat-select[@id='goalAssignEmps'])[2]");
				if(empdropdrown.isVisible()) {
					empdropdrown.click();
					
					Locator checkbox=page.locator("//mat-option[@aria-selected='true']");
					if(checkbox.isVisible()) {
						checkbox.click();

						if (actualempnames[i].isEmpty()) {

						} else {
							List<ElementHandle> empslist=page.querySelectorAll("//span[@class='mat-option-text']");
							for(int j=1;j<=actualempnames.length;j++) {
								for (ElementHandle emplist : empslist) {

									if(emplist.innerText().contains(actualempnames[j-1])) {
										emplist.click();
										break;
									}
								}
							}
						}



						page.keyboard().press("Escape");
					}
					else {


						if (actualempnames[i].isEmpty()) {

						} else {
							List<ElementHandle> empslist=page.querySelectorAll("//span[@class='mat-option-text']");
							for(int j=1;j<=actualempnames.length;j++) {
								for (ElementHandle emplist : empslist) {

									if(emplist.innerText().contains(actualempnames[j-1])) {
										emplist.click();
										break;
									}
								}
							}
						}


						page.keyboard().press("Escape");


					}
				}
				
				
				page.locator("(//textarea[@formcontrolname='subgoalDescription'])[2]").fill(actualkeypoint[i]);
				List<ElementHandle>subgoals=page.querySelectorAll("//textarea[contains(@class, 'ng-invalid')and contains(@formcontrolname,'subGoalValue')]");
				if(!subgoals.isEmpty()) {

					for (ElementHandle subgoal:subgoals) {
						subgoal.fill(subgoaldata);
					}
				}
				page.waitForTimeout(2000);

				page.locator("//button[text()='Add to list']").click();
				Locator latestGoal = page.locator("//mat-card[@class='custom-card mat-card ng-star-inserted']").last();
				latestGoal.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

				System.out.println("added to list");
				
			}

		}

		page.locator("//button[text()='Publish goal']").click();
		ElementHandle successmessage=page.waitForSelector("//p[text()='Goal Added Successfully']",new Page.WaitForSelectorOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
		if(successmessage.isVisible()) {
			System.out.println("goals created successfully");
		}
		else {
			System.out.println("goals not created successfully");
		}
		
	}
	
	//searchgoal functionality in my goals tab
	public static void searchgoal(String goalname){
		Locator searchbar=page.locator("//input[@id='search-bar-empid']");
		searchbar.click();
		searchbar.fill(goalname);
		searchbar.press("Enter");
		Locator goals=page.locator("//tr[contains(@class,'row-ACTIVE')]");
		assertEquals("Expected exactly one active goal row", 1, goals.count());

		if(goals.count()>1) {
			System.out.println("search functionality failed");
		}
		else {
		
			page.locator("//td[normalize-space()='"+goalname+"']").click();
			System.out.println("search functionality working fine");
			page.locator("//mat-icon[text()='close']").click();
		}
		searchbar.clear();
		assertTrue("Expected more than one active goal row", goals.count() > 1);

		if(goals.count()>1) {
			System.out.println("search clear functionality working fine");
		}
		else {
			System.out.println("search clear functionality failed");

		}
		
		searchbar.click();
		searchbar.fill(goalname);
		searchbar.press("Enter");
		Locator goals1=page.locator("//tr[contains(@class,'row-ACTIVE')]");
		assertEquals("Expected exactly one active goal row", 1, goals1.count());
		if(goals1.count()>1) {
			System.out.println("search functionality failed");
		}
		else {
		
			page.locator("//td[normalize-space()='"+goalname+"']").click();
			System.out.println("search functionality working fine");
			page.locator("//mat-icon[text()='close']").click();
		}
		page.locator("//span[normalize-space()='Insights']").click();
		page.locator("//span[normalize-space()='My Goals']").click();
		String searchText=searchbar.inputValue();
	 System.out.println("search bar text:"+searchbar.inputValue());
	 assertEquals("Search bar should be empty.", "", searchText);
	}

	public static void negativecalendar(String date) {
		String startdate = date;

		//Split by hyphen
		String[] parts = startdate.split("-");

		String stday = parts[0];    // "01"
		String stmonth = parts[1];  // "apr"
		String styear = parts[2];   // "2024"

		
		
		try {
		
		
		
		//driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		page.locator("//button[@aria-label='Choose month and year']").click();
		//WebElement startyeartable=driver.findElement(By.xpath("//table[@class='mat-calendar-table']"));

		ElementHandle startyeartable = page.waitForSelector("//table[@class='mat-calendar-table']");

		//List<WebElement>startyearrows=startyeartable.findElements(By.tagName("tr"));
		List<ElementHandle> startyearrows =startyeartable.querySelectorAll("tr");
		for (ElementHandle styrrows : startyearrows) {
			List<ElementHandle>startyearcolumns=styrrows.querySelectorAll("td");
			for (ElementHandle styrcolmns : startyearcolumns) {
				String year=styrcolmns.innerText();
				if(year.equalsIgnoreCase(styear)) {
					
					if (page.locator("//td[contains(@class,'body-disabled') and contains(@aria-label,'"+year+"')]").isVisible()) {
						page.keyboard().press("Escape");
					} else {
						styrcolmns.click();
						break;
					}
					
					//page.locator("//td[contains(@class,'body-disabled') and contains(@aria-label,'"+year+"')]");
					
					
				}
			}
		}

		ElementHandle  startmonthtable=page.waitForSelector("//table[@class='mat-calendar-table']");
		List<ElementHandle>startmonthrows=startmonthtable.querySelectorAll("tr");
		outer:
			for (ElementHandle stmnthrows : startmonthrows) {
				List<ElementHandle>startmonthcolumns=stmnthrows.querySelectorAll("td");
				for (ElementHandle stmnthcolmns : startmonthcolumns) {
					String month=stmnthcolmns.innerText();
					if(month.equalsIgnoreCase(stmonth)) {
						
						if (page.locator("//td[contains(@class,'body-disabled') and contains(@aria-label,'"+stmonth+"')]").isVisible()) {
							page.keyboard().press("Escape");
						} else {
							stmnthcolmns.click();
							break outer;
						}
						
						
						
					}
				}
			}
		ElementHandle  startdatetable=page.waitForSelector("//table[@class='mat-calendar-table']");
		List<ElementHandle>startdaterows=startdatetable.querySelectorAll("tr");
		outer:
			for (ElementHandle stdtrows : startdaterows) {
				List<ElementHandle>startdatecolumns=stdtrows.querySelectorAll("td");
				for (ElementHandle stdtcolmns : startdatecolumns) {
					String datee=stdtcolmns.innerText();
					if(datee.equalsIgnoreCase(stday)) {
						

						if (page.locator("//td[contains(@class,'body-disabled')]//div[text()='"+stday+"']").isVisible()) {
							page.keyboard().press("Escape");
						} else {
							stdtcolmns.click();
							break outer;
						}
						
						stdtcolmns.click();
						break outer;
					}
				}
			}
		
	}
	catch(Exception  e) {
		
	}
	}
	
}
