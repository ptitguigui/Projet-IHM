import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Main {
	
	JFrame f1 = new JFrame("projet");
	Canvas c1 = new Canvas("c1");
	Canvas c2 = new Canvas("c2");
	JPanel p2 = new JPanel();
	JPanel p1 = new JPanel();	
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	Souris s1 = new Souris();
	JLabel l1 = new JLabel("yo");
	CanvasRect cr1 = new CanvasRect(c1,c2);
	JColorChooser chooser = new JColorChooser();
	ColorSelectionModel model = chooser.getSelectionModel();
	
	
	Main(){
	
		JOptionPane d = new JOptionPane();
	
		
		/**
		 * choisir le nombre de couleur que l'on veut
		 */
		int choix=0;
		try{
			String [] possibilites = new String[]{"2","3","4","5","6","7","8","9","10"};
			String s =(String)d.showInputDialog(d, " Choisissez le nombre nombre de couleurs :","Couleur",JOptionPane.QUESTION_MESSAGE,null,possibilites,possibilites[0]);
			choix = Integer.parseInt(s);
		}catch(Exception e){
			
		}
		
		
		//f1.getContentPane().setLayout(new GridLayout(1,3));			
		Canvas.setLargeurFenetre(400);	// positionne les diagrammes	
						
		
		/**
		 * défini la taille des canvas
		 * indispensable pour mettre dans le panel
		 */
		
		
		c1.setPreferredSize(new Dimension(430,800));		
		c2.setPreferredSize(new Dimension(430,800));
		

									
		c1.largeurRectangle(choix,1310);
		c1.remplirListeCouleur();
		c1.creerNombreRectangle();	
		c1.repainte();
		p1.add(c1);	
		l1.setLocation(200,250);
		l1.setBackground(Color.WHITE);
		p1.add(l1);

		c2.largeurRectangle(choix,1310);			
		c2.repainte();
		p2.add(c2);
		
		
		/**
		 * Met les carrés de couleur au milieu
		 */
		cr1.mettreCouleur();
		cr1.setH(45);
		cr1.setW(45);
	
		
		
		cr1.setPosition(120,70);
		cr1.setPosition(280,70);
		cr1.setPosition(120,150);
		cr1.setPosition(280,150);
		cr1.setPosition(120,230);
		cr1.setPosition(280,230);
		cr1.setPosition(120,310);
		cr1.setPosition(280,310);
		cr1.setPosition(120,390);
		cr1.setPosition(280,390);
		
	
		
		c1.addCanvasRectToCanvas(cr1);
		c1.addMouseListener(s1);
		cr1.addMouseListener(s1);
		s1.addCanvasRect(cr1);
		
				

		p4.add(chooser);
		p4.setBackground(Color.WHITE);
		
		
		model.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				c1.changerCouleur2(chooser.getColor(),cr1.i);
				c2.changerCouleur2(chooser.getColor(), cr1.i);
				cr1.mettreAJourCouleur(chooser.getColor(), cr1.i);
			}
		}) ;
		
		
		

		cr1.setPreferredSize(new Dimension(430,1000));
		p3.add(cr1, BorderLayout.CENTER);
		
		
		
		f1.getContentPane().add(p1, BorderLayout.WEST);
		f1.getContentPane().add(p3,BorderLayout.CENTER);
		f1.getContentPane().add(p2,BorderLayout.EAST);
		f1.getContentPane().add(p4,BorderLayout.NORTH);

		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);		
		f1.setPreferredSize(new Dimension(1310,780));
		f1.setLocation(150,100);
		f1.pack();
		f1.setVisible(true);
	}
		
		
	public static void main(String args[]){
		Main m = new Main();
		m.chooser.setPreviewPanel(new JPanel());
	}
	}
