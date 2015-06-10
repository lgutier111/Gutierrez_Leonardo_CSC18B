/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimonPackage;

//
// This program taken from example in the text and modified heavily to fit the needs
// of this game.  Used in conjunction with the ResultSetTableModel class
//
//

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class GameHistoryFrame extends JFrame{
		
		
	//variables to connect to a mysql database remotely
		private static final String DATABASE_URL = "jdbc:mysql://209.129.8.4:3306/";
		private static final String USERNAME = "42029";
		private static final String PASSWORD = "42029csc18b";
		private static final String dbName = "42029";
		private static final String driver = "com.mysql.jdbc.Driver";

		private static String firstName = "firstName";
		private static String lastName = "lastName";
		private static String windowTitle;
		
		private List<String> userArrayList;
		
		private ScoreFrame sf = new ScoreFrame();
		
		// default query retrieves all data from authors table	
		//private static final String DEFAULT_QUERY = "SELECT * FROM authors";
		private String DEFAULT_QUERY = "SELECT entity_user_Simon.first_name, "
				+ "entity_user_Simon.last_name, "
				+ "entity_history_Simon.game_score, "
				+ "entity_history_Simon.game_level, "
				+ "enum_status_Simon.status_name "
				+ "FROM xref_user_history_Simon, "
				+ "entity_history_Simon, "
				+ "entity_user_Simon, "
				+ "enum_status_Simon "
				+ "WHERE xref_user_history_Simon.game_id = entity_history_Simon.game_id "
				+ "AND xref_user_history_Simon.user_id = entity_user_Simon.user_id "
				+ "AND enum_status_Simon.enum_status_id = entity_user_Simon.status "
				+ "AND entity_user_Simon.user_id = " + sf.getCurrentUserId();

		private PreparedStatement searchSimonUser;
		
		private static ResultSetTableModel tableModel;
	
	public GameHistoryFrame(){
		
		ResultSet resultSet = null;
		
		// create ResultSetTableModel and display database table
		try 
		{
			// create TableModel for results of query SELECT * FROM authors
			tableModel = new ResultSetTableModel(
					DATABASE_URL+dbName, USERNAME, PASSWORD, DEFAULT_QUERY);
			Connection connection = DriverManager.getConnection(DATABASE_URL+dbName, USERNAME, PASSWORD);

			//search the simon user to get first and lat name 
			searchSimonUser = connection.prepareStatement("SELECT first_name, last_name FROM entity_user_Simon WHERE user_id = ?");
			System.out.println("The user id from score frame is " + sf.getCurrentUserId());
			searchSimonUser.setInt(1, sf.getCurrentUserId());
			resultSet = searchSimonUser.executeQuery();
			System.out.println("Get the user first and last name");
			userArrayList = new ArrayList<String>();
			
			while (resultSet.next()){
				System.out.println("You are in the while loop");
				//userArrayList.add(resultSet.getString("first_name"));
				//serArrayList.add(resultSet.getString("last_name"));
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
				System.out.println("name from dbase is: " + firstName + " " + lastName);
				
				//System.out.println("array element is: " + userArrayList.get(0));
				//System.out.println("email entered by user is: " + email);
			}
			
			
			// create JTable based on the tableModel
			JTable resultTable = new JTable(tableModel);
      
			windowTitle = "Game History for " + firstName + " " + lastName;
			this.setTitle(windowTitle);

			add(new JScrollPane(resultTable), BorderLayout.CENTER);

			final TableRowSorter<TableModel> sorter = 
					new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);

			// ensure database is closed when user quits application
			addWindowListener(
					new WindowAdapter() 
					{
						public void windowClosed(WindowEvent event)
						{
							tableModel.disconnectFromDatabase();
							System.exit(0);
						} 
					} 
					); 
		} 
		catch (SQLException sqlException) 
		{
			JOptionPane.showMessageDialog(null, sqlException.getMessage(), 
					"Database error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectFromDatabase();
			System.exit(1); // terminate application
		}     
	}
}
