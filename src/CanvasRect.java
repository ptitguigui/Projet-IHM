
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
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		
		/*for(Rectangle rec: list){
			g.setColor(Color.ORANGE);
			g.fillRect(rec.x, rec.y, w , h);
			g.setColor(Color.BLACK);
			g.drawRect(rec.x, rec.y, w,h);
		}*/
		
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
	
	public void mettreCouleur(Canvas c){
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
	
}
