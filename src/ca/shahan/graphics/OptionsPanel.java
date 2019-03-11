package ca.shahan.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;

public class OptionsPanel extends JFrame{
	public OptionsPanel() {
		setSize(500,500);

		JPanel panel = new JPanel();
		JCheckBox colorCheckbox = new JCheckBox("MultiColor");
		colorCheckbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CellPanel.color = !CellPanel.color;
				
				System.out.println(CellPanel.color);
				
			}
			
		});
		
		JColorChooser colorChooser = new JColorChooser();
		
//		colorChooser.setChooserPanels(new AbstractColorChooserPanel());
		
		panel.add(colorChooser);
		panel.add(colorCheckbox);
//		setAlwaysOnTop(true);
		add(panel);
		
		setVisible(true);
	}
}
