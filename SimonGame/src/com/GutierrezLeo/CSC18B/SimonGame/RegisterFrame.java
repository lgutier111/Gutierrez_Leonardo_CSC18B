package com.GutierrezLeo.CSC18B.SimonGame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class RegisterFrame extends JFrame {
	
	private RegisterPanel registerPanel = new RegisterPanel();
	private SettingsPanel settingsPanel = new SettingsPanel();
	private SimonWelcome simoneWelcome;
	
	public RegisterFrame() {
		
		setUpFrame();
		
	}
	
	private void setUpFrame(){
		
		//setContentPane(registerPanel);
		getContentPane().add(registerPanel);
		setTitle("REGISTRATION");
		setSize(400,500);
		setResizable(false);
		setMaximumSize(new Dimension(400, 500));
	    //setName("REGISTRATION");
	    setPreferredSize(new Dimension(400, 500));
		setLocation(200,200);
		//setAlwaysOnTop(true);
		setVisible(true);
		
		getContentPane().add(settingsPanel);
		//setTitle("SETTINGS");
		setSize(400,500);
		setResizable(false);
		setMaximumSize(new Dimension(400, 500));
		//setName("SETTINGS");
		setPreferredSize(new Dimension(400, 500));
		setLocation(200,200);
		setVisible(false);
		
	}
	
	public void ParentCloseMe(){
	// Hide the frame
		System.out.println("You are in the parent close me method in the FRAME");
		getContentPane().setVisible(false);
		//setVisible(false);
		//dispose();
		simoneWelcome = new SimonWelcome();
		simoneWelcome.setVisible(true);
		this.setVisible(false);
		//System.exit(1);
	}
	
	 public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new RegisterFrame().setVisible(true);
	            }
	        });
	    }
}
