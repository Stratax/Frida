package adr.strata.frida.actores;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono;

    public Persona(){
        nombre = "empty";
        apellido_paterno="empty";
        apellido_materno ="empty";
        telefono = "empty";
    }

    public String getNombre() {
        return nombre;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
