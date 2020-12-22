package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import javax.swing.text.StyleConstants;

public class Practice {
	JFrame testFrame;
	JPanel practicePanel;
	private JLabel setTextLabel, pasteTextLabel;
	JButton addTextButtonPracticeClass;
	JComboBox<String> setTextComboBoxPracticeClass;
	JTextField pasteHereTextFieldPracticeClass;
	Sound soundObj;
	UpperLayout upperLayoutObj;
	CenterLayout centerLayoutObj;
	Car myCarObj;
	Timer timerObj;
	String stringOfTextPane;
	int currentPosition, typedTotalWrongCharacters, lengthOfText;
	double movePerUnitKeyPressed, moveTotal;
	javax.swing.text.Style style;
	TextDetailsClass textDetails;
	Database database;
	int userId;
	
	public Practice() {
		
		database = new Database();
		soundObj = new Sound();
		upperLayoutObj = new UpperLayout();
		centerLayoutObj = new CenterLayout();
		myCarObj = new Car();
		timerObj = new Timer();
		
//		if(myCarObj.isAlive()==false)
//			myCarObj.start();
		
//		myCarObj.suspendCarThread();
		
		if(timerObj.isAlive()==false)
			timerObj.start();
		
		timerObj.suspendTimerThread();
		
		centerLayoutObj.textPane.setStyledDocument(centerLayoutObj.doc);
		style = centerLayoutObj.textPane.addStyle("color", null);
		StyleConstants.setForeground(style, Color.black);
		
		
		
		//..............................
		//..........COMBO BOX...........
		//..............................
		
		setTextComboBoxPracticeClass = new JComboBox<String>();
		setTextComboBoxPracticeClass.setBounds(85, 2, 230, 22);
	
		textDetails = new TextDetailsClass();
		for(int i=0; i<200; i++)
		{
			String addTextToComboBox = textDetails.textForTyping[i];
			addTextToComboBox = addTextToComboBox.substring(0, 50);
			addTextToComboBox = String.valueOf(i+1)+". "+addTextToComboBox.trim();
			setTextComboBoxPracticeClass.addItem(addTextToComboBox);
		}
		
		//................................
		//.............LABEL..............
		//................................
		
		setTextLabel = new JLabel(new ImageIcon("setText1.png"));
		setTextLabel.setBounds(5, 4, 80, 20);
		setTextLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		setTextLabel.setForeground(Color.blue);
		
		pasteTextLabel = new JLabel(new ImageIcon("pasteText1.png"));
		pasteTextLabel.setBounds(403, 4, 75, 20);
		
		upperLayoutObj.labelProfileName.setText("Abdul Halim  ");
		upperLayoutObj.labelPanelTitleName.setText("Practice");

//		rectangleBorderLabelPracticeClass = new JLabel(new ImageIcon("rectangleBorder7.png"));
//		rectangleBorderLabelPracticeClass.setBounds(0, 0, 880, 590);
		
//		JLabel t = new JLabel("salsmanasdf");
//		t.setBounds(50, 50, 200, 50);
//		upperLayoutObj.panelInsideCenterPanel.add(t);
		
		//...........TextField...........
		pasteHereTextFieldPracticeClass = new JTextField("");
		pasteHereTextFieldPracticeClass.setBounds(488, 2, 170, 23);
//		pasteHereTextFieldPracticeClass.setFont(new Font("Kalpurush",Font.BOLD,17));
		
		//................................
		//...........Button...............
		//................................
		addTextButtonPracticeClass = new JButton(new ImageIcon("set3.png"));
		addTextButtonPracticeClass.setBounds(662, 2, 40, 23);

		//................................
		//..........Panel.................
		//................................
		
		upperLayoutObj.panel4.add(setTextLabel);
		upperLayoutObj.panel4.add(setTextComboBoxPracticeClass);
		upperLayoutObj.panel4.add(pasteTextLabel);
		upperLayoutObj.panel4.add(pasteHereTextFieldPracticeClass);
		upperLayoutObj.panel4.add(addTextButtonPracticeClass);
		upperLayoutObj.panel4.add(soundObj.soundPanel);
		
		//...................Adding From TimerClass............
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.timerLabel);
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.wpmLabel);
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.runningSpeedLabel);
		upperLayoutObj.panelInsideCenterPanel.add(timerObj.speedLabel);
		
		//.....................................................
		//................Adding from centerLayout.............
		centerLayoutObj.newRaceButton.setVisible(false);
		centerLayoutObj.nextButton.setVisible(false);
		centerLayoutObj.youWonLabel.setVisible(false);
		centerLayoutObj.restartButton.setVisible(false);
		centerLayoutObj.tryAgainButton.setVisible(false);
		centerLayoutObj.scoreLabel.setVisible(false);
//		centerLayoutObjPracticeClass.speedLabel.setVisible(false);
		centerLayoutObj.tryAgainButton.setBounds(50, 150, 80, 30);
		centerLayoutObj.borderInsideRectangleBorder.setBounds(0, -20, 880, 590);
		centerLayoutObj.textPane.setBounds(60, 210, 595, 224);
		centerLayoutObj.typeToStartPanel.setBounds(55, 170, 605, 30);
		centerLayoutObj.typeHereLabel.setBounds(103, 470, 90, 30);
		centerLayoutObj.typeHereTextField.setBounds(190, 470, 400, 30);
		
		
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.rectangleBorderLabel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.borderInsideRectangleBorder);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.typeHereLabel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.typeHereTextField);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.typeToStartPanel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.resultPanel);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.roadLabel1);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.textPane);
		upperLayoutObj.panelInsideCenterPanel.add(centerLayoutObj.backButton);
//		upperLayoutObjPracticeClass.panelInsideCenterPanel.add(centerLayoutObjPracticeClass.backButton);
//		upperLayoutObjPracticeClass.panelInsideCenterPanel.add(centerLayoutObjPracticeClass.flagLabel1);
//		upperLayoutObjPracticeClass.panelInsideCenterPanel.add(centerLayoutObjPracticeClass.backButton);
		
		
		upperLayoutObj.panelInsideCenterPanel.add(myCarObj.changeCarPanel);
		upperLayoutObj.panelInsideCenterPanel.add(myCarObj.carLabel);

		////////////////////////////////////////////////////////////
		
		
		//............Calling All kinds of METHODs.......................
		setInitialPracticeClass();
		
		
		//..................................................
		practicePanel = new JPanel();
		practicePanel.setBackground(Color.white);
		practicePanel.setLayout(new BorderLayout());
		
		new BorderLayout();
		practicePanel.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		practicePanel.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(practicePanel);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
		
		//******************************************************
		//..............LISTENERS...............................
		
		//ComboBox
		setTextComboBoxPracticeClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				int index = setTextComboBoxPracticeClass.getSelectedIndex();
				
				timerObj.suspendTimerThread();
				saveToDatabase();
				centerLayoutObj.textPane.setText(textDetails.textForTyping[index]);
				setInitialPracticeClass();
			}
		});
		
		//add button or SET
		addTextButtonPracticeClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addText = pasteHereTextFieldPracticeClass.getText();
				addText = addText.trim();
				if(addText.length()>0)
				{
					if(addText.length()>880)
						addText = addText.substring(0, 880);
					addText = addText.trim();
					centerLayoutObj.textPane.setText(addText);
					
					timerObj.suspendTimerThread();
					saveToDatabase();
					setInitialPracticeClass();
				}
				else
				{
					JOptionPane.showMessageDialog(practicePanel, "The text is too short!");
//					centerLayoutObj.typeHereLabel.setVisible(false);
//					centerLayoutObj.typeHereTextField.setVisible(false);
					pasteHereTextFieldPracticeClass.setText(null);
//					System.out.println(addText.length());
				}
			}
		});
		
		//tryAgain Button
		centerLayoutObj.tryAgainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setInitialPracticeClass();
			}
		});
		
		//Restart Button
		centerLayoutObj.restartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timerObj.suspendTimerThread();
				timerObj.wasSuspended();
				saveToDatabase();
				setInitialPracticeClass();
				
			}
		});
		
		//...........................................................................
		//............................KEY LISTENER HANDLING..........................
		//...........................................................................
		centerLayoutObj.typeHereTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent evt) {
				
				if(evt.getKeyChar()!=KeyEvent.VK_BACK_SPACE)
				{
						timerObj.resumeTimerThread(); 
						setFalseAfterThreadStart();
						setTrueAfterThreadStart();
					if(stringOfTextPane.charAt(currentPosition)==evt.getKeyChar())
					{
						if(evt.getKeyChar()==KeyEvent.VK_SPACE)
							Sound.playSoundSpace();
						else
							Sound.playSoundKey();
						StyleConstants.setForeground(style, Color.green);
						centerLayoutObj.doc.setCharacterAttributes(currentPosition, 1, centerLayoutObj.textPane.getStyle("color"), true);
						
						if(evt.getKeyChar()==KeyEvent.VK_SPACE)
							centerLayoutObj.typeHereTextField.setText("");
						moveTotal+=movePerUnitKeyPressed;
						myCarObj.setCarPosition((int)moveTotal+60, myCarObj.carY);
					}
					/////////////////////////
					else
					{
						StyleConstants.setForeground(style, Color.red);
						centerLayoutObj.doc.setCharacterAttributes(currentPosition, 1, centerLayoutObj.textPane.getStyle("color"), true);
						typedTotalWrongCharacters++;
						
					}
					currentPosition++;
					if(currentPosition==lengthOfText)
					{
//							myCarObj.suspendCarThread();
							timerObj.suspendTimerThread();
							setFalseAfterThreadSuspend();
							setTrueAfterThreadSuspend();
							setAccuracy();
							setSpeed();
							saveToDatabase();
							centerLayoutObj.typeToStartLabel.setText("");
							System.out.println(typedTotalWrongCharacters);
							System.out.println(lengthOfText-typedTotalWrongCharacters);
							
					}
					else
						setTextToTypeHereToStart();
					timerObj.setTypingCurrentPosition(currentPosition-typedTotalWrongCharacters);
					///////////////////
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent evt) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent evt) {
				
			}
		});
	}
	
	//.............METHODS..................
	
	public void setInitialPracticeClass(){
		myCarObj.setCarPosition(60, 40); // 660, so distance = 600;
		moveTotal=0;
		currentPosition=0;
		typedTotalWrongCharacters=0;
		stringOfTextPane = centerLayoutObj.textPane.getText();
		lengthOfText= stringOfTextPane.length();
		movePerUnitKeyPressed=600.0/(double)lengthOfText;
		
		StyleConstants.setForeground(style, Color.black);
		centerLayoutObj.doc.setCharacterAttributes(0, lengthOfText, centerLayoutObj.textPane.getStyle("color"), true);
		
		
		timerObj.setInitialTimerClass(); // setting initial to TimerClass
		timerObj.wpmLabel.setVisible(false);
		
		centerLayoutObj.setInitialCenterLayoutClass(); // setting initial to centerLayoutClass
		
		centerLayoutObj.tryAgainButton.setVisible(false);
		centerLayoutObj.restartButton.setVisible(false);
		
	}
	
	
	
	public void setTrueAfterThreadStart()
	{
		centerLayoutObj.restartButton.setVisible(true);
		timerObj.runningSpeedLabel.setVisible(true);
	}
	
	public void setFalseAfterThreadStart()
	{
//		setTextComboBoxPracticeClass.setVisible(false);
//		setTextLabel.setVisible(false);
//		pasteHereTextFieldPracticeClass.setVisible(false);
//		pasteTextLabel.setVisible(false);
//		addTextButtonPracticeClass.setVisible(false);
		
	}
	
	public void setTrueAfterThreadSuspend()
	{
		centerLayoutObj.tryAgainButton.setVisible(true);
//		centerLayoutObjPracticeClass.speedLabel.setVisible(true);
		centerLayoutObj.accuracyLabel.setVisible(true);
		centerLayoutObj.correctlyTypedCharacterLabel.setVisible(true);
		centerLayoutObj.mistypedCharacterLabel.setVisible(true);

//		setTextComboBoxPracticeClass.setVisible(true);
//		setTextLabel.setVisible(true);
//		pasteHereTextFieldPracticeClass.setVisible(true);
//		pasteTextLabel.setVisible(true);
//		addTextButtonPracticeClass.setVisible(true);
		
		
	}
	
	public void setFalseAfterThreadSuspend()
	{
		centerLayoutObj.typeHereTextField.setVisible(false);
		centerLayoutObj.typeToStartLabel.setVisible(false);
		centerLayoutObj.typeHereLabel.setVisible(false);
		centerLayoutObj.restartButton.setVisible(false);
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
		double acc = (double)(lengthOfText-typedTotalWrongCharacters)/(double)lengthOfText;
		acc*=100.0;
		centerLayoutObj.accuracyLabel.setText("Accuracy : "+String.valueOf(Double.parseDouble(String.format("%.2f", acc))) +"%");
		
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
	}
	
	public void saveToDatabase(){
		saveTypedCharactersAndTime();
	}
	
	public void saveTypedCharactersAndTime(){
		int typedCharacters = currentPosition-typedTotalWrongCharacters;
		//update tbl_total....
		database.updatingTotal(userId, typedCharacters, (int)timerObj.seconds);
		currentPosition=0; typedTotalWrongCharacters=0;
		timerObj.seconds=0;
	}
	
	public static void main(String[] args) {
		new Practice();
	}
}
