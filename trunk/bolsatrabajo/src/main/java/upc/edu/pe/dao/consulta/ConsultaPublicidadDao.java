package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Publicidad;
import upc.edu.pe.util.ConexionBD;
import upc.edu.pe.web.comun.Constantes;
import upc.edu.pe.web.comun.HelperDate;

public class ConsultaPublicidadDao extends BaseDAO{

	public List<Publicidad> listarPublicidad() throws DAOExcepcion {
		System.out.println("ConsultaPublicidadDao: listarPublicidad()");
		List<Publicidad> lista = new ArrayList<Publicidad>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "Select id_publi, desc_corta_publi, cuerpo_publi, enlace_publi," +
				" fechaInicial_publi, fecha_fin, estado_publi from tb_publicidad" ;
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicidad publicidad = new Publicidad();
				publicidad.setIdpublicidad(rs.getInt("id_publi"));
				publicidad.setDescripcion(rs.getString("desc_corta_publi"));
				publicidad.setCuerpo(rs.getString("cuerpo_publi"));
				publicidad.setEnlace(rs.getString("enlace_publi"));
				publicidad.setFechainicial(HelperDate.parseaDate(rs.getString("fechaInicial_publi"), Constantes.FORMATO_FECHA));
				publicidad.setFechafin(HelperDate.parseaDate(rs.getString("fecha_fin"), Constantes.FORMATO_FECHA));
				publicidad.setEstado(rs.getString("estado_publi"));
				lista.add(publicidad);
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
	
	public Publicidad obtenerPublicidadPorId(int id) throws DAOExcepcion {
		System.out.println("ConsultaPublicidadDao: obtenerPublicidadPorId(int id)");
		Publicidad publicidad=null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "Select id_publi, desc_corta_publi, cuerpo_publi, enlace_publi," +
				" fechaInicial_publi, fecha_fin, estado_publi from tb_publicidad where id_publi=?" ;
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				publicidad = new Publicidad();
				publicidad.setIdpublicidad(rs.getInt("id_publi"));
				publicidad.setDescripcion(rs.getString("desc_corta_publi"));
				publicidad.setCuerpo(rs.getString("cuerpo_publi"));
				publicidad.setEnlace(rs.getString("enlace_publi"));
				publicidad.setFechainicial(HelperDate.parseaDate(rs.getString("fechaInicial_publi"), Constantes.FORMATO_FECHA));
				publicidad.setFechafin(HelperDate.parseaDate(rs.getString("fecha_fin"), Constantes.FORMATO_FECHA));
				publicidad.setEstado(rs.getString("estado_publi"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return publicidad;
	}
	
}
