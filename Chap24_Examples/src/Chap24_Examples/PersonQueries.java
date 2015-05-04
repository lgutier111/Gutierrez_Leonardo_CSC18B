package Chap24_Examples;

//********************************************************************************
//
//THIS WORKS.  DATABASE IS FOUND AND TABLES ARE RECOGNIZED
//
//TO GET THIS PROGRAM TO WORK I HAD TO DO THE FOLLOWING:
//
//		- Modify the CLASSPATH to include the following path:
//			c:\PROGRA~1\Java\jdk1.8.0_45\db\lib\derby.jar
//
//		- I also had to add 2 external libraries to the project in the package
//			explorer.  They will end up in the Referenced Libraries.  I added
//			both derby.jar and derbyclient.jar from the library in the
//			CLASSPATH above.  It then started to work.
//********************************************************************************

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries 
{
   //private static final String URL = "jdbc:derby:addressbook";
   //private static final String userName = "deitel";
   //private static final String password = "deitel";
	
   // static variables below used for mysql connection
   private static final String URL = "jdbc:mysql://localhost:3306/";
   private static final String dbName = "test";
   private static final String driver = "com.mysql.jdbc.Driver";
   private static final String userName = "root";
   private static final String password = "";
   // used for mysql connection
 
   private Connection connection; // manages connection
   private PreparedStatement selectAllPeople; 
   private PreparedStatement selectPeopleByLastName; 
   private PreparedStatement insertNewPerson; 
    
   // constructor
   public PersonQueries()
   {
      try 
      {
    	 //Class statement below used for mysql connections
    	 Class.forName(driver).newInstance();
         connection = 	
         	DriverManager.getConnection(URL+dbName, userName, password);

         
         // create query that selects all entries in the AddressBook
         selectAllPeople = 
            connection.prepareStatement("SELECT * FROM Addresses");
         
         // create query that selects entries with a specific last name
         selectPeopleByLastName = connection.prepareStatement(
            "SELECT * FROM Addresses WHERE LastName = ?");
         
         // create insert that adds a new entry into the database
         insertNewPerson = connection.prepareStatement(
            "INSERT INTO Addresses " + 
            "(FirstName, LastName, Email, PhoneNumber) " + 
            "VALUES (?, ?, ?, ?)");
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         System.exit(1);
      }
      catch (IllegalAccessException iae)
      {
    	  System.err.println("Illegal Access to database");
    	  iae.printStackTrace();
      }
      catch (InstantiationException ie)
      {
    	  System.err.println("Can't instantiate database");
    	  ie.printStackTrace();
      }
      catch (ClassNotFoundException cnfe)
      {
    	  System.err.println("Class not found");
    	  cnfe.printStackTrace();
      }
   } // end PersonQueries constructor
   
   // select all of the addresses in the database
   public List< Person > getAllPeople()
   {
      List< Person > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllPeople.executeQuery(); 
         results = new ArrayList< Person >();
         
         while (resultSet.next())
         {
            results.add(new Person(
               resultSet.getInt("addressID"),
               resultSet.getString("firstName"),
               resultSet.getString("lastName"),
               resultSet.getString("email"),
               resultSet.getString("phoneNumber")));
         } 
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();         
      } 
      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException sqlException)
         {
            sqlException.printStackTrace();         
            close();
         }
      }
      
      return results;
   } 

   // select person by last name   
   public List< Person > getPeopleByLastName(String name)
   {
      List< Person > results = null;
      ResultSet resultSet = null;

      try 
      {
         selectPeopleByLastName.setString(1, name); // specify last name

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPeopleByLastName.executeQuery(); 

         results = new ArrayList< Person >();

         while (resultSet.next())
         {
            results.add(new Person(resultSet.getInt("addressID"),
               resultSet.getString("firstName"),
               resultSet.getString("lastName"),
               resultSet.getString("email"),
               resultSet.getString("phoneNumber")));
         } 
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      } 
      finally
      {
         try 
         {
            resultSet.close();
         }
         catch (SQLException sqlException)
         {
            sqlException.printStackTrace();         
            close();
         }
      } 
      
      return results;
   } 
   
   // add an entry
   public int addPerson(
      String fname, String lname, String email, String num)
   {
      int result = 0;
      
      // set parameters, then execute insertNewPerson
      try 
      {
         insertNewPerson.setString(1, fname);
         insertNewPerson.setString(2, lname);
         insertNewPerson.setString(3, email);
         insertNewPerson.setString(4, num);

         // insert the new entry; returns # of rows updated
         result = insertNewPerson.executeUpdate(); 
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         close();
      } 
      
      return result;
   } 
   
   // close the database connection
   public void close()
   {
      try 
      {
         connection.close();
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      } 
   } 
} // end class PersonQueries