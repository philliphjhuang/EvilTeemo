import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Teemo extends GameObject {
	int speed;
	public Teemo(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
	}


	void update() {
		Random r = new Random();
		int q = r.nextInt(1);
		if(q==0) {
			x++;
		} else if(q==1) {
			x--;
		}
	}
	void draw(Graphics g){
        

		
	}
	
	
}