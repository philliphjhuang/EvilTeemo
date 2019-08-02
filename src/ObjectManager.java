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
	long startTime = System.currentTimeMillis();
	long currentTime = (System.currentTimeMillis()-startTime)/1000;
	long timer = 0L;
	int score = 0;
	
		public ObjectManager(Blitzcrank B, Thresh T, Teemo teemo) {
		this.B = B;
		this.T = T;
		this.teemo = teemo;
	}

	void update() {
		B.update();
		T.update();
		teemo.update();
		for (BlitzcrankHook bh : BH) {
			bh.update();
		}
		for (Thresh T : thresh) {
			T.update();
		}
	}

	void draw(Graphics g) {
		B.draw(g);
		T.draw(g);
		teemo.draw(g);
		for (BlitzcrankHook bh : BH) {
			bh.draw(g);
		}
		for (Thresh th : thresh) {
			th.draw(g);
		}
	}

	void addBlitzcrankHook(BlitzcrankHook blitzcrankHookObjects) {
		BH.add(blitzcrankHookObjects);
	}
	void addThresh(Thresh ThreshObjects) {
		thresh.add(ThreshObjects);
	}

	public void manageHook() {
		if (System.currentTimeMillis()%100==0) {
			timer = System.currentTimeMillis();
			addBlitzcrankHook(new BlitzcrankHook(teemo.x,teemo.y,100,100));
		}
	}
	void purgeObjects() {
		for (int i = 0; i < BH.size(); i++) {
			if (BH.get(i).isAlive == false) {
				BH.remove(i);
			}
		}
	}
		/*
		for (int i = 0; i < TH.size(); i++) {
			if (TH.get(i).isAlive == false) {
				TH.remove(i);
				T.canHook = false;
			}
		}
		*/
		

		
	public int getScore() {
		return score;
	}

	void checkCollision() {
		for (BlitzcrankHook bh : BH) {
			if(bh.collisionBox.intersects(B.collisionBox)) {
				B.isAlive=false;
				
			}
			/* else if (bh.collisionBox.intersects(teemo.collisionBox)) {
				bh.isAlive = false;
				B.isAlive=false;
			}
		}
		for (ThreshHook th : TH) {
			if (th.collisionBox.intersects(B.collisionBox)) {
				B.isAlive = false;

			}
		}
		*/
		}
	}
}
