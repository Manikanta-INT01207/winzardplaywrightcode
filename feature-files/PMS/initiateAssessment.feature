Feature: verify admin able to initiate assessment or not 

Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module
Then admin goes to initiate assessment tab and click on the start new to initiate assessment
Then admin enters the assessment "<title>" , "<appraisalperiodstartdate>" and "<appraisalperiodenddate>"
Then admin enters the "<reviewtypes>" and their "<weightages>"
Then admin selects the "<hierarchy>" , "<authorityToFillEntireAssessment>" and "<configurtaionType>"
Then admin select the "<recommendations>"
Then admin selects the employees from through "<customempID>" , "<empIDs>" and filters "<category>" , "<subcategory>"
Then admin enters the "<appraisalStartDate>" , "<appraisalEndDate>" and "<HOC>" for standard and skiplevel hierarchy

Examples:
|username|password|title|appraisalperiodstartdate|appraisalperiodenddate|reviewtypes|weightages|hierarchy|authorityToFillEntireAssessment|configurtaionType|recommendations|customempID|empIDs|category|subcategory|appraisalStartDate|appraisalEndDate|HOC|
|anirudha@interbiz.in|Winzard@2024|title|2-may-2025|30-dec-2025|performance,Custom Forms,Competencies / Skills / Potential|30,40,30|standard|reporting manager|condition|WFH,title|CAP-38||||29-oct-2025|4-nov-2025|CAP-01|

