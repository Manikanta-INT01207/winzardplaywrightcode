Feature: initiating the default engagement survey

Scenario: engagement default survey 
Scenario Outline:

Given admin is in the engagement portal "<username>" and "<password>"
Then admin clicks the org tab 
Then admin selects or adds the employees through the "<customEmployee>" and "<category>" and "<subCategory>" and "<empIDs>"
Then admin enters the "<startdate>" and "<enddate>"
Then admin clicks the initiate tab to create the default engagement survey 

Examples: 
|username|password|customEmployee|category|subCategory|empIDs|startdate|enddate|
|anirudha@interbiz.in|Winzard@2024|CAP-37|grade|grade A|CAP-01,CAP-02,CAP-03|1-Sep-2025|31-Sep-2025|