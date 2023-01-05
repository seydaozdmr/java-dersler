package i_date;

import org.joda.time.LocalDate;
import org.joda.time.YearMonth;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ExprationDay {
    public static void main(String[] args) {
        DateTimeFormatter expirationParser = DateTimeFormat.forPattern("MM/yyyy");

        String expirationString = "02/2024";

        LocalDate expirationDay = YearMonth.parse(expirationString, expirationParser)
                .plusMonths(1) // following month
                .toLocalDate(1) // day 1 of month
                .minusDays(1); // last day of expiration month

        System.out.println(expirationDay);


    }
}
