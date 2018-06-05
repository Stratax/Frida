package adr.strata.frida.actores;

public class Contacto extends Persona {
    private String parentesco;

    public Contacto(){
        parentesco = "empty";
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
