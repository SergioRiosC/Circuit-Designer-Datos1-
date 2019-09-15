package Grafica;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComboBox;

public class Listas {
	int x1;
	int y1;
	int x2;
	int y2;
	int cont=0;
	int i;
	JComboBox tf;
	
	String nombre;
	String operacion;
	
	Rectangle pos;
	
	public Listas(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public int getY2() {
		return y2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void dibujar(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
	}
	public Listas(JComboBox tf) {
		this.tf=tf;
	}
	public JComboBox getTf() {
		return tf;
	}
	
	public Listas(String nombre, Rectangle pos) {//Parejas
		this.nombre=nombre;
		this.pos=pos;
	}
	public Listas(String operacion, int i) {//Operas
		this.operacion=operacion;
		this.i=i;
		//this.o=o;
		
	}

}
