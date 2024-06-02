import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

class ContactList {
    //private Contact[] ContactListArray;
    // private int Length;
    // private int LoadFactor;
    // private int Index;
    private Node front;

    public boolean isNull(){
        if(front==null){
            return true;
        }else{
            return false;
        }
    }
    public boolean nextIsNull(){
        if(front.next==null){
            return true;
        }else{
            return false;
        }
    }

    public void AddContact(Contact Contact) {
        // ContactListArray = new Contact[Length];
        // this.Length = Length;
        // this.LoadFactor = LoadFactor;
        // Index = 0;
        Node n1 = new Node(Contact);
        Node lNode = front;
        if(isNull()){
            front = n1;
        }else{
           while(lNode.next!=null){
            lNode=lNode.next;
           }
           lNode.next = n1;
        }
    }
    public String MemberIdGenarate2(){
        if(isNull()){
            return "C001";
        }else{
            Node temp = front;
            int index=0;
            while(temp!=null){
                temp = temp.next;
                index++;
            }String nextId = String.format("C%03d", index + 1);

                 return nextId;
        }
    }
    public boolean DuplicatePhoneNumber(String PhoneNumber){
        Node temp = front;
        if(isNull()){
            return false;
        }else{
            while(temp!=null){
                if(temp.Contact.PhoneNumber().equals(PhoneNumber)){
                    return true;
                }
                temp = temp.next;
            }
        }return false;
    }
    public int FindMember(String Contact){
        Node temp = front;
        int count =0;
        while(temp!=null){
            if(temp.Contact.Name().equals(Contact)||(temp.Contact.PhoneNumber().equals(Contact))){
                return count;
                
        }
        count++;
        temp=temp.next;
        
    }
    return -1;
}

    public void SetName(int index,String newName){
        Node temp = front;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }temp.Contact.setName(newName);
    }
   public void SetPhoneNumber(int index,String PhoneNumber){
    Node temp = front;
    for(int i=0;i<index;i++){
        temp = temp.next;
    }temp.Contact.setPhoneNumber(PhoneNumber);
   }
   public void setCompanyName(int index,String CompanyName){
    Node temp = front;
    for(int i=0;i<index;i++){
        temp = temp.next;
    }temp.Contact.setCompanyName(CompanyName);
   }
   public void setSalary(int index,double Salary){
    Node temp = front;
    for(int i=0;i<index;i++){
        temp = temp.next;
    }temp.Contact.setSalary(Salary);
   }

   public void DisplayMember(int index) {

    Node temp = front;
    for(int i=0;i<index;i++){
        temp=temp.next;
    }

    System.out.printf("\n\tContactid\t  : %s\n", temp.Contact.id());
    System.out.printf("\tName\t          : %s\n", temp.Contact.Name());
    System.out.printf("\tPhone Number\t  : %s\n", temp.Contact.PhoneNumber());
    System.out.printf("\tCompany Name\t  : %s\n", temp.Contact.CompanyName());
    System.out.printf("\tSalary\t          : %,.2f\n", temp.Contact.Salary());
    System.out.printf("\tB'Day(YYYY-MM-DD) : %s\n", temp.Contact.Birthday());

}



   public void DeleteContact(int index){
    if(index==0){
        front = front.next;
    }else{
        Node temp = front;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }temp.next=temp.next.next;
    }
   }
   public int Size(){
    Contact temp = front;
    int count = 0;
    while(temp!=null){
        count++;
        temp = temp.next();
    }
    return count;
   }



    // public void AddContact(Contact Contact) {
    //     if (Index == ContactListArray.length) {
    //         Contact[] temp = new Contact[Index + LoadFactor];
    //     }
    //     ContactListArray[Index++] = Contact;
    // }

    // public int GetIndex() {
    //     return Index;
    // }

    // public String GetMemberId(int index) {
    //     return ContactListArray[index].GetMemberId();
    // }

    // public String GetName(int index) {
    //     return ContactListArray[index].GetName();
    // }

    // public String GetPhoneNumber(int index) {
    //     return ContactListArray[index].GetPhoneNumber();
    // }

    // public String GetCompanyName(int index) {
    //     return ContactListArray[index].GetComanyName();
    // }

    // public Double GetSalary(int index) {
    //     return ContactListArray[index].GetSalary();
    // }

    // public String GetBirthday(int index) {
    //     return ContactListArray[index].GetBirthday();
    // }


    // public void SetContactId(int FindMember, String ContactId) {
    //     ContactListArray[FindMember].SetMemberId(ContactId);
    // }

    // public void SetName(int FindMember, String newName) {
    //     ContactListArray[FindMember].SetName(newName);
    // }

    // public void SetPhoneNumber(int FindMember, String PhoneNumber) {
    //     ContactListArray[FindMember].SetPhoneNumber(PhoneNumber);
    // }

    // public void SetCompanyName(int FindMember, String newCompanyName) {
    //     ContactListArray[FindMember].SetCompanyName(newCompanyName);
    // }

    // public void SetSalary(int FindMember, double Salary) {
    //     ContactListArray[FindMember].SetSalary(Salary);
    // }

    // public void leftIndex() {
    //     Index--;
    // }

    // public void DeleteContact(int Delete) {
    //     for (int i = Delete; i < Index; i++) {
    //         if(i+1<Index)SetContactId(i+1, GetMemberId(i));
    //         ContactListArray[i] = ContactListArray[i + 1];

    //     }
    //     leftIndex();
        
    // }
    class Node{
        Contact Contact;
        Node next;

        Node(Contact Contact){
            this.Contact=Contact;
        }

    }
}

class Contact {
    private String MemberId;
    private String Name;
    private String PhoneNumber;
    private String CompanyName;
    private double Salary;
    private String Birthday;
   

    Contact(String MemberId, String Name, String PhoneNumber, String CompanyName, double Salary, String Birthday) {
        this.MemberId = MemberId;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.CompanyName = CompanyName;
        this.Salary = Salary;
        this.Birthday = Birthday;
    }

   
    public String id(){
        return MemberId;
    }
    public String Name(){
        return Name;
    }
    public String PhoneNumber(){
        return PhoneNumber;
    }
    public String CompanyName(){
        return CompanyName;
    }
    public Double Salary(){
        return Salary;
    }
    public String Birthday(){
        return Birthday;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber=PhoneNumber;
    }
    public void setCompanyName(String CompanyName){
        this.CompanyName=CompanyName;
    }
    public void setSalary(Double Salary){
        this.Salary=Salary;
    }
    
    // public void SetMemberId(String MemberId) {
    //     this.MemberId = MemberId;
    // }

    // public void SetName(String Name) {
    //     this.Name = Name;
    // }

    // public void SetPhoneNumber(String PhoneNumber) {
    //     this.PhoneNumber = PhoneNumber;
    // }

    // public void SetCompanyName(String CompanyName) {
    //     this.CompanyName = CompanyName;
    // }

    // public void SetSalary(double Salary) {
    //     this.Salary = Salary;
    // }

    // public void SetBirthday(String Birthday) {
    //     this.Birthday = Birthday;
    // }

    // public String GetMemberId() {
    //     return MemberId;
    // }

    // public String GetName() {
    //     return Name;
    // }

    // public String GetPhoneNumber() {
    //     return PhoneNumber;
    // }

    // public String GetComanyName() {
    //     return CompanyName;
    // }

    // public double GetSalary() {
    //     return Salary;
    // }

    // public String GetBirthday() {
    //     return Birthday;
    // }
}

public class IFriendContactOrganizer {
    // ==================================================== Create Arrays
    // ====================================================
    // public static Contact [] ContactArray = new Contact [0];
    // public static string[] memberidarray = new string[0];
    // public static string[] namearray = new string[0];
    // public static string[] phonenumberarray = new string[0];
    // public static string[] companynamearray = new string[0];
    // public static double[] salaryarray = new double[0];
    // public static string[] birthdayarray = new string[0];
    //public static ContactList ContactList = new ContactList(5, 2);

    // ==================================================== MemberIdGenarate2
    // ====================================================
    // public static String MemberIdGenarate2() {
    //     String nextId = String.format("C%03d", ContactList.GetIndex() + 1);

    //     return nextId;

    // }

    // ==================================================== MemberIdGenarate1
    // ====================================================

    // ==================================================== Extend Arrays
    // ====================================================
    public static void ExtendArrays() {
        // String[] extendMemberIdArray = new String[MemberIdArray.length + 1];
        // String[] extendNameArray = new String[MemberIdArray.length + 1];
        // String[] extendPhoneNumberArray = new String[MemberIdArray.length + 1];
        // String[] extendCompanyNameArray = new String[MemberIdArray.length + 1];
        // double[] extendSalaryArray = new double[MemberIdArray.length + 1];
        // String[] extendBirthDayArray = new String[MemberIdArray.length + 1];

        // for (int i = 0; i < MemberIdArray.length; i++) {
        // extendMemberIdArray[i] = MemberIdArray[i];
        // extendNameArray[i] = NameArray[i];
        // extendPhoneNumberArray[i] = PhoneNumberArray[i];
        // extendCompanyNameArray[i] = CompanyNameArray[i];
        // extendSalaryArray[i] = SalaryArray[i];
        // extendBirthDayArray[i] = BirthDayArray[i];
        // }
        // MemberIdArray = extendMemberIdArray;
        // NameArray = extendNameArray;
        // PhoneNumberArray = extendPhoneNumberArray;
        // CompanyNameArray = extendCompanyNameArray;
        // SalaryArray = extendSalaryArray;
        // BirthDayArray = extendBirthDayArray;

        // Contact [] ExtendContactArray = new Contact[ContactArray.length+1];
        // for (int i = 0; i < ContactArray.length; i++) {
        // ExtendContactArray[i]=ContactArray[i];
        // }
        // ContactArray=ExtendContactArray;

    }

    // ==================================================== NewDeleteArrays
    // ====================================================
    public static void NewDeleteArrays(int delete) {
        // String[] extendMemberIdArray = new String[MemberIdArray.length - 1];
        // String[] extendNameArray = new String[MemberIdArray.length - 1];
        // String[] extendPhoneNumberArray = new String[MemberIdArray.length - 1];
        // String[] extendCompanyNameArray = new String[MemberIdArray.length - 1];
        // double[] extendSalaryArray = new double[MemberIdArray.length - 1];
        // String[] extendBirthDayArray = new String[MemberIdArray.length - 1];

        // Contact [] DeleteContactArray = new Contact[ContactArray.length-1];

        // for (int i = 0; i < delete; i++) {
        // // extendMemberIdArray[i] = MemberIdArray[i];
        // // extendNameArray[i] = NameArray[i];
        // // extendPhoneNumberArray[i] = PhoneNumberArray[i];
        // // extendCompanyNameArray[i] = CompanyNameArray[i];
        // // extendSalaryArray[i] = SalaryArray[i];
        // // extendBirthDayArray[i] = BirthDayArray[i];
        // DeleteContactArray[i] = ContactArray[i];
        // }
        // // int j = delete;
        // for (int i = delete + 1; i < ContactArray.length; i++) {
        // // extendMemberIdArray[j] = MemberIdArray[i];
        // // extendNameArray[j] = NameArray[i];
        // // extendPhoneNumberArray[j] = PhoneNumberArray[i];
        // // extendCompanyNameArray[j] = CompanyNameArray[i];
        // // extendSalaryArray[j] = SalaryArray[i];
        // // extendBirthDayArray[j] = BirthDayArray[i];
        // // j++;
        // DeleteContactArray[delete] = ContactArray[i];
        // }
        // // // for (int i = 0; i < extendMemberIdArray.length; i++) {
        // // // extendMemberIdArray[i] = MemberIdArray[i];

        // // // }
        // // MemberIdArray = extendMemberIdArray;
        // // NameArray = extendNameArray;
        // // PhoneNumberArray = extendPhoneNumberArray;
        // // CompanyNameArray = extendCompanyNameArray;
        // // SalaryArray = extendSalaryArray;
        // // BirthDayArray = extendBirthDayArray;
        // ContactArray = DeleteContactArray;
    }

    // ==================================================== Display Member
    // ====================================================
    

    // =================================================== Search Member
    // ====================================================
    public static int FindMember(String contact,ContactList cList) {
        // int i = 0;
        // do {

        //     // Scanner input = new Scanner(System.in);

        //     if ((contact.charAt(0) == '0') & (contact.length() == 10)) {
        //         for (i = 0; i < ContactList.GetIndex(); i++) {
        //             if (contact.equals(ContactList.GetPhoneNumber(i))) {
        //                 return i;

        //             }
        //         }

        //     } // check phone number

        //     else {
        //         for (i = 0; i < ContactList.GetIndex(); i++) {
        //             if (contact.equals(ContactList.GetName(i))) {
        //                 return i;
        //             }
        //         }
        //     }
        //     return -1;
        // } while (true);
        Contact temp = cList.front();
        int index =0;
            while(temp != null) {
                if(contact.equals(temp.PhoneNumber()) || contact.equals(temp.Name())) {
                    return index;
                }
                index++;
                temp=temp.next();
            }
        return -1;

    }

    // ==================================================== Clear Console
    // ====================================================
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    // ==================================================== DuplicatePhoneNumber
    // ====================================================
//     public static boolean DuplicatePhoneNumber(String phoneNumber) {

//         // for (int i = 0; i < ContactList.GetIndex(); i++) {
//         //     if (phoneNumber.equals(ContactList.GetPhoneNumber(i))) {
//         //         return true;
//         //     }
//         // }
//         // return false;
        
//         if(cList.front()==null){
//             return false;
//         }else{
//         Contact temp = front;
//         while(temp!=null){
//             if(phoneNumber.equals(temp.PhoneNumber())){
//         return true;
        
//         }
//         temp=temp.next();
//         }
//     }
//     return false;
// }

    // ==================================================== Short methode
    // ====================================================
    public static void SortContact(char Option) {
        Scanner input = new Scanner(System.in);
        if (cList.front() == null) {

            System.out.println(
                    "\n\tThere are no any data......");

            System.out.print("\nDo you want to add contacts (Y/N) : ");
            char ch = input.next().charAt(0);
            input.nextLine();
            if (ch == 'Y' || ch == 'y') {
                // Move the cursor up five lines
                System.out.print("\033[4A");
                // Clear the lines
                System.out.print("\033[0J");
                AddContacts();

            } else if (ch == 'N' || ch == 'n') {
                Exit();
                return;
            }
        }
        switch (Option) {
            case '1': {
                System.out.println("\t\t\t+-----------------------------------------------------------------+");
                System.out.println("\t\t\t|                      List contact by Name                       |");
                System.out.println("\t\t\t+-----------------------------------------------------------------+");
                // String[] AssendingMemeberArray = new String[MemberIdArray.length];
                // String[] AssendingContactArray = new String[ContactList.GetIndex()];
                // String[] DuplicateContactArray = new String[ContactList.GetIndex()];
                System.out.println(
                        "+--------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %-13s|        %-12s|\n",
                        "Contact Id",
                        "Name", "Phone Number", "Company", "Salary", "Birthday");
                System.out.println(
                        "+--------------------------------------------------------------------------------------------------------------------+");

                // for (int i = 0; i < ContactList.GetIndex(); i++) {
                //     // Contact originalContact = ContactArray[i];
                //     // Contact duplicateContact = new Contact(originalContact.GetMemberId(),
                //     // originalContact.GetName(),
                //     // originalContact.GetPhoneNumber(), originalContact.GetComanyName(),
                //     // originalContact.GetSalary(), originalContact.GetBirthday());
                //     // AssendingContactArray[i] = originalContact;
                //     // DuplicateContactArray[i] = duplicateContact;
                //     AssendingContactArray[i] = ContactList.GetName(i);
                //     DuplicateContactArray[i] = ContactList.GetName(i);
                // }
                    int size =cList.Size();
                   
                for (int j = 0; j < size ; j++) {
                    Contact temp = cList.front();
                    Contact top = cList.front();
                    System.out.println("for ");
                    while (temp.next()!=null){

                        // if ((AssendingContactArray[i]).compareTo(AssendingContactArray[i + 1]) > 0) {
                        //     String temp = AssendingContactArray[i];
                        //     AssendingContactArray[i] = AssendingContactArray[i + 1];
                        //     AssendingContactArray[1 + i] = temp;
                            String name1 =temp.Name();
                            String name2 =temp.next().Name();
                        if(name1.compareTo(name2) > 0){
                            // Contact top =temp.next();
                            // temp.setnext(temp.next().next()); 
                            // top.setnext(temp);                                         
                            // temp=top;
                            
                            // Contact front =temp.next();
                            // temp.setnext(temp.next().next());
                            // front.setnext(temp);
                            // temp=front;

                            top =temp.next();
                            temp.setnext(top.next());
                            top.setnext(temp);
                            temp=top;
                            
                            System.out.println(temp.Name());

                            System.out.println("whul");


                        }
                        System.out.println(temp.Name());
                        temp=temp.next();
                        System.out.println(temp.Name());
                        }

                    }

                
                    Contact temp2 = cList.front();
                while(temp2!=null) {
                    

                    System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %,-13.2f|        %-12s|\n",
                            // ContactArray[newindex].GetMemberId(),
                            // ContactArray[newindex].GetName(),
                            // ContactArray[newindex].GetPhoneNumber(),
                            // ContactArray[newindex].GetComanyName(),
                            // ContactArray[newindex].GetSalary(),
                            // ContactArray[newindex].GetBirthday());
                            temp2.id(),
                            temp2.Name(),
                            temp2.PhoneNumber(),
                            temp2.CompanyName(),
                            temp2.Salary(),
                            temp2.Birthday());

                    temp2=temp2.next();
                }
                // for (int i = 0; i < ContactList.GetIndex(); i++) {
                //     ContactList.SetName(i, AssendingContactArray[i]);
                // }

                System.out.println(
                        "+--------------------------------------------------------------------------------------------------------------------+");

                System.out.print("\nDo you want to go home (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    home();
                    break;
                } else if (ch == 'N' || ch == 'n') {
                    Exit();
                    return;

                } else {
                    System.out.println("Invalid Input......");
                    System.out.println("----------------------------------------------------------------------\n\n\n");
                    home();
                    break;
                }
            }
            //break;
            // case '2': {
            //     System.out.println("\t\t\t+-----------------------------------------------------------------+");
            //     System.out.println("\t\t\t|                     List contact by Salary                      |");
            //     System.out.println("\t\t\t+-----------------------------------------------------------------+");
            //     // double[] AssendingMemeberSalaryArray = new double[MemberIdArray.length];
            //     double[] AssendingContactArray = new double[ContactList.GetIndex()];
            //     double[] DuplicateContactArray = new double[ContactList.GetIndex()];
            //     System.out.println(
            //             "+--------------------------------------------------------------------------------------------------------------------+");
            //     System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %-13s|        %-12s|\n",
            //             "Contact Id",
            //             "Name", "Phone Number", "Company", "Salary", "Birthday");
            //     System.out.println(
            //             "+--------------------------------------------------------------------------------------------------------------------+");
            //     for (int i = 0; i < ContactList.GetIndex(); i++) {
            //         // Contact originalContact = ContactArray[i];
            //         // Contact duplicateContact = new Contact(originalContact.GetMemberId(),
            //         // originalContact.GetName(),
            //         // originalContact.GetPhoneNumber(), originalContact.GetComanyName(),
            //         // originalContact.GetSalary(), originalContact.GetBirthday());
            //         // AssendingContactArray[i] = originalContact;
            //         // DuplicateContactArray[i] = duplicateContact;
            //         AssendingContactArray[i] = ContactList.GetSalary(i);
            //         DuplicateContactArray[i] = AssendingContactArray[i];
            //     }

            //     for (int j = 0; j < ContactList.GetIndex() - j; j++) {
            //         for (int i = 0; i < ContactList.GetIndex() - 1; i++) {
            //             if ((AssendingContactArray[i]) > (AssendingContactArray[i + 1])) {
            //                 double temp = AssendingContactArray[i];
            //                 AssendingContactArray[i] = AssendingContactArray[i + 1];
            //                 AssendingContactArray[1 + i] = temp;
            //             }

            //         }

            //     }

            //     for (int i = 0; i < ContactList.GetIndex(); i++) {
            //         int newindex = SortSearch2(AssendingContactArray[i]);
            //         System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %,-13.2f|        %-12s|\n",
            //                 // ContactArray[newindex].GetMemberId(),
            //                 // ContactArray[newindex].GetName(),
            //                 // ContactArray[newindex].GetPhoneNumber(),
            //                 // ContactArray[newindex].GetComanyName(),
            //                 // ContactArray[newindex].GetSalary(),
            //                 // ContactArray[newindex].GetBirthday());

            //                 // ContactArray[newindex].SetSalary(0);

            //                 ContactList.GetMemberId(newindex),
            //                 ContactList.GetName(newindex),
            //                 ContactList.GetPhoneNumber(newindex),
            //                 ContactList.GetCompanyName(newindex),
            //                 ContactList.GetSalary(newindex),
            //                 ContactList.GetBirthday(newindex));

            //         ContactList.SetSalary(i, 0);
            //     }
            //     for (int i = 0; i < ContactList.GetIndex(); i++) {
            //         ContactList.SetSalary(i, DuplicateContactArray[i]);
            //     }
            //     System.out.println(
            //             "+--------------------------------------------------------------------------------------------------------------------+");

            //     System.out.print("\nDo you want to go home (Y/N) : ");
            //     char ch = input.next().charAt(0);
            //     input.nextLine();
            //     if (ch == 'Y' || ch == 'y') {
            //         // Move the cursor up five lines
            //         System.out.print("\033[4A");
            //         // Clear the lines
            //         System.out.print("\033[0J");
            //         home();
            //         break;
            //     } else if (ch == 'N' || ch == 'n') {
            //         Exit();
            //         return;

            //     } else {
            //         System.out.println("Invalid Input......");
            //         System.out.println("----------------------------------------------------------------------\n\n\n");
            //         home();
            //         break;
            //     }

            // }

            // case '3': {
            //     System.out.println("\t\t\t+-----------------------------------------------------------------+");
            //     System.out.println("\t\t\t|                    List contact by Birthday                     |");
            //     System.out.println("\t\t\t+-----------------------------------------------------------------+");
            //     // String[] AssendingBirthDayArray = new String[MemberIdArray.length];
            //     // Contact [] AssendingContactArray = new Contact [ContactArray.length];
            //     System.out.println(
            //             "+--------------------------------------------------------------------------------------------------------------------+");
            //     System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %-13s|        %-12s|\n",
            //             "Contact Id",
            //             "Name", "Phone Number", "Company", "Salary", "Birthday");
            //     System.out.println(
            //             "+--------------------------------------------------------------------------------------------------------------------+");
            //     // for (int i = 0; i < ContactArray.length; i++) {
            //     // AssendingContactArray[i] = ContactArray[i];
            //     // }
            //     int IntAssendingBirthDayArray[] = new int[ContactList.GetIndex()];
            //     int IntBirthDayArray[] = new int[ContactList.GetIndex()];
            //     /////////////////////////////////////////////////////////////////////////////////////////////
            //     for (int i = 0; i < ContactList.GetIndex(); i++) {
            //         String BDay = ContactList.GetBirthday(i);
            //         String Year = BDay.substring(0, 4);
            //         String Month = BDay.substring(5, 7);
            //         String day = BDay.substring(8);
            //         // String Line1 = BDay.substring(4, 5);
            //         // String Line2 = BDay.substring(7, 8);

            //         int days = (Integer.parseInt(day));
            //         int Months = (Integer.parseInt(Month));
            //         int year = (Integer.parseInt(Year));

            //         int values = year * 10000 + Months * 100 + days;
            //         IntAssendingBirthDayArray[i] = values;

            //     }
            //     for (int i = 0; i < ContactList.GetIndex(); i++) {
            //         IntBirthDayArray[i] = IntAssendingBirthDayArray[i];
            //     }
            //     ////////////////////////////////////////////////////////////////////////////////////////////
            //     for (int j = 0; j < ContactList.GetIndex() - j; j++) {
            //         for (int i = 0; i < ContactList.GetIndex() - 1; i++) {
            //             if (IntAssendingBirthDayArray[i] > IntAssendingBirthDayArray[i + 1]) {
            //                 int temp = IntAssendingBirthDayArray[i];
            //                 IntAssendingBirthDayArray[i] = IntAssendingBirthDayArray[i + 1];
            //                 IntAssendingBirthDayArray[1 + i] = temp;
            //             }

            //         }

            //     }

            //     for (int i = 0; i < IntAssendingBirthDayArray.length; i++) {
            //         int newindex = SortSearch3(IntAssendingBirthDayArray[i], IntBirthDayArray);
            //         System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %,-13.2f|        %-12s|\n",
            //                 // ContactArray[newindex].GetMemberId(),
            //                 // ContactArray[newindex].GetName(),
            //                 // ContactArray[newindex].GetPhoneNumber(),
            //                 // ContactArray[newindex].GetComanyName(),
            //                 // ContactArray[newindex].GetSalary(),
            //                 // ContactArray[newindex].GetBirthday());
            //                 ContactList.GetMemberId(newindex),
            //                 ContactList.GetName(newindex),
            //                 ContactList.GetPhoneNumber(newindex),
            //                 ContactList.GetCompanyName(newindex),
            //                 ContactList.GetSalary(newindex),
            //                 ContactList.GetBirthday(newindex));
            //         IntBirthDayArray[newindex] = 0;
            //     }
            //     System.out.println(
            //             "+--------------------------------------------------------------------------------------------------------------------+");

            //     System.out.print("\nDo you want to go home (Y/N) : ");
            //     char ch = input.next().charAt(0);
            //     input.nextLine();
            //     if (ch == 'Y' || ch == 'y') {
            //         // Move the cursor up five lines
            //         System.out.print("\033[4A");
            //         // Clear the lines
            //         System.out.print("\033[0J");
            //         home();
            //         break;
            //     } else if (ch == 'N' || ch == 'n') {
            //         Exit();
            //         return;

            //     } else {
            //         System.out.println("Invalid Input......");
            //         System.out.println("----------------------------------------------------------------------\n\n\n");
            //         home();
            //         break;
            //     }
            // }
            default:
                System.out.print("\n\tInvalid input.....\n\nDo you want to sort contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    ListContact();
                    break;
                } else if (ch == 'N' || ch == 'n') {
                    home();
                    break;
                }

        }

    }

    // ==================================================== Sort Search
    // ====================================================
    public static int SortSearch(String key) {
        int index = 0;
        for (int i = 0; i < ContactList.GetIndex(); i++) {
            if (ContactList.GetName(i).equals(key)) {
                index = i;
                break;
            }
        }
        return index;

    }

    public static int SortSearch2(Double key) {
        int index = 0;
        for (int i = 0; i < ContactList.GetIndex(); i++) {
            if (key == ContactList.GetSalary(i)) {
                index = i;
                break;
            }
        }
        return index;

    }

    public static int SortSearch3(int key, int kay[]) {
        int index = 0;
        for (int i = 0; i < ContactList.GetIndex(); i++) {
            if (key == kay[i]) {
                index = i;
                break;

            }
        }
        return index;
    }

    // ==================================================== printsort
    // ====================================================
    public static void PrintSort(int key) {

    }

    // ==================================================== Main methode
    // ====================================================
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        home();

    }
    public static ContactList cList = new ContactList ();
    // ==================================================== Home Page
    // ====================================================
    public static void home() {
        clearConsole();
        System.out.println("\t   /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$");
        System.out.println("\t   |__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
        System.out.println("\t    /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$");
        System.out.println("\t   | $$| $$$$$   | $$$$$$$/   | $$  | $$$$$  | $$ $$ $$| $$  | $$");
        System.out.println("\t   | $$| $$__/   | $$__  $$   | $$  | $$__/  | $$  $$$$| $$  | $$");
        System.out.println("\t   | $$| $$      | $$  \\ $$   | $$  | $$     | $$\\  $$$| $$  | $$");
        System.out.println("\t   | $$| $$      | $$  | $$ /$$$$$$ | $$$$$$$| $$ \\  $$| $$$$$$$/");
        System.out.println("\t   |__/|__/      |__/  |__/|_______/|_______/|__/  \\__/|_______/`");

        System.out.println("\n  _____            _             _          ____                        _");
        System.out.println(" / ____|          | |           | |        / __ \\                      (_)");
        System.out.println("| |     ___  _ __ | |_ __ _  ___| |_ ___  | |  | |_ __ __ _  __ _ _ __  _ _______ _ __");
        System.out
                .println(
                        "| |    /   \\| '_ \\| __/ _' |/ __| __/ __| | |  | | '__/ _' |/ _' | '_ \\| |_  / _ \\ '__|");
        System.out.println("| |___| (_) | | | | || |_| | |__| |_\\__ \\ | |__| | | | |_| | |_| | | | | |/ /  __/ |");
        System.out.println(
                " \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/  \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|");
        System.out.println("                                                       __/ |");
        System.out.println("                                                      |___/");

        System.out.println(
                "\n=======================================================================================");
        System.out.println(
                "\n\t[01] ADD Contacts\n\n\t[02] UPDATE Contact\n\n\t[03] DELETE Contact\n\n\t[04] SEARCH Contact\n\n\t[05] LIST Contact\n\n\t[06] EXIT\n\n");
        System.out.print("Enter an option to continue -> ");
        Scanner Input = new Scanner(System.in);
        int option = Input.nextInt();
        
        switch (option) {
            case 1:
            AddContacts();
                break;
            case 2:
                UpdateContact();
                break;
            case 3:
                DeleteContact();
                break;
            case 4:
                SearchContact();
                break;
            case 5:
                ListContact();
                break;
            case 6:
                Exit();
                return;
            default:
                System.out.println("\tInvalid input...");
                System.out.print("\nDo you want to input again (Y/N) : ");
                char ch = Input.next().charAt(0);
                Input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    home();
                    break;

                } else if (ch == 'N' || ch == 'n') {
                    return;

                } else {
                    System.out.println("Invalid Input......");
                    System.out.println(
                            "----------------------------------------------------------------------\n\n\n");
                    home();

                }
                home();
                break;
        }

    }

    // ==================================================== Add Contact
    // ====================================================
    public static void AddContacts() {

        Scanner input = new Scanner(System.in);

        do {
            clearConsole();

            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                       Add Contact to the list                   |");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("");

            // MemberIdArray[MemberIdArray.length - 1] = MemberIdGenarate2();
            String MemberId = cList.MemberIdGenarate2();

            // System.out.println(MemberIdArray[MemberIdArray.length - 1]);
            System.out.println(MemberId);
            System.out.println("=======\n\n");

            System.out.print("Name              : ");
            String Name = input.next();

            String PhoneNumber = "";
            do {
                System.out.print("Phone Number      : ");
                PhoneNumber = input.next();
                if ((PhoneNumber.charAt(0) == '0') & (PhoneNumber.length() == 10)) {

                    if (cList.DuplicatePhoneNumber(PhoneNumber) == true) {
                        System.out.println("\tDuplicate Phone Number...");
                        System.out.print("\nDo you want to input Phone Number again (Y/N) : ");
                        char ch = input.next().charAt(0);
                        input.nextLine();
                        if (ch == 'Y' || ch == 'y') {
                            // Move the cursor up five lines
                            System.out.print("\033[4A");
                            // Clear the lines
                            System.out.print("\033[0J");
                            continue;

                        } else if (ch == 'N' || ch == 'n') {
                            home();
                            return;
                        } else {
                            System.out.println("Invalid Input......");
                            System.out.println(
                                    "----------------------------------------------------------------------\n\n\n");
                            home();
                            return;
                        }
                    }

                    break;
                } else {
                    System.out.println("\tInvalid Phone Number...");
                    System.out.print("\nDo you want to input Phone Number again (Y/N) : ");
                    char ch = input.next().charAt(0);
                    input.nextLine();
                    if (ch == 'Y' || ch == 'y') {
                        // Move the cursor up five lines
                        System.out.print("\033[4A");
                        // Clear the lines
                        System.out.print("\033[0J");
                        continue;

                    } else if (ch == 'N' || ch == 'n') {
                        home();
                        break;
                    } else {
                        System.out.println("Invalid Input......");
                        System.out.println(
                                "----------------------------------------------------------------------\n\n\n");
                        home();
                        break;
                    }

                }

            } while (true);

            System.out.print("Company Name      : ");
            String CompanyName = input.next();

            double Salary = 0;
            do {
                System.out.print("Salary            : ");
                Salary = input.nextDouble();
                input.nextLine();
                if (Salary > 0) {
                    break;
                } else {
                    System.out.println("\tInvalid Salary...");
                    System.out.print("\nDo you want to input salary again (Y/N) : ");
                    char ch = input.next().charAt(0);
                    input.nextLine();
                    if (ch == 'Y' || ch == 'y') {
                        // Move the cursor up five lines
                        System.out.print("\033[4A");
                        // Clear the lines
                        System.out.print("\033[0J");

                    } else if (ch == 'N' || ch == 'n') {
                        home();
                        break;
                    } else {
                        System.out.println("Invalid Input......");
                        System.out.println(
                                "----------------------------------------------------------------------\n\n\n");
                        home();
                        break;
                    }
                }
            } while (true);

            String BDay = "";
            do {
                LocalDate currentDate = LocalDate.now();
                int currentMonthValue = currentDate.getMonthValue();
                int currentYear = currentDate.getYear();
                int currentMonthDate = currentDate.getDayOfMonth();
                System.out.print("B'Day             : ");
                BDay = input.next();
                if (BDay.length() == 10 & BDay.charAt(4) == '-' & BDay.charAt(7) == '-') {
                    String Year = BDay.substring(0, 4);
                    String Month = BDay.substring(5, 7);
                    String day = BDay.substring(8);
                    String Line1 = BDay.substring(4, 5);
                    String Line2 = BDay.substring(7, 8);
                    boolean x = false;
                    int days = (Integer.parseInt(day));
                    int Months = (Integer.parseInt(Month));
                    int year = (Integer.parseInt(Year));
                    if (year == currentYear) {
                        if (Months > currentMonthValue) {
                            System.out.println("\tInvalid Birthday...");
                            System.out.print("\nDo you want to input Birthday again (Y/N) : ");
                            char ch = input.next().charAt(0);
                            input.nextLine();
                            if (ch == 'Y' || ch == 'y') {
                                // Move the cursor up five lines
                                System.out.print("\033[4A");
                                // Clear the lines
                                System.out.print("\033[0J");
                                continue;

                            } else if (ch == 'N' || ch == 'n') {
                                home();
                                break;

                            } else {
                                System.out.println("Invalid Input......");
                                System.out.println(
                                        "----------------------------------------------------------------------\n\n\n");
                                home();
                                break;
                            }
                        } else if (Months == currentMonthValue) {
                            if (days > currentMonthDate) {
                                System.out.println("\tInvalid Birthday...");
                                System.out.print("\nDo you want to input Birthday again (Y/N) : ");
                                char ch = input.next().charAt(0);
                                input.nextLine();
                                if (ch == 'Y' || ch == 'y') {
                                    // Move the cursor up five lines
                                    System.out.print("\033[4A");
                                    // Clear the lines
                                    System.out.print("\033[0J");
                                    continue;

                                } else if (ch == 'N' || ch == 'n') {
                                    home();
                                    break;

                                } else {
                                    System.out.println("Invalid Input......");
                                    System.out.println(
                                            "----------------------------------------------------------------------\n\n\n");
                                    home();
                                    break;
                                }
                            }
                        }
                    }
                    switch (Months) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            if (days <= 31)
                                x = true;
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            if (days <= 30)
                                x = true;
                            break;
                        case 02:
                            if (days == 29) {
                                if (year % 400 == 0) {
                                    x = true;
                                } else if ((year % 100 != 0) & (year % 4 == 0)) {
                                    x = true;
                                }
                            } else if (days < 29) {
                                x = true;
                            }
                            break;
                    }

                    if (((year > currentYear) || (Months > 12)) || (!x)) {
                        System.out.println("\tInvalid Birthday...");
                        System.out.print("\nDo you want to input Birthday again (Y/N) : ");
                        char ch = input.next().charAt(0);
                        input.nextLine();
                        if (ch == 'Y' || ch == 'y') {
                            // Move the cursor up five lines
                            System.out.print("\033[4A");
                            // Clear the lines
                            System.out.print("\033[0J");
                            continue;

                        } else if (ch == 'N' || ch == 'n') {
                            home();
                            break;

                        } else {
                            System.out.println("Invalid Input......");
                            System.out.println(
                                    "----------------------------------------------------------------------\n\n\n");
                            home();
                            break;

                        }

                    } else {
                        break;
                    }

                } else {
                    System.out.println("\tInvalid Birthday...");
                    System.out.print("\nDo you want to input Birthday again (Y/N) : ");
                    char ch = input.next().charAt(0);
                    input.nextLine();
                    if (ch == 'Y' || ch == 'y') {
                        // Move the cursor up five lines
                        System.out.print("\033[4A");
                        // Clear the lines
                        System.out.print("\033[0J");
                        continue;

                    } else if (ch == 'N' || ch == 'n') {
                        home();
                        break;
                    } else {
                        System.out.println("Invalid Input......");
                        System.out.println(
                                "----------------------------------------------------------------------\n\n\n");
                        home();
                        break;
                    }

                }

            } while (true);

            // NameArray[MemberIdArray.length - 1] = Name;
            // PhoneNumberArray[MemberIdArray.length - 1] = PhoneNumber;
            // CompanyNameArray[MemberIdArray.length - 1] = CompanyName;
            // SalaryArray[MemberIdArray.length - 1] = Salary;
            // BirthDayArray[MemberIdArray.length - 1] = BDay;
            // ExtendArrays();
            // ContactArray [ContactArray.length-1] = new
            // Contact(MemberId,Name,PhoneNumber,CompanyName,Salary,BDay);
            Contact ContactDetails = new Contact(MemberId, Name, PhoneNumber, CompanyName, Salary, BDay);
            cList.AddContact(ContactDetails);
            System.out.println("\n\tMember added successfully...");
            System.out.print("\nDo you want to add another Member (Y/N) : ");
            char ch = input.next().charAt(0);
            input.nextLine();
            if (ch == 'Y' || ch == 'y') {
                continue;
            } else if (ch == 'N' || ch == 'n') {
                home();
                break;
            } else {
                System.out.println("Invalid Input......");
                System.out.println("----------------------------------------------------------------------\n\n\n");
                home();
                break;
            }

        } while (true);
    }

    // ==================================================== Update Contact
    // ====================================================
    public static void UpdateContact() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        L2: do {
            clearConsole();

            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                           UPDATE Contact                        |");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("");
            if (cList.isNull()) {
                System.out.println("\tThere are no any Contacts to Update...");
                System.out.print("\nDo you want add contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    AddContacts();
                } else if (ch == 'N' || ch == 'n') {
                    Exit();

                }
            }
            System.out.print("Search Contact by Name or Phone Number - ");
            String contact = input.next();

            int FindMember = cList.FindMember(contact);

            if (FindMember == -1) {
                System.out.println("\tNo contact found for " + contact + "...");
                System.out.print("\nDo you want to try a update contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    UpdateContact();
                } else if (ch == 'N' || ch == 'n') {
                    home();
                    break;

                } else {
                    System.out.println("Invalid Input......");
                    System.out.println("----------------------------------------------------------------------\n\n\n");
                    home();
                    break;
                }

            } else {
                cList.DisplayMember(FindMember);
            }
            
            System.out.println("\nWhat do you want to update....");
            System.out.println("\t[1] Name");
            System.out.println("\t[2] Phone Number");
            System.out.println("\t[3] Company Name");
            System.out.println("\t[4] Salary");
            System.out.print("\n\nEnter an option to continue -> ");
            int option = input.nextInt();
            switch (option) {
                case 1: {
                    // Move the cursor up five lines
                    System.out.print("\033[8A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    System.out.println("\nUpdate name\n=============\n");
                    System.out.print("Input new name - ");
                    String newName = input.next();
                    // NameArray[FindMember] = newName;
                    // ContactArray[FindMember].SetName(newName);
                   cList.SetName(FindMember, newName);
                    System.out.println("\tContact has been update successfully");
                    System.out.println("");
                    System.out.print("\nDo you want to update another Contact (Y/N) : ");
                    char ch = input.next().charAt(0);
                    input.nextLine();
                    if (ch == 'Y' || ch == 'y') {
                        UpdateContact();
                        break;

                    } else if (ch == 'N' || ch == 'n') {
                        home();
                        break;

                    } else {
                        System.out.println("Invalid Input......");
                        System.out.println(
                                "----------------------------------------------------------------------\n\n\n");
                        home();
                        break;
                    }

                }

                case 2: {
                    // Move the cursor up five lines
                    System.out.print("\033[8A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    System.out.println("\nPhone Number\n=============\n");
                    String PhoneNumber = "";
                    do {
                        System.out.print("Phone Number      : ");
                        PhoneNumber = input.next();
                        if ((PhoneNumber.charAt(0) == '0') & (PhoneNumber.length() == 10)) {

                            if (cList.DuplicatePhoneNumber(PhoneNumber) == true) {
                                System.out.println("\tDuplicate Phone Number...");
                                System.out.print("\nDo you want to input Phone Number again (Y/N) : ");
                                char ch = input.next().charAt(0);
                                input.nextLine();
                                if (ch == 'Y' || ch == 'y') {
                                    // Move the cursor up five lines
                                    System.out.print("\033[4A");
                                    // Clear the lines
                                    System.out.print("\033[0J");
                                    continue;

                                } else if (ch == 'N' || ch == 'n') {
                                    home();
                                    break;
                                } else {
                                    System.out.println("Invalid Input......");
                                    System.out.println(
                                            "----------------------------------------------------------------------\n\n\n");
                                    home();
                                    break;
                                }
                            }
                            // PhoneNumberArray[FindMember] = PhoneNumber;
                            // ContactArray[FindMember].SetPhoneNumber(PhoneNumber);
                            cList.SetPhoneNumber(FindMember, PhoneNumber);
                            System.out.println("\tContact has been update successfully");
                            System.out.println("");
                            System.out.print("\nDo you want to update another Contact (Y/N) : ");
                            char ch = input.next().charAt(0);
                            input.nextLine();
                            if (ch == 'Y' || ch == 'y') {

                                UpdateContact();

                            } else if (ch == 'N' || ch == 'n') {
                                home();
                                break;

                            } else {
                                System.out.println("Invalid Input......");
                                System.out.println(
                                        "----------------------------------------------------------------------\n\n\n");
                                home();
                                break;
                            }

                            break;
                        } else {
                            System.out.println("\tInvalid Phone Number...");
                            System.out.print("\nDo you want to input Phone Number again (Y/N) : ");
                            char ch = input.next().charAt(0);
                            input.nextLine();
                            if (ch == 'Y' || ch == 'y') {
                                // Move the cursor up five lines
                                System.out.print("\033[4A");
                                // Clear the lines
                                System.out.print("\033[0J");
                                continue;

                            } else if (ch == 'N' || ch == 'n') {
                                home();

                            } else {
                                System.out.println("Invalid Input......");
                                System.out.println(
                                        "----------------------------------------------------------------------\n\n\n");
                                home();
                                break;
                            }

                        }

                    } while (true);

                }
                    break;
                case 3: {

                    // Move the cursor up five lines
                    System.out.print("\033[8A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    System.out.println("\nCompany Name\n=============\n");
                    System.out.print("Input new Company Name - ");
                    String newCompanyName = input.next();
                    // CompanyNameArray[FindMember] = newCompanyName;
                    // ContactArray[FindMember].SetCompanyName(newCompanyName);
                    cList.setCompanyName(FindMember, newCompanyName);
                    System.out.println("\tContact has been update successfully");
                    System.out.println("");
                    System.out.print("\nDo you want to update another Contact (Y/N) : ");
                    char ch = input.next().charAt(0);
                    input.nextLine();
                    if (ch == 'Y' || ch == 'y') {
                        // Move the cursor up five lines
                        System.out.print("\033[4A");
                        // Clear the lines
                        System.out.print("\033[0J");
                        UpdateContact();

                    } else if (ch == 'N' || ch == 'n') {
                        home();
                        break;

                    } else {
                        System.out.println("Invalid Input......");
                        System.out.println(
                                "----------------------------------------------------------------------\n\n\n");
                        home();
                        break;
                    }

                }
                    break;
                case 4: {
                    // Move the cursor up five lines
                    System.out.print("\033[8A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    double Salary = 0;
                    do {
                        System.out.print("New Salary            : ");
                        Salary = input.nextDouble();
                        input.nextLine();
                        if (Salary > 0) {
                            // SalaryArray[FindMember] = Salary;
                            // ContactArray[FindMember].SetSalary(Salary);
                            cList.setSalary(FindMember, Salary);
                            System.out.println("\tSalary has been update successfully");
                            System.out.println("");
                            System.out.print("\nDo you want to update another Contact (Y/N) : ");
                            char ch = input.next().charAt(0);
                            input.nextLine();
                            if (ch == 'Y' || ch == 'y') {
                                UpdateContact();

                            } else if (ch == 'N' || ch == 'n') {
                                home();
                                break;

                            } else {
                                System.out.println("Invalid Input......");
                                System.out.println(
                                        "----------------------------------------------------------------------\n\n\n");
                                home();
                                break;
                            }

                        } else {
                            System.out.println("\tInvalid Salary...");
                            System.out.print("\nDo you want to input salary again (Y/N) : ");
                            char ch = input.next().charAt(0);
                            input.nextLine();
                            if (ch == 'Y' || ch == 'y') {
                                // Move the cursor up five lines
                                System.out.print("\033[4A");
                                // Clear the lines
                                System.out.print("\033[0J");
                                continue;

                            } else if (ch == 'N' || ch == 'n') {
                                home();
                                break;
                            } else {
                                System.out.println("Invalid Input......");
                                System.out.println(
                                        "----------------------------------------------------------------------\n\n\n");
                                home();
                                break;
                            }
                        }
                    } while (true);
                }
                    break;
                default: {
                    System.out.println("Invalid Input...");
                    System.out.print("Do u want to update contact (Y/N) : ");
                    char ch = input.next().charAt(0);
                    input.nextLine();
                    if (ch == 'Y' || ch == 'y') {
                        // Move the cursor up five lines
                        System.out.print("\033[4A");
                        // Clear the lines
                        System.out.print("\033[0J");
                        continue;

                    } else if (ch == 'N' || ch == 'n') {
                        home();
                        break;
                    } else {
                        System.out.println("Invalid Input......");
                        System.out.println(
                                "----------------------------------------------------------------------\n\n\n");
                        home();
                        break;
                    }

                }
            }
            return;

        } while (true);
    }

    // ==================================================== Delete Contact
    // ====================================================
    public static void DeleteContact() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        L2: do {
            clearConsole();

            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                           DELETE Contact                        |");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("");
            if (cList.isNull()) {
                System.out.println("\tThere are no any Contacts to Update...");
                System.out.print("\nDo you want add contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    AddContacts();
                } else if (ch == 'N' || ch == 'n') {
                    Exit();

                }
            }else if (cList.nextIsNull()) {
                cList.DisplayMember(0);
                System.out.print("\nDo you want to delete this Contct (Y/N) : ");
            char ch = input.next().charAt(0);
            input.nextLine();
            if (ch == 'Y' || ch == 'y') {
                // NewDeleteArrays(FindMember);
                cList.DeleteContact(0);
                System.out.println("\tMember has been deleted succesfuly...");
                System.out.println("");
                System.out.print("\nDo you want to add Contact (Y/N) : ");
                ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    AddContacts();

                } else { Exit();
            }
            }}else{


            System.out.print("Search Contact by Name or Phone Number - ");
            String contact = input.next();

            int FindMember = cList.FindMember(contact);
            if (FindMember == -1) {
                System.out.println("\tNo contact found for " + contact + "...");
                System.out.println("");
                System.out.print("\nDo you want to try a delete contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    
                    DeleteContact();
                    return;
                } else if (ch == 'N' || ch == 'n') {
                    home();
                    break;

                } else {
                    System.out.println("Invalid Input......");
                    System.out.println("----------------------------------------------------------------------\n\n\n");
                    home();
                    break;
                }

            } else {
                cList.DisplayMember(FindMember);
            
                
            System.out.print("\nDo you want to delete this Contct (Y/N) : ");
            char ch = input.next().charAt(0);
            input.nextLine();
            if (ch == 'Y' || ch == 'y') {
                // NewDeleteArrays(FindMember);
                cList.DeleteContact(FindMember);
                System.out.println("\tMember has been deleted succesfuly...");
                System.out.println("");
                System.out.print("\nDo you want to delete another Contact (Y/N) : ");
                ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    DeleteContact();

                } else if (ch == 'N' || ch == 'n') {
                    home();
                    break;

                } else {
                    System.out.println("Invalid Input......");
                    System.out.println(
                            "----------------------------------------------------------------------\n\n\n");
                    home();
                    break;
                }

            } else if (ch == 'N' || ch == 'n') {
                home();
                break;
            } else {
                System.out.println("Invalid Input......");
                System.out.println(
                        "----------------------------------------------------------------------\n\n\n");
                home();
                break;
            }
        }
    }return;
        } while (true);
    }

    // ==================================================== Search Contact
    // ====================================================
    public static void SearchContact() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        L2: do {
            clearConsole();

            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                           SEARCH Contact                        |");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("");
            if (cList.front() == null) {
                System.out.println("\tThere are no any Contacts to Update...");
                System.out.print("\nDo you want add contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    AddContacts();
                } else if (ch == 'N' || ch == 'n') {
                    Exit();

                }
            }
            if (cList.front().next() == null) {
                DisplayMember(0,cList);
                System.out.print("\nDo you want go homepage (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    
                    home();
                    Exit();

                } else if (ch == 'N' || ch == 'n') {
                    Exit();

                }
            }
            System.out.print("Search Contact by Name or Phone Number - ");
            String contact = input.next();

            int FindMember = FindMember(contact,cList);
            if (FindMember == -1) {
                System.out.println("\tNo contact found for " + contact + "...");
                System.out.print("\nDo you want to try a search contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    SearchContact();
                } else if (ch == 'N' || ch == 'n') {
                    home();
                    break;

                } else {
                    System.out.println("Invalid Input......");
                    System.out.println("----------------------------------------------------------------------\n\n\n");
                    home();
                    break;
                }

            } else {
                Contact temp = cList.front();
                for(int i=0;i<cList.Size();i++){
                    if(temp.Name().equals(contact)||temp.PhoneNumber().equals(contact)){
                        DisplayMember(i,cList);
                    }
                    temp=temp.next();
                }
                // String DuplicateNameArray[] = new String[ContactList.GetIndex()];
                // String DuplicatePhoneNumber[] = new String[ContactList.GetIndex()];
                // for (int i = 0; i < ContactList.GetIndex(); i++) {
                //     DuplicateNameArray[i] = ContactList.GetName(i);
                //     DuplicatePhoneNumber[i] = ContactList.GetPhoneNumber(i);
                // }
                // while (true) {
                //     FindMember = FindMember(contact);
                //     if (FindMember == -1)
                //         break;
                //     DisplayMember(FindMember);
                //     ContactList.SetPhoneNumber(FindMember, "contact");
                //     ContactList.SetName(FindMember, "contact");

                // }

                // for (int i = 0; i < ContactList.GetIndex(); i++) {
                //     // NameArray[i]=DuplicateNameArray[i];
                //     // PhoneNumberArray[i]=DuplicatePhoneNumber[i];
                //     // ContactArray[i].SetName(DuplicateNameArray[i]);
                //     // ContactArray[i].SetPhoneNumber(DuplicatePhoneNumber[i]);

                //     ContactList.SetPhoneNumber(i, DuplicatePhoneNumber[i]);
                //     ContactList.SetName(i, DuplicateNameArray[i]);
                // }
                    
                System.out.print("\nDo you want to search another contact (Y/N) : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch == 'Y' || ch == 'y') {
                    // Move the cursor up five lines
                    System.out.print("\033[4A");
                    // Clear the lines
                    System.out.print("\033[0J");
                    SearchContact();
                    break;
                } else if (ch == 'N' || ch == 'n') {
                    home();
                    break;

                } else {
                    System.out.println("Invalid Input......");
                    System.out.println("----------------------------------------------------------------------\n\n\n");
                    home();
                    break;
                }
            }

            return;
        } while (true);
    }

    // ==================================================== List Contact
    // ====================================================
    public static void ListContact() {

        clearConsole();
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("|                           SORT Contact                        |");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("");

        System.out.print(
                "\t[01] Sorting by Name\n\t[02] Sorting by Salary\n\t[03] Sorting by Birthday\n\nEnter an option to continue ->");

        char Option = input.next().charAt(0);
        clearConsole();
        clearConsole();
        SortContact(Option);

    }

    // ==================================================== Exit
    // ====================================================
    public static void Exit() {
        clearConsole();
        System.out.println("\n\n");
        System.out.println("===============Thank you for using our application===============");
        LocalTime currentTime = LocalTime.now();

        // Define morning, afternoon, and evening time ranges
        LocalTime dayStart = LocalTime.of(0, 0);
        LocalTime daygEnd = LocalTime.of(15, 59);

        // Check the current time and greet accordingly
        if (currentTime.isAfter(dayStart) && currentTime.isBefore(daygEnd)) {
            System.out.println("\n\t\t\tHave a Good day!");
        } else {
            System.out.println("\n\t\t\tGood Night...!");
        }
        String face = "\n\t\t\t     ^__^\n" +
                " \t\t\t    (^_^) \n" +
                "\t\t\t   > o.o <";
        System.out.println(face);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------\n\n\n");

        System.exit(0);

    }

}
