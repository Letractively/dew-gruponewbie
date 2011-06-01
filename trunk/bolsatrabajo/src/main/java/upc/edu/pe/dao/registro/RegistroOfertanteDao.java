package upc.edu.pe.dao.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Ofertante;
import upc.edu.pe.util.ConexionBD;

public class RegistroOfertanteDao extends BaseDAO {

	public int registrarOfertante(Ofertante ofertante) throws DAOExcepcion {
		int idPersona = 0;
		String query = "insert into tb_persona (nombreRazonSocial_per, email_per, password_per, id_tipdoc, numeroDocumento_per, telefono_per, id_tipper) values (?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, ofertante.getRazonSocial());
			stmt.setString(2, ofertante.getCorreo());
			stmt.setString(3, ofertante.getContrasenhia());
			stmt.setString(4, ofertante.getTipoDocumento());
			stmt.setString(5, ofertante.getNumeroDocumento());
			stmt.setString(6, ofertante.getTelefono());
			stmt.setString(7, ofertante.getTipoPersona());

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
	
	public int modificarOfertante(Ofertante ofertante) throws DAOExcepcion {
		int idPersona = 0;
		String query = "update tb_persona SET nombreRazonSocial_per = ? , email_per = ? , password_per = ?, id_tipdoc = ?, numeroDocumento_per = ?, telefono_per = ?, id_tipper = ? where id_per = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, ofertante.getRazonSocial());
			stmt.setString(2, ofertante.getCorreo());
			stmt.setString(3, ofertante.getContrasenhia());
			stmt.setString(4, ofertante.getTipoDocumento());
			stmt.setString(5, ofertante.getNumeroDocumento());
			stmt.setString(6, ofertante.getTelefono());
			stmt.setString(7, ofertante.getTipoPersona());
			stmt.setInt(8, ofertante.getId());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
			idPersona=1;
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
