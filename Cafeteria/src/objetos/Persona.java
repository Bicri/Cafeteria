
package objetos;

/**
 *
 * @author isaac
 */
public class Persona {
    
    protected String nombre, primerApellido, segundoApellido, sexo;

    public Persona() {
    }
    

    public Persona(String nombre, String primerApellido, String segundoApellido, String sexo) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
    }


    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", sexo=" + sexo + '}';
    } 
    
}
