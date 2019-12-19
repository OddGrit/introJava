import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class ButtonLoadListener implements ActionListener {
	private ImagePanel img;
	private JFileChooser fc; 
	
	public ButtonLoadListener(ImagePanel img) {
		this.img = img;
		fc = new JFileChooser();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int returnVal = fc.showDialog(img.getParent(), "Load");
		
		//Pressed load
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			img.setImage(file.getPath());
			fc.setSelectedFile(null);
		}
	}

}
