package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Login;
import upc.edu.pe.util.ConexionBD;

public class ConsultaLoginDao extends BaseDAO{

	public Login obtener(String email_per) throws DAOExcepcion {
		System.out.println("ConsultaLoginDao: obtener(String email_per)");
		Login vo = new Login();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select email_per, password_per from tb_persona where email_per=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, email_per);
			rs = stmt.executeQuery();
			if (rs.next()) {

				vo.setEmail_per(rs.getString(1));
				vo.setPassword_per(rs.getString(2));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
}