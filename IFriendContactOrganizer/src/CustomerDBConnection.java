import java.util.*;
class CustomerDBConnection{
	private ArrayList <Contact>contactList;
	
	private static CustomerDBConnection customerDBConnection;
	private CustomerDBConnection(){
		contactList=new ArrayList<>();
	}
	public static CustomerDBConnection getInstance(){
		if(customerDBConnection==null){
			customerDBConnection=new CustomerDBConnection();
		}
		return customerDBConnection;
	}
	public ArrayList<Contact>getCustomerList(){
		return contactList;
	}
}
