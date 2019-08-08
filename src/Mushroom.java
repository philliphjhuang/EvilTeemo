import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Mushroom extends GameObject {
	int Xspeed;
	int Yspeed;
	public Mushroom(int x, int y, int width, int height) {
		super(x, y, width, height);
		Xspeed = 10;
		Yspeed = 10;
		// TODO Auto-generated constructor stub
	}
		public void update() {
			
			
		super.update();
		
		if(new Random().nextInt(2)==1) {
			x+=Xspeed;
		} else {
			x-=Xspeed;
		}
		if(new Random().nextInt(2)==1) {
			y+=Yspeed;
		} else {
			y-=Yspeed;
		}

		if (y < 0) {
		Yspeed=-Yspeed;
		} 
		if(y>1200) {
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
		g.drawImage(GamePanel.mushroomImg, x, y, width, height, null);
		g.setColor(new Color(0,0,0,0));
		g.drawRect(collisionBox.x+5, collisionBox.y, collisionBox.width-10,collisionBox.height-5);
	}
}
