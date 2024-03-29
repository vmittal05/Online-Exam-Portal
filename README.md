# Online-Exam-Portal
Provides user the facility to register on the portal and take a timed online exam.
Built by using Java Servlets, JDBC and JSP.

## Features:
1. Register and take a timed quiz on Java Basics.
2. View your results.
3. Signup and Login functionalities using Cookies.
4. Fully validated forms for signup, login etc.

## Demo Video:


https://user-images.githubusercontent.com/41340985/190709060-ca018d5e-ea9b-4592-907f-ebb2050afe43.mp4



## How to Run:
1. Install mysql and create a database named ajp.
2. Create a table named register.<br />
Schema:<br />

| Field  | Type        | Null | Key | Default | Extra |
|--------|-------------|------|-----|---------|-------|
| enroll | int(10)     | NO   | PRI | NULL    |       |
| fname  | varchar(20) | YES  |     | NULL    |       |
| lname  | varchar(20) | YES  |     | NULL    |       |
| gender | char(1)     | YES  |     | NULL    |       |
| pass   | varchar(20) | YES  |     | NULL    |       |
| univ   | varchar(20) | YES  |     | NULL    |       |

3. Run the project  using [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/packages/release/2020-03/r/eclipse-ide-enterprise-java-developers-includes-incubating-components) or a similar IDE via Tomcat Server and visit http://localhost:8080/ajpProject/welcome.html
4. Signup using the link in the page and filling the form (validated).
5. Login and click on Start Test.
6. Choose the correct options as per the questions and click on Submit (Also the test will auto submit in 100 seconds !).
7. View your Final Marks.

Thank you !

