class Contact1 {
    private String MemberId;
    private String Name;
    private String PhoneNumber;
    private String CompanyName;
    private double Salary;
    private String Birthday;
   

    Contact1(String MemberId, String Name, String PhoneNumber, String CompanyName, double Salary, String Birthday) {
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