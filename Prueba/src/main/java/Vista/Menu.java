package Vista;

import Controlador.ControllerGame;
import Modelo.Question;
import Modelo.Answer;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Menu {

    public Menu() {

    }

    public static void menu() throws SQLException {
        ControllerGame controladorJuego = new ControllerGame();
        int programa = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Hola, bienvenido a preguntados Sofka");
        System.out.println("Por favor indique la accion que desea ejecutar escribiendo el numero según corresponda:");
        while (programa == 1) {
            System.out.println("1. Iniciar el juego.\n"
                    + "2. Historial de resultados\n"
                    + "3. Configurar juego\n"
                    + "4. Salir");
            int accion = input.nextInt();
            System.out.println("\n");
            //Validar menu de opciones
            if (accion < 1 || accion > 4) {
                System.out.println("Digite por favor un número correcto");
            } else {
                if (accion == 4) {
                    programa = 0;
                }
            }
            switch (accion) {
                //Iniciar juego
                case 1:
                    int nivel = 1;
                    int acumulado = 0;
                    String nombre = "";
                    while (nivel > -1 ) {
                        switch (nivel) {
                            case 0:
                                JOptionPane.showMessageDialog(null, "---INCORRECTO---\nLa respuesta indicada es incorrecta, has perdido todos tus puntos.");
                                nombre = JOptionPane.showInputDialog(null, "Digite su nombre para guardar el resultado.");
                                if (controladorJuego.guardarResultado(nombre, acumulado)) {
                                    JOptionPane.showMessageDialog(null, "Su resultado ha sido guardado con exito.");
                                }
                                nivel = -1;
                                break;
                            case 1:
                                nivel = controladorJuego.ejecutarNivel(nivel);
                                if (nivel == 2) {
                                    acumulado = 100000;
                                    JOptionPane.showMessageDialog(null, "---CORRECTO---\nAcabas de acumular: " + acumulado + " puntos.");
                                }
                                break;
                            case 2:
                                nivel = controladorJuego.ejecutarNivel(nivel);
                                if (nivel == 3) {
                                    acumulado = 200000;
                                    JOptionPane.showMessageDialog(null, "---CORRECTO---\nAcabas de acumular: " + acumulado + " puntos.");
                                }
                                break;
                            case 3:
                                nivel = controladorJuego.ejecutarNivel(nivel);
                                if (nivel == 4) {
                                    acumulado = 500000;
                                    JOptionPane.showMessageDialog(null, "---CORRECTO---\nAcabas de acumular: " + acumulado + " puntos.");
                                }
                                break;
                            case 4:
                                nivel = controladorJuego.ejecutarNivel(nivel);
                                if (nivel == 5) {
                                    acumulado = 1000000;
                                    JOptionPane.showMessageDialog(null, "---CORRECTO---\nAcabas de acumular: " + acumulado + " puntos.");
                                }
                                break;
                            case 5:
                                nivel = controladorJuego.ejecutarNivel(nivel);
                                if (nivel == 6) {
                                    acumulado = 2000000;
                                    JOptionPane.showMessageDialog(null, "---FELICITACIONES---\nAcabas de ganar el juego, finalizas con: " + acumulado + " puntos.");
                                    nombre = JOptionPane.showInputDialog(null, "Digite su nombre para guardar el resultado.");
                                    if (controladorJuego.guardarResultado(nombre, acumulado)) {
                                        JOptionPane.showMessageDialog(null, "Su resultado ha sido guardado con exito.");
                                    }
                                    nivel = -1;
                                }
                                break;
                            case 7:
                                JOptionPane.showMessageDialog(null, "---Fin del juego---\nTe retiras del juego con: " + acumulado + " puntos.");
                                nombre = JOptionPane.showInputDialog(null, "Digite su nombre para guardar el resultado.");
                                if (controladorJuego.guardarResultado(nombre, acumulado)) {
                                    JOptionPane.showMessageDialog(null, "Su resultado ha sido guardado con exito.");
                                    nivel = -1;
                                }
                                break;
                        }
                    }

                    break;
                //Historial de resultados
                case 2:
                    controladorJuego.mostrarRecord();
                    break;
                case 3:                    
                    System.out.println("CONFIGURACION\nAquí es donde podrás agregar nuevas preguntas para el juego.\n");
                    String preguntaNueva = JOptionPane.showInputDialog(null, "Digite la nueva pregunta");
                    System.out.println("Digite el nivel de dificultad (de 1 a 5).");
                    int nivelNuevo = input.nextInt();
                    while(nivelNuevo < 0 || nivelNuevo > 6){
                        System.out.println("Digite el nivel de dificultad (de 1 a 5).");
                        nivelNuevo = input.nextInt();
                    }
                    Question pregunta = controladorJuego.guardarPregunta(preguntaNueva, nivelNuevo);
                    String respuestasNuevas [];
                    respuestasNuevas = new String [4];
                    for(int i = 0;i < 4; i++){
                        if(i==0){
                            respuestasNuevas[i] = JOptionPane.showInputDialog(null, "Digite la respuesta verdadera.");
                        }else{
                        respuestasNuevas[i] = JOptionPane.showInputDialog(null, "Digite una respuesta falsa");
                        }
                    }
                    if(controladorJuego.guardarRepuesta(respuestasNuevas, pregunta.getID())){
                        JOptionPane.showMessageDialog(null, "Se ha guardado con exito.");
                    }
                    break;

            }
        }
    }

}
