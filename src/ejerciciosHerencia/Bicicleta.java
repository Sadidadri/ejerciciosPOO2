package ejerciciosHerencia;

public class Bicicleta extends Vehiculo{

	public Bicicleta(int kmR) {
		super(kmR);
	}
	public void hacerElCaballito() {
		System.out.println("Ahora estoy haciendo el caballito.");
	}
}
