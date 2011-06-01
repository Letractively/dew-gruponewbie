package upc.edu.pe;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import upc.edu.pe.dao.registro.RegistroOfertanteDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Ofertante;

public class RegistroOfertanteTest {

	@Test
	public void registrarOfertante(){
		//Preparamos los datos del ofertante
		System.out.println("Se cargan los datos al objeto ofertante");
		Ofertante ofertante = new Ofertante();
		ofertante.setRazonSocial("Razon social test");
		ofertante.setCorreo("correoTest@hotmail.com");
		ofertante.setContrasenhia("contrasenhiaTest");
		
		RegistroOfertanteDao registroOferDao = new RegistroOfertanteDao();
		
		try {
			ofertante.setId(registroOferDao.registrarOfertante(ofertante));
			//Validar
			assertTrue(ofertante.getId()>=1);
			System.out.println("Se registró el Ofertante correctamente:-->"+ofertante.toString());
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void modificarOfertante(){
		//Preparamos los datos del ofertante
		System.out.println("Se cargan los datos al objeto ofertante");
		Ofertante ofertante = new Ofertante();
		ofertante.setId(1);
		ofertante.setRazonSocial("Razon social test Mod");
		ofertante.setCorreo("correoTestMod@hotmail.com");
		ofertante.setContrasenhia("contrasenhiaTestMod");
		
		RegistroOfertanteDao registroOferDao = new RegistroOfertanteDao();
		
		try {
			int idOfertante = registroOferDao.modificarOfertante(ofertante);
			//Validar
			assertTrue(idOfertante>=1);
			System.out.println("Se modificó el Ofertante correctamente:-->"+ofertante.toString());
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
}
