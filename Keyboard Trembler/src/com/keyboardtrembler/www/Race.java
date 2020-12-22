package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.*;
import javax.swing.text.StyleConstants;


public class Race{

	JFrame testFrame;
	JLabel youLabel, comLabel;
	JPanel RacePanel;
	UpperLayout upperLayoutObj;
	CenterLayout centerLayoutObj;
	Sound soundObj;
	Car myCarObj;
	Timer timerObj, computerCarObj;
	javax.swing.text.Style style;
	Random randomNumber;
	String stringOfTextPane;
	int averageSpeedOfUser, speedOfComputerCar, currentPosition, typedTotalWrongCharacters, currentlyTypedWrongCharacters, lengthOfText;
	double movePerUnitKeyPressed, moveTotal, accuracy;
	TextDetailsClass textDetails;
	boolean flag, raceOccurred, shouldResume;
	int userId;
	Database database = new Database();
	
	public Race() {
		
		randomNumber = new Random();
		textDetails = new TextDetailsClass();
		
		upperLayoutObj = new UpperLayout();
		centerLayoutObj = new CenterLayout();
		soundObj = new Sound();
		
		centerLayoutObj.textPane.setStyledDocument(centerLayoutObj.doc);
		style = centerLayoutObj.textPane.addStyle("color", null);
		StyleConstants.setForeground(style, Color.black);
		
		//...........Car.............
		myCarObj = new Car();
		
		//.......For Computer Car.........
		computerCarObj  = new Timer();
		computerCarObj.start();
		computerCarObj.suspendCarThread();
		System.out.println(computerCarObj.isAlive());
		computerCarObj.isItComputerCar=true;
		
		
		//..............Timer.................
		timerObj = new Timer();
		
		if(timerObj.isAlive()==false)
			timerObj.start();
		
		timerObj.suspendTimerThread();
		
		//>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<
		//..............Label.................
		
		youLabel = new JLabel("YOU :");
		youLabel.setBounds(15, 70, 100, 50);
		youLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		
		
		comLabel = new JLabel("COM :");
		comLabel.setBounds(15, 160, 100, 50);
		comLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		
		upperLayoutObj.panelInsideCenterPanel.add(youLabel);
		upperLayoutObj.panelInsideCenterPanel.add(comLabel);
		
		//.........Corner profile name........
		upperLayoutObj.labelProfileName.setText("Salman Chowdhury  ");
		upperLayoutObj.labelPanelTitleName.setText("Race");
		
		//..................Adding From TimerClass.......................
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.timerLabel);
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.runningSpeedLabel);
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.wpmLabel);
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.speedLabel);
		
		
		//..................Adding From CenterLayoutClass.......................
		centerLayoutObj.nextButton.setVisible(false);
		centerLayoutObj.scoreLabel.setVisible(false);
		centerLayoutObj.restartButton.setVisible(false);
		
		
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.rectangleBorderLabel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.borderInsideRectangleBorder);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.textPane);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.typeHereLabel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.typeHereTextField);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.backButton);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.typeToStartPanel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.resultPanel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.roadLabel1);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.roadLabel2);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.flagLabel1);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.flagLabel2);
//		upperLayoutObjRaceClass.panelInsideCenterPanel.add(centerLayoutObjRaceClass.speedLabel);
		
		
		
		
		
		
		//..................Adding From CarClass :: MY CAR.......................
		upperLayoutObj.panelInsideCenterPanel.add(myCarObj.carLabel);
		upperLayoutObj.panelInsideCenterPanel.add(myCarObj.changeCarPanel);
		
		//..................Adding From TimerClass :: COMPUTER CAR.......................
		upperLayoutObj.panelInsideCenterPanel.add(computerCarObj.computerCarObjTimerClass.carLabel);
//		upperLayoutObjRaceClass.panelInsideCenterPanel.add(computerCarObj.computerCarWpmLabel);
//		upperLayoutObjRaceClass.panelInsideCenterPanel.add(computerCarObj.timerLabel);
//		computerCarObj.timerLabel.setBounds(695, 210, 150, 50);;
		
		
		//........Calling All kinds of Methods..........
		setRandomTextIntoTextPane();
		setInitialRaceClass();
		
		
		
		
		//................................
		//............Panel...............
		//................................
		
		upperLayoutObj.panel4.add(soundObj.soundPanel);
		
		RacePanel = new JPanel();
		RacePanel.setBackground(Color.white);
		RacePanel.setLayout(new BorderLayout());
		
		new BorderLayout();
		RacePanel.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		RacePanel.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(RacePanel);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
		
		//.............................Listeners......................
		centerLayoutObj.tryAgainButton.addActionListener(new ActionListener() {
			
			//Try again button
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				saveTypedCharactersAndTime();
				setInitialRaceClass();
			}
		});
		
		centerLayoutObj.restartButton.addActionListener(new ActionListener() {
			
			//Restart Button
			@Override
			public void actionPerformed(ActionEvent e) {
				timerObj.suspendTimerThread();
				computerCarObj.suspendCarThread();
				saveTypedCharactersAndTime();
				setInitialRaceClass();
				
			}
		});
		
		//..New Race Button...
		centerLayoutObj.newRaceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setRandomTextIntoTextPane();
				setInitialRaceClass();
			}
		});
		
		//...............................................................
		//........................KEY LISTENERS..........................
		//...............................................................
		centerLayoutObj.typeHereTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent evt) {
				
				if(evt.getKeyChar()!=KeyEvent.VK_BACK_SPACE)
				{
						timerObj.resumeTimerThread();
						if(shouldResume==true)
						{
							computerCarObj.resumeCarThread();
							shouldResume=false;
						}
						setFalseAfterThreadStart();
						setTrueAfterThreadStart();
					if(stringOfTextPane.charAt(currentPosition)==evt.getKeyChar() && currentlyTypedWrongCharacters==0)
					{
						if(evt.getKeyChar()==KeyEvent.VK_SPACE)
						{
							Sound.playSoundSpace();
							centerLayoutObj.typeHereTextField.setText("");
						}
						else
							Sound.playSoundKey();
						StyleConstants.setForeground(style, Color.green);
						centerLayoutObj.doc.setCharacterAttributes(currentPosition, 1, centerLayoutObj.textPane.getStyle("color"), true);
						
						moveTotal+=movePerUnitKeyPressed;
						myCarObj.setCarPosition((int)moveTotal+60, myCarObj.carY);
						
						currentPosition++;
						flag=true;
//						myCarObj.carMovingUnit((int)moveTotal);
					}
					/////////////////////////
					else
					{
						StyleConstants.setForeground(style, Color.red);
						centerLayoutObj.doc.setCharacterAttributes(currentPosition, 1, centerLayoutObj.textPane.getStyle("color"), true);
						if(flag==true)
						{
							flag=false;
							typedTotalWrongCharacters++;
						}
						currentlyTypedWrongCharacters++;
					}
//					currentPosition++;
//					centerLayoutObjRaceClass.typeHereTextField.setText("");
					if(currentPosition==lengthOfText)
					{
							computerCarObj.suspendCarThread();
							timerObj.suspendTimerThread();
							setFalseAfterThreadSuspend();
							setTrueAfterThreadSuspend();
							setAccuracy();
							setSpeed();
							showWinningResult();
							centerLayoutObj.typeToStartLabel.setText("");
							
//							System.out.println(typedTotalWrongCharacters);
//							System.out.println(lengthOfText-typedTotalWrongCharacters);
							saveInfoIntoDatabase();
							raceOccurred=true;
							
					}
					else
						setTextToTypeHereToStart();
					timerObj.setTypingCurrentPosition(currentPosition);
//					timerObj.setTypingCurrentPosition(currentPosition-typedTotalWrongCharacters);
					///////////////////
				}
				else if(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)
				{
					String s=centerLayoutObj.typeHereTextField.getText();
					if(s.length()==0)
						currentlyTypedWrongCharacters=0;
					else if(currentlyTypedWrongCharacters>0)
						currentlyTypedWrongCharacters--;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
	}
		
	public void setInitialRaceClass()
	{
		currentlyTypedWrongCharacters = 0;
		
		shouldResume = true;
		raceOccurred=false;
		centerLayoutObj.typeHereLabel.setVisible(true);
		centerLayoutObj.typeHereTextField.setVisible(true);
		centerLayoutObj.tryAgainButton.setVisible(false);
		centerLayoutObj.newRaceButton.setVisible(false);
		centerLayoutObj.setInitialCenterLayoutClass();
		
		myCarObj.setCarPosition(60, 40);
		computerCarObj.computerCarObjTimerClass.setCarPosition(60, 129);
		computerCarObj.setInitialTimerClass();
		timerObj.setInitialTimerClass(); // setting timer initial
		flag=true;
		moveTotal=0;
		currentPosition=0;
		typedTotalWrongCharacters=0;
		stringOfTextPane = centerLayoutObj.textPane.getText();
		lengthOfText= stringOfTextPane.length();
		movePerUnitKeyPressed=600.0/(double)lengthOfText;
		
		//...Important calculation about computer car............
		getComputerCarAvgSpeed();
		setComputerCarSpeed();
		computerCarObj.computerCarPerUnitDistance=movePerUnitKeyPressed;
		
		StyleConstants.setForeground(style, Color.black);
		centerLayoutObj.doc.setCharacterAttributes(0, lengthOfText, centerLayoutObj.textPane.getStyle("color"), true);

		System.out.println("CarX : "+computerCarObj.computerCarObjTimerClass.carX);
	
	
		int n = randomNumber.nextInt(14)+1;
        System.out.println(n);
        computerCarObj.computerCarObjTimerClass.setCarIcon(n);	//set computer Car Label
        
	}
	
	public void setTrueAfterThreadStart(){
		timerObj.runningSpeedLabel.setVisible(true);
		
	}
	
	public void setFalseAfterThreadStart(){
		
	}
	
	public void setTrueAfterThreadSuspend(){
		centerLayoutObj.accuracyLabel.setVisible(true);
		centerLayoutObj.mistypedCharacterLabel.setVisible(true);
		centerLayoutObj.correctlyTypedCharacterLabel.setVisible(true);
		centerLayoutObj.tryAgainButton.setVisible(true);
		centerLayoutObj.newRaceButton.setVisible(true);
	}
	
	public void setFalseAfterThreadSuspend(){
		centerLayoutObj.typeHereLabel.setVisible(false);
		centerLayoutObj.typeHereTextField.setVisible(false);
		centerLayoutObj.youWonLabel.setVisible(true);
		
		timerObj.runningSpeedLabel.setVisible(false);
		
	}
	
	
	public void setTextToTypeHereToStart()
	{
		if(stringOfTextPane.charAt(currentPosition)==' ')
			centerLayoutObj.typeToStartLabel.setText("<space>");
		else if(stringOfTextPane.charAt(currentPosition)=='\n')
			centerLayoutObj.typeToStartLabel.setText("<enter>");
		else
			centerLayoutObj.typeToStartLabel.setText(String.valueOf(stringOfTextPane.charAt(currentPosition)));
			
	}
	
	public void setAccuracy(){
		accuracy = (double)(lengthOfText-typedTotalWrongCharacters)/(double)lengthOfText;
		accuracy*=100.0;
		centerLayoutObj.accuracyLabel.setText("Accuracy: "+String.valueOf(Double.parseDouble(String.format("%.2f", accuracy))) +"%");
		
		if(lengthOfText-typedTotalWrongCharacters>1)
			centerLayoutObj.correctlyTypedCharacterLabel.setText("Perfect : "+ String.valueOf(lengthOfText-typedTotalWrongCharacters)+" Characters");
		else
			centerLayoutObj.correctlyTypedCharacterLabel.setText("Perfect : "+ String.valueOf(lengthOfText-typedTotalWrongCharacters)+" Character");
		if(typedTotalWrongCharacters>1)
			centerLayoutObj.mistypedCharacterLabel.setText("Mistyped : "+ String.valueOf(typedTotalWrongCharacters)+" Characters");
		else
			centerLayoutObj.mistypedCharacterLabel.setText("Mistyped : "+ String.valueOf(typedTotalWrongCharacters)+" Character");
	}
	
	public void setSpeed()
	{
		timerObj.speedLabel.setVisible(true);
		
//		timerObj.speed  = (double)currentPosition/5.0;
//		if(timerObj.seconds+1!=0)
//			timerObj.speed = timerObj.speed/(double)((timerObj.seconds+1)/60.0);
//		centerLayoutObjRaceClass.speedLabel.setText("Speed : " + String.valueOf((int)timerObj.speed) + " WPM");
	}
	
	
	public void setComputerCarSpeed()
	{
		// getComputerCarAvgSpeed()

		int min=averageSpeedOfUser-5; int max = averageSpeedOfUser+10;
		int  n = randomNumber.nextInt((max-min)+1)+min;
		speedOfComputerCar = n; // use random speed in WPM
		computerCarObj.sleepingTimeOfCar = (60000/(speedOfComputerCar*5));

	}
	
	//........ AVERAGE SPEED ............
	public void getComputerCarAvgSpeed(){
//		get average speed from database
		averageSpeedOfUser= database.getAvgSpeed(userId);
		if(averageSpeedOfUser<10)
			averageSpeedOfUser=10;
	}
	
	public void showWinningResult(){
		timerObj.setWinner(1);
		if(Timer.winner==1)
			centerLayoutObj.youWonLabel.setText("YOU WON!");
		else if(Timer.winner==2)
			centerLayoutObj.youWonLabel.setText("YOU LOSE!");
		
	}
	
	public void saveInfoIntoDatabase(){
		
		
		//testing before saving to database
//		System.out.println(timerObj.wpmLabel.getText()+" After finished the race");
//		System.out.println(centerLayoutObj.accuracyLabel.getText());
//		System.out.println(accuracy+" After finished the race");
		String status="";
		if(Timer.winner==1)
			status = "WON";
		else if(Timer.winner==2)
			status = "LOSE";
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
        String playingDate = String.valueOf(format.format(date));
        System.out.println(playingDate);
//        centerLayoutObjRaceClass.speedLabel.setText(timerObj.wpmLabel.getText());
        
        //save totaltyped characters
        database.insertIntoRaceHistory(userId, (int)timerObj.speed, Double.parseDouble(String.format("%.2f", accuracy)), status, playingDate);
        saveTypedCharactersAndTime();
        
        System.out.println(timerObj.seconds);
        System.out.println("RaceOccurred : "+raceOccurred);
		
	}
	
	public void saveTypedCharactersAndTime(){
		int typedCharacters = currentPosition;
		//update tbl_total....
		database.updatingTotal(userId, typedCharacters, (int)timerObj.seconds);
		currentPosition=0; timerObj.seconds=0;
	}
	
	public void setRandomTextIntoTextPane()
	{
		int  n = randomNumber.nextInt(200);
		centerLayoutObj.textPane.setText(textDetails.textForTyping[n]);
	}
//	public static void main(String[] args) {
//		new Race();
//	}

}