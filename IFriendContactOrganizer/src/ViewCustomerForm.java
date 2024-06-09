import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class ViewCustomerForm extends JFrame{
	private JTable tblCustomerDetails;
	private DefaultTableModel dtm;
	
	private JLabel titleLabel;
	
	private JButton btnSortName; 
	private JButton btnSortSalary;
	private JButton btnSortBirthday;
	private JButton btnMainMenu; 
	ViewCustomerForm(){
		setSize(500,300);
		setTitle("View Customer Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		titleLabel=new JLabel("View Customer Form");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);
		
		String[] columnsName={"Customer Id","Name","PhoneNumber","CompanyName","Salary","Birthday"};
		dtm=new DefaultTableModel(columnsName,0);
		
		tblCustomerDetails=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
		JPanel southButton = new JPanel(new GridLayout(2,1));
		JPanel deleteButton = new JPanel();
		
		add("Center",tablePane);
	
		JPanel buttonPanel=new JPanel(); //Default layout ->JPanel --FlowLAyout
		btnSortName=new JButton("Sort By Name");
		btnSortName.setFont(new Font("",1,10));
		
		
        btnSortName.addActionListener(new ActionListener(){
			
            public void actionPerformed(ActionEvent evt){
				ContactController.sortByName();
				// ContactDBConnection custDBC=ContactDBConnection.getInstance();
				// ArrayList<Contact> custList=custDBC.getContatList();
				ArrayList<Contact> custList=ContactDBConnection.getInstance().getContactList();
				dtm.setRowCount(0);
				
					for(int i =0;i<custList.size();i++){
						Contact Contact = custList.get(i);
						Object[] rowDat ={Contact.id(),Contact.Name(),Contact.PhoneNumber(),Contact.CompanyName(),Contact.Salary(),Contact.Birthday()};
						dtm.addRow(rowDat);
						

					}
				
                }           
        });
		///////////////////
		btnSortSalary=new JButton("Sort By Salary");
		btnSortSalary.setFont(new Font("",1,10));
		
        btnSortSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
				ContactController.sortBySalary();
				// ContactDBConnection custDBC=ContactDBConnection.getInstance();
				// ArrayList<Contact> custList=custDBC.getContatList();
				ArrayList<Contact> custList=ContactDBConnection.getInstance().getContactList();
				dtm.setRowCount(0);
				
					for(int i =0;i<custList.size();i++){
						Contact Contact = custList.get(i);
						Object[] rowDat ={Contact.id(),Contact.Name(),Contact.PhoneNumber(),Contact.CompanyName(),Contact.Salary(),Contact.Birthday()};
						dtm.addRow(rowDat);
						
					}
				
                }           
        });
		//////////////////
		btnSortBirthday=new JButton("Sort By Birthday");
		btnSortBirthday.setFont(new Font("",1,10));
		
        btnSortBirthday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
				ContactController.sortByBirthday();
				// ContactDBConnection custDBC=ContactDBConnection.getInstance();
				// ArrayList<Contact> custList=custDBC.getContatList();
				ArrayList<Contact> custList=ContactDBConnection.getInstance().getContactList();
				dtm.setRowCount(0);
				
				
					for(int i =0;i<custList.size();i++){
						Contact Contact = custList.get(i);
						Object[] rowDat ={Contact.id(),Contact.Name(),Contact.PhoneNumber(),Contact.CompanyName(),Contact.Salary(),Contact.Birthday()};
						dtm.addRow(rowDat);
						//rowDat[i] = null;
					}
					
				
                }           
        });
		/////////////////////////////////////////


		buttonPanel.add(btnSortName);
		buttonPanel.add(btnSortSalary);
		buttonPanel.add(btnSortBirthday);

		btnMainMenu=new JButton("Main Menu");
		btnMainMenu.setFont(new Font("",1,20));
		btnMainMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewCustomerForm.this.dispose();
				new Contactmainform().setVisible(true);
			}
		});
		southButton.add(buttonPanel);
		deleteButton.add(btnMainMenu);
		southButton.add(deleteButton);	
			
		add("South",southButton);
		
	}
	public static void main(String args[]){
		new ViewCustomerForm().setVisible(true);
	}
}
