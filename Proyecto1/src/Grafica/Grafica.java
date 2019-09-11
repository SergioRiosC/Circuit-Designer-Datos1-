package Grafica;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	
	objeto AND =new objeto("C:\\\\Users\\\\xpc\\\\Desktop\\\\AND.jpg");
	objeto NAND=new objeto("C:\\\\Users\\\\xpc\\\\Desktop\\\\NAND.jpg");
	objeto OR=new objeto("C:\\\\Users\\\\xpc\\\\Desktop\\\\OR.jpg");
	objeto NOT=new objeto("C:\\\\Users\\\\xpc\\\\Desktop\\\\NOT.jpg");
	objeto NOR=new objeto("C:\\\\Users\\\\xpc\\\\Desktop\\\\NOR.jpg");
	objeto XOR=new objeto("C:\\\\Users\\\\xpc\\\\Desktop\\\\XOR.jpg");
	objeto XNOR=new objeto("C:\\\\Users\\\\xpc\\\\Desktop\\\\XNOR.jpg");
	
	int cont=0;
	Listas[] Entradas=new Listas[100];
	
	public Ven() {
		setBounds(0, 0, 1300, 725);
		setTitle("Circuit Designer");

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		
		AND.setBounds(1150,10,100,100);
		NAND.setBounds(1150,100,100,100);
		OR.setBounds(1150,190,100,100);
		NOT.setBounds(1150,280,100,100);
		NOR.setBounds(1150,370,100,100);
		XOR.setBounds(1150,460,100,100);
		XNOR.setBounds(1150,550,100,100);
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
				cont++;
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
		this.V2=V2;
		this.P2=P2;
		V2.setBounds(400,225,500,200);
		V2.setTitle("Resultado");
		P2.setBackground(Color.DARK_GRAY);
		P2.setLayout(null);
		V2.setVisible(true);
		V2.add(P2);		
	}
	
	public void Entradas()  {
		mouse  tf=new mouse();
		tf.setBounds(10,10,40,30);
		tf.setBackground(Color.white);
		panel.add(tf);
		tf.addItem("0");
		tf.addItem("1");
		tf.setSelectedIndex(0);
		tf.setVisible(true);
		panel.repaint();	
}
	
	 class mouse extends JComboBox implements  MouseMotionListener, ItemListener{
		public mouse(){
			JComboBox tf=new JComboBox();
			Entradas[cont]=new Listas(tf);
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
	

class objeto extends JLabel implements MouseMotionListener{
	public objeto(String ubic) {
		ImageIcon nom= new ImageIcon(ubic);
		setIcon(nom);
		addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {	
		
		setLocation(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2 );
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {		
	}
}
class LinePanel extends JPanel {
	Listas linea;
	Listas[] lin=new Listas[100];
	int cont=0;
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
        
       for(int i=0;i<cont;i++) {
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
	            lin[cont]=linea;
	            cont++;
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
