package upc.edu.pe.dao.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.TipoUsuario;
import upc.edu.pe.util.ConexionBD;

public class RegistroTipoUsuarioDao extends BaseDAO {

	public boolean registrarTipoUsuario(TipoUsuario tipoUsuario) throws DAOExcepcion {
		boolean flagRpta=true;
		String query = "INSERT INTO tb_tipousuario(des_tipusu) VALUES (?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, tipoUsuario.getDescripcion());
			int i = stmt.executeUpdate();
			if (i != 1) {
				flagRpta=false;
				throw new SQLException("No se pudo insertar");
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
