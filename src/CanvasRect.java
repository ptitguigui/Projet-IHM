
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

public class CanvasRect extends JPanel{
	private Vector<Rectangle> list = new Vector<>();
	private ArrayList<Color> listeCouleur = new ArrayList<>();
	private int x,y,w,h;
	Canvas c;
	
	CanvasRect(Canvas c){
		this.c = c;
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		
		for(int i=0 ; i<listeCouleur.size(); i++){
			g.setColor(listeCouleur.get(i));
			g.fillRect(list.get(i).x, list.get(i).y, list.get(i).width, list.get(i).height);
			g.setColor(Color.BLACK);
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
	
	public void changerCouleur(int x2, int y2) {
		for(int i=0; i<list.size();i++){
			if(list.get(i).contains(x2, y2)){
				listeCouleur.set(i,new Color(0,0,0));
				c.changerCouleur(listeCouleur.get(i),i );
			}	
		}
		repaint();
		
	}
	
}
