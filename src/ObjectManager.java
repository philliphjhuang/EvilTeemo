import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Blitzcrank B;
	Thresh T;
	Teemo teemo;
	ArrayList<BlitzcrankHook> BH = new ArrayList<BlitzcrankHook>();
	ArrayList<Thresh> thresh = new ArrayList<Thresh>();
	ArrayList<ThreshHook> TH = new ArrayList<ThreshHook>();
	long hookTimer = 0;
	long threshTimer = 0;
	int threshSpawnTime = 10000;
	int score = 0;
	Random a = new Random();
	int aa = a.nextInt(1);
	public ObjectManager(Blitzcrank B, Thresh T, Teemo teemo) {
		this.B=B;
		this.T=T;
		this.teemo=teemo;
	}
	
	
	
	void update() {
		B.update();
		T.update();
		for(BlitzcrankHook bh: BH){
			bh.update();
		}
		for(ThreshHook th: TH){
			th.update();
		}
		for(Thresh T: thresh) {
			T.update();
		}
	}
	
		void draw(Graphics g) {
			B.draw(g);
			for(BlitzcrankHook bh: BH) {
				bh.draw(g);
			}
			for(Thresh th:thresh) {
				th.draw(g);
			}
			for(ThreshHook th:TH) {
				th.draw(g);
			}
		}
	
		
		
		
		
	void addBlitzcrankHook(BlitzcrankHook BlitzcrankHookObjects){
		BH.add(BlitzcrankHookObjects);
	}
	void addThreshHook(ThreshHook ThreshHookObjects){
		TH.add(ThreshHookObjects);	
	}
	void addThresh(Thresh ThreshObjects) {
		thresh.add(ThreshObjects);
	}
	
	
	
	
	
	public void manageEnemies() {
		if((System.currentTimeMillis() - threshTimer >= threshSpawnTime)&& (T.isAlive==false)) {
			addThresh(new Thresh(800,0,50,50));
			threshTimer = System.currentTimeMillis();
		}
	}
	
	
	void purgeObjects() {
    	for(int i = 0; i < thresh.size(); i++) {
    		if(thresh.get(i).isAlive==false) {
    			thresh.remove(i);
    		}
    	}
	}
	public int getScore() {
		return score;
	}
	
	
	
	
	
	void checkCollision() {
		for(BlitzcrankHook bh:BH) {
			if(bh.collisionBox.intersects(T.collisionBox)) {
				score++;
				bh.isAlive=false;
				T.isAlive=false;
			} else if(bh.collisionBox.intersects(teemo.collisionBox)) {
				score--;
			}
		}	
		for(ThreshHook th:TH) {
			if(th.collisionBox.intersects(B.collisionBox)) {
				B.isAlive = false;
			}
		}
	}
	
	
	
	
	
	
	
	
}
