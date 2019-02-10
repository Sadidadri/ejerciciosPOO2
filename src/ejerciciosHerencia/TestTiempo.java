package ejerciciosHerencia;

public class TestTiempo {

	public static void main(String[] args) {
		Tiempo time1 = new Tiempo(2,50,15);
		Tiempo time2 = new Tiempo(3,125,50);
			    
		System.out.println("Primer tiempo:");
		System.out.println(time1);
		System.out.println("Segundo tiempo:");
		System.out.println(time2);
			    
		System.out.println("T1 + T2:");
		System.out.println(time1.suma(time2));
		System.out.println("T2 - T1:");
		System.out.println(time2.resta(time1));
	}
}
