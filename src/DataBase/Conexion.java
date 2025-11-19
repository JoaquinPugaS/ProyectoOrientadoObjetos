/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", "");
            
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conexion;
    }
}