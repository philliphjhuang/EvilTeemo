import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Teemo extends GameObject {
	int speed;
	public Teemo(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 3;
	}


	void update() {
		x+=speed;
		if(x==1500) {
			speed=-speed;
		} 
		if(x==0) {
			speed=3;
		}
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.blitzcrankImg,x-70,y-100,width,height,null);

		
	}
	
	
}