package ajpProject;

import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Result extends HttpServlet  {
	private static final long serialVersionUID = 1L; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
	        response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	    
	        String q1=request.getParameter("q1");
	        String q2=request.getParameter("q2");
	        String q3=request.getParameter("q3");
	        String q4=request.getParameter("q4");
	        String q5=request.getParameter("q5");
	        int marks=0;
	        if(q1==null&&q2==null&&q3==null&&q4==null&&q5==null) {
	        	pw.println("<font color=red><b>Looks like you didn't select an option for any of the questions !!</b></font>");
	        	request.getRequestDispatcher("final.html").include(request, response);
	        }else {
	        try {
	        if(q1!=null&&q1.equals("C"))
	        	marks++;
	        if(q2!=null&&q2.equals("D"))
	        	marks++;
	        if(q3!=null&&q3.equals("B"))
	        	marks++;
	        if(q4!=null&&q4.equals("B"))
	        	marks++;
	        if(q5!=null&&q5.equals("A"))
	        	marks++;
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	        pw.println("<h3>Final Score: "+marks+"</h3>");
	        request.getRequestDispatcher("final.html").include(request, response);
	        }
	        pw.close();
}
	}
