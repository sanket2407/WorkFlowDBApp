package controller.client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
public class ClientController {
    
    @RequestMapping(value= "/login", method = RequestMethod.GET)
    @ResponseBody
    public String clientLogin(){
    	
    	return "client login";
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
    	      sql = "INSERT INTO client_master ( name, address, password ) VALUES ("+client.getName()+","+client.getAdd()+","+client.getPassword()+")";
    	      
    	      stmt.executeUpdate(sql);

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
    	
    	return new ResponseEntity<Object>(client, HttpStatus.CREATED);
    }

    @RequestMapping(value= "/clientLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> clientLogin(@RequestBody Client client){
    	
    	return null;
    }
    
    @RequestMapping(value = "/xxx1", method = RequestMethod.POST)
    @ResponseBody
    public String xxx(){
		return "dasdsadd";
    }
    
	
}