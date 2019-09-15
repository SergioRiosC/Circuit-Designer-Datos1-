package Grafica;
public class Logica {
	public int operaciones(Listas[] Operas) {
		int c=0;
		int c2=1;
		int r=0;
		boolean b=true;
		while(c<Operas.length) {
			if(Operas[c].operacion==null) {}
			else {
			while( c2<Operas.length) {
				if(Operas[c2].operacion==null) {}
				else if(Operas[c].operacion==Operas[c2].operacion) {
					r=recib(Operas[c].operacion, Operas[c].i ,Operas[c2].i );
					b=false;
					break;
				}
				c2++;
			}
			}
			if(b==false) {
				break;
			}else {
			c++;
			}
		}	
		return r;
	}	
	public static int recib(String nombre, int i, int o) {
		int r=0;
		switch(nombre) {
		case("AND"):
			System.out.println("and");
			r= AND(i,o);
			break;
		case("OR"):
			r=OR(i,o);
		/*case("NOT"):
			System.out.println("not");
			r=NOT(i,o);*/
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
	public static int AND(int i, int o) {
		int r=0;
		if(i==1&&o==1) {
			r=1;
		}
		return r;
	}
	public static int OR(int i,int o) {
		int r=0;
		if(i==1||o==1) {
			r=1;
		}
		return r;
	}
	public  static int NOT(int i) {
		int r=0;
		if(i==0) {
			r= 1;
		}else {
			r=1;
		}
		return r;
	}
	public static int NAND(int i,int o) {
		int r=1;
		if(AND(i,o)==1) {
			r=0;
		}
		return r;
	}
	public static int NOR(int i,int o) {
		int r=1;
		if(i==1||o==1) {
			r=0;
		}
		return r;
	}
	public static int XOR(int i,int o) {
		int r=1;
		if(i==o) {
			r=0;
		}
		return r;
	}
	public static int XNOT(int i,int o) {
		int r=0;
		if(XOR(i,o)==0) {
			r=1;
		}
		return r;
	}
}
