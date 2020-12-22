package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	JFrame frameMain;
	JPanel panelMain;
	int userId;
	String userName, profileName;
	Welcome welcomeObj;
	SignUp signUpObj;
	Home homeObj;
	Race raceObj;
	Practice practiceObj;
	RaceHistory raceHistoryObj;
	RankList rankListObj;
	Settings settingsObj;
	PasswordRecovery passwordRecoveryObj;
	NewPasswordRecovery newPasswordRecoveryObj;
	About aboutObj;
	Database database;
	public Main() {
		
		database = new Database();
		welcomeObj = new Welcome();//GridBag
		signUpObj = new SignUp();//GridBag
		homeObj = new Home();//GridLayout(1,1)
		raceObj = new Race();
		practiceObj = new Practice();
		raceHistoryObj = new RaceHistory();
		rankListObj = new RankList();
		settingsObj = new Settings();
		passwordRecoveryObj = new PasswordRecovery();
		newPasswordRecoveryObj = new NewPasswordRecovery();
		aboutObj = new About();
		
		//................Main Panel........................
		panelMain = new JPanel();
		panelMain.setBackground(Color.white);
		
		//........Checking Current login information........
		userId = database.checkCurrentLogin();
		if(userId!=0)
		{
			setGridLayoutInPanel(homeObj.panelHome);
			setHomePanel();
		}
		else
			setGridBagLayoutInPanel(welcomeObj.panelWelcome);
		

		
		//...............Main Frame..............
		frameMain = new JFrame("KeyBoard Trembler");
		frameMain.setMinimumSize(new Dimension(900, 700));
		frameMain.setLayout(new GridLayout(1, 1));
		frameMain.setVisible(true);
		frameMain.getContentPane().setBackground(Color.white);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocationRelativeTo(null);
		frameMain.add(panelMain);
		frameMain.repaint();
		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
		frameMain.setIconImage(frameIcon);
		
		
		//......................ActionListeners.....................
		
		//.........Welcome panel...........
		welcomeObj.buttonSignIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(isCorrect(welcomeObj.textFieldUsername.getText(), String.valueOf(welcomeObj.passwordField.getPassword()))==true){
					setGridLayoutInPanel(homeObj.panelHome);
					database.insertIntoCurrentLogin(userId);
					setHomePanel();
					//set profile picture
					//set user playing statistic
				}
				else
					JOptionPane.showMessageDialog(frameMain,"<html><font color=red>Incorrect username or password!<font><html>");
			}
		});
		
		welcomeObj.buttonForgotPassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordRecoveryObj.emailTextFieldPasswordRecoveryClass.setText("");
				passwordRecoveryObj.dateOfBirthTextFieldPasswordRecoveryClass.setText("");
				passwordRecoveryObj.usernameTextFieldPasswordRecoveryClass.setText("");
				passwordRecoveryObj.question1TextFieldPasswordRecoveryClass.setText("");
				passwordRecoveryObj.question2TextFieldPasswordRecoveryClass.setText("");
				setGridBagLayoutInPanel(passwordRecoveryObj.passwordRecoveryPanel);
			}
		});
		
		welcomeObj.buttonSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpObj.setInitial();
				setGridBagLayoutInPanel(signUpObj.panelSignUp);
			}
		});
		
		welcomeObj.buttonAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridBagLayoutInPanel(aboutObj.aboutPanel);
			}
		});
		
		welcomeObj.buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//..........Sign up panel........
		
		signUpObj.buttonCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(signUpObj.isEverythingOK()==true)
				{
					signUpObj.saveToDataBase();
					setGridBagLayoutInPanel(welcomeObj.panelWelcome);
					JOptionPane.showMessageDialog(frameMain, "Account created successfully, please login!");
				}
			}
		});
		
		signUpObj.buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridBagLayoutInPanel(welcomeObj.panelWelcome);
			}
		});
		
		//.............Home panel.........
		homeObj.signOutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridBagLayoutInPanel(welcomeObj.panelWelcome);
				welcomeObj.textFieldUsername.setText("");
				welcomeObj.passwordField.setText("");
				database.deleteCurrentLogin();
				userId=0;
			}
		});	
		
		homeObj.raceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setGridLayoutInPanel(raceObj.RacePanel);
			}
		});
		
		homeObj.practiceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setGridLayoutInPanel(practiceObj.practicePanel);
			}
		});
		
		homeObj.raceHistoryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setGridLayoutInPanel(raceHistoryObj.RaceHistoryPanel);
				raceHistoryObj.insertingToTable();
			}
		});
		
		homeObj.rankListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rankListObj.insertingToTable();
				setGridLayoutInPanel(rankListObj.RankListPanel);
			}
		});
		
		homeObj.settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//set field details from data base
				setGridLayoutInPanel(settingsObj.settingsPanel);
				settingsObj.setInitial();
			}
		});
		
		
		
		// ......RACE PANEL.............
		raceObj.centerLayoutObj.backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				raceObj.timerObj.suspendTimerThread();
				raceObj.computerCarObj.suspendCarThread();
				raceObj.saveTypedCharactersAndTime();
				raceObj.setRandomTextIntoTextPane();
				raceObj.setInitialRaceClass();
				setHomePanel();
				setGridLayoutInPanel(homeObj.panelHome);
				
			}
		});
	

		// ......................Practice panel.......................
		practiceObj.centerLayoutObj.backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				practiceObj.timerObj.suspendTimerThread();
				practiceObj.saveToDatabase();
				practiceObj.setInitialPracticeClass();
				setHomePanel();
				setGridLayoutInPanel(homeObj.panelHome);
				
				
			}
		});
		
		
		//................Race History...............
		raceHistoryObj.backButtonRaceHistoryClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridLayoutInPanel(homeObj.panelHome);	
			}
		});
	
		//.................Rank List...........
		rankListObj.backButtonRankListClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridLayoutInPanel(homeObj.panelHome);
			}
		});
		
		
		///......................Password recovery.....................
		passwordRecoveryObj.cancelButtonPasswordRecoveryClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridBagLayoutInPanel(welcomeObj.panelWelcome);
			}
		});
		
		passwordRecoveryObj.sendRequestButtonPasswordRecoveryClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String email = passwordRecoveryObj.emailTextFieldPasswordRecoveryClass.getText();
				String dateOfBirth = passwordRecoveryObj.dateOfBirthTextFieldPasswordRecoveryClass.getText();
				String username =  passwordRecoveryObj.usernameTextFieldPasswordRecoveryClass.getText();
				String question1Answer =  passwordRecoveryObj.question1TextFieldPasswordRecoveryClass.getText();
				String question2Answer =  passwordRecoveryObj.question2TextFieldPasswordRecoveryClass.getText();
				
				userId = database.getUserId(email, username, dateOfBirth, question1Answer, question2Answer);
				
				if(userId!=0)
				{
					newPasswordRecoveryObj.userId=userId;
					setGridBagLayoutInPanel(newPasswordRecoveryObj.newPasswordRecoveryPanel);
				}
				else
					JOptionPane.showMessageDialog(frameMain, "Incorrect information!");
				
			}
		});
		
		
		newPasswordRecoveryObj.doneButtonNewPasswordRecoveryClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = String.valueOf(newPasswordRecoveryObj.passwordField.getPassword());
				if(newPasswordRecoveryObj.checkPassword()==true)
				{
					database.updatePassword(userId, password);
					JOptionPane.showMessageDialog(frameMain, "Changed Successfully!");
					newPasswordRecoveryObj.setInitial();
					setGridBagLayoutInPanel(welcomeObj.panelWelcome);
				}
			}
		});
		
		//......................About...................
		
		aboutObj.backButtonAboutClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridBagLayoutInPanel(welcomeObj.panelWelcome);
			}
		});
		
		//.............Settings..............
		settingsObj.backButtonSettingsClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGridLayoutInPanel(homeObj.panelHome);
			}
		});
		
		settingsObj.deleteAccountButtonSettingsClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				database.deleteUser(userId);
				setGridBagLayoutInPanel(welcomeObj.panelWelcome);
				JOptionPane.showMessageDialog(frameMain, "Account deleted successfully!");
			}
		});
	}
	
	
	public void setGridBagLayoutInPanel(JPanel p){
		panelMain.removeAll();
		panelMain.setLayout(new GridBagLayout());
		panelMain.add(p, new GridBagConstraints());
		panelMain.revalidate();
		panelMain.repaint();
	}

	public void setGridLayoutInPanel(JPanel p){
		
		panelMain.removeAll();
		panelMain.setLayout(new GridLayout(1,1));
		panelMain.add(p);
		panelMain.revalidate();
		panelMain.repaint();
	}
	
	
	public boolean isCorrect(String username, String password){
		userId= database.getUserId(username, password);
		if(userId!=0)
			return true;
		else
			return false;
	}
	
	public void setProfileName(int userId)
	{
		System.out.println(userId);
		profileName = database.getName(userId);
		homeObj.labelProfileNameBelowDp.setText(profileName);
		String username=database.getUserName(userId)+"  ";
		homeObj.upperLayoutObj.labelProfileName.setText(username);
		raceObj.upperLayoutObj.labelProfileName.setText(username);
		practiceObj.upperLayoutObj.labelProfileName.setText(username);
		raceHistoryObj.upperLayoutObj.labelProfileName.setText(username);
		rankListObj.upperLayoutObj.labelProfileName.setText(username);
		settingsObj.upperLayoutObj.labelProfileName.setText(username);
		
	}
	
	public void setUserIdToOtherClass()
	{
		raceObj.userId = userId;
		practiceObj.userId=userId;
		raceHistoryObj.userId=userId;
		rankListObj.userId=userId;
		settingsObj.userId=userId;
		homeObj.userId=userId;
	}
	
	public void setProfilePicture(){
		ImageIcon imgIcon = database.getPicture(userId);
		if(imgIcon!=null)
		{
			
			Image img = imgIcon.getImage().getScaledInstance(78, 84, Image.SCALE_SMOOTH);
			ImageIcon finalImage = new ImageIcon(img);
			homeObj.labelProPic.setIcon(finalImage);
		}
		else
			homeObj.labelProPic.setIcon(null);
	}
	
	public void setHomePanel(){
		setUserIdToOtherClass();
		setProfileName(userId);
		setProfilePicture();
		int avgSpeed = database.getAvgSpeed(userId);
		int bestSpeed = database.getBestSpeed(userId);
		int totalPlayedRaces = database.getTotalPlayedRaces(userId);
		int totalWonRaces = database.getTotalWonRaces(userId);
		int typedCharacters= database.getTypedCharacters(userId);
		int playingTime = database.getPlayingTime(userId);
		
//		System.out.println(userId);
//		System.out.println(totalWonRaces+"Won");
		
		homeObj.labelAvgSpeed.setText(":  "+String.valueOf(avgSpeed)+" WPM / "+String.valueOf(avgSpeed*5)+" CPM");
		homeObj.labelBestSpeed.setText(":  "+String.valueOf(bestSpeed)+" WPM / "+String.valueOf(bestSpeed*5)+" CPM");
		homeObj.labelTotalPlayedRaces.setText(":  "+String.valueOf(totalPlayedRaces));
		homeObj.labelTotalRacesWon.setText(":  "+String.valueOf(totalWonRaces));
		homeObj.labelTotalTypedChar.setText(":  "+String.valueOf(typedCharacters));
		if((int)playingTime/60>1)
			homeObj.labelTotalPlayingTime.setText(":  "+String.valueOf((int)playingTime/60)+" Minutes");
		else
			homeObj.labelTotalPlayingTime.setText(":  "+String.valueOf((int)playingTime/60)+" Minute");
		String yourTypingSpeed;
		if(avgSpeed>80)
			yourTypingSpeed="Pro Typist";
		else if(avgSpeed>60)
			yourTypingSpeed="Fast";
		else if(avgSpeed>45)
			yourTypingSpeed="Fluent";
		else if(avgSpeed>25)
			yourTypingSpeed="Average";
		else if(avgSpeed>10)
			yourTypingSpeed="Slow";
		else if(avgSpeed>0)
			yourTypingSpeed="Very slow";
		else
			yourTypingSpeed="--";
		
		homeObj.labelYourTypingSpeed.setText(":  "+yourTypingSpeed);
		homeObj.labelExperience.setText(":  "+String.valueOf((int)playingTime/3900));
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
