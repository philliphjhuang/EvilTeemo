import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Blitzcrank B;
	Thresh T;
	ArrayList<BlitzcrankHook> BH = new ArrayList<BlitzcrankHook>();
	ArrayList<Thresh> thresh = new ArrayList<Thresh>();
	ArrayList<ThreshHook> TH = new ArrayList<ThreshHook>();
	ArrayList<Teemo> Teeto = new ArrayList<Teemo>();
	long hookTimer = 0;
	long threshTimer = 0;
	int threshSpawnTime = 10000;
	int score = 0;
	Random a = new Random();
	int aa = a.nextInt(1);
	public ObjectManager(Blitzcrank B, Thresh T) {
		this.B=B;
		this.T=T;
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
		for(Teemo tee : Teeto) {
			tee.update();
		}
	}
	
	
		void drawBlitzcrankHook(Graphics g) {
		B.draw(g);
		
		for(BlitzcrankHook bh: BH) {
			B.draw(g);
		}
		
	}
		void drawThreshHook(Graphics g) {
			T.draw(g);
			for(ThreshHook th: TH) {
				T.draw(g);
			}
		}
		
		
		
		
	void addBlitzcrankHook(BlitzcrankHook BlitzcrankHookObjects){
		BH.add(BlitzcrankHookObjects);
	}
	void addThreshHook(ThreshHook ThreshHookObjects){
		TH.add(ThreshHookObjects);	
	}
	void addTeemo(Teemo TeemoObjects) {
		Teeto.add(TeemoObjects);
	}
	void addThresh(Thresh ThreshObjects) {
		thresh.add(ThreshObjects);
	}
	
	
	
	
	
	public void manageEnemies() {
		if((System.currentTimeMillis() - threshTimer >= threshSpawnTime)&& (T.isAlive==false)) {
			addThresh(new Thresh(800,0,50,50));
			threshTimer = System.currentTimeMillis();
		}
		if(tee.isAlive==false) {
			if(aa==0) {
				addTeemo(new Teemo(0,333,50,50));
			} else if(aa==1) {
				addTeemo(new Teemo(1000,666,50,50));
			}
		}
	}
	
	
	void purgeObjects() {
    	for(int i = 0; i < thresh.size(); i++) {
    		if(thresh.get(i).isAlive==false) {
    			thresh.remove(i);
    		}
    	}
    	for(int i = 0; i< teeto.size(); i++) {
    		if(teeto.get(i).isAlive==false) {
    			teeto.remove(i);
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
			} else if(bh.collisionBox.intersects(tee.)) {
				
			}
		
		}
			
	}
	
	
	
	
	
	
	
	
}
