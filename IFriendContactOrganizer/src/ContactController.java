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
}
