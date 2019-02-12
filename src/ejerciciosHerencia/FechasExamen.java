package ejerciciosHerencia;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Realiza los siguientes programas en Java:
1.- Muestra un men� con las siguientes opciones:
- Introducir (por teclado) una fecha en formato dd/mm/aaaa.
Pide una fecha al usuario, si no se introduce correctamente se devuelve un mensaje de error.
Usa una funci�n booleana para validar la fecha.
- Sumar d�as a la fecha.
Pide un n�mero de d�as (positivo) para sumar a la fecha introducida previamente y actualiza
su valor. Esta opci�n s�lo podr� realizarse si hay una fecha introducida, si no la hay mostrar�
un mensaje de error, si el n�mero de d�as introducido no es positivo tambi�n. Usa una funci�n
que recibir� la fecha, el n�mero de d�as a sumarle y devolver� la nueva fecha.
- Restar d�as a la fecha.
Pide un n�mero de d�as (negativo) para sumar a la fecha introducida previamente y actualiza
su valor. Esta opci�n s�lo podr� realizarse si hay una fecha introducida, si no la hay mostrar�
un mensaje de error, si el n�mero de d�as introducido no es negativo tambi�n. Usa la funci�n
del apartado anterior.
- Comparar la fecha introducida con otra.
Pide una fecha al usuario (v�lida, si no lo es da error) y la comparar� con la que tenemos
almacenada, posteriormente mostrar� si esta fecha es anterior, igual o posterior a la que
tenemos almacenada, usar� una funci�n para ello a la que le pasaremos las dos fechas y
devolver� un valor negativo si la 1� es ANTERIOR a la 2�, 0 si son IGUALES y un valor
positivo si es POSTERIOR.
- Mostrar fecha.
- Terminar.
 * @author d18momoa
 *
 */
public class FechasExamen {
	
	final static int [] DIAS_MES = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {	
		
		LocalDate fecha = null;
		Scanner s = new Scanner(System.in);
	  
	  boolean fechaIntroducida = false;
		boolean salirMenu = false;
		int elegirOpcion = 0;
		
		
		do {
      mostrarMenu();
      elegirOpcion = s.nextInt(); s.nextLine();
      switch(elegirOpcion) {
        case 1: System.out.print("Introduzca una fecha en formato dd/mm/aaaa: "); 
                String cad = s.nextLine();
                if (esFechaValida(cad)) {
                	int dia = Integer.parseInt(cad.substring(0,2));
                	int mes = Integer.parseInt(cad.substring(3,5));
                	int agno = Integer.parseInt(cad.substring(6,10));
                  fecha = LocalDate.of(agno,mes,dia);
                  fechaIntroducida = true;
                } else {
                  System.out.println("La fecha que ha introducido no es v�lida");
                  System.out.println("\nPulse Intro para continuar...");
                  s.nextLine();
                }
                break;
        case 2: case 3: case 4: case 5: // en todos estos casos debe haber fecha introducida
                if (fechaIntroducida) {
                  switch(elegirOpcion) {
                    case 2: case 3:
                      System.out.print("N�mero de d�as: ");
                      int n = s.nextInt(); s.nextLine();
                      if (n>0) {
                        if (elegirOpcion==2) {    // sumar d�as a la fecha
                          fecha = convertirCadenaALocalDate(sumaDiasFecha(convertirLocalDateACadena(fecha),n));
                        } else {        // restar d�as a la fecha
                          fecha = convertirCadenaALocalDate(sumaDiasFecha(convertirLocalDateACadena(fecha),-1*n));
                        }
                        System.out.println("La nueva fecha es "+fecha);
                      } else {
                        System.out.println("El n�mero de d�as no puede ser negativo.");
                      }
                      break;
                    case 4: // compara fechas
                      System.out.print("Introduzca una fecha para comparar con "+fecha+": ");
                      String fecha2 = s.nextLine();
                      if (esFechaValida(fecha2)) {
                        int comparacion = comparaFechas(convertirLocalDateACadena(fecha),fecha2);
                        if (comparacion<0) {
                          System.out.println(fecha+" es anterior a "+fecha2);
                        } else if (comparacion>0) {
                          System.out.println(fecha+" es posterior a "+fecha2);
                        }
                        else {
                          System.out.println("La fecha que introducido es igual a la fecha almacenada");
                        }
                      } else {
                        System.out.println("La fecha que ha introducido no es v�lida");
                      }
                      break;
                    case 5: // muestra fecha almacenada 
                      System.out.println("La fecha almacenada es "+fecha);
                  }
                  System.out.println("\nPulse Intro para continuar...");
                  s.nextLine();
                } else {
                  System.out.println("No hay fecha almacenada. Pulse Intro para continuar...");
                  s.nextLine();
                }
                break;
        case 6: System.out.println("Gracias por usar este programa"); 
        				salirMenu = true;
                break;
        default: System.out.println("Opci�n err�nea. Pulse Intro para continuar...");
                s.nextLine(); 
      }
    } while (!salirMenu);
	}
	/**
   * Muestra el men� de opciones.
   */  
  public static void mostrarMenu() {
    System.out.println("Men� de opciones");
    System.out.println("----------------");
    System.out.println("1. Introducir una fecha");
    System.out.println("2. Sumar d�as a la fecha");
    System.out.println("3. Restar d�as a la fecha");
    System.out.println("4. Comparar fecha introducida con otra");
    System.out.println("5. Mostrar fecha almacenada");
    System.out.println("6. TERMINAR");
  }
  /**
   * Comprueba si la fecha pasada como par�metro es v�lida.
   * @param cad
   * @return <code>true</code> en caso de que sea v�ida y <code>false</code> en caso contrario
   */
  public static boolean esFechaValida(String f) {
    // comprobar que es un formato dd/mm/aaaa
    if (f.length()!=10  || !Character.isDigit(f.charAt(0)) || !Character.isDigit(f.charAt(1)) || !Character.isDigit(f.charAt(3))
                        || !Character.isDigit(f.charAt(4)) || !Character.isDigit(f.charAt(6)) || !Character.isDigit(f.charAt(7))
                        || !Character.isDigit(f.charAt(8)) || !Character.isDigit(f.charAt(9))
                        || f.charAt(2)!='/' || f.charAt(5)!='/') {
      return false;
    }
    // comprobar si mes es correcto
    int mes = Integer.parseInt(f.substring(3,5));
    if (mes<1 || mes>12) {
      return false;
    }
    // comprobar si d�a es correcto
    int dia = Integer.parseInt(f.substring(0, 2));
    int anyo = Integer.parseInt(f.substring(6));
    int diasmes = DIAS_MES[mes-1];  // restamos 1 al mes para que est� entre 0 y 11
    // �febrero y a�o bisisesto?
    if (mes==2 && anyo%4==0 && (anyo%100!=0 || anyo%400==0)) {
      diasmes++;
    }
    return (dia>0 && dia<=diasmes);
  }

  /**
   * Compara dos fechas.
   * @param fecha1
   * @param fecha2
   * @return un valor positivo si la primera es posterior a la segunda, negativo si es anterior y 0 si son iguales
   */
  public static int comparaFechas(String fecha1, String fecha2) {
    int dia1 = Integer.parseInt(fecha1.substring(0, 2));
    int dia2 = Integer.parseInt(fecha2.substring(0, 2));
    int mes1 = Integer.parseInt(fecha1.substring(3, 5));
    int mes2 = Integer.parseInt(fecha2.substring(3, 5));
    int anyo1 = Integer.parseInt(fecha1.substring(6));
    int anyo2 = Integer.parseInt(fecha2.substring(6));
    
    if (anyo1!=anyo2) {
      return anyo1-anyo2;
    } else if (mes1!=mes2) {
      return mes1-mes2;
    } else {
      return dia1-dia2;
    }
  }
  
  /**
   * Suma a la fecha los d�as indicados y devuelve la nueva fecha.
   * @param fecha
   * @param n   puede ser positivo o negativo
   * @return una nueva fecha
   */
  public static String sumaDiasFecha(String fecha, int n) {
    String fecha2 = fecha;
    if (n>=0) {
      for (int i=1; i<=n; i++) {
        fecha2 = suma1DiaFecha(fecha2);
      }
    } else {
      int ndias=Math.abs(n);
      for (int i=1; i<=ndias; i++) {
        fecha2 = resta1DiaFecha(fecha2);
      }
    }
    int dia = Integer.parseInt(fecha2.substring(0,2));
  	int mes = Integer.parseInt(fecha2.substring(3,5));
  	int agno = Integer.parseInt(fecha2.substring(6,10));
    return fecha2;
    
  }

  /**
   * Suma un d�a a la fecha
   * @param f
   * @return fecha del d�a siguiente
   */
  public static String suma1DiaFecha(String f) {
    int d = Integer.parseInt(f.substring(0, 2));
    int m = Integer.parseInt(f.substring(3, 5));
    int a = Integer.parseInt(f.substring(6));
    
    int diasmes = DIAS_MES[m-1];
    // �febrero y a�o bisisesto?
    if (m==2 && a%4==0 && (a%100!=0 || a%400==0)) {
      diasmes++;
    }
    d++;
    if (d>diasmes) {
      d = 1;
      m++;
      if (m==13) {
        m = 1;
        a++;
      }
    }
    f = fecha(d,m,a);
    return f;
  }

  /**
   * Resta un d�a a la fecha
   * @param f
   * @return fecha del d�a siguiente
   */
  public static String resta1DiaFecha(String f) {
    int d = Integer.parseInt(f.substring(0, 2));
    int m = Integer.parseInt(f.substring(3, 5));
    int a = Integer.parseInt(f.substring(6));
    
    d--;
    if (d==0) { // mes anterior
      m--;
      if (m==0) { // a�o anterior
        m=12;
        a--;
      } 
      d = DIAS_MES[m-1];
      // �febrero y a�o bisisesto?
      if (m==2 && a%4==0 && (a%100!=0 || a%400==0)) {
        d++;
      }
    }
    f = fecha(d,m,a);
    return f;
  }

  
  /**
   * Devuelve una cadena en formato dd/mm/aaaa
   * @param d d�a del mes
   * @param m d�a del a�o
   * @param a a�o
   * @return
   */
  public static String fecha(int d, int m, int a) {
    String dia=Integer.toString(d).trim();
    String mes=Integer.toString(m).trim();
    String anyo=Integer.toString(a).trim();
    String f;
    // d�a
    if (dia.length()<2) {
      dia = "0"+dia;
    }
    // mes
    if (mes.length()<2) {
      mes = "0"+mes;
    }
    // a�o
    for (int i=anyo.length(); i<4; i++) {
      anyo = "0"+anyo;
    }
    return dia + "/" + mes + "/" + anyo;
  }
  public static String convertirLocalDateACadena(LocalDate ld) {
  	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  	String cadena = ld.format(formatter);
  	return cadena;
  }
  public static LocalDate convertirCadenaALocalDate(String cad) {
  	int d = Integer.parseInt(cad.substring(0, 2));
    int m = Integer.parseInt(cad.substring(3, 5));
    int a = Integer.parseInt(cad.substring(6));
  	return LocalDate.of(a, m, d);
  }
}

