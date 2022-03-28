# amelia_foundations_project

## Project Description

This is an API that will support a new internal expense reimbursement system. This system will manage the process of reimbursing employees for expenses incurred while on company time. All registered employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

### Features
- Register new users with the system
- Log into the system using a registered user's credentials
- Create a new reimbursement as an authenticated employee user

### TODO's
- Approve or deny pending reimbursements as an authenticated finance manager user 
- Get all of the reimbursements created by a user

### Technologies

**Persistence Tier**
- PostGreSQL (running on Docker)

**Application Tier**
- Java 8
- Apache Maven
- JDBC
- Java EE Servlets
- JSON Web Tokens
- JUnit
- Mockito

### Getting Started

- From Windows/Linux Command Line: git clone https://github.com/220207-java-enterprise/amelia_foundations_project.git 
- From IDE: Open program
- From Postman: Enter dummy data and interact with program
- From Command Line: cd into Apache Tomcat bin and type sh startup.sh (Windows/Mac) or sh $Catalina_Home/bin/catalina.sh run (Linux)
- From IDE: Type mvn tomcat7:deploy to build program

### Usage

- Insert dummy data into your database with Postman
- Insert an Employee to complete a reimbursement
- Insert an Admin to authenticate user
- Insert a Financial Manager to approve/deny reimbursement
