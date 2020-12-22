package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Welcome{

	JFrame testFrame;
	JPanel panelWelcome;
	JPasswordField passwordField;
	JTextField textFieldUsername;
	JButton buttonSignIn, buttonSignUp, buttonAbout, buttonExit, buttonForgotPassword;
	JLabel labelTitle, labelOr, labelUsernameHint, labelPasswordHint, labelRectangleBorder;
	int userId; String userName;

	Welcome(){
		
		//..................Label......................
		labelRectangleBorder = new JLabel(new ImageIcon("rectangleBorder7.png"));
		labelRectangleBorder.setBounds(0, 1, 880, 590);
		
		labelTitle = new JLabel(new ImageIcon("title2.png"));
		labelTitle.setBounds(35, 100, 800,100);
		
		labelOr = new JLabel(new ImageIcon("or.png"));
		labelOr.setBounds(35, 290, 800,100);
		
		labelUsernameHint = new JLabel("Username");
		labelUsernameHint.setBounds(185, 222, 150, 36);
		labelUsernameHint.setFont(new Font("Dialog", Font.BOLD, 14));
		
		labelPasswordHint = new JLabel("Password");
		labelPasswordHint.setBounds(415, 222, 100, 36);
		labelPasswordHint.setFont(new Font("Dialog", Font.BOLD, 14));
		
		//..........TextField...................
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(182, 250, 200, 33);
		textFieldUsername.setBorder(new LineBorder(Color.gray,2));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(412, 250, 200, 33);
		passwordField.setBorder(new LineBorder(Color.gray,2));
		
		
		
		//.................Button.......................
		buttonSignIn = new JButton(new ImageIcon("signin10.png"));
		buttonSignIn.setBounds(620, 250, 70, 32);
		
		buttonForgotPassword = new JButton(new ImageIcon("forgotPassword.png"));
		buttonForgotPassword.setBounds(415, 285, 135, 18);
		buttonForgotPassword.setBorderPainted(false);
		
		buttonSignUp = new JButton(new ImageIcon("signUp1.png"));
		buttonSignUp.setBounds(382, 385, 109, 38);
		buttonSignUp.setBorderPainted(false);
		
		buttonAbout = new JButton(new ImageIcon("about1.png"));
		buttonAbout.setBounds(390, 427, 95, 38);
		buttonAbout.setBorderPainted(false);
		
		buttonExit = new JButton(new ImageIcon("exit1.png"));
		buttonExit.setBounds(397, 469, 77, 38);
		buttonExit.setBorderPainted(false);
	
		
		panelWelcome = new JPanel();
		panelWelcome.setPreferredSize(new Dimension(880, 590));
		panelWelcome.setLayout(null);
		panelWelcome.setBackground(Color.white);
		
		panelWelcome.add(labelRectangleBorder);
		panelWelcome.add(labelTitle);
		panelWelcome.add(textFieldUsername);
		panelWelcome.add(passwordField);
		panelWelcome.add(labelUsernameHint);
		panelWelcome.add(labelPasswordHint);
		panelWelcome.add(buttonSignIn);
		panelWelcome.add(buttonForgotPassword);
		panelWelcome.add(labelOr);
		panelWelcome.add(buttonSignUp);
		panelWelcome.add(buttonAbout);
		panelWelcome.add(buttonExit);
		
		
//		testFrame  = new JFrame();
//		testFrame.setSize(900,  700);
//		testFrame.setLayout(new GridBagLayout());
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(testFrame.EXIT_ON_CLOSE);
//		testFrame.add(welcomePanel, new GridBagConstraints());
		
		
		//................................
		//........FORGOT PASSWORD.........
		//................................
		buttonForgotPassword.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				buttonForgotPassword.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonForgotPassword.setBorderPainted(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		//.............................
		//...........SIGN UP...........
		//.............................
		buttonSignUp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				buttonSignUp.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSignUp.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		//...............................
		//.........about.................
		//...............................
		buttonAbout.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAbout.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAbout.setBorderPainted(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		//................................
		//............EXIT................
		//................................
		buttonExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				buttonExit.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonExit.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
//	public static void main(String[] args) {
//		new WelcomeClass();
//	}

}
