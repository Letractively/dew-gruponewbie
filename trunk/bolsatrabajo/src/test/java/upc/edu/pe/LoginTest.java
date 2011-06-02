package upc.edu.pe;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaLoginDao;
import upc.edu.pe.exception.DAOExcepcion;

public class LoginTest {
	
	
	
	//Otra versión de consultar login
	@Test
	public void listarSolicitantePorSueldoReferenciaTest(){
		System.out.println("Se carga e método listarSolicitantePorSueldoReferenciaTest()");
	
		ConsultaLoginDao consultaLogin = new ConsultaLoginDao();
		String usuarioLogin="ednvpr@gmail.com";
		String pass="asd";
		try {
			
			assertTrue(consultaLogin.obtener(usuarioLogin,pass));
			System.out.println("Existen el usuario ");
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
	}
}
