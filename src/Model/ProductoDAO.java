package Model;

import DataBase.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;



public class ProductoDAO {

    public boolean agregar(Producto p) {
        try (Connection cnx = Conexion.obtenerConexion()) {

            String sql = "INSERT INTO producto "
                       + "(nmProducto, precioProducto, cdtpUnidadMedida, fcExpiracion, cdtpMarca, medida, cdtpClase) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = cnx.prepareStatement(sql);

            stmt.setString(1, p.getNombre());              // nmProducto
            stmt.setDouble(2, p.getPrecio());              // precioProducto
            stmt.setInt(3, p.getTipoProducto());           // cdtpUnidadMedida
            stmt.setString(4, p.getFechaExpiracion());     // fcExpiracion
            stmt.setInt(5, p.getMarca());                  // cdtpMarca
            stmt.setDouble(6, p.getMedida());              // medida
            stmt.setInt(7, p.getClase());                  // cdtpClase

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error en ProductoDAO.agregar: " + e.getMessage());
            return false;
        }
    }
    public boolean eliminar(int idProducto) {
        try (Connection cnx = Conexion.obtenerConexion()) {

            String sql = "DELETE FROM producto WHERE idProducto = ?";
            PreparedStatement stmt = cnx.prepareStatement(sql);

            stmt.setInt(1, idProducto);

            int filas = stmt.executeUpdate();
            return filas > 0; 

        } catch (Exception e) {
            System.out.println("Error en ProductoDAO.eliminar: " + e.getMessage());
            return false;
        }
    }
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();

        try (Connection con = Conexion.obtenerConexion()) {
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("idProducto"),
                    rs.getString("nmProducto"),
                    rs.getDouble("precioProducto"),
                    rs.getInt("cdtpUnidadMedida"),
                    rs.getString("fcExpiracion"),
                    rs.getInt("cdtpMarca"),
                    rs.getDouble("medida"),
                    rs.getInt("cdtpClase")
                );

                lista.add(p);
}


        } catch (Exception e) {
            System.out.println("Error listar productos: " + e.getMessage());
        }
        return lista;
    }
    
    public Producto obtenerPorId(int id) {
        try (Connection cnx = Conexion.obtenerConexion()) {
            String sql = "SELECT * FROM producto WHERE idProducto = ?";
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Producto(
                    rs.getInt("idProducto"),
                    rs.getString("nmProducto"),
                    rs.getDouble("precioProducto"),
                    rs.getInt("cdtpUnidadMedida"),
                    rs.getString("fcExpiracion"),
                    rs.getInt("cdtpMarca"),
                    rs.getDouble("medida"),
                    rs.getInt("cdtpClase")
                );
            }

    } catch (Exception e) {
        System.out.println("Error : " + e.getMessage());
    }
    return null;
}

    public boolean actualizar(Producto p) {
        try (Connection cnx = Conexion.obtenerConexion()) {

            String sql = "UPDATE producto SET "
                    + "nmProducto=?, precioProducto=?, cdtpUnidadMedida=?, fcExpiracion=?, "
                    + "cdtpMarca=?, medida=?, cdtpClase=? "
                    + "WHERE idProducto=?";

            PreparedStatement stmt = cnx.prepareStatement(sql);

            stmt.setString(1, p.getNombre());
            stmt.setDouble(2, p.getPrecio());
            stmt.setInt(3, p.getTipoProducto());
            stmt.setString(4, p.getFechaExpiracion());
            stmt.setInt(5, p.getMarca());
            stmt.setDouble(6, p.getMedida());
            stmt.setInt(7, p.getClase());
            stmt.setInt(8, p.getIdProducto());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
            return false;
        }
}


}





