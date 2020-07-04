
package objetos;

/**
 *
 * @author isaac
 */
public class Empleado extends Persona{
    
    private String numeroEmpleado;
    private String telefono;
    private String correo, cargo, contraseña;

    public Empleado()
    {
        super();
    }

    public Empleado(String numeroEmpleado, String telefono, String correo, String cargo, String contraseña, String nombre, String primerApellido, String segundoApellido, String sexo) {
        super(nombre, primerApellido, segundoApellido, sexo);
        this.numeroEmpleado = numeroEmpleado;
        this.telefono = telefono;
        this.correo = correo;
        this.cargo = cargo;
        this.contraseña = contraseña;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "numeroEmpleado=" + numeroEmpleado + ", telefono=" + telefono + ", correo=" + correo + ", cargo=" + cargo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}
