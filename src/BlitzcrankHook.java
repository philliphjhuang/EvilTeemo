import java.awt.Color;
import java.awt.Graphics;
public class BlitzcrankHook extends GameObject {
int speed;
public BlitzcrankHook(int x, int y, int width, int height) {
	
	super(x, y, width, height);
	// TODO Auto-generated constructor stub
	speed = 10;
	
}

void update() {
super.update();
y-=speed;
if(y<0){
	isAlive = false;
}

}

void draw(Graphics g) {
    


	
}
}
