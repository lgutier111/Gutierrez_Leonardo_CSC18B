package com.GutierrezLeo.CSC18B.SimonGame;

import java.awt.Color;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JPanel;

/**
 *
 * @author Leo
 * 			CIC18B	-	Java Advanced Object
 * 			Dr Mark Lehr
 * 			Riverside City College
 */
//public class SimonGamePanel extends javax.swing.JPanel {
public class SimonGamePanel extends JPanel{
	
	private static Color color = new Color(0,0,0);
	private ObjectInputStream input;
	private int fileStatus;
	private int difficulty;
	private int sound;
	private int R;
	private int G;
	private int B;

    /**
     * Creates new form SimonGamePanel
     */
    public SimonGamePanel() {
        System.out.println("You are in the SimonGamePanel constructor");
        
    	readSequentialFile();
    	color = new Color(R, G, B);

        initComponents();
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
        exitButton = new javax.swing.JButton();
        scoreTextField = new java.awt.TextField();
        highScoreTextField = new java.awt.TextField();
        scoreLabel = new java.awt.Label();
        highScoreLabel = new java.awt.Label();
        greenButton = new javax.swing.JButton();
        redButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();
        simonLabel = new javax.swing.JLabel();

        // Set max and preferred panel size
        setMaximumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));

        // Exit button details
        exitButton.setBackground(color);
        exitButton.setForeground(Color.WHITE);
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        // Score Text Field details
        scoreTextField.setBackground(color);
        scoreTextField.setEditable(false);
        scoreTextField.setForeground(new java.awt.Color(255, 255, 255));
        scoreTextField.setText("00");
        scoreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreTextFieldActionPerformed(evt);
            }
        });

        // High Score Text Field
        highScoreTextField.setBackground(color);
        highScoreTextField.setEditable(false);
        highScoreTextField.setForeground(new java.awt.Color(255, 255, 255));
        highScoreTextField.setName(""); // NOI18N
        highScoreTextField.setText("00");

        //setBackground(Color.BLACK);
        setBackground(color);
        setForeground(Color.WHITE);
        scoreLabel.setText("Score");
        highScoreLabel.setText("High Score");

        // Green button details
        greenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("green_arch_OFF.fw.png"))); // NOI18N
        greenButton.setBackground(Color.BLACK);
        greenButton.setText("Green");
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        // Red button details
        redButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("red_arch_OFF.fw.png"))); // NOI18N
        redButton.setBackground(Color.BLACK);
        redButton.setText("Red");
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        // Blue button details
        blueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("blue_arch_OFF.fw.png"))); // NOI18N
        blueButton.setBackground(Color.BLACK);
        blueButton.setText("Blue");
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        // Yellow button details
        yellowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("yellow_arch_OFF.fw.png"))); // NOI18N
        yellowButton.setBackground(Color.BLACK);
        yellowButton.setText("Yellow");
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        // Simon label details
        simonLabel.setFont(new java.awt.Font("Gulim", 0, 36)); // NOI18N
        simonLabel.setBackground(color);
        simonLabel.setForeground(Color.YELLOW);
        simonLabel.setText("S  I  M  O  N");

        
        // Panel layout details created in NetBeans using the GUI builder
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(exitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
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
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(simonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(simonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
                    .addComponent(highScoreTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>                        

    
    public void readSequentialFile(){
    	
    	openFile();
    	readRecord();
    	closeFile();
    	
    }
    
    public void openFile(){
    	
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
    
    public void readRecord(){
    	
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
    			
    			System.out.println("Settings in file are fileStatus: " + fileStatus +
    					"difficulty: " + difficulty +
    					"sound: " + sound +
    					"R setting: " + R +
    					"G setting: " + G +
    					"B setting: " + B);
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
    
    public void closeFile(){
    	
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
    
    // Score text field actions
    private void scoreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }                                              

    // Green button actions
    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("You have pressed the green button");
    }                                           

    // Red button actions
    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("You have pressed the red button");
    }                                         

    // Yellow button actions
    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("You have pressed the yellow button");
    }                                            

    // Blue button actions
    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("You have pressed the blue button");
    }                                          

    // Exit button actions
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }                                          

    // Variables declaration - do not modify                     
    private javax.swing.JButton blueButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton greenButton;
    private java.awt.Label highScoreLabel;
    private java.awt.TextField highScoreTextField;
    private javax.swing.JButton redButton;
    private java.awt.Label scoreLabel;
    private java.awt.TextField scoreTextField;
    private javax.swing.JLabel simonLabel;
    private javax.swing.JButton yellowButton;
    // End of variables declaration                   
}
