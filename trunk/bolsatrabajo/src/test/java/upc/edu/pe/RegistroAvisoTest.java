package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import upc.edu.pe.dao.registro.RegistroAvisoDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.Especialidad;
import upc.edu.pe.web.comun.Constantes;
import upc.edu.pe.web.comun.HelperDate;

public class RegistroAvisoTest {

	@Test
	public void registrarTipoUsuario(){
		//Preparamos los datos del TipoUsuario
		System.out.println("Se cargan los datos al objeto Aviso");
		Aviso aviso = new Aviso();
		aviso.setCargo("Analista Programador - Junior");
		aviso.setFechaInicio(HelperDate.parseaDate("2011-05-27",Constantes.FORMATO_FECHA));
		aviso.setFechaFin(HelperDate.parseaDate("2011-07-27",Constantes.FORMATO_FECHA));
		aviso.setDescripcion("Se requiere analista programador junior con vocación de servicio, etc...");
		aviso.setJornadaLaboral("tiempo completo");
		aviso.setDisponibilidad("inmediata");
		aviso.setRequerimiento("Saber hablar");
		aviso.setBeneficios("Pertenecer a una empresa próspera");
		aviso.setSueldo(new BigDecimal(3500));
		aviso.setEstado("P");//P=Publicado; N=No publicado
		aviso.setContadorVisitas(0);
		Especialidad especialidad =new Especialidad();
		especialidad.setIdEspecialidad(8);//Ing sistemas
		aviso.setEspecialidad(especialidad);
		
		RegistroAvisoDao registroAvisoDao = new RegistroAvisoDao(); 
		boolean flagRegistro;
		try {
			flagRegistro = registroAvisoDao.registrarAvisoo(aviso, 1);
			//Validar
			assertTrue(flagRegistro);
			System.out.println("Se registró el aviso correctamente:");
		} catch (DAOExcepcion e) {
			System.out.println("Error al intentar registrar: "+e.getStackTrace());
		}
		
	}
	
}
