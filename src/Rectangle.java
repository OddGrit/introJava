import java.awt.Graphics;

import javax.swing.JComponent;

public class Rectangle extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(x, y, width, height);
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
