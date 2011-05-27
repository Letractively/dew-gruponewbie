package upc.edu.pe.web.comun;

import java.text.ParseException;

public class FormatDateSqlException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormatDateSqlException(String mensaje,ParseException e){
		super(mensaje,e);
	}

}
