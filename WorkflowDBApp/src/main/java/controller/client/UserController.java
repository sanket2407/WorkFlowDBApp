package controller.client;

import java.sql.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import databaseConnection.DBConnection;

@RestController
public class UserController {
    
    @RequestMapping("/ram")
    public String index() {
		return "dasdsadd";
    }
    
}
