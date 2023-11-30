package p_big_decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageExample {
    public static void main(String[] args) {
        System.out.println(calculatePercentage(BigDecimal.TEN,BigDecimal.valueOf(100)));
    }

    private static BigDecimal calculatePercentage(BigDecimal difference, BigDecimal lastPrice){
        return  new BigDecimal(difference.divide(lastPrice,2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100))
                .toPlainString()).setScale(0,RoundingMode.DOWN) ;
    }
}
