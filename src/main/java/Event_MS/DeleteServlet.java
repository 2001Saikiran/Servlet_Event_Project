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
import java.util.Scanner;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException, ServletException
	   {
		   HttpServletRequest request = (HttpServletRequest) req;
	       HttpServletResponse response = (HttpServletResponse) res;
           int id =  Integer.parseInt(request.getParameter("id"));
             
           Connection con = null;
           PreparedStatement ps = null;
           
           
	 try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system", "root", "SK02@krhps");
         ps = con.prepareStatement("DELETE FROM event WHERE id = ?");
         ps.setInt(1,id);
         int rowsDeleted = ps.executeUpdate();
//       System.out.println(rowsDeleted + " record(s) deleted successfully!");
         int row=  	ps.executeUpdate();
		    
			
			PrintWriter pw=res.getWriter();
			pw.write("<h1>Event Deleted Successfully</h1>");
//			pw.write("<html><body>");
//			pw.write("<script>alert('Event Deleted Successfully');</script>");
//			pw.write("</body></html>");
			RequestDispatcher rd=req.getRequestDispatcher("all");
			rd.include(req, res);
		 
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}