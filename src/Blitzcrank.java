import java.awt.Color;
import java.awt.Graphics;
public class Blitzcrank extends GameObject{
	int mouseX ;
	int mouseY ;
	int speed = 3;
	boolean isLaunching;
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

	
	if (x + (width/2) < mouseX) {
		x += speed;
	}
	if(x + (width/2) > mouseX) {
		x -= speed;
	}
	if(y + (height/2) < mouseY) {
		y += speed;
	}
	if(y + (height/2) > mouseY) {
		y -= speed;
	}
	
	
	
	
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.blitzcrankImg,x,y,width,height,null);
		g.setColor(Color.RED);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width,collisionBox.height );
	}
}
