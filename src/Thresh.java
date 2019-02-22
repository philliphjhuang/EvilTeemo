import java.awt.Color;
import java.awt.Graphics;

public class Thresh extends GameObject {
	int Xspeed;
	int Yspeed;
	public Thresh(int x, int y, int width, int height) {
		super(x,y,width,height);
		// TODO Auto-generated constructor stub
		Xspeed = 3;
		Yspeed = 3;
	}
	void update() {
	super.update();
	
	x+=Xspeed;
	y+=Yspeed;
	if(x==1500) {
		Xspeed=-Xspeed;
	} 
	if(x==0) {
		Xspeed=3;
	}
	if(y>400) {
		Yspeed=-Yspeed;
	}
	if(y==0) {
		Yspeed=3;
	}
	
	
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.threshImg,x-70,y-100,width,height,null);
	}
}
