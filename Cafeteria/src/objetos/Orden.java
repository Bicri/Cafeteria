
package objetos;

/**
 *
 * @author isaac
 */
public class Orden extends Platillo{

    private String idOrden, cliente, fecha, estado, platillos;
    private float total;
    private int cantidad;
    

    public Orden() {
        super();
    }

    public Orden(int cantidad, String IdPlatillo, String NombrePlatillo, float precio) {
        super(IdPlatillo, NombrePlatillo, precio);
        this.cantidad = cantidad;
    }

    public Orden(String idOrden, String cliente, String fecha, String estado, String platillos, float total, int cantidad) {
        this.idOrden = idOrden;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
        this.platillos = platillos;
        this.total = total;
        this.cantidad = cantidad;
    }
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPlatillos() {
        return platillos;
    }

    public void setPlatillos(String platillos) {
        this.platillos = platillos;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", cliente=" + cliente + ", fecha=" + fecha + ", estado=" + estado + ", platillos=" + platillos + ", total=" + total + '}';
    }

 
    
}
