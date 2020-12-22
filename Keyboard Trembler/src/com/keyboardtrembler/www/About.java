package com.keyboardtrembler.www;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class About {
	
	JFrame testFrame;
	JPanel aboutPanel;
	JLabel rectangleBorderLabel, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JButton backButtonAboutClass;
	public About() {
		
		
		
		rectangleBorderLabel = new JLabel(new ImageIcon("rectangleBorder7.png"));
		rectangleBorderLabel.setBounds(0, 0, 880, 590);
		
		//...................Button...................
		backButtonAboutClass = new JButton(new ImageIcon("back1.png"));
		backButtonAboutClass.setBounds(420, 450, 45, 25);
		
		
		//................Label.................
		l1 = new JLabel("About");
		l1.setBounds(420, 50, 100, 30);
		l1.setFont(new Font("Dialog", Font.BOLD, 18));
		l1.setForeground(Color.decode("125569800"));
		
		l2 = new JLabel("This application is developed by ABDUL HALIM CHOWDHURY on purpose of Project-200");
		l2.setBounds(130, 80, 850, 30);
		l2.setFont(new Font("Dialog", Font.BOLD, 14));
		l2.setForeground(Color.black);
		
		l3 = new JLabel("ID : 161-115-044");
		l3.setBounds(390, 100, 200, 30);
		l3.setFont(new Font("Dialog", Font.PLAIN, 14));
		l3.setForeground(Color.black);
		
		l4 = new JLabel("Batch : 38th B");
		l4.setBounds(395, 120, 200, 30);
		l4.setFont(new Font("Dialog", Font.PLAIN, 14));
		l4.setForeground(Color.black);
		
		l5 = new JLabel("Metropolitan University, Sylhet");
		l5.setBounds(340, 140, 300, 30);
		l5.setFont(new Font("Dialog", Font.PLAIN, 14));
		l5.setForeground(Color.black);
		
	
		l6 = new JLabel("Submitted to");
		l6.setBounds(400, 180, 100, 30);
		l6.setFont(new Font("Dialog", Font.BOLD, 15));
		l6.setForeground(Color.decode("125569800"));
	
		l7 = new JLabel("Arif Ahmed");
		l7.setBounds(300, 200, 200, 30);
		l7.setFont(new Font("Dialog", Font.BOLD, 14));
		l7.setForeground(Color.black);
		
		l8 = new JLabel("Lecturer, Department of Computer Science and Engineering");
		l8.setBounds(300, 220, 600, 30);
		l8.setFont(new Font("Dialog", Font.PLAIN, 14));
		l8.setForeground(Color.black);
		
		l9 = new JLabel("Metropolitan University, Sylhet");
		l9.setBounds(300, 240, 600, 30);
		l9.setFont(new Font("Dialog", Font.PLAIN, 14));
		l9.setForeground(Color.black);
		
		l10 = new JLabel("If you found any bug, please inform me : keyboard_trembler@outlook.com");
		l10.setBounds(15, 530, 800, 30);
		l10.setFont(new Font("Dialog", Font.BOLD, 12));
		l10.setForeground(Color.black);
		
		l11 = new JLabel("Copyright © 2017");
		l11.setBounds(750, 530, 100, 30);
		l11.setFont(new Font("Dialog", Font.PLAIN, 12));
		l11.setForeground(Color.black);
		
		l12 = new JLabel("");
		l12.setBounds(420, 20, 100, 30);
		l12.setFont(new Font("Dialog", Font.BOLD, 18));
		l12.setForeground(Color.decode("12345687"));
	
		
		
		//............Panel...............
		aboutPanel = new JPanel();
		aboutPanel.setPreferredSize(new Dimension(880, 590));
		aboutPanel.setLayout(null);
		aboutPanel.setBackground(Color.WHITE);
		aboutPanel.add(rectangleBorderLabel);
		aboutPanel.add(backButtonAboutClass);
		aboutPanel.add(l1);
		aboutPanel.add(l2);
		aboutPanel.add(l3);
		aboutPanel.add(l4);
		aboutPanel.add(l5);
		aboutPanel.add(l6);
		aboutPanel.add(l7);
		aboutPanel.add(l8);
		aboutPanel.add(l9);
		aboutPanel.add(l10);
		aboutPanel.add(l11);
		aboutPanel.add(l12);
		
		
		
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridBagLayout());
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(aboutPanel);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
	}
//	
//	public static void main(String[] args) {
//		new About();
//	}
	
}
