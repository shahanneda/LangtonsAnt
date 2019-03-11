package ca.shahan.graphics;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ca.shahan.Main;
import ca.shahan.logic.LangtonsAnt;


public class ShahanGraphics {
	private JPanel j;
	public ShahanGraphics() {
		JFrame f = new JFrame();
		f.setSize(1000,1000);
		f.setTitle("Shahan's LangtonsAnt");
		Dimension d = new Dimension(1000,1000);
		j = new CellPanel();
		j.setBackground(Color.RED);
		f.add(j);
//		JLabel label = new JLabel();
//		j.add(label);
		j.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	  System.out.println("GOT CLICK" + System.currentTimeMillis());
		    	int x = e.getX();
		        int y = e.getY();
		        
		        int bx =(int) ((float)Main.gameWidth/d.getWidth()    *  x ) ;
		      
		        int by = (int) ((float)Main.gameWidth/d.getHeight() * y);
		        LangtonsAnt.board[bx][by] = !LangtonsAnt.board[bx][by];
		        LangtonsAnt.toBeUpdated.add(new int[] {bx,by});
//		        label.setText("X: "+bx+" \t Y: "+by); // this sets the JLabel's text
//		        label.setBounds(x, y, label.getText().length()*2, 20);
		    }
		});
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		

	}
	
	public void UpdateGame() {
		j.repaint();
	}
	
}
