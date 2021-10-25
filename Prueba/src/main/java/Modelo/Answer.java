package Modelo;

public class Answer {
    
    private int ID;
    private String respuesta;
    private String validacion;
    private int pregunta_id;

    public Answer(int ID, String respuesta, String validacion, int pregunta_id) {
        this.ID = ID;
        this.respuesta = respuesta;
        this.validacion = validacion;
        this.pregunta_id = pregunta_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public int getPregunta_id() {
        return pregunta_id;
    }

    public void setPregunta_id(int pregunta_id) {
        this.pregunta_id = pregunta_id;
    }
    
    
}
