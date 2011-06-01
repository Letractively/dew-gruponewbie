package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import upc.edu.pe.dao.registro.RegistroPublicidadDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Publicidad;
import upc.edu.pe.web.comun.Constantes;
import upc.edu.pe.web.comun.HelperDate;

public class RegistroPublicidadTest {

	@Test
	public void registrarPublicidad(){
		//Preparamos los datos del TipoUsuario
		System.out.println("Se cargan los datos al objeto Publicidad");
		Publicidad publicidad = new Publicidad();
		publicidad.setDescripcion("Taxi JaVa");
		publicidad.setCuerpo("El servicio de taxi JaVa se caracteriza por tener unidades nuevas, buenas tarifas, etc...");
		publicidad.setEnlace("www.taxiJaVa.pe");
		publicidad.setFechainicial(HelperDate.parseaDate("2011-05-30",Constantes.FORMATO_FECHA));
		publicidad.setFechafin(HelperDate.parseaDate("2011-12-30",Constantes.FORMATO_FECHA));
		publicidad.setEstado("1");
				
		RegistroPublicidadDao registroPublicidadDao = new RegistroPublicidadDao(); 
		boolean flagRegistro;
		try {
			flagRegistro = registroPublicidadDao.registrarPublicidad(publicidad);
			//Validar
			assertTrue(flagRegistro);
			System.out.println("Se registró Publicidad correctamente:");
		} catch (DAOExcepcion e) {
			System.out.println("Error al intentar registrar: "+e.getStackTrace());
		}
		
	}
	
	
}
