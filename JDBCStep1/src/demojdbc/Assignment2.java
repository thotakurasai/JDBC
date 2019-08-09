package demojdbc;
	

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
	import java.util.logging.Logger;

	public class Assignment2 {

	    public static void main(String[] args) {

	        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	        String user = "postgres";
	        String password = "Ravalisai@9";
	        String tablesql = "CREATE TABLE IF NOT EXISTS imagess(image bytea)";

	        String query = "INSERT INTO imagess VALUES(?)";

	        
	        try (Connection con = DriverManager.getConnection(url, user, password);
	                ) {
	        	
	    		

	        	Statement stmt = con.createStatement();
	    		stmt.execute(tablesql);
	    		PreparedStatement pst = con.prepareStatement(query);
	            File img = new File("src/output.png");

	            try (FileInputStream fin = new FileInputStream(img)) {

	                pst.setBinaryStream(1, fin, (int) img.length());
	                pst.executeUpdate();
	            } catch (IOException ex) {
	                Logger.getLogger(Assignment2.class.getName()).log(
	                        Level.SEVERE, ex.getMessage(), ex);
	            }

	        } catch (SQLException ex) {

	            Logger lgr = Logger.getLogger(Assignment2.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);
	        }
	    }
	}