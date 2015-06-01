package com.GutierrezLeo.CSC18B.SimonGame;

import javax.swing.JFrame;

public class TestHighScore {

	public static void main(String[] args) {

		ScoreFrame highScore_Frame = new ScoreFrame();
		highScore_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		highScore_Frame.setDefaultLookAndFeelDecorated(true);
		highScore_Frame.setSize(500,700);
		
		//This line below is used to test the score screen.  Enter a value greater than the
		// lowest value in the top 10 scores.  If you enter a value that is lower, then 
		// the top 10 scores will just display and you will not be asked to enter any
		// initials.
		highScore_Frame.addScore("   ", 218500);
		highScore_Frame.setVisible(true);
	}
}
