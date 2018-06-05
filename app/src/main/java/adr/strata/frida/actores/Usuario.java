package adr.strata.frida.actores;



import java.io.Serializable;
import java.util.List;

public class Usuario extends Persona{


    private String email;
    private String contrasenia;
    private int edad;
    private String calle;
    private String casa_no;
    private String colonia;
    private String estado;
    private String delegacion;
    private String tpo_sangre;
    private String cp;
    private Contacto contactos[];

    public Usuario() {
        email = "empty";
        contrasenia = "empty";
        edad = 0;
        calle = "empty";
        casa_no = "empty";
        colonia = "empty";
        estado = "empty";
        delegacion = "empty";
        tpo_sangre = "empty";
        cp = "empty";
        contactos = new Contacto[3];
    }

    public void agregarContacto(Contacto c, int pos){
        contactos[pos] = c;
    }
    public Contacto getContacto(int pos){
        return contactos[pos];
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }


    public String getCasa_no() {
        return casa_no;
    }

    public void setCasa_no(String casa_no) {
        this.casa_no = casa_no;
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
