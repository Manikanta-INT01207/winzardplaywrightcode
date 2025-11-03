Feature: verify admin able to update the existing recommendation or not 
Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin opens the existing recommendation "<recommendation>"
Then admin changes the "<recommendationTitle>" , "<description>" in it then saves the recommendation
Then admin admin opens the edited recommendation "<recommendationTitle>" to make sure changes are reflected or not

Examples:
|username|password|recommendation|recommendationTitle|description|recommendationTitle|
|anirudha@interbiz.in|Winzard@2024|titlee|titlleee|dummyyyy|titlleee|
