package k_strings;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MoneyFormat {
    public static void main(String[] args) {
        System.out.println(changeMoney(new BigDecimal(Double.valueOf("1000.0"))));
    }

    private static String changeMoney(BigDecimal price){
        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(symbols);
        df.setMinimumFractionDigits(2);
        return df.format(price);
    }
}
