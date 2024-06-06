import javax.swing.*;
import java.awt.*;
class Contactmainform extends JFrame{
	JButton btnAddContact;
	JButton btnSearchContact;
	JButton btnDeleteContact;
	JButton btnUpdateContact;
	JButton btnViewContact;
	JButton btnExit;
	
	Contactmainform(){
		setTitle("Customer mgt System");
		setSize(500,300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new GridLayout(5,1));
		
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,25));
		buttonPanel.add(btnAddContact);
		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,25));
		buttonPanel.add(btnUpdateContact);
		
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,25));
		buttonPanel.add(btnSearchContact);
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,25));
		buttonPanel.add(btnDeleteContact);
		
		btnViewContact=new JButton("View Contact");
		btnViewContact.setFont(new Font("",1,25));
		buttonPanel.add(btnViewContact);
		
		
		add("Center",buttonPanel);
	}
	
	public static void main(String args[]){
		new Contactmainform().setVisible(true);
	}
}
