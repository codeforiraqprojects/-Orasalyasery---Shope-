package Packg;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConn {


	    public static  Connection connect()   {  

			Connection conect  ;  
	        try {  
	        	Class.forName("org.sqlite.JDBC");

	     
	              conect = DriverManager.getConnection("jdbc:sqlite:ShopDB.db");
	          
	       

	              return conect;
	        } catch (Exception e) { 
				  JOptionPane.showMessageDialog(null,e.getMessage());

	            System.out.println();
	            return null;
	        }  
	    }  
	    
	}
