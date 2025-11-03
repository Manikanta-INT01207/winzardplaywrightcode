Feature: verify admin able edit the forms or not

Scenario Outline:

Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin opens the form "<formname>"
Then admin changes the "<formtitle>" and add questions "<questions>" , "<description>" in it then saves the form
Then admin admin opens the edited form "<formtitle>" to make sure changes are reflected or not

Examples:
|username|password|formname|formtitle|questions|description|formtitle|
|anirudha@interbiz.in|Winzard@2024|dum|dummm|q1,q2,q3|d1,d2,d3|dummm|
