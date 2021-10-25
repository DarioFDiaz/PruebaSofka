package Modelo;

public class Question {
    private int ID;
    private String pregunta;
    private int nivel;

    public Question(int ID, String pregunta, int nivel) {
        this.ID = ID;
        this.pregunta = pregunta;
        this.nivel = nivel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
