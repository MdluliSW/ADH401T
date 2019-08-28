/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login.form;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class DbConnect {
    public Connection conn = null;
    void connect() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/validClient?"
                    +"user=root&password=";
            conn = DriverManager.getConnection(connectionUrl);
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        Statement createStatement(){
            try 
            {
            return conn.createStatement();    
            
        } catch (SQLException ex){
            
            System.out.println("The SQL Exception is "+ ex.toString());
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null,ex);
            return null;
        }
    }
    CallableStatement prepareCall(String sql) {
        try {
            return conn.prepareCall(sql);
        }catch(SQLException exe){
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, exe);
            return null;
        }
        
    }
}
