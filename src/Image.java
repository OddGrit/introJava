import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Image extends JPanel{
	private BufferedImage image;
	
	public Image(String path){
		setImage(path);
	}
	
	public Image () {
		super();
		image = null;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage img) {
		image = img;
		this.repaint();
	}
	
	public void setImage(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e){
			JOptionPane.showMessageDialog(null,  "Could not open the file.");
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(image.getWidth(), image.getHeight());
	}
}
