import java.awt.Color;
import java.awt.Graphics;

public class Thresh extends GameObject {
	int Xspeed;
	int Yspeed;
	public Thresh(int x, int y, int width, int height) {
		super(x,y,width,height);
		// TODO Auto-generated constructor stub
		Xspeed = 4;
		Yspeed = 4;
	}
	void update() {
	super.update();
	
	x+=Xspeed;
	y+=Yspeed;
	if(x==1500) {
		Xspeed=-Xspeed;
	} 
	if(x==0) {
		Xspeed=4;
	}
	if(y>250) {
		Yspeed=-Yspeed;
	}
	if(y==10) {
		Yspeed=4;
	}
	
	
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.threshImg,x,y,width,height,null);
	}
}
