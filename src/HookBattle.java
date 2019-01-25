import java.awt.Dimension;

import javax.swing.JFrame;

public class HookBattle {

	

	JFrame frame;
	final int WIDTH = 1500; 
	final int HEIGHT = 1200;
	GamePanel GP;
	
	public HookBattle() {
		frame = new JFrame();
		GP = new GamePanel();
	}
	
	
	
	public static void main(String[] args) {
		HookBattle HB = new HookBattle();
		HB.setUp();
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
		frame.addMouseListener(GP);
		frame.addMouseMotionListener(GP);
		
		
	}
	
	
	
	
	
	
}

















