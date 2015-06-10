package com.GutierrezLeo.CSC18B.SimonGame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Leo Gutierrez
 * 			CIC18B	-	Java Advanced Objects
 * 			Dr Mark Lehr
 * 			Riverside City College
 * 			Spring Semester 2015
 * 
 */
//public class SimonGamePanel extends javax.swing.JPanel {
public class SimonGamePanel extends JPanel implements ActionListener{
	
	private static Color color = new Color(0,0,0);
	private ObjectInputStream input;
	private int fileStatus;
	private int difficulty;
	protected int sound;
	private int R;
	private int G;
	private int B;
	private int simonArraySize;
	private int n = 0;
	private int j = 0;
	private int myClick = 0;
	private int gameScore = 0;
	private int seqCounter = -1;
	
	private char[] simonArray;
	private char[] userArray;
	
	private long startTime;
	private long stopTime;
	private double timeToPress;

	private boolean arraysGood = true;
	private boolean onTime = true;
	private boolean finishedLevel = false;
	
	private File loseFile = new File("loseGame.wav");
	private File redFile = new File("redSound.wav");
	private File greenFile = new File("greenSound.wav");
	private File yellowFile = new File("yellowSound.wav");
	private File blueFile = new File("blueSound.wav");
	
	private final ImageIcon blueOff = new ImageIcon(getClass().getResource("blue_arch_OFF.fw.png"));
	private final ImageIcon blueOn = new ImageIcon(getClass().getResource("blue_arch_ON.fw.png"));

	private ImageIcon redOff = new ImageIcon(getClass().getResource("red_arch_OFF.fw.png"));
	private ImageIcon redOn = new ImageIcon(getClass().getResource("red_arch_ON.fw.png"));
	
	private ImageIcon greenOff = new ImageIcon(getClass().getResource("green_arch_OFF.fw.png"));
	private ImageIcon greenOn = new ImageIcon(getClass().getResource("green_arch_ON.fw.png"));

	private ImageIcon yellowOff = new ImageIcon(getClass().getResource("yellow_arch_OFF.fw.png"));
	private ImageIcon yellowOn = new ImageIcon(getClass().getResource("yellow_arch_ON.fw.png"));

	private ScoreFrame highScore_Frame;
	public SimonWelcome sw = new SimonWelcome();
	
    public SimonGamePanel(){
        System.out.println("The current thread is: " + Thread.currentThread().getName());
    	readSequentialFile();
    	color = new Color(R, G, B);

        initComponents();
        
        gameSetUp();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	// Declare all buttons, labels and text boxes for the panel
        exitButton = new JButton();
        scoreTextField = new TextField();
        highScoreTextField = new TextField();
        scoreLabel = new Label();
        highScoreLabel = new Label();
        greenButton = new JButton();
        redButton = new JButton();
        blueButton = new JButton();
        yellowButton = new JButton();
        simonLabel = new JLabel();
        goButton = new JButton();

        // Set max and preferred panel size
        setMaximumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));

        // Exit button details
        exitButton.setBackground(color);
        exitButton.setForeground(Color.WHITE);
        exitButton.setText("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        // Score Text Field details
        scoreTextField.setBackground(color);
        scoreTextField.setEditable(false);
        //scoreTextField.setForeground(new Color(255, 255, 255));
        scoreTextField.setForeground(color);
        scoreTextField.setText("");
        scoreTextField.setVisible(false);

        // High Score Text Field
        highScoreTextField.setBackground(color);
        highScoreTextField.setEditable(false);
        highScoreTextField.setForeground(new Color(255, 255, 255));
        highScoreTextField.setName(""); // NOI18N
        highScoreTextField.setText("00");

        //setBackground(Color.BLACK);
        setBackground(color);
        setForeground(Color.WHITE);
        //scoreLabel.setText("High Score");
        scoreLabel.setText("");
        highScoreLabel.setText("Score");

        // Green button details
        greenButton.setBackground(color);
        greenButton.setIcon(greenOff);
        greenButton.setPressedIcon(greenOn);
        greenButton.setEnabled(false);
        greenButton.addActionListener(this);

        // Red button details
        redButton.setBackground(color);
        redButton.setIcon(redOff);
        redButton.setPressedIcon(redOn);
        redButton.setEnabled(false);
        redButton.addActionListener(this);

        // Blue button details
        blueButton.setBackground(color);
        blueButton.setIcon(blueOff);
        blueButton.setPressedIcon(blueOn);
        blueButton.setEnabled(false);
        blueButton.addActionListener(this);

        // Yellow button details
        yellowButton.setBackground(color);
        yellowButton.setIcon(yellowOff);
        yellowButton.setPressedIcon(yellowOn);
        yellowButton.setEnabled(false);
        yellowButton.addActionListener(this);

        // Simon label details
        simonLabel.setFont(new java.awt.Font("Gulim", 0, 36));
        simonLabel.setBackground(color);
        simonLabel.setForeground(Color.YELLOW);
        simonLabel.setText("S  I  M  O  N");
        
        goButton.setText("GO");
        goButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt){
        		goButtonActionPerformed(evt);
        	}
        });

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(exitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(goButton)
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(highScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(highScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(scoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(simonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(simonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scoreTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exitButton)
                            .addComponent(highScoreLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScoreTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goButton)
                        .addGap(3, 3, 3)))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void gameSetUp(){
    	System.out.println("gameSetUp:  The current Thread is: " + Thread.currentThread().getName());
    	fillSimonArray();
    	
    }
    
    // Array values		The values for the simon array are populated here.
    //    They are randomly selected and assigned a letter.
    //			1 = green			assign 'G'	
    //			2 = red				assign 'R'	
    //			3 = yellow			assign 'Y'	
    //			4 = blue			assign 'B'
    // 
    //  The stop watch is also initiated here.  The user will have 5 seconds at the most
    //    in between clicking each subsequent button.
    private void fillSimonArray(){
    	int numLtr;
    	
    	switch(difficulty)
    	{
    	case 1:	simonArraySize = 8;
    			break;
    	case 2: simonArraySize = 20;
    			break;
    	default: simonArraySize = 31;
    			 break;
    	}

    	simonArray = new char [simonArraySize];
    	
    	for (int count = 0; count < simonArraySize; count++){
        	numLtr = getRndm();
        	switch (numLtr)
        	{
        	case 1:			simonArray[count] = 'G';			//green
        					break;
        	case 2:			simonArray[count] = 'R';			//red
        					break;
        	case 3:			simonArray[count] = 'Y';			//yellow
        					break;
        	default:		simonArray[count] = 'B';			//blue
        					break;
        	}
    	}
    	
    	//  Initialize the user array (cannot be nulls)
    	initializeUserArray();
    	
    }
    
    // Initialize the user array to all 'A's.  Replace each as the game continues.
    private void initializeUserArray(){
    	System.out.println("The current Thread is: " + Thread.currentThread().getName());
    	userArray = new char [simonArraySize];
    	
    	for (int count = 0; count < simonArraySize; count++){
    		userArray[count] = 'A';
    	}
    }
    
    // Generate a random number from 1 to 4
    private int getRndm(){
    	Random rand = new Random();
    	int random = rand.nextInt(4) + 1;
    	return random;
    }
    
    // GO button to start the game play
    private void goButtonActionPerformed(ActionEvent evt) {
    	System.out.println("The current thread is: " + Thread.currentThread().getName());
    			greenButton.setEnabled(true);
    	    	redButton.setEnabled(true);
    	    	yellowButton.setEnabled(true);
    	    	blueButton.setEnabled(true);
    	
    	// Set the clock to zero for the first input
    	startStopWatch();
    	
   		userPlay();
    }
    
    
 // The game starts here
    private void userPlay(){
    	System.out.println("***** You are in the userPlay method *****");
    	System.out.println("The current thread is: " + Thread.currentThread().getName());
    	myClick = 0;
    	initializeUserArray();

    	if ((n != simonArraySize) || (arraysGood) || (onTime)){
    		j = n + 1;
    	}

    	// show user the simon array
    	System.out.println("userPlay:     j is: " + j);
    			
    	if ((n == simonArraySize) || (!arraysGood) || (!onTime)){
    		System.out.println("Do not play the next iteration.  Bring up the score panel");
    	} else {
    		System.out.println("The current thread is: " + Thread.currentThread().getName());
    		new Thread(new Runnable(){
    			public void run(){
    				for (int i = 0; i < j; i++){
    					playSimonArray(i);
    				}
    			}
    		}).start();
    	}
    }
    
    private void playSimonArray(int i){
    	
    	if(simonArray[i] == 'G'){
			greenButton.doClick(500);
			waitExec(500);
    	}
    	
    	if(simonArray[i] == 'R'){
			redButton.doClick(500);
			waitExec(500);
    	}
    	
    	if(simonArray[i] == 'Y'){
			yellowButton.doClick(500);
			waitExec(500);
     	}
    	
    	if(simonArray[i] == 'B'){
			blueButton.doClick(500);
			waitExec(500);
     	}
    }
    
    private void checkTime(){
        
        verifyTimeToPress();

    }
    
    private void verifyTimeToPress(){
        timeToPress = elapsedTime();

        if(timeToPress > 5){
        	onTime = false;
        } else {
        	onTime = true;
        }
        
        if (onTime)
        	startStopWatch();
    }
    
    //Start the stop watch
    private void startStopWatch(){
    	startTime = System.currentTimeMillis();
    }
    
    private double elapsedTime(){
    	stopTime = System.currentTimeMillis();
    	return (stopTime - startTime) / 1000.0;
    }
    
    
    private void compareArrays(){
    	
    	for (int i = 0; i < simonArraySize; i++){
    		System.out.print(simonArray[i]);
    	}
    	for (int i = 0; i < simonArraySize; i++){
    		System.out.print(userArray[i]);
    	}

    	if (simonArray[n] == userArray[n]){
    		arraysGood = true;
    	} else {
    		arraysGood = false;
    	}
    	
    	if (arraysGood){
    		gameScore += 1;
    		highScoreTextField.setText(Integer.toString(gameScore));		
    	} else {
    		if (sound == 1)
    		{
    			System.out.println("compareArrays:     Game over. Arrays didn't match");
    			playClip("lost");
    		}
    		checkScore();
    	}
    	
       	// increment interation by 1
    	n++;
    	
    	if (n == simonArraySize){
    		checkScore();
    	}
    }
    
    private void doOneCompare(int a){
    	
    	System.out.println("The current thread is: " + Thread.currentThread().getName());
    	for (int i = 0; i < simonArraySize; i++){
    		System.out.print(simonArray[i]);
    	}
    	System.out.println(" ");
    	for (int i = 0; i < simonArraySize; i++){
    		System.out.print(userArray[i]);
    	}
    	
    	System.out.println("");
    	System.out.println("simonArray[" + a + "] is: " + simonArray[a]);
    	System.out.println(" userArray[" + a + "] is: " + userArray[a]);
    	
    	if (simonArray[a] == userArray[a]){
    		arraysGood = true;
    	} else {
    		arraysGood = false;
    	}
    	
    	if (!arraysGood){
    		if (sound == 1){
    			playClip("lost");
    		}
    	checkScore();
    	}
    }
    

    //  Bring up the high score panel when game ends. Ask for user input if score is higher
    //  than the lowest score.  Otherwise, just display the top 10 scores.
    private void checkScore(){
    	System.out.println("***** You are in the checkScore method *****");
    	System.out.println("The current thread is " + Thread.currentThread().getName());
    		///this.removeAll();
    		//sw.setVisible(false);
    		//sw.dispose();
    		this.setVisible(false);
    		this.setEnabled(false);
    		highScore_Frame = new ScoreFrame();
    		highScore_Frame.pack();
    		highScore_Frame.setSize(500, 700);
    		highScore_Frame.setLocationRelativeTo(null);
    		highScore_Frame.setVisible(true);
    		highScore_Frame.addScore("   ", gameScore, difficulty);
    	
    }
    
    // Play the sound clip (if the sound is on) for each color
    private void playClip(String buttonColor){
    	try
    	{
    		//  Play blue button sound
    		if (buttonColor == "blue")
    		{
    			AudioInputStream blueGameIn = AudioSystem.getAudioInputStream(blueFile);
    			Clip blueClip = AudioSystem.getClip();
    			blueClip.open(blueGameIn);
    			blueClip.start();
    		}
    		// Play yellow button sound
    		else if (buttonColor == "yellow")
    		{
        		AudioInputStream yellowGameIn = AudioSystem.getAudioInputStream(yellowFile);
        		Clip yellowClip = AudioSystem.getClip();
        		yellowClip.open(yellowGameIn);
        		yellowClip.start();
    		}
    		// Play red button sound
    		else if (buttonColor == "red")
    		{
           		AudioInputStream redGameIn = AudioSystem.getAudioInputStream(redFile);
        		Clip redClip = AudioSystem.getClip();
        		redClip.open(redGameIn);
        		redClip.start(); 
    		}	
    		// Play green button sound
    		else if (buttonColor == "green")
    		{
          		AudioInputStream greenGameIn = AudioSystem.getAudioInputStream(greenFile);
        		Clip greenClip = AudioSystem.getClip();
        		greenClip.open(greenGameIn);
        		greenClip.start();	
    		} 
    		// Play the game lost sound
    		else if (buttonColor == "lost")
    		{
    			AudioInputStream lostGameIn = AudioSystem.getAudioInputStream(loseFile);
        		Clip lostClip = AudioSystem.getClip();
        		lostClip.open(lostGameIn);
        		lostClip.start();
    		}
     	}
    	catch (UnsupportedAudioFileException e)
    	{
    		System.out.println("Unsupported Audio File.");
    		e.printStackTrace();
    	}
    	catch (IOException e)
    	{
    		System.out.println("IO Exception opening audio clips");
    		e.printStackTrace();
    	}
    	catch (LineUnavailableException e)
    	{
    		System.out.println("Line unavailable.");
    		e.printStackTrace();
    	}
    }
    
    // Exit button actions
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }          
    
    // Wait the milliseconds as defined by the calling of the method in the millisecs variable
    private void waitExec(long millisecs){
    	System.out.println("***** You are in the waitExec method *****");
    	System.out.println("The current thread is: " + Thread.currentThread().getName());
    	try 
    	{
 	       Thread.currentThread().sleep(millisecs);
 		}
 	    catch (InterruptedException e)
 		{
 	       e.printStackTrace();
 	    }
    }
    
 // Open, read and close the settings file
    private void readSequentialFile(){
    	openFile();
    	readRecord();
    	closeFile();
    	
    }
    
    // Open the settings file for the game
    private void openFile(){
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
    
    // Read the settings file
    private void readRecord(){
    	try
    	{
    		while (true)
    		{
    			GameSettings setting = (GameSettings) input.readObject();
    			fileStatus = setting.getFileStatus();
    			difficulty = setting.getDifficulty(); 
    			sound = setting.getSound();
    			R = setting.getR();
    			G = setting.getG();
    			B = setting.getB();
    			
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
    
    // Close the settings file
    private void closeFile(){
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
    
    // Variables declaration - do not modify
    private JButton exitButton;
    private JButton goButton;
    private Label highScoreLabel;
    private TextField highScoreTextField;
    private Label scoreLabel;
    private TextField scoreTextField;
    private JLabel simonLabel;
    private JButton greenButton;
    private JButton redButton;
    private JButton yellowButton;
    private JButton blueButton;
    // End of variables declaration                   


	@Override
	public void actionPerformed(ActionEvent e) {
		// Green button actions
		if (e.getSource() == greenButton){
	        System.out.println("The current thread is: " + Thread.currentThread().getName());
	        
        	userArray[myClick] = 'G';
        	
        	buttonActions('G');
        	
	    }
	    

	    // Red button actions
		if (e.getSource() == redButton){
	        System.out.println("The current thread is: " + Thread.currentThread().getName());
	        
        	userArray[myClick] = 'R';
        	
        	buttonActions('R');
        	
	    } 
	    
	    
	    // Yellow button actions
		if (e.getSource() == yellowButton){
	        System.out.println("The current thread is: " + Thread.currentThread().getName());

        	userArray[myClick] = 'Y';
        	
        	buttonActions('Y');
        	
	    }                                            

	    // Blue button actions
		if (e.getSource() == blueButton){
	        System.out.println("The current thread is: " + Thread.currentThread().getName());
	        
        	userArray[myClick] = 'B';
        	
        	buttonActions('B');

	    }                                          
	}
	
	private void buttonActions(char color){
		
		seqCounter++;
		
		checkTime();
		
    	if (onTime){
    		if ((sound == 1) && (color == 'G')){
    			playClip("green");
    		}
       		if ((sound == 1) && (color == 'R')){
    			playClip("red");
    		}
       		if ((sound == 1) && (color == 'Y')){
    			playClip("yellow");
    		}
       		if ((sound == 1) && (color == 'B')){
    			playClip("blue");
    		}
    		
    		if (n > 0){
    			System.out.println("n is greater than 0: " + n);
    			if ((seqCounter > n) && (seqCounter != n + (n + 1))){
    				doOneCompare(myClick);
    				myClick++;
    			}
    		}
    		
    		if (seqCounter == n + (n + 1)){
    			seqCounter = -1;
    			compareArrays();
    			startStopWatch();
    			userPlay();
    		}
    	} else {
    		if (sound == 1){
    			System.out.println("Game over. Took too much time");
    			playClip("lost");
    		}
    		checkScore();
    	}
	}
}
