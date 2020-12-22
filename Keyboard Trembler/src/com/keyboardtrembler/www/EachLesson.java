package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class EachLesson {

	JFrame testFrame;
	JPanel EachLessonPanel;
	UpperLayout upperLayoutObj;
	Sound soundObj;
	CenterLayout centerLayoutObj;
	Timer timerObj;
	public EachLesson() {
		
		upperLayoutObj = new UpperLayout();
		soundObj = new Sound();
		centerLayoutObj = new CenterLayout();
		timerObj = new Timer();
		
		if(timerObj.isAlive()==false)
			timerObj.start();
		
		timerObj.suspendTimerThread();
		
		//.............Label..............
		upperLayoutObj.labelProfileName.setText("Salman Chowdhury  ");
		upperLayoutObj.labelPanelTitleName.setText("Each Lesson");
		
		
		//................................
		//............Panel...............
		//................................
		
		upperLayoutObj.panel4.add(soundObj.soundPanel);
		
		EachLessonPanel = new JPanel();
		EachLessonPanel.setBackground(Color.white);
		EachLessonPanel.setLayout(new BorderLayout());
		
		new BorderLayout();
		EachLessonPanel.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		EachLessonPanel.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(EachLessonPanel);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
	}
	
//	public static void main(String[] args) {
//		new EachLesson();
//	}
}
