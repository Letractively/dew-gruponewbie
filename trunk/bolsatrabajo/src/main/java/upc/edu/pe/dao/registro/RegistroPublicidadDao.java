package upc.edu.pe.dao.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Publicidad;
import upc.edu.pe.util.ConexionBD;

public class RegistroPublicidadDao extends BaseDAO{
	public boolean registrarPublicidad(Publicidad publicidad) throws DAOExcepcion {
		boolean flagRpta=true;
		String query = "INSERT INTO tb_publicidad(desc_corta_publi, cuerpo_publi, enlace_publi," +
				" fechaInicial_publi, fecha_fin, estado_publi) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, publicidad.getDescripcion());
			stmt.setString(2, publicidad.getCuerpo());
			stmt.setString(3,publicidad.getEnlace());
			stmt.setDate(4, new java.sql.Date(publicidad.getFechainicial().getTime()));
			stmt.setDate(5, new java.sql.Date(publicidad.getFechafin().getTime()));
			stmt.setString(6, publicidad.getEstado());
						
			int i = stmt.executeUpdate();
			if (i != 1) {
				flagRpta=false;
				throw new SQLException("No se pudo insertar publicidad");
			}
		} catch (SQLException e) {
			flagRpta=false;
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return flagRpta;
	}
	
	public boolean modificarPublicidad(Publicidad publicidad) throws DAOExcepcion {
		boolean flagRpta=true;
		String query = "UPDATE tb_publicidad SET desc_corta_publi = ?, cuerpo_publi = ?, enlace_publi = ?, fechaInicial_publi = ?, fecha_fin = ?, estado_publi = ? WHERE id_publi= ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, publicidad.getDescripcion());
			stmt.setString(2, publicidad.getCuerpo());
			stmt.setString(3,publicidad.getEnlace());
			stmt.setDate(4, new java.sql.Date(publicidad.getFechainicial().getTime()));
			stmt.setDate(5, new java.sql.Date(publicidad.getFechafin().getTime()));
			stmt.setString(6, publicidad.getEstado());
			stmt.setInt(7, publicidad.getIdpublicidad());
						
			int i = stmt.executeUpdate();
			if (i != 1) {
				flagRpta=false;
				throw new SQLException("No se pudo actualizar publicidad");
			}
		} catch (SQLException e) {
			flagRpta=false;
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return flagRpta;
	}
	
	public boolean anularPublicidad(Publicidad publicidad) throws DAOExcepcion {
		boolean flagRpta=true;
		String query = "UPDATE tb_publicidad SET estado_publi = ? WHERE id_publi= ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, publicidad.getEstado());
			stmt.setInt(2, publicidad.getIdpublicidad());
						
			int i = stmt.executeUpdate();
			if (i != 1) {
				flagRpta=false;
				throw new SQLException("No se pudo anular publicidad");
			}
		} catch (SQLException e) {
			flagRpta=false;
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return flagRpta;
	}
}
