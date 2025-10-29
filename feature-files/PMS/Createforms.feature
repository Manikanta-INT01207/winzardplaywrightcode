Feature: check admin able to create forms 

Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to global configuration tab then goes to create forms tab
Then admin clicks on the start new to create a new form
Then admin adds the sections "<formtitle>", "<sectionscount>" , "<sectiontypes>" , "<sectiontitle>" ,"<weightage>" , "<othersSecquestions>", "<othersSecdescription>", "<subqstnstyps>" , "<dropdownquestionoptions>" , "<ratingQuestions>", "<ratingDescriptions>", "<ratingCommentQuestions>", "<ratingCommentQuestionsDescription>"

Examples:
|username|password|formtitle|sectionscount|sectiontypes|sectiontitle|weightage|othersSecquestions|othersSecdescription|subqstnstyps|dropdownquestionoptions|ratingQuestions|ratingDescriptions|ratingCommentQuestions|ratingCommentQuestionsDescription|
|anirudha@interbiz.in|Winzard@2024|dummy|3|Rating & Comment,Rating Scale,others|sectn-1,sectn-2,sectn-3|30,40, |long question,short question,dropdown question|long desc,short desc,drop down desc|Long,Short,dropdown|1,2,3,4|q1,q2|q1 desc,q2 desc,q3 desc|a1,a2,a3|a1 desc,a2 desc,a3 desc|