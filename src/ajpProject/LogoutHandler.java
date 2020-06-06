package ajpProject;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class LogoutHandler extends HttpServlet {  
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
      response.setContentType("text/html");  
      PrintWriter out=response.getWriter();  
        
        
        
      Cookie ck=new Cookie("name","");  
      ck.setMaxAge(0);  
      response.addCookie(ck);  
        
      out.print("<font color='green'><b>You have successfully logged out!</b></font>");  
      request.getRequestDispatcher("login.html").include(request, response);  
  }  
}  