package com.GutierrezLeo.CSC18B.SimonGame;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class SettingsPanel extends JPanel {
	private final Action action = new Save();
	private final Action action_2 = new Original();
	private final Action action_3 = new ColorSwatch();
	private final Action action_5 = new radioEasy();
	private final Action action_6 = new radioMedium();
	private final Action action_7 = new radioHard();
	private final Action action_4 = new radioSoundOff();
	private final Action action_8 = new radioSoundOn();
	
	private int fileStatusSetting;
	private int difficultySetting;
	private int soundSetting;
	private int rSetting;
	private int gSetting;
	private int bSetting;
	
	private SimonWelcome simonWelcome;
	private RegisterFrame registerFrame;

	private static ObjectOutputStream output;  //outputs data to file
	private static ObjectOutputStream output2;  // outputs to a file using JFileChooser
	private static ObjectInputStream input;    //read input data file
	private static ObjectInputStream input2;   // read input file using JFileChooser
	private File saveLocation;
	private File openLocation;
	
	private Color color;
	
	private JRadioButton rdbtnEasy = new JRadioButton("Easy");
	private JRadioButton rdbtnMedium = new JRadioButton("Medium");
	private JRadioButton rdbtnHard = new JRadioButton("Hard");
	private JRadioButton rdbtnOff = new JRadioButton("Off");
	private JRadioButton rdbtnOn = new JRadioButton("On");
	private SpringLayout springLayout;
	private JLabel lblDifficulty;
	private JButton btnSave;
	private JButton btnLoad;
	private final JButton btnDone = new JButton("Done");
	
	// Constructor
	public SettingsPanel() {
		
		setUpSettingsPanel();
		
		readSequentialFile();

		color = new Color(rSetting, gSetting, bSetting);

		


	}
	
	public void setUpSettingsPanel(){
		
		setForeground(Color.WHITE);
		//setBackground(Color.BLACK);
		//setBackground(color);
		springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.EAST, btnDone, -67, SpringLayout.EAST, this);
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("GAME SETTINGS");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 111, SpringLayout.WEST, this);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);
		
		lblDifficulty = new JLabel("Difficulty");
		springLayout.putConstraint(SpringLayout.NORTH, lblDifficulty, 32, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblDifficulty, 78, SpringLayout.WEST, this);
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDifficulty.setForeground(Color.WHITE);
		add(lblDifficulty);
		
		//JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setSelected(true);
		rdbtnEasy.setRolloverEnabled(false);
		rdbtnEasy.setAction(action_5);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnEasy, 230, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnEasy, -109, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblDifficulty, -21, SpringLayout.WEST, rdbtnEasy);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnEasy, 0, SpringLayout.NORTH, lblDifficulty);
		rdbtnEasy.setBackground(color);
		rdbtnEasy.setForeground(Color.WHITE);
		add(rdbtnEasy);
		
		//JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setRolloverEnabled(false);
		rdbtnMedium.setAction(action_6);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMedium, 6, SpringLayout.SOUTH, rdbtnEasy);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMedium, 0, SpringLayout.WEST, rdbtnEasy);
		rdbtnMedium.setBackground(color);
		rdbtnMedium.setForeground(Color.WHITE);
		add(rdbtnMedium);
		
		//JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setRolloverEnabled(false);
		rdbtnHard.setAction(action_7);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnHard, 6, SpringLayout.SOUTH, rdbtnMedium);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnHard, 0, SpringLayout.WEST, rdbtnEasy);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnHard, -109, SpringLayout.EAST, this);
		rdbtnHard.setBackground(color);
		rdbtnHard.setForeground(Color.WHITE);
		add(rdbtnHard);
		
		JLabel lblSound = new JLabel("Sound");
		lblSound.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSound.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblSound, 111, SpringLayout.SOUTH, lblDifficulty);
		springLayout.putConstraint(SpringLayout.WEST, lblSound, 0, SpringLayout.WEST, lblDifficulty);
		add(lblSound);
		
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
		btnOriginal.setAction(action_2);
		btnOriginal.setBackground(Color.WHITE);
		btnOriginal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnOriginal);
		
		JButton btnColorSwatch = new JButton("Color Swatch");
		springLayout.putConstraint(SpringLayout.WEST, btnOriginal, 0, SpringLayout.WEST, btnColorSwatch);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOriginal, -21, SpringLayout.NORTH, btnColorSwatch);
		springLayout.putConstraint(SpringLayout.EAST, btnOriginal, 0, SpringLayout.EAST, btnColorSwatch);
		springLayout.putConstraint(SpringLayout.NORTH, btnColorSwatch, 364, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnColorSwatch, -53, SpringLayout.EAST, this);
		btnColorSwatch.setRolloverEnabled(false);
		btnColorSwatch.setForeground(new Color(0, 0, 0));
		btnColorSwatch.setAction(action_3);
		btnColorSwatch.setBackground(Color.WHITE);
		add(btnColorSwatch);
		
		btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnDone, 0, SpringLayout.NORTH, btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setRolloverEnabled(false);
		btnSave.setAction(action);
		btnSave.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 86, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -34, SpringLayout.SOUTH, this);
		add(btnSave);
		
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadUserSettingFile();
			}
		});
		btnLoad.setRolloverEnabled(false);
		btnLoad.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, btnLoad, 0, SpringLayout.WEST, btnSave);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLoad, -18, SpringLayout.NORTH, btnSave);
		add(btnLoad);
		
		setBackground(Color.BLACK);
		btnDone.setBackground(Color.WHITE);
		btnDone.setRolloverEnabled(false);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				simonWelcome = new SimonWelcome();
				simonWelcome.setVisible(true);
			}
		});
		
		add(btnDone);
		
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnEasy);
		radioGroup.add(rdbtnMedium);
		radioGroup.add(rdbtnHard);
		
		//JRadioButton rdbtnOff = new JRadioButton("Off");
		rdbtnOff.setAction(action_4);
		rdbtnOff.setRolloverEnabled(false);
		rdbtnOff.setBackground(color);
		rdbtnOff.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnOff, 1, SpringLayout.NORTH, lblSound);
		add(rdbtnOff);
		
		//JRadioButton rdbtnOn = new JRadioButton("On");
		rdbtnOn.setAction(action_8);
		rdbtnOn.setSelected(true);
		rdbtnOn.setRolloverEnabled(false);
		rdbtnOn.setForeground(Color.WHITE);
		rdbtnOn.setBackground(color);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnOff, -13, SpringLayout.WEST, rdbtnOn);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnOn, 1, SpringLayout.NORTH, lblSound);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnOn, 0, SpringLayout.EAST, btnColorSwatch);
		add(rdbtnOn);
		
		ButtonGroup radioGroupSound = new ButtonGroup();
		radioGroupSound.add(rdbtnOff);
		radioGroupSound.add(rdbtnOn);
	}
	
	private class Save extends AbstractAction {
		public Save() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save game settings");
		}
		public void actionPerformed(ActionEvent e) {
			//Set the file status setting to 1.  If the game abnormally ends, it will restore the settings being saved.
			fileStatusSetting = 1;
			createSequentialFile();
			setVisible(false);
			simonWelcome = new SimonWelcome();
			simonWelcome.setVisible(true);
		}
	}
	
	
	private class Original extends AbstractAction {
		public Original() {
			putValue(NAME, "Original");
			putValue(SHORT_DESCRIPTION, "Original background color");
		}
		public void actionPerformed(ActionEvent e) {
			setBackground(Color.BLACK);
			rSetting = 0;
			gSetting = 0;
			bSetting = 0;
		}
	}
	
	private class ColorSwatch extends AbstractAction {
		public ColorSwatch() {
			putValue(NAME, "ColorSwatch");
			putValue(SHORT_DESCRIPTION, "Bring up the Color Swatch to change color");
		}
		public void actionPerformed(ActionEvent e) {
			JFrame ShowColors2JFrame = new JFrame();
			color = JColorChooser.showDialog(ShowColors2JFrame, "Choose a color", color);
			if (color == null)
				color = Color.BLACK;
			setBackground(color);
			rSetting = color.getRed();
			gSetting = color.getGreen();
			bSetting = color.getBlue();
		}
	}
	
	private class radioEasy extends AbstractAction {
		public radioEasy() {
			putValue(NAME, "Easy");
			putValue(SHORT_DESCRIPTION, "Easy Setting");
		}
		public void actionPerformed(ActionEvent e) {
			difficultySetting = 1;
		}
	}
	
	private class radioMedium extends AbstractAction {
		public radioMedium() {
			putValue(NAME, "Medium");
			putValue(SHORT_DESCRIPTION, "Medium setting");
		}
		public void actionPerformed(ActionEvent e) {
			difficultySetting = 2;
		}
	}
	
	private class radioHard extends AbstractAction {
		public radioHard() {
			putValue(NAME, "Hard");
			putValue(SHORT_DESCRIPTION, "Hard setting");
		}
		public void actionPerformed(ActionEvent e) {
			difficultySetting = 3;
		}
	}
	private class radioSoundOff extends AbstractAction {
		public radioSoundOff() {
			putValue(NAME, "Off");
			putValue(SHORT_DESCRIPTION, "Turn Sound Off");
		}
		public void actionPerformed(ActionEvent e) {
			soundSetting = 0;
		}
	}
	private class radioSoundOn extends AbstractAction {
		public radioSoundOn() {
			putValue(NAME, "On");
			putValue(SHORT_DESCRIPTION, "Turn Sound On");
		}
		public void actionPerformed(ActionEvent e) {
			soundSetting = 1;
		}
	}
	
	
	
private void createSequentialFile(){
		openFile();
		addRecord();
		closeFile();
	}
	
	public void openFile(){
		// The last user setting file.  This file will be read in automatically at the start of
		// every game.
		System.out.println("You are in the open file method");
		try{
			File file = new File("simonsettings.ser");
			
			if(!file.exists()){
				System.out.println("you are in createNewFile if stmt");
				file.createNewFile();
			}
			
			output = new ObjectOutputStream(
					Files.newOutputStream(Paths.get("simonsettings.ser")));
			
			createUserSettingFile();
			
			output2 = new ObjectOutputStream(new FileOutputStream(saveLocation)); 
			
					//Files.newOutputStream(Paths.get("afile.txt")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.  Terminating.");
			System.exit(1);  // terminate program
		}
	}
	
	public void addRecord(){
		System.out.println("You are in the addRecord method");
		try 
		{
		GameSettings gameSettings = new GameSettings(fileStatusSetting, difficultySetting, soundSetting,  
				rSetting, gSetting, bSetting);
		
		output.writeObject(gameSettings);
		output2.writeObject(gameSettings);
		} 
		catch (NoSuchElementException elementException)
		{ 
			System.err.println("Invalid input. Please try again.");
		} 
		catch (IOException ioException)
		{
			System.err.println("Error writing to file.  Terminating.");
			System.exit(1);
		}
	}
	
	public void closeFile(){
		System.out.println("You are in the closefile method");
		try
		{
				output.close();
				output2.close();
		}
		catch (IOException ioException)
		{
			System.err.println("Error closing file.  Terminating.");
			System.exit(1);
		}
		
	}
	
	// Using the JFileChooser, this will allow a user to save his own custom settings
	private void createUserSettingFile(){
		System.out.println("you are in the createUserSettingsFile method");
		JFrame parentFrame = new JFrame();
		
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Save Settings File");
		int userSelection = jfc.showSaveDialog(parentFrame);
		
		if(userSelection == JFileChooser.APPROVE_OPTION){
			saveLocation = jfc.getSelectedFile();
		}
	}
	
	
	// Using the JFileChooser, this will allow a user to load his own custom settings
	private void loadUserSettingFile(){
		System.out.println("you are in the loadUserSettingsFile method");
		
		JFrame parentFrame = new JFrame();
		
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Load Settings File");
		int userSelection = jfc.showOpenDialog(parentFrame);
		
		if(userSelection == JFileChooser.APPROVE_OPTION){
			openLocation = jfc.getSelectedFile();
		}
		
		// open the input file
		try
		{
			input2 = new ObjectInputStream(new FileInputStream(openLocation));
		}
		catch (IOException ioException)
		{
			System.err.println("Error opening file.");
		}
		
		
		//  read the settings record selected by the user
		try
    	{
    		while (true)
    		{
    			GameSettings setting = (GameSettings) input2.readObject();
    			fileStatusSetting = setting.getFileStatus();
    			
    			difficultySetting = setting.getDifficulty();
    			if(difficultySetting == 1){
    				rdbtnEasy.setSelected(true);
    			} 
    			
    			if(difficultySetting == 2){
    				rdbtnMedium.setSelected(true);
    			} 
    			
    			if(difficultySetting == 3){
    				rdbtnHard.setSelected(true);
    			}
    				
    			soundSetting = setting.getSound();
    			if(soundSetting == 0){
    				rdbtnOff.setSelected(true);
    			} else {
    				rdbtnOn.setSelected(true);
    			}
    			
    			rSetting = setting.getR();
    			gSetting = setting.getG();
    			bSetting = setting.getB();
    			
    			if(fileStatusSetting == 0){
    				//use default settings if app was closed properly and not interrupted last time it was running
    				fileStatusSetting = 1;
    				difficultySetting = 1;
    				soundSetting = 1;
    				rSetting = 0;
    				gSetting = 0;
    				bSetting = 0;
    				rdbtnEasy.setSelected(true);
    				rdbtnOn.setSelected(true);
    			}
    		}
    	}
    	catch (EOFException endOfFileException)
    	{
    		System.err.println("No More Records");
    	}
    	catch (ClassNotFoundException classNotFoundException)
    	{
    		System.err.println("Invalid object type.  Terminating. ");
    	}
    	catch (IOException ioException)
    	{
    		System.err.println("Error reading from file.  Terminating.");
    	}
		
		
		// close the input file
    	try
    	{
    		if (input2 != null)
    			input2.close();
    	}
    	catch (IOException ioException)
    	{
    		System.err.println("Error closing file.  Terminating.");
    		System.exit(1);
    	}
		
	}
	
	
	
	// Read in the last user settings
	public void readSequentialFile(){
    	openFileInput();
    	readRecord();
    	closeFileInput();
    }
	
	
	public void openFileInput(){
    	try
    	{
    		input = new ObjectInputStream(Files.newInputStream(Paths.get("simonsettings.ser")));
    	} 
    	catch (IOException ioException)
    	{
    		System.err.println("Error opening file.");
    		System.exit(1);
    	}
    }
    
    public void readRecord(){
    	try
    	{
    		while (true)
    		{
    			GameSettings setting = (GameSettings) input.readObject();
    			fileStatusSetting = setting.getFileStatus();
    			
    			difficultySetting = setting.getDifficulty();
    			if(difficultySetting == 1){
    				rdbtnEasy.setSelected(true);
    			} 
    			
    			if(difficultySetting == 2){
    				rdbtnMedium.setSelected(true);
    			} 
    			
    			if(difficultySetting == 3){
    				rdbtnHard.setSelected(true);
    			}
    				
    			soundSetting = setting.getSound();
    			if(soundSetting == 0){
    				rdbtnOff.setSelected(true);
    			} else {
    				rdbtnOn.setSelected(true);
    			}
    			
    			rSetting = setting.getR();
    			gSetting = setting.getG();
    			bSetting = setting.getB();
    			
    			if(fileStatusSetting == 0){
    				//use default settings if app was closed properly and not interrupted last time it was running
    				fileStatusSetting = 1;
    				difficultySetting = 1;
    				soundSetting = 1;
    				rSetting = 0;
    				gSetting = 0;
    				bSetting = 0;
    				rdbtnEasy.setSelected(true);
    				rdbtnOn.setSelected(true);
    			}
    		}
    	}
    	catch (EOFException endOfFileException)
    	{
    		System.err.println("No More Records");
    	}
    	catch (ClassNotFoundException classNotFoundException)
    	{
    		System.err.println("Invalid object type.  Terminating. ");
    	}
    	catch (IOException ioException)
    	{
    		System.err.println("Error reading from file.  Terminating.");
    	}
    }
    
    public void closeFileInput(){
    	try
    	{
    		if (input != null)
    			input.close();
    	}
    	catch (IOException ioException)
    	{
    		System.err.println("Error closing file.  Terminating.");
    		System.exit(1);
    	}
    }
}
