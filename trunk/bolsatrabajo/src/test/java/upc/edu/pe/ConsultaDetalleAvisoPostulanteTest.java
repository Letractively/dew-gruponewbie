package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaDetalleAvisoPostulanteDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.DetalleAvisoPostulante;
import upc.edu.pe.model.Persona;

public class ConsultaDetalleAvisoPostulanteTest {

	@Test
	public void estadisticaPostulantesAvisoTest(){
		System.out.println("Se carga e método estadisticaPostulantesAvisoTest()");

		System.out.println("=================================================estadisticaPostulantesAvisoTest");
		ConsultaDetalleAvisoPostulanteDao cdap = new ConsultaDetalleAvisoPostulanteDao();
		try {
			DetalleAvisoPostulante dap = new DetalleAvisoPostulante();
			Aviso aviso = new Aviso();
			Persona persona = new Persona();
			dap.setId_avi(1);
			dap.setAviso(aviso);
			persona.setDisponibilidad("tiempo completo");
			persona.setSalario(new BigDecimal(5000.0));
			//persona.setEdad(35);
			dap.setPersona(persona);			
			
			List<DetalleAvisoPostulante> lista = cdap.buscarPostulantesAviso(dap);		
			assertTrue(lista.size()>=1);
			System.out.println("Existen "+ lista.size()+" registros");
			for(int i=0; i<lista.size(); i++) {
				DetalleAvisoPostulante r = lista.get(i); 
			    System.out.println("Elemento-->"+r.toString());

			} 
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
		
	}
}
