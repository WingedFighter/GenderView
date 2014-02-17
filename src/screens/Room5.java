package screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import player.Gender;

/**
 * @author Matthew
 *
 */
public class Room5 extends GameRooms {

	private static final long serialVersionUID = 1L;
	private BufferedImage[] imgs;
	private int genderNumber;
	private boolean maleState, femaleState;
	private int[][] blockField = 
			{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};

	public Room5() {
		super();
		imgs = getImgs();
		genderNumber = 1;
		setPlayerX(20);
		setPlayerY(300);
		maleState = false;
		femaleState = false;
		player.setState(true);
		player.setFState(true);
	}
	
	public boolean collisionDetection(int x, int y, int j, int i) {
		int x2 = j * 20;
		int y2 = i * 20;
		if(x >= x2 && x <= x2 + 20) {
			if(y >= y2 - 20 && y <= y2 + 20) {
				return true;
			}
		}
		return false;
	}
	
	public boolean imSmart() {
		int x = player.getX();
		int y = player.getY();
		for(int i = 0; i < blockField.length; i++) {
			for(int j = 0; j < blockField[0].length; j++) {
				if(blockField[i][j] == 1) {
					if(collisionDetection(x, y, j, i)) {
						player.setCollision(true);
						return true;
					}
				}
				if(blockField[i][j] == 5) {
					if(collisionDetection(x, y, j, i)) {
						player.setState(true);
						return true;
					}
				}
				if(blockField[i][j] == 6) {
					if(collisionDetection(x, y, j, i)) {
						changeRooms(4);
						return true;
					}
				}
				if(blockField[i][j] == 4 && player.getGender() == Gender.FEMALE) {
					if(collisionDetection(x, y, j, i)) {
						player.setCollision(true);
						return true;
					}
				}
				if(blockField[i][j] == 3 && player.getGender() == Gender.MALE) {
					if(collisionDetection(x, y, j, i)) {
						player.setCollision(true);
						return true;
					}
				}
			}
		}
		player.setCollision(false);
		return false;
	}
	
	@Override
	public void setMaleState(boolean m) {
		maleState = m;
	}
	
	@Override
	public void setFemaleState(boolean f) {
		femaleState = f;
	}
	
	@Override
	public void myDraw(Graphics window) {
		if(maleState) {
			genderNumber = 1;
		} else if(femaleState) {
			genderNumber = 2;
		} else {
			genderNumber = 0;
		}
		window.drawImage(imgs[genderNumber], 0, 0, 800, 640, null);
		for(int i = 0; i < blockField.length; i++) {
			for(int j = 0; j < blockField[0].length; j++) {
				if(blockField[i][j] == 1 && (player.getGender() == Gender.NEUTRAL)) {
					window.drawImage(imgs[5], j * 20, i * 20, 20, 20, null);
				} else if(blockField[i][j] == 3 && (player.getGender() == Gender.MALE)) {
					window.drawImage(imgs[6], j*20, i * 20, 20, 20, null);
				} else if(blockField[i][j] == 1 && (player.getGender() == Gender.MALE) && i >= 15) {
					window.drawImage(imgs[6], j * 20, i * 20, 20, 20, null);
				} else if(blockField[i][j] == 6) {
					window.drawImage(imgs[5], j * 20, i * 20, 20, 20, null);
				} else if(blockField[i][j] == 4 && (player.getGender() == Gender.FEMALE)) {
					window.drawImage(imgs[7], j*20, i * 20, 20, 20, null);
				} else if(blockField[i][j] == 1 && (player.getGender() == Gender.FEMALE) && i >= 15) {
					window.drawImage(imgs[7], j * 20, i * 20, 20, 20, null);
				}
			}
		}
		imSmart();
		interact();
		player.draw(window);
	}
}
