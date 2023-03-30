package k_strings;

import j_oop.basics.B;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ParseRequest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String request = new String("Tümü".getBytes("iso-8859-1"),"UTF-8");
        System.out.println(request);

        BigDecimal result =calculatePercentage((BigDecimal.valueOf(100).subtract(BigDecimal.valueOf(99)) ),BigDecimal.valueOf(100));
        System.out.println(result);
        System.out.println(new BigDecimal(result.toPlainString()).setScale(0,RoundingMode.DOWN));


        double money = 1000.1;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(money);
        System.out.println(moneyString);

        double amount = 2015000.15;
        System.out.println(String.format("%,.2f", amount));
    }

    private static BigDecimal calculatePercentage(BigDecimal difference, BigDecimal lastPrice){
        return  new BigDecimal(difference.divide(lastPrice,2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100))
                .toPlainString()).setScale(0,RoundingMode.DOWN) ;
    }
}
