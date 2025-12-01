Feature: generating the wellbeing insights

Scenario: generating the insights 

Scenario Outline:

Given  user went to wellbeing portal "<username>" and "<password>"
Then user generates the insights for particular survey using the dates "<startdate>" and "<enddate>" selects the access persons "<count>" and "<personnames>" and custom employee name "<empid>" if you want to access to the particular person


Examples:
|username|password|startdate|enddate|count|personnames|empid|
|anirudha@interbiz.in|Winzard@2024|Nov 9, 2025|Nov 30, 2025|3|leadership,superadmin,custom employees|CAP-43|

