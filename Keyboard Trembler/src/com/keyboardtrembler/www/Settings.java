package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Settings extends Database{
	JFrame testFrame;
	JPanel settingsPanel;
	private JLabel rectangleBorderLabel, nameLabel, emailLabel, dateOfBirthLabel, currentPasswordLabel, newPasswordLabel, confirmPasswordLabel, nameEx, emailEx, dateOfBirthEx, newPasswordEx;
	JTextField nameTextFieldSettingsClass, emailTextFieldSettingsClass, dateOfBirthTextFieldSettingsClass;
	JButton updateButtonSettingsClass, changePasswordButtonSettingsClass, backButtonSettingsClass, deleteAccountButtonSettingsClass;
	UpperLayout upperLayoutObj;
	JPasswordField newPasswordField, currentPasswordField, confirmPasswordField;
	int userId;
	JLabel labelNameWarning, labelEmailWarning, labelDateOfBirthWarning, labelPasswordWarning, labelConfirmPasswordWarning, labelPasswordNotMatch;
	
	//......constructor......
	public Settings() {
		upperLayoutObj = new UpperLayout();

		userId=0;
		
		//................................
		//.............LABEL..............
		//................................
		
//		labelPleaseFillUpAllFields = new JLabel("Please fill up all the fields!");
//		labelPleaseFillUpAllFields.setBounds(385, 470, 250, 30);
//		labelPleaseFillUpAllFields.setForeground(Color.RED);
		
		labelNameWarning = new JLabel("Too long");
		labelNameWarning.setBounds(670, 65, 200, 30);
		labelNameWarning.setForeground(Color.RED);
		
		labelEmailWarning = new JLabel("Invalid email");
		labelEmailWarning.setBounds(670, 125, 200, 30);
		labelEmailWarning.setForeground(Color.RED);
		
		
		labelDateOfBirthWarning = new JLabel("Invalid date format");
		labelDateOfBirthWarning.setBounds(670, 185, 200, 30);
		labelDateOfBirthWarning.setForeground(Color.RED);
		
		labelPasswordNotMatch = new JLabel("Incorrect password");
		labelPasswordNotMatch.setBounds(670, 315, 200, 30);
		labelPasswordNotMatch.setForeground(Color.RED);
		
		labelPasswordWarning = new JLabel("Too short");
		labelPasswordWarning.setBounds(670, 375, 200, 30);
		labelPasswordWarning.setForeground(Color.RED);
		
		labelConfirmPasswordWarning = new JLabel("Password not match");
		labelConfirmPasswordWarning.setBounds(670, 435, 200, 30);
		labelConfirmPasswordWarning.setForeground(Color.RED);
		
		
		rectangleBorderLabel = new JLabel(new ImageIcon("rectangleBorder7.png"));
		rectangleBorderLabel.setBounds(0, 0, 880, 590);
		
		upperLayoutObj.labelProfileName.setText("Abdul Halim Chy  ");
		upperLayoutObj.labelPanelTitleName.setText("Settings");
		
		nameLabel = new JLabel("Name                        : ");
		nameLabel.setBounds(215, 60, 150, 40);
		nameLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		nameLabel.setForeground(Color.black);
		
		emailLabel = new JLabel("Email                         : ");
		emailLabel.setBounds(215, 120, 150, 40);
		emailLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		emailLabel.setForeground(Color.black);
		
		dateOfBirthLabel = new JLabel("Date of Birth            : ");
		dateOfBirthLabel.setBounds(215, 180, 150, 40);
		dateOfBirthLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		dateOfBirthLabel.setForeground(Color.black);
		
		currentPasswordLabel = new JLabel("Current Password   :");
		currentPasswordLabel.setBounds(215, 310, 150, 40);
		currentPasswordLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		currentPasswordLabel.setForeground(Color.black);
		
		newPasswordLabel = new JLabel("New Password         : ");
		newPasswordLabel.setBounds(215, 370, 150, 40);
		newPasswordLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		newPasswordLabel.setForeground(Color.black);
		
		confirmPasswordLabel = new JLabel("Confirm Password   : ");
		confirmPasswordLabel.setBounds(215, 430, 150, 40);
		confirmPasswordLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		confirmPasswordLabel.setForeground(Color.black);
		
		//...........Example Label..........
		nameEx = new JLabel("Ex: Abdul Halim Chy");
		nameEx.setBounds(377, 85, 140, 40);
		nameEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		nameEx.setForeground(Color.black);
		
		emailEx = new JLabel("Ex: example@gmail.com");
		emailEx.setBounds(377, 145, 140, 40);
		emailEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		emailEx.setForeground(Color.black);
		
		dateOfBirthEx = new JLabel("Ex: 1990-09-23 (Format: YYYY-MM-DD)");
		dateOfBirthEx.setBounds(377, 205, 200, 40);
		dateOfBirthEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		dateOfBirthEx.setForeground(Color.black);
		
		newPasswordEx = new JLabel("Password must contains more than 5 characters");
		newPasswordEx.setBounds(377, 395, 270, 40);
		newPasswordEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		newPasswordEx.setForeground(Color.black);
		
		
		//..........................
		//........TEXTFIELD.........
		//..........................
		nameTextFieldSettingsClass = new JTextField();
		nameTextFieldSettingsClass.setBounds(375, 63, 250, 35);
		nameTextFieldSettingsClass.setBorder(new LineBorder(Color.gray, 2));
				
		emailTextFieldSettingsClass = new JTextField();
		emailTextFieldSettingsClass.setBounds(375, 123, 250, 35);
		emailTextFieldSettingsClass.setBorder(new LineBorder(Color.gray, 2));
				
		dateOfBirthTextFieldSettingsClass = new JTextField();
		dateOfBirthTextFieldSettingsClass.setBounds(375, 183, 250, 35);
		dateOfBirthTextFieldSettingsClass.setBorder(new LineBorder(Color.gray, 2));
				
		currentPasswordField = new JPasswordField();
		currentPasswordField.setBounds(375, 313, 250, 35);
		currentPasswordField.setBorder(new LineBorder(Color.gray, 2));
				
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(375, 373, 250, 35);
		newPasswordField.setBorder(new LineBorder(Color.gray, 2));
				
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(375, 433, 250, 35);
		confirmPasswordField.setBorder(new LineBorder(Color.gray, 2));		
		
		//.........................
		//...........BUTTON........
		//.........................
		
		updateButtonSettingsClass = new JButton(new ImageIcon("update5.png"));
		updateButtonSettingsClass.setBounds(377, 250, 100, 30);
		
		changePasswordButtonSettingsClass = new JButton(new ImageIcon("changePassword3.png"));
		changePasswordButtonSettingsClass.setBounds(340, 445, 180, 30);
		
		backButtonSettingsClass = new JButton(new ImageIcon("back1.png"));
		backButtonSettingsClass.setBounds(235, 450, 45, 22);
		backButtonSettingsClass.setBorderPainted(false);
		
		deleteAccountButtonSettingsClass = new JButton(new ImageIcon("deleteAccount2.png"));
		deleteAccountButtonSettingsClass.setBounds(555, 450, 116, 20);
		deleteAccountButtonSettingsClass.setBorderPainted(false);
		
		//.....................................
		//........Adding to center panel.......
		//.....................................
		upperLayoutObj.panelInsideCenterPanel.add(rectangleBorderLabel);
		
		upperLayoutObj.panelInsideCenterPanel.add(labelNameWarning);
		upperLayoutObj.panelInsideCenterPanel.add(labelEmailWarning);
		upperLayoutObj.panelInsideCenterPanel.add(labelDateOfBirthWarning);
		upperLayoutObj.panelInsideCenterPanel.add(labelPasswordWarning);
		upperLayoutObj.panelInsideCenterPanel.add(labelConfirmPasswordWarning);
		upperLayoutObj.panelInsideCenterPanel.add(labelPasswordNotMatch);
		
		
		upperLayoutObj.panelInsideCenterPanel.add(nameLabel);
		upperLayoutObj.panelInsideCenterPanel.add(emailLabel);
		upperLayoutObj.panelInsideCenterPanel.add(dateOfBirthLabel);
		upperLayoutObj.panelInsideCenterPanel.add(currentPasswordLabel);
		upperLayoutObj.panelInsideCenterPanel.add(newPasswordLabel);
//		upperLayoutObj.panelInsideCenterPanel.add(confirmPasswordLabel);
		
		upperLayoutObj.panelInsideCenterPanel.add(nameEx);
		upperLayoutObj.panelInsideCenterPanel.add(emailEx);
		upperLayoutObj.panelInsideCenterPanel.add(dateOfBirthEx);
		upperLayoutObj.panelInsideCenterPanel.add(newPasswordEx);
		
		upperLayoutObj.panelInsideCenterPanel.add(nameTextFieldSettingsClass);
		upperLayoutObj.panelInsideCenterPanel.add(emailTextFieldSettingsClass);
		upperLayoutObj.panelInsideCenterPanel.add(dateOfBirthTextFieldSettingsClass);
		upperLayoutObj.panelInsideCenterPanel.add(currentPasswordField);
		upperLayoutObj.panelInsideCenterPanel.add(newPasswordField);
//		upperLayoutObj.panelInsideCenterPanel.add(confirmPasswordField);
		
		upperLayoutObj.panelInsideCenterPanel.add(updateButtonSettingsClass);
		upperLayoutObj.panelInsideCenterPanel.add(backButtonSettingsClass);
		upperLayoutObj.panelInsideCenterPanel.add(changePasswordButtonSettingsClass);
		upperLayoutObj.panelInsideCenterPanel.add(deleteAccountButtonSettingsClass);		
		
		settingsPanel = new JPanel();
		settingsPanel.setBackground(Color.green);
		settingsPanel.setLayout(new BorderLayout());
		
		new BorderLayout();
		settingsPanel.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		settingsPanel.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		//........Calling all types of method.........
		setInitial();
		
//		testFrame  = new JFrame();
//		testFrame.setSize(900,  700);
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(settingsPanel);
		
		//................Action listeners
		updateButtonSettingsClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(isCorrectInfo()==true)
				{
					updateInfo();
					JOptionPane.showMessageDialog(settingsPanel, "Updated Successfully!");
				}
				else
					JOptionPane.showMessageDialog(settingsPanel, "Please fill the fields correctly");
			}
		});
		
		changePasswordButtonSettingsClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isOkPassword()==true)
				{
					String newPassword = String.valueOf(newPasswordField.getPassword());
					updatePassword(userId, newPassword);
					JOptionPane.showMessageDialog(settingsPanel, "Password changed successfully!");
				}
				else
					JOptionPane.showMessageDialog(settingsPanel, "Failed to change password!");
			}
		});
		
		//.........................KEY LISTENERS........................
		
		//........Name......
		nameTextFieldSettingsClass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				checkName();
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		
		//...........Email...........
		emailTextFieldSettingsClass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkEmail();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		
		
		//................DateOfBirth..........
		dateOfBirthTextFieldSettingsClass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkDateOfBirth();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		
		//.................currentPassword........
		currentPasswordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkCurrentPassword();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		
		//..........New password................
		newPasswordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkNewPassword();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		
		//...............Confirm password.........
		confirmPasswordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
//				checkConfirmPassword();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		
		
		deleteAccountButtonSettingsClass.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				deleteAccountButtonSettingsClass.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteAccountButtonSettingsClass.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		backButtonSettingsClass.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				backButtonSettingsClass.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				backButtonSettingsClass.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

	public boolean checkName(){
		String name = nameTextFieldSettingsClass.getText().trim().toUpperCase();
		int len = name.length(), flag=0;
		
		
		for(int i=0; i<len; i++)
		{
			if((name.charAt(i)>='A' && name.charAt(i)<='Z') || name.charAt(i)=='.' || name.charAt(i)=='-' || (flag==1 && name.charAt(i)==' '))
			{
				flag=1;
				continue;
			}
			else
			{
				labelNameWarning.setText("Invalid name format");
				labelNameWarning.setVisible(true);
				return false;
			}
		}
		
		if(len<3)
		{
			labelNameWarning.setText("Too short");
			labelNameWarning.setVisible(true);
			return false;
		}
		else if(len>25)
		{
			labelNameWarning.setText("Too long");
			labelNameWarning.setVisible(true);
			return false;
		}
		
		labelNameWarning.setVisible(false);
		return true;
	}
	
	public boolean checkEmail(){
		String email = emailTextFieldSettingsClass.getText().trim().toLowerCase();
		int len = email.length(), a=0, c=0, d=0, e=0;
		
		if(len<5 || len>60)
		{
			labelEmailWarning.setText("Invalid email");
			labelEmailWarning.setVisible(true);
			return false;
		}
		
		for(int i=0; i<len; i++)
		{
			if(email.charAt(i)>='a' && email.charAt(i)<='z' && c==0)
			{
				a=1;
				continue;
			}
			else if((email.charAt(i)>='0' && email.charAt(i)<='9' && a==1 && c==0) || ((email.charAt(i)=='-' || email.charAt(i)=='_' || email.charAt(i)=='.' ) && a==1 && c==0))
			{
				continue;
			}
			else if(email.charAt(i)=='@' && a==1)
			{
				c=1;
				continue;
			}
			if(email.charAt(i)>='a' && email.charAt(i)<='z' && c==1)
			{
				d=1;
				continue;
			}
			else if(d==1 && email.charAt(i)=='.')
			{
				e=1;
				continue;
			}
			else
			{
				labelEmailWarning.setText("Invalid email");
				labelEmailWarning.setVisible(true);
				return false;
			}
		}
		
		
		if((email.charAt(len-1)=='.') || (a!=1 || c!=1 || d!=1 || e!=1))
		{
			labelEmailWarning.setText("Invalid email");
			labelEmailWarning.setVisible(true);
			return false;
		}
		
		labelEmailWarning.setVisible(false);
		return true;
	}
	
	public boolean checkDateOfBirth(){
		String dateOfBirth = dateOfBirthTextFieldSettingsClass.getText().trim();
		int len = dateOfBirth.length();
		if(len<10 || len>10)
		{
			labelDateOfBirthWarning.setText("Invalid date format");
			labelDateOfBirthWarning.setVisible(true);
			return false;
		}
		
		for(int i=0; i<4; i++)
		{
			if(dateOfBirth.charAt(i)<'0' || dateOfBirth.charAt(i)>'9')
			{
				labelDateOfBirthWarning.setText("Invalid date format");
				labelDateOfBirthWarning.setVisible(true);
				return false;
			}
		}
		
		if( dateOfBirth.charAt(4)!='-' || dateOfBirth.charAt(7)!='-' || (dateOfBirth.charAt(5)<'0' || dateOfBirth.charAt(5)>'9') || (dateOfBirth.charAt(6)<'0' || dateOfBirth.charAt(6)>'9') || (dateOfBirth.charAt(8)<'0' || dateOfBirth.charAt(8)>'9') || (dateOfBirth.charAt(9)<'0' || dateOfBirth.charAt(9)>'9'))
		{
			labelDateOfBirthWarning.setText("Invalid date format");
			labelDateOfBirthWarning.setVisible(true);
			return false;
		}
		
		labelDateOfBirthWarning.setVisible(false);
		return true;
	}
	
	public boolean checkNewPassword(){
		String password = String.valueOf(newPasswordField.getPassword());
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
	
	public boolean checkCurrentPassword()
	{
		String password = String.valueOf(currentPasswordField.getPassword());
		if(isPasswordCorrect(userId, password)==true)
		{
			labelPasswordNotMatch.setVisible(false);
			return true;
		}
		else
		{
			labelPasswordNotMatch.setVisible(true);
			return false;
		}
	}
	
	/*public boolean checkConfirmPassword()
	{
		String password =  String.valueOf(newPasswordField.getPassword());
		String confirmPass =  String.valueOf(confirmPasswordField.getPassword());
		System.out.println(password+" pass");
		System.out.println(confirmPass+" con pass");
		if(password==confirmPass)
		{
			labelConfirmPasswordWarning.setVisible(false);
			return true;
		}
		else
		{
			labelConfirmPasswordWarning.setVisible(true);
			return false;
		}
	}*/
	
	public void setInitial(){
		labelNameWarning.setVisible(false);
		labelEmailWarning.setVisible(false);
		labelDateOfBirthWarning.setVisible(false);
		labelPasswordNotMatch.setVisible(false);
		labelPasswordWarning.setVisible(false);
		labelConfirmPasswordWarning.setVisible(false);
		
		currentPasswordField.setText("");
		newPasswordField.setText("");
//		confirmPasswordField.setText("");
		
		nameTextFieldSettingsClass.setText(getName(userId));
		emailTextFieldSettingsClass.setText(getEmail(userId));
		dateOfBirthTextFieldSettingsClass.setText(getDateOfBirth(userId));
	}
	
	public boolean isCorrectInfo(){
		if(checkDateOfBirth()==true && checkName()==true && checkEmail()==true)
			return true;
		else
			return false;
	}
	
	public boolean isOkPassword(){
		String newPassword = String.valueOf(newPasswordField.getPassword());
		String currentPassword = String.valueOf(currentPasswordField.getPassword());
		if(newPassword.length()!=0 && currentPassword.length()!=0 && checkCurrentPassword()==true && checkNewPassword()==true)
			return true;
		else
			return false;
	}
	
	public void updateInfo(){
		String name = nameTextFieldSettingsClass.getText().trim().toUpperCase();
		String email = emailTextFieldSettingsClass.getText().trim().toLowerCase();
		String dateOfBirth = dateOfBirthTextFieldSettingsClass.getText().trim();
		updateUser(userId, name, email, dateOfBirth);
	}
	
//	public boolean isCorrectPassword()
//	{
//		if
//	}
	
	public void updatePassword()
	{
		
	}
	
//	public static void main(String[] args) {
//		new Settings();
//	}

}
