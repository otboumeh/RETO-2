package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Agencia;
import main.java.app.com.utils.DBConnection;

public class AgenciaDAO {

	public ArrayList<Agencia> getAllAgencies() {
		ArrayList<Agencia> ret = null;

		String sql = "select * from agencia";

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
					ret = new ArrayList<Agencia>();

				Agencia agencia = new Agencia();

				String idAgencia = resultSet.getString("Id_Agencia");
				String nomAgencia = resultSet.getString("NomAgencia");
				String tipoAgencia = resultSet.getString("Cod_Tipo");
				String colorAgencia = resultSet.getString("ColorAgencia");
				String numEmp = resultSet.getString("Cod_descEmp");
				String logo = resultSet.getString("Logo");
				String pass = resultSet.getString("Pass");

				agencia.setIdAgencia(idAgencia);
				agencia.setNomAgencia(nomAgencia);
				agencia.setTipoAgencia(tipoAgencia);
				agencia.setColorAgencia(colorAgencia);
				agencia.setNumEmp(numEmp);
				agencia.setLogo(logo);
				agencia.setPass(pass);

				ret.add(agencia);
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


	public void addAgencyToDB(Agencia agencia) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBConnection.DRIVER);

			connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASS);

			statement = connection.createStatement();
			
			String codTipoAgencia = agencia.getTipoAgencia().equalsIgnoreCase("Mayorista") ? "A1" : agencia.getTipoAgencia().equalsIgnoreCase("Minorista") ? "A2": agencia.getTipoAgencia().equalsIgnoreCase("Mayorista-minorista") ? "A3" : null; 
			String codDescEmp = agencia.getNumEmp().equalsIgnoreCase("Entre 2 a 10") ? "L1" :  agencia.getNumEmp().equalsIgnoreCase("Entre 10 a 100") ? "L2":  agencia.getNumEmp().equalsIgnoreCase("Entre 100 a 1000") ? "L3" : null; 

			
			String sql = "insert into Agencia (Id_Agencia, NomAgencia, Cod_tipo, ColorAgencia, Cod_descEmp, Logo, Pass) VALUES ('" + agencia.getIdAgencia() + "', '"
					+ agencia.getNomAgencia() + "', '" + codTipoAgencia + "', '" + agencia.getColorAgencia() + "', '" + codDescEmp + "', '" + agencia.getLogo() + "', '" + agencia.getPass() + "')";

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
