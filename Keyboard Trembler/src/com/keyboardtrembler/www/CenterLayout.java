package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

public class CenterLayout {
	JLabel  speedLabel, flagLabel1, flagLabel2, scoreLabel, correctlyTypedCharacterLabel, mistypedCharacterLabel, accuracyLabel, youWonLabel, typeToStartLabel, roadLabel1, roadLabel2, rectangleBorderLabel, borderInsideRectangleBorder, typeHereLabel;
	JTextField typeHereTextField;
	JButton nextButton, newRaceButton, backButton, restartButton, tryAgainButton;
	JPanel typeToStartPanel, resultPanel;
	JFrame testFrame;
	JTextPane textPane;
	StyledDocument doc;
	public CenterLayout() {
		
		//.................Label.....................
		//...........................................
		flagLabel1 = new JLabel(new ImageIcon("flag3.png"));
		flagLabel1.setBounds(810, 34, 30, 80);
		
		flagLabel2 = new JLabel(new ImageIcon("flag3.png"));
		flagLabel2.setBounds(810, 113, 30, 100);
		
		rectangleBorderLabel = new JLabel(new ImageIcon("rectangleBorder7.png"));
		rectangleBorderLabel.setBounds(0, 0, 880, 590);
	
		borderInsideRectangleBorder = new JLabel(new ImageIcon("borderInsideRectangleBorder5.png"));
		borderInsideRectangleBorder.setBounds(0, 20, 880, 590);
		
		roadLabel1 = new JLabel("  ---------------------------------------------------------------------------------------------");
		roadLabel1.setBounds(65, 96, 880, 20);
		roadLabel1.setFont(new Font("Dialog", Font.BOLD, 25));
		roadLabel1.setForeground(Color.gray);
		
		roadLabel2 = new JLabel("  ---------------------------------------------------------------------------------------------");
		roadLabel2.setBounds(65, 185, 880, 20);
		roadLabel2.setFont(new Font("Dialog", Font.BOLD, 25));
		roadLabel2.setForeground(Color.gray);
		
		typeToStartLabel = new JLabel("TYPE TO START");
		typeToStartLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		typeToStartLabel.setForeground(Color.decode("100100123"));
		
		typeHereLabel = new JLabel(new ImageIcon("typeHere1.png"));
		typeHereLabel.setBounds(101, 490, 90, 30);
		typeHereLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		
		speedLabel = new JLabel("Speed : 237 WPM");
		speedLabel.setBounds(15, 25, 150, 30);
		speedLabel.setForeground(Color.blue);
		
		accuracyLabel  = new JLabel("Accuracy : 100%");
		accuracyLabel.setBounds(15, 45, 150, 30);
//		accuracyLabel.setForeground(Color.blue);
		
		correctlyTypedCharacterLabel  = new JLabel("Perfect : 9999 Characters");
		correctlyTypedCharacterLabel.setBounds(15, 65, 200, 30);
//		correctlyTypedCharacterLabel.setForeground(Color.green);
		
		mistypedCharacterLabel  = new JLabel("Mistyped : 9999 Characters");
		mistypedCharacterLabel.setBounds(15, 85, 200, 30);
//		mistypedCharacterLabel.setForeground(Color.red);
		
		scoreLabel  = new JLabel("Score : 5");
		scoreLabel.setBounds(15, 105, 150, 30);
//		scoreLabel.setForeground(Color.blue);
		
		youWonLabel = new JLabel("YOU LOSE!");
		youWonLabel.setBounds(50, 0, 150, 30);
		youWonLabel.setForeground(Color.decode("125769900"));
		youWonLabel.setFont(new Font("Dialog", Font.PLAIN, 14));	
		
		
		//................TextPane...............
		//.......................................
		doc = (StyledDocument) new DefaultStyledDocument();
		textPane = new JTextPane(doc);
		String text = "Bangladesh is a area of natural beauties. It is located in south-east asia. It has many wonderful scenary and culture. It has the lengthiest organic unbroken sea seaside called Cox's Bazar. Teknaf a position located by the side of Naf stream. This also represents the end point of Cox's Bazar seaside. \"saint Martin\" a little island in the northeast part of the Bay of Bengal. The local name of the isle is Narikel Jinjira significance \"Coconut Island\" in Arabic. The isle is house to several vulnerable varieties of turtles, as well as the corals, some of which are found only on this isle.";
//		String text = "Convection also plays a minor role because of the relative thinness of the air";
//		String text = "Hi my name is Jane. We hardly know each other, but that's about to change. Here you're going to get to know a lot about me, and maybe even more than you can imagine. This whole things kinda like a blind date - I mean here you are in your brand new Corvette, running along the superinformation highway. Put your big muscular arm around me and whisper sweet things in my ear. And I'll promise to do whatever your little heart desires. BUT, only you make the right moves. Just imagine watching me get proposition by my sleez bald boss. BUT, if you make the wrong moves. You could turn me into a nun. Imagine that. Me?! A nun? HA! I don't think so. But it's really all up to you. God knows what you'll do with that hot little mouse of yours. Point is: life's a game, and this game is full of life.";
		textPane.setText(text);
		textPane.setAutoscrolls(true);
		textPane.setBounds(60, 250, 595, 224);
		textPane.setBackground(Color.white);
		textPane.setForeground(Color.black);
		textPane.setFont(new Font("Dialog", Font.BOLD, 14));
		textPane.getScrollableTracksViewportWidth();
		textPane.setEditable(false);
		textPane.setSelectedTextColor(null);
		
		//................TEXTFIELD..............
		typeHereTextField = new JTextField();
		typeHereTextField.setBounds(190, 490, 400, 30);
		typeHereTextField.setBorder(new LineBorder(Color.GRAY, 2));
		typeHereTextField.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		//...............Button....................
		backButton = new JButton(new ImageIcon("back1.png"));
		backButton.setBounds(417, 535, 45, 25);
		backButton.setBorderPainted(false);
		
		tryAgainButton = new JButton(new ImageIcon("tryAgain1.png"));
		tryAgainButton.setBounds(5, 150, 80, 30);
		
		newRaceButton = new JButton(new ImageIcon("newRace1.png"));
		newRaceButton.setBounds(95, 150, 80, 30);
		
		restartButton = new JButton(new ImageIcon("restart1.jpg"));
		restartButton.setBounds(50, 150, 80, 30);
		
		nextButton = new JButton(new ImageIcon("next1.png"));
		nextButton.setBounds(50, 150, 80, 30);
				
		
		//...............Panel.....................
		//.........................................
		typeToStartPanel = new JPanel();
		typeToStartPanel.setBounds(55, 210, 605, 40);
		typeToStartPanel.setBackground(Color.white);
		
		typeToStartPanel.add(typeToStartLabel);
		typeToStartPanel.setBounds(55, 210, 605, 30);
		
		resultPanel  = new JPanel();
		resultPanel.setBounds(680, 280, 180, 200);
		resultPanel.setLayout(null);
		resultPanel.setBackground(Color.white);
//		resultPanel.add(speedLabel);
		resultPanel.add(accuracyLabel);
		resultPanel.add(scoreLabel);
		resultPanel.add(youWonLabel);
		resultPanel.add(tryAgainButton);
		resultPanel.add(newRaceButton);
		resultPanel.add(restartButton);
		resultPanel.add(nextButton);
		resultPanel.add(correctlyTypedCharacterLabel);
		resultPanel.add(mistypedCharacterLabel);
		
		
		////////////////////////////////////////
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(null);
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		testFrame.add(rectangleBorderLabel);
//		testFrame.add(borderInsideRectangleBorder);
//		testFrame.add(roadLabel1);
//		testFrame.add(roadLabel2);
//		testFrame.add(typeToStartPanel);
//		testFrame.add(typeHereTextField);
//		testFrame.add(typeHereLabel);
//		testFrame.add(backButton);
//		testFrame.add(resultPanel);
//		testFrame.add(textPane);
//		testFrame.add(flagLabel1);
//		testFrame.add(flagLabel2);
		
		backButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				backButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				backButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
	}
	
	
	public void setInitialCenterLayoutClass()
	{	
//		speedLabel.setText("Speed : 0 WPM");
		accuracyLabel.setText("Accuracy : 0%");
		correctlyTypedCharacterLabel.setText("Perfect : 0 Characters");
		mistypedCharacterLabel.setText("Mistyped : 0 Characters");
		scoreLabel.setText("Score : 0");
		youWonLabel.setText("No Result");
		
//		speedLabel.setVisible(false);
		accuracyLabel.setVisible(false);
		correctlyTypedCharacterLabel.setVisible(false);
		mistypedCharacterLabel.setVisible(false);
		scoreLabel.setVisible(false);
		youWonLabel.setVisible(false);
		
		typeHereTextField.setText("");
		typeToStartLabel.setText("TYPE TO START");
		typeToStartLabel.setVisible(true);
		typeHereLabel.setVisible(true);
		typeHereTextField.setVisible(true);
	}
	
//	public static void main(String[] args)
//	{
//		new CenterLayout();
//	}
}
