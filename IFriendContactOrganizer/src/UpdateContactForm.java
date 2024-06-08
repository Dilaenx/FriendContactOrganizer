import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;

public class UpdateContactForm extends JFrame{
private JLabel titleLabel;
private JLabel lbSearch;

private JLabel lblID;
private JLabel lblName;
private JLabel lblPhonenumber;
private JLabel lblCompanyName;
private JLabel lblSalary;
private JLabel lblBirthday;
private JLabel lbUpdate;
private JLabel lbtBackToMenu;

private JButton btnSearch;
private JButton btnUpdate;
private JButton btnName;
private JButton btnPhonenumber;
private JButton btnSalary;
private JButton btnBackToMenu;



private JTextField txtSearch;

UpdateContactForm(){
    setSize(500,300);
    setTitle("Add Contact Form");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);

    titleLabel=new JLabel("Update Contact Form");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,20));
		add("North",titleLabel);

        JPanel centerPanel=new JPanel(new GridLayout(3,1));

        JPanel searchPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel detailsPanel=new JPanel(new GridLayout(6,3));
        

        

        lbSearch=new JLabel("Enter Search Contact :");
		lbSearch.setHorizontalAlignment(JLabel.LEFT);
		lbSearch.setFont(new Font("",1,12));
         searchPanel.add(lbSearch);


        txtSearch=new JTextField(15);
        txtSearch.setFont(new Font("",1,12));
        searchPanel.add(txtSearch);


        btnSearch=new JButton("Search");
        btnSearch.setFont(new Font("",1,8));
        
        searchPanel.add(btnSearch);

        

        centerPanel.add(searchPanel);
        centerPanel.add(detailsPanel);

        btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				int index = ContactController.searchContact(txtSearch.getText());
                if(index==-1){
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

			}
		});




        searchPanel.add(btnSearch);

        

        centerPanel.add(searchPanel);
        centerPanel.add(detailsPanel);
        


      


        centerPanel.add(detailsPanel);
        add("Center",centerPanel);
}
public static void main(String args[]){
    new UpdateContactForm().setVisible(true);
}

}
