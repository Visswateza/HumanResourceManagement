import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddEmp{
	
	JFrame AE = new JFrame();
	private JTextField tfName;
	private JTextField tfGender;
	private JTextField tfDOB;
	private JTextField tfAddress;
	private JTextField tfQualification;
	private JTextField tfExperience;
	private JTextField tfPositon;
	private JTextField tfDepartment;
	private JTextField tfSalary;

	public AddEmp() {
		AE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AE.setBounds(100, 100, 1000, 600);
		AE.setVisible(true);
		AE.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Human Resources Management");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 11, 984, 50);
		AE.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(79, 72, 150, 40);
		AE.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee ID : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(147, 123, 150, 25);
		AE.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(307, 123, 150, 25);
		AE.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Name : ");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(147, 159, 150, 25);
		AE.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Gender : ");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(147, 195, 150, 25);
		AE.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("DOB (YYYY-MM-DD)");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(147, 231, 150, 25);
		AE.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Address :");
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_3.setBounds(147, 267, 150, 25);
		AE.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Qualification : ");
		lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_4.setBounds(147, 303, 150, 25);
		AE.add(lblNewLabel_2_2_4);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("Experience : ");
		lblNewLabel_2_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_5.setBounds(147, 339, 150, 25);
		AE.add(lblNewLabel_2_2_5);
		
		JLabel lblNewLabel_2_2_6 = new JLabel("Position : ");
		lblNewLabel_2_2_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_6.setBounds(147, 375, 150, 25);
		AE.add(lblNewLabel_2_2_6);
		
		JLabel lblNewLabel_2_2_7 = new JLabel("Department : ");
		lblNewLabel_2_2_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_7.setBounds(147, 411, 150, 25);
		AE.add(lblNewLabel_2_2_7);
		
		JLabel lblNewLabel_2_2_8 = new JLabel("Salary : ");
		lblNewLabel_2_2_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_8.setBounds(147, 447, 150, 25);
		AE.add(lblNewLabel_2_2_8);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(307, 159, 200, 25);
		AE.add(tfName);
		
		tfGender = new JTextField();
		tfGender.setColumns(10);
		tfGender.setBounds(307, 195, 200, 25);
		AE.add(tfGender);
		
		tfDOB = new JTextField();
		tfDOB.setColumns(10);
		tfDOB.setBounds(307, 231, 200, 25);
		AE.add(tfDOB);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(307, 267, 500, 25);
		AE.add(tfAddress);
		
		tfQualification = new JTextField();
		tfQualification.setColumns(10);
		tfQualification.setBounds(307, 303, 200, 25);
		AE.add(tfQualification);
		
		tfExperience = new JTextField();
		tfExperience.setColumns(10);
		tfExperience.setBounds(307, 339, 200, 25);
		AE.add(tfExperience);
		
		tfPositon = new JTextField();
		tfPositon.setColumns(10);
		tfPositon.setBounds(307, 377, 200, 25);
		AE.add(tfPositon);
		
		tfDepartment = new JTextField();
		tfDepartment.setColumns(10);
		tfDepartment.setBounds(307, 411, 200, 25);
		AE.add(tfDepartment);
		
		tfSalary = new JTextField();
		tfSalary.setColumns(10);
		tfSalary.setBounds(307, 447, 200, 25);
		AE.add(tfSalary);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HResource","root","root");
			
			PreparedStatement stmt = conn.prepareStatement("select max(ID) from Employee;");
			ResultSet rs1 = stmt.executeQuery();
			rs1.next();						
			int Max = Integer.parseInt(rs1.getString("max(ID)"));
			Max = Max+1;
			lblNewLabel_2_1.setText(""+Max);
			
			Date dt = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			String date = ft.format(dt);
			tfDOB.setText(date);
			
			conn.close();
			stmt.close();
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
					
					PreparedStatement stmt = conn.prepareStatement("select max(ID) from Employee;");
					ResultSet rs1 = stmt.executeQuery();
					rs1.next();						
					int Max = Integer.parseInt(rs1.getString("max(ID)"));
					Max = Max+1;
					lblNewLabel_2_1.setText(""+Max);
					
					Date dt = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
					String date = ft.format(dt);
					
					PreparedStatement ps = conn.prepareStatement("insert into Employee(ID, DOJ , E_Name , Gender , DOB , Address , Qualification , Experience , Position , Department, Salary) values(?,?,?,?,?,?,?,?,?,?,?);");
					ps.setLong(1,Max);
					ps.setString(2,date);
					ps.setString(3,tfName.getText());
					ps.setString(4,tfGender.getText());
					ps.setString(5,tfDOB.getText()); 
					ps.setString(6,tfAddress.getText());
					ps.setString(7,tfQualification.getText());
					ps.setString(8,tfExperience.getText());
					ps.setString(9,tfPositon.getText());
					ps.setString(10,tfDepartment.getText());
					ps.setString(11,tfSalary.getText()); 
					
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
		btnAdd.setBounds(600, 500, 100, 30);
		AE.add(btnAdd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin();
				AE.dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGoBack.setBounds(710, 500, 100, 30);
		AE.add(btnGoBack);
	}
}
