package Packg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class UpdateAmount {
	Connection	 conect;
	void Update(int a,int b) {
		conect = DBConn.connect();
			// TODO Auto-generated method stub
		     try {   //3
		            String sql = "update Amount set totalQaun=totalQaun-? where Amount.ID=?";  
		            PreparedStatement pst  = conect.prepareStatement(sql);  
		            pst.setString(1,(String.valueOf(a)));
		            pst.setString(2,(String.valueOf(b)));
		            pst.execute();
	     		JOptionPane.showMessageDialog(null, "update amount");
	     		pst.close();
	           
	          
	     } catch (SQLException e1) {  
	         System.out.println(e1.getMessage());  
	     }  
			
		}

	
}
