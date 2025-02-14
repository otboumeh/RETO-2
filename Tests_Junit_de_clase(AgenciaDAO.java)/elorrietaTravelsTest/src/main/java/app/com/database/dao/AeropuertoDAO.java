package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Aeropuerto;
import main.java.app.com.utils.DBConnection;

public class AeropuertoDAO {
	
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
