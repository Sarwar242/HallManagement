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

import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Students extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel idl;
	private JTextField Id;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField HallId;
	private JTextField StudentId;
	private JTextField RoomNo;
	private JTextField PhoneNo;
	private JTextField Dept;
	private JTextField Sessions;
	private JTextField Religion;
	private JTextField District;
	private JLabel lblNewLabel_3;
	private JTextField searchField;
	private JTable table_1;
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
		String query="SELECT * FROM student";
		Statement st;
		ResultSet rs;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(query);
			Items items;
			while(rs.next()) {
				items=new Items(rs.getInt("Id"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("StudentId"), rs.getString("HallId"),rs.getString("RoomNo"),rs.getString("PhoneNo"),rs.getString("Dept"),rs.getString("Sessions"),rs.getString("Religion"),rs.getString("District"));
				itemList.add(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemList;
	}
	public void show_std() {
		
		ArrayList<Items> list= getItemList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row= new Object[11];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getId();
			row[1]=list.get(i).getFirstName();
			row[2]=list.get(i).getLastName();
			row[3]=list.get(i).getStudentId();
			row[4]=list.get(i).getHallId();
			row[5]=list.get(i).getRoomNo();
			row[6]=list.get(i).getPhoneNo();
			row[7]=list.get(i).getDept();
			row[8]=list.get(i).getSessions();
			row[9]=list.get(i).getReligion();
			row[10]=list.get(i).getDistrict();
			
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
				show_std();
				JOptionPane.showMessageDialog(null, "Data "+message+"Successfully");
			
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
					Students frame = new Students();
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
	public Students() {
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
				String query="UPDATE `student` SET `FirstName`='"+FirstName.getText()+"',`LastName`='"+LastName.getText()+"',`StudentId`='"+StudentId.getText()+"',`HallId`='"+HallId.getText()+"', `RoomNo`='"+RoomNo.getText()+"',`PhoneNo`='"+PhoneNo.getText()+"',`Dept`='"+Dept.getText()+"',`Sessions`='"+Sessions.getText()+"',`Religion`='"+Religion.getText()+"',`District`='"+District.getText()+"' WHERE id='"+Id.getText()+"'";
				executeSQLQuery(query, "Updated");
			}
		});
		btnNewButton_1.setBackground(new Color(184, 134, 11));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\edit.png"));
		btnNewButton_1.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\edit.png"));
		btnNewButton_1.setBounds(139, 460, 119, 46);
		contentPane.add(btnNewButton_1);
		
		idl = new JLabel("Id : ");
		idl.setVerticalAlignment(SwingConstants.TOP);
		idl.setFont(new Font("Tahoma", Font.BOLD, 14));
		idl.setHorizontalTextPosition(SwingConstants.CENTER);
		idl.setHorizontalAlignment(SwingConstants.LEFT);
		idl.setBounds(28, 46, 38, 27);
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
				StudentId.setText(model.getValueAt(i,3).toString());
				HallId.setText(model.getValueAt(i,4).toString());
				RoomNo.setText(model.getValueAt(i,5).toString());
				PhoneNo.setText(model.getValueAt(i,6).toString());
				Dept.setText(model.getValueAt(i,7).toString());
				Sessions.setText(model.getValueAt(i,8).toString());
				Religion.setText(model.getValueAt(i,9).toString());
				District.setText(model.getValueAt(i,10).toString());
				
				
			}
		});
		
		table.setDragEnabled(true);
		table.setGridColor(new Color(128, 0, 128));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setForeground(new Color(0, 100, 0));
		table.setModel(new DefaultTableModel(
			new Object[][]{},
			new String[] {
				"Id", "FirstName", "LastName", "StudentId", "HallId", "RoomNo", "PhoneNo", "Dept", "Sessions", "Religion", "District"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(46);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.getColumnModel().getColumn(6).setPreferredWidth(97);
		table.getColumnModel().getColumn(6).setMinWidth(39);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(255, 245, 238));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//searchRow
		final TableRowSorter<TableModel> rowSorter= new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		show_std();
		Id = new JTextField();
		Id.setToolTipText("Automatically Generated");
		Id.setBounds(100, 46, 233, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
		JLabel lblName = new JLabel("FirstName");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 75, 80, 27);
		contentPane.add(lblName);
		
		FirstName = new JTextField();
		FirstName.setBounds(100, 80, 233, 20);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("LastName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 103, 80, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("StudentId:");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 158, 80, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HallId:");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 196, 80, 27);
		contentPane.add(lblNewLabel_2);
		
		LastName = new JTextField();
		LastName.setBounds(100, 111, 233, 20);
		contentPane.add(LastName);
		LastName.setColumns(10);
		
	StudentId= new JTextField();
	StudentId.setBounds(100, 166, 233, 20);
		contentPane.add(StudentId);
		StudentId.setColumns(10);
		
		HallId = new JTextField();
		HallId.setText("\r\n");
		HallId.setBounds(100, 201, 233, 20);
		contentPane.add(HallId);
		HallId.setColumns(10);
		
		RoomNo= new JTextField();
		RoomNo.setBounds(100, 235, 233, 20);
		contentPane.add(RoomNo);
		RoomNo.setColumns(10);
		
		PhoneNo= new JTextField();
		PhoneNo.setBounds(100, 270, 233, 20);
		contentPane.add(PhoneNo);
		PhoneNo.setColumns(10);
		
		Dept= new JTextField();
		Dept.setBounds(100, 305, 233, 20);
		contentPane.add(Dept);
		Dept.setColumns(10);
		
		Sessions = new JTextField();
		Sessions.setBounds(100, 340, 233, 20);
		contentPane.add(Sessions);
		Sessions.setColumns(10);
		
		Religion = new JTextField();
		Religion.setBounds(100, 375, 233, 20);
		contentPane.add(Religion);
		Religion.setColumns(10);
		
		District= new JTextField();
		District.setBounds(100, 410, 233, 20);
		contentPane.add(District);
		District.setColumns(10);
		
		//JLabel lblperUnit = new JLabel("(per unit)");
		//lblperUnit.setBounds(17, 133, 46, 14);
		//contentPane.add(lblperUnit);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query="INSERT INTO student(FirstName,LastName,StudentId,HallId,RoomNo,PhoneNo,Dept,Sessions,Religion,District) VALUES('"+FirstName.getText()+"','"+LastName.getText()+"','"+StudentId.getText()+"','"+HallId.getText()+"','"+RoomNo.getText()+"','"+PhoneNo.getText()+"','"+Dept.getText()+"','"+Sessions.getText()+"','"+Religion.getText()+"','"+District.getText()+"')";
				executeSQLQuery(query, "Inserted");
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\plus.png"));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\plus.png"));
		btnNewButton.setBounds(21, 460, 119, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="DELETE FROM `student` WHERE Id='"+Id.getText()+"'";
				executeSQLQuery(query, "Deleted");
				Id.setText("");
				FirstName.setText("");
				LastName.setText("");
				StudentId.setText("");
				HallId.setText("");
				RoomNo.setText("");
				PhoneNo.setText("");
				Dept.setText("");
				Sessions.setText("");
				Religion.setText("");
				District.setText("");
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\bt_remove.png"));
		btnNewButton_2.setSelectedIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\bt_remove.png"));
		btnNewButton_2.setBounds(253,460, 131, 46);
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
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Uniersity's all document\\Class\\3rd semester\\Mostafijur Sir\\New folder\\shop\\Icons\\D:\\java\\SuperShop2\\Icons\\1503_fruit_main.jpg"));
		lblNewLabel_3.setBounds(720, -144, 1011, 660);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblDept = new JLabel("RoomNo:");
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDept.setBounds(10, 238, 80, 14);
		contentPane.add(lblDept);
		
		JLabel lblNewLabel_4 = new JLabel("\r\nPhoneNo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 273, 80, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dept:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 308, 80, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sessions:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 343, 80, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Religion:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 378, 80, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("District:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 413, 80, 14);
		contentPane.add(lblNewLabel_8);
		
		
		
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
				StudentId.setText("");
				HallId.setText("");
				RoomNo.setText("");
				PhoneNo.setText("");
				Dept.setText("");
				Sessions.setText("");
				Religion.setText("");
				District.setText("");
				searchField.setText("");
				show_std();
				
			}
		});
		btnRefresh.setBounds(127, 536, 89, 23);
		contentPane.add(btnRefresh);
		
		
	}
}
