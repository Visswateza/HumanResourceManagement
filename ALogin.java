import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ALogin {

	JFrame AL = new JFrame();
	private JTextField PIN;

	public ALogin() {
		AL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AL.setBounds(100, 100, 500, 400);
		AL.setLayout(null);
		AL.setVisible(true);
	
		JLabel lblNewLabel_1 = new JLabel("Human Resources Management");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 11, 464, 50);
		AL.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Security PIN :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(162, 156, 150, 25);
		AL.add(lblNewLabel_2);
		
		PIN = new JTextField();
		PIN.setColumns(10);
		PIN.setBounds(137, 192, 200, 25);
		AL.add(PIN);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PIN.getText().equals("1234")) {
					new Admin();
					AL.dispose();
				}
			}
		});
		btnProceed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProceed.setBounds(147, 228, 180, 30);
		AL.add(btnProceed);
		
	}

}
