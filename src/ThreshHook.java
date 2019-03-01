import java.awt.Color;
import java.awt.Graphics;

public class ThreshHook extends GameObject {
	
	boolean isLaunching = false;
	int speed;
	public ThreshHook(int x, int y, int width, int height) {
		
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 8;
		
	}

	void update() {
	super.update();
	this.isLaunching = true;
	isLaunching = true;
	
	y+=speed;
	if(y==1200){
		isAlive = false;
	}
	

	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.threshHookImg, x, y, width, height, null);
	}
}
