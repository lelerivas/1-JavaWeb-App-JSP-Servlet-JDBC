package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	private final String URL = "jdbc:mysql://localhost:3306/registerstaff";
	private final String USER = "root";
	private final String PASSWORD = "123456";
	
	protected Connection conn;
	protected PreparedStatement stmt; 
	protected ResultSet rs;
	
	protected final void openConecction() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL,USER, PASSWORD);
	}
	
	protected final void closeConecction() throws Exception{
		if(conn != null){
			conn.close();
		}
	}
}