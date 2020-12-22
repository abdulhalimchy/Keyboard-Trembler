package com.keyboardtrembler.www;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class RaceHistory extends Database{

	JFrame testFrame;
	JPanel RaceHistoryPanel;
	UpperLayout upperLayoutObj;
	JButton backButtonRaceHistoryClass;
	JLabel rectangleBorderLabel;
	JTable raceHistoryTable;
	DefaultTableModel model;
	JScrollPane scrollPane;
	int userId;
	
	public RaceHistory() {

		upperLayoutObj = new UpperLayout();
		
		////////////////////////////////////////////////////////
		//......................Table...........................
		raceHistoryTable = new JTable(){  
      	  public boolean isCellEditable(int row, int column){  
  		    return false;  
  		  }  
  		};
  		
		
  		Object[] columns = {"<html><h3>Race#<h3><html>","<html><h3>Speed<h3><html>","<html><h3>Accuracy<h3><html>","<html><h3>Status<h3><html>", "<html><h3>Date<h3><html>"};
		
  		model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        model.isCellEditable(0, 0);
        // set the model to the table
        raceHistoryTable.setModel(model);
        raceHistoryTable.setLayout(new FlowLayout());
        
     // Change A JTable Background Color, Font Size, Font Color, Row Height
        raceHistoryTable.setBackground(Color.decode("10025100"));
        raceHistoryTable.setForeground(Color.black);
        raceHistoryTable.setFont(new Font("Dialog", Font.BOLD, 12));
        raceHistoryTable.setRowHeight(30);
        
        scrollPane = new JScrollPane(raceHistoryTable);
        scrollPane.setBounds(40, 70, 800, 400);
        scrollPane.setBorder(new LineBorder(Color.decode("10016352"), 2));
        
        Object[] row = new Object[5];
        
        row[0]="1";
        row[1]="51 WPM";
        row[2]="98.50%";
        row[3]="WON";
        row[4]="2017-12-05";
        
        model.addRow(row);
        model.addRow(row);
        
        
        //////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////
        					//////////////////////
  		
		//.............Label..............
		rectangleBorderLabel = new JLabel(new ImageIcon("rectangleBorder7.png"));
		rectangleBorderLabel.setBounds(0, 0, 880, 590);
		
		upperLayoutObj.labelProfileName.setText("Salman Chowdhury  ");
		upperLayoutObj.labelPanelTitleName.setText("Race History");
		
		//...........Button..............
		backButtonRaceHistoryClass  = new JButton(new ImageIcon("back1.png"));
		backButtonRaceHistoryClass.setBounds(420,530, 45, 25);
		
		
		//................adding to panel................
		upperLayoutObj.panelInsideCenterPanel.add(rectangleBorderLabel);
		upperLayoutObj.panelInsideCenterPanel.add(backButtonRaceHistoryClass);
		upperLayoutObj.panelInsideCenterPanel.add(scrollPane);
		
		
		//................................
		//............Panel...............
		//................................
		
		RaceHistoryPanel = new JPanel();
		RaceHistoryPanel.setBackground(Color.white);
		RaceHistoryPanel.setLayout(new BorderLayout());
		
		new BorderLayout();
		RaceHistoryPanel.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		RaceHistoryPanel.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(RaceHistoryPanel);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
		
//		insertingToTable();
	}
	
	public void insertingToTable(){
		model.setRowCount(0);
		ArrayList<raceDetails> list = getRaceDetails(userId);
		int size=list.size();
		Iterator<raceDetails> itr = list.iterator();
		while(itr.hasNext())
		{
			Object[] row = new Object[5];
			raceDetails rd = (raceDetails) itr.next();
			row[0]=String.valueOf(size);
			row[1]=String.valueOf(rd.speed+" WPM");
			row[2]=String.valueOf(rd.accuracy+"%");
			row[3]=String.valueOf(rd.status);
			row[4]=String.valueOf(rd.date);
			model.addRow(row);
			size--;
		}
	}
	
//	public static void main(String[] args) {
//		new RaceHistory();
//	}

}
