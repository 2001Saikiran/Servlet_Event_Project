
package Event_MS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/create")
public class CreateServlet extends HttpServlet
{
  @Override
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
	int id=  Integer.parseInt(req.getParameter("id"));
	String title = req.getParameter("title");
	String loc = req.getParameter("loc");
	String date = req.getParameter("date");
	String guest = req.getParameter("guest");
	
	System.out.println(id);
	System.out.println(title);
	System.out.println(loc);
	System.out.println(date);
	System.out.println(guest);
	
	 try
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system","root","SK02@krhps");
		PreparedStatement ps = con.prepareStatement("insert into event values(?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2,title);
		ps.setString(3,loc);
		ps.setString(4,date);
		ps.setString(5,guest);
		
		int row = ps.executeUpdate();

		
		PrintWriter pw = res.getWriter();
	
		pw.write("<html><head><style>body { text-align: center; margin-top: 100px; }</style></head><body><h1>Event Created Successfully</h1></body></html>");
		
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req,res);
		ps.close();
		con.close();
		
	  } 
	 catch (ClassNotFoundException | SQLException e)
	  {
		
		e.printStackTrace();
	  } 
	
   }
}