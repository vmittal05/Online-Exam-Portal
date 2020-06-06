# Online-Exam-Portal
Provides user the facility to register on the portal and take a timed online exam.
Built by using Java Servlets, JDBC and JSP.
## How to Run:
1. Install mysql and create a database named ajp.
2. Create a table named register.
Schema:
 +--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| enroll | int(10)     | NO   | PRI | NULL    |       |
| fname  | varchar(20) | YES  |     | NULL    |       |
| lname  | varchar(20) | YES  |     | NULL    |       |
| gender | char(1)     | YES  |     | NULL    |       |
| pass   | varchar(20) | YES  |     | NULL    |       |
| univ   | varchar(20) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3. Run the file welcome.html using Eclipse IDE for Java EE Developers or a similar IDE.
4. Signup using the link in the page and filling the form (validated).
5. Login and click on Start Test.
6. Choose the correct options as per the questions and click on Submit (Also the test will auto submit in 100 seconds !).
7. View your Final Marks.

Thank you !

