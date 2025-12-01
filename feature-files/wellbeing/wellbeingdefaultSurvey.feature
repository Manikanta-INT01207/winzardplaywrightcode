Feature: wellbeing default survey

Scenario: wellbeing default survey

Scenario Outline: 

Given user is on the workforce wellbeing page "<username>" and "<password>"
Then user clicks the org tab to initiate survey 
Then admin adds the employees through "<customEmp>" either through filters "<category>" and "<subcategory>" and through "<empIDS>"
Then  clicks on the next button to create an wellbeing default survey
Then user selects the "<startdate>" and "<enddate>"
Then user clicks on the initiate button  

Examples: 
|username|password|customEmp|category|subcategory|empIDS|startdate|enddate|
|anirudha@interbiz.in|Winzard@2024|CAP-37|grade|grade A|CAP-01,CAP-02,CAP-03|10-Nov-2025|30-Nov-2025|