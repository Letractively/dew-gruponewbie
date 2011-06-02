package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaPostulanteDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.ExperienciaProfesional;
import upc.edu.pe.model.Solicitante;

public class ConsultaSolicitanteTest {

	@Test
	public void listarSolicitantePorSueldoReferenciaTest(){
		System.out.println("Se carga e método listarSolicitantePorSueldoReferenciaTest()");
	
		ConsultaPostulanteDao consPosDao = new ConsultaPostulanteDao();
		try {
			
			List<Solicitante> lista = consPosDao.listarSolicitantePorSueldoReferencia(new BigDecimal("4000"));
			
			assertTrue(lista.size()>=1);
			System.out.println("Existen "+ lista.size()+" registros");
			for(int i=0; i<lista.size(); i++) {

				Solicitante r = lista.get(i); 
			    System.out.println("Elemento-->"+r.toString());

			} 
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
		
	}
	
	@Test
	public void obtenerCvitaePorSolicitante(){
		Solicitante solicitante = new Solicitante();		
		solicitante.setId(2);
		
		ConsultaPostulanteDao consPosDao = new ConsultaPostulanteDao();
		// Visualizar los datos del Solicitante
		try {
			solicitante = consPosDao.obtenerDatosPersonales(solicitante);
			assertTrue(solicitante!=null);
			System.out.println("Currsiculum Vitae Generado:");
			System.out.println("--------------------------");
			System.out.println("Datos Personales: "+solicitante);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}		
		
		
		// Visualizar los Experiencia Laboral del Solicitante
		List<ExperienciaProfesional> lstExperienciaProfesional;
		try {
			lstExperienciaProfesional = consPosDao.obtenerExperienciaProfesional(solicitante);
			assertTrue(lstExperienciaProfesional.size()>0);
			System.out.println("Experiencia Laboral: "+lstExperienciaProfesional.toString());
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}

	}
}
