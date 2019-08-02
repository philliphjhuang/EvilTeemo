import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Blitzcrank B;
	Thresh T;
	Teemo teemo;
	ArrayList<Mushroom> M = new ArrayList<Mushroom>();
	ArrayList<Thresh> thresh = new ArrayList<Thresh>();
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
		for (Mushroom m : M) {
			m.update();
		}
		for (Thresh T : thresh) {
			T.update();
		}
	}

	void draw(Graphics g) {
		B.draw(g);
		T.draw(g);
		teemo.draw(g);
		for (Mushroom m : M) {
			m.draw(g);
		}
		for (Thresh th : thresh) {
			th.draw(g);
		}
	}

	void addMushroom(Mushroom mushroomObjects) {
		M.add(mushroomObjects);
	}
	void addThresh(Thresh ThreshObjects) {
		thresh.add(ThreshObjects);
	}

	public void manageHook() {
		if (System.currentTimeMillis()%100==0) {
			timer = System.currentTimeMillis();
			addMushroom(new Mushroom(teemo.x,teemo.y,100,100));
		}
	}
	void purgeObjects() {
		for (int i = 0; i < M.size(); i++) {
			if (M.get(i).isAlive == false) {
				M.remove(i);
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
		for (Mushroom m: M) {
			if(m.collisionBox.intersects(B.collisionBox)) {
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
