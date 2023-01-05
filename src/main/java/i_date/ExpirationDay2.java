package i_date;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ExpirationDay2 {
    public static void main(String[] args) {
        DateTimeFormatter expirationParser = DateTimeFormatter.ofPattern("MM/uuuu");

        String expirationString = "02/2024";

        LocalDate expirationDay = YearMonth.parse(expirationString, expirationParser)
                .atEndOfMonth();

        System.out.println(expirationDay);
    }
}
