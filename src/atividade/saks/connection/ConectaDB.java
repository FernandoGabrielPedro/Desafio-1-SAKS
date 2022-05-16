package atividade.saks.connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectaDB {
    static final String URL = "jdbc:mysql://localhost:3306/cadastro";
    static final String USER = "root";
    static final String PASS = "";
    
    public static Connection createConnectionMySQL(){
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(ConectaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return connection;
    }
}