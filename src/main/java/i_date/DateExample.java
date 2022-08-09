package i_date;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.logging.Logger;

public class DateExample {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        LocalDate nextYear=LocalDate.of(2023,8,9);
        localDate= localDate.plusDays(1);
        nextYear=nextYear.plusDays(10);
        var date=LocalDate.of(2022, Month.AUGUST,9);
        date = date.plusDays(10);
        System.out.println(date);
        System.out.println(nextYear);
        System.out.println(localDate);
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println(zonedDateTime);




        for(int j=1;j<=12;j++){
            YearMonth yearMonth=YearMonth.of(2022,j);
            System.out.println(yearMonth.getMonth());
            int day=1;
            for(int i=1;i<=6;i++){
                for(int k=1;k<=7;k++){
                    if(day>yearMonth.lengthOfMonth())
                        break;
                    LocalDate firstDayOfMonth= LocalDate.of(2022,j,day);
                    if(k==firstDayOfMonth.getDayOfWeek().getValue()){
                        if(firstDayOfMonth.equals(LocalDate.now()))
                            System.out.printf(ANSI_RED + "%2d ",day++);
                        System.out.printf(ANSI_RESET + "%2d ",day++);
                    }else {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
