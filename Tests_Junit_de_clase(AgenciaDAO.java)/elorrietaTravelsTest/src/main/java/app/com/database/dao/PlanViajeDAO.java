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
	
	public ArrayList<PlanViaje> getAllPlanViajes() {
		ArrayList<PlanViaje> ret = null;

		String sql = "select * from Plan_Viaje";

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
					ret = new ArrayList<PlanViaje>();

				PlanViaje planViaje = new PlanViaje();

				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String trayecto = resultSet.getString("Trayecto");
				String idIda = resultSet.getString("Id_VueloIda");
				String idVuelta = resultSet.getString("Id_VueloVuelta");

				planViaje.setIdEvento(idEvento);
				planViaje.setNomEvento(nomEvento);
				planViaje.setTipoEvento(tipoEvento);
				planViaje.setTrayecto(trayecto);
				planViaje.setIda(vueloDAO.getFlightById(idIda));
				planViaje.setVuelta(vueloDAO.getFlightById(idVuelta));
				
				ret.add(planViaje);
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


	
	public ArrayList<PlanViaje> getPlanViajeByTrip(String IdTrip) {
		ArrayList<PlanViaje> ret = null;

		String sql = "select * from Plan_Viaje where Id_Viaje = '" + IdTrip + "'";

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
					ret = new ArrayList<PlanViaje>();

				PlanViaje planViaje = new PlanViaje();

				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String trayecto = resultSet.getString("Trayecto");
				String Id_Ida = resultSet.getString("Id_VueloIda");
				String Id_Vuelta = resultSet.getString("Id_VueloVuelta");

				Vuelo ida = vueloDAO.getFlightById(Id_Ida);
				Vuelo vuelta = vueloDAO.getFlightById(Id_Vuelta);

				planViaje.setIdEvento(idEvento);
				planViaje.setNomEvento(nomEvento);
				planViaje.setTipoEvento(tipoEvento);
				planViaje.setTrayecto(trayecto);
				planViaje.setIda(ida);
				planViaje.setVuelta(vuelta);

				ret.add(planViaje);
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
	
	
	public PlanViaje getPlanViajeById(String IdEvento) {
		PlanViaje ret = null;

		String sql = "select * from Plan_Viaje where Id_Evento = '" + IdEvento + "'";

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
					ret = new PlanViaje();

				PlanViaje planViaje = new PlanViaje();

				String idEvento = resultSet.getString("Id_Evento");
				String nomEvento = resultSet.getString("Nom_Evento");
				String tipoEvento = resultSet.getString("TipoEvento");
				String trayecto = resultSet.getString("Trayecto");
				String Id_Ida = resultSet.getString("Id_VueloIda");
				String Id_Vuelta = resultSet.getString("Id_VueloVuelta");

				Vuelo ida = vueloDAO.getFlightById(Id_Ida);
				Vuelo vuelta = vueloDAO.getFlightById(Id_Vuelta);

				planViaje.setIdEvento(idEvento);
				planViaje.setNomEvento(nomEvento);
				planViaje.setTipoEvento(tipoEvento);
				planViaje.setTrayecto(trayecto);
				planViaje.setIda(ida);
				planViaje.setVuelta(vuelta);

				ret = planViaje;
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
	
	public void deletePlanViajeById(String eventId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;
		
		String idVueloIda = getPlanViajeById(eventId).getIda().getIdVuelo();
		String idVueloVuelta = getPlanViajeById(eventId).getVuelta().getIdVuelo();
		
		if (null != idVueloIda) {
			vueloDAO.deleteVueloById(idVueloIda);
		}
		if (null != idVueloVuelta) {
			vueloDAO.deleteVueloById(idVueloVuelta);
		}		

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
	
	public void addPlanViajeByIdViaje(PlanViaje planViaje, String ViajeId) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			statement = connection.createStatement();
			
			String idEvento= planViaje.getIdEvento();
			String nomEvento = planViaje.getNomEvento();
			String tipoEvento = planViaje.getTipoEvento();
			String trayecto = planViaje.getTrayecto();
			String idIda = planViaje.getIda().getIdVuelo();
			String idVuelta = planViaje.getVuelta() != null ? planViaje.getVuelta().getIdVuelo() : null;
			String idViaje = ViajeId;
			
			String sql = "insert into Plan_Viaje (Id_Evento, Nom_Evento, TipoEvento, Trayecto, Id_VueloIda, Id_VueloVuelta, Id_Viaje) VALUES ('" + idEvento + "', '"
					+ nomEvento + "', '" + tipoEvento + "', '" + trayecto + "', '" + idIda + "', ";

	        if (idVuelta == null) {
	            sql += "NULL";
	        } else {
	            sql += "'" + idVuelta + "'"; 
	        }
	        sql += ", '" + idViaje + "')";
			
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
	
	public void modifyReturnFlight(String idEvento, String idVueloVuelta) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			String sql = "update Plan_Viaje set Id_VueloVuelta = ? where Id_Evento= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, idVueloVuelta);
			preparedStatement.setString(2, idEvento);

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
