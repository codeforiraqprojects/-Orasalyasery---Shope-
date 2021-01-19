package Packg;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.SystemColor;

public class SellerPage extends JFrame {

	private JPanel contentPane;
	
	private JButton btn2 ;
	private JLabel lbl3_1;
	private JTextField txt3;
	private JTextField txt4;
	JLabel lbl3;
	
	JLabel lblUserName;
	JLabel lblSellerName;
	Connection	 conect ;
	   UpdateAmount UpQuan;
	String CluothesName;
	 String OraderQun;
	int TQaun;
	int CluothesID;
	static	int OraderQunN;
	int userId;
	String username;

	
	public SellerPage(int userId,String username) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 485);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(204, 0, 0));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn3 = new JButton("Enter Order");
		btn3.setForeground(SystemColor.activeCaptionBorder);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 19));

		btn3.setBackground(Color.DARK_GRAY);
		btn3.setBounds(50, 303, 139, 31);
		contentPane.add(btn3);
		
		JPanel header = new JPanel(new FlowLayout());
		header.setBounds(0, 0, 566, 60);
		contentPane.add(header);
		header.setBorder(BorderFactory.createTitledBorder("seller Page"));
		header.setBackground(Color.lightGray);
		
	
		
		
		JLabel lblSellerName_1 = new JLabel("Seller Name :");
		lblSellerName_1.setBounds(81, 16, 145, 35);
		header.add(lblSellerName_1);
		lblSellerName_1.setForeground(Color.BLACK);
		lblSellerName_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblSellerName_1.setBackground(new Color(255, 239, 213));
		
		JLabel lblUserName_1 = new JLabel(username);
		lblUserName_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblUserName_1.setBounds(223, 28, 105, 21);
		header.add(lblUserName_1);
		
		
		
	
		
		JPanel foter = new JPanel(new FlowLayout());
		foter.setBounds(10, 208, 556, 70);
		contentPane.add(foter);
		
		
	       
        
		
		
		JLabel lblNewLabel_2 = new JLabel("Order Quan");
		foter.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(135, 206, 250));
		
		txt4 = new JTextField();
		foter.add(txt4);
		txt4.setText("0");
		txt4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Clouthes Name");
		foter.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(new Color(135, 206, 250));
		
		JLabel lbl3_1 = new JLabel("");
		foter.add(lbl3_1);
		lbl3_1.setForeground(new Color(255, 0, 0));
		lbl3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel body = new JPanel();
		body.setBounds(10, 99, 541, 70);
		contentPane.add(body);
		

		
		JLabel lblNewLabel = new JLabel("Enter ID Cluothes");
		body.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		
		txt3 = new JTextField();
		body.add(txt3);
		txt3.setColumns(10);
		
		 btn2 = new JButton("Check Quan");
		 body.add(btn2);
		 btn2.setForeground(SystemColor.activeCaptionBorder);
		 btn2.setBackground(Color.DARK_GRAY);
		 btn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btn2.addActionListener(new ActionListener() {
		 	

		 	public void actionPerformed(ActionEvent arg0) {
		 	
		 			conect = DBConn.connect();

		 		        try {  
		 		        	 String sql = "select Cluothes.ID,Amount.TotalQaun,Cluothes.Name from Cluothes inner join Amount on Cluothes.ID=Amount.CluothesID where Cluothes.ID=?";  
		 		            PreparedStatement pst  = conect.prepareStatement(sql);  
		 		            pst.setString(1, txt3.getText().trim()); 
		 		             ResultSet rs = pst.executeQuery();
		 		             CluothesID=Integer.parseInt(rs.getString("ID"));
		 		            
		 		             CluothesName=rs.getString("Name");   
		 		             TQaun=Integer.parseInt(rs.getString("TotalQaun"));
		 		           	
		 		        	while(rs.next()) 
		 		        	{

		 		        	
		 		        		  if (TQaun>0) {
		 		        			
		 		        			  lbl3_1.setText(CluothesName);
		 		        				 
		 		        				  	
		 				        	}

		 				        	else 
		 				        	{
		 				        		JOptionPane.showMessageDialog(null, "Quantity implemented");
		 				        		}
		 		        	
		 		            
		 		            rs.close();
		 		            pst.close();
		 		        		  }
		 		            
		 		        } catch (SQLException e1) {  
		 					  JOptionPane.showMessageDialog(null,e1);

		 		        }
		 		        
		 		     
		 		     
		 		}
		 	});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			
				conect = DBConn.connect();

		        try {    OraderQun=txt4.getText();  
		        
		        OraderQunN=Integer.parseInt(OraderQun);  
		        	 String sql = "insert into Sealing (clouthesID,QuanOrder,UserId,date)values (?,?,?,datetime('now'))";  
		            PreparedStatement pst  = conect.prepareStatement(sql);  
		            pst.setInt(1, CluothesID);
		            pst.setInt(2, OraderQunN);
		            pst.setInt(3, userId);
		            pst.execute();	
		            pst.close();
		            UpdateAmount updatAmo=new UpdateAmount();
			        updatAmo.Update(OraderQunN,CluothesID);}
		      
		            
		        catch (SQLException e1) {  
					  JOptionPane.showMessageDialog(null,e1);
		        }
		        
				
			}
		});
		
	
     
	}
}
