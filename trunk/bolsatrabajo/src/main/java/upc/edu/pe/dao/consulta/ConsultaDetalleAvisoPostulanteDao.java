package upc.edu.pe.dao.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import upc.edu.pe.dao.BaseDAO;
import upc.edu.pe.exception.DAOExcepcion;
import upc.edu.pe.model.DetalleAvisoPostulante;
import upc.edu.pe.model.Distrito;
import upc.edu.pe.model.Persona;
import upc.edu.pe.util.ConexionBD;

public class ConsultaDetalleAvisoPostulanteDao extends BaseDAO {

	public List<DetalleAvisoPostulante> buscarPostulantesAviso(DetalleAvisoPostulante dap, int edad) throws DAOExcepcion {
		System.out.println("ConsultaDetalleAvisoPostulante: buscarPostulantesAviso()");
		List<DetalleAvisoPostulante> lista = new ArrayList<DetalleAvisoPostulante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			StringBuffer sb = new StringBuffer(); 
			sb.append("select a.id_avi,email_per,titulo_per, resumen_per,disponibilidad_per, salario_per,apellidoPaterno_per, apellidoMaterno_per,direccion_per, descripcion_tipdoc,numeroDocumento_per, fechaNacimiento_per,telefono_per, celular_per,nombre_dis ");
			sb.append("from tb_detalle_aviso_postulante a inner join tb_persona b on a.id_per=b.id_per inner join tb_distrito c on c.id_dis=b.id_dis inner join tb_tipodocumento d on b.id_tipdoc=d.id_tipdoc ");
			sb.append("where a.id_avi=? ");
			
			//validacion de criterios
			if(dap.getPersona().getDisponibilidad()!=null){
				sb.append("and disponibilidad_per=? ");
			}
            	
			if(dap.getPersona().getSalario()!=null){
				sb.append("and salario_per<? ");
			}
			if(edad>0){
				sb.append("and (YEAR(CURDATE())-YEAR(fechaNacimiento_per)) < ?");
			}

			//asignacion de criterios
			int acum=1;
			stmt = con.prepareStatement(sb.toString());
			stmt.setInt(1, dap.getId_avi());
			if(dap.getPersona().getDisponibilidad()!=null){
				acum+=1;
				stmt.setString(acum, dap.getPersona().getDisponibilidad());
			}
			if(dap.getPersona().getSalario()!=null){
				acum+=1;
				stmt.setBigDecimal(acum, dap.getPersona().getSalario());
			}
			if(edad>0){
				acum+=1;
				stmt.setInt(acum, edad);
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				DetalleAvisoPostulante r_dap = new DetalleAvisoPostulante();
				Persona r_persona = new Persona();
				Distrito r_distrito = new Distrito();
				r_persona.setCorreo(rs.getString("email_per"));
				r_persona.setTitulo(rs.getString("titulo_per"));
				r_persona.setResumen(rs.getString("resumen_per"));
				r_persona.setDisponibilidad(rs.getString("disponibilidad_per"));
				r_persona.setSalario(rs.getBigDecimal("salario_per"));
				r_persona.setApellidoPaterno(rs.getString("apellidoPaterno_per"));
				r_persona.setApellidoMaterno(rs.getString("apellidoMaterno_per"));
				r_persona.setCorreo(rs.getString("descripcion_tipdoc"));
				r_persona.setNumeroDocumento(rs.getString("numeroDocumento_per"));
				r_persona.setDireccion(rs.getString("direccion_per"));
				r_persona.setFechaNacimiento(rs.getDate("fechaNacimiento_per"));
				r_persona.setTelefono(rs.getString("telefono_per"));
				r_persona.setCelular(rs.getString("celular_per"));
				r_distrito.setNombre(rs.getString("nombre_dis"));
				r_persona.setDistrito(r_distrito);
				r_dap.setPersona(r_persona);
				lista.add(r_dap);
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
