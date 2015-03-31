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

public class RegisterPanel extends JPanel {
	
	private JLabel firstNameLabel, lastNameLabel, emailLabel, studentIDLabel, dateLabel, headerLabel;
	private JTextField firstNameTextField, lastNameTextField, emailTextField, studentIDTextField, dateTextField;
	private SpringLayout currentLayout;
	private JButton okButton;
	private final Action action = new SwingAction();
	private String firstName, lastName, email, studentID, todayDate;
	private boolean inputVerification = false;
	private Label thankYouLabel = new Label("Input Not Yet Validated");
	
	public RegisterPanel() {
		
		firstNameLabel = new JLabel("Enter First Name:");
		firstNameLabel.setForeground(Color.YELLOW);
		lastNameLabel = new JLabel("Enter Last Name:");
		lastNameLabel.setForeground(Color.YELLOW);
		emailLabel = new JLabel("Enter email:");
		emailLabel.setForeground(Color.YELLOW);
		studentIDLabel = new JLabel("Enter Student ID:");
		studentIDLabel.setForeground(Color.YELLOW);
		dateLabel = new JLabel("Enter Date (mm/dd/yyyy):");
		dateLabel.setForeground(Color.YELLOW);
		headerLabel = new JLabel("PLAYER REGISTRATION");
		headerLabel.setForeground(Color.RED);

		firstNameTextField = new JTextField();
		lastNameTextField = new JTextField();
		emailTextField = new JTextField();
		studentIDTextField = new JTextField();
		dateTextField = new JTextField();
		
		
		
		okButton = new JButton("OK");
		okButton.setAction(action);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		currentLayout = new SpringLayout();
		currentLayout.putConstraint(SpringLayout.WEST, thankYouLabel, 6, SpringLayout.EAST, okButton);
		currentLayout.putConstraint(SpringLayout.SOUTH, thankYouLabel, 0, SpringLayout.SOUTH, okButton);
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
		currentLayout.putConstraint(SpringLayout.SOUTH, okButton, -98, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, okButton, 0, SpringLayout.EAST, firstNameLabel);
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
		this.add(okButton);
		
		add(thankYouLabel);
		
		//Put all the deatils for labels and text fields below:

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Input Complete");
		}
		public void actionPerformed(ActionEvent e) {
			//thankYouLabel = new Label("");
			System.out.println("you have pressed the OK button");
			firstName = firstNameTextField.getText();
			lastName = lastNameTextField.getText();
			email = emailTextField.getText();
			studentID = studentIDTextField.getText();
			todayDate = dateTextField.getText();
			System.out.println("FirstName entered: " + firstName);
			System.out.println("LastName entered: " + lastName);
			System.out.println("email entered: " + email);
			System.out.println("Student ID entered: " + studentID);
			System.out.println("Today's Date: " + todayDate);
			verifyInput();
			
			if (inputVerification){
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				emailTextField.setText("");
				studentIDTextField.setText("");
				dateTextField.setText("");
				thankYouLabel.setText("Thank You! User Registered");
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
		} else if (!ValidateInput.validateDate(todayDate)){
			JOptionPane.showMessageDialog(this, "Invalide date: " + todayDate 
					+ ". Please correct.");
			dateTextField.setText("");
		} else
			inputVerification = true;
			System.out.println("Valid input.  Thank you. Input Verification is: " + inputVerification);
	}
}
