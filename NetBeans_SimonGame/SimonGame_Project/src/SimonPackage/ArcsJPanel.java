/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimonPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
*
* @author Leo
* 			CIC18B	-	Java Advanced Object
* 			Dr Mark Lehr
* 			Riverside City College
*/
public class ArcsJPanel extends JPanel{
	
	//SimonWelcome simonWelcome = new SimonWelcome();
   // draw rectangles and arcs
   @Override
   public void paintComponent(Graphics g){
	   
      super.paintComponent(g);  

      
      g.setColor(Color.YELLOW);
      g.fillArc(110, 70, 140, 90, 270, -90);
      
      // start at 270 and sweep 
      g.setColor(Color.BLUE);
      g.fillArc(120, 70, 140, 90, 270, 90);
      
      // start at 
      g.setColor(Color.GREEN);
      g.fillArc(110, 60, 140, 90, 90, 90);
      
      // start at
      g.setColor(Color.RED);
      g.fillArc(120, 60, 140, 90, 90, -90);
                 
      // start at 0 and sweep 360 degrees
      g.setColor(Color.BLACK);
      g.fillArc(125, 75, 120, 70, 0, 360);
      

      
   } 
} // end class ArcsJPanel