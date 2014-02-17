package screens;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * @author Matthew
 *
 */
public abstract class Screen extends Canvas implements Runnable, KeyListener,
		MouseListener {

	private static final long serialVersionUID = 1L;
	private BufferedImage back;
	private ArrayList<MouseEvent> mouse;
	private ArrayList<String> keysP, keysR;
	
	public Screen() {
		mouse = new ArrayList<MouseEvent>();
		keysP = new ArrayList<String>();
		keysR = new ArrayList<String>();
		
		addMouseListener(this);
		addKeyListener(this);
	}
	
	@Override
	public void update(Graphics window) {
		paint(window);
	}
	
	@Override
	public void paint(Graphics window) {
        
        Graphics2D twoD = (Graphics2D) window;
        
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }
        
        Graphics backGraphic = back.createGraphics();
        
        myDraw(backGraphic);
        
        twoD.drawImage(back, null, 0, 0);
	}
	
	public abstract void myDraw(Graphics window);
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		mouse.add(arg0);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		String a = "" + arg0.getKeyChar();
		keysP.add(a);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		String a = "" + arg0.getKeyChar();
		keysR.add(a);

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<MouseEvent> getMouse() {
		return mouse;
	}
	
	public ArrayList<String> getKeysP() {
		return keysP;
	}
	
	public ArrayList<String> getKeysR() {
		return keysR;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e) {
			
		}
	}

}
