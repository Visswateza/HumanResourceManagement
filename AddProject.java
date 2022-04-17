import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddProject {

	JFrame AP = new JFrame();
	
	private JPanel contentPane;
	private JTextField tfPName;
	private JTextField tfPDes;
	private JTextField tfEDate;
	private JTextField tfSDate;
	private JTable table;

	public AddProject() {
		AP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AP.setBounds(100, 100, 1000, 600);
		AP.setLayout(null);
		AP.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Human Resources Management");
		lblNewLabel.setBounds(0, 11, 1000, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		AP.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add new project");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(75, 325, 150, 40);
		AP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Project ID : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(147, 376, 150, 25);
		AP.add(lblNewLabel_2);
		
		JLabel lbPID = new JLabel("ID");
		lbPID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbPID.setBounds(307, 376, 150, 25);
		AP.add(lbPID);
		
		JLabel lblNewLabel_2_2 = new JLabel("Name : ");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(147, 412, 150, 25);
		AP.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Description : ");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(147, 448, 150, 25);
		AP.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Start Date :");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(147, 484, 150, 25);
		AP.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("End Date :");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2_1.setBounds(567, 484, 100, 25);
		AP.add(lblNewLabel_2_2_2_1);
		
		tfPName = new JTextField();
		tfPName.setColumns(10);
		tfPName.setBounds(307, 414, 570, 25);
		AP.add(tfPName);
		
		tfPDes = new JTextField();
		tfPDes.setColumns(10);
		tfPDes.setBounds(307, 450, 570, 25);
		AP.add(tfPDes);
		
		tfEDate = new JTextField();
		tfEDate.setColumns(10);
		tfEDate.setBounds(677, 484, 200, 25);
		AP.add(tfEDate);
		
		tfSDate = new JTextField();
		tfSDate.setColumns(10);
		tfSDate.setBounds(307, 484, 200, 25);
		AP.add(tfSDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 132, 792, 182);
		AP.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		Date dt = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String date = ft.format(dt);
		tfSDate.setText(date);
		tfEDate.setText(date);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HResource","root","root");
			
			PreparedStatement stmt = conn.prepareStatement("select max(ID) from Project;");
			ResultSet rs1 = stmt.executeQuery();
			rs1.next();						
			
			String str = "select * from Project;"; 
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			int Max = Integer.parseInt(rs1.getString("max(ID)"));
			Max = Max+1;
			lbPID.setText(""+Max);
			
			conn.close();
			stmt.close();
			ps.close();
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
					
					PreparedStatement stmt = conn.prepareStatement("select max(ID) from Project;");
					ResultSet rs1 = stmt.executeQuery();
					rs1.next();						
					int Max = Integer.parseInt(rs1.getString("max(ID)"));
					Max = Max+1;
					
					PreparedStatement ps = conn.prepareStatement("insert into Project(ID, Project_Name, P_Description, Start_Date, End_Date) values(?,?,?,?,?);");
					ps.setLong(1,Max);
					ps.setString(2,tfPName.getText());
					ps.setString(3,tfPDes.getText());
					ps.setString(4,tfSDate.getText()); 
					ps.setString(5,tfEDate.getText()); 
					
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
		btnAdd.setBounds(727, 520, 150, 30);
		AP.add(btnAdd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin();
				AP.dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGoBack.setBounds(777, 90, 100, 30);
		AP.add(btnGoBack);
		
		JLabel lblNewLabel_1_1 = new JLabel("Exsisting Projects");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(75, 84, 222, 40);
		AP.add(lblNewLabel_1_1);
	}
}
