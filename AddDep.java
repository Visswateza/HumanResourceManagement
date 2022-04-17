import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddDep{

	JFrame AD = new JFrame();
	
	private JPanel contentPane;
	private JTextField tfEID;
	private JTextField tdDepN;
	private JTextField tfDepDOB;
	private JTextField DepRelation;
	private JTextField tfSearch;
	JTable DepTable;

	public AddDep() {
		AD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AD.setBounds(100, 100, 1000, 600);
		AD.setLayout(null);
		AD.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Human Resources Management");
		lblNewLabel.setBounds(0, 11, 1000, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		AD.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Dependent");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(79, 72, 150, 40);
		AD.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee ID : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(147, 123, 150, 25);
		AD.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Dependent Name : ");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(147, 159, 150, 25);
		AD.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("DOB (yyyy-mm-dd) ");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(147, 195, 150, 25);
		AD.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Relation :");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(147, 231, 150, 25);
		AD.add(lblNewLabel_2_2_2);
		
		tfEID = new JTextField();
		tfEID.setColumns(10);
		tfEID.setBounds(307, 123, 200, 25);
		AD.add(tfEID);
		
		tdDepN = new JTextField();
		tdDepN.setColumns(10);
		tdDepN.setBounds(307, 159, 200, 25);
		AD.add(tdDepN);
		
		tfDepDOB = new JTextField();
		tfDepDOB.setColumns(10);
		tfDepDOB.setBounds(307, 195, 200, 25);
		AD.add(tfDepDOB);
		
		DepRelation = new JTextField();
		DepRelation.setColumns(10);
		DepRelation.setBounds(307, 231, 200, 25);
		AD.add(DepRelation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 370, 800, 170);
		AD.add(scrollPane);
		
		DepTable = new JTable();
		scrollPane.setViewportView(DepTable);
		
		try {
			Date dt = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			String date = ft.format(dt);
			tfDepDOB.setText(date);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e,"Failed Message",JOptionPane.ERROR_MESSAGE);
		}
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HResource","root","root");
					
					PreparedStatement ps = conn.prepareStatement("insert into Dependent(Emp_ID, Dep_Name, DOB, Relation) values(?,?,?,?);");
					ps.setString(1,tfEID.getText());
					ps.setString(2,tdDepN.getText());
					ps.setString(3,tfDepDOB.getText()); 
					ps.setString(4,DepRelation.getText()); 
					
					int x= ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null,"Registration Success","Success Message",JOptionPane.PLAIN_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null,"Registration Failed","Failed Message",JOptionPane.ERROR_MESSAGE);
					}
					ps.close();
					conn.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1,"Failed Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(407, 267, 100, 30);
		AD.add(btnAdd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin();
				AD.dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGoBack.setBounds(800, 72, 100, 30);
		AD.add(btnGoBack);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search for Employee Dependents");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(79, 329, 280, 30);
		AD.add(lblNewLabel_1_1);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(335, 329, 250, 30);
		AD.add(tfSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HResource","root","root");
					
					String str = "select * from Dependent where Emp_Id = "+tfSearch.getText()+";"; 
					PreparedStatement ps1 = conn.prepareStatement(str);
					ResultSet rs2 = ps1.executeQuery();
					DepTable.setModel(DbUtils.resultSetToTableModel(rs2));
					ps1.close();
				}
				catch(Exception e1) {
					
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(595, 329, 146, 30);
		AD.add(btnSearch);
		
	}
}
