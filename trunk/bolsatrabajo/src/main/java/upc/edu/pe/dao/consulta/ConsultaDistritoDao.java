package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Distrito;
import upc.edu.pe.util.ConexionBD;

public class ConsultaDistritoDao extends BaseDAO {
	
	public List<Distrito> listar() throws DAOExcepcion {
		System.out.println("ConsultaDistritoDao: listar()");
		List<Distrito> c = new ArrayList<Distrito>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT id_dis, nombre_dis from tb_distrito";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Distrito vo = new Distrito();
				vo.setId_distrito(rs.getString("id_dis"));
				vo.setNombre(rs.getString("nombre_dis"));
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
