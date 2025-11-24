package Model.DAO;

import Model.GetInventario;
import DataBase.Conexion;
import Model.Inventario;
import Model.Producto;
import Model.TpClase;
import Model.TpMarca;
import Model.TpMedida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.*;



public class GestionInventarioDAO {

    public boolean agregar(Producto p,Inventario inv) {
        try (Connection cnx = Conexion.obtenerConexion()) {

            String sql = "INSERT INTO producto "
                       + "(nmProducto, precioProducto, cdtpUnidadMedida, fcExpiracion, cdtpMarca, medida, cdtpClase,fcingreso) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?,now())";

            PreparedStatement stmt = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, p.getNombre());             
            stmt.setDouble(2, p.getPrecio());              
            stmt.setInt(3, p.getTipoProducto());           
            stmt.setTimestamp(4,p.getFechaExpiracion() == null ? null :Timestamp.valueOf(p.getFechaExpiracion()));     
            stmt.setInt(5, p.getMarca());                 
            stmt.setDouble(6, p.getMedida());              
            stmt.setInt(7, p.getClase());                 

            stmt.executeUpdate();
            ResultSet  rs = stmt.getGeneratedKeys();
            
            if(!rs.next()){
                throw new SQLException("error al insertar");
            }
            
            
            
            String query = """
                           insert into inventario 
                           (idproducto, stockcritico,stock)
                           values (?,?,?)
                           """;
            
            PreparedStatement stm = cnx.prepareStatement(query);
            
            stm.setInt(1, rs.getInt(1));
            stm.setInt(2,inv.getStock());
            stm.setInt(3,inv.getStockCritico());
            
            stm.executeUpdate();
            
            return true;

        } catch (Exception e) {
            System.out.println("Error en ProductoDAO.agregar: " + e.getMessage());
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
        public List<GetInventario> listarParaCompra() {
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
                         inventario i on i.idproducto = p.idproducto and p.fcexpiracion is not null inner join 
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
                    rs.getInt("precioProducto"),
                    rs.getInt("cdtpUnidadMedida"),
                    rs.getTimestamp("fcExpiracion").toLocalDateTime(),
                    rs.getInt("cdtpMarca"),
                    rs.getInt("medida"),
                    rs.getInt("cdtpClase")
                );
            }

    } catch (Exception e) {
        System.out.println("Error : " + e.getMessage());
    }
    return null;
}

    public boolean actualizar(Producto p, Inventario inv) {
        try (Connection cnx = Conexion.obtenerConexion()) {

            String sql = "UPDATE producto SET "
                    + "nmProducto=?, precioProducto=?, cdtpUnidadMedida=?, fcExpiracion=?, "
                    + "cdtpMarca=?, medida=?, cdtpClase=? "
                    + "WHERE idProducto=?";

            PreparedStatement stmt = cnx.prepareStatement(sql);

            stmt.setString(1, p.getNombre());
            stmt.setDouble(2, p.getPrecio());
            stmt.setInt(3, p.getTipoProducto());
            stmt.setTimestamp(4,p.getFechaExpiracion() == null ? null : Timestamp.valueOf(p.getFechaExpiracion()));
            stmt.setInt(5, p.getMarca());
            stmt.setDouble(6, p.getMedida());
            stmt.setInt(7, p.getClase());
            stmt.setInt(8, p.getIdProducto());

            stmt.executeUpdate();
            
            String query = """
                           update inventario
                           set stock = ?
                           where idInventario = ?
                           """;
            
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setInt(1,inv.getStock());
            stm.setInt(2, inv.getIdInventario());
            
            stm.executeUpdate();
            
            
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
                rs.getInt("precioProducto"),                  
                rs.getInt("cdtpUnidadMedida"),                   
                rs.getTimestamp("fcExpiracion") != null 
    ? rs.getTimestamp("fcExpiracion").toLocalDateTime() 
    : null,
                rs.getInt("cdtpMarca"),                         
                rs.getInt("medida"),                          
                rs.getInt("cdtpClase")
            );                         

        }catch(Exception e){
               System.out.println(e.getMessage());
            return null;
        }
        
    }

    public boolean expirarProducto(int idProducto) {
        
           try(Connection con = Conexion.obtenerConexion()){
            String query = "update producto set fcexpiracion= now() where idproducto = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, idProducto);
            
            stm.executeUpdate();
            
            return true;


        }catch(Exception e){
               System.out.println(e.getMessage());
               return false;
               
        }
        
    }

    public boolean agregarMarca(String nmMarca) {
         try (Connection cnx = Conexion.obtenerConexion()) {

            String sql = "INSERT INTO tpMarca "
                       + "(nmmarca,lgEliminado) "
                       + "VALUES (?,0)";

            PreparedStatement stmt = cnx.prepareStatement(sql);

            stmt.setString(1, nmMarca);


            stmt.executeUpdate();
            
            return true;

        } catch (Exception e) {
            System.out.println("Error en ProductoDAO.agregar: " + e.getMessage());
            
            return false;
        }
    }
    
    public  List<TpMarca> getMarca(){
        List<TpMarca> listamarca = new ArrayList<>();
        
        try(Connection con = Conexion.obtenerConexion()){
            String query = """
                           select * from tpmarca where lgeliminado <> 1
                           """;
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet resultSet = stm.executeQuery();
            
            while(resultSet.next()){
                listamarca.add(new TpMarca(resultSet.getInt("cdtpmarca"), resultSet.getString("nmMarca"), resultSet.getBoolean("lgEliminado")));
            }
            return listamarca;
            
            
            
            
        }catch(Exception e){}
        
        return null;
    }

    public List<TpMedida> getUnidadMedida() {
        List<TpMedida> listaMedida = new ArrayList<>();
        
        try(Connection con = Conexion.obtenerConexion()){
            String query = """
                           select * from tpmedida where lgeliminado <> 1
                           """;
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet resultSet = stm.executeQuery();
            
            while(resultSet.next()){
                listaMedida.add(new TpMedida(resultSet.getInt("cdtpUnidadMedida"), resultSet.getString("nmUnidadMedida"), resultSet.getBoolean("lgEliminado")));
            }
            return listaMedida;
            
            
            
            
        }catch(Exception e){
           System.out.println(e.getMessage());
        return null;
        }
        
    }

    public List<TpClase> getClases() {
                List<TpClase> listaClase = new ArrayList<>();
        
        try(Connection con = Conexion.obtenerConexion()){
            String query = """
                           select * from tpclase where lgeliminado <> 1
                           """;
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet resultSet = stm.executeQuery();
            
            while(resultSet.next()){
                listaClase.add(new TpClase(resultSet.getInt("cdtpclase"), resultSet.getString("nmClase"), resultSet.getBoolean("lgEliminado")));
            }
            return listaClase;
            
            
            
            
        }catch(Exception e){
           System.out.println(e.getMessage());
        return null;
        }
        
    }

}





