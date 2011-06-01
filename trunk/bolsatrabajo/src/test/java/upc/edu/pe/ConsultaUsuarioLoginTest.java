package upc.edu.pe;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaUsuarioLoginDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Persona;

public class ConsultaUsuarioLoginTest {

	@Test
	public void validarUsuaroLoginTest(){
		System.out.println("Se carga e método validarUsuaroLoginTest()");

		System.out.println("=================================================validarUsuaroLoginTest");
		ConsultaUsuarioLoginDao consultaUsuLog = new ConsultaUsuarioLoginDao();
		try {
			
			Persona per = consultaUsuLog.validarUsuarioLogin("felixangelalfaroc@gmail.com", "hola");			
			
			assertTrue(per!=null);
			System.out.println("Existe el usuario");
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
		
	}
}
