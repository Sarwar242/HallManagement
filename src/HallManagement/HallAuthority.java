package HallManagement;





import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class HallAuthority extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private JLabel idl;
	private JTextField Id;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField HallPost;
	private JTextField TeachersInfo;
	private JTextField Dept;
	private JTextField PhoneNo;
	private JTextField Mail;
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
	public ArrayList<Items>getItemList() throws ClassNotFoundException{
		ArrayList<Items>itemList=new ArrayList<Items>();
		Connection  connection=getConnection();
		String query="SELECT * FROM hallauthority";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("Id"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("HallPost"),rs.getString("TeachersInfo"),rs.getString("Dept"),rs.getString("PhoneNo"),rs.getString("Mail"));
				itemList.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	
	public void show_Authority() throws ClassNotFoundException {
		ArrayList<Items> list= getItemList();
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row= new Object[8];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getFirstName();
			row[2]=list.get(i).getLastName();
			row[3]=list.get(i).getHallPost();
			row[4]=list.get(i).getTeachersInfo();
			row[5]=list.get(i).getDept();
			row[6]=list.get(i).getPhoneNo();
			row[7]=list.get(i).getMail();
			
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
				
				show_Authority();
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
					HallAuthority frame = new HallAuthority();
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
	 * @throws ClassNotFoundException 
	 */
	public HallAuthority() throws ClassNotFoundException {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setMinimumSize(new Dimension(1400, 710));
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
				String query="UPDATE `hallauthority` SET `FirstName`='"+FirstName.getText()+"',`LastName`='"+LastName.getText()+"',`HallPost`='"+HallPost.getText()+"',`TeachersInfo`='"+TeachersInfo.getText()+"',`Dept`='"+Dept.getText()+"',`PhoneNo`='"+PhoneNo.getText()+"',`Mail`='"+Mail.getText()+"' WHERE Id='"+Id.getText()+"'";
				executeSQLQuery(query, "Updated");
			}
		});
		btnNewButton_1.setBackground(new Color(184, 134, 11));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\edit.png"));
		btnNewButton_1.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\edit.png"));
		btnNewButton_1.setBounds(120, 448, 119, 46);
		contentPane.add(btnNewButton_1);
		
		idl = new JLabel("Id : ");
		idl.setForeground(Color.ORANGE);
		idl.setVerticalAlignment(SwingConstants.TOP);
		idl.setFont(new Font("Tahoma", Font.BOLD, 20));
		idl.setHorizontalTextPosition(SwingConstants.CENTER);
		idl.setHorizontalAlignment(SwingConstants.LEFT);
		idl.setBounds(10, 64, 49, 27);
		contentPane.add(idl);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(406, 67, 968, 537);
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
				HallPost.setText(model.getValueAt(i,3).toString());
				TeachersInfo.setText(model.getValueAt(i,4).toString());
				Dept.setText(model.getValueAt(i,5).toString());
				PhoneNo.setText(model.getValueAt(i,6).toString());
				Mail.setText(model.getValueAt(i,7).toString());
				
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
					"Id", "FirstName", "LastName", "HallPost", "TeachersInfo", "Dept", "PhoneNo", "Mail"
				}
			));
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		table.getColumnModel().getColumn(4).setPreferredWidth(92);
		table.getColumnModel().getColumn(7).setPreferredWidth(97);
		table.setCellSelectionEnabled(true);
		table.setBackground(SystemColor.controlHighlight);
		final TableRowSorter<TableModel> rowSorter= new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		show_Authority();
		Id = new JTextField();
		Id.setToolTipText("Automatically Generated");
		Id.setBounds(118, 67, 233, 26);
		contentPane.add(Id);
		Id.setColumns(10);
		
		JLabel lblName = new JLabel("F Name : ");
		lblName.setForeground(Color.ORANGE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(10, 102, 88, 27);
		contentPane.add(lblName);
		
		FirstName = new JTextField();
		FirstName.setBounds(118, 102, 233, 27);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("L Name: ");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 140, 88, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T_Info");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 225, 88, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dept:  ");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 267, 88, 27);
		contentPane.add(lblNewLabel_2);
		
		LastName = new JTextField();
		LastName.setBounds(118, 140, 233, 27);
		contentPane.add(LastName);
		LastName.setColumns(10);
		
		HallPost = new JTextField();
		HallPost.setBounds(118, 187, 233, 27);
		contentPane.add(HallPost);
		HallPost.setColumns(10);
		
		TeachersInfo = new JTextField();
		TeachersInfo.setBounds(118, 230, 233, 29);
		contentPane.add(TeachersInfo);
		TeachersInfo.setColumns(10);
		
		Dept = new JTextField();
		Dept.setBounds(118, 271, 233, 27);
		contentPane.add(Dept);
		Dept.setColumns(10);
		
		PhoneNo = new JTextField();
		PhoneNo.setBounds(118, 316, 233, 27);
		contentPane.add(PhoneNo);
		PhoneNo.setColumns(10);
		
		Mail = new JTextField();
		Mail.setBounds(118, 368, 233, 28);
		contentPane.add(Mail);
		Mail.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query="INSERT INTO hallauthority(FirstName,LastName,HallPost,TeachersInfo,Dept,PhoneNo,Mail) VALUES('"+FirstName.getText()+"','"+LastName.getText()+"','"+HallPost.getText()+"','"+TeachersInfo.getText()+"','"+Dept.getText()+"','"+PhoneNo.getText()+"','"+Mail.getText()+"')";
				executeSQLQuery(query, "Inserted");
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\plus.png"));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\plus.png"));
		btnNewButton.setBounds(0, 448, 119, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="DELETE FROM `hallauthority` WHERE Id='"+Id.getText()+"'";
				executeSQLQuery(query, "Deleted");
				Id.setText("");
				FirstName.setText("");
				LastName.setText("");
				HallPost.setText("");
				TeachersInfo.setText("");
				Dept.setText("");
				PhoneNo.setText("");
				Mail.setText("");
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\bt_remove.png"));
		btnNewButton_2.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\bt_remove.png"));
		btnNewButton_2.setBounds(238, 448, 131, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Requirements catagory=new Requirements();
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
				Main shop=new Main();
				Main.main(null);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(184, 588, 89, 31);
		contentPane.add(btnNewButton_4);
		
		lblNewLabel_3 = new JLabel("New label");
		
		lblNewLabel_3.setBounds(908, 12, 1047, 671);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setBackground(Color.RED);
		lblMail.setBounds(0, 368, 74, 27);
		contentPane.add(lblMail);
		
		JLabel lblNewLabel_4 = new JLabel("Phone No: ");
		lblNewLabel_4.setBounds(10, 319, 74, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblHallPost = new JLabel("Hall Post: ");
		lblHallPost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHallPost.setForeground(Color.BLUE);
		lblHallPost.setBounds(10, 187, 77, 27);
		contentPane.add(lblHallPost);
		//Search
		
		
				JLabel lblSearchanyValue = new JLabel("Search(Any Value) : ");
				lblSearchanyValue.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSearchanyValue.setHorizontalAlignment(SwingConstants.CENTER);
				lblSearchanyValue.setBounds(406, 11, 152, 27);
				contentPane.add(lblSearchanyValue);
						
						
						searchField = new JTextField();
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
								HallPost.setText("");
								TeachersInfo.setText("");
								Dept.setText("");
								PhoneNo.setText("");
								Mail.setText("");
								
								searchField.setText("");
								
								try {
									show_Authority();
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						});
						btnRefresh.setBounds(127, 536, 89, 23);
						contentPane.add(btnRefresh);
	}
}

