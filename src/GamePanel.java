import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	
	Timer timer;
	GameObject GO;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	
	Font titleFont;
	
	Font smallFont;
	
	int currentState = MENU_STATE;
	
	Blitzcrank B = new Blitzcrank(800,1500,100,100);
	
	Thresh T = new Thresh(800,1000,100,100);
	
	ObjectManager OM = new ObjectManager(B,T);
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		OM.update();
		OM.manageEnemies();
		OM.checkCollisions();
		OM.purgeObjects();
		if(B.isAlive==false) {
			currentState = END_STATE;
		}
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		
		g.fillRect(0,0, 9999,9999);    
		
		g.setColor(Color.YELLOW);
		
		g.setFont(titleFont);
		
		g.drawString("Hook Battle", 25, 200);
		
		g.setFont(smallFont);
		
		g.drawString("Press ENTER to start", 135, 350);
		
		g.drawString("Press SPACE for instructions",90,500);
		
		
		
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 9999, 9999);
		
		OM.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0,0, 9999, 9999);
		
		g.setColor(Color.BLACK);
		
		g.setFont(titleFont);
		
		g.drawString("Game Over", 118, 200);
		
		g.setFont(smallFont);
		
		g.drawString("You hooked " + OM.getScore() + " Threshes", 138, 350);
		
		g.drawString("Press ENTER to rerstart",110,500);
		
	}
public GamePanel() {
		
		GO = new GameObject(10,10,100,100);


	timer = new Timer(1000/60,this);
	
	
	titleFont = new Font("Arial",Font.BOLD,48);
	smallFont = new Font("Arial",Font.BOLD,24);

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

if(currentState == MENU_STATE){

    updateMenuState();

}else if(currentState == GAME_STATE){

    updateGameState();

}else if(currentState == END_STATE){

    updateEndState();

}


	
	
	
	
	
}
@Override

public void paintComponent(Graphics g){
	GO.draw(g);
	
	if(currentState == MENU_STATE){

	    drawMenuState(g);

	}else if(currentState == GAME_STATE){

	    drawGameState(g);

	}else if(currentState == END_STATE){

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
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		if(currentState==END_STATE) {
		B = new Blitzcrank(250,700,50,50);
		OM = new ObjectManager(B);
	}
		System.out.println(WIDTH+" "+HEIGHT);
		currentState ++;
	}
	if(currentState > END_STATE){
		
        currentState = MENU_STATE;
	}
		if(e.getKeyCode()==KeyEvent.VK_Q){
		OM.addHook(new Hook(B.x+20,B.y,10,10));
		if(currentState==MENU_STATE) {
			JOptionPane.showMessageDialog(null, "Right click around to move. Press Q to hook. Try not to get hooked.");
		}
	}

	}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	




	
	
	
}