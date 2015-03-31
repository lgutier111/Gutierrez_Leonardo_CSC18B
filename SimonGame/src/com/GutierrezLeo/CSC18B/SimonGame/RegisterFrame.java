package com.GutierrezLeo.CSC18B.SimonGame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class RegisterFrame extends JFrame {
	
	private RegisterPanel registerPanel = new RegisterPanel();
	
	public RegisterFrame() {
		
		setUpFrame();
		
	}
	
	private void setUpFrame(){
		
		setContentPane(registerPanel);
		setTitle("REGISTRATION");
		setSize(400,500);
		setResizable(false);
		setMaximumSize(new Dimension(400, 500));
	    setName("REGISTRATION");
	    setPreferredSize(new Dimension(400, 500));
		setLocation(200,200);
		setAlwaysOnTop(true);
		setVisible(true);
		
	}
	
	//public void ParentCloseMe(){
	//	// Hide the frame
	//	System.out.println("You are in the parent close me method in the FRAME");
	//	this.setVisible(false);
	//	this.dispose();
	//}
}
