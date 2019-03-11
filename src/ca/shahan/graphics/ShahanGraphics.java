package ca.shahan.graphics;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ca.shahan.Main;
import ca.shahan.logic.LangtonsAnt;


public class ShahanGraphics {
	private CellPanel j;
	public ShahanGraphics() {
		JFrame f = new JFrame();
		JSlider s = new JSlider(1,10);
		s.setInverted(true);
		s.addChangeListener(new ChangeListener() {
			 public void stateChanged(ChangeEvent e) {
				 Main.timeBetweenFrames = (long) Math.pow(10, s.getValue());
				 
			 }
			
		});
		f.setSize(1000,1000);
		f.setTitle("Shahan's LangtonsAnt");
		Dimension d = new Dimension(1000,1000);
		JPanel backP = new JPanel(new BorderLayout());
		j = new CellPanel();
		

		
		
		j.setBackground(Color.RED);
		
	
		
//		JLabel label = new JLabel();
//		j.add(label);
		j.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		    	  System.out.println("GOT CLICK" + System.currentTimeMillis());
		    	int x = e.getX();
		        int y = e.getY();
		        
		        int bx =(int) ((float)Main.gameWidth/d.getWidth()    *  x ) ;
		      
		        int by = (int) ((float)Main.gameWidth/d.getHeight() * y);
//		        LangtonsAnt.board[bx][by] = !LangtonsAnt.board[bx][by];
//		        LangtonsAnt.toBeUpdated.add(new int[] {bx,by});
		        LangtonsAnt.ants.add(new int[] {bx,by,0});
//		        label.setText("X: "+bx+" \t Y: "+by); // this sets the JLabel's text
//		        label.setBounds(x, y, label.getText().length()*2, 20);
		    }
		});
		backP.add(s,BorderLayout.PAGE_START);
		backP.add(j,BorderLayout.CENTER);
		f.add(backP);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		

	}
	
	public void UpdateGame() {
		j.UpdateGUI();
		j.repaint();
	}
	
}
