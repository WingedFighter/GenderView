package main;
import javax.swing.*;
import java.awt.*;
import screens.*;

/**
 * @author Matthew
 *
 */
public class Start extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int CANVAS_WIDTH = 800;
	public static final int CANVAS_HEIGHT = 640;
	public static final String TITLE = "Gender View";
	
	private static boolean change;
	private static int state;
	
	public Start() {
		super(TITLE);
		this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		change = true;
		state = 0;
		
		//Screen stuff goes here, instantiate
		
		while(true) {
			
			if(change) {
				getContentPane().removeAll();
				switch(state) {
					case 0:
						Screen main = new MainScreen();
						((Component) main).setFocusable(true);
						getContentPane().add(main);
						main.requestFocusInWindow();
						break;
					case 1:
						Screen intSc = new InstructionScreen();
						((Component) intSc).setFocusable(true);
						getContentPane().add(intSc);
						intSc.requestFocusInWindow();
						break;
					case 2:
						GameRooms first = new Room1();
						((Component) first).setFocusable(true);
						getContentPane().add(first);
						first.requestFocusInWindow();
						JOptionPane.showMessageDialog(this,
							    "Welcome to New York.");
						break;
					case 3:
						GameRooms second = new Room2();
						((Component) second).setFocusable(true);
						getContentPane().add(second);
						second.requestFocusInWindow();
						JOptionPane.showMessageDialog(this,
							    "Are you really male?");
						break;
					case 4:
						GameRooms third = new Room3();
						((Component) third).setFocusable(true);
						getContentPane().add(third);
						third.requestFocusInWindow();
						JOptionPane.showMessageDialog(this,
							    "Or are you female?.");
						break;
					case 5:
						GameRooms fourth = new Room4();
						((Component) fourth).setFocusable(true);
						getContentPane().add(fourth);
						fourth.requestFocusInWindow();
						JOptionPane.showMessageDialog(this,
							    "Maybe both. Take a trip to find out.");
						break;
					case 6:
						GameRooms fifth = new Room5();
						((Component) fifth).setFocusable(true);
						getContentPane().add(fifth);
						fifth.requestFocusInWindow();
						JOptionPane.showMessageDialog(this,
							    "It is in the journey, not the destination, that you will find yourself both within you and within others.");
						break;
					case 7:
						GameRooms sixth = new Room6();
						((Component) sixth).setFocusable(true);
						getContentPane().add(sixth);
						sixth.requestFocusInWindow();
						JOptionPane.showMessageDialog(this,
							    "Welcome to Nevada, it is time to make your choice.");
						break;
					case 8:
						GameRooms seventh = new Room7();
						((Component) seventh).setFocusable(true);
						getContentPane().add(seventh);
						seventh.requestFocusInWindow();
						JOptionPane.showMessageDialog(this,
							    "Your choice will never be this black and white (or blue and pink)");
						break;
					case 9:
						JOptionPane.showMessageDialog(this,
							    "Did you make the right choice?");
						System.exit(0);
						break;
					case 10:
						JOptionPane.showMessageDialog(this,
							    "Did you make the right choice?");
						System.exit(0);
						break;
					default:
						break;
				}
				change = false;
			}
			
			setVisible(true);
			
		}
	}
	
	public static void changeState(int s) {
		state = s;
		change = true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Start();
	}

}
