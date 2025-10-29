Feature: creating competencies in the PMS 

Scenario Outline:

Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin clicks on the start new to create a new competencies 
Then admin adds the comptencies "<title>" and "<description>"

Examples:
|username|password|title|description|
|anirudha@interbiz.in|Winzard@2024|title-1|description-1|

