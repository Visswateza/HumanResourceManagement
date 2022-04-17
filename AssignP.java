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

public class AssignP{
	
	JFrame AsP = new JFrame();
	private JPanel contentPane;
	private JTextField tfEID;
	private JTextField tfPID;
	private JTextField tfFDate;
	private JTextField tfUDate;
	private JTable Proj_table;
	private JTable Emp_Table;

	public AssignP() {
		AsP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AsP.setBounds(100, 100, 1000, 600);
		AsP.setLayout(null);
		AsP.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Human Resources Management");
		lblNewLabel.setBounds(0, 11, 1000, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		AsP.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Assignment");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(79, 72, 150, 40);
		AsP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Assignment ID : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(147, 123, 150, 25);
		AsP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(307, 123, 150, 25);
		AsP.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Employee ID :");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(147, 159, 150, 25);
		AsP.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Project ID : ");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(147, 195, 150, 25);
		AsP.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("From :");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(550, 159, 150, 25);
		AsP.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Upto : ");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2_1.setBounds(550, 195, 150, 25);
		AsP.add(lblNewLabel_2_2_2_1);
		
		tfEID = new JTextField();
		tfEID.setColumns(10);
		tfEID.setBounds(307, 159, 200, 25);
		AsP.add(tfEID);
		
		tfPID = new JTextField();
		tfPID.setColumns(10);
		tfPID.setBounds(307, 195, 200, 25);
		AsP.add(tfPID);
		
		tfFDate = new JTextField();
		tfFDate.setColumns(10);
		tfFDate.setBounds(710, 161, 200, 25);
		AsP.add(tfFDate);
		
		tfUDate = new JTextField();
		tfUDate.setColumns(10);
		tfUDate.setBounds(710, 197, 200, 25);
		AsP.add(tfUDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 318, 800, 87);
		AsP.add(scrollPane);
		
		Proj_table = new JTable();
		scrollPane.setViewportView(Proj_table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(79, 457, 800, 87);
		AsP.add(scrollPane_1);
		
		Emp_Table = new JTable();
		scrollPane_1.setViewportView(Emp_Table);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HResource","root","root");
			
			String str = "select * from Project;"; 
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			Proj_table.setModel(DbUtils.resultSetToTableModel(rs));
			ps.close();
			str = "select * from Employee;"; 
			PreparedStatement ps1 = conn.prepareStatement(str);
			ResultSet rs2 = ps1.executeQuery();
			Emp_Table.setModel(DbUtils.resultSetToTableModel(rs2));
			ps1.close();
			
			PreparedStatement stmt = conn.prepareStatement("select max(Assignment_ID) from Assignments;");
			ResultSet rs1 = stmt.executeQuery();
			rs1.next();						
			int Max = Integer.parseInt(rs1.getString("max(Assignment_ID)"));
			Max = Max+1;
			lblNewLabel_2_1.setText(""+Max);
			
			Date dt = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			String date = ft.format(dt);
			tfFDate.setText(date);
			tfUDate.setText(date);
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
					
					PreparedStatement ps = conn.prepareStatement("insert into Assignments(Assignment_ID, Emp_ID, Project_ID, From_Date, Upto_Date) values(?,?,?,?,?);");
					ps.setLong(1,Max);
					ps.setString(2,tfEID.getText());
					ps.setString(3,tfPID.getText());
					ps.setString(4,tfFDate.getText()); 
					ps.setString(5,tfUDate.getText()); 
					
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
		btnAdd.setBounds(600, 250, 100, 30);
		AsP.add(btnAdd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin();
				AsP.dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGoBack.setBounds(710, 250, 100, 30);
		AsP.add(btnGoBack);
		
		JLabel lblNewLabel_1_1 = new JLabel("Project List");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(79, 284, 150, 30);
		AsP.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Employee List");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(79, 416, 150, 30);
		AsP.add(lblNewLabel_1_1_1);

	}
}
