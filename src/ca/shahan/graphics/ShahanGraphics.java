package ca.shahan.graphics;

import java.awt.*;
import javax.swing.*;

import ca.shahan.Main;
import ca.shahan.logic.LangtonsAnt;


public class ShahanGraphics {
	private JPanel j;
	public ShahanGraphics() {
		JFrame f = new JFrame();
		f.setSize(1000,1000);
		f.setTitle("Shahan's LangtonsAnt");
		
		j = new CellPanel();
		j.setBackground(Color.RED);
		f.add(j);
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		

	}
	
	public void UpdateGame() {
		j.repaint();
	}
	
}
