package main;

import java.sql.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import databaseConnection.DBConnection;
import model.Client;

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
    
    /*{
	"name" = "Microsoft",
	"add" = "Seattle",
	"password" = "admin"
	}*/
	@RequestMapping(value= "/clientSignUp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> clientSignUp(@RequestBody Client client){
		
		Connection conn = new DBConnection().getConnection();
		Statement stmt = null;
		
		try{	
		      stmt = conn.createStatement();
		      String sql;
		      sql = "INSERT INTO client_master ( name, address, password ) VALUES ('"+client.getName()+"','"+client.getAdd()+"','"+client.getPassword()+"')";
		      
		      System.out.println(sql);
		      
		      stmt.executeUpdate(sql);
	
		      stmt.close();
		      conn.close();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se1){
		    	  se1.printStackTrace();
		    	  return new ResponseEntity<Object>(se1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se2){
		         se2.printStackTrace();
		         return new ResponseEntity<Object>(se2.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		      }//end finally try
		   }//end try
		
		return new ResponseEntity<Object>(client, HttpStatus.CREATED);
	}

    /*{
	"name" = "Microsoft",
	"password" = "admin"
	}*/
    @RequestMapping(value= "/clientLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> clientLogin(@RequestBody Client client){
    	
    	DBConnection dbCon = new DBConnection();
    	Connection conn = dbCon.getConnection();
    	Statement stmt = null;
    	try{
    		
    	      System.out.println("Creating statement...");
    	      stmt = conn.createStatement();
    	      String sql;
    	      sql = "SELECT password FROM client_master where name='"+client.getName()+"'";
    	      ResultSet rs = stmt.executeQuery(sql);
    	      System.out.println(sql);
    	      while(rs.next()){
    	         //Retrieve by column name
    	         String pass = rs.getString("password");
    	       
    	         if(pass.equals(client.getPassword())){
    	        	 
    	        	 return new ResponseEntity<Object>(client, HttpStatus.OK);
    	         }
    	         else{
    	        	 return new ResponseEntity<Object>("Invalid username or password!", HttpStatus.BAD_REQUEST);
    	         }
    	      }

    	      rs.close();
    	      stmt.close();
    	      conn.close();
    	   }catch(Exception e){
 		      //Handle errors for Class.forName
 		      e.printStackTrace();
 		      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
 		   }finally{
 		      //finally block used to close resources
 		      try{
 		         if(stmt!=null)
 		            stmt.close();
 		      }catch(SQLException se1){
 		    	  se1.printStackTrace();
 		    	  return new ResponseEntity<Object>(se1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
 		      }// nothing we can do
 		      try{
 		         if(conn!=null)
 		            conn.close();
 		      }catch(SQLException se2){
 		         se2.printStackTrace();
 		         return new ResponseEntity<Object>(se2.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
 		      }//end finally try
 		   }//end try
		return new ResponseEntity<Object>("Invalid username or password!", HttpStatus.BAD_REQUEST);
    }
    
    
}
