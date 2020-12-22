package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Home{

	JFrame testFrame;
	JPanel panelHome, panelBelowProfilePic;
	JLabel labelDefaultProPic, labelRectangleBorder, labelProPicBorder, labelProPic, labelAvgSpeed, labelBestSpeed, labelTotalTypedChar, labelTotalPlayedRaces, labelTotalRacesWon, labelTotalPlayingTime, labelExperience, labelYourTypingSpeed, labelProfileNameBelowDp, labelStatistic;
	JButton updateDpButton, learnTouchTypingButton, practiceButton, raceButton, raceHistoryButton, rankListButton, settingsButton, signOutButton;
	UpperLayout upperLayoutObj;
	int userId;
	Database database;
	
	public Home() {
		
		database = new Database();
		upperLayoutObj = new UpperLayout();
		
		////////////////////////////////////////////////////////////
		//.............................Label........................
		upperLayoutObj.labelProfileName.setText("Salman Cho222  ");
		upperLayoutObj.labelPanelTitleName.setText("HOME");
		
		labelRectangleBorder = new JLabel(new ImageIcon("rectangleBorder7.png"));
		labelRectangleBorder.setBounds(0, 0, 880, 590);
		
		labelProfileNameBelowDp = new JLabel("DSDD MAJHARUL ISLAM RAFAT");
//		profileNameLabelBelowDp.setForeground(Color.getHSBColor(800, 89, 108));
		labelProfileNameBelowDp.setForeground(Color.decode("125569900"));
		labelProfileNameBelowDp.setFont(new Font("Dialog", Font.BOLD, 13));
		
		//-----------Profile Pic----------------------
		labelProPicBorder = new JLabel(new ImageIcon("proPicBorder6.png"));
		labelProPicBorder.setBounds(240, 54, 108, 110);
		
		labelProPic = new JLabel();
		labelProPic.setBounds(243, 50, 100, 100);
		
		labelDefaultProPic = new JLabel(new ImageIcon("blankProPic1.png"));
		labelDefaultProPic.setBounds(229, 45, 108, 110);
		
		upperLayoutObj.panelInsideCenterPanel.add(labelProPicBorder);
		upperLayoutObj.panelInsideCenterPanel.add(labelProPic);
		upperLayoutObj.panelInsideCenterPanel.add(labelDefaultProPic);
		
		//-------------------//--------------------//--
		
		labelStatistic = new JLabel("<html>Average typing speed<br>Best typing speed<br>Played races<br>Races won<br>Typed characters<br>Playing time<br>Your typing is speed is<br>Experience level<html>");
		labelStatistic.setBounds(400, 15, 200, 221);
		labelStatistic.setForeground(Color.decode("12599"));
		labelStatistic.setFont(new Font("Dialog", Font.BOLD, 14));
		
		labelAvgSpeed = new JLabel("51 WPM / 255 CPM");
		labelAvgSpeed.setBounds(590, 34, 300, 50);
		labelAvgSpeed.setForeground(Color.decode("12599"));
		labelAvgSpeed.setFont(new Font("Dialog", Font.BOLD, 13));
		
		labelBestSpeed = new JLabel("66 WPM / 330 CPM");
		labelBestSpeed.setForeground(Color.decode("12599"));
		labelBestSpeed.setBounds(590, 52, 300, 50);
		labelBestSpeed.setFont(new Font("Dialog", Font.BOLD, 13));
		
		labelTotalPlayedRaces = new JLabel("27");
		labelTotalPlayedRaces.setForeground(Color.decode("12599"));
		labelTotalPlayedRaces.setBounds(590, 71, 300, 50);
		labelTotalPlayedRaces.setFont(new Font("Dialog", Font.BOLD, 13));
		
		labelTotalRacesWon = new JLabel("17");	
		labelTotalRacesWon.setForeground(Color.decode("12599"));
		labelTotalRacesWon.setBounds(590, 89, 300, 50);
		labelTotalRacesWon.setFont(new Font("Dialog", Font.BOLD, 13));
		
		labelTotalTypedChar = new JLabel("2343");
		labelTotalTypedChar.setForeground(Color.decode("12599"));
		labelTotalTypedChar.setBounds(590, 108, 300, 50);
		labelTotalTypedChar.setFont(new Font("Dialog", Font.BOLD, 13));
		
		labelTotalPlayingTime = new JLabel("165 minutes");
		labelTotalPlayingTime.setForeground(Color.decode("12599"));
		labelTotalPlayingTime.setBounds(590, 128, 300, 50);
		labelTotalPlayingTime.setFont(new Font("Dialog", Font.BOLD, 13));
		
		labelYourTypingSpeed = new JLabel("Fluent");
		labelYourTypingSpeed.setForeground(Color.decode("12599"));
		labelYourTypingSpeed.setBounds(590, 148, 300, 50);
		labelYourTypingSpeed.setFont(new Font("Dialog", Font.BOLD, 13));
		
		labelExperience = new JLabel("3");
		labelExperience.setForeground(Color.decode("12599"));
		labelExperience.setBounds(590, 167, 300, 50);
		labelExperience.setFont(new Font("Dialog", Font.BOLD, 13));
		
		///////////////////////////////////////////////////////////////
		//..........................BUTTON............................
//		updateDpButton = new JButton(new ImageIcon("updateDp1.png"));
		updateDpButton = new JButton("<html><u>Update<u><html>");
		updateDpButton.setBackground(Color.white);
//		updateDpButton.setFont(new Font("Dialog", Font.BOLD, 12));
		updateDpButton.setBounds(242, 145, 80, 18);
		updateDpButton.setBorderPainted(false);
		
		learnTouchTypingButton = new JButton(new ImageIcon("learnTouchTypingButton10.png"));
		learnTouchTypingButton.setBorderPainted(false);
		learnTouchTypingButton.setVisible(false);
		learnTouchTypingButton.setBounds(326, 245, 248, 40);
		
		practiceButton = new JButton(new ImageIcon("practiceButton1.png"));
		practiceButton.setBounds(330, 285, 243, 40);
		practiceButton.setBorderPainted(false);
		
		raceButton = new JButton(new ImageIcon("raceButton2.png"));
		raceButton.setBounds(330, 325, 243, 40);
		raceButton.setBorderPainted(false);
		
		raceHistoryButton = new JButton(new ImageIcon("raceHistoryButton1.png"));
		raceHistoryButton.setBounds(335, 365, 233, 40);
		raceHistoryButton.setBorderPainted(false);
		
		rankListButton = new JButton(new ImageIcon("rankListButton2.png"));
		rankListButton.setBounds(340, 405, 223, 40);
		rankListButton.setBorderPainted(false);
		
		settingsButton = new JButton(new ImageIcon("settingsButton1.png"));
		settingsButton.setBounds(345, 445, 213, 40);
		settingsButton.setBorderPainted(false);
		
		signOutButton = new JButton(new ImageIcon("signOutButton2.png"));
		signOutButton.setBounds(355, 485, 193, 40);
		signOutButton.setBorderPainted(false);
		
		upperLayoutObj.panelInsideCenterPanel.add(updateDpButton);
		upperLayoutObj.panelInsideCenterPanel.add(learnTouchTypingButton);
		upperLayoutObj.panelInsideCenterPanel.add(practiceButton);
		upperLayoutObj.panelInsideCenterPanel.add(raceButton);
		upperLayoutObj.panelInsideCenterPanel.add(raceHistoryButton);
		upperLayoutObj.panelInsideCenterPanel.add(rankListButton);
		upperLayoutObj.panelInsideCenterPanel.add(settingsButton);
		upperLayoutObj.panelInsideCenterPanel.add(signOutButton);
		
		
		//.............Adding to panel...............................
		
		upperLayoutObj.panelInsideCenterPanel.add(labelRectangleBorder);
		upperLayoutObj.panelInsideCenterPanel.add(labelStatistic);
		upperLayoutObj.panelInsideCenterPanel.add(labelAvgSpeed);
		upperLayoutObj.panelInsideCenterPanel.add(labelBestSpeed);
		upperLayoutObj.panelInsideCenterPanel.add(labelTotalPlayedRaces);
		upperLayoutObj.panelInsideCenterPanel.add(labelTotalRacesWon);
		upperLayoutObj.panelInsideCenterPanel.add(labelTotalTypedChar);
		upperLayoutObj.panelInsideCenterPanel.add(labelTotalPlayingTime);
		upperLayoutObj.panelInsideCenterPanel.add(labelExperience);
		upperLayoutObj.panelInsideCenterPanel.add(labelYourTypingSpeed);

		
		//..............Panel.....................
		panelBelowProfilePic = new JPanel();
		panelBelowProfilePic.setBounds(157, 160, 250, 30);
		panelBelowProfilePic.setBackground(Color.WHITE);
		
		panelBelowProfilePic.add(labelProfileNameBelowDp);
		
		upperLayoutObj.panelInsideCenterPanel.add(panelBelowProfilePic);
		
		
		
		//................................
		//.........Main Panel...............
		//................................
		
		panelHome = new JPanel();
		panelHome.setBackground(Color.white);
		panelHome.setLayout(new BorderLayout());
		
		new BorderLayout();
		panelHome.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		panelHome.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		//..........Testing Frame............
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(panelHome);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
		
		
		//......................Action LISTENERS.....................
		updateDpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setProfilePic();
			}
		});
		
		//....................Mouse listeners..................
		learnTouchTypingButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				learnTouchTypingButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				learnTouchTypingButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		practiceButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				practiceButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				practiceButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		raceButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				raceButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				raceButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		raceHistoryButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				raceHistoryButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				raceHistoryButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		rankListButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				rankListButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				rankListButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		settingsButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				settingsButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				settingsButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		signOutButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				signOutButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				signOutButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		updateDpButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				updateDpButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				updateDpButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
	}
	
	
	public void setProfilePic(){
		JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String sname = file.getAbsolutePath();
            
            //checking image supported format (.png, .jpg, .gif)
            if((sname.charAt(sname.length()-1)=='g'  && sname.charAt(sname.length()-2)=='n' && sname.charAt(sname.length()-3)=='p') || (sname.charAt(sname.length()-1)=='g'  && sname.charAt(sname.length()-2)=='p' && sname.charAt(sname.length()-3)=='j') || (sname.charAt(sname.length()-1)=='f'  && sname.charAt(sname.length()-2)=='i' && sname.charAt(sname.length()-3)=='g') || (sname.charAt(sname.length()-1)=='G'  && sname.charAt(sname.length()-2)=='N' && sname.charAt(sname.length()-3)=='P') || (sname.charAt(sname.length()-1)=='G'  && sname.charAt(sname.length()-2)=='P' && sname.charAt(sname.length()-3)=='J') || (sname.charAt(sname.length()-1)=='F'  && sname.charAt(sname.length()-2)=='I' && sname.charAt(sname.length()-3)=='G'))
            {
            	ImageIcon imgIcon = new ImageIcon(sname);
              
            	Image img = imgIcon.getImage().getScaledInstance(78, 84, Image.SCALE_SMOOTH);
            	ImageIcon finalImage = new ImageIcon(img);
            	labelProPic.setIcon(finalImage);
            	
            	database.deleteProfilePic(userId);
            	int len = (int) file.length();
            	try {
					database.insertIntoProfilePicture(userId, (new FileInputStream(file)), len);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            	//save image As profile pic into database
            }
        }
		
	}
	
//	public static void main(String[] args) {
//		new Home();
//	}

}
