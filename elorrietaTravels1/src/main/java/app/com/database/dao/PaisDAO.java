package main.java.app.com.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.app.com.database.models.Pais;
import main.java.app.com.utils.DBConnection;

public class PaisDAO {

	public ArrayList<Pais> getAllCountries() {
		ArrayList<Pais> ret = null;

		String sql = "select * from Pais";

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
					ret = new ArrayList<Pais>();

				Pais pais = new Pais();

				String codPais = resultSet.getString("Cod_Pais");
				String nomPais = resultSet.getString("NomPais");
	
				pais.setIdPais(codPais);
				pais.setNomPais(nomPais);
				
				ret.add(pais);
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
