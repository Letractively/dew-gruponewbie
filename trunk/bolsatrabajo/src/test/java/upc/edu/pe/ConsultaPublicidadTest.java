package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaPublicidadDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Publicidad;;

public class ConsultaPublicidadTest {

	@Test
	public void listarPublicidadTest(){
		System.out.println("Se carga e método buscarPublicidadTest()");

		System.out.println("===================listarPublicidadTest");
		ConsultaPublicidadDao consultaPublicidad = new ConsultaPublicidadDao();
		try {
			
			List<Publicidad> lista = consultaPublicidad.listarPublicidad();			
			
			assertTrue(lista.size()>=1);
			System.out.println("Existen "+ lista.size()+" registros");
			for(int i=0; i<lista.size(); i++) {

				Publicidad r = lista.get(i); 
			    System.out.println("Elemento-->"+r.toString());

			} 
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
		
	}
	
	
}
