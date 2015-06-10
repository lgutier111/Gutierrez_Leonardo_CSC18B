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

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Label;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class RegisterPanel extends JPanel {
	
	//Declare objects and variables
	private JLabel firstNameLabel, lastNameLabel, emailLabel, studentIDLabel, dateLabel, headerLabel;
	private JTextField firstNameTextField, lastNameTextField, emailTextField, studentIDTextField, dateTextField;
	private SpringLayout currentLayout;
	private JButton saveButton;
	private final Action action = new SwingAction();
	private String firstName, lastName, email, studentID, birthDate;
	
	private boolean inputVerification = false;
	private boolean userAlreadyRegistered = false;
	private boolean somebodyRegistered = false;
	
	private Label thankYouLabel = new Label("Input Not Yet Validated");
	private final Action done = new SwingAction_1();

	private static Formatter output;   //outputs data to file
	private final int status = 0;      //fill with 0 until the user finishes the game to upate value
	private int result = 0;
	private int count = 0;
	
	private PreparedStatement insertNewRegistrant;
	private PreparedStatement searchEmailAddress;
	
	private DateFormat formatter = new SimpleDateFormat("yyy-mm-dd");
	private StringTokenizer st;
	private String[] holdDate;
	private String day;
	private String month;
	private String year;
	private String reformattedDate;
	private java.sql.Date sqlDate;
	
	private List<String> emailArrayList;
	private int currentUserId;
	
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
		
		this.currentUserId = currentUserId;
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
						
			System.out.println("You are in the actionPerformed for SAVE button");
			//Get the values entered by the user.
			firstName = firstNameTextField.getText().trim();
			lastName = lastNameTextField.getText().trim();
			email = emailTextField.getText().trim();
			studentID = studentIDTextField.getText().trim();
			birthDate = dateTextField.getText().trim();
			
			//Perform the verifyInput method to test the input by the user
			System.out.println("Right before validate input called");
			verifyInput();
			
			// add database save here
			if (inputVerification){
				System.out.println("input has been verified");
				System.out.println("Result going into dbase update is: " + result);
				//emailArrayList = new ArrayList<String>();
				ResultSet resultSet = null;
				
				//Insert into database
				try
				{
					String DATABASE_URL = "jdbc:mysql://209.129.8.4:3306/42029";
					String USERNAME = "42029";
					String PASSWORD = "42029csc18b";
					Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
					
					// SEE IF A USER ALREADY REGISTERED
					//See if user is already registered by looking at the email address.  If the email address is already
					//    in the database, then inform the user that there is already somebody registered with that 
					//    same email.
					System.out.println("Right before the searchEmailAddress SELECT stmt");
					searchEmailAddress = connection.prepareStatement("SELECT user_email, user_id FROM entity_user_Simon WHERE user_email = ?");
					searchEmailAddress.setString(1, email);
					resultSet = searchEmailAddress.executeQuery();
					System.out.println("in the see if a user already exists section");
					emailArrayList = new ArrayList<String>();
					
					while (resultSet.next()){
						System.out.println("You are in the while loop");
						emailArrayList.add(resultSet.getString("user_email"));
						System.out.println("array element is: " + emailArrayList.get(0));
						System.out.println("email entered by user is: " + email);
						if (emailArrayList.get(0).equals(email)){
							JOptionPane.showMessageDialog(null, "You are already registered. Thank you.",
									"Registration Complete", JOptionPane.INFORMATION_MESSAGE);
							currentUserId = resultSet.getInt("user_id");
							result = 1;
							userAlreadyRegistered = true;
							System.out.println("The current user id is: " + currentUserId);
						}
					}
					
					System.out.println("Right before the add a user section");
					//  ADD A USER IF USER HASN'T REGISTERED
					if (!userAlreadyRegistered){
						System.out.println("You are in the add user if stmt");
						// create PREPARED STATEMENT to insert that adds a new entry into the database
						insertNewRegistrant = connection.prepareStatement(
							"INSERT INTO entity_user_Simon" +
							"(first_name, last_name, user_email, student_id, birth_date, status)" +
									"VALUES (?, ?, ?, ?, ?, ?)");
					
						reformatTheDate();
					
						insertNewRegistrant.setString(1, firstName);
						insertNewRegistrant.setString(2, lastName);
						insertNewRegistrant.setString(3, email);
						insertNewRegistrant.setString(4, studentID);
						insertNewRegistrant.setDate(5, sqlDate);
						insertNewRegistrant.setInt(6, status);
					
						//insert the new entry; returns the number of rows updated
						result = insertNewRegistrant.executeUpdate();
					}
					
					// Get the user_id of the user just added
					//   Use the email entered above to get the user_id just created
					if (!userAlreadyRegistered){
					System.out.println("Right before the searchEmailAddress SELECT stmt");
					searchEmailAddress = connection.prepareStatement("SELECT user_email, user_id FROM entity_user_Simon WHERE user_email = ?");
					searchEmailAddress.setString(1, email);
					resultSet = searchEmailAddress.executeQuery();
					System.out.println("in the see if a user already exists section");
					emailArrayList = new ArrayList<String>();
					
						while (resultSet.next()){
							System.out.println("You are in the 2nd while loop");
							emailArrayList.add(resultSet.getString("user_email"));
							System.out.println("array element is: " + emailArrayList.get(0));
							System.out.println("email entered by user is: " + email);
							if (emailArrayList.get(0).equals(email)){
								currentUserId = resultSet.getInt("user_id");
								result = 1;
								System.out.println("The user id of the newly added user is: " + currentUserId);
							}
						}
					}
					
					
					}
					catch (SQLException sqlException)
					{
						sqlException.printStackTrace();
						System.exit(1);
					}
					
				if (result == 1)
					thankYouLabel.setText("User has been registered!!!");
				else
					thankYouLabel.setText("User has not been added");
				
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				emailTextField.setText("");
				studentIDTextField.setText("");
				dateTextField.setText("");
				
				// Update the file with the current user
				saveTheCurrentUser();
				
				inputVerification = false;
				userAlreadyRegistered = false;
				somebodyRegistered = true;
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
	
	private void reformatTheDate(){
		
		holdDate = new String[3];
		
		st = new StringTokenizer(birthDate, "/-");
		for (int s = 0; s < 3; s++){
			splitDate(s);
		}
		
		reformattedDate = holdDate[2] + "-" + holdDate[0] + "-" + holdDate[1];
		
		Date myDate = null;
		try
		{
			myDate = formatter.parse(reformattedDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		sqlDate = new java.sql.Date(myDate.getTime());
	}
	
	private void splitDate(int s){
		
		holdDate[s] = st.nextToken("/-");
		
		month = holdDate[0];
		day   = holdDate[1];
		year  = holdDate[2];
	}
	
	protected void setCurrentUserId(int currentUserId){
		this.currentUserId = currentUserId;
	}
	
	protected int getCurrentUserId(){
		return currentUserId;
	}
	
	private void saveTheCurrentUser(){
		
		try {

			System.out.println("Writing out the currentUserId: " + currentUserId);
			String stringCurrentUserId = null;
			stringCurrentUserId = Integer.toString(currentUserId);
			File file = new File("currentUser.txt");
 
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			fw.write(stringCurrentUserId);
			fw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Done button action - will set the hide the registration panel and activate the settings panel.
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "DONE");
			putValue(SHORT_DESCRIPTION, "Done with registration");
		}
		public void actionPerformed(ActionEvent e) {
			
			// if the user bypassed registration, save 0 to the currentUser file
			if (!somebodyRegistered)
				currentUserId = 0;
			
			saveTheCurrentUser();
			
			setVisible(false);
			SettingsPanel settingsPanel = new SettingsPanel();
			settingsPanel.setVisible(true);
		}
	}
}

