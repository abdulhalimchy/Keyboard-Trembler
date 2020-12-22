package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class PasswordRecovery {
		
	JFrame testFrame;
	JPanel passwordRecoveryPanel;
	JLabel passwordRecoveryLabel, rectangleBorderLabel, usernameEx, emailEx, dateOfBirthEx, question1Ex, question2Ex, usernameLabel, emailLabel, dateOfBirthLabel, question1Label, question2Label;
	JTextField usernameTextFieldPasswordRecoveryClass, emailTextFieldPasswordRecoveryClass, dateOfBirthTextFieldPasswordRecoveryClass, question1TextFieldPasswordRecoveryClass, question2TextFieldPasswordRecoveryClass;
	JButton sendRequestButtonPasswordRecoveryClass, cancelButtonPasswordRecoveryClass;
	
	public PasswordRecovery() {
		
		
		//..............................
		//...........LABEL..............
		//..............................
		
		rectangleBorderLabel = new JLabel(new ImageIcon("rectangleBorder7.png"));
		rectangleBorderLabel.setBounds(0, 0, 880, 590);
		
		
		passwordRecoveryLabel = new JLabel("Password recovery");
		passwordRecoveryLabel.setBounds(375, 30, 200, 40);
		passwordRecoveryLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordRecoveryLabel.setForeground(Color.decode("125569800"));
		
		usernameLabel = new JLabel("Username                 : ");
		usernameLabel.setBounds(250, 160, 150, 40);
		usernameLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		usernameLabel.setForeground(Color.black);
		
		emailLabel = new JLabel("Email                         : ");
		emailLabel.setBounds(250, 100, 150, 40);
		emailLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		emailLabel.setForeground(Color.black);
		
		dateOfBirthLabel = new JLabel("Date of Birth             :");
		dateOfBirthLabel.setBounds(250, 220, 150, 40);
		dateOfBirthLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		dateOfBirthLabel.setForeground(Color.black);
		
		question1Label = new JLabel("1.The Country you like most?");
		question1Label.setBounds(252, 280, 290, 40);
		question1Label.setFont(new Font("Gill Sans", Font.BOLD, 11));
		question1Label.setForeground(Color.black);
		
		question2Label = new JLabel("1.Your favorite game?");
		question2Label.setBounds(493, 280, 290, 40);
		question2Label.setFont(new Font("Gill Sans", Font.BOLD, 11));
		question2Label.setForeground(Color.black);
		
		//.............................
		//........Example Label........
		//.............................
		emailEx = new JLabel("Ex: example@gmail.com");
		emailEx.setBounds(412, 125, 140, 40);
		emailEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		emailEx.setForeground(Color.black);
		
		usernameEx = new JLabel("Ex: abdulhalimchy");
		usernameEx.setBounds(412, 185, 140, 40);
		usernameEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		usernameEx.setForeground(Color.black);
		
		dateOfBirthEx = new JLabel("Ex: 1990-09-23 (Format: YYYY-MM-DD)");
		dateOfBirthEx.setBounds(412, 245, 200, 40);
		dateOfBirthEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		dateOfBirthEx.setForeground(Color.black);
		
		question1Ex = new JLabel("Ex: Bangladesh");
		question1Ex.setBounds(252, 332, 290, 40);
		question1Ex.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		question1Ex.setForeground(Color.black);
		
		question2Ex = new JLabel("Ex: Football");
		question2Ex.setBounds(493, 332, 290, 40);
		question2Ex.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		question2Ex.setForeground(Color.black);
		
		//.............................
		//.........TEXTFIELD...........
		//.............................
		usernameTextFieldPasswordRecoveryClass = new JTextField();
		usernameTextFieldPasswordRecoveryClass.setBounds(410, 163, 250, 35);
		usernameTextFieldPasswordRecoveryClass.setBorder(new LineBorder(Color.gray, 2));
		
		emailTextFieldPasswordRecoveryClass = new JTextField();
		emailTextFieldPasswordRecoveryClass.setBounds(410, 103, 250, 35);
		emailTextFieldPasswordRecoveryClass.setBorder(new LineBorder(Color.gray, 2));
		
		dateOfBirthTextFieldPasswordRecoveryClass = new JTextField();
		dateOfBirthTextFieldPasswordRecoveryClass.setBounds(410, 223, 250, 35);
		dateOfBirthTextFieldPasswordRecoveryClass.setBorder(new LineBorder(Color.gray, 2));
		
		question1TextFieldPasswordRecoveryClass = new JTextField();
		question1TextFieldPasswordRecoveryClass.setBounds(250, 310, 170, 35);
		question1TextFieldPasswordRecoveryClass.setBorder(new LineBorder(Color.gray, 2));
		
		question2TextFieldPasswordRecoveryClass = new JTextField();
		question2TextFieldPasswordRecoveryClass.setBounds(491, 310, 170, 35);
		question2TextFieldPasswordRecoveryClass.setBorder(new LineBorder(Color.gray, 2));
		
		//.............................
		//...........Button............
		//.............................
		sendRequestButtonPasswordRecoveryClass = new JButton(new ImageIcon("sendRequest1.png"));
		sendRequestButtonPasswordRecoveryClass.setBounds(387, 400, 135, 30);
		
//		cancelButtonPasswordRecoveryClass = new JButton("Cancel");
//		cancelButtonPasswordRecoveryClass.setBackground(Color.white);
		cancelButtonPasswordRecoveryClass = new JButton(new ImageIcon("cancel2.png"));
		cancelButtonPasswordRecoveryClass.setBounds(425, 435, 60, 28);
		cancelButtonPasswordRecoveryClass.setBorderPainted(false);
		
		//.........PANEL...............
		passwordRecoveryPanel = new JPanel();
		passwordRecoveryPanel.setPreferredSize(new Dimension(880, 590));
		passwordRecoveryPanel.setLayout(null);
		passwordRecoveryPanel.setBackground(Color.white);
		
		
		//...........Adding to Panel............
		
		passwordRecoveryPanel.add(rectangleBorderLabel);
		
		passwordRecoveryPanel.add(passwordRecoveryLabel);
		passwordRecoveryPanel.add(usernameLabel);
		passwordRecoveryPanel.add(emailLabel);
		passwordRecoveryPanel.add(dateOfBirthLabel);
		
		passwordRecoveryPanel.add(emailEx);
		passwordRecoveryPanel.add(usernameEx);
		passwordRecoveryPanel.add(dateOfBirthEx);
		passwordRecoveryPanel.add(question1Ex);
		passwordRecoveryPanel.add(question2Ex);
		
		passwordRecoveryPanel.add(question1Label);
		passwordRecoveryPanel.add(question2Label);
		
		passwordRecoveryPanel.add(usernameTextFieldPasswordRecoveryClass);
		passwordRecoveryPanel.add(emailTextFieldPasswordRecoveryClass);
		passwordRecoveryPanel.add(dateOfBirthTextFieldPasswordRecoveryClass);
		passwordRecoveryPanel.add(question1TextFieldPasswordRecoveryClass);
		passwordRecoveryPanel.add(question2TextFieldPasswordRecoveryClass);
		
		passwordRecoveryPanel.add(sendRequestButtonPasswordRecoveryClass);
		passwordRecoveryPanel.add(cancelButtonPasswordRecoveryClass);
		
		
		
		
//		testFrame  = new JFrame();
//		testFrame.setSize(900,  700);
//		testFrame.setLayout(new GridBagLayout());
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		testFrame.add(passwordRecoveryPanel, new GridBagConstraints());
		
		
		cancelButtonPasswordRecoveryClass.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				cancelButtonPasswordRecoveryClass.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cancelButtonPasswordRecoveryClass.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
//	public static void main(String[] args) {
//		new PasswordRecovery();
//	}

}
