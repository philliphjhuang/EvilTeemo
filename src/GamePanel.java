import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	Timer timer;
	GameObject GO;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	
	Font titleFont;
	
	Font smallFont;
	
	int currentState = MENU_STATE;
	
	
	
	void updateMenuState() {
		
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
		
		
		
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0,0, 9999, 9999);
		
		g.setColor(Color.BLACK);
		
		g.setFont(titleFont);
		
		g.drawString("Game Over", 118, 200);
		
		g.setFont(smallFont);
		
		g.drawString("You hooked " + OM.getScore() + " enemies", 138, 350);
		
		g.drawString("Press ENTER to rerstart",110,500);
		
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


	}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub

	
}




	
	
	
}