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
	if(right==true) {
		x+=speed;
	}
	if(left==true) {
		x-=speed;
	}
	if(x<=0) {
		x=0;
		left=false;
	} else if(x>=1000) {
		x=1000;
		right=false;
	}
}
	void draw(Graphics g) {
		
	}
}
