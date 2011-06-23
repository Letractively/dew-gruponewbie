package upc.edu.pe.dao.consulta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.ExperienciaProfesional;
import upc.edu.pe.model.Industria;
import upc.edu.pe.model.PerfilProfesional;
import upc.edu.pe.model.Solicitante;
import upc.edu.pe.util.ConexionBD;

public class ConsultaPostulanteDao extends BaseDAO{
	
	public List<Solicitante> listarSolicitantePorSueldoReferencia(BigDecimal salario) throws DAOExcepcion {
		System.out.println("ConsultaPostulanteDao: listarAvisosPulicados()");
		List<Solicitante> lista = new ArrayList<Solicitante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT p.nombreRazonSocial_per as Nombre,p.apellidoPaterno_per as ApellidoPaterno,p.apellidoMaterno_per as ApellidoMaterno,p.titulo_per as Titulo,p.email_per as Email,p.numeroDocumento_per as NumeroDocumento,p.fechaNacimiento_per as FechaNacimiento,p.sexo_per as Sexo,p.telefono_per,p.celular_per,t.nombre_dep as Departamento,v.nombre_prov as Provincia,d.nombre_dis as Distrito,p.direccion_per as Direccion,p.salario_per as Salario,p.disponibilidad_per as Disponibilidad FROM tb_persona p,tb_distrito d,tb_provincia v,tb_departamento t WHERE p.id_dis=d.id_dis AND d.id_prov=v.id_prov AND v.id_dep=t.id_dep AND p.salario_per<?";
			stmt = con.prepareStatement(query);
			stmt.setBigDecimal(1, salario);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Solicitante sol = new Solicitante();
				PerfilProfesional perfil = new PerfilProfesional();
				
				sol.setNombre(rs.getString("Nombre"));
				sol.setApellidoPaterno(rs.getString("ApellidoPaterno"));
				sol.setApellidoMaterno(rs.getString("ApellidoMaterno"));
				// Titulo Profesional
				perfil.setTituloProfesional(rs.getString("Titulo"));
				sol.setCorreo(rs.getString("Email"));
				sol.setNumeroDocumento(rs.getString("NumeroDocumento"));
				sol.setFechaNacimiento(rs.getDate("FechaNacimiento"));
				sol.setSexo(rs.getString("Sexo"));
				sol.setTelefono(rs.getString("telefono_per"));
				sol.setCelular(rs.getString("celular_per"));
				sol.setDireccion(rs.getString("Direccion"));
				perfil.setPretencionEconomica(rs.getBigDecimal("Salario"));
				perfil.setDisponibilidadHoraria(rs.getString("Disponibilidad"));
				// Llenando los datos del perfil Profesional		
				sol.setPerfilProfesional(perfil);
				
				lista.add(sol);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}
	
	public Solicitante obtenerDatosPersonales(Solicitante solicitante) throws DAOExcepcion {
		System.out.println("ConsultaPostulanteDao: obtenerDatosPersonales()");
		Solicitante sol = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT p.resumen_per,p.nombreRazonSocial_per as Nombre,p.apellidoPaterno_per as ApellidoPaterno,p.apellidoMaterno_per as ApellidoMaterno,p.titulo_per as Titulo,p.email_per as Email,p.numeroDocumento_per as NumeroDocumento,p.fechaNacimiento_per as FechaNacimiento,p.sexo_per as Sexo,p.telefono_per,p.celular_per,t.nombre_dep as Departamento,v.nombre_prov as Provincia,d.nombre_dis as Distrito,p.direccion_per as Direccion,p.salario_per as Salario,p.disponibilidad_per as Disponibilidad FROM tb_persona p,tb_distrito d,tb_provincia v,tb_departamento t WHERE p.id_dis=d.id_dis AND d.id_prov=v.id_prov AND v.id_dep=t.id_dep AND p.id_per=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, solicitante.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				sol = new Solicitante();
				sol.setId(solicitante.getId());
				PerfilProfesional perfil = new PerfilProfesional();
				
				sol.setResumen(rs.getString("resumen_per"));
				sol.setNombre(rs.getString("Nombre"));
				sol.setApellidoPaterno(rs.getString("ApellidoPaterno"));
				sol.setApellidoMaterno(rs.getString("ApellidoMaterno"));
				// Titulo Profesional
				perfil.setTituloProfesional(rs.getString("Titulo")==null?"":rs.getString("Titulo"));
				perfil.setResumenProfesional(rs.getString("resumen_per")==null?"":rs.getString("resumen_per"));
				sol.setCorreo(rs.getString("Email"));
				sol.setNumeroDocumento(rs.getString("NumeroDocumento"));
				sol.setFechaNacimiento(rs.getDate("FechaNacimiento"));
				sol.setSexo(rs.getString("Sexo"));
				sol.setTelefono(rs.getString("telefono_per"));
				sol.setCelular(rs.getString("celular_per"));
				sol.setDireccion(rs.getString("Direccion"));
				perfil.setPretencionEconomica(rs.getBigDecimal("Salario")==null?new BigDecimal(0):rs.getBigDecimal("Salario"));
				perfil.setDisponibilidadHoraria(rs.getString("Disponibilidad")==null?"":rs.getString("Disponibilidad"));
				// Llenando los datos del perfil Profesional		
				sol.setPerfilProfesional(perfil);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return sol;
	}

	public List<ExperienciaProfesional> obtenerExperienciaProfesional(Solicitante solicitante) throws DAOExcepcion {
		System.out.println("ConsultaPostulanteDao: obtenerExperienciaProfesional()");
		List<ExperienciaProfesional> lstExperienciaProfesional = new ArrayList<ExperienciaProfesional>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT e.cargo_exp as Cargo,e.descripcion_exp as Descripcion,i.descripcion_ind as DescripcionIndustria,e.nombreEmpresa_exp as Empresa,e.fechaInicio_exp as FechaInicio,e.fechaFin_exp as FechaFin FROM tb_persona p,tb_experiencia_laboral e,tb_industria i WHERE p.id_per=e.id_per AND e.id_ind=i.id_ind AND p.id_per=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, solicitante.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				ExperienciaProfesional experiencia = new ExperienciaProfesional();
				Industria industria = new Industria();			
				experiencia.setCargo(rs.getString("Cargo"));
				experiencia.setDescripcionLaboral(rs.getString("Descripcion"));
				industria.setNombreIndustria(rs.getString("DescripcionIndustria"));
				experiencia.setNombreOrganizacion(rs.getString("Empresa"));
				experiencia.setFechaInicio(rs.getDate("FechaInicio"));
				experiencia.setFechatermino(rs.getDate("FechaFin"));
				experiencia.setIndustria(industria);
				lstExperienciaProfesional.add(experiencia);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lstExperienciaProfesional;
	}

}
