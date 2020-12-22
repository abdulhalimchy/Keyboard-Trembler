package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class NewPasswordRecovery {
		
	JFrame testFrame;
	JPanel newPasswordRecoveryPanel;
	JLabel passwordRecoveryLabel, newPasswordLabel, confirmNewPasswordLabel, newPasswordEx, confirmPasswordEx;
	JTextField  confirmPasswordTextFieldNewPasswordRecoveryClass;
	JPasswordField passwordField;
	JButton doneButtonNewPasswordRecoveryClass;
	JLabel labelPasswordWarning, labelPassNotMatchWarning, rectangleBorderLabel;
	int userId;
	
	Database database;
	public NewPasswordRecovery() {
		
		database = new Database();
		
		//..............................
		//...........LABEL..............
		//..............................
		
		rectangleBorderLabel = new JLabel(new ImageIcon("rectangleBorder7.png"));
		rectangleBorderLabel.setBounds(0, 0, 880, 590);
		
		
		labelPasswordWarning = new JLabel("Too short");
		labelPasswordWarning.setBounds(650, 175, 200, 30);
		labelPasswordWarning.setForeground(Color.RED);
		
		
//		labelPassNotMatchWarning = new JLabel("Password not match");
//		labelPassNotMatchWarning.setBounds(650, 160, 200, 30);
//		labelPassNotMatchWarning.setForeground(Color.RED);
		
		
		passwordRecoveryLabel = new JLabel("Password recovery");
		passwordRecoveryLabel.setBounds(350, 100, 200, 40);
		passwordRecoveryLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordRecoveryLabel.setForeground(Color.decode("125569800"));
		
//		confirmNewPasswordLabel = new JLabel("Confirm Password   :");
//		confirmNewPasswordLabel.setBounds(200, 160, 150, 40);
//		confirmNewPasswordLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
//		confirmNewPasswordLabel.setForeground(Color.black);
		
		newPasswordLabel = new JLabel("New Password         :");
		newPasswordLabel.setBounds(200, 170, 150, 40);
		newPasswordLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		newPasswordLabel.setForeground(Color.black);
		
		//.............................
		//........Example Label........
		//.............................
		newPasswordEx = new JLabel("Password must contains more than 5 characters");
		newPasswordEx.setBounds(362, 195, 250, 40);
		newPasswordEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		newPasswordEx.setForeground(Color.black);
		
		//.............................
		//.........TEXTFIELD...........
		//.............................
//		confirmPasswordTextFieldNewPasswordRecoveryClass = new JTextField();
//		confirmPasswordTextFieldNewPasswordRecoveryClass.setBounds(360, 163, 250, 35);
//		confirmPasswordTextFieldNewPasswordRecoveryClass.setBorder(new LineBorder(Color.gray, 2));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(360, 173, 250, 35);
		passwordField.setBorder(new LineBorder(Color.gray, 2));
		
		//.............................
		//...........Button............
		//.............................
		doneButtonNewPasswordRecoveryClass = new JButton(new ImageIcon("done1.png"));
		doneButtonNewPasswordRecoveryClass.setBounds(400, 250, 80, 30);
		
		//.........PANEL...............
		newPasswordRecoveryPanel = new JPanel();
		newPasswordRecoveryPanel.setPreferredSize(new Dimension(880, 590));
		newPasswordRecoveryPanel.setLayout(null);
		newPasswordRecoveryPanel.setBackground(Color.white);
		
		
		//...........Adding to Panel............
		newPasswordRecoveryPanel.add(passwordRecoveryLabel);
		newPasswordRecoveryPanel.add(newPasswordLabel);
//		newPasswordRecoveryPanel.add(confirmNewPasswordLabel);
		
		newPasswordRecoveryPanel.add(newPasswordEx);
		
		newPasswordRecoveryPanel.add(passwordField);
//		newPasswordRecoveryPanel.add(confirmPasswordTextFieldNewPasswordRecoveryClass);
		
		newPasswordRecoveryPanel.add(doneButtonNewPasswordRecoveryClass);
//		newPasswordRecoveryPanel.add(labelPassNotMatchWarning);
		newPasswordRecoveryPanel.add(labelPasswordWarning);
		newPasswordRecoveryPanel.add(rectangleBorderLabel);
		
		
		
		//............Password......................
		passwordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkPassword();
			}
				
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	
		//................Action Listeners..........
		
		
		
		//Calling all types  of method/.........
		setInitial();
		
//		testFrame  = new JFrame();
//		testFrame.setSize(900,  700);
//		testFrame.setLayout(new GridBagLayout());
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
		
	}
	
	public boolean checkPassword(){
		String password = String.valueOf(passwordField.getPassword());
		System.out.println(password);
		int len = password.length();
		if(len<6)
		{
			labelPasswordWarning.setText("Too short");
			labelPasswordWarning.setVisible(true);
			return false;
		}
		else if(len>32)
		{
			labelPasswordWarning.setText("Too long");
			labelPasswordWarning.setVisible(true);
			return false;
		}
		
		labelPasswordWarning.setVisible(false);
		return true;
	}
	
	public void setInitial()
	{
		labelPasswordWarning.setText("");
		passwordField.setText("");
		labelPasswordWarning.setVisible(false);
	}
//	public static void main(String[] args) {
//		new NewPasswordRecovery();
//	}

}
