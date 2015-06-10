/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimonPackage;

import java.io.Serializable;

public class GameSettings implements Serializable{

	private int fileStatus;
	private int difficulty;
	private int sound;
	private int R;
	private int G;
	private int B;
	
	public GameSettings(){
		this(0, 0, 0, 0, 0, 0);
	}
	
	public GameSettings(int fileStatus, int difficulty, int sound, int R, int G, int B){
		this.fileStatus = fileStatus;
		this.difficulty = difficulty;
		this.sound = sound;
		this.R = R;
		this.G = G;
		this.B = B;
	}
	
	public void setFileStatus(int fileStatus){
		this.fileStatus = fileStatus;
	}
	
	public int getFileStatus(){
		return fileStatus;
	}
	
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public void setSound(int sound){
		this.sound = sound;
	}
	
	public int getSound(){
		return sound;
	}
	
	public void setR(int R){
		this.R = R;
	}
	
	public int getR(){
		return R;
	}
	
	public void setG(int G){
		this.G = G;
	}
	
	public int getG(){
		return G;
	}
	
	public void setB(int B){
		this.B = B;
	}
	
	public int getB(){
		return B;
	}
}
