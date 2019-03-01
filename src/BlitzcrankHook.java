import java.awt.Color;
import java.awt.Graphics;

public class BlitzcrankHook extends GameObject {
	double velocity;
	double angle;
	int mouseX;
	int mouseY;
	double Xvelocity;
	double Yvelocity;
	boolean isLaunching = false;
	
	public BlitzcrankHook(int x, int y, int width, int height, int mouseX, int mouseY) {

		super(x, y, width, height);
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		int Xdif = x - mouseX;
		int Ydif = y - mouseY;

		this.isLaunching = true;
		isLaunching = true;

		velocity = 7;
		if (Xdif != 0) {
			angle = Math.atan((double) Ydif / (double) Xdif);
		} else {
			angle = 0;

		}

		if (x > 0) {
			Xvelocity = Math.cos(angle) * velocity;
			Yvelocity = Math.sin(angle) * velocity;
		}

		// TODO Auto-generated constructor stub
	}

	public void update() {
		if (isLaunching == true) {
			x += Xvelocity;
			y -= Yvelocity;
		}
		super.update();
		if (y < 0) {
			isAlive = false;
		}

	}

	void draw(Graphics g) {

		g.drawImage(GamePanel.blitzcrankHookImg, x, y, width, height, null);

	}
}
