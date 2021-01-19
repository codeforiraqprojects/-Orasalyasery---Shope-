package Packg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import net.proteanit.sql.DbUtils;

import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.sql.Connection;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Admin extends JFrame {

	private JPanel contentPane;

	Connection conect = DBConn.connect();
	private  JTable table;
	
	public Admin() {
		
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_7339326210075");
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 60, 320, 153);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show Report Seller");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbstractClass ins=new Select() ;
//				abstract
				 table.setModel(DbUtils.resultSetToTableModel(ins.select()));
			}
		});
		btnNewButton.setBounds(119, 11, 159, 23);
		panel.add(btnNewButton);
	}
}
