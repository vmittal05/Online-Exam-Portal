package ajpProject;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.*; 
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login") 
public class loginHandler extends HttpServlet  {
	private static final long serialVersionUID = 1L; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		try {
			ArrayList<String> al = new ArrayList<>();
	        response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        String id = request.getParameter("id");
	        String pass = request.getParameter("pass");
	        if ((pass == null) || (pass.equals(""))) {
	        	al.add("PROVIDE PASSWORD...");
	        }
	        else if (pass.length()<5) {
	        	al.add("PROVIDE PASSWORD of at least 6 characters...");
	        } 
	        if ((id== null) || (id.equals(""))) {
	            al.add("PROVIDE STUDENT ID...");
	        }else {
	            try {
	            	Integer.parseInt(id);
	            }catch (Exception e) {
	            	al.add("PROVIDE ID IN CORRECT FORMAT....");
	            }
	        }
	        if (al.size() != 0) {
	        	pw.println("<font color='red'>"+al+"</font>");
//	        	pw.print(al);  
	        	RequestDispatcher rd=request.getRequestDispatcher("/login.html");
	        	rd.include(request, response);
	        } 
	        else { 
	        	Connection con = DBConnection.initializeDatabase(); 
				 String preQueryStatement = "SELECT * FROM register WHERE enroll = ?;";
				 PreparedStatement pStmnt = con.prepareStatement(preQueryStatement);
				 pStmnt.setInt(1,Integer.parseInt(id));
				 ResultSet rs = pStmnt.executeQuery();
				 if (rs.next()){
					 String pwd=rs.getString("pass");
//					 System.out.println(pwd+" "+pass);
					 if(!pwd.equals(pass)) {
						 pw.println("<font color='red'>Please enter correct password !!</font>");
				        	RequestDispatcher rd=request.getRequestDispatcher("/login.html");
				        	rd.include(request, response);
					 }
					 else {
						 String fname = rs.getString("fname");
						 String lname = rs.getString("lname");
						 pw.print("<font color='green'>You are successfully logged in!</font><br>");  
						 HttpSession session=request.getSession();  
						 session.setAttribute("uname",fname);  
						 Cookie ck=new Cookie("name",fname);  
						 response.addCookie(ck);
						 pw.print("<h3><marquee>Welcome, "+fname+" "+lname+"</marquee><br></h3>");  
						 request.getRequestDispatcher("profile.jsp").include(request, response);  
					 }  
			         pw.close();
				 }
				 else {
					 pw.println("<font color='red'>ID Doesn't exists try Signing up !! !!</font>");
			        	RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			        	rd.include(request, response);
				 }
	        }
		}
		catch(Exception e) {
			
		}
	}
}
