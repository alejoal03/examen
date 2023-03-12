package BusinessLogic.Entities;

public class Coordenadas {
    int aaCapacidad;
    String aaGeolocalizacion;
    String aaArsenal;
    
    public Coordenadas(int aaCapacidad, String aaGeolocalizacion, String aaArsenal) {
        this.aaCapacidad = aaCapacidad;
        this.aaGeolocalizacion = aaGeolocalizacion;
        this.aaArsenal = aaArsenal;
    }

    public int getAaCapacidad() {
        return aaCapacidad;
    }

    public void setAaCapacidad(int aaCapacidad) {
        this.aaCapacidad = aaCapacidad;
    }

    public String getAaGeolocalizacion() {
        return aaGeolocalizacion;
    }

    public void setAaGeolocalizacion(String aaGeolocalizacion) {
        this.aaGeolocalizacion = aaGeolocalizacion;
    }

    public String getAaArsenal() {
        return aaArsenal;
    }

    public void setAaArsenal(String aaArsenal) {
        this.aaArsenal = aaArsenal;
    }
}