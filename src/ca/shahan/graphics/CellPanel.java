package ca.shahan.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import ca.shahan.Main;
import ca.shahan.logic.LangtonsAnt;

public class CellPanel extends JPanel{
	
	float scale = 1.2f;
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Rectangle r = g.getClipBounds();
		Dimension d = new Dimension(1000,1000);
//		g.setColor(Color.BLUE);
//		g.fillRect(10,10,d.width-20,d.height-20)  ;
		for(int i = 0; i < Main.gameWidth; i++) {
			for (int j = 0 ; j <Main.gameHeight; j++) {
				boolean state = LangtonsAnt.board[i][j];
				if(state) {
					g.setColor(Color.BLACK);
				}else {
					g.setColor(Color.RED);
				}
//				g.fillRect((int)(i*(d.getWidth()/Main.gameWidth)), 
//						(int)(j* (d.getHeight()/Main.gameHeight)), 
//						(int)(d.getWidth()/Main.gameWidth),
//						(int)(d.getHeight()/Main.gameHeight));
			}
		}
		for(int i = 0; i < LangtonsAnt.toBeUpdated.size(); i++) {
	
	 	
			int[] tile = LangtonsAnt.toBeUpdated.get(i);
	 		boolean state = LangtonsAnt.board[tile[0]][tile[1]];
				if(state) {
					g.setColor(Color.BLACK);
				}else {
					g.setColor(Color.RED);
				}
			g.fillRect((int)(tile[0]*(d.getWidth()/Main.gameWidth)), 
					(int)(tile[1]* (d.getHeight()/Main.gameHeight)), 
					(int)(d.getWidth()/Main.gameWidth),
					(int)(d.getHeight()/Main.gameHeight));
//			LangtonsAnt.toBeUpdated.remove(i);
		}
		
	}
	
}
 