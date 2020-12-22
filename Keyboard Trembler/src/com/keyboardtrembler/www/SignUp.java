package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignUp {
	JFrame testFrame;
	JLabel labelRectangleBorder, labelCreateAccount, labelName, labelEmail, labelUsername, labelDateOfBirth, labelPassword, labelConfirmPassword, labelSecurityQuestions, labelQuestion1, labelQuestion2,
		   labelNameEx, labelEmailEx, labelUsernameEx, labelDateOfBirthEx, labelPasswordEx, labelQuestion1Ex, labelQuestion2Ex;
	JTextField textFieldName, textFieldEmail, textFieldUsername, textFieldDateOfBirth, textFieldConfirmPassword, textFieldQuestion1, textFieldQuestion2;
	JPasswordField passwordField;
	JButton buttonCreate, buttonCancel;
	JPanel panelSignUp;
	JLabel labelNameWarning, labelEmailWarning, labelUserNameWarning, labelDateOfBirthWarning, labelPasswordWarning, labelConfirmPasswordWarning, labelPleaseFillUpAllFields;
	Database database;
	String userName; int userId;
	SignUp(){
		
		database = new Database();
		
		labelRectangleBorder = new JLabel(new ImageIcon("rectangleBorder7.png"));
		labelRectangleBorder.setBounds(0, 0, 880, 590);
		
		labelCreateAccount = new JLabel("Create account");
		labelCreateAccount.setBounds(380, 15, 200, 40);
		labelCreateAccount.setFont(new Font("Dialog", Font.BOLD, 18));
		labelCreateAccount.setForeground(Color.decode("125569800"));
		
		//.........................
		//.......TAG LABEL.........
		//.........................
		
		labelPleaseFillUpAllFields = new JLabel("Please fill up all the fields!");
		labelPleaseFillUpAllFields.setBounds(385, 470, 250, 30);
		labelPleaseFillUpAllFields.setForeground(Color.RED);
		
		labelNameWarning = new JLabel("Too long");
		labelNameWarning.setBounds(670, 70, 200, 30);
		labelNameWarning.setForeground(Color.RED);
		
		labelEmailWarning = new JLabel("Invalid email");
		labelEmailWarning.setBounds(670, 130, 200, 30);
		labelEmailWarning.setForeground(Color.RED);
		
		labelUserNameWarning = new JLabel("Not Available");
		labelUserNameWarning.setBounds(670, 190, 200, 30);
		labelUserNameWarning.setForeground(Color.RED);
		
		labelDateOfBirthWarning = new JLabel("Invalid date format");
		labelDateOfBirthWarning.setBounds(670, 250, 200, 30);
		labelDateOfBirthWarning.setForeground(Color.RED);
		
		labelPasswordWarning = new JLabel("Too short");
		labelPasswordWarning.setBounds(670, 310, 200, 30);
		labelPasswordWarning.setForeground(Color.RED);
		
//		labelConfirmPasswordWarning = new JLabel("Password");
//		labelConfirmPasswordWarning.setBounds(670, 370, 200, 30);
//		labelConfirmPasswordWarning.setForeground(Color.RED);
		
		
		
		labelName = new JLabel("Name                        : ");
		labelName.setBounds(250, 65, 150, 40);
		labelName.setFont(new Font("Gill Sans", Font.BOLD, 14));
		labelName.setForeground(Color.black);
		
		labelEmail = new JLabel("Email                         : ");
		labelEmail.setBounds(250, 125, 150, 40);
		labelEmail.setFont(new Font("Gill Sans", Font.BOLD, 14));
		labelEmail.setForeground(Color.black);
		
		labelUsername = new JLabel("Username                 : ");
		labelUsername.setBounds(250, 185, 150, 40);
		labelUsername.setFont(new Font("Gill Sans", Font.BOLD, 14));
		labelUsername.setForeground(Color.black);
		
		labelDateOfBirth = new JLabel("Date of Birth             :");
		labelDateOfBirth.setBounds(250, 245, 150, 40);
		labelDateOfBirth.setFont(new Font("Gill Sans", Font.BOLD, 14));
		labelDateOfBirth.setForeground(Color.black);
		
		labelPassword = new JLabel("Password                  : ");
		labelPassword.setBounds(250, 305, 150, 40);
		labelPassword.setFont(new Font("Gill Sans", Font.BOLD, 14));
		labelPassword.setForeground(Color.black);
		
//		labelConfirmPassword = new JLabel("Confirm Password   : ");
//		labelConfirmPassword.setBounds(250, 365, 150, 40);
//		labelConfirmPassword.setFont(new Font("Gill Sans", Font.BOLD, 14));
//		labelConfirmPassword.setForeground(Color.black);
		
		labelSecurityQuestions = new JLabel("Security Questions  : ");
		labelSecurityQuestions.setBounds(250, 350, 150, 40);
		labelSecurityQuestions.setFont(new Font("Gill Sans", Font.BOLD, 14));
		labelSecurityQuestions.setForeground(Color.decode("125587900"));
		
		//...................................
		//..........EXAMPLE LABEL............
		//...................................
		labelNameEx = new JLabel("Ex: Abdul Halim Chy");
		labelNameEx.setBounds(412, 90, 140, 40);
		labelNameEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		labelNameEx.setForeground(Color.black);
		
		labelEmailEx = new JLabel("Ex: example@gmail.com");
		labelEmailEx.setBounds(412, 150, 140, 40);
		labelEmailEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		labelEmailEx.setForeground(Color.black);
		
		labelUsernameEx = new JLabel("Ex: abdulhalimchy");
		labelUsernameEx.setBounds(412, 210, 140, 40);
		labelUsernameEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		labelUsernameEx.setForeground(Color.black);
		
		labelDateOfBirthEx = new JLabel("Ex: 1990-09-23 (Format: YYYY-MM-DD)");
		labelDateOfBirthEx.setBounds(412, 270, 200, 40);
		labelDateOfBirthEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		labelDateOfBirthEx.setForeground(Color.black);
		
		labelPasswordEx = new JLabel("Password must contains more than 5 characters");
		labelPasswordEx.setBounds(412, 330, 270, 40);
		labelPasswordEx.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		labelPasswordEx.setForeground(Color.black);
		
		labelQuestion1 = new JLabel("1.The Country you like most?");
		labelQuestion1.setBounds(272, 380, 290, 40);
		labelQuestion1.setFont(new Font("Gill Sans", Font.BOLD, 11));
		labelQuestion1.setForeground(Color.black);
		
		labelQuestion2 = new JLabel("1.Your favorite game?");
		labelQuestion2.setBounds(493, 380, 290, 40);
		labelQuestion2.setFont(new Font("Gill Sans", Font.BOLD, 11));
		labelQuestion2.setForeground(Color.black);
		
		labelQuestion1Ex = new JLabel("Ex: Bangladesh");
		labelQuestion1Ex.setBounds(272, 430, 290, 40);
		labelQuestion1Ex.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		labelQuestion1Ex.setForeground(Color.black);
		
		labelQuestion2Ex = new JLabel("Ex: Football");
		labelQuestion2Ex.setBounds(493, 430, 290, 40);
		labelQuestion2Ex.setFont(new Font("Gill Sans", Font.PLAIN, 11));
		labelQuestion2Ex.setForeground(Color.black);
	
		
		
		
		//..........................
		//........TEXTFIELD.........
		//..........................
		textFieldName = new JTextField();
		textFieldName.setBounds(410, 68, 250, 35);
		textFieldName.setBorder(new LineBorder(Color.gray, 2));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(410, 128, 250, 35);
		textFieldEmail.setBorder(new LineBorder(Color.gray, 2));
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(410, 188, 250, 35);
		textFieldUsername.setBorder(new LineBorder(Color.gray, 2));
		
		textFieldDateOfBirth = new JTextField();
		textFieldDateOfBirth.setBounds(410, 248, 250, 35);
		textFieldDateOfBirth.setBorder(new LineBorder(Color.gray, 2));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(410, 308, 250, 35);
		passwordField.setBorder(new LineBorder(Color.gray, 2));
		
//		textFieldConfirmPassword = new JTextField();
//		textFieldConfirmPassword.setBounds(410, 368, 250, 35);
//		textFieldConfirmPassword.setBorder(new LineBorder(Color.gray, 2));
		
		textFieldQuestion1 = new JTextField();
		textFieldQuestion1.setBounds(270, 408, 170, 35);
		textFieldQuestion1.setBorder(new LineBorder(Color.gray, 2));
		
		textFieldQuestion2 = new JTextField();
		textFieldQuestion2.setBounds(491, 408, 170, 35);
		textFieldQuestion2.setBorder(new LineBorder(Color.gray, 2));
		
		//..........BUTTON..............
		buttonCreate = new JButton(new ImageIcon("create3.png"));
		buttonCreate.setBounds(405, 500, 110, 30);
		
		buttonCancel = new JButton(new ImageIcon("cancel2.png"));
		buttonCancel.setBounds(430, 530, 60, 28);
		buttonCancel.setBorderPainted(false);
		
		//............PANEL..........
		panelSignUp = new JPanel();
		panelSignUp.setPreferredSize(new Dimension(880, 590));
		panelSignUp.setLayout(null);
		panelSignUp.setBackground(Color.white);
		
		//TAG LABEL ADDING
		panelSignUp.add(labelRectangleBorder);
		
		panelSignUp.add(labelCreateAccount);
		panelSignUp.add(labelName);
		panelSignUp.add(labelEmail);
		panelSignUp.add(labelUsername);
		panelSignUp.add(labelDateOfBirth);
		panelSignUp.add(labelPassword);
//		panelSignUp.add(labelConfirmPassword);
		panelSignUp.add(labelSecurityQuestions);
		panelSignUp.add(labelPleaseFillUpAllFields);
		panelSignUp.add(labelNameWarning);
		panelSignUp.add(labelEmailWarning);
		panelSignUp.add(labelUserNameWarning);
		panelSignUp.add(labelDateOfBirthWarning);
		panelSignUp.add(labelPasswordWarning);
//		panelSignUp.add(labelConfirmPasswordWarning);
		
		
		//EXAMPLE ADDING
		panelSignUp.add(labelNameEx);
		panelSignUp.add(labelEmailEx);
		panelSignUp.add(labelUsernameEx);
		panelSignUp.add(labelDateOfBirthEx);
		panelSignUp.add(labelPasswordEx);
		panelSignUp.add(labelQuestion1Ex);
		panelSignUp.add(labelQuestion2Ex);
		panelSignUp.add(labelQuestion1);
		panelSignUp.add(labelQuestion2);
		
		//TEXTFIELD ADDING
		panelSignUp.add(textFieldName);
		panelSignUp.add(textFieldEmail);
		panelSignUp.add(textFieldUsername);
		panelSignUp.add(textFieldDateOfBirth);
		panelSignUp.add(passwordField);
//		panelSignUp.add(textFieldConfirmPassword);
		panelSignUp.add(textFieldQuestion1);
		panelSignUp.add(textFieldQuestion2);
		
		panelSignUp.add(buttonCreate);
		panelSignUp.add(buttonCancel);
		
		
		//.............CALLING ALL KINDS OF METHODS............
		setInitial();
		
		//........Testing Frame.........
//		testFrame  = new JFrame();
//		testFrame.setSize(900,  700);
//		testFrame.setLayout(new GridBagLayout());
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(testFrame.EXIT_ON_CLOSE);
//		testFrame.add(panelSignUp, new GridBagConstraints());
		
		//................................KEY LISTENERS OF TEXTFIELDS...............
		
		//......Name......
		textFieldName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkName();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		//.....Email...
		textFieldEmail.addKeyListener(new KeyListener() {
			
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
		
		//...USERNAME........
		textFieldUsername.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkUserName();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		//.........Date of Birth.....
		textFieldDateOfBirth.addKeyListener(new KeyListener() {
			
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
		
		
		//.......................Mouser listeners.......................
		
		buttonCancel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				buttonCancel.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonCancel.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
	public boolean checkName(){
		String name = textFieldName.getText().trim().toUpperCase();
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
		String email = textFieldEmail.getText().trim().toLowerCase();
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
	
	public boolean checkUserName(){
		String username = textFieldUsername.getText().trim().toLowerCase();
		int len = username.length();
		
		if(len>20)
		{
			labelUserNameWarning.setText("Too long");
			labelUserNameWarning.setVisible(true);
			return false;
		}
		else if(len<3)
		{
			labelUserNameWarning.setText("Too short");
			labelUserNameWarning.setVisible(true);
			return false;
		}
		
		if(database.isAvailable(username)==false)
		{
			labelUserNameWarning.setText("Not available");
			labelUserNameWarning.setVisible(true);
			return false;
		}
		
		labelUserNameWarning.setVisible(false);
		return true;
	}
	
	public boolean checkDateOfBirth(){
		String dateOfBirth = textFieldDateOfBirth.getText().trim();
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
	
	public boolean checkIsAnyFieldEmpty(){
		String name = textFieldName.getText().trim().toUpperCase();
		String email = textFieldEmail.getText().trim().toLowerCase();
		String username = textFieldUsername.getText().trim().toLowerCase();
		String dateOfBirth = textFieldDateOfBirth.getText().trim();
		String password = String.valueOf(passwordField.getPassword());
		String question1 = textFieldQuestion1.getText().trim();
		String question2 = textFieldQuestion2.getText().trim();
//		System.out.println("1>"+question1);
//		System.out.println("1>"+question2);
		if(name.length()==0 || email.length()==0 || username.length()==0 || dateOfBirth.length()==0 || password.length()==0 || question1.length()==0 || question2.length()==0)
		{
			labelPleaseFillUpAllFields.setVisible(true);
			return true;
		}
		labelPleaseFillUpAllFields.setVisible(false);
		return false;
	}

	public boolean isEverythingOK(){
		boolean a, b, c, d, e, f;
		a=checkDateOfBirth(); b=checkEmail(); c=checkIsAnyFieldEmpty(); d=checkName(); e=checkUserName(); f=checkPassword();
		if(a==true && b==true && c==false && d==true &&  e==true && f==true){
			labelPleaseFillUpAllFields.setVisible(false);
			return true;
		}
		else
		{
			labelPleaseFillUpAllFields.setVisible(true);
			return false;
		}
	}
	
 	public void setInitial(){
		textFieldName.setText("");
		textFieldEmail.setText("");
		textFieldUsername.setText("");
		textFieldDateOfBirth.setText("");
		passwordField.setText("");
		textFieldQuestion1.setText("");
		textFieldQuestion2.setText("");
		
		labelPleaseFillUpAllFields.setVisible(false);
		labelNameWarning.setVisible(false);
		labelEmailWarning.setVisible(false);
		labelDateOfBirthWarning.setVisible(false);
		labelUserNameWarning.setVisible(false);
		labelPasswordWarning.setVisible(false);
	}
	
	
	public void saveToDataBase(){
		String name = textFieldName.getText().trim().toUpperCase();
		String email = textFieldEmail.getText().trim().toLowerCase();
		String username = textFieldUsername.getText().trim().toLowerCase();
		String dateOfBirth = textFieldDateOfBirth.getText().trim();
		String password = String.valueOf(passwordField.getPassword());
		password=database.hashStringValue(password); // hashing password;
		String question1 = textFieldQuestion1.getText().trim();
		question1 = database.hashStringValue(question1); // hashing answer
		String question2 = textFieldQuestion2.getText().trim();
		question2 = database.hashStringValue(question2); // hashing answer
		
		//.........Storing user information..........
		database.insertIntoUser(name, username, email, dateOfBirth, password, question1, question2);
		userId = database.getUserId(username);
		database.insertIntoTotal(userId, 0, 0);
		database.insertIntoProfilePicture(userId, null, 0);
	}
	
//	public static void main(String[] args){
//		new SignUp();
//	}
}
