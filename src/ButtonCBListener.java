import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;

public class ButtonCBListener implements ActionListener {

	private JComboBox cb;
	private Image img; 
	
	public ButtonCBListener(JComboBox cb, Image img) {
		this.cb = cb;
		this.img = img;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(cb.getSelectedIndex()) {
		case ImgComboBox.INVERT:
			BufferedImage image = img.getImage();
			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
					Color color = new Color(image.getRGB(x, y), true);
					color = new Color(255 - color.getRed(),
									  255 - color.getGreen(),
									  255 - color.getBlue());
					image.setRGB(x, y, color.getRGB());
				}
			}
			img.setImage(image);
			break;
		case ImgComboBox.CROP:
			break;
		default:
			
		}
	}

}
