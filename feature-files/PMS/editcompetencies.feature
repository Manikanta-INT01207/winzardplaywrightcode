Feature: verify admin able to update the existing competencies

Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin opens the existing  "<competency>"
Then admin changes the "<comptencyTitle>" , "<description>" in it then saves the comptency
Then admin admin opens the edited comptency "<competencyTitle>" to make sure changes are reflected or not

Examples:
|username|password|competency|comptencyTitle|description|competencyTitle|
|anirudha@interbiz.in|Winzard@2024|title|titlleee|dummyyyy|titlleee|
