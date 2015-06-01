package com.GutierrezLeo.CSC18B.SimonGame;

import java.awt.Dimension;
import javax.swing.JFrame;

public class RegisterFrame extends JFrame {
	
	private RegisterPanel registerPanel = new RegisterPanel();
	private SettingsPanel settingsPanel = new SettingsPanel();
	private SimonWelcome simoneWelcome;
	
	public RegisterFrame() {
		
		//Set to close program on exit
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//Place REGISTRATION at the top of the registration window
		setTitle("GAME SET UP");
		
		//Set size and window defaults
		setSize(400,500);
		setResizable(false);
		setMaximumSize(new Dimension(400, 500));
	    setPreferredSize(new Dimension(400, 500));
	    
	    //Set location to center of screen
	    setLocationRelativeTo(null);
		
		//Perform the registration frame set up
		setUpFrameRegister();
		setUpFrameSettings();
		
	}
				
	private void setUpFrameRegister(){
		
		//Add the registration panel to the JFrame;
		getContentPane().add(registerPanel);
		
		//Make the registration screen visible
		setVisible(true);
		
	}
	
	private void setUpFrameSettings(){
		
		//Add the settings panel on the JPanel with default settings 
		getContentPane().add(settingsPanel);
		
		//Make the settings panel invisible for the moment
		setVisible(false);
		
	}
	
	public void closeFrame(){
		this.setVisible(false);
		this.dispose();
	}
	
}
