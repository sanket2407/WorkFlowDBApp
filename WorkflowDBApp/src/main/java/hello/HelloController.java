package hello;

import java.sql.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import databaseConnection.DBConnection;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
    	
    	DBConnection dbCon = new DBConnection();
    	Connection conn = dbCon.getConnection();
    	Statement stmt = null;
    	
    	try{
    		
    	      System.out.println("Creating statement...");
    	      stmt = conn.createStatement();
    	      String sql;
    	      sql = "SELECT name, address FROM client_master";
    	      ResultSet rs = stmt.executeQuery(sql);

    	      while(rs.next()){
    	         //Retrieve by column name
    	         String name = rs.getString("name");
    	         System.out.println(name);

    	      }

    	      rs.close();
    	      stmt.close();
    	      conn.close();
    	   }catch(Exception e){
    	      //Handle errors for Class.forName
    	      e.printStackTrace();
    	   }finally{
    	      //finally block used to close resources
    	      try{
    	         if(stmt!=null)
    	            stmt.close();
    	      }catch(SQLException se2){
    	      }// nothing we can do
    	      try{
    	         if(conn!=null)
    	            conn.close();
    	      }catch(SQLException se){
    	         se.printStackTrace();
    	      }//end finally try
    	   }//end try
    	   System.out.println("Done!");
    	
        return "Greetings from Spring Boot!";
    }
    
}
