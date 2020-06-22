
package objetos;

/**
 *
 * @author isaac
 */
public class Platillo {
    
    private String IdPlatillo, NombrePlatillo;
    private float precio;

    public Platillo() {
    }

    public Platillo(String IdPlatillo, String NombrePlatillo, float precio) {
        this.IdPlatillo = IdPlatillo;
        this.NombrePlatillo = NombrePlatillo;
        this.precio = precio;
    }

    public String getIdPlatillo() {
        return IdPlatillo;
    }

    public void setIdPlatillo(String IdPlatillo) {
        this.IdPlatillo = IdPlatillo;
    }

    public String getNombrePlatillo() {
        return NombrePlatillo;
    }

    public void setNombrePlatillo(String NombrePlatillo) {
        this.NombrePlatillo = NombrePlatillo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Platillo{" + "IdPlatillo=" + IdPlatillo + ", NombrePlatillo=" + NombrePlatillo + ", precio=" + precio + '}';
    }
    
}
