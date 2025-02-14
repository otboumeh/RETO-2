package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Aerolinea;
import main.java.app.com.utils.DBConnection;

/**
 * DAO gestor de BBDD para aerolineas en la base de datos.
 * 
 * Maneja conexiones a la base de datos y ejecuta consultas SQL.
 * 
 * @author Grupo_01
 */
public class AerolineaDAO {

	/**
	 * Obtiene todas las aerolineas de la base de datos
	 * 
	 * @return Retorna la lista de todos los aerolineas
	 */
	public ArrayList<Aerolinea> getAllAirlines() {
		ArrayList<Aerolinea> ret = null;

		String sql = "select * from Aerolinea";

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
					ret = new ArrayList<Aerolinea>();

				Aerolinea aerolinea = new Aerolinea();

				String codAerolinea = resultSet.getString("Cod_Aerolinea");
				String nomAeroliena = resultSet.getString("NomAerolinea");

				aerolinea.setCodAirline(codAerolinea);
				aerolinea.setNameAirline(nomAeroliena);

				ret.add(aerolinea);
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
	 * Obtiene una aerolinea por su nombre
	 * 
	 * @param airlineName Nombre de la aerolinea
	 * @return Retorna Aerolinea encontrada o null si no existe
	 */
	public Aerolinea getAirlineByName(String airlineName) {
		Aerolinea ret = null;

		String sql = "select * from Aerolinea where NomAerolinea = '" + airlineName + "'";

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
					ret = new Aerolinea();

				Aerolinea aerolinea = new Aerolinea();

				String idAerolinea = resultSet.getString("Cod_Aerolinea");
				String nomAerolinea = resultSet.getString("NomAerolinea");

				aerolinea.setCodAirline(idAerolinea);
				aerolinea.setNameAirline(nomAerolinea);

				ret = aerolinea;
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
	 * Obtiene una aerolinea por su codigo
	 * 
	 * @param airlineId Codigo de la aerolinea
	 * @return Retorna Aerolinea encontrada o null si no existe
	 */
	public Aerolinea getAirlineByCod(String airlineId) {
		Aerolinea ret = null;

		String sql = "select * from Aerolinea where Cod_Aerolinea = '" + airlineId + "'";

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
					ret = new Aerolinea();

				Aerolinea aerolinea = new Aerolinea();

				String idAerolinea = resultSet.getString("Cod_Aerolinea");
				String nomAerolinea = resultSet.getString("NomAerolinea");

				aerolinea.setCodAirline(idAerolinea);
				aerolinea.setNameAirline(nomAerolinea);

				ret = aerolinea;
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
