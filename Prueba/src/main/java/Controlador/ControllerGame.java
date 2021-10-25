package Controlador;

import Modelo.ManagerGame;
import Modelo.Question;
import Modelo.Records;
import Modelo.Answer;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControllerGame {
    Modelo.ManagerGame  gestorjuego;
    Scanner input = new Scanner(System.in);
    LinkedList<Answer> listRespuesta;
    LinkedList<Records> listRecord;
    Question pregunta = null;
    Record record = null;

    public ControllerGame() {
        gestorjuego = new ManagerGame();
    }
    
    public Question guardarPregunta (String pregunta ,int nivel) throws SQLException{
        return gestorjuego.guardarPregunta(pregunta, nivel);
    }
    
    public boolean guardarRepuesta (String respuestasNuevas[] ,int pregunta_id){
        return gestorjuego.guardarRespuesta(respuestasNuevas, pregunta_id);
    }
    
    public Question buscarPregunta (int nivel) throws SQLException{
        return gestorjuego.buscarPregunta(nivel);
    }
    
    public LinkedList <Answer> buscarRespuesta (int ID) throws SQLException{
        return gestorjuego.buscarRespuesta(ID);
    }
    
    public int ejecutarNivel(int nivel) throws SQLException {
        int contador = 1;
        int correcto = 0;
        pregunta = buscarPregunta(nivel);
        listRespuesta = buscarRespuesta(pregunta.getID());
        System.out.println("Lea detenidamente la pregunta y deacuerdo a la opcion que considere correcta, marque el indicador que corresponda,\n o escriba 5 si desea finalizar el juego y guardar el acumulado de puntos que tenga.");
        System.out.println("\nNIVEL " + nivel + "\n"
                + " " + pregunta.getPregunta() + "\n");
        for (Answer respuesta : listRespuesta) {
            System.out.println(contador + ". " + respuesta.getRespuesta()+"\n");
            if (respuesta.getValidacion().equals("V")) {
                correcto = contador;
            }
            contador++;
        }
        int respuestaJugador = input.nextInt();
        if (respuestaJugador == correcto) {
            nivel++;
        } else {
            if (respuestaJugador == 5) {
                nivel = 7;
            }else{
                if (respuestaJugador == 6) {
                    nivel = 6;
                }else {
                    nivel = 0;
                }
            }
        }
        return nivel;
    }
    
    public boolean guardarResultado (String nombre ,int acumulado){
        return gestorjuego.guardarResultado(nombre, acumulado);
    }
    
    public LinkedList <Records> buscarRecord () throws SQLException{
        return gestorjuego.buscarRecord();
    }
    
    public void mostrarRecord () throws SQLException{
        listRecord = gestorjuego.buscarRecord();
        int contador = 1;
        for (Records record : listRecord) {
            System.out.println(contador + ". " + record.getNombre()+" "+record.getPuntaje()+"\n");
            contador++;
        }
    }
}
