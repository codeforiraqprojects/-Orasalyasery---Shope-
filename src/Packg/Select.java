package Packg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends AbstractClass {
	ResultSet select() {
		ResultSet rs = null;

		Connection conect  ;  
        
        try {   //3
        	conect = DBConn.connect();
        	    String sql = "select Cluothes.Name,Cluothes.Quan as 'ald',Amount.TotalQaun from Cluothes inner join Amount on Cluothes.ID=Amount.CluothesID group by Cluothes.Name";  
	            PreparedStatement pst  = conect.prepareStatement(sql);  
	             rs = pst.executeQuery();
	           
        } catch (SQLException e1) {  
            System.out.println(e1.getMessage());  
        }
		return rs; }
	

	
}
