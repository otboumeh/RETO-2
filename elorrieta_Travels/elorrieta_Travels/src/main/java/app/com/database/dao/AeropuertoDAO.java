package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Aeropuerto;
import main.java.app.com.utils.DBConnection;

/**
 * DAO (gestor de BBDD) para aeropuertos en la base de datos.
 * 
 * Maneja conexiones a la base de datos y ejecuta consultas SQL.
 * 
 * @author Grupo_01
 */
public class AeropuertoDAO {

    /**
     * Obtiene todos los aeropuertos de la base de datos
     * @return Retorna la lista de todos los aeropuertos
     */
    public ArrayList<Aeropuerto> getAllAirports() {
        ArrayList<Aeropuerto> ret = null;

        String sql = "select * from Aeropuerto";

        Connection connection = null;

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DBConnection.DRIVER);

            connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                if (null == ret)
                    ret = new ArrayList<Aeropuerto>();

                Aeropuerto aeropuerto = new Aeropuerto();

                String idAeropuerto = resultSet.getString("Id_Aeropuerto");
                String ciudad = resultSet.getString("Ciudad");

                aeropuerto.setIdAeropuerto(idAeropuerto);
                aeropuerto.setCiudad(ciudad);

                ret.add(aeropuerto);
            }
        } catch (SQLException sqle) {
            System.out.println("Error con la BBDD - " + sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Error generico - " + e.getMessage());
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (Exception e) {
            }
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
            }
        }
        return ret;
    }

    /**
     * Obtiene un aeropuerto por su ID
     * @param IdAeropuerto ID del aeropuerto
     * @return Retorna Aeropuerto encontrado o null si no existe
     */
    public Aeropuerto getAeropuertoById(String IdAeropuerto) {
        Aeropuerto ret = null;

        String sql = "select * from Aeropuerto where Id_Aeropuerto= '" + IdAeropuerto + "'";

        Connection connection = null;

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DBConnection.DRIVER);

            connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                if (null == ret)
                    ret = new Aeropuerto();

                Aeropuerto aeropuerto = new Aeropuerto();

                String idAeropuerto = resultSet.getString("Id_Aeropuerto");
                String ciudad = resultSet.getString("Ciudad");

                aeropuerto.setIdAeropuerto(idAeropuerto);
                aeropuerto.setCiudad(ciudad);

                ret = aeropuerto;
            }
        } catch (SQLException sqle) {
            System.out.println("Error con la BBDD - " + sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Error generico - " + e.getMessage());
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (Exception e) {
            }
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
            }
        }
        return ret;
    }
}
