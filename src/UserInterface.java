import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable{
	
	private JFrame frame;
	
	public UserInterface() {
		
	}

	@Override
	public void run() {
		frame = new JFrame("Image Manipulator");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createComponents(Container container) {
		container.setLayout(new BorderLayout());
		
		ImagePanel img = new ImagePanel();
		ImgListener il = new ImgListener(img);
		img.addMouseListener(il);
		img.addMouseMotionListener(il);
		container.add(img, BorderLayout.NORTH);
		
		ImgComboBox comboBox = new ImgComboBox();
		container.add(comboBox, BorderLayout.WEST);

		JButton manButton = new JButton("Manipulate image");
		manButton.setActionCommand(ButtonListener.Actions.MANIPULATE.name());
		manButton.addActionListener(new ButtonListener(container));
		container.add(manButton, BorderLayout.CENTER);
		
		JButton loadButton = new JButton("Load image");
		loadButton.setActionCommand(ButtonListener.Actions.LOAD.name());
		loadButton.addActionListener(new ButtonListener(container));
		container.add(loadButton, BorderLayout.EAST);

	}
	
	

}
