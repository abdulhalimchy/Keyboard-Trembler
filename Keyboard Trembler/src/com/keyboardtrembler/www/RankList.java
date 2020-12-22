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

public class RankList extends Database{

	JFrame testFrame;
	JPanel RankListPanel;
	UpperLayout upperLayoutObj;
	JTable rankListTable;
	JScrollPane scrollPane;
	DefaultTableModel model;
	JLabel rectangleBorderLabel, yourRankLabel;
	JButton backButtonRankListClass;
	int userId;
	public RankList() {
		
		upperLayoutObj = new UpperLayout();
		
		////////////////////////////////////////////////////////
		//......................Table...........................
		rankListTable = new JTable(){  
			public boolean isCellEditable(int row, int column){  
				return false;  
			}  
		};

		Object[] columns = {"<html><h3>Rank<h3><html>","<html><h3>Username<h3><html>","<html><h3>Average Speed<h3><html>","<html><h3>Best Speed<h3><html>", "<html><h3>Average Accuracy<h3><html>"};

		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		model.isCellEditable(0, 0);
		// set the model to the table
		rankListTable.setModel(model);
		rankListTable.setLayout(new FlowLayout());
		
		// Change A JTable Background Color, Font Size, Font Color, Row Height
		rankListTable.setBackground(Color.decode("10025100"));
		rankListTable.setForeground(Color.black);
		rankListTable.setFont(new Font("Dialog", Font.BOLD, 12));
		rankListTable.setRowHeight(30);

		scrollPane = new JScrollPane(rankListTable);
		scrollPane.setBounds(30, 70, 820, 420);
		scrollPane.setBorder(new LineBorder(Color.decode("10016352"), 2));

		Object[] row = new Object[5];
		
		row[0]="1";
		row[1]="abdulhalim";
		row[2]="51 WPM";
		row[3]="61 WPM";
		row[4]="95.05%";
		
		model.addRow(row);
		
		//.............Label..............

		rectangleBorderLabel = new JLabel(new ImageIcon("rectangleBorder7.png"));
		rectangleBorderLabel.setBounds(0, 0, 880, 590);
		
		upperLayoutObj.labelProfileName.setText("Salman Chowdhury  ");
		upperLayoutObj.labelPanelTitleName.setText("RANK LIST");
		
		yourRankLabel = new JLabel("You didn't participate yet!");
		yourRankLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		yourRankLabel.setBounds(385, 20, 300, 30);
		
		//...................Button.......................
		backButtonRankListClass = new JButton(new ImageIcon("back1.png"));
		backButtonRankListClass.setBounds(420,530, 45, 25);
		
		
		//...........Adding to panel...............................
		upperLayoutObj.panelInsideCenterPanel.add(scrollPane);
		upperLayoutObj.panelInsideCenterPanel.add(rectangleBorderLabel);
		upperLayoutObj.panelInsideCenterPanel.add(backButtonRankListClass);
		upperLayoutObj.panelInsideCenterPanel.add(yourRankLabel);
		
		
		
		
		//................................
		//............Panel...............
		//................................
		
		RankListPanel = new JPanel();
		RankListPanel.setBackground(Color.white);
		RankListPanel.setLayout(new BorderLayout());
		
		new BorderLayout();
		RankListPanel.add(upperLayoutObj.panelCenter, BorderLayout.CENTER);
		new BorderLayout();
		RankListPanel.add(upperLayoutObj.panelInsideNorth, BorderLayout.NORTH);
		
		
//		testFrame  = new JFrame();
//		testFrame.setMinimumSize(new Dimension(900, 700));
//		testFrame.setLayout(new GridLayout(1,1));
//		testFrame.setVisible(true);
//		testFrame.getContentPane().setBackground(Color.white);
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		testFrame.add(newPasswordRecoveryPanel, new GridBagConstraints());
//		testFrame.add(RankListPanel);
//		Image frameIcon = Toolkit.getDefaultToolkit().getImage("frameIcon3.png");
//		testFrame.setIconImage(frameIcon);
		
		
		insertingToTable();
	}
	
	public void insertingToTable(){
		model.setRowCount(0);
		ArrayList<rankDetails> list = getRankDetails();
		Iterator<rankDetails> itr = list.iterator();
		int rank=1;
		while(itr.hasNext())
		{
			Object[] row = new Object[5];
			rankDetails rd = (rankDetails) itr.next();
			row[0]="#"+String.valueOf(rank);
			row[1]=rd.userName;
			row[2]=String.valueOf((int)rd.avgSpeed +" WPM");
			row[3]=String.valueOf(rd.bestSpeed+" WPM");
			row[4]=String.valueOf(Double.parseDouble(String.format("%.2f", rd.avgAccuracy))+"%");
			model.addRow(row);
			if(rd.userId==userId)
			{
				yourRankLabel.setText("Your rank is #"+String.valueOf(rank));
				rankListTable.getSelectionModel().addSelectionInterval(rank-1, rank-1);
			}
			rank++;
		}
	}
	
//	public static void main(String[] args) {
//		new RankList();
//	}

}
