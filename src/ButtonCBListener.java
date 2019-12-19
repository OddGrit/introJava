import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JComboBox;

public class ButtonCBListener implements ActionListener {

	private JComboBox<String> cb;
	private ImagePanel img; 
	
	public ButtonCBListener(JComboBox<String> cb, ImagePanel img) {
		this.cb = cb;
		this.img = img;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedImage image = img.getImage();
		Rectangle rect = img.getRect();
		
		switch(cb.getSelectedIndex()) {
		case ImgComboBox.INVERT:
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
			break;
		case ImgComboBox.CROP:
			if (rect != null) {
				//get a smaller image
				image = image.getSubimage(rect.x, rect.y, rect.width, rect.height);
				img.setImage(image);
				img.setRect(null); //Removing the Rectangle
			}
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
		
		
	}

}
