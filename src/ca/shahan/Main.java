package ca.shahan;

import ca.shahan.graphics.ShahanGraphics;
import ca.shahan.logic.LangtonsAnt;

/**
 * @author shahan
 *
 */
public class Main {
	ShahanGraphics g;
	long timeBetweenFrames = 1000000000;
	public static final int gameWidth = 100;
	public static final int gameHeight = 100;

	public static void main(String[] args) {
		
		new Main();
	}
	
	Main() {
		g = new ShahanGraphics();
		LangtonsAnt.ants.add(new int[] {50,50,0});
//		LangtonsAnt.ants.add(new int[] {200,100,0});

		GameLoop();
	}
	void GameLoop() {
		long lastUpdateTime = System.nanoTime();
		while(true) {
			if(System.nanoTime() - lastUpdateTime >  timeBetweenFrames) {
				lastUpdateTime = System.nanoTime();
				LangtonsAnt.UpdateGame();
				g.UpdateGame();
			}
		}
	}

}
