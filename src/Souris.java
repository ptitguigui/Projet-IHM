import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Souris implements MouseListener{

	Canvas c;
	CanvasRect cr;
	
	public void mouseClicked(MouseEvent e) {
		c.changerCouleur(e.getX(),e.getY());

		
	}

	public void addCanva(Canvas c){
		this.c = c;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}