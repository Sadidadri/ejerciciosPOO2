package ejerciciosHerencia;
/**
 * Clase Vehiculo
 * @author d18momoa
 *
 */
public class Vehiculo {
	
	private static int kilometrosTotales = 0;
	private static int vehiculosCreados = 0;
	private int kilometrosRecorridos = 0;

	public Vehiculo(int kmR) {
		this.kilometrosRecorridos = kmR;
    kilometrosTotales += kmR;
    vehiculosCreados += 1;
	}
	private void setKilometrosRecorridos(int kilometrosRecorridos) {
		this.kilometrosRecorridos = kilometrosRecorridos;
	}
	public int getKilometrosRecorridos() {
		return kilometrosRecorridos;
	}
	public int getKilometrosTotales() {
		return kilometrosTotales;
	}
	public int getVehiculosCreados() {
		return vehiculosCreados;
	}
	public void echarAAndar() {
		System.out.println("En marcha");
	}
}    

