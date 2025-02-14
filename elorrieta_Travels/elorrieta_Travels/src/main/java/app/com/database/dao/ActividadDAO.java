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

/**
 * DAO (gestor de BBDD) para actividades en la base de datos.
 * 
 * Maneja conexiones a la base de datos y ejecuta consultas SQL.
 * 
 * @author Grupo_01
 */
public class ActividadDAO {

	/**
	 * Obtiene todas las actividades de la base de datos
	 * 
	 * @return Retorna la lista de actividades
	 */
	public ArrayList<Actividad> getAllActividades() {
		ArrayList<Actividad> ret = null;

		String sql = "select * from Actividad";

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
					ret = new ArrayList<Actividad>();

				Actividad actividad = new Actividad();

				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String descrip = resultSet.getString("Descripcion");
				Date fecha = resultSet.getDate("fecha");
				int precio = resultSet.getInt("Precio");

				actividad.setIdEvento(idEvento);
				actividad.setNomEvento(nomEvento);
				actividad.setTipoEvento(tipoEvento);
				actividad.setDescripcion(descrip);
				actividad.setFecha(fecha);
				actividad.setPrecio(precio);

				ret.add(actividad);
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
	 * Obtiene las actividades asociadas a un viaje
	 * 
	 * @param IdTrip Id del viaje
	 * @return Retorna una lista de actividades
	 */
	public ArrayList<Actividad> getActividadByTrip(String IdTrip) {
		ArrayList<Actividad> ret = null;

		String sql = "select * from Actividad where Id_Viaje = '" + IdTrip + "'";

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
					ret = new ArrayList<Actividad>();

				Actividad actividad = new Actividad();

				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String descripcion = resultSet.getString("Descripcion");
				Date fecha = resultSet.getDate("Fecha");
				int precio = resultSet.getInt("Precio");

				actividad.setIdEvento(idEvento);
				actividad.setNomEvento(nomEvento);
				actividad.setTipoEvento(tipoEvento);
				actividad.setDescripcion(descripcion);
				actividad.setFecha(fecha);
				actividad.setPrecio(precio);

				ret.add(actividad);
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
	 * Elimina una actividad por su ID
	 * 
	 * @param eventId ID del evento a eliminar
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

	/**
	 * Añade una actividad a un viaje el la BBDD
	 * 
	 * @param actividad Actividad a añadir
	 * @param ViajeId   Id del viaje
	 */
	public void addActividadByIdViaje(Actividad actividad, String ViajeId) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			statement = connection.createStatement();

			String idEvento = actividad.getIdEvento();
			String nomEvento = actividad.getNomEvento();
			String tipoEvento = actividad.getTipoEvento();
			String descripcion = actividad.getDescripcion();
			Date fecha = actividad.getFecha();
			int precio = actividad.getPrecio();
			String idViaje = ViajeId;

			String sql = "insert into Actividad (Id_Evento, Nom_Evento, TipoEvento, Descripcion, Fecha, Precio, Id_Viaje) VALUES ('"
					+ idEvento + "', '" + nomEvento + "', '" + tipoEvento + "', '" + descripcion + "', '" + fecha
					+ "', '" + precio + "', '" + idViaje + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
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
	}

}
