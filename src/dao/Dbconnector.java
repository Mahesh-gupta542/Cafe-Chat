package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnector {
	static Connection conn= null;
	public static Connection makeConnection()
		{
			try
			{
				Class.forName("org.postgresql.Driver");
				String url="jdbc:postgresql://localhost:5432/cafe_chat_db";
				String user="postgres";
				String password ="superuser";
				conn = DriverManager.getConnection(url,user,password);
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
			System.out.println("Connected to db.");
			return conn;
		}
	public static void close(Connection conn) {
		try {
			if( null != conn )
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
