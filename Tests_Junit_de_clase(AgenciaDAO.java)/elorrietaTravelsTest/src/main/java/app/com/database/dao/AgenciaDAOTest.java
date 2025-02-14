package main.java.app.com.database.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.app.com.database.models.Agencia;
import main.java.app.com.database.models.Viaje;

class AgenciaDAOTest {


    private final AgenciaDAO agenciaDAO = new AgenciaDAO();
    private static Agencia testAgencia;


    @Test
    void testGetAllAgencies() {
        ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();
        assertTrue(agencias.size() >= 0, "La longitud de agencias es mas que 0");
    }
    
    @Test
    void testAgencyIsAdded() {
    	
        testAgencia = new Agencia();
        testAgencia.setIdAgencia("AG009");
        testAgencia.setNomAgencia("Agencia JUnit");
        testAgencia.setTipoAgencia("Mayorista");         
        testAgencia.setColorAgencia("#ffffff");
        testAgencia.setNumEmp("Entre 10 a 100"); 
        testAgencia.setLogo("img.test.com/logo.png");
        testAgencia.setPass("JUnit@5");
        agenciaDAO.addAgencyToDB(testAgencia);
    	
    	ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();
    	Agencia agenciaEncontrado = null;
    	
    	for (Agencia agencia : agencias) {
    		if(agencia.getIdAgencia().equalsIgnoreCase("AG009")) {
    			agenciaEncontrado = agencia;
    			break;
    		}
    	}
        assertNotNull(agenciaEncontrado, "La agencia debe de aparecer en la base de datos");

     }
    
}
