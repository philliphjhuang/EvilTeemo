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
	long timer = 10000;
	int score = 0;
	Random a = new Random();
	int aa = a.nextInt(1);

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
		for (ThreshHook th : TH) {
			th.update();
		}
		for (Thresh T : thresh) {
			T.update();
		}
	}

	void draw(Graphics g) {
		B.draw(g);
		for (BlitzcrankHook bh : BH) {
			bh.draw(g);
		}
		for (Thresh th : thresh) {
			th.draw(g);
		}
		for (ThreshHook th : TH) {
			th.draw(g);
		}
		T.draw(g);
		teemo.draw(g);
	}

	void addBlitzcrankHook(BlitzcrankHook BlitzcrankHookObjects) {
		BH.add(BlitzcrankHookObjects);
	}

	void addThreshHook(ThreshHook ThreshHookObjects) {
		TH.add(ThreshHookObjects);
	}

	void addThresh(Thresh ThreshObjects) {
		thresh.add(ThreshObjects);
	}
/*
	public void manageHook() {
		if ((System.currentTimeMillis() >= timer)) {
			B.canHook = true;
		}
		if ((System.currentTimeMillis() >= timer)) {
			T.canHook = true;
			addThreshHook(new ThreshHook(T.x, T.y, 100, 100));
		}
	}
*/
	public void manageEnemies() {
		if ((System.currentTimeMillis() > timer) && (T.isAlive == false)) {
			addThresh(new Thresh(750, 100, 150, 150));
			timer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < thresh.size(); i++) {
			if (T.isAlive==false) {
				thresh.remove(i);
			}
		}
		for (int i = 0; i < TH.size(); i++) {
			if (TH.get(i).isAlive == false) {
				TH.remove(i);
				T.canHook = false;
			}
		}
		for (int i = 0; i < BH.size(); i++) {
			if (BH.get(i).isAlive == false) {
				BH.remove(i);
			}
		}
	}

	public int getScore() {
		return score;
	}

	void checkCollision() {
		for (BlitzcrankHook bh : BH) {
			if (bh.collisionBox.intersects(T.collisionBox)) {
				score++;
				bh.isAlive = false;
				T.isAlive = false;
			} else if (bh.collisionBox.intersects(teemo.collisionBox)) {
				score--;
				bh.isAlive = false;
			}
		}
		for (ThreshHook th : TH) {
			if (th.collisionBox.intersects(B.collisionBox)) {
				B.isAlive = false;

			}
		}
	}
}
