package ajpProject;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.*; 
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

// Servlet Name 
@WebServlet("/Register") 
public class Registration extends HttpServlet { 
	private static final long serialVersionUID = 1L; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		try {
			ArrayList<String> al = new ArrayList<>();
	        response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        String fname = request.getParameter("fname");
	        String lname = request.getParameter("lname");
	        String pass = request.getParameter("pass");
	        String gender = request.getParameter("gender");
	        String univ = request.getParameter("univ");
	        String id = request.getParameter("enroll");
	        
	        if ((fname == null) || (fname.equals(""))) {
	            al.add("PROVIDE VALID STUDENT NAME...");
	        } else {
	            if(fname instanceof String==false) {
	            	al.add("PROVIDE STUDENT NAME IN CORRECT FORMAT...");            		
	          }
	        }
	        if ((pass == null) || (pass.equals(""))) {
	        	al.add("PROVIDE PASSWORD...");
	        }
	        if (pass.length()<5) {
	        	al.add("PROVIDE PASSWORD of at least 6 characters...");
	        } 
	        if ((gender== null) || (gender.equals(""))) {
	            al.add("PROVIDE STUDENT GENDER...");
	        }
	        if ((univ== null) || (univ.equals(""))) {
	            al.add("PROVIDE STUDENT UNIVERSITY...");
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
	        	RequestDispatcher rd=request.getRequestDispatcher("/signup.html");
	        	rd.include(request, response);
	        } 
	        else {
			// Initialize the database 
			Connection con = DBConnection.initializeDatabase(); 
			 String preQueryStatement = "SELECT * FROM register WHERE enroll = ?;";
			 PreparedStatement pStmnt = con.prepareStatement(preQueryStatement);
			 pStmnt.setInt(1,Integer.parseInt(id));
			 ResultSet rs = pStmnt.executeQuery();
			 if (!rs.next()){

				 PreparedStatement st = con.prepareStatement("insert into register values(?,?,?,?,?,?)"); 
				 
				 // For the first parameter, 
				 // get the data using request object 
				 // sets the data to st pointer 
				 st.setInt(1, Integer.parseInt(id)); 
				 
				 // Same for second parameter 
				 st.setString(2, fname); 
				 st.setString(3, lname);
				 st.setString(4, gender);
				 st.setString(5, pass);
				 st.setString(6, univ);
				 
				 st.executeUpdate(); 
				 st.close(); 
				 con.close(); 
				 PrintWriter out = response.getWriter(); 
				 out.println("<html><body><b><font color='green'>Successfully Inserted"+"</font></b></body></html>"); 
				 RequestDispatcher rd=request.getRequestDispatcher("/login.html");
				 rd.include(request, response);
			// Close all the connections 
			 }
			 else {
				 PrintWriter out = response.getWriter(); 
					out.println("<html><body><b><font color='red'>Record already exists !!"+"</font></b></body></html>");
					RequestDispatcher rd=request.getRequestDispatcher("/signup.html");
		        	rd.include(request, response);
			 }
			// Get a writer pointer 
	        }	// to display the successful result 
		}
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 
