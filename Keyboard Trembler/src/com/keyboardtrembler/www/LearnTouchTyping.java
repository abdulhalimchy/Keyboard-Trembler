package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class LearnTouchTyping {

	JFrame testFrame;
	JPanel learnTouchTypingPanel;
	UpperLayout upperLayoutObj;
	public LearnTouchTyping() {
		
		upperLayoutObj = new UpperLayout();
		
		//.............Label..............
		upperLayoutObj.labelProfileName.setText("Salman Chowdhury  ");
		upperLayoutObj.labelPanelTitleName.setIcon(new ImageIcon("learnTouchTyping1.png"));
		
		
		//................................
		//............Panel...............
		//................................
		learnTouchTypingPanel = new JPanel();
		learnTouchTypingPanel.setBackground(Color.white);
		learnTouchTypingPanel.setLayout(new BorderLayout());
		
		new BorderLayout();
		learnTouchTypingPanel.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		learnTouchTypingPanel.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(learnTouchTypingPanel);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
	}
	
//	public static void main(String[] args) {
//		new LearnTouchTyping();
//	}

}
