/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimonPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JWindow;

public class SplashScreen extends JWindow{

	//Get image that will be used as the splash screen image.
	Image splashImage = Toolkit.getDefaultToolkit().getImage("SimonSplash.gif");
	
	//Declare a new image icon to place on the screen
	ImageIcon splash = new ImageIcon(splashImage);
	
	//Declare the player registration frame to call after the splash screen has concluded
	RegisterFrame rf = new RegisterFrame();
	
	//Splash screen constructor
	public SplashScreen(){

		// try statement to display the splash image
		try
		{
			//Set splash image default location
			setSize(splash.getIconWidth(),splash.getIconHeight());
			setLocationRelativeTo(null);
			
			//Set the splash screen to visible
			setVisible(true);
			
			//Set the splash screen to display for 4 seconds
			Thread.sleep(4000);
			
			//When the splash screen concludes, close and dump from memory
			dispose();
			
			//Set the Player registration frame on for player registration
			rf.setVisible(true);
		}
		catch (Exception e)
		{
			System.err.println("Exception in loading splash");
			e.printStackTrace();
		}
	}
	
	// Draw the splash screen image
	public void paint(Graphics g){
		g.drawImage(splashImage,0,0,this);
	}
	
	// Main to initiate splash screen
	public static void main(String args[]) {
            	SplashScreen ss = new SplashScreen();
    }
}
