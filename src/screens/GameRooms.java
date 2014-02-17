package screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import player.Gender;
import player.Player;

import javax.imageio.ImageIO;

import main.Start;

/**
 * @author Matthew
 *
 */
public class GameRooms extends Screen {

	private static final long serialVersionUID = 1L;
	private final int DY_CONSTANT = 20;
	private final int DX_CONSTANT = 2;
	private BufferedImage backN, backM, backF, signM, signF;
	private BufferedImage blockN, blockM, blockF;
	private String[] fileLocs = {"GameNeutralBack", "GameMaleBack",
			"GameFemaleBack", "MaleSign", "FemaleSign", "BlackBlock",
			"BlueBlock", "PinkBlock"};
	private BufferedImage[] imgs = {backN, backM, backF, signM, signF,
			blockN, blockM, blockF};
	protected Player player;
	
	public GameRooms() {
		super();
		try {
			for(int i = 0; i < fileLocs.length; i++) {
				File file = new File("resources/" + fileLocs[i] + ".png");
				imgs[i] = ImageIO.read(file);
			}
			
		} catch (Exception e) {
			System.out.println("No file");
		}
		
		player = new Player();
		player.setGravity(1);
		
		setVisible(true);
        
        new Thread(this).start();
	}
	
	public BufferedImage[] getImgs() {
		return imgs;
	}
	
	public void setPlayerX(int x) {
		player.setX(x);
	}
	
	public void setPlayerY(int y) {
		player.setY(y);
	}
	
	public void setPlayerDX(int d) {
		player.setDX(d);
	}
	
	public void setPlayerDY(int d) {
		player.setDY(d);
	}
	
	public void interact() {
		if(!(getKeysP().isEmpty())) {
			String e = getKeysP().remove(0);
			movePlayer(e);
		} else if(!(getKeysR().isEmpty())) {
			String e = getKeysR().remove(0);
			stopPlayer(e);
		}
	}
	
	public void movePlayer(String x) {
		switch(x) {
			case "a":
				setPlayerDX(-1 * DX_CONSTANT);
				break;
			case "w":
				setPlayerDY(-1 * DY_CONSTANT);
				break;
			case "d":
				setPlayerDX(DX_CONSTANT);
				break;
			case "c":
				if(player.getGender() == Gender.MALE && player.getFState()) {
					player.changeGender(2);
					setFemaleState(true);
					setMaleState(false);
				} else if (player.getGender() == Gender.NEUTRAL && player.getState()){
					player.changeGender(1);
					setFemaleState(false);
					setMaleState(true);
				} else {
					player.changeGender(0);
					setFemaleState(false);
					setMaleState(false);
				}
			default:
				break;
		}
	}
	
	public void setMaleState(boolean b) {}
	
	public void setFemaleState(boolean b) {}
	
	public void changeRooms(int i) {
		Start.changeState(i + 3);
	}
	
	public void stopPlayer(String x) {
		switch(x) {
		case "a":
			setPlayerDX(0);
			break;
		case "w":
			break;
		case "d":
			setPlayerDX(0);
			break;
		default:
			break;
	}
	}

	/* (non-Javadoc)
	 * @see screens.Screen#myDraw(java.awt.Graphics)
	 */
	@Override
	public void myDraw(Graphics window) {
		
	}

}
