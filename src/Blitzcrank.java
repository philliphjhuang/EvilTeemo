import java.awt.Color;
import java.awt.Graphics;
public class Blitzcrank extends GameObject{
	int mouseX ;
	int mouseY ;
	int speed = 3;
	public Blitzcrank(int x, int y, int width, int height) {
		super(x,y,width,height);
		// TODO Auto-generated constructor stub
	}
	
	public void mousePosition(int mouseX, int mouseY) {
		this.mouseX=mouseX;
		this.mouseY=mouseY;
	}
	
	
	void update() {
	super.update();

	
	if(y<750) {
		y=750;
	}
	if (x < mouseX) {
		x += speed;
	}
	if(x > mouseX) {
		x -= speed;
	}
	if(y < mouseY) {
		y += speed;
	}
	if(y > mouseY) {
		y -= speed;
	}
	
	
	
	
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.blitzcrankImg,x-70,y-100,width,height,null);
	}
}
