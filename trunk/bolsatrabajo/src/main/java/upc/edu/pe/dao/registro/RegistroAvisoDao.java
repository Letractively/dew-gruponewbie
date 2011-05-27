package upc.edu.pe.dao.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.Aviso;
import upc.edu.pe.model.TipoUsuario;
import upc.edu.pe.util.ConexionBD;

public class RegistroAvisoDao extends BaseDAO {
//SELECT id_avi, cargo_avi, inicio_avi, fin_avi, descripcion_avi, jornadaLaboral_avi, disponibilidad_avi, requerimientos_avi, beneficios_avi, sueldo_avi, estado_avi, conteoLectura_avi, id_per, id_Especialidad FROM tb_aviso'
	public boolean registrarAvisoo(Aviso aviso, int idUsuario) throws DAOExcepcion {
		boolean flagRpta=true;
		String query = "INSERT INTO tb_aviso(cargo_avi, inicio_avi, fin_avi, descripcion_avi, jornadaLaboral_avi, disponibilidad_avi, requerimientos_avi, beneficios_avi, sueldo_avi, estado_avi, conteoLectura_avi, id_per, id_Especialidad) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, aviso.getCargo());
			stmt.setDate(2, new java.sql.Date(aviso.getFechaInicio().getTime()));
			stmt.setDate(3, new java.sql.Date(aviso.getFechaFin().getTime()));
			stmt.setString(4, aviso.getDescripcion());
			stmt.setString(5, aviso.getJornadaLaboral());
			stmt.setString(6, aviso.getDisponibilidad());
			stmt.setString(7, aviso.getRequerimiento());
			stmt.setString(8, aviso.getBeneficios());
			stmt.setBigDecimal(9, aviso.getSueldo());
			stmt.setString(10, aviso.getEstado());
			stmt.setInt(11, aviso.getContadorVisitas());
			stmt.setInt(12, idUsuario);
			stmt.setInt(13, aviso.getEspecialidad().getIdEspecialidad());
			
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
