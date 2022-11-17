package j_oop.warranty;

import j_oop.warranty.rules.ExhaustiveRulesBuilder;
import j_oop.warranty.states.DeviceStatus;
import j_oop.warranty.states.OperationalStatus;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.Supplier;

public class Demo {
    private void offerMoneyBack() { System.out.println("Offer money back."); }
    private void offerRepair() { System.out.println("Offer repair."); }
    private void offerSensorRepair() { System.out.println("Offer sensor replacement."); }

    private void claimExtended(Article article, LocalDate today, Optional<LocalDate> sensorFailureDate) {
        sensorFailureDate
                .flatMap(date -> article.getExtendedWarranty().filter(date))
                .ifPresent(warranty -> warranty.on(today).claim(this::offerSensorRepair));
    }

    private void claimExpress(Article article, LocalDate today) {
        article.getExpressWarranty().on(today).claim(this::offerRepair);
    }

    private void claimMoneyBack(Article article, LocalDate today) {
        article.getMoneyBackWarranty().on(today).claim(this::offerMoneyBack);
    }

    private void claimWarranty(Supplier<ClaimingRulesBuilder> rulesBuilderFactory, Article article, DeviceStatus status) {
        LocalDate today = LocalDate.now();

        rulesBuilderFactory.get()
                .onMoneyBack(s -> this.claimMoneyBack(article, today))
                .onClaimExpress(s -> this.claimExpress(article, today))
                .onClaimExtended(s -> this.claimExtended(article, today, Optional.ofNullable(s.getFailureDetectionDate())))
                .build()
                .applicableTo(status)
                .ifPresent(action -> action.apply());

        System.out.println("--------------------");
    }

//    public void claimWarranty(Article article, OperationalStatus status) {
//        LocalDate today = LocalDate.now();
//
//        StatusEqualityRule.match(OperationalStatus.allFine(),
//                ()-> this.claimMoneyBack(article,today))
//                .orElse(StatusEqualityRule.match(OperationalStatus.notOperational(),()->{
//                    this.claimMoneyBack(article,today);
//                }))
//                .applicableTo(status)
//                .ifPresent(action->action.apply());
//
//
//        if (status.equals(OperationalStatus.allFine())) {
//            this.claimMoneyBack(article, today);
//        }
//        else if (status.equals(OperationalStatus.notOperational())) {
//            this.claimMoneyBack(article, today);
//            this.claimExpress(article, today);
//        }
//        else if (status.equals(OperationalStatus.visiblyDamaged())) {
//        }
//        else if (status.equals(OperationalStatus.sensorFailed())) {
//            this.claimMoneyBack(article, today);
//            this.claimExtended(article, today, sensorFailureDate);
//        }
//        else if (status.equals(OperationalStatus.notOperational().add(OperationalStatus.visiblyDamaged()))) {
//            this.claimExpress(article, today);
//        }
//        else if (status.equals(OperationalStatus.notOperational().add(OperationalStatus.sensorFailed()))) {
//            this.claimMoneyBack(article, today);
//            this.claimExpress(article, today);
//            this.claimExtended(article, today, sensorFailureDate);
//        }
//        else if (status.equals(OperationalStatus.visiblyDamaged().add(OperationalStatus.sensorFailed()))) {
//            this.claimExtended(article, today, sensorFailureDate);
//        }
//        else if (status.equals(OperationalStatus.notOperational().add(OperationalStatus.visiblyDamaged()).add(OperationalStatus.sensorFailed()))) {
//            this.claimExpress(article, today);
//            this.claimExtended(article, today, sensorFailureDate);
//        }
//
//        System.out.println("--------------------");
//
//    }

    public static void main(String[] args) {
        LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        Warranty moneyBack = new TimeLimitedWarranty(sellingDate, Duration.ofDays(60));
        Warranty warranty = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        Part sensor = new Part(sellingDate);
        Warranty sensorWarranty=new TimeLimitedWarranty(sellingDate,Duration.ofDays(90));

        Article article = new Article(moneyBack, warranty).install(sensor,sensorWarranty);
        Demo demo=new Demo();
        Supplier<ClaimingRulesBuilder> builderFactory = ()->new ExhaustiveRulesBuilder();


        demo.claimWarranty(builderFactory, article, DeviceStatus.allFine());


//        demo.claimWarranty(article, OperationalStatus.visiblyDamaged(), Optional.empty());
//        demo.claimWarranty(article, OperationalStatus.notOperational(), Optional.empty());
//        demo.claimWarranty(article, OperationalStatus.notOperational().add(OperationalStatus.visiblyDamaged()), Optional.empty());
//
//        LocalDate sensorExamined = LocalDate.now().minus(2, ChronoUnit.DAYS);
//        demo.claimWarranty(article, OperationalStatus.sensorFailed(), Optional.of(sensorExamined));
//        demo.claimWarranty(article, OperationalStatus.notOperational().add(OperationalStatus.sensorFailed()), Optional.of(sensorExamined));



//        Article item3 = new Article(Warranty.lifeTime(sellingDate.minus(15, ChronoUnit.DAYS)), Warranty.lifeTime(sellingDate));
//        claimWarranty(item3);
    }

}