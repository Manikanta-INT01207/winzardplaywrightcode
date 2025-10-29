Feature: check admin abe to assign the competencies through employee level

Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin selects the employee level to assign competencies 
Then admin adds the employees through "<customemployee>" , "<EmpiID>", filters "<category>" ,"<subcategory>" then adds the "<title>" and "<competencies>"

Examples:
|username|password|customemployee|EmpiID|category|subcategory|title|competencies|
|anirudha@interbiz.in|Winzard@2024|CAP-02||||comps for CAP-02|creativity,delegation|