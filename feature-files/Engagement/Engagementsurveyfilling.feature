Feature: employee filling the engagement survey

Scenario: Engagement survey filling by employee
Scenario Outline:

Given employee goes to  engagement  portal "<usernameee>" and "<passwordss>"
Then employees opens the engagement survey to fil it
Then employee gives the rating and "<optionAnswer>" and "<freeTextAnswer>" for the engagement survey

Examples:
|usernameee|passwordss|optionAnswer|freeTextAnswer|
|anirudha@interbiz.in|Winzard@2024|optionAnswer-01|freeTextAnswer-01|
|anirudha+1@interbiz.in|Winzard@2024|optionAnswer-02|freeTextAnswer-02|
|manikantap+3@interbiz.in|Winzard@2024|optionAnswer-03|freeTextAnswer-03|
|manikantap+4@interbiz.in|Winzard@2024|optionAnswer-04|freeTextAnswer-04|
|sneha@winzard.io|Winzard@2024|optionAnswer-05|freeTextAnswer-05|
|anirudha+2@interbiz.in|Winzard@2024|optionAnswer-06|freeTextAnswer-06|
