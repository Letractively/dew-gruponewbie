package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaEmpresaDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Ofertante;

public class ConsultaEmpresaTest {

	@Test
	public void buscarEmpresaPorRubroTest(){
		System.out.println("Se carga e método buscarEmpresaPorRubroTest()");

		System.out.println("=================================================buscarEmpresaPorRubroTest");
		ConsultaEmpresaDao consultaEmp = new ConsultaEmpresaDao();
		try {
			
			List<Ofertante> lista = consultaEmp.buscarPorIndustria(6);//Seteamos idIndustria 6=Informático			
			
			assertTrue(lista.size()>=1);
			System.out.println("Existen "+ lista.size()+" registros");
			for(int i=0; i<lista.size(); i++) {

				Ofertante r = lista.get(i); 
			    System.out.println("Elemento-->"+r.toString());

			} 
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
		
	}
}
