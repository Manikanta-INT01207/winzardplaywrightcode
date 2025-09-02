Feature: creating engagement custom question survey

Scenario Outline:

Given admin is on the engagement portal "<username>" and "<password>"
Then admin clicks on the org tab to initiate a survey
Then admin adds the employees through "<customEmp>" through filters "<category>" and "<subcategory>" and through "<empIDS>"
Then admin clicks on the next button to create
Then admin selects the "<startdate>" and "<enddate>"  to create survey
Then admin clicks on the Add custom questions to add the questions
Then admin add the custom questions  "<NoofQuestions>", "<Questiontype>", "<NoOFsubQuestions>", "<subquestions>"
Then admin clicks on the initiate tab to initate the survey

Examples:
|username|password|customEmp|category|subcategory|empIDS|startdate|enddate|NoofQuestions|Questiontype|NoOFsubQuestions|subquestions|
|anirudha@interbiz.in|Winzard@2024|CAP-37|grade|grade A|CAP-04,CAP-05|7-Aug-2025|31-Aug-2025|3|free text,rating,Subquestions|4|sub-1,sub-2,sub-3,sub-4|