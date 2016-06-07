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
	private CanvasRect cr1;
	
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
			list.add(new Rectangle(x,largeurFenetre-h,w,h)); // changer y en variable par la suite
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
	

	/**
	 * détermine la largeur des rectangles
	 * permet de calculer pour mettre un espace entre les rectangles
	 */
	public void largeurRectangle(int n, double largeur){ 
				
		nombreRectangle =n ;
		this.w =(int) (((largeur-100)/3.0)-(3*n)-1) / n;

	}
	
	
	public static void setLargeurFenetre(int n){
		largeurFenetre = n;// détermine la largeur du panel
	}
	

	public int getH(){
		return h;
	}
	
	
	public int getW(){
		return w;
	}

	
	public void remplirListeCouleur(){
		int rouge = 0;
		int vert = 0;
		int bleu = 0;
		int gris = 0;
		int cpt = 0;
		ArrayList<Integer> nuanceGris = new ArrayList<>();
		boolean trouve = false;
		
		nuanceGris.add(0);
		nuanceGris.add(255);
		for(int i=0 ; i<nombreRectangle; i++){
			while(!trouve){
				rouge = r.nextInt(256);
				vert = r.nextInt(256);
				bleu = r.nextInt(256);
				gris =  (int) (0.3*rouge + 0.59*vert + 0.11*bleu);
				
				for(int j = 0; j<nuanceGris.size(); j++){
					if(nombreRectangle>6){
						if((gris-nuanceGris.get(j) < -15 && nuanceGris.get(j)-gris >15) || (gris - nuanceGris.get(j)>15 && nuanceGris.get(j) - gris <-15)){
							cpt++;
						}
					}else{
						if((gris-nuanceGris.get(j) < -25 && nuanceGris.get(j)-gris >25) || (gris - nuanceGris.get(j)>25 && nuanceGris.get(j) - gris <-25)){
							cpt++;
						}
					}
				}
				if(cpt==nuanceGris.size())
					trouve = true;	
				else
					cpt = 0;
			}
			nuanceGris.add(gris);
			trouve = false;
			cpt =0;
			listeCouleur.add(new Color(rouge,vert,bleu));
		}
	}
	

	
	public void changerCouleur2(Color c, int i){
		listeCouleur.set(i, c);
		repaint();
		
		
	}
	

	public void addCanvasRectToCanvas(CanvasRect cr1){
		this.cr1 = cr1;
	}
}
