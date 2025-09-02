Feature:  due employees filling the engagment survey 
Scenario: engagement survey filling by the due employees

Scenario Outline:
Given due employee goes to  engagement portal "<usernameee>" and "<passwordss>"
Then due employees opens the engagement survey to fil it
Then due employee gives the rating and "<optionAnswer>" and "<freeTextAnswer>" to the engagment survey then submits it 

Examples:
|usernameee|passwordss|optionAnswer|freeTextAnswer|
|manikantap+1@interbiz.in|Winzard@2024|optionAnswer-01|freeTextAnswer-01|
|manikantap+2@interbiz.in|Winzard@2024|optionAnswer-02|freeTextAnswer-02|