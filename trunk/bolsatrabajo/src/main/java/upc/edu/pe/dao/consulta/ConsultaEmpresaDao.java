package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Ofertante;
import upc.edu.pe.util.ConexionBD;

public class ConsultaEmpresaDao extends BaseDAO {

	public Ofertante obtenerDatosEmpresa(Ofertante ofertante) throws DAOExcepcion {
		System.out.println("ConsultaEmpresaDao: buscarPorIndustria()");
		Ofertante ofert = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT id_per, email_per, resumen_per, nombreRazonSocial_per, direccion_per, telefono_per, celular_per, id_tipdoc, numeroDocumento_per FROM tb_persona where id_per = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, ofertante.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				ofert = new Ofertante();
				ofert.setId(rs.getInt("id_per"));
				ofert.setCorreo(rs.getString("email_per"));
				ofert.setRazonSocial(rs.getString("nombreRazonSocial_per"));
				ofert.setDireccion(rs.getString("direccion_per"));
				ofert.setTelefono(rs.getString("telefono_per"));
				ofert.setTipoDocumento(rs.getString("id_tipdoc"));
				ofert.setNumeroDocumento(rs.getString("numeroDocumento_per"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return ofert;
	}
	
	public List<Ofertante> buscarPorIndustria(int idIndustria) throws DAOExcepcion {
		System.out.println("ConsultaEmpresaDao: buscarPorIndustria()");
		List<Ofertante> lista = new ArrayList<Ofertante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT id_per, email_per, resumen_per, nombreRazonSocial_per, direccion_per, telefono_per, celular_per, id_tipdoc, numeroDocumento_per FROM tb_persona where id_tipper = 2 and id_ind = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idIndustria);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Ofertante ofert = new Ofertante();
				ofert.setId(rs.getInt("id_per"));
				ofert.setCorreo(rs.getString("email_per"));
				ofert.setRazonSocial(rs.getString("nombreRazonSocial_per"));
				ofert.setDireccion(rs.getString("direccion_per"));
				ofert.setTelefono(rs.getString("telefono_per"));
				ofert.setTipoDocumento(rs.getString("id_tipdoc"));
				ofert.setNumeroDocumento(rs.getString("numeroDocumento_per"));
				lista.add(ofert);
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
	
	public List<Ofertante> buscarPorNombre(String nombreEmpresa) throws DAOExcepcion {
		System.out.println("ConsultaEmpresaDao: buscarPorIndustria()");
		List<Ofertante> lista = new ArrayList<Ofertante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT id_per, email_per, resumen_per, nombreRazonSocial_per, direccion_per, telefono_per, celular_per, id_tipdoc, numeroDocumento_per FROM tb_persona where id_tipper = 2 and nombreRazonSocial_per LIKE ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%"+nombreEmpresa);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Ofertante ofert = new Ofertante();
				ofert.setId(rs.getInt("id_per"));
				ofert.setCorreo(rs.getString("email_per"));
				ofert.setRazonSocial(rs.getString("nombreRazonSocial_per"));
				ofert.setDireccion(rs.getString("direccion_per"));
				ofert.setTelefono(rs.getString("telefono_per"));
				ofert.setTipoDocumento(rs.getString("id_tipdoc"));
				ofert.setNumeroDocumento(rs.getString("numeroDocumento_per"));
				lista.add(ofert);
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
	
	public List<Ofertante> listadoGeneral() throws DAOExcepcion {
		System.out.println("ConsultaEmpresaDao: listadoGeneral()");
		List<Ofertante> lista = new ArrayList<Ofertante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT id_per, email_per, resumen_per, nombreRazonSocial_per, direccion_per, telefono_per, celular_per, id_tipdoc, numeroDocumento_per FROM tb_persona where id_tipper = 2";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Ofertante ofert = new Ofertante();
				ofert.setId(rs.getInt("id_per"));
				ofert.setCorreo(rs.getString("email_per"));
				ofert.setRazonSocial(rs.getString("nombreRazonSocial_per"));
				ofert.setDireccion(rs.getString("direccion_per"));
				ofert.setTelefono(rs.getString("telefono_per"));
				ofert.setTipoDocumento(rs.getString("id_tipdoc"));
				ofert.setNumeroDocumento(rs.getString("numeroDocumento_per"));
				lista.add(ofert);
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
}
