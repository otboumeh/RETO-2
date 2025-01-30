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

	/**
	 * Retorna todas las filas de la tabla t_alumno. Si la consulta no devuelve
	 * nada, retorna NULL
	 * 
	 * @return todos los alumnos o null
	 */
	public ArrayList<Agencia> getAllAgencies() {
		ArrayList<Agencia> ret = null;

		// SQL que queremos lanzar
		String sql = "select * from agencia";

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
			while (resultSet.next()) {

				// Hay al menos una fila en el cursos, inicializamos el ArrayList
				if (null == ret)
					ret = new ArrayList<Agencia>();

				// El Alumno
				Agencia agencia = new Agencia();

				// Sacamos las columnas del resultSet				
				String idAgencia = resultSet.getString("Id_Agencia");
				String nomAgencia = resultSet.getString("NomAgencia");
				String tipoAgencia = resultSet.getString("TipoAgencia");
				String colorAgencia = resultSet.getString("ColorAgencia");
				String logo = resultSet.getString("Logo");
				String pass = resultSet.getString("Pass");

				// Metemos los datos en Alumno
				agencia.setIdAgencia(idAgencia);
				agencia.setNomAgencia(nomAgencia);
				agencia.setTipoAgencia(tipoAgencia);
				agencia.setColorAgencia(colorAgencia);
				agencia.setLogo(logo);
				agencia.setPass(pass);
				
				// Lo guardamos en la lista
				ret.add(agencia);
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
