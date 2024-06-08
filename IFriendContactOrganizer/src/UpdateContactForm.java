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

        JPanel detailsPanel=new JPanel(new GridLayout(6,1));

        

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
               lblID=new JLabel("Contact Id :"+Contact.id());
               lblID.setHorizontalAlignment(JLabel.CENTER);
               lblID.setFont(new Font("",1,12));
               detailsPanel.add(lblID);
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
