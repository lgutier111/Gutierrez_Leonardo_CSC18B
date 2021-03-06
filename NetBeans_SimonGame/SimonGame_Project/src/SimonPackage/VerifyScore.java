/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimonPackage;

import java.util.Comparator;

//Class to get the top 10 highest scores
// COMPERATOR was taken from chapter 17 from the latest text edition (10th)
public class VerifyScore implements Comparator<TopScores> {
	
	// Compares score by score until sorted
	public int compare (TopScores score1, TopScores score2){
	
		int s1 = score1.getScore();
		int s2 = score2.getScore();
		
		if (s1 > s2) {
			return -1;
		} else if (s1 < s2) {
			return +1;
		} else {
			return 0;
		}
	}
}
