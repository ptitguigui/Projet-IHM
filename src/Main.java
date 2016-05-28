import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main {

	Main(){
		
		JFrame f1 = new JFrame("projet");		
		Canvas c1 = new Canvas("c1");
		Canvas c2 = new Canvas("c2");	
		JPanel p2 = new JPanel();
		JPanel p1 = new JPanel();	
		JPanel l1 = new JPanel();
		Souris s1 = new Souris();
		CanvasRect cr1 = new CanvasRect();
		JOptionPane d = new JOptionPane();
		
		
		/**
		 * choisir le nombre de couleur que l'on veut
		 */
		
		String [] possibilites = new String[]{"2","3","4","5","6","7","8","9","10"};
		String s =(String)d.showInputDialog(d, " Choisissez le nombre nombre de couleurs :","Couleur",JOptionPane.QUESTION_MESSAGE,null,possibilites,possibilites[0]);
		int choix = Integer.parseInt(s);
		
		f1.getContentPane().setLayout(new GridLayout(1,3));			
		Canvas.setLargeurFenetre(600);	// positionne les diagrammes	
						
		
		/**
		 * défini la taille des canvas
		 * indispensable pour mettre dans le panel
		 */
		
		c1.setPreferredSize(new Dimension(430,1000));		
		c2.setPreferredSize(new Dimension(430,1000));

									
		c1.largeurRectangle(choix,1310);
		c1.remplirListeCouleur();
		c1.creerNombreRectangle();	
		c1.repainte();
		p1.add(c1);	
		
		c2.largeurRectangle(choix,1310);			
		c2.repainte();
		p2.add(c2);
		
		
		/**
		 * Met les carrés de couleur au milieu
		 */
		cr1.mettreCouleur(c1);
		cr1.setH(45);
		cr1.setW(45);
		
		
		cr1.setPosition(120,200);
		cr1.setPosition(280,200);
		cr1.setPosition(120,280);
		cr1.setPosition(280,280);
		cr1.setPosition(120,360);
		cr1.setPosition(280,360);
		cr1.setPosition(120,440);
		cr1.setPosition(280,440);
		cr1.setPosition(120,520);
		cr1.setPosition(280,520);
		
		c1.addMouseListener(s1);
		s1.addCanva(c1);
		
		

		cr1.setPreferredSize(new Dimension(430,1000));
		l1.add(cr1);
		
		
		f1.getContentPane().add(p1);
		f1.getContentPane().add(l1);
		f1.getContentPane().add(p2);

		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);		
		f1.setPreferredSize(new Dimension(1310,780));
		f1.setLocation(150,100);
		f1.pack();
		f1.setVisible(true);
	}
		
		public static void main(String args[]){
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new Main();
				}
			});
		}
	}