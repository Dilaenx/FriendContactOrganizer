import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class DeleteContactForm extends JFrame{
private JLabel titleLabel;
private JLabel lbSearch;

private JLabel lblID;
private JLabel lblName;
private JLabel lblPhonenumber;
private JLabel lblCompanyName;
private JLabel lblSalary;
private JLabel lblBirthday;

private JLabel lbtBackToMenu;

private JButton btnSearch;
private JButton btnBackToMenu;
private JButton btnDelete;



private JLabel lblId;

private JTextField txtSearch;

DeleteContactForm(){
    setSize(500,300);
    setTitle("Add Contact Form");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);

    titleLabel=new JLabel("Delete Contact Form");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,20));
		add("North",titleLabel);

        JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnBackToMenu = new JButton("Back To Menu");
        btnBackToMenu.setFont(new Font("",1,10));
        mainMenu.add(btnBackToMenu);
        btnBackToMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				DeleteContactForm.this.dispose();
				new Contactmainform().setVisible(true);
			}
		});

        add("South",mainMenu);

        JPanel Center = new JPanel(new GridLayout(3,1));
        JPanel SearchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel detailsPanel = new JPanel(new GridLayout(6,3));
        JPanel del = new JPanel(new FlowLayout(FlowLayout.CENTER));
        

        titleLabel=new JLabel("Enter Name or Phone Number: ");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("",1,10));

        

        txtSearch = new JTextField(10);
        txtSearch.setFont(new Font("",1,10));
        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("",1,10));
        
        Center.add(SearchPanel);
        Center.add(detailsPanel);
        SearchPanel.add(titleLabel);
        SearchPanel.add(txtSearch);
        SearchPanel.add(btnSearch);
       
        
        add("Center",Center); 
        btnDelete = new JButton("Delete");
               btnDelete.setFont(new Font("",1,10));
     
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
				int index = ContactController.searchContact(txtSearch.getText());
                if(index==-1){
                    DeleteContactForm.this.dispose();
				new SearchContactForm().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Invalid Contact", "Error", JOptionPane.ERROR_MESSAGE);
					return;
                }
                
               detailsPanel.removeAll();
               ArrayList<Contact> custList=ContactDBConnection.getInstance().getContactList();
               Contact Contact = custList.get(index);

               lblID=new JLabel("Contact Id");
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
               lblID=new JLabel(":");
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
               lblID=new JLabel(Contact.id());
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);

               lblName=new JLabel("Name");
               lblName.setHorizontalAlignment(JLabel.LEFT);
               lblName.setFont(new Font("",1,12));
               detailsPanel.add(lblName);
               lblID=new JLabel(":");
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
               lblName=new JLabel(Contact.Name());
               lblName.setHorizontalAlignment(JLabel.LEFT);
               lblName.setFont(new Font("",1,12));
               detailsPanel.add(lblName);


               lblPhonenumber=new JLabel("Phone Number");
               lblPhonenumber.setHorizontalAlignment(JLabel.LEFT);
               lblPhonenumber.setFont(new Font("",1,12));
               detailsPanel.add(lblPhonenumber);
               lblID=new JLabel(":");
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
               lblPhonenumber=new JLabel(Contact.PhoneNumber());
               lblPhonenumber.setHorizontalAlignment(JLabel.LEFT);
               lblPhonenumber.setFont(new Font("",1,12));
               detailsPanel.add(lblPhonenumber);

               lblCompanyName=new JLabel("Company Name");
               lblCompanyName.setHorizontalAlignment(JLabel.LEFT);
               lblCompanyName.setFont(new Font("",1,12));
               detailsPanel.add(lblCompanyName);
               lblID=new JLabel(":");
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
               lblCompanyName=new JLabel(Contact.CompanyName());
               lblCompanyName.setHorizontalAlignment(JLabel.LEFT);
               lblCompanyName.setFont(new Font("",1,12));
               detailsPanel.add(lblCompanyName);

               lblSalary=new JLabel("Salary");
               lblSalary.setHorizontalAlignment(JLabel.LEFT);
               lblSalary.setFont(new Font("",1,12));
               detailsPanel.add(lblSalary);
               lblID=new JLabel(":");
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
               lblSalary=new JLabel(""+Contact.Salary());
               lblSalary.setHorizontalAlignment(JLabel.LEFT);
               lblSalary.setFont(new Font("",1,12));
               detailsPanel.add(lblSalary);

               lblBirthday=new JLabel("Birthday");
               lblBirthday.setHorizontalAlignment(JLabel.LEFT);
               lblBirthday.setFont(new Font("",1,12));
               detailsPanel.add(lblBirthday);
               lblID=new JLabel(":");
               lblID.setHorizontalAlignment(JLabel.LEFT);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
               lblBirthday=new JLabel(Contact.Birthday());
               lblBirthday.setHorizontalAlignment(JLabel.LEFT);
               lblBirthday.setFont(new Font("",1,12));
               detailsPanel.add(lblBirthday);
               
               detailsPanel.revalidate();
               detailsPanel.repaint();

               
              
               del.add(btnDelete);
           
               
               btnDelete.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent evt){

                    boolean isAdded=ContactController.DeleteContact(index);
				if(isAdded){
					JOptionPane.showMessageDialog(null, "Contact Added Successfully");
				}


                       
                       DeleteContactForm.this.dispose();
                       new DeleteContactForm().setVisible(true);
                   }
               });
             
            
            }
        });
        SearchPanel.add(titleLabel);
        SearchPanel.add(txtSearch);
        SearchPanel.add(btnSearch);

        Center.add(SearchPanel);
        Center.add(detailsPanel);
        Center.add(del);
         
        
}
public static void main(String args[]){
    new DeleteContactForm().setVisible(true);
}

}