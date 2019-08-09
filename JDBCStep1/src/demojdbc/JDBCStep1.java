package demojdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;


public class JDBCStep1 {
	private static final String user = "postgres";
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String password = "Ravalisai@9";
	
	public static void main(String[] args)
	{
		try {	
			//Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("established");
		//Statement smt = con.createStatement();
		String tablesql = "CREATE TABLE IF NOT EXISTS employees(emp_id SERIAL PRIMARY KEY,name varchar(30),position varchar(30),salary bigint)";
		Statement stmt = con.createStatement();
		stmt.execute(tablesql);
		
		PreparedStatement stm=con.prepareStatement("SELECT * FROM employees");
		
		
			
			 ResultSet rs=stm.executeQuery(); 
			 while(rs.next()){
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)); }
			   
		con.close();  
		} catch(SQLException e) {
			System.out.println("failed to connect to database");
			e.printStackTrace();
		}
	}
}
