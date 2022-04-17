import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

	JFrame Wel = new JFrame();
	private JButton btnAdminLogin;
	private JButton btnEmployeeLogin;
	private JButton btnQuit;

	public Welcome() {
		Wel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Wel.setBounds(100, 100, 500, 400);
		Wel.setLayout(null);
		Wel.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Human Resources Management");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 11, 464, 50);
		Wel.add(lblNewLabel_1);
		
		btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ALogin AL = new ALogin();
				Wel.dispose();
			}
		});
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminLogin.setBounds(153, 144, 180, 30);
		Wel.add(btnAdminLogin);
		
		btnEmployeeLogin = new JButton("Employee Portal");
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ELogin El = new ELogin();
				Wel.dispose();
			}
		});
		btnEmployeeLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEmployeeLogin.setBounds(153, 193, 180, 30);
		Wel.add(btnEmployeeLogin);
		
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wel.dispose();
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnQuit.setBounds(153, 241, 180, 30);
		Wel.add(btnQuit);
		
	}
	
	public static void main(String[] args) {
		Welcome Main = new Welcome();
	}

}
