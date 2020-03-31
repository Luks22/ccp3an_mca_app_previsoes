package br.usjt.meteriologia.model;

import java.util.Calendar;

public class Relogio {

	public String horario() {
		
		Calendar calendar = Calendar.getInstance();
		String horario, minutos;
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		
		if(minutes < 10) {
		   minutos = "0" + Integer.toString(minutes);
		   horario = Integer.toString(hour) + ":" + minutos;
		}else {
			
		 horario = Integer.toString(hour) + ":" + Integer.toString(minutes);
		 
		}
		
		return horario;
	}
}
