package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpperLayout {
	JPanel panel1, panel2, panel3, panel4, panelUpperLine, panelNorth, panelCenter, panelInsideNorth, panelInsideCenterPanel, panelInsideNorthPanel1, panelInsideNorthPanel2;
	JLabel labelPanelTitleName;
	JLabel labelProfileName;
	public UpperLayout() {
		
		labelPanelTitleName = new JLabel();
		labelPanelTitleName.setForeground(Color.decode("125569800"));
		labelPanelTitleName.setFont(new Font("Dialog", Font.BOLD, 15));
		
		labelProfileName = new JLabel();
		labelProfileName.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
//		panel1.setBackground(Color.WHITE);
		panel1.add(labelPanelTitleName);
		
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
new BorderLayout();
		//		panel2.setBackground(Color.WHITE);
		panel2.add(labelProfileName, BorderLayout.EAST);
		
		
		panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension(880, 25));
		panel4.setBackground(Color.white);
		panel4.setLayout(null);
		
		panel3 = new JPanel();
		panel3.setBounds(0, 5, 4000, 25);
		panel3.setLayout(new GridBagLayout());
		panel3.setBackground(Color.white);
		
		panel3.add(panel4);
		
		
		panelUpperLine = new JPanel();
		panelUpperLine.setBounds(0, 0, 4000, 1);
		panelUpperLine.setLayout(null);
		panelUpperLine.setBackground(Color.LIGHT_GRAY);
		
		panelInsideNorthPanel1 = new JPanel();
//		panelInsideNorthPanel1.setBackground(Color.white);
		panelInsideNorthPanel1.setLayout(new GridLayout(1,3));
		panelInsideNorthPanel1.add(new JLabel(""));
		panelInsideNorthPanel1.add(panel1);
		panelInsideNorthPanel1.add(panel2);
		
		
		panelInsideNorthPanel2 = new JPanel();
		panelInsideNorthPanel2.setBackground(Color.white);
		panelInsideNorthPanel2.setLayout(new BorderLayout());
new BorderLayout();
		//		panelInsideNorthPanel2.add(upperLinePanel);
//		panelInsideNorthPanel2.add(panel3);
		panelInsideNorthPanel2.add(panelUpperLine, BorderLayout.NORTH);		
		new BorderLayout();
		panelInsideNorthPanel2.add(panel3, BorderLayout.CENTER);
		
		
		panelInsideNorth = new JPanel();
		panelInsideNorth.setBackground(Color.white);
		panelInsideNorth.setPreferredSize(new Dimension(0, 60));
		panelInsideNorth.setLayout(new GridLayout(2, 1));
		panelInsideNorth.add(panelInsideNorthPanel1);
		panelInsideNorth.add(panelInsideNorthPanel2);
		
		panelInsideCenterPanel = new JPanel();
		panelInsideCenterPanel.setPreferredSize(new Dimension(880, 590));
		panelInsideCenterPanel.setBackground(Color.white);
		panelInsideCenterPanel.setLayout(null);
		
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.white);
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.add(panelInsideCenterPanel, new GridBagConstraints());
	}
	
}
