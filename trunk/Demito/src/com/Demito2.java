package com;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class Demito2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Locale usersLocale = Locale.getDefault();
	    Calendar cal = Calendar.getInstance(usersLocale);
	    int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        System.out.println("dia:"+day);
        System.out.println("diaSemana:"+dayWeek);
        System.out.println("mes"+month);
        System.out.println("año"+year);
        
        int dia1=0;
        int dia2=0;
        int dia3=0;
        int dia4=0;
        int dia5=0;
        int dia6=0;
        int dia7=0;
 
        
        if(dayWeek==1){
        	dia1=day-6;dia2=day-5;dia3=day-4;dia4=day-3;dia5=day-2;dia6=day-1;dia7=day;
        }
        if(dayWeek==2){
        	dia1=day;dia2=day-3;dia3=day-2;dia4=day-1;dia5=day;dia6=day+1;dia7=day+6;
        }
        if(dayWeek==3){
        	dia1=day-1;dia2=day-3;dia3=day-2;dia4=day-1;dia5=day;dia6=day+1;dia7=day+5;
        }
        if(dayWeek==4){
        	dia1=day-2;dia2=day-1;dia3=day;dia4=day+1;dia5=day+2;dia6=day+3;dia7=day+4;
        }
        if(dayWeek==5){
        	dia1=day-3;dia2=day-2;dia3=day-1;dia4=day;dia5=day+1;dia6=day+2;dia7=day+3;
        }
        if(dayWeek==6){
        	dia1=day-4;dia2=day-3;dia3=day-2;dia4=day-1;dia5=day;dia6=day+1;dia7=day+2;
        }
        if(dayWeek==7){
        	dia1=day-5;dia2=day-4;dia3=day-3;dia4=day-2;dia5=day-1;dia6=day;dia7=day+1;
        }
        System.out.println("dia1:"+dia1);
        System.out.println("dia2:"+dia2);
        System.out.println("dia3:"+dia3);
        System.out.println("dia4:"+dia4);
        System.out.println("dia5:"+dia5);
        System.out.println("dia6:"+dia6);
        System.out.println("dia7:"+dia7);

    }

}
