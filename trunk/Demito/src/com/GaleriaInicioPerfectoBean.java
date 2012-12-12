package com;


/** 
 * Resumen. 
 * Descripción detallada 
 * Objeto que recibirá los parámatros de la url y el código de país
 * 
 * @author Angel Tamayo Trigoso
 * @version 1.00, 7/08/2012  
 *  
*/

public class GaleriaInicioPerfectoBean {

	private String codPaisOD;

	// Parametros de Atlas
	private Integer app_inst_id; // codigo de pais

	private Integer app_id; // codigo de aplicacion

	private Integer rpt_id;// codigo de reporte

	private Integer usr_prf_id;

	private Integer role_id;

	private Integer rpt_col_id;// codigo de columna

	private String rpt_col_x_app_inst_nm;// nombre de columna

	// Parametros de Extranet
	private Short smlCodigoPaquete;

	private Short smlCodigoProceso;

	private Byte intCodigoInstancia;

	private String vchCodigoUsuario;

	private Byte intTipoUsuario;

	private Integer intAno;

	private Integer orden;


	public Integer getApp_id() {
		return app_id;
	}

	public void setApp_id(Integer app_id) {
		this.app_id = app_id;
	}

	public Integer getApp_inst_id() {
		return app_inst_id;
	}

	public void setApp_inst_id(Integer app_inst_id) {
		this.app_inst_id = app_inst_id;
	}

	public String getCodPaisOD() {
		return codPaisOD;
	}

	public void setCodPaisOD(String codPaisOD) {
		this.codPaisOD = codPaisOD;
	}

	public Integer getIntAno() {
		return intAno;
	}

	public void setIntAno(Integer intAno) {
		this.intAno = intAno;
	}

	public Byte getIntCodigoInstancia() {
		return intCodigoInstancia;
	}

	public void setIntCodigoInstancia(Byte intCodigoInstancia) {
		this.intCodigoInstancia = intCodigoInstancia;
	}

	public Byte getIntTipoUsuario() {
		return intTipoUsuario;
	}

	public void setIntTipoUsuario(Byte intTipoUsuario) {
		this.intTipoUsuario = intTipoUsuario;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getRpt_col_id() {
		return rpt_col_id;
	}

	public void setRpt_col_id(Integer rpt_col_id) {
		this.rpt_col_id = rpt_col_id;
	}

	public String getRpt_col_x_app_inst_nm() {
		return rpt_col_x_app_inst_nm;
	}

	public void setRpt_col_x_app_inst_nm(String rpt_col_x_app_inst_nm) {
		this.rpt_col_x_app_inst_nm = rpt_col_x_app_inst_nm;
	}

	public Integer getRpt_id() {
		return rpt_id;
	}

	public void setRpt_id(Integer rpt_id) {
		this.rpt_id = rpt_id;
	}

	public Short getSmlCodigoPaquete() {
		return smlCodigoPaquete;
	}

	public void setSmlCodigoPaquete(Short smlCodigoPaquete) {
		this.smlCodigoPaquete = smlCodigoPaquete;
	}

	public Short getSmlCodigoProceso() {
		return smlCodigoProceso;
	}

	public void setSmlCodigoProceso(Short smlCodigoProceso) {
		this.smlCodigoProceso = smlCodigoProceso;
	}

	public Integer getUsr_prf_id() {
		return usr_prf_id;
	}

	public void setUsr_prf_id(Integer usr_prf_id) {
		this.usr_prf_id = usr_prf_id;
	}

	public String getVchCodigoUsuario() {
		return vchCodigoUsuario;
	}

	public void setVchCodigoUsuario(String vchCodigoUsuario) {
		this.vchCodigoUsuario = vchCodigoUsuario;
	}

	/*public String getVchNombrePremio() {
		return vchNombrePremio;
	}

	public void setVchNombrePremio(String vchNombrePremio) {
		this.vchNombrePremio = vchNombrePremio;
	}*/
	



}
