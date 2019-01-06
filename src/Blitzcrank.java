import java.awt.Dimension;

import javax.swing.JFrame;

public class Blitzcrank {

	

	JFrame frame;
	final static int WIDTH = 1000; 
	final int HEIGHT = 1600;
	GamePanel GP;
	
	
	
	
	public static void main(String[] args) {
		Blitzcrank B = new Blitzcrank();
		B.setUp();
	}
	
void setUp() {
		
		frame.add(GP);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.pack();
		GP.startGame();
		frame.addKeyListener(GP);
		
		
	}
	
	
	
	
	
	
}

















