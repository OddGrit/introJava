import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener {

	private Container container;
	private ImagePanel img; 

	public enum Actions{
		MANIPULATE,
		LOAD
	}
	
	public ButtonListener(Container container) {
		this.container = container;
		
		if (container.getComponent(0) instanceof ImagePanel) {
			img = (ImagePanel) container.getComponent(0);
		} else {
			JOptionPane.showMessageDialog(null, "Fatal error");
			System.exit(1);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.MANIPULATE.name()) {
			
			JComboBox<String> cb;
			if (container.getComponent(1) instanceof ImgComboBox) {
				cb = (ImgComboBox)container.getComponent(1);
			} else {
				JOptionPane.showMessageDialog(null, "Error: Cannot find the selection Box");
				return;
			}
			
			switch(cb.getSelectedIndex()) {
			case ImgComboBox.INVERT:
				invertImage();
				break;
			case ImgComboBox.CROP:
				cropImage();
				break;
			case ImgComboBox.DOUBLE:
				img.resize(1.414);
				img.setRect(null);
				break;
			case ImgComboBox.HALF:
				img.resize(0.707);
				img.setRect(null);
			default:
			}
		} else if (e.getActionCommand() == Actions.LOAD.name()) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showDialog(img.getParent(), "Load");
			
			//Pressed load
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				img.setImage(file.getPath());
				fc.setSelectedFile(null);
			}
		}
	}
	
	private void invertImage() {
		BufferedImage image = img.getImage();
		Rectangle rect = img.getRect();
		//Default whole picture
		int startX = 0;
		int startY = 0;
		int stopX = image.getWidth();
		int stopY = image.getHeight();
		if (rect != null) {
			startX = rect.x;
			startY = rect.y;
			stopX = rect.width + startX;
			stopY = rect.height + startY;
		}
		for (int x = startX; x < stopX; x++) {
			for (int y = startY; y < stopY; y++) {
				Color color = new Color(image.getRGB(x, y), true);
				color = new Color(255 - color.getRed(),
								  255 - color.getGreen(),
								  255 - color.getBlue());
				image.setRGB(x, y, color.getRGB());
			}
		}
		img.setImage(image);
	}
	
	private void cropImage() {
		Rectangle rect = img.getRect();
		
		if (rect != null) {
			BufferedImage image = img.getImage();		
			//get a smaller image
			image = image.getSubimage(rect.x, rect.y, rect.width, rect.height);
			img.setImage(image);
			img.setRect(null); //Removing the Rectangle
		}
	}

}
