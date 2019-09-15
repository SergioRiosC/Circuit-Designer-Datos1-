package Grafica;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
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

public class Grafica{
	
	public static void main(String[] args) {
		Ven v=new Ven();
		v.setVisible(true);
	}

}
class Ven extends JFrame{
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
	
	objeto AND =new objeto("AND.jpg","AND");
	objeto NAND=new objeto("NAND.jpg","NAND");
	objeto OR=new objeto("OR.jpg","OR");
	objeto NOT=new objeto("NOT.jpg","NOT");
	objeto NOR=new objeto("NOR.jpg","NOR");
	objeto XOR=new objeto("XOR.jpg","XOR");
	objeto XNOR=new objeto("XNOR.jpg","XNOT");
	
	
	
	
	int y=10;
	
	
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
	
	public void Simular(JPanel P2,JFrame V2) {
		Simulacion S=new Simulacion();
		//System.out.println();	
		JOptionPane.showMessageDialog(null,"El resultado es: "+S.recib(lin,Parejas,Entradas) );
		/*this.V2=V2;
		this.P2=P2;
		V2.setBounds(400,225,500,200);
		V2.setTitle("Resultado");
		P2.setBackground(Color.DARK_GRAY);
		P2.setLayout(null);
		V2.setVisible(true);
		V2.add(P2);	*/	
	}
	
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
	
class mouse extends JComboBox implements  MouseMotionListener, ItemListener{
		public mouse(){
			
			JComboBox tf=new JComboBox();
			
			
			tf.addItemListener(this);
			addMouseMotionListener(this);
			
		}
		public Listas[] getEntradas() {
			return Entradas;
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			
			setLocation(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2 );	
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {}
		@Override
		public void itemStateChanged(ItemEvent e) {}	
	}
	

class objeto extends JLabel implements MouseMotionListener, MouseListener{
	
	String nombre;
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
	@Override
	public void mouseDragged(MouseEvent e) {	
		//setBounds(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2, 150, 100);
		setLocation(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2 );	
		
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		 
		this.setBounds(this.getX(),this.getY(), 100, 100);
		repaint();
		
		//Simulacion.recib(this.getBounds(),nombre);
		Parejas[contPar]=new Listas(nombre, this.getBounds());
		//System.out.println(Parejas[contPar]);
		contPar++;
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}



class LinePanel extends JPanel {
	int contLin=0;
	private MouseHandler mouseHandler = new MouseHandler();
    private Point p1= new Point(0,0);
    private Point p2 = new Point(0,0);
    private boolean drawing;
    
    public LinePanel() {
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        
    }
    public Listas[] getLin() {
    	return lin;
    }
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
    
    private class MouseHandler extends MouseAdapter {
    	   	   	
        public void mousePressed(MouseEvent e) {
        	if(e.getButton()==MouseEvent.BUTTON3) {
        		drawing = true;
        		p1 = e.getPoint();
        		linea=new Listas(p1.x,p1.y,p2.x,p2.y);
        		repaint();
        	}
        }
        
        public  void mouseReleased(MouseEvent e) {
        	if(e.getButton()==MouseEvent.BUTTON3) {
	            drawing = false;
	            p2 = e.getPoint();
	            lin[contLin]=linea;
	            contLin++;
	            repaint();
	            p1.x=0;
	            p1.y=0;
	            p2.x=0;
            	p2.y=0;
        	}
        }       
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
