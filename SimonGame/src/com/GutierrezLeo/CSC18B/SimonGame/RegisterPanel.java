package com.GutierrezLeo.CSC18B.SimonGame;

import javax.swing.JButton;
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
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class RegisterPanel extends JPanel {
	
	private JLabel firstNameLabel, lastNameLabel, emailLabel, studentIDLabel, dateLabel, headerLabel;
	private JTextField firstNameTextField, lastNameTextField, emailTextField, studentIDTextField, dateTextField;
	private SpringLayout currentLayout;
	private JButton saveButton;
	private final Action action = new SwingAction();
	private String firstName, lastName, email, studentID, birthDate;
	private boolean inputVerification = false;
	private Label thankYouLabel = new Label("Input Not Yet Validated");
	private final Action action_1 = new SwingAction_1();
	private RegisterFrame parent;
	private static ObjectOutputStream output;   //outputs data to file
	
	public RegisterPanel() {
		
		firstNameLabel = new JLabel("Enter First Name:");
		firstNameLabel.setForeground(Color.YELLOW);
		lastNameLabel = new JLabel("Enter Last Name:");
		lastNameLabel.setForeground(Color.YELLOW);
		emailLabel = new JLabel("Enter email:");
		emailLabel.setForeground(Color.YELLOW);
		studentIDLabel = new JLabel("Enter Student ID:");
		studentIDLabel.setForeground(Color.YELLOW);
		dateLabel = new JLabel("Birthdate (mm/dd/yyyy):");
		dateLabel.setForeground(Color.YELLOW);
		headerLabel = new JLabel("PLAYER REGISTRATION");
		headerLabel.setForeground(Color.RED);

		firstNameTextField = new JTextField();
		lastNameTextField = new JTextField();
		emailTextField = new JTextField();
		studentIDTextField = new JTextField();
		dateTextField = new JTextField();
		
		
		saveButton = new JButton("SAVE");
		saveButton.setBackground(Color.WHITE);
		saveButton.setAction(action);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		currentLayout = new SpringLayout();
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
		currentLayout.putConstraint(SpringLayout.WEST, headerLabel, 137, SpringLayout.WEST, this);
		
		
		setUpRegPanel();
	}
	
	private void setUpRegPanel(){
		
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		
		this.setLayout(currentLayout);
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
		this.add(saveButton);
		
		add(thankYouLabel);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		currentLayout.putConstraint(SpringLayout.NORTH, btnDone, 22, SpringLayout.SOUTH, saveButton);
		currentLayout.putConstraint(SpringLayout.WEST, btnDone, 0, SpringLayout.WEST, emailLabel);
		btnDone.setBackground(Color.WHITE);
		btnDone.setAction(action_1);
		add(btnDone);
		
		//Put all the deatils for labels and text fields below:

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SAVE");
			putValue(SHORT_DESCRIPTION, "Input Complete");
		}
		public void actionPerformed(ActionEvent e) {
			//thankYouLabel = new Label("");
			System.out.println("you have pressed the save button");
			firstName = firstNameTextField.getText();
			lastName = lastNameTextField.getText();
			email = emailTextField.getText();
			studentID = studentIDTextField.getText();
			birthDate = dateTextField.getText();
			System.out.println("FirstName entered: " + firstName);
			System.out.println("LastName entered: " + lastName);
			System.out.println("email entered: " + email);
			System.out.println("Student ID entered: " + studentID);
			System.out.println("Today's Date: " + birthDate);
			verifyInput();
			
			if (inputVerification){
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				emailTextField.setText("");
				studentIDTextField.setText("");
				dateTextField.setText("");
				thankYouLabel.setText("Thank You! User Registered");
				
				createSequentialFile();
			}
		}
	}
	
	
	private void verifyInput(){
		
		if (!ValidateInput.validateFirstName(firstName)){
			JOptionPane.showMessageDialog(this, "Bad First Name, " + firstName 
					+ ". Up to 20 characters only.");
			firstNameTextField.setText("");
		} else if (!ValidateInput.validateLastName(lastName)){
			JOptionPane.showMessageDialog(this, "Bad Last Name, " + lastName 
					+ ". Up to 20 characters only. Dashes and hyphens are allowed.");
			lastNameTextField.setText("");
		} else if (!ValidateInput.validateEmail(email)){
			JOptionPane.showMessageDialog(this, "Bad email address: " + email 
					+ ". Please correct.");
			emailTextField.setText("");
		} else if (!ValidateInput.validateStudentID(studentID)){
			JOptionPane.showMessageDialog(this, "Bad student ID: " + studentID 
					+ ". Please correct.");
			studentIDTextField.setText("");
		} else if (!ValidateInput.validateDate(birthDate)){
			JOptionPane.showMessageDialog(this, "Invalide date: " + birthDate 
					+ ". Please correct.");
			dateTextField.setText("");
		} else
			inputVerification = true;
			System.out.println("Valid input.  Thank you. Input Verification is: " + inputVerification);
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "DONE");
			putValue(SHORT_DESCRIPTION, "Done with registration");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("You have pressed the DONE button");
			setVisible(false);
			SettingsPanel settingsPanel = new SettingsPanel();
			parent = new RegisterFrame();
			parent.setTitle("SETTINGS");
			//parent.add(settingsPanel);
			settingsPanel.setVisible(true);
			//parent.setVisible(false);
			//parent.dispose();
			////parent.ParentCloseMe();
		}
	}
	
	private void createSequentialFile(){
		
		openFile();
		addRecord();
		closeFile();
		
	}
	
	public static void openFile(){
		try{
			File file = new File("registered.ser");
			
			if(!file.exists()){
				System.out.println("you are in createNewFile if stmt");
				file.createNewFile();
			}
			
			output = new ObjectOutputStream(
					Files.newOutputStream(Paths.get("registered.ser")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.  Terminating.");
			System.exit(1);;  // terminate program
		}
	}
	
	public void addRecord(){
	
		try 
		{
		RegisteredUser registeredUser = new RegisteredUser(firstName, lastName, email, 
				studentID, birthDate);
		
		output.writeObject(registeredUser);
		} 
		catch (NoSuchElementException elementException)
		{ 
			System.err.println("Invalid input. Please try again.");
		} 
		catch (IOException ioException)
		{
			System.err.println("Error writeing to file.  Terminating.");
			//break;
		}
	}
	
	public void closeFile(){
		
		try
		{
			if (inputVerification)
				output.close();
		}
		catch (IOException ioException)
		{
			System.err.println("Error closing file.  Terminating.");
		}
		
	}
}
