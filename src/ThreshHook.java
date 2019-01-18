import java.awt.Color;
import java.awt.Graphics;
	
public class ThreshHook extends GameObject {
	
	
	int speed;
	public ThreshHook(int x, int y, int width, int height) {
		
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
		
	}

	void update() {
	super.update();
	y+=speed;
	if(y>1000){
		isAlive = false;
	}

	}

	void draw(Graphics g) {
	    


		
	}
}
