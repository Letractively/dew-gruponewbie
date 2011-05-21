package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import upc.edu.pe.dao.consulta.ConsultaTipoUsuarioDao;
import upc.edu.pe.dao.registro.RegistroTipoUsuarioDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.TipoUsuario;

public class RegistroTipoUsuarioTest {

	@Test
	public void registrarTipoUsuario(){
		//Preparamos los datos del TipoUsuario
		System.out.println("Se cargan los datos al objeto TipoUsuario");
		TipoUsuario tipoUsu = new TipoUsuario();
		tipoUsu.setDescripcion("Example");
		
		RegistroTipoUsuarioDao registroTUDao = new RegistroTipoUsuarioDao(); 
		boolean flagRegistro;
		try {
			flagRegistro = registroTUDao.registrarTipoUsuario(tipoUsu);
			//Validar
			assertTrue(flagRegistro);
			System.out.println("Se registró el tipoUsuario correctamente:");
		} catch (DAOExcepcion e) {
			System.out.println("Error al intentar registrar: "+e.getStackTrace());
		}
		
	}
	
	@Test
	public void listarTipoUsuario(){
		System.out.println("Se carga e método listarTipoUsuario()");

		System.out.println("=================================================listarTest");
		ConsultaTipoUsuarioDao consultaTUDao = new ConsultaTipoUsuarioDao();
		try {
			
			List<TipoUsuario> lista = consultaTUDao.listar();			
			
			assertTrue(lista.size()>1);
			System.out.println("Existen "+ lista.size()+" registros");
			for(int i=0; i<lista.size(); i++) {

				TipoUsuario r = lista.get(i); 
			    System.out.println("Elemento-->"+r.toString());

			} 
		
		} catch (DAOExcepcion e) {
			Assert.fail("Falla al obtener la lista de datos: " + e.getMessage());
		}
		
	}
		
}
