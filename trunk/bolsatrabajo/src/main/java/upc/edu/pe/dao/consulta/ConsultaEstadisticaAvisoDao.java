package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.util.ConexionBD;

public class ConsultaEstadisticaAvisoDao extends BaseDAO{
	
	/**
	 * javier watanabe
	 * Metodo que devuelve el listado con la cantidad de postulantes por aviso
	 * */
	public List<Aviso> estadisticaPostulantesAviso(Aviso aviso) throws DAOExcepcion {
		System.out.println("ConsultaEstadisticaAvisoDao: estadisticaPostulantesAviso()");
		List<Aviso> lista = new ArrayList<Aviso>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			StringBuffer sb = new StringBuffer(); 
			sb.append(" select a.id_avi,cargo_avi,inicio_avi,fin_avi,sueldo_avi,count(*) as total " +
					"from tb_detalle_aviso_postulante a inner join tb_aviso b");
			sb.append(" on a.id_avi=b.id_avi ");
			sb.append(" group by a.id_avi,cargo_avi,inicio_avi,fin_avi,sueldo_avi;");
			
			stmt = con.prepareStatement(sb.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Aviso r_aviso = new Aviso();
				r_aviso.setCargo(rs.getString("cargo_avi"));
				r_aviso.setFechaInicio(rs.getDate("inicio_avi"));
				r_aviso.setFechaFin(rs.getDate("fin_avi"));
				r_aviso.setSueldo(rs.getBigDecimal("sueldo_avi"));
				r_aviso.setTotalPostulantes(rs.getInt("total"));
				lista.add(r_aviso);
			}
			System.out.println("tamaño de la lista : "+lista.size());
		} catch (SQLException e) {
			System.err.println("ConsultaEstadisticaAvisoDao : estadisticaPostulantesAviso : "+e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}
}
