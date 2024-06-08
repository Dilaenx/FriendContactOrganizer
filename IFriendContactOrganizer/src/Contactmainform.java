import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Contactmainform extends JFrame{
	AddContactForm addContactForm;
	ViewCustomerForm ViewCustomerForm;
	UpdateContactForm updateContactForm;
	SearchContactForm searchContactForm;
	

	JButton btnAddContact;
	JButton btnSearchContact;
	JButton btnDeleteContact;
	JButton btnUpdateContact;
	JButton btnViewContact;
	JButton btnExit;
	
	Contactmainform(){
		setTitle("Customer mgt System");
		setSize(500,300);
		setDefaultCloseOperation(0);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new GridLayout(6,1));
		
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,25));
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					if(addContactForm==null){
						addContactForm=new AddContactForm();
					}
					addContactForm.setVisible(true);
					
				}
			});

			btnAddContact.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					Contactmainform.this.dispose();
				}
			});
			
		buttonPanel.add(btnAddContact);
		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,25));
		///////////////////////////////////
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					if(updateContactForm==null){
						updateContactForm=new UpdateContactForm();
					}
					updateContactForm.setVisible(true);
					
				}
			});

			btnUpdateContact.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					Contactmainform.this.dispose();
				}
			});
		buttonPanel.add(btnUpdateContact);
		
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,25));

		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					if(searchContactForm==null){
						searchContactForm=new SearchContactForm();
					}
					searchContactForm.setVisible(true);
					
				}
			});

			btnSearchContact.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					Contactmainform.this.dispose();
				}
			});

		buttonPanel.add(btnSearchContact);
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,25));
		buttonPanel.add(btnDeleteContact);
		
		btnViewContact=new JButton("View Contact");
		btnViewContact.setFont(new Font("",1,25));

		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					if(ViewCustomerForm==null){
						ViewCustomerForm=new ViewCustomerForm();
					}
					ViewCustomerForm.setVisible(true);
					
				}
			});

			btnViewContact.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					Contactmainform.this.dispose();
				}
			});

		buttonPanel.add(btnViewContact);


		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,25));

		btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					Contactmainform.this.dispose();
				}
			});

		buttonPanel.add(btnExit);
		
		
		add("Center",buttonPanel);
	}
	
	public static void main(String args[]){
		new Contactmainform().setVisible(true);
	}
}
