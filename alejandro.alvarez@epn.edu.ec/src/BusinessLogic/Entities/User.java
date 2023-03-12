package BusinessLogic.Entities;

public class User {
    int aaId;
    String aaNombre;
    String aaApellido;
    String aaUsuario;
    String aaContrasena;


    public User(int aaId, String aaNombre, String aaApellido, String aaUsuario, String aaContrasena) {
        this.aaId = aaId;
        this.aaNombre = aaNombre;
        this.aaApellido = aaApellido;
        this.aaUsuario = aaUsuario;
        this.aaContrasena = aaContrasena;
    }

    public int getId() {
        return aaId;
    }

    public void setId(int aaId) {
        this.aaId = aaId;
    }

    public String aaGetNombre() {
        return aaNombre;
    }

    public void aaSetNombre(String aaNombre) {
        this.aaNombre = aaNombre;
    }

    public String aaGetApellido() {
        return aaApellido;
    }

    public void aaSetApellido(String aaApellido) {
        this.aaApellido = aaApellido;
    }

    public String aaGetUsuario() {
        return aaUsuario;
    }

    public void aaSetUsuario(String aaUsuario) {
        this.aaUsuario = aaUsuario;
    }

    public String aaGetContrasena() {
        return aaContrasena;
    }

    public void aaSetaaContrasena(String aaContrasena) {
        this.aaContrasena = aaContrasena;
    }
}

