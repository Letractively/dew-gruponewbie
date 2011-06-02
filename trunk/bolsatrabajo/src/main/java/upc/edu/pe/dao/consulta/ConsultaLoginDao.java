package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.util.ConexionBD;

public class ConsultaLoginDao extends BaseDAO{

	public boolean obtener(String email_per, String contrasenha) throws DAOExcepcion {
		System.out.println("ConsultaLoginDao: obtener(String email_per)");
		
		boolean flagRpta=false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select count(1) as contador from tb_persona where email_per= ? and password_per = ?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, email_per);
			stmt.setString(2, contrasenha);
			rs = stmt.executeQuery();
			if (rs.next()) {
				if(rs.getInt("contador")>0){
					flagRpta=true;					
				}				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return flagRpta;
	}
}