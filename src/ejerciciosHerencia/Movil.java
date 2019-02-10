package ejerciciosHerencia;

import java.text.DecimalFormat;

public class Movil extends Terminal{
	
	private float costo= 0;
	private String tarifa= "";
	DecimalFormat df = new DecimalFormat("#.00");
	
	public Movil(String num,String tarifa) {
		super(num);
		setTarifa(tarifa);
	}
	private void setTarifa(String tarifa) {
		if(tarifa.equals("rata") || tarifa.equals("RATA") || tarifa.equals("mono") || tarifa.equals("MONO") || tarifa.equals("bisonte") || tarifa.equals("BISONTE") ) {
      this.tarifa = tarifa;
		}else {
      System.out.println("Esa tarifa no existe.");
		}
	}
	public void llama(Movil m2,int tiempo) {
	  if (this.tarifa.equals("rata") || this.tarifa.equals("RATA")) {
      this.costo += (0.06 * (((float)tiempo/100)));
	  }else if (this.tarifa.equals("mono") || this.tarifa.equals("MONO")) {
	  	this.costo += (0.12 * (((float)tiempo/100)));
	  }else if (this.tarifa.equals("bisonte") || this.tarifa.equals("BISONTE")){
	  	this.costo += (0.30 * (((float)tiempo/100)));    
    }else{
      System.out.println("Error al realizar la llamada.");
    }
    super.llama(m2, tiempo);
  }
	public String toString() {
		String cadena = super.toString();
		return cadena + ", tarificados 0"+df.format(this.costo)+" euros";
	}  
}
