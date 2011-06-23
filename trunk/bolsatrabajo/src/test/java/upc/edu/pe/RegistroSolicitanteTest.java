package upc.edu.pe;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import upc.edu.pe.dao.registro.RegistroPostulanteDao;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Distrito;
import upc.edu.pe.model.ExperienciaProfesional;
import upc.edu.pe.model.Industria;
import upc.edu.pe.model.PerfilProfesional;
import upc.edu.pe.model.Solicitante;
import upc.edu.pe.web.comun.Constantes;

public class RegistroSolicitanteTest {

	@Test
	public void registrarSolicitanteTest(){
		//Preparamos los datos del solicitante
		System.out.println("Se cargan los datos al objeto solicitante");
		Solicitante solicitante = new Solicitante();
		solicitante.setCorreo("correoTest@hotmail.com");
		solicitante.setContrasenhia("contrasenhiaTest");
		solicitante.setNombre("Usuario test");
		solicitante.setApellidoPaterno("ApellidoP Test");
		solicitante.setApellidoMaterno("ApellidoM Test");
		solicitante.setDireccion("Av testeo");
		solicitante.setNumeroDocumento("41656523");
		solicitante.setSexo(Constantes.C_SEXO_MASCULINO);//TODO: Validar M: Masculino || F: Femenino
		solicitante.setFechaNacimiento(new Date());
		solicitante.setTelefono("565-6265");
		solicitante.setCelular("99999999");
		Distrito dis = new Distrito();
		dis.setId_distrito("150101");
		
		
		//Enviamos los datos a la capa service
		RegistroPostulanteDao registroPosDao = new RegistroPostulanteDao();
		try {
			int idPersona = registroPosDao.registrarSolicitante(solicitante);
			solicitante.setId(idPersona);
			//Validar
			assertTrue(idPersona>=1);
			System.out.println("Se registró el Solicitante correctamente:-->"+solicitante.toString());
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
		
		//Registro de Perfil profesional
		PerfilProfesional perfilProfesional = new PerfilProfesional();
		perfilProfesional.setTituloProfesional("Ingeniero de Shystemas");
		perfilProfesional.setResumenProfesional("Soy un profesional... ");
		perfilProfesional.setDisponibilidadHoraria(Constantes.C_DISPONIBILIDAD_COMPLETA);//TODO: VALIDAR ESTE VALOR "C" Completo || "P" parcial
		perfilProfesional.setPretencionEconomica(new BigDecimal("3500.00"));
		solicitante.setPerfilProfesional(perfilProfesional);
		
		try {
			int idPerfil = registroPosDao.registrarPerfilProfesional(solicitante);
			//Validar
			assertTrue(idPerfil>=1);
			System.out.println("Se registró el perfilProfesional correctamente:-->"+solicitante.getPerfilProfesional().toString());
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
		
		List<ExperienciaProfesional> lista = new ArrayList<ExperienciaProfesional>();
		
		//Preparamos los datos de la 1ra experiencia profesional
		System.out.println("Se cargan los datos de la 1ra experiencia profesional del solicitante");
	
		ExperienciaProfesional experienciaProfesional = new ExperienciaProfesional();
		Industria industria = new Industria();
		industria.setIdIndustria(1);
		industria.setNombreIndustria("Consultoria");
		
		experienciaProfesional.setNombreOrganizacion("Synopsis");
		experienciaProfesional.setIndustria(industria);
		experienciaProfesional.setCargo("Practicante");
		experienciaProfesional.setFechaInicio(new Date());
		experienciaProfesional.setFechatermino(new Date());
		experienciaProfesional.setDescripcionLaboral("Mi labor consistia en llevar los documentos...");
		try {
			int idExp = registroPosDao.registrarExperienciaProfesional(experienciaProfesional);
			experienciaProfesional.setIdExperienciaProfesional(idExp);
			//Validar
			assertTrue(idExp>=1);
			System.out.println("Se registró la 1era experiencia Profesional correctamente:-->"+experienciaProfesional.toString());
			lista.add(experienciaProfesional);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
		
		//Preparamos los datos de la 1ra experiencia profesional
		System.out.println("Se cargan los datos de la 1ra experiencia profesional del solicitante");
	
		experienciaProfesional = new ExperienciaProfesional();
		industria = new Industria();
		industria.setIdIndustria(1);
		industria.setNombreIndustria("Consultoria");
		
		experienciaProfesional.setNombreOrganizacion("SSS");
		experienciaProfesional.setIndustria(industria);
		experienciaProfesional.setCargo("Call Center");
		experienciaProfesional.setFechaInicio(new Date());
		experienciaProfesional.setFechatermino(new Date());
		experienciaProfesional.setDescripcionLaboral("Mi labor consistia en contestar llamadas...");
		
		try {
			int idExp = registroPosDao.registrarExperienciaProfesional(experienciaProfesional);
			experienciaProfesional.setIdExperienciaProfesional(idExp);
			//Validar
			assertTrue(idExp>=1);
			System.out.println("Se registró la 2da experiencia Profesional correctamente:-->"+experienciaProfesional.toString());
			lista.add(experienciaProfesional);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
				
		solicitante.setListExperienciaProfesional(lista);
		
	}
	
}
