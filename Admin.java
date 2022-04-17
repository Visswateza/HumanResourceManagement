import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin {

	JFrame Ad = new JFrame();
	
	public Admin() {
		Ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ad.setBounds(100, 100, 500, 400);
		Ad.setLayout(null);
		Ad.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Human Resources Management");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 11, 464, 50);
		Ad.add(lblNewLabel_1);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEmp();
				Ad.dispose();
			}
		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddEmployee.setBounds(150, 93, 180, 30);
		Ad.add(btnAddEmployee);
		
		JButton btnAddProject = new JButton("Add Project");
		btnAddProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddProject();
				Ad.dispose();
			}
		});
		btnAddProject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddProject.setBounds(150, 134, 180, 30);
		Ad.add(btnAddProject);
		
		JButton btnAddDependents = new JButton("Add Dependents");
		btnAddDependents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddDep();
				Ad.dispose();
			}
		});
		btnAddDependents.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDependents.setBounds(150, 175, 180, 30);
		Ad.add(btnAddDependents);
		
		JButton btnAssignProjects = new JButton("Assign Projects");
		btnAssignProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AssignP();
				Ad.dispose();
			}
		});
		btnAssignProjects.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAssignProjects.setBounds(150, 216, 180, 30);
		Ad.add(btnAssignProjects);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Welcome();
				Ad.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.setBounds(150, 257, 180, 30);
		Ad.add(btnLogOut);
		
	}

}
