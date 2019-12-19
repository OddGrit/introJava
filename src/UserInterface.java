import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable{
	
	private JFrame frame;
	
	public UserInterface() {
		
	}

	@Override
	public void run() {
		frame = new JFrame("Image editor");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createComponents(Container container) {
		container.setLayout(new BorderLayout());
		ImgComboBox comboBox = new ImgComboBox();
		container.add(comboBox, BorderLayout.WEST);

		Image img = new Image("nature1.jpeg");
		container.add(img, BorderLayout.NORTH);

		JButton button = new JButton("Manipulate image");
		button.addActionListener(new ButtonCBListener(comboBox, img));
		container.add(button, BorderLayout.EAST);
	}

}
