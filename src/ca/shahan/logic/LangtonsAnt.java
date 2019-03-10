package ca.shahan.logic;

import java.util.ArrayList;

import ca.shahan.Main;

public class LangtonsAnt {
	public static boolean[][] board= new boolean[Main.gameWidth][Main.gameHeight]; 
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	static int antX = 300;
	static int antY = 300;
	static int antDirection = 0;
	public static ArrayList<int[]> toBeUpdated = new ArrayList<int[]>();
	public static void UpdateGame() {
		
		if(board[antX][antY]) {
			antDirection += 1;
			antDirection = (antDirection>3)? 0 : antDirection;
		}else if(!board[antX][antY]) {
			antDirection -= 1;
			antDirection = (antDirection<0)? 3 : antDirection;
		}
		
		board[antX][antY] = !board[antX][antY];
		toBeUpdated.add(new int[] {antX,antY});
		switch(antDirection) {
			case NORTH:	
				antY--;
				break;
			case EAST:
				antX++;
				break;
			case SOUTH:
				antY++;
				break;
			case WEST:
				antX--;
		}
			
	}
}
