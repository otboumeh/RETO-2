package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import main.java.app.com.database.models.Vuelo;
import main.java.app.com.utils.DBConnection;

/**
 * DAO (gestor de BBDD) para vuelos en la base de datos.
 * 
 * Maneja conexiones a la base de datos y ejecuta consultas SQL.
 * 
 * @author Grupo_01
 */
public class VueloDAO {

	AeropuertoDAO aeropuertoDAO = new AeropuertoDAO();

	/**
	 * Obtiene todas las vuelos de la base de datos
	 * 
	 * @return Retorna la lista de vuelos
	 */
	public ArrayList<Vuelo> getAllFlights() {
		ArrayList<Vuelo> ret = null;

		String sql = "select * from Vuelo";

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
					ret = new ArrayList<Vuelo>();

				Vuelo vuelo = new Vuelo();

				String idVuelo = resultSet.getString("Id_Vuelo");
				Date fechaVuelo = resultSet.getDate("FechVuelo");
				String codAerolinea = resultSet.getString("Aerolinea");
				Time horarioSal = resultSet.getTime("HorarioSalida");
				Time duracion = resultSet.getTime("Duracion");
				String codAeroOrigen = resultSet.getString("Id_AeroOrig");
				String codAeroDest = resultSet.getString("Id_AeroDest");
				int precio = resultSet.getInt("Precio");

				vuelo.setIdVuelo(idVuelo);
				vuelo.setFechaIda(fechaVuelo);
				vuelo.setAerolinea(codAerolinea);
				vuelo.setHorarioSalida(horarioSal);
				vuelo.setDuracion(duracion);
				vuelo.setIdAeroOrigen(codAeroOrigen);
				vuelo.setIdAeroDestino(codAeroDest);
				vuelo.setPrecio(precio);

				ret.add(vuelo);
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
	 * Obtiene un vuelo por su Id
	 * 
	 * @param IdVuelo Id del Vuelo
	 * @return Retorna un vuelo buscandolo por su Id
	 */
	public Vuelo getFlightById(String IdVuelo) {
		Vuelo ret = null;

		String sql = "select * from Vuelo where Id_Vuelo = '" + IdVuelo + "'";

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
					ret = new Vuelo();

				Vuelo vuelo = new Vuelo();

				String idVuelo = resultSet.getString("Id_Vuelo");
				Date fechVuelo = resultSet.getDate("FechVuelo");
				String idAerolinea = resultSet.getString("Aerolinea");
				Time horarioSal = resultSet.getTime("HorarioSalida");
				Time duracion = resultSet.getTime("Duracion");
				String idAeroOrigen = resultSet.getString("Id_AeroOrig");
				String idAeroDestino = resultSet.getString("Id_AeroDest");
				int precio = resultSet.getInt("Precio");

				vuelo.setIdVuelo(idVuelo);
				vuelo.setFechaIda(fechVuelo);
				vuelo.setAerolinea(idAerolinea);
				vuelo.setHorarioSalida(horarioSal);
				vuelo.setDuracion(duracion);
				vuelo.setIdAeroOrigen(idAeroOrigen);
				vuelo.setIdAeroDestino(idAeroDestino);
				vuelo.setPrecio(precio);

				ret = vuelo;
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
	 * Añade un vuelo a la base de datos
	 * 
	 * @param vuelo el vuelo para añadir
	 */
	public void addFlightToDB(Vuelo vuelo) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			statement = connection.createStatement();

			String idVuelo = vuelo.getIdVuelo();

			Date fecha = vuelo.getFechaIda();
			String aerolinea = vuelo.getAerolinea();

			Time horariosal = vuelo.getHorarioSalida();

			Time duracion = vuelo.getDuracion();

			String codAeroOrigen = vuelo.getIdAeroOrigen();
			String codAeroDestino = vuelo.getIdAeroDestino();

			int precio = vuelo.getPrecio();

			String sql = "insert into Vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio) VALUES ('"
					+ idVuelo + "', '" + fecha + "', '" + aerolinea + "', '" + horariosal + "', '" + duracion + "', '"
					+ codAeroOrigen + "', '" + codAeroDestino + "', '" + precio + "')";

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

	/**
	 * Elimina un vuelo por su ID
	 * 
	 * @param flightId El Id del vuelo para borrar
	 */
	public void deleteVueloById(String flightId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			String sql = "delete from Vuelo where Id_Vuelo = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, flightId);

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
