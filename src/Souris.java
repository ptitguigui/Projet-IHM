import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Souris implements MouseListener{

	Canvas c1 = new Canvas ("c1");
	Canvas c2 = new Canvas ("c2");
	CanvasRect cr;
	
	
	public void mouseClicked(MouseEvent e) {	
		cr.changerCouleur1(e.getX(),e.getY());		
		
	}


	public void addCanvasRect(CanvasRect cr){
		this.cr = cr;
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
