package Grafica;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

/**
 * Clase que ejecuta la simulacion de circuitos.
 * Hereda de la clase ven.
 * @author SergioRios
 */
public class Simulacion extends Ven {
	Listas[] lineas;
	Listas[] pares;
	static Listas[] Operas=new Listas[50];
	Listas[] Entra;
	
	int contPareja=0;
	int contLin=0;
	int contOp=0;
	int contEnt=0;
	
	static Logica log =new Logica();
	/**
	 * Funcion que conecta las listas de lineas entradas y las coloca en una lista nueva. La lista es enviada a realizar las operaciones correspondientes
	 * @param lin Lista que contiene todas las lineas dibujadas.
	 * @param Parejas Lista con la pocision de las imagenes de las compuertas y sus nombres.
	 * @param Entradas Lista que contiene las entradas reque ridas para el circuito del usuario.
	 * @param resultados Lista que contendra los resultados de las operaciones.
	 */
	public  void recib(Listas[] lin, Listas[] Parejas, Listas[] Entradas , Listas[] resultados) {
		this.lineas=lin;
		this.pares=Parejas;
		this.Entra=Entradas;
		
		while(contLin<lin.length) {
			//System.out.println(lin[0].x1);
			//System.out.println(Parejas[contPareja].pos);
			if(lin[contLin]==null) {}
			
			else {
				while(contPareja<Parejas.length){
					if(Parejas[contPareja]==null) {}
				
					else if(Parejas[contPareja].pos.contains(lin[contLin].getX2(),lin[contLin].getY2())  ) {
						System.out.println("esta "+Parejas[contPareja].nombre);
						int ENT=Integer.parseInt(Entradas[contEnt].getTf().getSelectedItem().toString() );
						String N=Parejas[contPareja].nombre;
						//System.out.println("sale "+N);
						//System.out.println(lin[contLin]);
						Operas[contOp]=new Listas(N,ENT );
						//System.out.println("llega "+Operas[contOp].operacion);
						
						contOp++;
						contEnt++;	
						
					}
					else if(Parejas[contPareja].pos.contains(lin[contLin].getX1(),lin[contLin].getY1())) {
						System.out.println("simon no weon");
						int contRes=resultados.length-1;
						int ENT=0;
						String N="";
						while(contRes>=0) { 
							System.out.println("Buscando res ant");
							if(resultados[contRes]!=null) {
								System.out.println("res ant= "+resultados[contRes]);
								ENT=Integer.parseInt(resultados[contRes].toString());
								break;}
							contRes--;}
						int temp=contPareja;
						while(temp<Parejas.length) {
							System.out.println("buscando ope sig");
							if(Parejas[temp]==null) {}
							else if(Parejas[temp].pos.contains(lin[contLin].getX2(),lin[contLin].getY2())  ) {
								System.out.println("ope sig= "+Parejas[temp].nombre);
								N=Parejas[temp].nombre;	
								break;
							}
							temp++;
						}
						Operas[contOp]=new Listas(N,ENT );
					}
						
					
					else {
						System.out.println("no esta "+Parejas[contPareja].nombre);
					}
					contPareja++;
				}
				
			}
			contPareja=0;
			contLin++;
		}
		log.operaciones(Operas, resultados);
	}	
}