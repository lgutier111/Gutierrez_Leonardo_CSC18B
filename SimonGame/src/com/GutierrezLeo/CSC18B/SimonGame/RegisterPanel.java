package com.GutierrezLeo.CSC18B.SimonGame;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Label;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class RegisterPanel extends JPanel {
	
	//Declare objects and variables
	private JLabel firstNameLabel, lastNameLabel, emailLabel, studentIDLabel, dateLabel, headerLabel;
	private JTextField firstNameTextField, lastNameTextField, emailTextField, studentIDTextField, dateTextField;
	private SpringLayout currentLayout;
	private JButton saveButton;
	private final Action action = new SwingAction();
	private String firstName, lastName, email, studentID, birthDate;
	private boolean inputVerification = false;
	private Label thankYouLabel = new Label("Input Not Yet Validated");
	private final Action done = new SwingAction_1();
	private RegisterFrame parent;
	private static Formatter output;   //outputs data to file
	
	//Registration panel constructor
	public RegisterPanel() {
		
		//*****  Declare new labels with default text *****
		
		//First name label
		firstNameLabel = new JLabel("Enter First Name:");
		firstNameLabel.setForeground(Color.YELLOW);
		
		//Last name lable
		lastNameLabel = new JLabel("Enter Last Name:");
		lastNameLabel.setForeground(Color.YELLOW);
		
		//Email label
		emailLabel = new JLabel("Enter email:");
		emailLabel.setForeground(Color.YELLOW);
		
		//Student id label
		studentIDLabel = new JLabel("Enter Student ID:");
		studentIDLabel.setForeground(Color.YELLOW);
		
		//Date label
		dateLabel = new JLabel("Birthdate (mm/dd/yyyy):");
		dateLabel.setForeground(Color.YELLOW);
		
		//Header label
		headerLabel = new JLabel("S I M O N   PLAYER REGISTRATION");
		headerLabel.setForeground(Color.RED);

		//****  Declare new text fields for labels above*****
		firstNameTextField = new JTextField();
		lastNameTextField = new JTextField();
		emailTextField = new JTextField();
		studentIDTextField = new JTextField();
		dateTextField = new JTextField();
		
		//Declare save button and set color and action
		saveButton = new JButton("SAVE");
		saveButton.setBackground(Color.WHITE);
		saveButton.setAction(action);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//Layout for screen coded by Eclipse GUI builder
		currentLayout = new SpringLayout();
		currentLayout.putConstraint(SpringLayout.WEST, headerLabel, 89, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, headerLabel, 300, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.WEST, thankYouLabel, 6, SpringLayout.EAST, saveButton);
		currentLayout.putConstraint(SpringLayout.SOUTH, thankYouLabel, 0, SpringLayout.SOUTH, saveButton);
		currentLayout.putConstraint(SpringLayout.EAST, thankYouLabel, 31, SpringLayout.EAST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.NORTH, dateTextField, -3, SpringLayout.NORTH, dateLabel);
		currentLayout.putConstraint(SpringLayout.WEST, dateTextField, 0, SpringLayout.WEST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.EAST, dateTextField, 0, SpringLayout.EAST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.NORTH, studentIDTextField, -3, SpringLayout.NORTH, studentIDLabel);
		currentLayout.putConstraint(SpringLayout.WEST, studentIDTextField, 0, SpringLayout.WEST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.EAST, studentIDTextField, -97, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, emailTextField, -3, SpringLayout.NORTH, emailLabel);
		currentLayout.putConstraint(SpringLayout.WEST, emailTextField, 0, SpringLayout.WEST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.EAST, emailTextField, 0, SpringLayout.EAST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.NORTH, lastNameTextField, -3, SpringLayout.NORTH, lastNameLabel);
		currentLayout.putConstraint(SpringLayout.WEST, lastNameTextField, 0, SpringLayout.WEST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.EAST, lastNameTextField, 0, SpringLayout.EAST, firstNameTextField);
		currentLayout.putConstraint(SpringLayout.NORTH, firstNameTextField, -3, SpringLayout.NORTH, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.WEST, firstNameTextField, 51, SpringLayout.EAST, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.EAST, firstNameTextField, 142, SpringLayout.EAST, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.SOUTH, saveButton, -98, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.NORTH, dateLabel, 28, SpringLayout.SOUTH, studentIDLabel);
		currentLayout.putConstraint(SpringLayout.EAST, dateLabel, 0, SpringLayout.EAST, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.NORTH, studentIDLabel, 28, SpringLayout.SOUTH, emailLabel);
		currentLayout.putConstraint(SpringLayout.EAST, studentIDLabel, 0, SpringLayout.EAST, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.NORTH, emailLabel, 23, SpringLayout.SOUTH, lastNameLabel);
		currentLayout.putConstraint(SpringLayout.WEST, emailLabel, 102, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, lastNameLabel, 26, SpringLayout.SOUTH, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.EAST, lastNameLabel, 0, SpringLayout.EAST, firstNameLabel);
		currentLayout.putConstraint(SpringLayout.SOUTH, firstNameLabel, -411, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, firstNameLabel, 74, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, headerLabel, 26, SpringLayout.NORTH, this);
		
		//Set up the panel components
		setUpRegPanel();
	}
	
	//Add components to the registration panel
	private void setUpRegPanel(){
		
		//Set default colors to black and white
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		
		//Set the layout for the panel
		this.setLayout(currentLayout);
		
		//Add the labels and text fields for each item on the panel
		this.add(headerLabel);
		this.add(firstNameLabel);
		this.add(firstNameTextField);
		this.add(lastNameLabel);
		this.add(lastNameTextField);
		this.add(emailLabel);
		this.add(emailTextField);
		this.add(studentIDLabel);
		this.add(studentIDTextField);
		this.add(dateLabel);
		this.add(dateTextField);
		
		//Add the save button
		this.add(saveButton);
		
		//The thank you label to display after user enters correct input
		this.add(thankYouLabel);
		
		//Declare Done button with action and location relative to other button.  Coded by
		//  eclipse GUI builder
		JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		currentLayout.putConstraint(SpringLayout.NORTH, btnDone, 22, SpringLayout.SOUTH, saveButton);
		currentLayout.putConstraint(SpringLayout.WEST, btnDone, 0, SpringLayout.WEST, emailLabel);
		btnDone.setBackground(Color.WHITE);
		btnDone.setAction(done);
		add(btnDone);
	}

	
	//Action for the SAVE button
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SAVE");
			putValue(SHORT_DESCRIPTION, "Input Complete");
		}
		public void actionPerformed(ActionEvent e) {
			//Get the values entered by the user.
			firstName = firstNameTextField.getText();
			lastName = lastNameTextField.getText();
			email = emailTextField.getText();
			studentID = studentIDTextField.getText();
			birthDate = dateTextField.getText();
			
			//Perform the verifyInput method to test the input by the user
			verifyInput();
			
			//If the input by the user passes the verification process as valid input,
			//    then space out the fields and thank the user for registering.
			if (inputVerification){
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				emailTextField.setText("");
				studentIDTextField.setText("");
				dateTextField.setText("");
				thankYouLabel.setText("Thank You! User Registered");
				
				//Call the method to create the registration file for the user.
				createTextFile();
			}
		}
	}
	
	//Verify all input by the user
	private void verifyInput(){
		
		//If the first name does not start with a capital letter and/or is more than 20 bytes
		//    long, a pop up window will let the user know the input and ask to re-enter the data
		if (!ValidateInput.validateFirstName(firstName)){
			JOptionPane.showMessageDialog(this, "Bad First Name, " + firstName 
					+ ". Must start with a capital and up to 20 characters only.");
			firstNameTextField.setText("");
			
		//If the last name does not start with a capital letter and/or is more than 20 bytes
		//    long, a pop up window will let the user know the input and ask to re-enter the data
		} else if (!ValidateInput.validateLastName(lastName)){
			JOptionPane.showMessageDialog(this, "Bad Last Name, " + lastName 
					+ ". Up to 20 characters only. Dashes and hyphens are allowed.");
			lastNameTextField.setText("");
			
		//If the email entered is not a valid email address, a pop up window will let the user
		//    know the input and ask to re-enter the data
		} else if (!ValidateInput.validateEmail(email)){
			JOptionPane.showMessageDialog(this, "Bad email address: " + email 
					+ ". Please correct.");
			emailTextField.setText("");
			
		//If the Student ID is invalid, a pop up window will let the user know the input and ask
		//    the user to re-enter the data
		} else if (!ValidateInput.validateStudentID(studentID)){
			JOptionPane.showMessageDialog(this, "Bad student ID: " + studentID 
					+ ". Please correct.");
			studentIDTextField.setText("");
			
		//If the date of birth is invalid, a pop up window will let the user know the input and ask
		//    the user to re-enter the data
		} else if (!ValidateInput.validateDate(birthDate)){
			JOptionPane.showMessageDialog(this, "Invalide date: " + birthDate 
					+ ". Please correct.");
			dateTextField.setText("");
			
		//If all the fields passed the regular expression tests, then set the validation to true and
		//    thank the user for registering
		} else
			inputVerification = true;
			System.out.println("Valid input.  Thank you. Input Verification is: " + inputVerification);
	}
	
	
	//Done button action - will set the hide the registration panel and activate the settings panel.
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "DONE");
			putValue(SHORT_DESCRIPTION, "Done with registration");
		}
		public void actionPerformed(ActionEvent e) {
			//System.out.println("You have pressed the DONE button");
			setVisible(false);
			SettingsPanel settingsPanel = new SettingsPanel();
			settingsPanel.setVisible(true);
		}
	}
	
	private void createTextFile(){
		
		JFrame parentFrame = new JFrame();
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Save .txt Registration File");
		int userSelection = jfc.showSaveDialog(parentFrame);
		
		if(userSelection == JFileChooser.APPROVE_OPTION){
			File saveLocation = jfc.getSelectedFile();
			try
			{
				output = new Formatter(jfc.getSelectedFile() + ".txt");
				output.format("%s %s %s %s %s%n", firstName, lastName, email, studentID, birthDate);
				if (output != null)
					output.close();
			}
			catch (FileNotFoundException fnfe)
			{
				System.err.println("File not found.");
				fnfe.printStackTrace();
			}
			catch (FormatterClosedException fce)
			{
				System.err.println("Error writing to file.  Terminating.");
				fce.printStackTrace();
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println("Invalid input.");
				elementException.printStackTrace();
			}
		}
		
		inputVerification = false;
		
	}
}

