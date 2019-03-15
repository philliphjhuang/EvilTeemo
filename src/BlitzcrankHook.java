import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BlitzcrankHook extends GameObject {
	int Xspeed;
	int Yspeed;
	int speed;
	
	public BlitzcrankHook(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 8;
		
		// TODO Auto-generated constructor stub
	}
		public void update() {
			
			
		super.update();
		if(new Random().nextInt(1)==1) {
			x+=Xspeed;
		} else {
			x-=Xspeed;
		}
		if(new Random().nextInt(1)==1) {
			y+=Yspeed;
		} else {
			y-=Yspeed;
		}
	
		if (y < 0) {
		Yspeed=-Yspeed;
		} 
		if(y>1000) {
		Yspeed = -Yspeed;
		}
		if(x<0) {
		Xspeed = -Xspeed;
		}
		if(x>1500) {
		Xspeed = -Xspeed;
		}
	}

	void draw(Graphics g) {

		g.drawImage(GamePanel.dartImg, x-50, y, width, height, null);

	}
}
