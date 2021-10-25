package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ManagerGame extends Conexion {

    public Question guardarPregunta(String pregunta ,int nivel) throws SQLException {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO `prueba`.`pregunta` (`pregunta`, `nivel`) VALUES (?, ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, pregunta);
            ps.setInt(2, nivel);
            ps.execute();
            LinkedList<Question> listPregunta = new LinkedList<Question>();
            ResultSet result = null;
            sql = "SELECT * FROM prueba.pregunta Where pregunta=?;";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, pregunta);
                result = ps.executeQuery();
                if(result.next()) {
                    listPregunta.add(new Question(Integer.parseInt(result.getString("idpregunta")), result.getString("pregunta"), Integer.parseInt(result.getString("nivel"))));
                }                
                return listPregunta.element();
            } catch (SQLException e) {
                System.err.println(e);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public Question buscarPregunta(int nivel) throws SQLException {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        LinkedList<Question> listPregunta = new LinkedList<Question>();
        ResultSet result = null;
        String sql = "SELECT * FROM prueba.pregunta Where nivel=?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, nivel);
            result = ps.executeQuery();
            while (result.next()) {
                listPregunta.add(new Question(Integer.parseInt(result.getString("idpregunta")), result.getString("pregunta"), Integer.parseInt(result.getString("nivel"))));
            }
            int random = (int) (Math.random() * listPregunta.size());
            if (random == 0) {
                random = 1;
            }
            return listPregunta.get(random);
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }
    
    public boolean guardarRespuesta(String respuestasNuevas[] ,int pregunta_id) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO `prueba`.`respuesta` (`respuesta`, `validacion`, `pregunta_id`) VALUES (?, ?, ?); INSERT INTO `prueba`.`respuesta` (`respuesta`, `validacion`, `pregunta_id`) VALUES (?, ?, ?); INSERT INTO `prueba`.`respuesta` (`respuesta`, `validacion`, `pregunta_id`) VALUES (?, ?, ?); INSERT INTO `prueba`.`respuesta` (`respuesta`, `validacion`, `pregunta_id`) VALUES (?, ?, ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, respuestasNuevas[0]);
            ps.setString(2, "V");
            ps.setInt(3, pregunta_id);
            ps.setString(4, respuestasNuevas[1]);
            ps.setString(5, "F");
            ps.setInt(6, pregunta_id);
            ps.setString(7, respuestasNuevas[2]);
            ps.setString(8, "F");
            ps.setInt(9, pregunta_id);
            ps.setString(10, respuestasNuevas[3]);
            ps.setString(11, "F");
            ps.setInt(12, pregunta_id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public LinkedList<Answer> buscarRespuesta(int ID) throws SQLException {
        Connection connection = getConexion();
        LinkedList<Answer> listRespuesta = new LinkedList<Answer>();
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT * FROM prueba.respuesta WHERE pregunta_id = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ID);
            result = ps.executeQuery();

            while (result.next()) {
                listRespuesta.add(new Answer(Integer.parseInt(result.getString("idrespuesta")), result.getString("respuesta"), result.getString("validacion"), Integer.parseInt(result.getString("pregunta_id"))));
            }
            return listRespuesta;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public boolean guardarResultado(String nombre, int acumulado) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO `prueba`.`record` (`jugador`, `puntaje`) VALUES (?, ?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, acumulado);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public LinkedList <Records> buscarRecord() throws SQLException {
        LinkedList<Records> listRecord = new LinkedList<Records>();
        PreparedStatement ps = null;
        Connection connection = getConexion();
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM prueba.record ORDER BY puntaje desc;";
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                listRecord.add(new Records(Integer.parseInt(result.getString("idrecord")), result.getString("jugador"), Integer.parseInt(result.getString("puntaje"))));
            }
            return listRecord;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }
}
