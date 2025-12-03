Feature: verify admin able to create the recommendations

Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin clicks on the start new to create a new recommendations 
Then admin creates the recommendations by adding the "<title>" and "<description>"

Examples:
|username|password|title|description|
|anirudha@interbiz.in|Winzard@2024|title|description|
|anirudha@interbiz.in|Winzard@2024||description|
|anirudha@interbiz.in|Winzard@2024|title||
