package i_date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    }

    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue()-1;
    }
}
