package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Viaje;
import main.java.app.com.utils.DBConnection;

public class ViajeDAO {

	public ArrayList<Viaje> getTripsByAgency(String IdAgencia) {
		ArrayList<Viaje> ret = null;

		String sql = "select * from viaje where Id_Agencia = '" + IdAgencia + "'";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Viaje>();

				Viaje viaje = new Viaje();

				String idViaje= resultSet.getString("Id_Viaje");
				String nomViaje= resultSet.getString("NomViaje");
				String codTipoViaje = resultSet.getString("Cod_TipoViaje");
				Date fechaInicio = resultSet.getDate("FechInicio");
				Date fechaFin = resultSet.getDate("FechFin");
				String pais = resultSet.getString("PaisDestino");
				String descripciones = resultSet.getString("Descripcion");
				String serNoIncl = resultSet.getString("ServiciosnoIncl");
				String idAgencia = resultSet.getString("Id_Agencia");

				String tipoViaje = typeConverter(codTipoViaje);
				long numDias = dayDifference(fechaFin, fechaInicio);
				viaje.setIdViaje(idViaje);
				viaje.setNomViaje(nomViaje);;
				viaje.setTipoViaje(tipoViaje);
				viaje.setFechInicio(fechaInicio);
				viaje.setFechFin(fechaFin);
				viaje.setFechFin(fechaFin);
				viaje.setNumDias(numDias);
				viaje.setPais(pais);
				viaje.setDescripcion(descripciones);
				viaje.setServiciosnoIncl(serNoIncl);
				viaje.setIdAgencia(idAgencia);
				
				ret.add(viaje);
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
	
	private long dayDifference(Date fechInicio,  Date fechFin) {
        long differenceInMillis = fechInicio.getTime() - fechFin.getTime();
        long  differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);
        return differenceInDays;
	}
	
	private String typeConverter(String type) {
		String ret = null;
		switch (type) {
		case "B1":
			ret = "Parejas";
			break;
		case "B2":
			ret = "Mayores";			
			break;
		case "B3":
			ret = "Grupos";
			break;
		case "B4":
			ret = "Grandes viajes (destinos exóticos + vuelo + alojamiento)";
			break;
		case "B5":
			ret = "Escapada";
			break;
		default:
			ret = "algo esta mal";
		}
		return ret;
	}
	
	/**
	 * Elimina un alumno en la tabla t_alumno
	 * 
	 * @param alumno El alumno a eliminar
	 */
	public void deleteTripById(String tripId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			String sql = "delete from Viaje where Id_Viaje = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tripId);

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

 
