package HallManagement;



	
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JTextField;
	import javax.swing.SwingConstants;
	import java.awt.Color;
	import javax.swing.JLabel;
	import java.awt.Font;
	import java.awt.FlowLayout;
	import java.awt.BorderLayout;
	import java.awt.CardLayout;
	import javax.swing.ImageIcon;


	public class Requirements extends JFrame {

		private JPanel contentPane;
		private JTextField txtSupershop;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Requirements frame = new Requirements();
						frame.setVisible(true);
						frame.requestFocus();
						frame.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public Requirements() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 850, 600);
			contentPane = new JPanel();
			contentPane.setBackground(Color.PINK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblSell = new JLabel("Hall Management");
			lblSell.setForeground(new Color(255, 255, 0));
			lblSell.setHorizontalAlignment(SwingConstants.CENTER);
			lblSell.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
			lblSell.setBounds(322, 11, 300, 42);
			contentPane.add(lblSell);
			
			JLabel lblItemCatagories = new JLabel("Requirements");
			lblItemCatagories.setForeground(new Color(0, 100, 0));
			lblItemCatagories.setBounds(87, 64, 633, 36);
			lblItemCatagories.setBackground(new Color(245, 245, 220));
			lblItemCatagories.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblItemCatagories.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblItemCatagories);
			
			JButton btnFruits = new JButton("Students");
			btnFruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Students fruits= new Students();
					Students.main(null);
					setVisible(false);
				}
			});
			btnFruits.setForeground(new Color(139, 0, 0));
			btnFruits.setBackground(new Color(47, 79, 79));
			btnFruits.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnFruits.setBounds(309, 186, 185, 43);
			contentPane.add(btnFruits);
			
			JButton btnCosmatics = new JButton("Staffs");
			btnCosmatics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Staffs cosmatics= new Staffs();
					Staffs.main(null);
					setVisible(false);
				}
			});
			btnCosmatics.setBackground(new Color(205, 133, 63));
			btnCosmatics.setForeground(new Color(139, 0, 0));
			btnCosmatics.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCosmatics.setBounds(309, 254, 185, 43);
			contentPane.add(btnCosmatics);
			
			JButton btnDailyComo = new JButton("HallAuthority");
			btnDailyComo.setForeground(new Color(139, 0, 0));
			btnDailyComo.setBackground(new Color(176, 196, 222));
			btnDailyComo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnDailyComo.setBounds(309, 122, 185, 43);
			btnDailyComo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//HallAuthority hallAuthority= new HallAuthority();
					HallAuthority.main(null);
					setVisible(false);
				}
			});
			contentPane.add(btnDailyComo);
			
			txtSupershop = new JTextField();
			txtSupershop.setBounds(0, 518, 856, 53);
			txtSupershop.setFont(new Font("Tahoma", Font.ITALIC, 14));
			txtSupershop.setBackground(Color.LIGHT_GRAY);
			txtSupershop.setHorizontalAlignment(SwingConstants.CENTER);
			txtSupershop.setText("@@HallMgSystem ");
			contentPane.add(txtSupershop);
			txtSupershop.setColumns(10);
			
			JButton btnHome = new JButton("Home");
			btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnHome.setForeground(new Color(50, 205, 50));
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main shop=new Main();
					Main.main(null);
					setVisible(false);
				}
			});
			btnHome.setBackground(Color.ORANGE);
			btnHome.setBounds(346, 403, 107, 36);
			contentPane.add(btnHome);
			
			JLabel lblNewLabel = new JLabel("");
			
			lblNewLabel.setBounds(0, 0, 856, 571);
			contentPane.add(lblNewLabel);
			
		}
	}

