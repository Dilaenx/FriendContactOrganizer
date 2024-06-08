import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddContactForm extends JFrame{
	//public static ContactList C = new ContactList ();

	private JLabel titleLabel;
	
	private JButton btnAdd;
	private JButton btnCancel;
	
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblPhonenumber;
	private JLabel lblCompanyName;
	private JLabel lblSalary;
	private JLabel lblBirthday;
	private JLabel lblC;
	
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhonenumber;
	private JTextField txtCompanyName;
	private JTextField txtSalary;
	private JTextField Birthdayy;
	private JTextField Birthdaym;
	private JTextField Birthdayd;
	
	AddContactForm(){
		setSize(500,300);
		setTitle("Add Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		titleLabel=new JLabel("Add Contact Form");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("Add");
		btnAdd.setFont(new Font("",1,20));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				String name=txtName.getText();
				String phonenumber=txtPhonenumber.getText();
				String companyname=txtCompanyName.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				String birthday=Birthdayy.getText()+"-"+Birthdaym.getText()+"-"+Birthdayd.getText();
				if(ContactValidation.ValidatePhoneNumber(phonenumber)==-1){
					JOptionPane.showMessageDialog(null, "Invalid Phone Number");
					return;
				}else if(ContactValidation.ValidatePhoneNumber(phonenumber)==0){
					JOptionPane.showMessageDialog(null, "Phone Number Already Exists");
					return;
				}else if(!ContactValidation.ValidateBithdate(birthday)){
						JOptionPane.showMessageDialog(null, "Invalid Birthdate");
						return;
					}else{
				
				Contact Contact=new Contact(id,name,phonenumber,companyname,salary,birthday);
				boolean isAdded=ContactController.addContact(Contact);
				if(isAdded){
					JOptionPane.showMessageDialog(null, "Contact Added Successfully");
				}
				
				
				AddContactForm.this.dispose();
				new AddContactForm().setVisible(true);
				}
			}
		});
		buttonPanel.add(btnAdd);
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddContactForm.this.dispose();
				new Contactmainform().setVisible(true);
			}
		});

		buttonPanel.add(btnCancel);
		add("South",buttonPanel);
		
		JPanel labelPanel=new JPanel(new GridLayout(6,1));
		
		lblId=new JLabel("Id");
		lblId.setFont(new Font("",1,20));
		labelPanel.add(lblId);
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		lblPhonenumber=new JLabel("PhoneNumber");
		lblPhonenumber.setFont(new Font("",1,20));
		labelPanel.add(lblPhonenumber);

		lblCompanyName=new JLabel("CompanyName");
		lblCompanyName.setFont(new Font("",1,20));
		labelPanel.add(lblCompanyName);
	
		lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20));
		labelPanel.add(lblSalary);
		
		lblBirthday=new JLabel("Brithday");
		lblBirthday.setFont(new Font("",1,20));
		labelPanel.add(lblBirthday);
		
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(6,1));
		
		txtId=new JTextField(4);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtPhonenumber=new JTextField(10);
		txtPhonenumber.setFont(new Font("",1,20));
		JPanel PhonenumberTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
		PhonenumberTextPanel.add(txtPhonenumber);
		textPanel.add(PhonenumberTextPanel);

		txtCompanyName=new JTextField(10);
		txtCompanyName.setFont(new Font("",1,20));
		JPanel companyNameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		companyNameTextPanel.add(txtCompanyName);
		textPanel.add(companyNameTextPanel);
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",1,20));
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		salaryTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);
		
		JPanel birthdayTextPannel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		Birthdayy=new JTextField(4);
		Birthdayy.setFont(new Font("",1,20));
		birthdayTextPannel.add(Birthdayy);
		textPanel.add(birthdayTextPannel);
		
		lblC = new JLabel("/");
		lblC.setFont(new Font("",1,20));
		birthdayTextPannel.add(lblC);
		textPanel.add(birthdayTextPannel);
		
		Birthdaym=new JTextField(2);
		Birthdaym.setFont(new Font("",1,20));
		birthdayTextPannel.add(Birthdaym);
		textPanel.add(birthdayTextPannel);
		
		lblC = new JLabel("/");
		lblC.setFont(new Font("",1,20));
		birthdayTextPannel.add(lblC);
		textPanel.add(birthdayTextPannel);
		
		Birthdayd=new JTextField(2);
		Birthdayd.setFont(new Font("",1,20));
		birthdayTextPannel.add(Birthdayd);
		textPanel.add(birthdayTextPannel);
		
		
		
		add("Center",textPanel);
	}


	public static void main(String args[]){
		new AddContactForm().setVisible(true);
	}
}


