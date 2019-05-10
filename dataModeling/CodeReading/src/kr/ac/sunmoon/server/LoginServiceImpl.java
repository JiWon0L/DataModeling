package kr.ac.sunmoon.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import kr.ac.sunmoon.client.service.LoginService;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService
{

	@Override
	public boolean login(String id, String pw) 
	{
		boolean returnValue = false;
		try
		{
			String url = "jdbc:mysql://localhost:3306/xxx_lab?useSSL=false";
	        String user = "root";
	        String password = "1234";
			
	        Connection con = DriverManager.getConnection(url, user, password);
	        
			 Statement stmt = con.createStatement();
			 String sql = "select count(*) from user where u_id='" + id + "' and u_pw='" + pw + "';";
			 ResultSet rs = stmt.executeQuery(sql);
			 rs.next();
			 if(rs.getInt(1) == 1)
				 returnValue = true;
			 
			 rs.close();
			 stmt.close();
			 con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return returnValue;
	}
}
