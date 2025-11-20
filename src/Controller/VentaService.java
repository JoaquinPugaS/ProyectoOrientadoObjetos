/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataBase.Conexion;
import Model.DTO.ProductoDTO;
import Model.DTO.VentaDTO;
import Model.DetalleVenta;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Puga
 */
public class VentaService {

    public void guardarVenta(VentaDTO venta) {
        Conexion con = new Conexion();
        Connection conn = con.obtenerConexion();
        
        venta = new VentaDTO(new ArrayList<ProductoDTO>(){{add(new ProductoDTO(3, 10));}},venta.getTpMetodoPago());
        
        if (!conn.equals(null)) {
            try {
                String insertVenta = "insert into venta (fcIngreso,cdtpMetodoPago) values (now(),?)";
                conn.setAutoCommit(false);

                PreparedStatement st = conn.prepareStatement(insertVenta, Statement.RETURN_GENERATED_KEYS);
                st.setInt(1, venta.getTpMetodoPago());

                st.executeUpdate();
                ResultSet  rs = st.getGeneratedKeys();
                
                 if (!rs.next()) {
                    throw new SQLException("no se inserta Venta");
                }
                 int idVenta = rs.getInt(1);
                 System.out.println("idventa" + idVenta);
                
                for(ProductoDTO i : venta.getDetalleVenta()){
                    String insertDetalleVenta = "insert into detalleVenta (idVenta,idinventario,cantidad) values (?,?,?)";
                    PreparedStatement st2 = conn.prepareStatement(insertDetalleVenta);
                    st2.setInt(1, idVenta);
                    st2.setInt(2, i.getIdInventario());
                    st2.setInt(3, i.getCantidadProducto());
                    
                    st2.executeUpdate();
                    
                    String updateProducto = "update inventario set stock = stock - ? where idinventario = ?";
                    PreparedStatement st3 = conn.prepareStatement(updateProducto);
                    st3.setInt(1, i.getCantidadProducto());
                    st3.setInt(2, i.getIdInventario());
                    
                    st3.executeUpdate();
                    
                }
                
                    
                
               
                conn.commit();
                st.close();
            } catch (SQLException ex) {

                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }

                ex.printStackTrace();

            } finally {

                try {
                    conn.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }

            }
        }
    }
    

}
