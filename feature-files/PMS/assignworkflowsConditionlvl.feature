Feature: verify admin able to create a workflow and assign forms  with condition level

Scenario Outline:
Given admin logs to profile with credintials "<username>" and "<password>"
Then admin goes to PMS module 
Then admin goes to the create workflows and assign forms tab 
Then admin clicks on the start new and enter the workflow title "<title>"
Then admin adds the forms "<forms>" and "<weightage>"
Then admin adds the  "<hierarchy>" , "<selfforms>", "<RMforms>", "<skiplevelmanagerforms>", "<reviwerlevels>", "<reviewersempIDs>", "<reviewer1forms>", "<reviewer2forms>", "<reviewer3forms>"
Then admin adds the "<finalauthority>"
Then admins adds the employees through filters "<department>" and "<subdepartment>"

# note :don't leave blank if there is no forms to be assigned instead of that add "no forms"  
# note: final authority reviwers should be given like this "reviewer - 2" remember the space between the '-' then only it works otherwise not 


Examples:
|username|password|title|forms|weightage|hierarchy|selfforms|RMforms|skiplevelmanagerforms|reviwerlevels|reviewersempIDs|reviewer1forms|reviewer2forms|reviewer3forms|finalauthority|department|subdepartment|
|anirudha@interbiz.in|Winzard@2024|grade-f workflow|self form,FORM 1|60,40|self,reporting manager,reviewer-1,reviewer-2|self form|FORM 1|no forms|L1,L2|CAP-37,CAP-38|self form,FORM 1|no forms|no forms|reviewer - 2|grade|Grade-F|