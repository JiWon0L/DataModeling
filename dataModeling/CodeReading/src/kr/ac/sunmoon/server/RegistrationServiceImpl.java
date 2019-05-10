package kr.ac.sunmoon.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import kr.ac.sunmoon.client.service.RegistrationService;
import kr.ac.sunmoon.shared.User;

public class RegistrationServiceImpl extends RemoteServiceServlet implements RegistrationService
{

	@Override
	public Boolean registerUser(User user) 
	{
		try
		{
			String url = "jdbc:mysql://localhost:3306/xxx_lab?useSSL=false";
	        String id = "root";
	        String password = "1234";
			
	        Connection con = DriverManager.getConnection(url, id, password);
	        
			 Statement stmt = con.createStatement();
			 String sql = "select count(*) from user where u_id='" + user.getId() + "';";
			 ResultSet rs = stmt.executeQuery(sql);
			 rs.next();
			 if(rs.getInt(1) > 0)
			 {
				 rs.close();
				 stmt.close();
				 con.close();
				 
				 return new Boolean(false);
			 }
			 
			 sql = "insert into user values('" + user.getId() + "', '" + user.getPw() + "', ";
			 if(user.getEmail() != null)
				 sql += "'" + user.getEmail() + "');";
			 else
				 sql += null + ");";
			 stmt.execute(sql);
			 
			 rs.close();
			 stmt.close();
			 con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new Boolean(true);
	}
}
