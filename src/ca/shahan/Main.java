package ca.shahan;

import ca.shahan.graphics.ShahanGraphics;
import ca.shahan.logic.LangtonsAnt;

/**
 * @author shahan
 *
 */
public class Main {
	ShahanGraphics g;
	static public long timeBetweenFrames = 10000000;
	public static final int gameWidth = 1000;
	public static final int gameHeight = 1000;
	public static boolean Restart = true;
	public static void main(String[] args) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		while(Restart) {
			Restart = false;
			new Main();
		}
		
	}
	
	Main() {
		g = new ShahanGraphics();
//		LangtonsAnt.ants.add(new int[] {50,50,0});
//		LangtonsAnt.ants.add(new int[] {200,100,0});

		GameLoop();
	}
	void GameLoop() {
		long lastUpdateTime = System.nanoTime();
		
		while(true) {
			g.UpdateGame();
			
			if(System.nanoTime() - lastUpdateTime >  timeBetweenFrames) {
				
				lastUpdateTime = System.nanoTime();
				LangtonsAnt.UpdateGame();
			}
		}
		
	}

}
