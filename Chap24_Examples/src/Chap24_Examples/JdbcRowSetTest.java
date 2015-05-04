package Chap24_Examples;

//Fig. 24.29: JdbcRowSetTest.java
//Displaying the contents of the authors table using JdbcRowSet.
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;  
import javax.sql.rowset.RowSetProvider;  

public class JdbcRowSetTest {
	// JDBC driver name and database URL to connect derby/apache database                      
	//private static final String DATABASE_URL = "jdbc:derby:books";
	//private static final String USERNAME = "deitel";
	//private static final String PASSWORD = "deitel";

	// MySQL driver / database connect variables
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String dbName = "test";
	private static final String driver = "com.mysql.jdbc.Driver";

public static void main(String args[])
{
   // connect to database books and query database
   try (JdbcRowSet rowSet =
      RowSetProvider.newFactory().createJdbcRowSet())
   {
      // specify JdbcRowSet properties 
      rowSet.setUrl(DATABASE_URL+dbName);        
      rowSet.setUsername(USERNAME);          
      rowSet.setPassword(PASSWORD);          
      rowSet.setCommand("SELECT * FROM authors"); // set query
      rowSet.execute(); // execute query                        

      // process query results
      ResultSetMetaData metaData = rowSet.getMetaData();
      int numberOfColumns = metaData.getColumnCount();
      System.out.println("Authors Table of Books Database:\n");

      // display rowset header
      for (int i = 1; i <= numberOfColumns; i++)
         System.out.printf("%-8s\t", metaData.getColumnName(i));
      System.out.println();
      
      // display each row
      while (rowSet.next()) 
      {
         for (int i = 1; i <= numberOfColumns; i++)
            System.out.printf("%-8s\t", rowSet.getObject(i));
         System.out.println();
      }
   }
   catch (SQLException sqlException) 
   {
      sqlException.printStackTrace();
      System.exit(1);
   }
} 
} // end class JdbcRowSetTest
