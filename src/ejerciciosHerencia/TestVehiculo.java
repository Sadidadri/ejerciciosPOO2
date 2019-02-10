package ejerciciosHerencia;
import java.util.Scanner;
/**
 * Clase para probar las clases Vehiculos
 * @author d18momoa
 *
 */
public class TestVehiculo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Bicicleta bici = new Bicicleta(200);
		Coche coche = new Coche(15000);

		boolean gestionarMenu = true;

		while (gestionarMenu) {
			mostrarOpciones();
			System.out.println("Elija una opcion:");
			int opcionElegida = Integer.parseInt(entrada.nextLine());
				    
			if(opcionElegida == 1) {
				bici.echarAAndar();
			}else if(opcionElegida == 2){
				bici.hacerElCaballito();
			}else if(opcionElegida == 3){
				coche.echarAAndar();
			}else if(opcionElegida == 4){
				coche.quemarRueda();
			}else if(opcionElegida == 5){
				System.out.println("La bici ha recorrido "+bici.getKilometrosRecorridos()+ " kilometros");
			}else if(opcionElegida == 6){
				System.out.println("El coche ha recorrido "+coche.getKilometrosRecorridos()+" kilometros");
			}else if(opcionElegida == 7){
				System.out.println("En total se han recorrido "+coche.getKilometrosTotales()+" kilometros");
			}else if(opcionElegida == 8){
				gestionarMenu = false;
				System.out.println("Saliendo...");       
			}else {
				System.out.println("Has introducido una opcion no valida.");
			}
		}
	}
	public static void mostrarOpciones() {
    System.out.println("VEHICULOS:\n1. Anda con la Bicicleta.\n2. Haz el caballito con la Bicicleta. \n3. Anda con el coche. \n4. Quema rueda con el coche."
           +"\n5. Ver kilometraje de la bicicleta. \n6. Ver kilometraje del coche. \n7. Ver kilometraje total. \n8. Salir.");
	}
}
