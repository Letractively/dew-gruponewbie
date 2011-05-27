package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaAvisoDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;

public class ConsultaAvisoTest {

	@Test
	public void listarAvisosPublicadosTest(){
		System.out.println("Se carga e método buscarEmpresaPorRubroTest()");

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
	
}
