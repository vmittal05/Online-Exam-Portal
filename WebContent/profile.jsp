<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Profile</title>
   </head>
   <body bgcolor="lightskyblue">
      Current Date &amp; Time:
      <%
         Date date = new Date();
         out.print(date.toString()+"<br>");
      %>

<hr size=2><br>
<a href="exam.jsp">Start Test</a><br><br>
<a href="logout">LogOut</a>
   </body>
</html>
