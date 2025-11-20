
package Model;

public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private int tipoProducto;       // cdtpUnidadMedida
    private String fechaExpiracion; // fcExpiracion
    private int marca;              // cdtpMarca
    private double medida;          // medida
    private int clase;              // cdtpClase

    // Constructor SIN ID para insertar
    public Producto(String nombre, double precio, int tipoProducto, String fechaExpiracion,
                    int marca, double medida, int clase) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.fechaExpiracion = fechaExpiracion;
        this.marca = marca;
        this.medida = medida;
        this.clase = clase;
    }

    // Constructor CON ID para listar
    public Producto(int idProducto, String nombre, double precio, int tipoProducto,
                String fechaExpiracion, int marca, double medida, int clase) {
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
    public double getPrecio() { return precio; }
    public int getTipoProducto() { return tipoProducto; }
    public String getFechaExpiracion() { return fechaExpiracion; }
    public int getMarca() { return marca; }
    public double getMedida() { return medida; }
    public int getClase() { return clase; }

    // SETTERS
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setTipoProducto(int tipoProducto) { this.tipoProducto = tipoProducto; }
    public void setFechaExpiracion(String fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }
    public void setMarca(int marca) { this.marca = marca; }
    public void setMedida(double medida) { this.medida = medida; }
    public void setClase(int clase) { this.clase = clase; }
}
