import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

class ContactList {
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

   public void sortByName(){
    Node temp = front;
    Node temp2 = front;
    while(temp!=null){
        temp2 = temp.next;
        while(temp2!=null){
            if(temp.Contact.Name().compareTo(temp2.Contact.Name())>0){
                Contact temp3 = temp.Contact;
                temp.Contact = temp2.Contact;
                temp2.Contact = temp3;
            }
            temp2 = temp2.next;
        }
        temp = temp.next;
    }
   }
   public void sortBySalary(){
    Node temp = front;
    Node temp2 = front;
    while(temp!=null){
        temp2 = temp.next;
        while(temp2!=null){
            if(temp.Contact.Salary()>temp2.Contact.Salary()){
                Contact temp3 = temp.Contact;
                temp.Contact = temp2.Contact;
                temp2.Contact = temp3;
            }
            temp2 = temp2.next;
        }
        temp = temp.next;
    }
   }
   public void sortByBirthday(){
    Node temp = front;
    Node temp2 = front;
    while(temp!=null){
        temp2 = temp.next;
        while(temp2!=null){
            if(temp.Contact.Birthday().compareTo(temp2.Contact.Birthday())>0){
                Contact temp3 = temp.Contact;
                temp.Contact = temp2.Contact;
                temp2.Contact = temp3;
            }
            temp2 = temp2.next;
        }
        temp = temp.next;
    }

    
   }
   public void printSort(){
    Node temp = front;
    System.out.println(
                    "+--------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %-13s|        %-12s|\n",
                    "Contact Id",
                    "Name", "Phone Number", "Company", "Salary", "Birthday");
            System.out.println(
                    "+--------------------------------------------------------------------------------------------------------------------+");

               while(temp!=null){
                System.out.printf("|  %-14s|      %-10s|    %-15s|      %-14s|       %,-13.2f|        %-12s|\n",
                        
                temp.Contact.id(),
                temp.Contact.Name(),
                temp.Contact.PhoneNumber(),
                temp.Contact.CompanyName(),
                temp.Contact.Salary(),
                temp.Contact.Birthday());

        temp=temp.next;
               }
            
        
            System.out.println(
                    "+--------------------------------------------------------------------------------------------------------------------+");


}
  
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
    

}

public class IFriendContactOrganizer {
   

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

    
    public static void SortContact(char Option) {
        Scanner input = new Scanner(System.in);
        if (cList.isNull()) {

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
                cList.sortByName();
                // String[] AssendingContactArray = new String[ContactList.GetIndex()];
                // String[] DuplicateContactArray = new String[ContactList.GetIndex()];
                cList.printSort();
                
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
            
            case '2': {
                System.out.println("\t\t\t+-----------------------------------------------------------------+");
                System.out.println("\t\t\t|                     List contact by Salary                      |");
                System.out.println("\t\t\t+-----------------------------------------------------------------+");
                cList.sortBySalary();
                cList.printSort();
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

            case '3': {
                System.out.println("\t\t\t+-----------------------------------------------------------------+");
                System.out.println("\t\t\t|                    List contact by Birthday                     |");
                System.out.println("\t\t\t+-----------------------------------------------------------------+");
                cList.sortByBirthday();
                cList.printSort();
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

            String MemberId = cList.MemberIdGenarate2();

        
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
       do {
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
         do {
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
            if (cList.nextIsNull()) {
                cList.DisplayMember(0);
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

            int FindMember = cList.FindMember(contact);
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
                cList.DisplayMember(FindMember);
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
