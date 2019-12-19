import javax.swing.JComboBox;

public class ImgComboBox extends JComboBox{
	private final static String[] optionList = {"Invert", "Crop", "Something else here"};
	public static final int INVERT = 0;
	public static final int CROP = 1;
	
	public ImgComboBox() {
		super(optionList);
	}
}
