package ejerciciosHerencia;

import java.time.LocalTime;

public class Tiempo {
	int horas = 0;
	int minutos = 0;
	int segundos = 0;
	
	public Tiempo(int h,int m,int s) {
		if(h < 0) {
        System.out.println("Las horas no pueden ser negativas");
		}else {
			int segundosTotales = s + 60*m + 3600*h;
      this.horas = (int)(segundosTotales/3600);
      this.minutos = (int)((segundosTotales%3600)/60);
      this.segundos = (int)((segundosTotales%3600)%60);
		}
	}
	public int getHoras() {
    return this.horas;
  }
  public int getMinutos() {
    return this.minutos;
  }
  public int getSegundos() {
    return this.segundos;  
  }
  public String toString() {
  	return this.horas+"h"+this.minutos+"m"+this.segundos+"s"; 
  } 
  public Tiempo suma(Tiempo t2) {
  	Tiempo t3 = new Tiempo((this.horas+t2.getHoras()),(this.minutos+t2.getMinutos()),(this.segundos+t2.getSegundos()));
  	return t3;
  }
  public Tiempo resta(Tiempo t2) {
  		int horas = this.horas;
  		int minutos = this.minutos;
  		int segundos = this.segundos;
  		
  		while(segundos < t2.getSegundos()) {
  			segundos +=60;
  			minutos--;
  		}
  		while(minutos < t2.getMinutos()) {
  			minutos +=60;
  			horas--;
  		}
  		if (horas < t2.getHoras()) {
  			System.out.println("Error, el tiempo no puede ser negativo");
  			return new Tiempo(0,0,0);
  		}
  		else {
  			horas -= t2.getHoras();
  			minutos -= t2.getMinutos();
  			segundos -= t2.getSegundos();
  			return new Tiempo(horas,minutos,segundos);
  		}
  }
}
