import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Blitzcrank B;
	Thresh T;
	ArrayList<BlitzcrankHook> BH = new ArrayList<BlitzcrankHook>();
	ArrayList<Thresh> thresh = new ArrayList<Thresh>();
	ArrayList<ThreshHook> TH = new ArrayList<ThreshHook>();
	long hookTimer = 0;
	boolean threshSpawn;
	int score = 0;
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
	}
	void draw(Graphics g) {
		B.draw(g);
		for(BlitzcrankHook bh: BH) {
			B.draw(g);
		}
		for(ThreshHook th: TH) {
			T.draw(g);
		}
	}
	void addBlitzcrankHook(BlitzcrankHook BlitzcrankHookObjects){
		BlitzcrankHook.add(BlitzcrankHookObjects);
	}
	void addThreshHook(ThreshHook ThreshHookObjects){
		ThreshHook.add(ThreshHookObjects);
		
		
	}

	
	
	
}
