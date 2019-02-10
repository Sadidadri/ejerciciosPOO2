package ejerciciosHerencia;

public class Terminal {
	private int tiempoLlamada = 0;
	private String numero;
	
	public Terminal(String num) {
		setNumero(num);
		setTiempoLlamada(0);
	}
  private void setNumero(String num) {
  	String compruebaNumero = num.replace(" ", "");
    compruebaNumero = compruebaNumero.replace("-","");
  	
  	if (compruebaNumero.length() == 9) {
  		this.numero = num;
  	}else {
  		System.out.println("Error, debes asignar un numero valido de 9 digitos.");
  	}
  }
  private void setTiempoLlamada(int tiempo) {
  	this.tiempoLlamada += tiempo;
  }
  public void llama(Terminal t2,int tiempo) {
  	setTiempoLlamada(tiempo);
  	t2.setTiempoLlamada(tiempo);
  }
  public String toString() {
  	return "Nº"+this.numero+" - "+this.tiempoLlamada+"s de conversacion";
  } 
}
