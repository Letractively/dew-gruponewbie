package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaAvisoDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.Especialidad;

public class ConsultaAvisoTest {

	@Test
	public void listarAvisosPublicadosTest(){
		System.out.println("Se carga el método buscarEmpresaPorRubroTest()");

		System.out.println("=================================================listarAvisosPublicadosTest");
		ConsultaAvisoDao consultaAviso = new ConsultaAvisoDao();
		try {
			
			List<Aviso> lista = consultaAviso.listarAvisosPulicados();			
			
			assertTrue(lista.size()>=1);
			System.out.println("Existen "+ lista.size()+" registros");
			for(int i=0; i<lista.size(); i++) {

				Aviso r = lista.get(i); 
			    System.out.println("Elemento-->"+r.toString());

			} 
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
	}
	
	@Test
	public void listarAvisosPorEspecialidadTest(){
		System.out.println("Se carga el método listarAvisosPorEspecialidadTest()");

		System.out.println("=================================================listarAvisosPorEspecialidadTest");
		Especialidad esp = new Especialidad();
		esp.setIdEspecialidad(17);//Tecnologia de Sistemas Informaticos
		ConsultaAvisoDao consultaAviso = new ConsultaAvisoDao();
		try {
			
			List<Aviso> lista = consultaAviso.listarAvisosPorEspecialidad(esp);			
			
			assertTrue(lista.size()>=1);
			System.out.println("Existen "+ lista.size()+" registros");
			for(int i=0; i<lista.size(); i++) {

				Aviso r = lista.get(i); 
			    System.out.println("Elemento-->"+r.toString());

			} 
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
	}
}
