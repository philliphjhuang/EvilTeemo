import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	Timer timer;
	GameObject GO;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	Font titleFont;

	Font smallFont;

	int currentState = MENU_STATE;

	Blitzcrank B = new Blitzcrank(750, 800, 150, 150);

	Thresh T = new Thresh(750, 100, 150, 150);

	Teemo teemo = new Teemo(0, 450, 200, 200);

	ObjectManager OM = new ObjectManager(B, T, teemo);

	int mouseX;

	int mouseY;

	boolean canHook;

	public static BufferedImage blitzcrankImg;
	public static BufferedImage blitzcrankHookImg;
	public static BufferedImage threshImg;
	public static BufferedImage threshHookImg;
	public static BufferedImage teemoImg;
	public static BufferedImage mapImg;
	void updateMenuState() {

	}

	void updateGameState() {
		OM.update();
		OM.manageEnemies();
		OM.checkCollision();
		OM.purgeObjects();
		if (B.isAlive == false) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, 9999, 9999);

		g.setColor(Color.YELLOW);

		g.setFont(titleFont);

		g.drawString("Hook Battle", 25, 200);

		g.setFont(smallFont);

		g.drawString("Press ENTER to start", 135, 350);

		g.drawString("Press SPACE for instructions", 90, 500);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 9999, 9999);
		g.drawImage(mapImg, 0, 0, mapImg.getWidth(), 1200, null);
		OM.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, 9999, 9999);

		g.setColor(Color.BLACK);

		g.setFont(titleFont);

		g.drawString("Game Over", 118, 200);

		g.setFont(smallFont);

		g.drawString("You hooked " + OM.getScore() + " Thresh(es)", 138, 350);

		g.drawString("Press ENTER to rerstart", 110, 500);

	}

	public GamePanel() {

		GO = new GameObject(10, 10, 100, 100);

		timer = new Timer(1000 / 60, this);

		titleFont = new Font("Arial", Font.BOLD, 48);
		smallFont = new Font("Arial", Font.BOLD, 24);

		try {

			blitzcrankImg = ImageIO.read(this.getClass().getResourceAsStream("blitzcrank.png"));

			blitzcrankHookImg = ImageIO.read(this.getClass().getResourceAsStream("blitzcrankHook.png"));

			threshImg = ImageIO.read(this.getClass().getResourceAsStream("thresh.png"));

			threshHookImg = ImageIO.read(this.getClass().getResourceAsStream("threshHook.png"));
			
			teemoImg = ImageIO.read(this.getClass().getResourceAsStream("teemo.png"));
			
			mapImg = ImageIO.read(this.getClass().getResourceAsStream("map.png"));
			
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		GO.update();
		repaint();

		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

	}

	@Override

	public void paintComponent(Graphics g) {
		GO.draw(g);

		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END_STATE) {
				B = new Blitzcrank(750, 800, 150, 150);
				T = new Thresh(750, 100, 150, 150);
				teemo = new Teemo(0, 450, 200, 200);
				OM = new ObjectManager(B, T, teemo);
			}
			System.out.println(WIDTH + " " + HEIGHT);
			currentState++;
		}
		if (currentState > END_STATE) {

			currentState = MENU_STATE;
		}
		if ((e.getKeyCode() == KeyEvent.VK_Q) && (B.canHook==true)) {
			if (currentState == GAME_STATE) {
				OM.addBlitzcrankHook(new BlitzcrankHook(B.x - 70, B.y - 100, 100, 100, mouseX, mouseY));
				B.canHook=false;
				if(B.isLaunching==true) {
					B.speed=0;
				} else {
					B.speed = 3;
				}
			}
		}
		if (currentState == MENU_STATE) {
			JOptionPane.showMessageDialog(null, "Click to move around. Press Q to hook. Don't hook Teemo. Try not to get hooked. Your hook has a 13 seconds cooldown, use it wisely.");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("x: " + e.getX());
		System.out.println("y: " + e.getY());

		B.mousePosition(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}