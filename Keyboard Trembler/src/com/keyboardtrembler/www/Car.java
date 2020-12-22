package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Car{
	JLabel carLabel, changeCarLabel;
	JButton changeCarButtonLeft, changeCarButtonRight;
	JPanel changeCarPanel;
	int carX, carY, carNo, computerCarMovingUnit;
	
	//....constructor.......
	public Car() {
//		runCar=true; suspended=false;
		carX=0; carY=0; computerCarMovingUnit=0;
		carNo=2;
		
		//...........Label......................
		
		carLabel = new JLabel(new ImageIcon("sky1.png"));
		carLabel.setBounds(carX, carY, 170, 80);
		
		//..........Change Car..................			
		changeCarLabel = new JLabel(new ImageIcon("changeCar4.png"));
		changeCarLabel.setBounds(-1, -5, 85, 30);
		
		changeCarButtonLeft = new JButton(new ImageIcon("changeCarLeftButton2.png"));
		changeCarButtonLeft.setBounds(85, 0, 20, 20);
		changeCarButtonLeft.setBorderPainted(false);
		changeCarButtonLeft.setBackground(Color.white);
				
		changeCarButtonRight = new JButton(new ImageIcon("changeCarRightButton1.png"));
		changeCarButtonRight.setBounds(105, 0, 20, 20);
		changeCarButtonRight.setBorderPainted(false);
		changeCarButtonRight.setBackground(Color.white);
				
		changeCarPanel = new JPanel();
		changeCarPanel.setBounds(730, 10, 135, 30);
		changeCarPanel.setBackground(Color.white);
		changeCarPanel.setLayout(null);
		
		changeCarPanel.add(changeCarButtonLeft);
		changeCarPanel.add(changeCarButtonRight);
		changeCarPanel.add(changeCarLabel);
		
		////////////////////////////////////////////////
		//.............ACTION LISTENSER...............//
		changeCarButtonLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(carNo==1)
					carNo=14;
				else
					carNo--;
				setCarIcon(carNo);
			}
		});
		
		changeCarButtonRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(carNo==14)
					carNo=1;
				else
					carNo++;
				setCarIcon(carNo);
			}
		});
		
		//Add change car button Mouse listener...
		changeCarButtonLeft.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				changeCarButtonLeft.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				changeCarButtonLeft.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		changeCarButtonRight.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				changeCarButtonRight.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				changeCarButtonRight.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
	}
	
	public void setCarPosition(int carX, int carY){
		this.carX=carX;
		this.carY=carY;
		carLabel.setBounds(carX, carY, 170, 80);
	}
	
	public void setCarIcon(int carNo){
		String str = "kar"+ String.valueOf(carNo) + ".png";
		ImageIcon icon = new ImageIcon(str);
		carLabel.setIcon(icon);
	}
}
