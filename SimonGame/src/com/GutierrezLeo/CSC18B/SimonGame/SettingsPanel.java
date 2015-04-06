package com.GutierrezLeo.CSC18B.SimonGame;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class SettingsPanel extends JPanel {
	private final Action action = new Save();
	private final Action action_1 = new Cancel();
	private final Action action_2 = new Original();
	private final Action action_3 = new ColorSwatch();
	private final Action action_4 = new SoundOnOff();
	private final Action action_5 = new radioEasy();
	private final Action action_6 = new radioMedium();
	private final Action action_7 = new radioHard();
	private int difficultySetting;
	private SimonWelcome simonWelcome;
	private RegisterFrame registerFrame;
	
	// Constructor
	public SettingsPanel() {
		
		setUpSettingsPanel();

	}
	
	public void setUpSettingsPanel(){
		
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("GAME SETTINGS");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 111, SpringLayout.WEST, this);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		springLayout.putConstraint(SpringLayout.NORTH, lblDifficulty, 32, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblDifficulty, 78, SpringLayout.WEST, this);
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDifficulty.setForeground(Color.WHITE);
		add(lblDifficulty);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setRolloverEnabled(false);
		rdbtnEasy.setAction(action_5);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnEasy, 230, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnEasy, -109, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblDifficulty, -21, SpringLayout.WEST, rdbtnEasy);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnEasy, 0, SpringLayout.NORTH, lblDifficulty);
		rdbtnEasy.setBackground(Color.BLACK);
		rdbtnEasy.setForeground(Color.WHITE);
		add(rdbtnEasy);
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setRolloverEnabled(false);
		rdbtnMedium.setAction(action_6);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMedium, 6, SpringLayout.SOUTH, rdbtnEasy);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMedium, 0, SpringLayout.WEST, rdbtnEasy);
		rdbtnMedium.setBackground(Color.BLACK);
		rdbtnMedium.setForeground(Color.WHITE);
		add(rdbtnMedium);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setRolloverEnabled(false);
		rdbtnHard.setAction(action_7);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnHard, 6, SpringLayout.SOUTH, rdbtnMedium);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnHard, 0, SpringLayout.WEST, rdbtnEasy);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnHard, -109, SpringLayout.EAST, this);
		rdbtnHard.setBackground(Color.BLACK);
		rdbtnHard.setForeground(Color.WHITE);
		add(rdbtnHard);
		
		JLabel lblSound = new JLabel("Sound");
		lblSound.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSound.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblSound, 111, SpringLayout.SOUTH, lblDifficulty);
		springLayout.putConstraint(SpringLayout.WEST, lblSound, 0, SpringLayout.WEST, lblDifficulty);
		add(lblSound);
		
		JToggleButton tglbtnSoundOnoff = new JToggleButton("Sound On/Off");
		tglbtnSoundOnoff.setRolloverEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, tglbtnSoundOnoff, 1, SpringLayout.NORTH, lblSound);
		tglbtnSoundOnoff.setSelected(true);
		tglbtnSoundOnoff.setAction(action_4);
		tglbtnSoundOnoff.setBackground(Color.WHITE);
		tglbtnSoundOnoff.setForeground(Color.BLACK);
		add(tglbtnSoundOnoff);
		
		JLabel lblBackgroundColor = new JLabel("Background Color");
		lblBackgroundColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBackgroundColor.setBackground(Color.BLACK);
		lblBackgroundColor.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblBackgroundColor, 84, SpringLayout.SOUTH, lblSound);
		springLayout.putConstraint(SpringLayout.WEST, lblBackgroundColor, 0, SpringLayout.WEST, lblDifficulty);
		add(lblBackgroundColor);
		
		JButton btnOriginal = new JButton("Original Color");
		btnOriginal.setRolloverEnabled(false);
		btnOriginal.setForeground(new Color(0, 0, 0));
		springLayout.putConstraint(SpringLayout.EAST, btnOriginal, -77, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, tglbtnSoundOnoff, 0, SpringLayout.WEST, btnOriginal);
		btnOriginal.setAction(action_2);
		btnOriginal.setBackground(Color.WHITE);
		btnOriginal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnOriginal, 0, SpringLayout.SOUTH, lblBackgroundColor);
		add(btnOriginal);
		
		JButton btnColorSwatch = new JButton("Color Swatch");
		btnColorSwatch.setRolloverEnabled(false);
		btnColorSwatch.setForeground(new Color(0, 0, 0));
		btnColorSwatch.setAction(action_3);
		btnColorSwatch.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, btnColorSwatch, 21, SpringLayout.SOUTH, btnOriginal);
		springLayout.putConstraint(SpringLayout.WEST, btnColorSwatch, 0, SpringLayout.WEST, btnOriginal);
		add(btnColorSwatch);
		
		JButton btnSave = new JButton("Save");
		btnSave.setRolloverEnabled(false);
		btnSave.setAction(action);
		btnSave.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 86, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -34, SpringLayout.SOUTH, this);
		add(btnSave);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnEasy);
		radioGroup.add(rdbtnMedium);
		radioGroup.add(rdbtnHard);
		
	}
	
	private class Save extends AbstractAction {
		public Save() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save game settings");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have pressed the SAVE button");
			setVisible(false);
			registerFrame = new RegisterFrame();
			registerFrame.setVisible(false);
			simonWelcome = new SimonWelcome();
			simonWelcome.setVisible(true);
			
		}
	}
	
	private class Cancel extends AbstractAction {
		public Cancel() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Cancel game settings");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have pressed the CANCEL button");
		}
	}
	
	private class Original extends AbstractAction {
		public Original() {
			putValue(NAME, "Original");
			putValue(SHORT_DESCRIPTION, "Original background color");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You ahve pressed the ORIGINAL button");
		}
	}
	
	private class ColorSwatch extends AbstractAction {
		public ColorSwatch() {
			putValue(NAME, "ColorSwatch");
			putValue(SHORT_DESCRIPTION, "Bring up the Color Swatch to change color");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have pressed the COLOR SWATCH button");
		}
	}
	
	private class SoundOnOff extends AbstractAction {
		public SoundOnOff() {
			putValue(NAME, "SoundOnOff");
			putValue(SHORT_DESCRIPTION, "Turn the sound on or mute the sound");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have pressed the SOUNDON/OFF button");
		}
	}
	
	private class radioEasy extends AbstractAction {
		public radioEasy() {
			putValue(NAME, "Easy");
			putValue(SHORT_DESCRIPTION, "Easy Setting");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have selected Easy setting");
			difficultySetting = 1;
			System.out.println("Difficulty setting: " + difficultySetting);
		}
	}
	
	private class radioMedium extends AbstractAction {
		public radioMedium() {
			putValue(NAME, "Medium");
			putValue(SHORT_DESCRIPTION, "Medium setting");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have selected Medium setting");
			difficultySetting = 2;
			System.out.println("Difficulty setteing: " + difficultySetting);
		}
	}
	
	private class radioHard extends AbstractAction {
		public radioHard() {
			putValue(NAME, "Hard");
			putValue(SHORT_DESCRIPTION, "Hard setting");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have selected Hard setting");
			difficultySetting = 3;
			System.out.println("Difficulty setting" + difficultySetting);
		}
	}
}
