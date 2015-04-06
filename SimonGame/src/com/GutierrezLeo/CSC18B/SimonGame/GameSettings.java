package com.GutierrezLeo.CSC18B.SimonGame;

import java.io.Serializable;

public class GameSettings implements Serializable{

	private int difficulty;
	private boolean sound;
	private int backgroundColor;
	
	public GameSettings(){
		this(0, false, 0);
	}
	
	public GameSettings(int difficulty, boolean sound, int backgroundColor){
		this.difficulty = difficulty;
		this.sound = sound;
		this.backgroundColor = backgroundColor;
	}
	
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public void setSound(boolean sound){
		this.sound = sound;
	}
	
	public boolean getSound(){
		return sound;
	}
	
	public void setBackgroundColor(int backgroundColor){
		this.backgroundColor = backgroundColor;
	}
	
	public int getBackgroundColor(){
		return backgroundColor;
	}
}
