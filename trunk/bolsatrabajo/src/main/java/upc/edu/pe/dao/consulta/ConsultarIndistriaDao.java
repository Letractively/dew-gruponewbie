package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Industria;
import upc.edu.pe.util.ConexionBD;

public class ConsultarIndistriaDao extends BaseDAO {
	
	public List<Industria> listarIndustria() throws DAOExcepcion {
		System.out.println("ConsultarIndistriaDao: listarIndustria()");
		List<Industria> lista = new ArrayList<Industria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "Select id_ind, descripcion_ind from tb_industria" ;
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Industria ind = new Industria();
				ind.setIdIndustria(rs.getInt("id_ind"));
				ind.setNombreIndustria(rs.getString("descripcion_ind"));
				lista.add(ind);
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
