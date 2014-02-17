package player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author Matthew
 *
 */
public class Player {
	
	private int x, y, dx, dy, gravity;
	private Gender curGender;
	private boolean unlocked, collision, fUnlocked;
	private BufferedImage[] players;
	
	public Player() {
		collision = fUnlocked = false;
		players = new BufferedImage[3];
		String[] locs = {"NeutralPlayer", "MalePlayer", "FemalePlayer"};
		try {
			for(int i = 0; i < locs.length; i++) {
				players[i] = ImageIO.read(new File("resources/" + locs[i] + ".png"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No file");
		}
		
		x = y = dx = dy = 0;
		curGender = Gender.NEUTRAL;
		unlocked = false;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setDX(int d) {
		dx = d;
	}
	
	public void setDY(int d) {
		dy = d;
	}
	
	public boolean getState() {
		return unlocked;
	}
	
	public void setState(boolean s)  {
		unlocked = s;
	}
	
	public boolean getFState() {
		return fUnlocked;
	}
	
	public void setFState(boolean s) {
		fUnlocked = s;
	}
	
	public void setCollision(boolean s) {
		collision = s;
	}
	
	public void changeGender(int c) {
		switch(c) {
			case 0:
				curGender = Gender.NEUTRAL;
				break;
			case 1:
				curGender = Gender.MALE;
				break;
			case 2:
				curGender = Gender.FEMALE;
				break;
			default:
				break;
		}
	}
	
	public Gender getGender() {
		return curGender;
	}
	
	public int getGravity() {
		return gravity;
	}
	
	public void setGravity(int g) {
		gravity = g;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(Graphics window) {
		x += dx;
		y += dy;
		switch(curGender) {
			case NEUTRAL:
				window.drawImage(players[0], x, y, 20, 20, null);
				break;
			case MALE:
				window.drawImage(players[1], x, y, 20, 20, null);
				break;
			case FEMALE:
				window.drawImage(players[2], x, y, 20, 20, null);
				break;
			default:
				break;
		}
		if(!collision) {
			dy += gravity;
		} else {
			dy = 0;
		}
	}
}
