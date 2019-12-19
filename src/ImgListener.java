import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ImgListener implements MouseListener, MouseMotionListener{
	private ImagePanel img;
	private int startX;
	private int startY;
	
	public ImgListener(ImagePanel img){
		this.img = img;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		img.setRect(null); //Remove the rectangle
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
	public void mousePressed(MouseEvent e) {
		//Set where first pressed
		startX = e.getX();
		startY = e.getY();
		Rectangle r = new Rectangle(startX, startY, 1, 1);
		img.setRect(r);
		}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = startX;
		int y = startY;
		int w = e.getX() - startX; 
		int h = e.getY() - startY;
		if (w < 0) { //in case of going left from start
			w *= -1;
			x -= w;
		}
		if (h < 0) { //in case of going higher than start 
			h *= -1;
			y -= h;
		}
		
		img.setRect(new Rectangle(x, y, w, h));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
}
