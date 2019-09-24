package Grafica;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 * Clase que almacena el metodo main
 * @author SergioRios
 *
 */

public class Grafica{
	/**
	 * Metodo principal del proyecto
	 * @param args
	 */
	public static void main(String[] args) {
		Ven v=new Ven();
		v.setVisible(true);
	}

}
/**
 * clase donde se almacena todo lo relacionado a la ventana principal del proyecto
 * @author SergioRios
 *
 */
class Ven extends JFrame{
	Image image;
	
	LinePanel panel=new LinePanel();
	JFrame V2=new JFrame();
	JPanel P2=new JPanel();
	
	JButton simular=new JButton("Simular");
	JButton entradas=new JButton("Agregar entradas");

	Listas linea;
	Listas[] lin=new Listas[50];
	int contLin=0;
	
	Listas[] Entradas=new Listas[50];
	int contEnt=0;
	
	Listas[] Parejas=new Listas[50];
	int contPar=0;
	
	Listas[] resultados=new Listas[50];
	
	objeto AND =new objeto("AND.jpg","AND");
	
	objeto NAND=new objeto("NAND.jpg","NAND");
	objeto OR=new objeto("OR.jpg","OR");
	objeto NOT=new objeto("NOT.jpg","NOT");
	objeto NOR=new objeto("NOR.jpg","NOR");
	objeto XOR=new objeto("XOR.jpg","XOR");
	objeto XNOR=new objeto("XNOR.jpg","XNOR");

	int y=10;
	/**
	 * Constructor de la calse, se configuran aspectos como el tamaño y posicion de la ventana y del panel en ella.
	 *  Tambien se colocan botones con sus respectivas funciones
	 */
	public Ven() {
		setBounds(0, 0, 1300, 725);
		setTitle("Circuit Designer");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		simular.setBounds(50,575,100,25);
		entradas.setBounds(180,575,160,25);

		
		simular.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				Simular(P2,V2);
			}
		});
		entradas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Entradas();
				contEnt=contEnt+1;
			}
		});
		panel.add(AND);
		panel.add(NAND);
		panel.add(OR);
		panel.add(NOT);
		panel.add(NOR);
		panel.add(XOR);
		panel.add(XNOR);
		panel.add(simular);
		panel.add(entradas);

		add(panel);
	}
		
	
	/**
	 * Funcion que simula el circuito establecido por el usuario
	 * @param P2 Panel de segunda ventana
	 * @param V2 Segunda ventana
	 */
	public void Simular(JPanel P2,JFrame V2) {
		int contRes=resultados.length-1;
		Simulacion S=new Simulacion();
		S.recib(lin,Parejas,Entradas,resultados);
		while(contRes>=0) { 
			System.out.println(resultados[contRes] +" "+contRes);
			if(resultados[contRes]!=null) {
				JOptionPane.showMessageDialog(null,"El resultado es: "+resultados[contRes].getRes());
				break;
			}
			contRes--;
		}
		/*this.V2=V2
		this.P2=P2;
		V2.setBounds(400,225,500,200);
		V2.setTitle("Resultado");
		P2.setBackground(Color.DARK_GRAY);
		P2.setLayout(null);
		V2.setVisible(true);
		V2.add(P2);	*/	
	}
	/**
	 * Funcion que agrega nuevas entradas al circuito del usuario
	 */
	public void Entradas()  {
		mouse  tf=new mouse();
		tf.setBounds(10,10,40,30);
		tf.setBackground(Color.white);
		panel.add(tf);
		tf.addItem("0");
		tf.addItem("1");
		tf.setSelectedIndex(1);
		Entradas[contEnt]=new Listas(tf);
		tf.setVisible(true);
		
		panel.repaint();
}
	
/**
 * Clase que agrega propiedades de mouse a las entradas del usuario
 * para poder ponerlas en cualquier lugar de la ventana.
 * @author SergioRios
 * 
 */
class mouse extends JComboBox implements  MouseMotionListener, ItemListener{
	/**
	 * Constructor: se crea el JComboBox de la entrada, ademas se le agregan las propiedaddes de mouse
	 */
		public mouse(){
			JComboBox tf=new JComboBox();
			tf.addItemListener(this);
			addMouseMotionListener(this);
			
		}
		/**
		 * @Override
		 * Permite establecer la locacion del JCombobox dependiendo de la localizacion actual del cursor del mouse
		 * 
		 **/
		@Override
		public void mouseDragged(MouseEvent e) {
			setLocation(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2 );	
		}
		@Override
		public void mouseMoved(MouseEvent e) {}
		@Override
		public void itemStateChanged(ItemEvent e) {}	
	}
	
/**
 * Clase que crea las imagenes de las compuertas logicas que el usuario utilizara para su circuito
 * @author SergioRios
 *
 */
class objeto extends JLabel implements MouseMotionListener, MouseListener{
	private Point p1= new Point();
    private Point p2 = new Point();
	String nombre;
	boolean b=false;
	boolean drawing;
	
	/**
	 * Constructor: Crea las imagenes y les agrega los MouseListener necesarios
	 * 
	 * @param ubic  La ubicacion de las imagenes en la carpera del proyecto.
	 * @param name  Nombre de la compuerta logica.
	 */
	public objeto(String ubic,String name)  {
	
		
		this.nombre=name;
		ImageIcon nom= new ImageIcon(ubic);
		setIcon(nom);
		
		setSize(100, 100);
		setLocation(1150,y);
		y=y+90;
		
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	/**
	 * Funcion que realiza las lineas de conexion dentro de las imagenes
	 * @param g Objeto del tipo Graphics a dibujar
	 */
	@Override
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.blue);
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
       
       
        g.drawLine(p1.x, p1.y, p2.x, p2.y);          
    }
	/**
	 * Funcion que se ejecuta cuando el mouse es arrastrado dentro de la imagen
	 * Si el click utilizado es el izquierdo, la imagen se movera, si es el derecho, se dibujara una linea
	 * @param e Objeto de mouse a procesar
	 */
	@Override
	public void mouseDragged(MouseEvent e) {	
		if(b) {
			setLocation(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2);	
		}
		if (drawing) {
			p2.x = e.getLocationOnScreen().x;
    		p2.y=e.getLocationOnScreen().y;
			linea.setX2(p2.x);
			linea.setY2(p2.y);
			repaint();	
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	/**
	 * Se ejecuta cuando el mouse es presionado.
	 * Si el boton el es izquierdo, la imagen empezara el movimiento, si es el derecho, la imagen empezara la linea
	 * @param e Objeto de mouse a procesar
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			b=true;
		}	
		if(e.getButton()==MouseEvent.BUTTON3) {
			
    		drawing = true;
    		p1.x = e.getLocationOnScreen().x;
    		p1.y=e.getLocationOnScreen().y;
    		linea=new Listas(p1.x,p1.y,p2.x,p2.y);
    		repaint();
    		
    	}
	}
	/**
	 * Se ejecuta cuando el click del mouse se deja de presionar
	 * Si el boton es el derecho, la linea dibujada se guardara en una lista
	 * @param e Objeto de mouse a procesar
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3) {
            drawing = false;
            p2.x = e.getLocationOnScreen().x;
    		p2.y=e.getLocationOnScreen().y;
            lin[contLin]=linea;
           
            contLin++;
            repaint();
		}else {
		this.setBounds(this.getX(),this.getY(), 100, 100);
		repaint();
		Parejas[contPar]=new Listas(nombre, this.getBounds());
		contPar++;
		b=false;
		
		
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}	
}

/**
 * Clase que crea el panel de la ventana principal y le agrega atributos como el dibujo de lineas en el.
 * @author SergioRios
 *
 */
class LinePanel extends JPanel {
	int contLin=0;
	private MouseHandler mouseHandler = new MouseHandler();
    private Point p1= new Point();
    private Point p2 = new Point();
    private boolean drawing;
    /**
     * Constructor: Agrega las propiedades de dibujo al panel
     */
    public LinePanel() {
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        
    }
    /**
     * Funcion para dibujar las lineas en el panel.
     * @param g Objeto Graphics a dibujar
     */
    @Override
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        
       for(int i=0;i<contLin;i++) {
    	   lin[i].dibujar(g);
       }       
        g.drawLine(p1.x, p1.y, p2.x, p2.y);          
    }
    
    /**
     * Clase que modifica los eventos del mouse.
     * Hereda de MouseAdapter.
     * @author SergioRios
     *
     */
    private class MouseHandler extends MouseAdapter {
    	/**
    	 * Cuando el boton derecho del mouse es presionado, inicia el dibujo de la linea
    	 * @param e Objeto de mouse a procesar
    	 */
        public void mousePressed(MouseEvent e) {
        	
        	
        	
        	if(e.getButton()==MouseEvent.BUTTON3) {
        		drawing = true;
        		p1 = e.getPoint();
        		linea=new Listas(p1.x,p1.y,p2.x,p2.y);
        		repaint();
        	}
        }
        /**
         * Cuando el boton derecho se deja de presionar, termina el proceso de dibujo y se guarda en una lista la linea dibujada
         * @param e Objeto de mouse a procesar
         */
        public  void mouseReleased(MouseEvent e) {
        	if(e.getButton()==MouseEvent.BUTTON3) {
	            drawing = false;
	            p2 = e.getPoint();
	            lin[contLin]=linea;
	            contLin++;
	            repaint();
        	}
        }    
        /**
         * Cuando el boton derecho es presionado u=y el mouse arrastrado, se dibuja una linea conforme se mueva el mouse
         * @param e Objeto de mouse a procesar
         */
        public void mouseDragged(MouseEvent e) {
        		if (drawing) {
        			p2 = e.getPoint();
        			linea.setX2(p2.x);
        			linea.setY2(p2.y);
        			repaint();	
        		}
        } 
        
      }
	}
}