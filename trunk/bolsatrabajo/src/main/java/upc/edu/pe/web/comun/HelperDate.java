package upc.edu.pe.web.comun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperDate {

	public static java.util.Date getFechaActual() {
		return new java.util.Date();
	}

	/**
	 * Obtiene un objeto java.util.Date desde una cadena con el formato especificado
	 * @param dateAsString
	 * @param formato
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date parseaDate(String dateAsString, String formato){
		Date result = null;
		SimpleDateFormat format = new SimpleDateFormat(formato);
		format.setLenient(false);
		try {
			result = format.parse(dateAsString);
		} catch (ParseException e) {		
			throw new FormatDateSqlException("Error al parsear la fecha " + dateAsString, e);
		}
		
		return result;		
	}
	
	public static String parseDateToString(Date date, String formato){

		String fecha ="";
		SimpleDateFormat sdf= new SimpleDateFormat(formato);//"dd/MM/yyyy");
		fecha = sdf.format(date);
		return fecha;
	}
}
