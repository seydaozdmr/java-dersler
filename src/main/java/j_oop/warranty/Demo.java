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


    public static void claimWarranty(Article article) {
        LocalDate localDate = LocalDate.now();

        article.getExpressWarranty().on(localDate).claim(Demo::expressWarranty);

        article.getMoneyBackWarranty().on(localDate).claim(Demo::offerMoneyBack);
        System.out.println("--------------------------");

    }

    public static void main(String[] args) {
        LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        Warranty moneyBack = new TimeLimitedWarranty(sellingDate, Duration.ofDays(60));
        Warranty warranty = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        Article article = new Article(moneyBack, warranty);
        claimWarranty(article);
        claimWarranty(article.withVisibleDamage());
        claimWarranty(article.notOperational().withVisibleDamage());
        claimWarranty(article.notOperational());

        Article item2 = new Article(Warranty.VOID, Warranty.lifeTime(sellingDate));
        claimWarranty(item2);
        claimWarranty(item2.withVisibleDamage().notOperational());


//        Article item3 = new Article(Warranty.lifeTime(sellingDate.minus(15, ChronoUnit.DAYS)), Warranty.lifeTime(sellingDate));
//        claimWarranty(item3);
    }

}