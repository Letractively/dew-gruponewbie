package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Persona;
import upc.edu.pe.util.ConexionBD;

public class ConsultaUsuarioLoginDao extends BaseDAO {

	public Persona validarUsuarioLogin(String nombreUsuario, String contrasenha) throws DAOExcepcion {
		System.out.println("ConsultaUsuarioLoginDao: validarUsuarioLogin()");
		Persona per = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT id_per, id_tipper FROM tb_persona where email_per = ? and password_per= ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombreUsuario);
			stmt.setString(2, contrasenha);
			rs = stmt.executeQuery();
			while (rs.next()) {
				per = new Persona();
				per.setId(rs.getInt("id_per"));
				per.setTipoPersona(rs.getString("id_tipper"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return per;
	}

}
