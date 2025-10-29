Feature: check admin able to assign the competencies in condition level

Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin selects the condition level in assign competencies 
Then admin adds the employees by adding fillters "<category>" and "<subcategory>" , "<title>", "<competencies>"

Examples:
|username|password|category|subcategory|title|competencies|
|anirudha@interbiz.in|Winzard@2024|Grade|Grade A|grade A workflow|Creativity,delegation,title|