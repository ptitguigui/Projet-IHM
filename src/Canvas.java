import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	Random r = new Random();
	static Vector<Rectangle> list = new Vector<>();
	static ArrayList<Color> listeCouleur = new ArrayList<>();
	private int x=15,y,w,h;
	private static int largeurFenetre,nombreRectangle;
	private String name;
	
	Canvas(String name){
		this.name = name;
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		Color couleur;
				
		if(this.name.equals("c1")){
			for(int i=0; i<list.size();i++){
				couleur = listeCouleur.get(i);
				//g.setColor(Color.ORANGE);
				g.setColor(couleur);
				g.fillRect(list.get(i).x, list.get(i).y, list.get(i).width , list.get(i).height);
				g.setColor(Color.BLACK);
				g.drawRect(list.get(i).x, list.get(i).y, list.get(i).width , list.get(i).height);
			}
		}
		else {
			for(int i=0; i<list.size();i++){
				int x = (int)(listeCouleur.get(i).getRed()*0.3)+(int)(listeCouleur.get(i).getGreen()*0.59)+(int)(listeCouleur.get(i).getBlue()*0.11);
				couleur = new Color(x,x,x);
				g.setColor(couleur);
				g.fillRect(list.get(i).x, list.get(i).y, list.get(i).width , list.get(i).height);
				g.setColor(Color.BLACK);
				g.drawRect(list.get(i).x, list.get(i).y, list.get(i).width , list.get(i).height);
			}
		}
	}

	
	
	
	
	public void creerNombreRectangle(){
		for(int i=0; i<nombreRectangle;i++){
			setH();
			list.add(new Rectangle(x,largeurFenetre-h,w,h)); // changer y en variable par la suite salut
			x += w+3;			
		}
		//repaint();
	}
	
	
	public void repainte(){
		
		repaint();
	}
	
	
	public void setH(){
		this.h = r.nextInt(180)+150;
	}
	
	public void largeurRectangle(int n, double largeur){
		nombreRectangle =n ;
		this.w =(int) (((largeur-100)/3.0)-(3*n)-1) / n;

	}
	
	public static void setLargeurFenetre(int n){
		largeurFenetre = n;
	}
	

	public int getH(){
		return h;
	}
	
	public int getW(){
		return w;
	}

	public int getLargeurFenetre(){
		return largeurFenetre;
	}

	public void remplirListeCouleur(){
		
		for(int i=0 ; i<nombreRectangle ; i++){
			listeCouleur.add(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		}				
	}

	public void changerCouleur(int x2, int y2) {
		for(int i=0; i<list.size();i++){
			if(list.get(i).contains(x2, y2))
				listeCouleur.set(i,new Color(0,0,0));			
			
		}
		repaint();
		
	}

}
