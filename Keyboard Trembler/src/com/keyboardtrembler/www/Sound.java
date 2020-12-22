package com.keyboardtrembler.www;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sound {
	JPanel soundPanel;
	static JButton soundOnButton, soundOffButton;
	static boolean playSound;
	JLabel soundLabel;
	public Sound() {
		
		playSound = true;
		
		soundLabel = new JLabel(new ImageIcon("soundLabel2.png"));
		soundLabel.setBounds(30, 0, 50, 20);
		
		soundOnButton = new JButton(new ImageIcon("soundOn1.png"));
		soundOnButton.setBounds(85, 0, 28, 20);
		soundOnButton.setBorderPainted(false);
		
		soundOffButton = new JButton(new ImageIcon("soundOff1.png"));
		soundOffButton.setBounds(85, 0, 28, 20);
		soundOffButton.setBorderPainted(false);
		
		soundPanel = new JPanel();
		soundPanel.setLayout(null);
		soundPanel.setBounds(760, 2, 120, 25);
		soundPanel.add(soundLabel);
		soundPanel.add(soundOnButton);
		soundPanel.add(soundOffButton);
		soundPanel.setBackground(Color.WHITE);
		
		soundOnButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				soundOnButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				soundOnButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		soundOffButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				soundOffButton.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				soundOffButton.setBorderPainted(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		
		//Mute sound..........
		soundOnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				soundOnButton.setVisible(false);
				soundOffButton.setVisible(true);
				playSound=false;
				
			}
		});
		
		//On sound
		soundOffButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				soundOffButton.setVisible(false);
				soundOnButton.setVisible(true);
				playSound=true;
				
			}
		});
	}
	
	synchronized public static void playSoundSpace() {
		  try {
			  AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("keySound1.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        if(playSound==true)
		        	clip.start();
//		   Thread.sleep(clip.getMicrosecondLength());
//		   clip.stop();
		  } catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
		 }
	
	synchronized public static void playSoundKey() {
		 try{
			  AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("keySound1.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        if(playSound==true)
		        	clip.start();
//		   Thread.sleep(clip.getMicrosecondLength());
//		   clip.stop();
		 	} catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
		}
}
