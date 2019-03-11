package ca.shahan.logic;

import java.util.ArrayList;

import ca.shahan.Main;

public class LangtonsAnt {
	public static boolean[][] board= new boolean[Main.gameWidth][Main.gameHeight]; 
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	/*
	 * All of the ants:
	 * 
	 * arr[0] should be x,
	 * arr[1] should be y
	 * arr[2] should be direction
 	 */
	public static ArrayList<int[]> ants = new ArrayList<int[]>();

	public static ArrayList<int[]> toBeUpdated = new ArrayList<int[]>();
	public static void UpdateGame() {
		for(int i = 0; i < ants.size(); i++) {
			int[] ant = ants.get(i);
			int antX = ant[0];
			int antY = ant[1];
			int antDirection = ant[2];
			if(antX > Main.gameWidth-1 || antY > Main.gameHeight-1 || antX < 0 || antY < 0) {
				ants.remove(i);
				continue;
			}
			if(board[antX][antY]) {
				antDirection += 1;
				antDirection = (antDirection>3)? 0 : antDirection;
			}else if(!board[antX][antY]) {
				antDirection -= 1;
				antDirection = (antDirection<0)? 3 : antDirection;
			}
			
			board[antX][antY] = !board[antX][antY];
			toBeUpdated.add(new int[] {antX,antY,ant[3],ant[4],ant[5]});
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
			ants.set(i, new int[] {antX,antY,antDirection,ant[3],ant[4],ant[5]});
				
		}
		
	}
}
