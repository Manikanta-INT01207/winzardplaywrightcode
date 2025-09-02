Feature: wellbeing custom survey

Scenario: wellbeing survey with custom questions

Scenario Outline:

Given Hr opens the wellbeing portal "<username>" and "<password>"
Then hr clicks on org tab 
Then hr adds the employees through "<customEmp>" through filters "<category>" and "<subcategory>" and through "<empIDS>"
Then hr clicks on the next button to create
Then hr selects the "<startdate>" and "<enddate>"  to create survey
Then hr clicks on the Add custom questions to add the questions
Then hr add the custom questions  "<NoofQuestions>", "<Questiontype>", "<NoOFsubQuestions>", "<subquestions>"
Then hr clicks on the initiate tab to initate the survey

Examples:
|username|password|customEmp|category|subcategory|empIDS|startdate|enddate|NoofQuestions|Questiontype|NoOFsubQuestions|subquestions|
|anirudha@interbiz.in|Winzard@2024|CAP-37|grade|grade A|CAP-04,CAP-05|1-Sep-2025|31-Sep-2025|3|free text,rating,Subquestions|4|sub-1,sub-2,sub-3,sub-4|