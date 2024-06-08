import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class ContactValidation {

    public static int ValidatePhoneNumber(String PhoneNumber){
        if(PhoneNumber.charAt(0) == '0' & PhoneNumber.length() == 10){
            ArrayList<Contact> custList=ContactDBConnection.getInstance().getContactList();

            for(int i =0;i<custList.size();i++){
                if(custList.get(i).PhoneNumber().equals(PhoneNumber))return 0;  
            }
        }else{
            return -1;
        }
        return 1;
       
    }
    public static boolean ValidateBithdate(String Birthdate){
                LocalDate currentDate = LocalDate.now();
                int currentMonthValue = currentDate.getMonthValue();
                int currentYear = currentDate.getYear();
                int currentMonthDate = currentDate.getDayOfMonth();
                String BDay = Birthdate;
                if(BDay.length() != 10|| BDay.charAt(4) != '-' || BDay.charAt(7) != '-'){
                    return false;
                }
                else {
                    String Year = BDay.substring(0, 4);
                    String Month = BDay.substring(5, 7);
                    String day = BDay.substring(8);

                    int days = (Integer.parseInt(day));
                    int Months = (Integer.parseInt(Month));
                    int year = (Integer.parseInt(Year));
                    if (((year > currentYear) || (Months > 12)) || (days>31)) {
                        return false;

                    } else if (year == currentYear) {
                        if (Months > currentMonthValue) {
                           return false;
                        } else if (Months == currentMonthValue) {
                            if (days > currentMonthDate) {
                                return false;
                        }
                    }
                }else{
                    switch (Months) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            if (days > 31)
                                return false;
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            if (days > 30)
                               return false;
                            break;
                        case 02:
                        if(days>29){
                            return false;
                        }else if (days == 29) {
                                if (year % 400 != 0) {
                                    return false;
                                } else if ((year % 100 == 0) & (year % 4 != 0)) {
                                    return false;
                                }
                            } 
                            break;
                    }
                }
            }
            return true;
        }
    }  
                    
    