package i_date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WeekOfDays {
    public static void main(String[] args) {

        LocalDate today= LocalDate.of(2022,11,21);
        int dayNumber= getDayNumberNew(today);
        LocalDate startDate = today.minusDays(dayNumber);
        LocalDate endDate = startDate.plusDays(6);
        LocalDateTime requestStartDate=startDate.atStartOfDay();
        LocalDateTime requestEndDate=endDate.atStartOfDay();

        System.out.println(requestStartDate);
        System.out.println(requestEndDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");

        LocalTime today2 = LocalTime.now();

        String timeString = today2.format(formatter);	//12.38


    }

    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue()-1;
    }
}
