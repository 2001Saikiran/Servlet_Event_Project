package Event_MS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException, ServletException
	   {
		HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	       int id =  Integer.parseInt(req.getParameter("id"));
	       String title= req.getParameter("title");
	       String loc = req.getParameter("loc");
	       String date= (req.getParameter("date"));
	       String guest = req.getParameter("guest");  
	       
	       
	 try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system", "root", "SK02@krhps");
         PreparedStatement ps = con.prepareStatement("update event set title=?,loc=?,date=?,guest=? where id=?");
         ps.setString(1,title);
         ps.setString(2,loc);
         ps.setString(3,date);
         ps.setString(4,guest);
         ps.setInt(5,id);
         int row = ps.executeUpdate();
         PrintWriter pw = res.getWriter();
     	
 		 pw.write("<html><head><style>body { text-align: center; margin-top: 100px; }</style></head><body><h1>Event Updated Successfully</h1></body></html>");
 		
         RequestDispatcher rd = req.getRequestDispatcher("all.jsp");
 		 rd.include(req,res);
 		 
         ps.close();
         con.close();
     } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
     }
 }

}