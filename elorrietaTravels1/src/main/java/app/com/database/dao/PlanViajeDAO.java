package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.PlanViaje;
import main.java.app.com.database.models.Vuelo;
import main.java.app.com.utils.DBConnection;

public class PlanViajeDAO {
	
	VueloDAO vueloDAO = new VueloDAO();
	
	public ArrayList<PlanViaje> getPlanViajeByTrip(String IdTrip) {
		ArrayList<PlanViaje> ret = null;

		// SQL que queremos lanzar
		String sql = "select * from Plan_Viaje where Id_Viaje = '" + IdTrip + "'";

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
					ret = new ArrayList<PlanViaje>();

				// El Alumno
				PlanViaje planViaje = new PlanViaje();

				// Sacamos las columnas del resultSet				
				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String trayecto = resultSet.getString("Trayecto");
				String Id_Ida = resultSet.getString("Id_VueloIda");
				String Id_Vuelta = resultSet.getString("Id_VueloVuelta");

				Vuelo ida = vueloDAO.getflightById(Id_Ida);
				Vuelo vuelta = vueloDAO.getflightById(Id_Vuelta);

				// Metemos los datos en Alumno
				planViaje.setIdEvento(idEvento);
				planViaje.setNomEvento(nomEvento);
				planViaje.setTipoEvento(tipoEvento);
				planViaje.setTrayecto(trayecto);
				planViaje.setIda(ida);
				planViaje.setVuelta(vuelta);


				
				// Lo guardamos en la lista
				ret.add(planViaje);
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
	public void deletePlanViajeById(String eventId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			String sql = "delete from Plan_Viaje where Id_Evento = ?";
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
