
package objetos;

/**
 *
 * @author isaac
 */
public class Orden {
    
    private String idOrden, cliente, platillos, fecha, estado;
    private float total;

    public Orden() {
    }

    public Orden(String idOrden, String cliente, String platillos, String fecha, String estado, float total) {
        this.idOrden = idOrden;
        this.cliente = cliente;
        this.platillos = platillos;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
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

    public String getPlatillos() {
        return platillos;
    }

    public void setPlatillos(String platillos) {
        this.platillos = platillos;
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

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", cliente=" + cliente + ", platillos=" + platillos + ", fecha=" + fecha + ", estado=" + estado + ", total=" + total + '}';
    }
    
    
    
}
