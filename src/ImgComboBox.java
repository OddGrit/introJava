import javax.swing.JComboBox;

public class ImgComboBox extends JComboBox<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String[] optionList = {"Invert", "Crop", "Double", "Half"};
	public static final int INVERT = 0;
	public static final int CROP = 1;
	public static final int DOUBLE = 2;
	public static final int HALF = 3;
	
	public ImgComboBox() {
		super(optionList);
	}
}
