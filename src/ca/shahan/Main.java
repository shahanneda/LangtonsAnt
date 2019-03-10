package ca.shahan;

import ca.shahan.graphics.ShahanGraphics;
import ca.shahan.logic.LangtonsAnt;

/**
 * @author shahan
 *
 */
public class Main {
	ShahanGraphics g;
	long timeBetweenFrames = 1;
	public static final int gameWidth = 100;
	public static final int gameHeight = 100;

	public static void main(String[] args) {
		
		new Main();
	}
	
	Main() {
		System.out.println("test");
		g = new ShahanGraphics();
		GameLoop();
	}
	void GameLoop() {
		long lastUpdateTime = System.currentTimeMillis();
		while(true) {
			if(System.currentTimeMillis() - lastUpdateTime >  timeBetweenFrames) {
				lastUpdateTime = System.currentTimeMillis();
				LangtonsAnt.UpdateGame();
				g.UpdateGame();
			}
		}
	}

}
