package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;

 

public class Assignment1 {
    private static List<Connection> ConnectionsPresent = new ArrayList<Connection>();
    
    private static final String user = "postgres";
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String password = "Ravalisai@9";
    
    
    static Connection returnConnection() throws SQLException
    {
        Connection con;
        con = DriverManager.getConnection(url,user,password);
        return con;
    }
    
    static public int getFreeConnectionCount()
    {
        return ConnectionsPresent.size();
    }
    
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        try
        {
            
            while(true)
            {
                System.out.println("\n1:connection\n2:size\n3:Exit\nEnter your choice");
                int choice = sc.nextInt();
                
                switch(choice)
                {
                    case 1: Connection connection = returnConnection();
                            System.out.println("New connection is at" + (getFreeConnectionCount()+1) + " and it is " + connection);
                            ConnectionsPresent.add(connection);
                            break;
                    case 2: System.out.println("Total connections" + getFreeConnectionCount());
                            break;
                    case 3: System.exit(0);
                    default:System.out.println("wrong input"); 
                }
            }
            
            
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

 

}
 
