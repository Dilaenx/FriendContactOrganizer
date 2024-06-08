import java.util.*;
public class ContactController {
    public static boolean addContact(Contact Contact){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        return contactList.add(Contact);

    }
    public static boolean DeleteContact(int index){
        ContactDBConnection.getInstance().getContactList().remove(index);
        return true;
    }
    public static boolean DeleteContact(Contact Contact){
        ContactDBConnection.getInstance().getContactList().remove(Contact);
        return true;
    } 
    public static void updateContact(Contact Contact){
       
    }
    //create a methode if i enter phonenumber or name then return the index of the object
    public static int searchContact(String Contact){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        for(int i=0;i<contactList.size();i++){
            if(contactList.get(i).Name().equals(Contact)||contactList.get(i).PhoneNumber().equals(Contact)){
                return i;
            }
        }
        return -1;
        
    }
    public static Contact getContact(int index){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        return contactList.get(index);
    }

    public static void updateName(int index,String newName){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        contactList.get(index).setName(newName);
    }

    public static void updatePhoneNumber(int index,String newPhoneNumber){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        contactList.get(index).setPhoneNumber(newPhoneNumber);
    }

    public static void updateSalary(int index,double salary){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        contactList.get(index).setSalary(salary);
    }
    
    
}
