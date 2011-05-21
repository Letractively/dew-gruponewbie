package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.TipoUsuario;
import upc.edu.pe.util.ConexionBD;

public class ConsultaTipoUsuarioDao extends BaseDAO {

	public List<TipoUsuario> listar() throws DAOExcepcion {
		System.out.println("ConsultaTipoUsuarioDao: listar()");
		List<TipoUsuario> c = new ArrayList<TipoUsuario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT id_tipusu, des_tipusu from tb_tipousuario";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				TipoUsuario vo = new TipoUsuario();
				vo.setIdTipoUsuario(rs.getInt("id_tipusu"));
				vo.setDescripcion(rs.getString("des_tipusu"));
				c.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
}
