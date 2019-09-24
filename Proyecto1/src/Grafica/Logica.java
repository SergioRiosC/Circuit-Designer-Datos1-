package Grafica;
/**
 * Clase que contiene la logica de las compuertas.
 * @author SergioRios
 *
 */
public class Logica {
	/**
	 * Funcion que permite conocer y asociar entradas con compuertas.
	 * @param Operas Lista que contiene las entradas y el nombre de las compuertas a utilizar.
	 * @param resultados Lista final que contendra los resultados de las operaciones.
	 */
	public void operaciones(Listas[] Operas, Listas[] resultados) {
		int c=0;
		int c2=1;
		int r=0;
		int contResu=0;
		
		while(c<Operas.length) {
			if(Operas[c]==null) {}
			else if(Operas[c].operacion=="NOT") {
				
				r=NOT( Operas[c].i);
				resultados[contResu]=new Listas(r);
				contResu++;
			}
			else {
				while( c2<Operas.length) {
					if(Operas[c2]==null) {}
					
					else if(Operas[c2].operacion=="NOT") {
						r=NOT(Operas[c2].i);
						resultados[contResu]=new Listas(r);
						System.out.println(resultados[contResu]);
						contResu++;
					}
					else if(Operas[c].operacion==Operas[c2].operacion) {
						r=recib(Operas[c].operacion, Operas[c].i ,Operas[c2].i );
						System.out.println(r);
						resultados[contResu]=new Listas(r);
						contResu++;
					}
					c2++;
				}
			}
				c++;
				c2=c+1;	
		}	
	}	
	/**
	 * Funcion que reconoce la operacion a realizar y mediante un bucle Switch Case, evalua entre todas las compuertas. 
	 * @param nombre Nombre de la compuerta.
	 * @param i Primer valor de  entrada.
	 * @param o Segundo valor de entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public static int recib(String nombre, int i, int o) {
		int r=0;
		switch(nombre) {
		case("AND"):
			System.out.println("and");
			r= AND(i,o);
			break;
		case("OR"):
			System.out.println("OR");
			r=OR(i,o);
			break;
		case("NAND"):
			System.out.println("nand");
			r=NAND(i,o);
			break;
		case("NOR"):
			System.out.println("nor");
			r=NOR(i,o);
			break;
		case("XOR"):
			System.out.println("xor");
			r=XOR(i,o);
			break;
		case("XNOT"):
			System.out.println("xnot");
			r=XNOT(i,o);
			break;
		}
		return r;
	}
	/**
	 * Compuerta AND.
	 * Ambas entradas en 1 para salida 1
	 * @param i Primer valor de  entrada.
	 * @param o Segundo valor de entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public static int AND(int i, int o) {
		int r=0;
		if(i==1&&o==1) {
			r=1;
		}
		return r;
	}
	/**
	 * Compuerta OR.
	 * Alguna entrada en 1 para salida 1
	 * @param i Primer valor de  entrada.
	 * @param o Segundo valor de entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public static int OR(int i,int o) {
		int r=0;
		if(i==1||o==1) {
			r=1;
		}
		return r;
	}
	/**
	 * Compuerta NOT.
	 * Contradice el valor de entrada.
	 * @param i Unico valor de  entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public  static int NOT(int i) {
		int r=0;
		if(i==0) {
			r= 1;
		}
		return r;
	}
	/**
	 *Compuerta NAND.
	 * Negacion de la compuerta AND.
	 * @param i Primer valor de  entrada.
	 * @param o Segundo valor de entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public static int NAND(int i,int o) {
		int r=1;
		if(AND(i,o)==1) {
			r=0;
		}
		return r;
	}
	/**
	 * Compuerta NOR.
	 * Ambas entradas en 0 para salida 1.
	 * @param i Primer valor de  entrada.
	 * @param o Segundo valor de entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public static int NOR(int i,int o) {
		int r=1;
		if(i==1||o==1) {
			r=0;
		}
		return r;
	}
	/**
	 * Compuerta XOR.
	 * Entrardas diferentes para salida 1.
	 * @param i Primer valor de  entrada.
	 * @param o Segundo valor de entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public static int XOR(int i,int o) {
		int r=1;
		if(i==o) {
			r=0;
		}
		return r;
	}
	/**
	 * Compuerta XNOT.
	 * Negacion de la compuerta XOR
	 * @param i Primer valor de  entrada.
	 * @param o Segundo valor de entrada.
	 * @return Resultado de la operacion realizada.
	 */
	public static int XNOT(int i,int o) {
		int r=0;
		if(XOR(i,o)==0) {
			r=1;
		}
		return r;
	}
}
