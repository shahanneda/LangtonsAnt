package ca.shahan.graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		//MENU
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("Options");
		menuItem = new JMenuItem("Options");
		
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ACTION");
				OptionsPanel options = new OptionsPanel();
				
				
			}
			
			
		});
//		menu.setMnemonic(KeyEvent.VK_A);
//		menu.getAccessibleContext().setAccessibleDescription(
//		        "The only menu in this program that has menu items");
		menu.add(menuItem);
		menuBar.add(menu);
		
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
		        LangtonsAnt.ants.add(new int[] {bx,by,0,(int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)});
//		        label.setText("X: "+bx+" \t Y: "+by); // this sets the JLabel's text
//		        label.setBounds(x, y, label.getText().length()*2, 20);
		    }
		});
		backP.add(s,BorderLayout.PAGE_START);
		backP.add(j,BorderLayout.CENTER);
		f.setJMenuBar(menuBar);
		f.add(backP);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		

	}
	
	public void UpdateGame() {
		j.UpdateGUI();
		j.repaint();
	}
	
}
