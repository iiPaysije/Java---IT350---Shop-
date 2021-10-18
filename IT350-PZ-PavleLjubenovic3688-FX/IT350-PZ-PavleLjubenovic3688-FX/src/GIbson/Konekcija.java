package GIbson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Konekcija 
{ 
    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/it350-gibson";
    private static String username = "root";
    private static String password = "";
    
    private Konekcija(){
        
    }
    
    public static Connection getInstance()
    {
        if(con == null){
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
