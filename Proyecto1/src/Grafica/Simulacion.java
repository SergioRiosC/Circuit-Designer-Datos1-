package Grafica;

import java.awt.Rectangle;

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
	public Simulacion() {
		
	}
	public  int recib(Listas[] lin, Listas[] Parejas, Listas[] Entradas) {
		this.lineas=lin;
		this.pares=Parejas;
		this.Entra=Entradas;
		
		while(contLin<lin.length) {
			if(lin[contLin]==null) {}
			else {
				while(contPareja<Parejas.length){
					if(Parejas[contPareja]==null) {}
					else if(Parejas[contPareja].pos.contains(lin[contLin].getX2(),lin[contLin].getY2())) {
						
						//System.out.println(Parejas[contPareja].nombre+" esta");
						
						int ENT=Integer.parseInt(Entradas[contEnt].getTf().getSelectedItem().toString() );
						String N=Parejas[contPareja].nombre;
						//System.out.println("sale "+N);
						
						Operas[contOp]=new Listas(N,ENT );
						//System.out.println("llega "+Operas[contOp].operacion);
						
						contOp++;
						contEnt++;	
					}
					else {
						System.out.println("no esta");
					}
					contPareja++;
				}
				
			}
			contPareja=0;
			contLin++;
		}
		return mandar(Operas);
	}
	public static int mandar(Listas[] Operas) {
		return log.operaciones(Operas);
	}
	
	
}