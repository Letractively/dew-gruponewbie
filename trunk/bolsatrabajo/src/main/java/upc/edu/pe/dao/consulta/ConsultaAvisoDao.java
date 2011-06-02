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
import upc.edu.pe.model.Especialidad;
import upc.edu.pe.util.ConexionBD;
import upc.edu.pe.web.comun.Constantes;
import upc.edu.pe.web.comun.HelperDate;

public class ConsultaAvisoDao extends BaseDAO {

	public List<Aviso> listarAvisosPulicados() throws DAOExcepcion {
		System.out.println("ConsultaAvisoDao: listarAvisosPulicados()");
		List<Aviso> lista = new ArrayList<Aviso>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT a.id_avi, a.cargo_avi, a.inicio_avi, a.fin_avi, a.descripcion_avi, a.jornadaLaboral_avi, a.disponibilidad_avi, a.requerimientos_avi, a.beneficios_avi, a.sueldo_avi, a.estado_avi, a.conteoLectura_avi, a.id_per, a.id_Especialidad, e.nombre_espe FROM tb_aviso a, tb_especialidad e WHERE a.id_Especialidad = e.id_Especialidad and estado_avi = 'P'";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Aviso aviso = new Aviso();
				aviso.setId(rs.getInt("id_avi"));
				aviso.setCargo(rs.getString("cargo_avi"));
				aviso.setFechaInicio(HelperDate.parseaDate(rs.getString("inicio_avi"), Constantes.FORMATO_FECHA));
				aviso.setFechaFin(HelperDate.parseaDate(rs.getString("fin_avi"), Constantes.FORMATO_FECHA));
				aviso.setDescripcion(rs.getString("descripcion_avi"));
				aviso.setJornadaLaboral(rs.getString("jornadaLaboral_avi"));
				aviso.setDisponibilidad(rs.getString("disponibilidad_avi"));
				aviso.setRequerimiento(rs.getString("requerimientos_avi"));
				aviso.setBeneficios(rs.getString("beneficios_avi"));
				aviso.setSueldo(rs.getBigDecimal("sueldo_avi"));
				aviso.setEstado(rs.getString("estado_avi"));
				aviso.setContadorVisitas(rs.getInt("conteoLectura_avi"));
				Especialidad espec = new Especialidad();
				espec.setIdEspecialidad(rs.getInt("id_Especialidad"));
				espec.setNombreEspecialidad(rs.getString("nombre_espe"));
				aviso.setEspecialidad(espec);
				
				lista.add(aviso);
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
	
	public List<Aviso> listarAvisosPorEspecialidad(Especialidad esp) throws DAOExcepcion {
		System.out.println("ConsultaAvisoDao: listarAvisosPulicados()");
		List<Aviso> lista = new ArrayList<Aviso>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT a.id_avi, a.cargo_avi, a.inicio_avi, a.fin_avi, a.descripcion_avi, a.jornadaLaboral_avi, a.disponibilidad_avi, a.requerimientos_avi, a.beneficios_avi, a.sueldo_avi, a.estado_avi, a.conteoLectura_avi, a.id_per, a.id_Especialidad, e.nombre_espe FROM tb_aviso a, tb_especialidad e WHERE a.id_Especialidad = e.id_Especialidad and estado_avi = 'P' and a.id_Especialidad = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, esp.getIdEspecialidad());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Aviso aviso = new Aviso();
				aviso.setId(rs.getInt("id_avi"));
				aviso.setCargo(rs.getString("cargo_avi"));
				aviso.setFechaInicio(HelperDate.parseaDate(rs.getString("inicio_avi"), Constantes.FORMATO_FECHA));
				aviso.setFechaFin(HelperDate.parseaDate(rs.getString("fin_avi"), Constantes.FORMATO_FECHA));
				aviso.setDescripcion(rs.getString("descripcion_avi"));
				aviso.setJornadaLaboral(rs.getString("jornadaLaboral_avi"));
				aviso.setDisponibilidad(rs.getString("disponibilidad_avi"));
				aviso.setRequerimiento(rs.getString("requerimientos_avi"));
				aviso.setBeneficios(rs.getString("beneficios_avi"));
				aviso.setSueldo(rs.getBigDecimal("sueldo_avi"));
				aviso.setEstado(rs.getString("estado_avi"));
				aviso.setContadorVisitas(rs.getInt("conteoLectura_avi"));
				Especialidad espec = new Especialidad();
				espec.setIdEspecialidad(rs.getInt("id_Especialidad"));
				espec.setNombreEspecialidad(rs.getString("nombre_espe"));
				aviso.setEspecialidad(espec);
				
				lista.add(aviso);
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
