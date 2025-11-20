package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Puga
 */
public class Conexion {
    
    public static Connection obtenerConexion (){
        
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen", "root", "");
            
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conexion;
    }
//    public static void main(String[] args) {
//        Conexion con = new Conexion();
//        con.obtenerConexion();
//    }

}