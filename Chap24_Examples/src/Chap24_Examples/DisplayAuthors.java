package Chap24_Examples;

//Fig. 24.23: DisplayAuthors.java
//Displaying the contents of the authors table.
//********************************************************************************
//
//  THIS WORKS.  DATABASE IS FOUND AND TABLES ARE RECOGNIZED
//
//  TO GET THIS PROGRAM TO WORK I HAD TO DO THE FOLLOWING:
//
//		- Modify the CLASSPATH to include the following path:
//			c:\PROGRA~1\Java\jdk1.8.0_45\db\lib\derby.jar
//
//		- I also had to add 2 external libraries to the project in the package
// 			explorer.  They will end up in the Referenced Libraries.  I added
//			both derby.jar and derbyclient.jar from the library in the
//			CLASSPATH above.  It then started to work.
//********************************************************************************
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthors{
	
	public static void main(String args[]){
	// connect to jdbc database derby/apache database
	//final String DATABASE_URL = "jdbc:derby:books";
	//final String SELECT_QUERY = 
    //  "SELECT authorID, firstName, lastName FROM authors";
	
	// connect to mysql database connection
	final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
	final String dbName = "test";
	final String USERNAME = "root";
	final String PASSWORD = "";
	final String SELECT_QUERY = 
	    "SELECT authorID, firstName, lastName FROM authors";
	

   // use try-with-resources to connect to and query the database
   try 
   {	
	  //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	  Connection connection = DriverManager.getConnection(DATABASE_URL+dbName, USERNAME, PASSWORD); 
      Statement statement = connection.createStatement(); 
      ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
   
      // get ResultSet's meta data
      ResultSetMetaData metaData = resultSet.getMetaData();
      int numberOfColumns = metaData.getColumnCount();     
      
      System.out.printf("Authors Table of Books Database:%n%n");

      // display the names of the columns in the ResultSet
      for (int i = 1; i <= numberOfColumns; i++)
         System.out.printf("%-8s\t", metaData.getColumnName(i));
      System.out.println();
      
      // display query results
      while (resultSet.next()) 
      {
         for (int i = 1; i <= numberOfColumns; i++)
            System.out.printf("%-8s\t", resultSet.getObject(i));
         System.out.println();
      } 
   } // AutoCloseable objects' close methods are called now 
   catch (SQLException sqlException)                                
   {                                                                  
      sqlException.printStackTrace();
   }
} 
} // end class DisplayAuthors