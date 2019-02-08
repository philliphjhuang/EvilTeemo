import java.awt.Color;
import java.awt.Graphics;
public class BlitzcrankHook extends GameObject {
double velocity;
double angle;
int mouseX;
int mouseY;
boolean isLaunching = false;


public BlitzcrankHook(int x, int y, int width, int height, int mouseX, int mouseY) {
	
	super(x, y, width, height);
	this.mouseX=mouseX;
	this.mouseY=mouseY;
	int Xdif =  y  - mouseX;
	int Ydif = x - mouseY;
	
	this.isLaunching = true;
	isLaunching = true;
	velocity = Math.sqrt(((Xdif*Xdif)+(Ydif*Ydif))*0.001);
	if(Xdif!=0) {
		angle = Math.atan((double)Ydif/(double)Xdif);
	}	else {
		angle=0;
		velocity=0;
	}
	
	
	// TODO Auto-generated constructor stub
}

public void update() {
	if (isLaunching == true) {
		x += velocity * Math.cos(angle);
		y += velocity * Math.sin(angle);
	}
super.update();
if(y<0){
	isAlive = false;
}



}

void draw(Graphics g) {
    
	g.drawImage(GamePanel.blitzcrankHookImg,x,y,width,height,null);

	
}
}
