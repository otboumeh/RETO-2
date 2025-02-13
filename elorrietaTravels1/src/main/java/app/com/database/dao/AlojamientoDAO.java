package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Alojamiento;
import main.java.app.com.utils.DBConnection;

public class AlojamientoDAO {

	public ArrayList<Alojamiento> getAllAlojamientos() {
		ArrayList<Alojamiento> ret = null;

		String sql = "select * from Alojamiento";

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
					ret = new ArrayList<Alojamiento>();

				Alojamiento alojamiento = new Alojamiento();

				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String nomHotel = resultSet.getString("NomHotel");
				String codTipoHab = resultSet.getString("Cod_TipoHab");
				String ciudad = resultSet.getString("Ciudad");
				int precio = resultSet.getInt("Precio");
				Date fechaEnt = resultSet.getDate("FechaEnt");
				Date fechaSal = resultSet.getDate("FechaSal");

				String tipoHab = roomCodeToTypeConverter(codTipoHab);

				alojamiento.setIdEvento(idEvento);
				alojamiento.setNomEvento(nomEvento);
				alojamiento.setTipoEvento(tipoEvento);
				alojamiento.setNomHotel(nomHotel);
				alojamiento.setTipoHab(tipoHab);
				alojamiento.setCiudad(ciudad);
				alojamiento.setPrecio(precio);
				alojamiento.setFechaEnt(fechaEnt);
				alojamiento.setFechaSal(fechaSal);

				ret.add(alojamiento);
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

	public ArrayList<Alojamiento> getAlojamientoByTrip(String IdTrip) {
		ArrayList<Alojamiento> ret = null;

		String sql = "select * from Alojamiento where Id_Viaje = '" + IdTrip + "'";

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
					ret = new ArrayList<Alojamiento>();

				Alojamiento alojamiento = new Alojamiento();

				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				;
				String tipoEvento = resultSet.getString("TipoEvento");
				;
				String nomHotel = resultSet.getString("NomHotel");
				String idTipoHab = resultSet.getString("Cod_TipoHab");
				String ciudad = resultSet.getString("Ciudad");
				int precio = resultSet.getInt("precio");
				Date fechaEnt = resultSet.getDate("FechaEnt");
				;
				Date fechaSal = resultSet.getDate("FechaSal");
				;

				String tipoHab = roomCodeToTypeConverter(idTipoHab);
				alojamiento.setIdEvento(idEvento);
				alojamiento.setNomEvento(nomEvento);
				alojamiento.setTipoEvento(tipoEvento);
				alojamiento.setNomHotel(nomHotel);
				alojamiento.setTipoHab(tipoHab);
				alojamiento.setCiudad(ciudad);
				alojamiento.setPrecio(precio);
				alojamiento.setFechaEnt(fechaEnt);
				alojamiento.setFechaSal(fechaSal);

				ret.add(alojamiento);
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

	private String roomCodeToTypeConverter(String type) {
		String ret = null;
		switch (type) {
		case "DB":
			ret = "Doble";
			break;
		case "DUI":
			ret = "Doble uso Individual";
			break;
		case "SIN":
			ret = "Individual";
			break;
		case "TPL":
			ret = "Triple";
			break;
		default:
			ret = "Unknown Type";
		}
		return ret;
	}

	private String roomTypeToCodeConverter(String type) {
		String ret = null;
		switch (type) {
		case "Doble":
			ret = "DB";
			break;
		case "Uso doble e individual":
			ret = "DUI";
			break;
		case "Individual":
			ret = "SIN";
			break;
		case "Triple":
			ret = "TPL";
			break;
		default:
			ret = "Unknown Type";
		}
		return ret;
	}

	public void deleteAlojamientoById(String eventId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			String sql = "delete from Alojamiento where Id_Evento = ?";
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

	public void addAlojamientoByIdViaje(Alojamiento alojamiento, String ViajeId) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			statement = connection.createStatement();

			String idEvento = alojamiento.getIdEvento();
			String nomEvento = alojamiento.getNomEvento();
			String tipoEvento = alojamiento.getTipoEvento();
			String nomHotel = alojamiento.getNomHotel();
			String tipoHab = alojamiento.getTipoHab();
			String codTipoHab = roomTypeToCodeConverter(tipoHab);
			System.out.println(codTipoHab);

			String ciudad = alojamiento.getCiudad();
			int precio = alojamiento.getPrecio();
			Date fechaEnt = alojamiento.getFechaEnt();
			Date fechaSal = alojamiento.getFechaSal();
			String idViaje = ViajeId;

			String sql = "insert into Alojamiento (Id_Evento, Nom_Evento, TipoEvento, NomHotel, Cod_TipoHab, Ciudad, precio, FechaEnt, FechaSal, Id_Viaje) VALUES ('"
					+ idEvento + "', '" + nomEvento + "', '" + tipoEvento + "', '" + nomHotel + "', '" + codTipoHab
					+ "', '" + ciudad + "', '" + precio + "', '" + fechaEnt + "', '" + fechaSal + "', '" + idViaje
					+ "')";

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
