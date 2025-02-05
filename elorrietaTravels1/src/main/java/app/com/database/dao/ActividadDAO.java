package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Actividad;
import main.java.app.com.utils.DBConnection;

public class ActividadDAO {
	public ArrayList<Actividad> getActividadByTrip(String IdTrip) {
		ArrayList<Actividad> ret = null;

		// SQL que queremos lanzar
		String sql = "select * from Actividad where Id_Viaje = '" + IdTrip + "'";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBConnection.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			// Recorremos resultSet, que tiene las filas de la tabla
			while (resultSet.next()) {

				// Hay al menos una fila en el cursos, inicializamos el ArrayList
				if (null == ret)
					ret = new ArrayList<Actividad>();

				// El Alumno
				Actividad actividad = new Actividad();

				// Sacamos las columnas del resultSet				
				String idEvento= resultSet.getString("Id_Evento");
				String nomEvento= resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String descripcion = resultSet.getString("Descripcion");
				Date fecha = resultSet.getDate("Fecha");
				int precio = resultSet.getInt("Precio");


				// Metemos los datos en Alumno
				actividad.setIdEvento(idEvento);
				actividad.setNomEvento(nomEvento);
				actividad.setTipoEvento(tipoEvento);
				actividad.setDescripcion(descripcion);
				actividad.setFecha(fecha);
				actividad.setPrecio(precio);
				
				// Lo guardamos en la lista
				ret.add(actividad);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
		return ret;
	}
	
	/**
	 * Elimina un alumno en la tabla t_alumno
	 * 
	 * @param alumno El alumno a eliminar
	 */
	public void deleteActividadById(String eventId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			String sql = "delete from Actividad where Id_Evento = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, eventId);

			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
	}

}
