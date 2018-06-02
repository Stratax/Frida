package adr.strata.frida.actores;



import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {

    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String email;
    private String contrasenia;
    private String telefono;
    private int edad;
    private String calle;
    private String casa_no;
    private String colonia;
    private String estado;
    private String delegacion;
    private String tpo_sangre;
    private String cp;

    public Usuario() {
        nombre = "empty";
        apellido_paterno = "empty";
        apellido_materno = "empty";
        email = "empty";
        contrasenia = "empty";
        telefono = "empty";
        edad = 0;
        calle = "empty";
        casa_no = "empty";
        colonia = "empty";
        estado = "empty";
        delegacion = "empty";
        tpo_sangre = "empty";
        cp = "empty";
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCasa_no() {
        return casa_no;
    }

    public void setCasa_no(String casa_no) {
        this.casa_no = casa_no;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getTpo_sangre() {
        return tpo_sangre;
    }

    public void setTpo_sangre(String tpo_sangre) {
        this.tpo_sangre = tpo_sangre;
    }

    public void registroUsuario(List lista){
        lista.add(this);
    }


}
