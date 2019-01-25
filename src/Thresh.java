import java.awt.Color;
import java.awt.Graphics;

public class Thresh extends GameObject {
	int speed;
	public Thresh(int x, int y, int width, int height) {
		super(x,y,width,height);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
	void update() {
	super.update();
	x+=3;
	if(x<=0) {
		x=0;
		x+=3;
	} else if(x>=1000) {
		x=1000;
		x-=3;
	}
	}
	void draw(Graphics g) {
      	
	
	}
}
