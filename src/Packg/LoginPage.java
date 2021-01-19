package Packg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblLogin;
	private JTextField textField_1;
	private JLabel lblPassword;
	Connection	 conect ;
	int userSaler;
	String usname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setForeground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0648\u0627\u062C\u0647\u0629 \u0627\u0644\u062F\u062E\u0648\u0644");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(174, 11, 135, 49);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 86, 135, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblLogin = new JLabel("User Name");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(22, 79, 118, 34);
		frame.getContentPane().add(lblLogin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 131, 135, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(22, 137, 89, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(Color.GRAY);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				conect = DBConn.connect();

			        try {  
			        	 String sql = "select * from User where Name=? and Password=? ";  
			            PreparedStatement pst  = conect.prepareStatement(sql);  
			            pst.setString(1, textField.getText().trim()); 
			            pst.setString(2, textField_1.getText().trim()); 
			             ResultSet rs = pst.executeQuery();
			         	String s=rs.getString("IDType");
			         	 userSaler=Integer.parseInt(rs.getString("ID"));
			         	 usname=rs.getString("name");
			           	int count=0;
			        	while(rs.next()) 
			        	{
			        		count = count + 1;
			        	}
			        			
			        	if (count == 1)
			        	{
			      
			        		frame.dispose();
			        	
				        
					        if (s.equals("1")) {
					        		Admin ad =new Admin();
					        		ad.setVisible(true);
					   
					        	}

					        	else 
					        	{
					        		SellerPage sal =new SellerPage(userSaler,usname);
					        		sal.setVisible(true);
					        		
					        		

					        		}
			    
			        	}
			        	else
			        	{
			        		JOptionPane.showMessageDialog(null, "doesnt exist");

			        	}
			        	
			            
			            rs.close();
			            pst.close();
			            
			        } catch (SQLException e1) {  
						  JOptionPane.showMessageDialog(null,e1);

			        }
			        
			     
			     
			}
		});
		btnNewButton.setBounds(303, 209, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
