import java.awt.Color;
import java.awt.Graphics;
public class Blitzcrank extends GameObject{
	boolean right = false;
	boolean left = false;
	int speed;
	public Blitzcrank(int x, int y, int width, int height) {
		super(x,y,width,height);
		// TODO Auto-generated constructor stub
		speed = 5;
	}
	void update() {
	super.update();
	
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.blitzcrankImg,x,y,width,height,null);
	}
}
