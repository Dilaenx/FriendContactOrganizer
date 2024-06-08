import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class ViewCustomerForm extends JFrame{
	private JTable tblCustomerDetails;
	private DefaultTableModel dtm;
	
	private JLabel titleLabel;
	
	private JButton btnReload; 
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
		
		add("Center",tablePane);
	
		JPanel buttonPanel=new JPanel(); //Default layout ->JPanel --FlowLAyout
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		
        btnReload.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
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

		buttonPanel.add(btnReload);

		btnMainMenu=new JButton("Main Menu");
		btnMainMenu.setFont(new Font("",1,20));
		btnMainMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewCustomerForm.this.dispose();
				new Contactmainform().setVisible(true);
			}
		});
		buttonPanel.add(btnMainMenu);		
		add("South",buttonPanel);
		
	}
	public static void main(String args[]){
		new ViewCustomerForm().setVisible(true);
	}
}
