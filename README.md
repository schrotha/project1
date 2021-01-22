Expense Reimbursement System

Project Description:
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

Technologies Used:
SQL
Hibernate
Java
Javelin
JavaScript
HTML
CSS
AJAX
JUnit
Mockito
Selenium
Features

Features:
Can create new employee or finance manager users
Can login/logout
Employee's can submit new reimbursement requests
Employee's can view their reimbursement request history and the status of those reimbursements
Finance managers can view pending reimbursements and approve/deny them
Finance managers can also view past reimbursements that have already been resolved

To-do list:
Need to add testing for service and dao layers
Need to add end-to-end testing 
Need to add further user verifications on the backend

Command to clone the repository:
open a git bash window in the directory you want to place the project into, then enter the command below
git clone https://gitlab.com/schrotha/expense-reimbursement-system.git

Starting the project:
Open the file Project-1/src/main/java/com/project/MainDriver.java 
In the main funtion, find the line of code "app.start(9050);" (should be line 54)
This line identifies the port on your local machine this app will use, change 9050 to whichever port you want to use.
Then run the MainDriver.java class as a java application to start the application.
You can then go to http://localhost:9050/html/login.html (replace 9050 with the port number you are using) to use the application


