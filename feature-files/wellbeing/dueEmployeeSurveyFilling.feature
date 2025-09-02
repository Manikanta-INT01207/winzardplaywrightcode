Feature:  due employees filling the survey 
Scenario: survey filling by the due employees

Scenario Outline:
Given due employee goes to  wellebing portal "<usernameee>" and "<passwordss>"
Then due employees opens the survey to fil it
Then due employee gives the rating and "<optionAnswer>" and "<freeTextAnswer>"

Examples:
|usernameee|passwordss|optionAnswer|freeTextAnswer|
|manikantap+1@interbiz.in|Winzard@2024|optionAnswer-01|freeTextAnswer-01|
|manikantap+2@interbiz.in|Winzard@2024|optionAnswer-02|freeTextAnswer-02|