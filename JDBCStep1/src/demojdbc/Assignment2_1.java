package demojdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment2_1 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String user = "postgres";
        String password = "Ravalisai@9";

        String query = "SELECT * FROM imagess";

        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {

            System.out.println(rs.getFetchSize());
            while(rs.next())
            {
        	//rs.next();
            
            File myFile = new File("src1/download1.png");

            try (FileOutputStream fos = new FileOutputStream(myFile)) {

                byte[] buf = rs.getBytes("image");
                fos.write(buf);
            }
            
            }
        } catch (IOException | SQLException ex) {

            Logger lgr = Logger.getLogger(Assignment2_1.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}