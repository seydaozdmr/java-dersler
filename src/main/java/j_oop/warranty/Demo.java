package j_oop.warranty;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Demo {
    private static void offerMoneyBack() {
        System.out.println("ürünün para iadesi yapılacaktır.");
    }

    private static void expressWarranty() {
        System.out.println("Ürünün garantisi bulunmaktadır.");
    }

    private static void offerSensorRepair() {
        System.out.println("Offer sensor replacement");
    }


    public static void claimWarranty(Article article) {
        LocalDate localDate = LocalDate.now();

        article.getExpressWarranty().on(localDate).claim(Demo::expressWarranty);

        article.getMoneyBackWarranty().on(localDate).claim(Demo::offerMoneyBack);
        article.getExtendedWarranty().on(localDate).claim(Demo::offerSensorRepair);
        System.out.println("--------------------------");

    }

    public static void main(String[] args) {
        LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        Warranty moneyBack = new TimeLimitedWarranty(sellingDate, Duration.ofDays(60));
        Warranty warranty = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        Part sensor = new Part(sellingDate);
        Warranty sensorWarranty=new TimeLimitedWarranty(sellingDate,Duration.ofDays(90));

        Article article = new Article(moneyBack, warranty).install(sensor,sensorWarranty);
        claimWarranty(article);
        claimWarranty(article.withVisibleDamage());
        claimWarranty(article.notOperational().withVisibleDamage());
        claimWarranty(article.notOperational());

        LocalDate sensorExamined = LocalDate.now().minus(2,ChronoUnit.DAYS);
        claimWarranty(article.sensorNotOperational(sensorExamined));
        claimWarranty(article.notOperational().sensorNotOperational(sensorExamined));

        Article item2 = new Article(Warranty.VOID, Warranty.lifeTime(sellingDate));
        claimWarranty(item2);
        claimWarranty(item2.withVisibleDamage().notOperational());



//        Article item3 = new Article(Warranty.lifeTime(sellingDate.minus(15, ChronoUnit.DAYS)), Warranty.lifeTime(sellingDate));
//        claimWarranty(item3);
    }

}