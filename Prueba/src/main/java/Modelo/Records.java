package Modelo;

public class Records {
    private int ID;
    private String nombre;
    private int puntaje;

    public Records(int ID, String nombre, int puntaje) {
        this.ID = ID;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
}
