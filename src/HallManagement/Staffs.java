package HallManagement;





import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import java.awt.Component;

import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Dialog.ModalExclusionType;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Staffs extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel idl;
	private JTextField Id;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Post;
	private JTextField Contact;
	private JLabel lblNewLabel_3;
	private JTextField searchField;
	private JScrollPane scrollPane;

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hallmgdb?autoReconnect=true&useSSL=false", "root", "");
			return con;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	public ArrayList<Items>getItemList(){
		ArrayList<Items>itemList=new ArrayList<Items>();
		Connection  connection=getConnection();
		String query="SELECT * FROM staffs";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("Id"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Post"), rs.getString("Contact"));
				itemList.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	
	public void show_staffs() {
	
		ArrayList<Items> list= getItemList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row= new Object[5];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getFirstName();
			row[2]=list.get(i).getLastName();
			row[3]=list.get(i).getPost();
			row[4]=list.get(i).getContact();
			
			model.addRow(row);
		}
		
	}
	
	public void executeSQLQuery(String query, String message) {
		Connection con= getConnection();
		Statement st;
		try {
			st=con.createStatement();
			if(st.executeUpdate(query)==1) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				
				show_staffs();
				JOptionPane.showMessageDialog(null, "Data "+message+"Successfully");
				model.setRowCount(0);
			}else {
				JOptionPane.showMessageDialog(null, "Data Not "+message);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staffs frame = new Staffs();
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
	@SuppressWarnings("serial")
	public Staffs() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setMinimumSize(new Dimension(1250, 710));
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setForeground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="UPDATE `staffs` SET `FirstName`='"+FirstName.getText()+"',`LastName`='"+LastName.getText()+"',`Post`='"+Post.getText()+"',`Contact`='"+Contact.getText()+"' WHERE Id='"+Id.getText()+"'";
				executeSQLQuery(query, "Updated");
			}
		});
		
		JLabel lblperUnit = new JLabel("(per unit)");
		lblperUnit.setBounds(10, 122, 46, 14);
		contentPane.add(lblperUnit);
		btnNewButton_1.setBackground(new Color(184, 134, 11));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\edit.png"));
		btnNewButton_1.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\edit.png"));
		btnNewButton_1.setBounds(139, 255, 119, 46);
		contentPane.add(btnNewButton_1);
		
		idl = new JLabel("Id : ");
		idl.setVerticalAlignment(SwingConstants.TOP);
		idl.setFont(new Font("Tahoma", Font.BOLD, 14));
		idl.setHorizontalTextPosition(SwingConstants.CENTER);
		idl.setHorizontalAlignment(SwingConstants.LEFT);
		idl.setBounds(10, 32, 38, 27);
		contentPane.add(idl);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(406, 67, 828, 537);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				Id.setText(model.getValueAt(i,0).toString());
				FirstName.setText(model.getValueAt(i,1).toString());
				LastName.setText(model.getValueAt(i,2).toString());
				Post.setText(model.getValueAt(i,3).toString());
				Contact.setText(model.getValueAt(i,4).toString());
				
			}
		});
		table.setDragEnabled(true);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setForeground(new Color(0, 100, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"Id", "FirstName", "LastName", "Post", "Contact"
			}
		));
		table.setCellSelectionEnabled(true);
		table.setBackground(SystemColor.controlHighlight);
		final TableRowSorter<TableModel> rowSorter= new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		show_staffs();
		Id = new JTextField();
		Id.setToolTipText("Automatically Generated");
		Id.setBounds(114, 32, 233, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 65, 53, 27);
		contentPane.add(lblName);
		
		FirstName = new JTextField();
		FirstName.setBounds(114, 63, 233, 20);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 95, 53, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unit : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 144, 46, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 182, 58, 27);
		contentPane.add(lblNewLabel_2);
		
		LastName = new JTextField();
		LastName.setBounds(114, 100, 233, 20);
		contentPane.add(LastName);
		LastName.setColumns(10);
		
		Post = new JTextField();
		Post.setBounds(114, 149, 233, 20);
		contentPane.add(Post);
		Post.setColumns(10);
		
		Contact = new JTextField();
		Contact.setBounds(114, 187, 233, 20);
		contentPane.add(Contact);
		Contact.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query="INSERT INTO staffs(FirstName,LastName,Post,Contact) VALUES('"+FirstName.getText()+"','"+LastName.getText()+"','"+Post.getText()+"','"+Contact.getText()+"')";
				executeSQLQuery(query, "Inserted");
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\plus.png"));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\plus.png"));
		btnNewButton.setBounds(21, 255, 119, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="DELETE FROM `staffs` WHERE Id='"+Id.getText()+"'";
				executeSQLQuery(query, "Deleted");
				Id.setText("");
				FirstName.setText("");
				LastName.setText("");
				Post.setText("");
				Contact.setText("");
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\bt_remove.png"));
		btnNewButton_2.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\bt_remove.png"));
		btnNewButton_2.setBounds(253, 255, 131, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Catagory2 catagory2=new Catagory2();
				//Catagory2.main(null);
				
				Requirements m= new Requirements();
				Requirements.main(null);
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(67, 588, 89, 31);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main();
				Main.main(null);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(184, 588, 89, 31);
		contentPane.add(btnNewButton_4);
		
		lblNewLabel_3 = new JLabel("");
		
		lblNewLabel_3.setBounds(-26, -78, 1134, 768);
		contentPane.add(lblNewLabel_3);
		
		
		//Search
		
		
		JLabel lblSearchanyValue = new JLabel("Search(Any Value) : ");
		lblSearchanyValue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchanyValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchanyValue.setBounds(406, 11, 152, 27);
		contentPane.add(lblSearchanyValue);
				
		searchField = new JTextField() {
			  
			private static final long serialVersionUID = 1755505973412085487L;
			@Override protected void paintComponent(Graphics g) {
			    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
			      Graphics2D g2 = (Graphics2D) g.create();
			      g2.setPaint(getBackground());
			      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
			          0, 0, getWidth() - 1, getHeight() - 1));
			      g2.dispose();
			    }
			    super.paintComponent(g);
			  }
			  @Override public void updateUI() {
			    super.updateUI();
			    setOpaque(false);
			    setBorder(new RoundedCornerBorder());
			  }
			};	
				
				searchField.getDocument().addDocumentListener(new DocumentListener() {
					
					
					
					@Override
					public void removeUpdate(DocumentEvent arg0) {
						String text=searchField.getText();
						if(text.trim().length()==0){
							rowSorter.setRowFilter(null);
						}
						else {
							rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
						}
						
					}
					
					@Override
					public void insertUpdate(DocumentEvent arg0) {
						String text=searchField.getText();
						if(text.trim().length()==0){
							rowSorter.setRowFilter(null);
						}
						else {
							rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
						}
						
						
					}
					
					@Override
					public void changedUpdate(DocumentEvent arg0) {
						throw new UnsupportedOperationException("Not Supported Yet");
						
					}

					
				});
			
				searchField.setFont(new Font("Tahoma", Font.PLAIN, 13));
				searchField.setBounds(571, 12, 297, 27);
				contentPane.add(searchField);
				searchField.setColumns(10);
				
				JButton btnRefresh = new JButton("Refresh");
				btnRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Id.setText("");
						FirstName.setText("");
						LastName.setText("");
						Post.setText("");
						Contact.setText("");
						
						searchField.setText("");
						show_staffs();
						
					}
				});
				btnRefresh.setBounds(127, 536, 89, 23);
				contentPane.add(btnRefresh);
	}
}


