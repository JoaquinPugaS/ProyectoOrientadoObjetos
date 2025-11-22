
package Model;

import java.time.LocalDateTime;

public class Producto {

    private int idProducto;
    private String nombre;
    private int precio;
    private int tipoProducto;       // cdtpUnidadMedida
    private LocalDateTime fechaExpiracion; // fcExpiracion
    private int marca;              // cdtpMarca
    private int medida;          // medida
    private int clase;              // cdtpClase

    // Constructor SIN ID para insertar
    public Producto(String nombre, int precio, int tipoProducto, LocalDateTime fechaExpiracion,
                    int marca, int medida, int clase) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.fechaExpiracion = fechaExpiracion;
        this.marca = marca;
        this.medida = medida;
        this.clase = clase;
    }

    // Constructor CON ID para listar
    public Producto(int idProducto, String nombre, int precio, int tipoProducto,
                LocalDateTime fechaExpiracion, int marca, int medida, int clase) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.fechaExpiracion = fechaExpiracion;
        this.marca = marca;
        this.medida = medida;
        this.clase = clase;
}



    // GETTERS
    public int getIdProducto() { return idProducto; }
    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }
    public int getTipoProducto() { return tipoProducto; }
    public LocalDateTime getFechaExpiracion() { return fechaExpiracion; }
    public int getMarca() { return marca; }
    public int getMedida() { return medida; }
    public int getClase() { return clase; }

    // SETTERS
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(int precio) { this.precio = precio; }
    public void setTipoProducto(int tipoProducto) { this.tipoProducto = tipoProducto; }
    public void setFechaExpiracion(LocalDateTime fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }
    public void setMarca(int marca) { this.marca = marca; }
    public void setMedida(int medida) { this.medida = medida; }
    public void setClase(int clase) { this.clase = clase; }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", tipoProducto=" + tipoProducto + ", fechaExpiracion=" + fechaExpiracion + ", marca=" + marca + ", medida=" + medida + ", clase=" + clase + '}';
    }
    
}
