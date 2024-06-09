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
    public static String mid(){
        if(ContactDBConnection.getInstance().getContactList().size()==0){
            return "C001";
        }else{
            String lastid=getContact(ContactDBConnection.getInstance().getContactList().size()-1).id();
            int index=Integer.parseInt(lastid.substring(1));
            
            String nextId = String.format("C%03d", index + 1);

            return nextId;
        }
    }
    public static  void sortByName(){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        for(int i=0;i<contactList.size();i++){
            for(int j=i+1;j<contactList.size();j++){
                if(contactList.get(i).Name().compareTo(contactList.get(j).Name())>0){
                    Contact temp=contactList.get(i);
                    contactList.set(i,contactList.get(j));
                    contactList.set(j,temp);
                }
            }
        }

    }
    public static  void sortBySalary(){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        for(int i=0;i<contactList.size();i++){
            for(int j=i+1;j<contactList.size();j++){
                if(contactList.get(i).Salary()>contactList.get(j).Salary()){
                    Contact temp=contactList.get(i);
                    contactList.set(i,contactList.get(j));
                    contactList.set(j,temp);
                }
            }
        }
    
}
    public static  void sortByBirthday(){
        ArrayList <Contact> contactList=ContactDBConnection.getInstance().getContactList();
        for(int i=0;i<contactList.size();i++){
            for(int j=i+1;j<contactList.size();j++){
                if(contactList.get(i).Birthday().compareTo(contactList.get(j).Birthday())>0){
                    Contact temp=contactList.get(i);
                    contactList.set(i,contactList.get(j));
                    contactList.set(j,temp);
                }
            }
        }

    }
}