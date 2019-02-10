package ejerciciosHerencia;

public class Coche extends Vehiculo{

	public Coche(int kmR) {
		super(kmR);
	}
	
	public void quemarRueda() {
		System.out.println("Quemando rueda...");
	}
}
