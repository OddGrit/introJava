import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class ImagePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	private Rectangle rect;
	
	public ImagePanel(String path){
		setImage(path);
	}
	
	public ImagePanel() {
		super();
		image = null;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage img) {
		image = img;
		setSize(image.getWidth(), image.getHeight());
		repaint();
		
	}
	
	public void setImage(String path) {
		try {
			setImage(ImageIO.read(new File(path)));
		} catch (IOException e){ // Cannot open the file
			JOptionPane.showMessageDialog(null,  "Could not open the file.");
		} catch (NullPointerException e) { // Cannot convert to BufferedImage
			JOptionPane.showMessageDialog(null, "Wrong file type");
		}
	}
	
	public Rectangle getRect() { //Get Rekt!
		return rect;
	}
	
	public void setRect(Rectangle r) {
		rect = r;
		repaint();
	}
	
	public void resize(double factor) {
		BufferedImage img = image;
		Dimension d = getSize();
		
		setImage(new BufferedImage((int)(d.getWidth() * factor), (int)(d.getHeight() * factor), BufferedImage.TYPE_INT_ARGB));
		setSize((int)(d.getWidth() * factor), (int)(d.getHeight() * factor));
		
		//Converting from Image to BufferedImage
		Graphics2D g2d = image.createGraphics();
		g2d.drawImage(img.getScaledInstance((int)(d.getWidth() * factor), (int)(d.getHeight() * factor), 
				Image.SCALE_SMOOTH), 0, 0, null);
		g2d.dispose();
		//Updating the frame size
		JFrame f = (JFrame)SwingUtilities.getRoot(this);
		f.pack();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		if (rect != null) {
			rect.paint(g);
		}
		//Updating the frame size
		JFrame f = (JFrame)SwingUtilities.getRoot(this);
		f.pack();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return image == null ? new Dimension(0, 0) : new Dimension(image.getWidth(), image.getHeight());
	}
}
