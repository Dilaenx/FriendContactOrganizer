
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