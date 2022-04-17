import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ELogin {

	JFrame EL = new JFrame();
	private JTextField PIN;
	
	public ELogin() {
		EL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EL.setBounds(100, 100, 500, 400);
		EL.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Human Resources Management");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 11, 464, 50);
		EL.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Security PIN :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(162, 156, 150, 25);
		EL.add(lblNewLabel_2);
		
		PIN = new JTextField();
		PIN.setColumns(10);
		PIN.setBounds(137, 192, 200, 25);
		EL.add(PIN);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnProceed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProceed.setBounds(147, 228, 180, 30);
		EL.add(btnProceed);
	}

}
