package ca.shahan;

import ca.shahan.graphics.ShahanGraphics;
import ca.shahan.logic.LangtonsAnt;

/**
 * @author shahan
 *
 */
public class Main {
	ShahanGraphics g;
	long timeBetweenFrames = 1000000;
	public static final int gameWidth = 1000;
	public static final int gameHeight = 1000;

	public static void main(String[] args) {
		
		new Main();
	}
	
	Main() {
		g = new ShahanGraphics();
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
