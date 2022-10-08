package domain;

public class Persona {
    private int idPersona;
    private String nombre;
    private String email;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Persona(int idPersona, String nombre, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.email = email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", email=" + email + "]";
    }
}
