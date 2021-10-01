package SupportComponents;

import java.util.HashMap;
import java.util.Map;

public class MonthMapping {

    Map<Integer,String> month;

    private void setMonth(){

        month = new HashMap<Integer,String>();

        month.put(1,"January");
        month.put(2,"February");
        month.put(3,"March");
        month.put(4,"April");
        month.put(5,"May");
        month.put(6,"Jun");
        month.put(7,"July");
        month.put(8,"August");
        month.put(9,"September");
        month.put(10,"October");
        month.put(11,"November");
        month.put(12,"December");

    }
    
    // Get the Month name based on user

    public String getstringFormOfMonth(int mon){
        setMonth();
        String stringFormOfMonth = month.get(mon);
        return stringFormOfMonth;
    }
} 
