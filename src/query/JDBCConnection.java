package query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {
    public static Connection getJDBCConnection(){
        final String url = "jdbc:sqlserver://localhost\\DESKTOP-4H2CDN2\\SQLEXPRESS:1433;databaseName=QLDATN";
        final String user = "sa";
        final String password = "MeoLuoi99";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    public static void main(String[] args) {
//        
//        Connection connection = getJDBCConnection();
//        
//        if(connection != null){
//            System.out.println("Thanh cong!");
//        }else{
//            System.out.println("That bai");
//        }
//    }
    
}
