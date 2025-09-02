Feature: generating the engagement insights

Scenario: generating the insights of engagment survey 

Scenario Outline:

Given  user went to engagment portal "<username>" and "<password>"
Then user generates the insights for particular engagement survey using the dates "<startdate>" and "<enddate>" selects the access persons "<count>" and "<personnames>" and custom employee name "<empid>" if you want to access to the particular person


Examples:
|username|password|startdate|enddate|count|personnames|empid|
|anirudha@interbiz.in|Winzard@2024|Sep 1, 2025|Sep 31, 2025|3|leadership,superadmin,custom employees|CAP-43|

