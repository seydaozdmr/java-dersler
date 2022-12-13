package i_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConvert {
    public static final String DATE_FORMAT_MONTH_DAY_YEAR_WITH_SLASH = "MM/dd/yyyy";
    public static void main(String[] args) {
        Date result = parseStringtoDate("12/22/2021 11:10:20 PM",DATE_FORMAT_MONTH_DAY_YEAR_WITH_SLASH);
        System.out.println(result);
    }

    public static Date parseStringtoDate(String value, String format)
    {


        //String parsableDate = value.substring(0, value.indexOf(' '));
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        try {
            return dateFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }


    }
}
