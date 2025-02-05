package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import main.java.app.com.database.models.Aeropuerto;
import main.java.app.com.database.models.Vuelo;
import main.java.app.com.utils.DBConnection;

public class VueloDAO {
	
	AeropuertoDAO aeropuertoDAO = new AeropuertoDAO();

	public Vuelo getflightById(String IdVuelo) {
		Vuelo ret = null;

		// SQL que queremos lanzar
		String sql = "select * from Vuelo where Id_Vuelo = '" + IdVuelo + "'";

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
			if (resultSet.next()) {

				// Hay al menos una fila en el cursos, inicializamos el ArrayList
				if (null == ret)
					ret = new Vuelo();

				// El Alumno
				Vuelo vuelo = new Vuelo();

				// Sacamos las columnas del resultSet				
				String idVuelo = resultSet.getString("Id_Vuelo");
				Date fechVuelo = resultSet.getDate("FechVuelo");
				String idAerolinea = resultSet.getString("Aerolinea");
				Time horarioSal = resultSet.getTime("HorarioSalida");
				int duracion = resultSet.getInt("Duracion");
				String idAeroOrigen = resultSet.getString("Id_AeroOrig");
				String idAeroDestino = resultSet.getString("Id_AeroDest");
				int precio = resultSet.getInt("Precio");

				Aeropuerto aeroOrigen = aeropuertoDAO.getAeropuertoById(idAeroOrigen);
				Aeropuerto aeroDestino = aeropuertoDAO.getAeropuertoById(idAeroDestino);
				
				// Metemos los datos en Alumno
				vuelo.setIdVuelo(idVuelo);
				vuelo.setFechaIda(fechVuelo);
				vuelo.setAerolinea(idAerolinea);
				vuelo.setHorarioSalida(horarioSal);
				vuelo.setDuracion(duracion);
				vuelo.setAeropuertoOrigen(aeroOrigen);
				vuelo.setAeropuertoDestino(aeroDestino);
				vuelo.setPrecio(precio);

				
				// Lo guardamos en la lista
				ret = vuelo;
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

	
}
