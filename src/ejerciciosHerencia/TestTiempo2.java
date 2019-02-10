package ejerciciosHerencia;
import java.time.*;
public class TestTiempo2 {

	public static void main(String[] args) {
		
		LocalTime time1 = construirTiempo(2,50,15);
		LocalTime time2 = construirTiempo(3,125,50);
		LocalTime suma;
		LocalTime resta;
		System.out.println("Primer tiempo:");
		System.out.println(time1);
		System.out.println("Segundo tiempo:");
		System.out.println(time2);
			    
		System.out.println("T1 + T2:");
		suma = suma(time1,time2); 
		System.out.println(suma);
		System.out.println("T2 - T1:");
		resta = resta(time2,time1);
		System.out.println(resta);
		
		/*Tiempo time1 = new Tiempo(2,50,15);
		Tiempo time2 = new Tiempo(3,125,50);
			    
		System.out.println("Primer tiempo:");
		System.out.println(time1);
		System.out.println("Segundo tiempo:");
		System.out.println(time2);
			    
		System.out.println("T1 + T2:");
		System.out.println(time1.suma(time2));
		System.out.println("T2 - T1:");
		System.out.println(time2.resta(time1));
		*/
	}
	public static LocalTime construirTiempo(int horas,int minutos,int segundos) {
		while (minutos >= 60) {
			horas +=1;
			minutos -=60;
		}
		while (segundos >= 60) {
			minutos +=1;
			segundos -=60;
		}
		return LocalTime.of(horas, minutos,segundos);
	}
	public static LocalTime suma(LocalTime time1,LocalTime time2) {
		return construirTiempo(time1.getHour()+time2.getHour(),time1.getMinute()+time2.getMinute(),time1.getSecond()+time2.getSecond());
	}
	public static LocalTime resta(LocalTime time1,LocalTime time2) {
		int horas = time1.getHour();
		int minutos = time1.getMinute();
		int segundos = time1.getSecond();
		
		while(segundos < time2.getSecond()) {
			segundos +=60;
			minutos--;
		}
		while(minutos < time2.getMinute()) {
			minutos +=60;
			horas--;
		}
		if (horas < time2.getHour()) {
			System.out.println("Error, el tiempo no puede ser negativo");
			return construirTiempo(0,0,0);
		}
		else {
			horas -= time2.getHour();
			minutos -= time2.getMinute();
			segundos -= time2.getSecond();
			return construirTiempo(horas,minutos,segundos);
		}
		
	}
	
}
