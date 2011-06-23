package upc.edu.pe.dao.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.ExperienciaProfesional;
import upc.edu.pe.model.Solicitante;
import upc.edu.pe.util.ConexionBD;

public class RegistroPostulanteDao extends BaseDAO {

	public int registrarSolicitante(Solicitante solicitante) throws DAOExcepcion {
		int idPersona = 0;
		String query = "insert into tb_persona (email_per,password_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, solicitante.getCorreo());
			stmt.setString(2, solicitante.getContrasenhia());
			stmt.setString(3, solicitante.getNombre());
			stmt.setString(4, solicitante.getApellidoPaterno());
			stmt.setString(5, solicitante.getApellidoMaterno());
			stmt.setString(6, solicitante.getDireccion());
			stmt.setString(7, solicitante.getNumeroDocumento());
			stmt.setString(8, solicitante.getSexo());
			stmt.setDate(9, new java.sql.Date(solicitante.getFechaNacimiento().getTime()));
			stmt.setString(10, solicitante.getTelefono());
			stmt.setString(11, solicitante.getCelular());
			stmt.setString(12, solicitante.getTipoPersona());
			stmt.setInt(13, solicitante.getTipoUsuario().getIdTipoUsuario());
			stmt.setString(14, solicitante.getDistrito().getId_distrito());
			stmt.setString(15, solicitante.getTipoDocumento());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			} else {
				String queryStr = "select LAST_INSERT_ID()";
				stmt = con.prepareStatement(queryStr);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					idPersona = rs.getInt(1);
				}
				rs.close();

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}

		return idPersona;
	}

	public int registrarPerfilProfesional(Solicitante solicitante)
			throws DAOExcepcion {
		int idPerfil = 0;
		String query = "UPDATE tb_persona SET titulo_per = ?, resumen_per = ?, disponibilidad_per = ?, salario_per = ? WHERE id_per = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, solicitante.getPerfilProfesional().getTituloProfesional());
			stmt.setString(2, solicitante.getPerfilProfesional().getResumenProfesional());
			stmt.setString(3, solicitante.getPerfilProfesional().getDisponibilidadHoraria());
			stmt.setBigDecimal(4, solicitante.getPerfilProfesional().getPretencionEconomica());
			stmt.setInt(5, solicitante.getId());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			} 
			idPerfil=1;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}

		return idPerfil;
	}
	
	public int registrarExperienciaProfesional(ExperienciaProfesional experienciaProfesional) throws DAOExcepcion {
		int idPersona = 0;
		String query = "INSERT INTO tb_experiencia_laboral (nombreEmpresa_exp, cargo_exp, fechaInicio_exp, fechaFin_exp, descripcion_exp, id_per, id_ind) VALUES(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, experienciaProfesional.getNombreOrganizacion());
			stmt.setString(2, experienciaProfesional.getCargo());
			stmt.setDate(3, new java.sql.Date(experienciaProfesional.getFechaInicio().getTime()));
			stmt.setDate(4, new java.sql.Date(experienciaProfesional.getFechatermino().getTime()));
			stmt.setString(5, experienciaProfesional.getDescripcionLaboral());
			stmt.setInt(6, idPersona);
			stmt.setInt(7, experienciaProfesional.getIndustria().getIdIndustria());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			} else {
				String queryStr = "select LAST_INSERT_ID()";
				stmt = con.prepareStatement(queryStr);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					idPersona = rs.getInt(1);
				}
				rs.close();

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}

		return idPersona;
	}
}
