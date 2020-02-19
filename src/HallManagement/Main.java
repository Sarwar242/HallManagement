package HallManagement;





import javax.swing.*;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4752374753932744185L;

	public Main() {
		
		setMinimumSize(new Dimension(800, 600));
		getContentPane().setBackground(new Color(102, 255, 51));
		setBackground(new Color(220, 20, 60));
	
		getContentPane().setLayout(null);
			
			JButton btnSell = new JButton("Continue");
			btnSell.setSelectedIcon(null);
			btnSell.setSelected(isVisible());
			
			btnSell.setBounds(317, 186, 118, 30);
			btnSell.addActionListener(new ActionListener() {
				private Requirements Requirements;

				public void actionPerformed(ActionEvent arg0) {
					setRequirements(new Requirements());
					Requirements.main(null);
					setVisible(false);
				}

				public Requirements getRequirements() {
					return Requirements;
				}

				public void setRequirements(Requirements Requirements) {
					this.Requirements = Requirements;
				}
			});
			btnSell.setBackground(Color.ORANGE);
			btnSell.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			getContentPane().add(btnSell);
		
			
		
		
		JLabel l1 = new JLabel("Welcome to Hall Management System!");
		l1.setBounds(85, 30, 602, 65);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Tahoma", Font.BOLD, 30));
		l1.setForeground(Color.RED);
		l1.setBackground(new Color(0, 0, 255));
		getContentPane().add(l1);
		
		JTextField txtSupershop = new JTextField();
		txtSupershop.setBounds(0, 511, 794, 50);
		txtSupershop.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtSupershop.setBackground(Color.LIGHT_GRAY);
		txtSupershop.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupershop.setText("@HallMgSystem");
		getContentPane().add(txtSupershop);
		txtSupershop.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(0, 0, 784, 549);
		getContentPane().add(lblNewLabel);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.requestFocus();
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 
	}
}