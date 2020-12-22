package com.keyboardtrembler.www;
import java.awt.Font;

import javax.swing.JLabel;

public class Timer extends Thread {
	
	int seconds, minutes, hours, typingCurrentPosition, sleepingTime, sleepingTimeOfCar;
	JLabel timerLabel, wpmLabel, runningSpeedLabel, speedLabel;
	boolean timeRunning, suspended, wasSuspended, isItComputerCar, suspendedCar, wasComputerCarSuspended;
	double speed, computerCarMoveTotal, computerCarPerUnitDistance;
	Car computerCarObjTimerClass;
	static int winner; // if winner=1, user won; else if winner=2, then computer win
	public Timer() {
		computerCarObjTimerClass = new Car();
		computerCarMoveTotal=0;
		isItComputerCar=false;
		timerLabel = new JLabel("Time : 00:00:00");
		timerLabel.setBounds(695, 240, 150, 50);
		timerLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		suspended=false;
		wasSuspended=false;
		sleepingTime=0;
		setTimerLabel(0, 0, 0);
		
		wpmLabel = new JLabel("237 WPM");
		wpmLabel.setBounds(815, 80, 70, 30);
		
//		computerCarWpmLabel = new JLabel("233 WPM");
//		computerCarWpmLabel.setBounds(815, 169, 70, 30);
		
		speedLabel = new JLabel("Speed : 236 WPM");
		speedLabel.setBounds(694, 306, 100, 30);
		
		runningSpeedLabel = new JLabel("Running Speed : 0 WPM");
		runningSpeedLabel.setBounds(365, 0, 200, 40);
		runningSpeedLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		setInitialTimerClass();
		
	}
	/////////////////...RUN...///////////////////
	@Override
	public void run() {
		while(timeRunning)
		{
			//only Work as a Timer
			if(isItComputerCar==false)
			{
				synchronized (this) {
					while(suspended){
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
				try {
					sleep(sleepingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				if(wasSuspended==true)
//				{
//					seconds=0;
//					wasSuspended=false;
//				}
				 if(suspended==false)
				 {
					 seconds++;
					 setRunningTime();
					 setRunningSpeed(); 
				 }
			}
			//help to move computer car
			else
			{
				synchronized (this) {
					while(suspendedCar){
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
				try {
					sleep(sleepingTimeOfCar);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				computerCarMoveTotal+=computerCarPerUnitDistance;
				computerCarObjTimerClass.carX=(int)computerCarMoveTotal;
				if(computerCarObjTimerClass.carX>=600)
				{
					computerCarObjTimerClass.carX=600;
					suspendCarThread();
					setWinner(2);
					computerCarMoveTotal=0;
					computerCarObjTimerClass.setCarPosition(computerCarObjTimerClass.carX+60, computerCarObjTimerClass.carY);
				}
				else if(suspendedCar==false)
					computerCarObjTimerClass.setCarPosition(computerCarObjTimerClass.carX+60, computerCarObjTimerClass.carY);
			}
		}
	}
	/////////////////////////////////////
	
	//...........METHODs............
	public void setInitialTimerClass()
	{
		winner=0;
		computerCarMoveTotal=0;
		computerCarPerUnitDistance=0;
		seconds=0; minutes=0; hours=0;
		speed=0;
		sleepingTime=1000;
		timeRunning=true;
		timerLabel.setText("Time : 00:00:00");
		runningSpeedLabel.setText("Running Speed : 0 WPM");
		wpmLabel.setText("0 WPM");
		speedLabel.setText("Speed : 0 WPM");
//		computerCarWpmLabel.setText("0 WPM");
		typingCurrentPosition=0;
		wpmLabel.setVisible(false);
		runningSpeedLabel.setVisible(false);
		speedLabel.setVisible(false);
		
	}
	
	public void setRunningTime()
	{
		minutes = seconds/60;
		hours = minutes/60;
		minutes = minutes%60;
		setTimerLabel(seconds, minutes, hours);
	}
	
	public void stopTime()
	{
		timeRunning=false;
	}
	
	public void setTimerLabel(int s, int m, int h)
	{
		String a = String.valueOf(s%60);
		String b = String.valueOf(m);
		String c = String.valueOf(h);
		String str="";
		
		//hours
		if(h<10)
			str = "0"+c+":";
		else
			str = c+":";
		
		//munites
		if(m<10)
			str+= "0"+b+":";
		else
			str+= b+":";
		
		//seconds
		if(s%60<10)
			str+= "0"+a;
		else
			str+= a;
		
		timerLabel.setText("Time : "+str);
		
	}
	
	public void setRunningSpeed()
	{
		speed  = (double)typingCurrentPosition/5.0;
		if(seconds!=0)
			speed = speed/(double)(seconds/60.0);
		wpmLabel.setText(String.valueOf((int)speed) + " WPM");
		speedLabel.setText("Speed : " + String.valueOf((int)speed) + " WPM");
		runningSpeedLabel.setText("Running Speed : "+String.valueOf((int)speed) + " WPM");
		
	}
	
	public void setTypingCurrentPosition(int currentPosition)
	{
		typingCurrentPosition=currentPosition;
	}
	
	public void suspendTimerThread(){
		suspended=true;
	}
	
	synchronized public void resumeTimerThread(){
		suspended=false;
		notify();
	}
	
	public void wasSuspended(){
		wasSuspended = true;
	}
	
	public void suspendCarThread(){
		suspendedCar=true;
	}
	
	synchronized public void resumeCarThread(){
		suspendedCar=false;
		notify();
	}
	
	public void carSleepingTime(int sleepTime){
		sleepingTimeOfCar = sleepTime;
	}
	
	public void setComputerCarWpm()
	{
		
	}
	
	synchronized public void setWinner(int num)
	{
		if(winner==0)
			winner=num;
	}
	
}