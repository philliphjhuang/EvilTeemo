import java.awt.Color;
import java.awt.Graphics;

public class Thresh extends GameObject {
	int Xspeed;
	int Yspeed;
	public Thresh(int x, int y, int width, int height) {
		super(x,y,width,height);
		// TODO Auto-generated constructor stub
		Xspeed = 6;
		Yspeed = 6;
	}
	void update() {
	super.update();
	
	x+=Xspeed;
	y+=Yspeed;
	if(x==1500) {
		Xspeed=-Xspeed;
	} 
	if(x==0) {
		Xspeed=6;
	}
	if(y>300) {
		Yspeed=-Yspeed;
	}
	if(y==10) {
		Yspeed=6;
	}
	
	
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.threshImg,x-70,y-100,width,height,null);
	}
}
