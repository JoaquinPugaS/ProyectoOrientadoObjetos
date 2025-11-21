package Model;

import DataBase.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;



public class GestionInventarioDAO {

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
    public List<GetInventario> listar() {
        List<GetInventario> lista = new ArrayList<>();

        try (Connection con = Conexion.obtenerConexion()) {
            String sql = """
                         select 
                         idinventario,i.idProducto,
                         nmProducto,medida,u.nmunidadmedida,
                         precioProducto,i.stock, CASE 
                                 WHEN fcExpiracion IS NULL THEN 0 
                                 ELSE 1 
                             END AS eliminado
                         
                         from 
                         producto p inner join 
                         inventario i on i.idproducto = p.idproducto inner join 
                         tpMedida u on u.cdtpunidadmedida = p.cdtpunidadmedida;
                         
                         """;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GetInventario p = new GetInventario(
                    rs.getInt("idinventario"),
                    rs.getInt("idProducto"),
                    rs.getString("nmProducto"),
                    rs.getInt("medida"),
                    rs.getString("nmunidadmedida"),
                    rs.getInt("precioProducto"),
                    rs.getInt("stock"),
                    rs.getBoolean("eliminado")
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
            String sql = "SELECT * FROM inventario WHERE idinventario = ?";
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

    public Inventario buscarEnInventarioPorId(int idInventario) {
        try(Connection con = Conexion.obtenerConexion()){
            String query = "select * from inventario where idinventario = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, idInventario);
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()){
                return new Inventario(
                    rs.getInt("idinventario"),
                    rs.getInt("idproducto"),
                    rs.getInt("stockcritico"),
                    rs.getInt("stock")
            );
            }
            return null;
            
        }catch(Exception e){
            return null;
        }
        
    }

    public Producto findProductoById(int idProducto) {
        
        System.out.println("idproducto" + idProducto);
        
        
           try(Connection con = Conexion.obtenerConexion()){
            String query = "select * from producto where idproducto = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, idProducto);
            
            ResultSet rs = stm.executeQuery();
               System.out.println("aaaaaaaaa");
            System.out.println("valor de rsnext: " + rs.next());
            
          
          

            return new Producto(
                rs.getInt("idProducto"),                         
                rs.getString("nmProducto"),                      
                rs.getDouble("precioProducto"),                  
                rs.getInt("cdtpUnidadMedida"),                   
                rs.getTimestamp("fcExpiracion") != null ? rs.getTimestamp("fcExpiracion").toString(): null,
                rs.getInt("cdtpMarca"),                         
                rs.getDouble("medida"),                          
                rs.getInt("cdtpClase")
            );                         

        }catch(Exception e){
               System.out.println(e.getMessage());
            return null;
        }
        
    }

    public void expirarProducto(int idProducto) {
        
           try(Connection con = Conexion.obtenerConexion()){
            String query = "update producto set fcexpiracion= now() where idproducto = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, idProducto);
            
            stm.executeUpdate();


        }catch(Exception e){
               System.out.println(e.getMessage());
               
        }
        
    }


}





