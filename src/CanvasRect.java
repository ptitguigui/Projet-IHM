
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CanvasRect extends JPanel{
	private Vector<Rectangle> list = new Vector<>();
	private ArrayList<Color> listeCouleur = new ArrayList<>();
	private int x,y,w,h;
	int i;
	int numeroCarreSelectionnePourGrossirLaBordure;
	Canvas c;
	Canvas c2;
	
	JColorChooser chooser = new JColorChooser();
	ColorSelectionModel model = chooser.getSelectionModel();
	
	CanvasRect(Canvas c, Canvas c2){
		this.c = c;
		this.c2 = c2;
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		
		for(int i=0 ; i<listeCouleur.size(); i++){
			g.setColor(listeCouleur.get(i));
			g.fillRect(list.get(i).x, list.get(i).y, list.get(i).width, list.get(i).height);
			g.setColor(Color.BLACK);
			if(numeroCarreSelectionnePourGrossirLaBordure == i){
				Graphics2D g2 = (Graphics2D)g;
				Stroke s = g2.getStroke();
				g2.setStroke(new BasicStroke(6));
				g2.drawRect(list.get(i).x, list.get(i).y, list.get(i).width, list.get(i).height);
				g2.setStroke(s);
				
				
				
			}
			else
				g.drawRect(list.get(i).x, list.get(i).y, list.get(i).width, list.get(i).height);		
		}
	}
	public void setPosition(int x, int y){
		this.x=x;
		this.y=y;
		list.add(new Rectangle(x,y,w,h));
		repaint();
	}
	
	public void setH(int n){
		this.h = n;
	}
	
	public void setW(int n){
		this.w = n;
	}
	
	public void mettreCouleur(){		
		for(Color c1 : c.listeCouleur ){
			this.listeCouleur.add(c1);
		}
	}

	public void remove(int x, int y){
		for(int i=0; i<list.size();i++){
			if(list.get(i).contains(x, y))
				list.remove(i);				
			
		}
		repaint();
	}
	
	public void setCoordonnees(int x, int y){
		for(int i=list.size()-1;i>=0;i--){
			if(list.get(i).contains(x, y)){
				list.get(i).x=x-w/2;
				list.get(i).y=y-h/2;
				repaint();
				break;
			}
		}
	}
	
	public void changerCouleur1(int x2, int y2) {
		for( int j=0; j<list.size();j++){
			if(list.get(j).contains(x2, y2)){
				numeroCarreSelectionnePourGrossirLaBordure = j;
				this.i = j;
				
			}	
		}
		repaint();		
	}
	public Color getCouleur(int i){
		return listeCouleur.get(i);
	}

	// change la couleur du petit carré quand une couleur est selectionner sur le ChooserColor
	public void mettreAJourCouleur(Color c, int i){		
		listeCouleur.set(i,c);	
		repaint();
	}
	
	
}
