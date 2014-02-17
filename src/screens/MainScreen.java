package screens;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.Start;

/**
 * @author Matthew
 *
 */
public class MainScreen extends Screen {

	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	
	public MainScreen() {
		super();
		File file = new File("resources/MainScreen.png");
		try {
			background = ImageIO.read(file);
		} catch (Exception e) {
			System.out.println("No file");
		}
		
		setVisible(true);
        
        new Thread(this).start();
	}
	
	@Override
	public void myDraw(Graphics window) {
		
		if(!getMouse().isEmpty()) {
			interaction(getMouse());
		}
		
		window.drawImage(background, 0, 0, 800, 640, null);
	}
	
	public void interaction(ArrayList<MouseEvent> q) {
		Start.changeState(1);
		q.remove(0).consume();
	}
}
