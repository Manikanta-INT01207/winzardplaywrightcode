Feature: sending remaainders to the due employees

Scenario: remainders for the active survey

Scenario Outline:

Given Admin opens the wellbeing portal with their "<username>" and "<password>"
Then  admin sends the remainders for the due employees of a active survey

Examples:
|username|password|
|anirudha@interbiz.in|Winzard@2024|