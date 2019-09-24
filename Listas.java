package Grafica;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JComboBox;
/**
 * Clase que crea las listas necesarias para el almacenamiento de diferentes datos.
 * @author SergioRios
 */
public class Listas {
	int x1;
	int y1;
	int x2;
	int y2;
	int cont=0;
	int i;
	int res;
	JComboBox tf;
	
	String nombre;
	String operacion;
	
	Rectangle pos;
	/**
	 * Constructor de la lista utilizada para las lineas.
	 * @param x1 Coordenada x1 de la linea.
	 * @param y1 Coordenada y1 de la linea.
	 * @param x2 Coordenada x2 de la linea.
	 * @param y2 Coordenada y2 de la linea.
	 */
	public Listas(int x1, int y1, int x2, int y2) {   //Lineas
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	/**
	 * Getter del x1 de Lineas
	 * @return coordenada x1 de la linea.
	 */
	public int getX1() {
		return x1;
	}
	/**
	 * Setter del x1 de la linea
	 * @param x1 Nueva coordenada x1 de la linea.
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}
	/**
	 * Getter del y1 de Lineas
	 * @return coordenada y1 de la linea.
	 */
	public int getY1() {
		return y1;
	}
	/**
	 * Setter del y1 de la linea
	 * @param y1 Nueva coordenada y1 de la linea.
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}
	/**
	 * Getter del x2 de Lineas
	 * @return coordenada x2 de la linea.
	 */
	public int getX2() {
		return x2;
	}
	/**
	 * Getter del y2 de Lineas
	 * @return coordenada y2 de la linea.
	 */
	public int getY2() {
		return y2;
	}
	/**
	 * Setter del x2 de la linea
	 * @param x2 Nueva coordenada x2 de la linea.
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}
	/**
	 * Setter del y2 de la linea
	 * @param y2 Nueva coordenada y2 de la linea.
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}
	/**
	 * Funcion para dibujar lineas.
	 * @param g Objeto Graphics a dibujar.
	 */
	public void dibujar(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
	}
	/*
	 * Constructor de la lista para las entradas.
	 */
	public Listas(JComboBox tf) {//Entradas
		this.tf=tf;
	}
	/**
	 * Getter de la entrada JComboBox
	 * @return Entrada JComboBox de la lista
	 */
	public JComboBox getTf() {
		return tf;
	}
	/**
	 * Constructor de lista usada para la posicion de la imagen de la compuerta y su nombre
	 * @param nombre Nombre de la compuerta.
	 * @param pos Posicion de la imagen.
	 */
	public Listas(String nombre, Rectangle pos) {//Parejas
		this.nombre=nombre;
		this.pos=pos;
	}
	/**
	 * Constructor de lista usada para guardar el int de una entrada y su operacion
	 * @param operacion Nombre de operacion.
	 * @param i int de la entrada 
	 */
	public Listas(String operacion, int i) {//Operas
		this.operacion=operacion;
		this.i=i;
	}
	/**
	 * Constructor de lista usada para almacenar los resultados de las operaciones realizadas.
	 * @param res Resultados de operaciones.
	 */
	public Listas(int res) { //Resultados
		this.res=res;
	}
	/**
	 * Getter de los resultados.
	 * @return resultado.
	 */
	public int getRes() {
		return res;
	}
}
