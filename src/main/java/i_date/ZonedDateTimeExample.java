package i_date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {

    public static void main(String[] args)
    {
        // getting current date
        LocalDate date = LocalDate.of(2023,9,15);

        // getting current time
        LocalTime time = LocalTime.now();

        // getting system default zone id
        ZoneId zoneId = ZoneId.systemDefault();

        // creating a new ZonedDateTime object
        ZonedDateTime zonedatetime
                = ZonedDateTime.of(date, time, zoneId);
        zonedatetime = zonedatetime.minusDays(5);
        System.out.println(zonedatetime);
    }
}
