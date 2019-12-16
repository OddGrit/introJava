import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class FinalTask {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		SwingUtilities.invokeLater(ui);
	
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get("text.txt")), "UTF-8");
		} catch (IOException e) {
			
		}
		System.out.println(content);
	}

}
