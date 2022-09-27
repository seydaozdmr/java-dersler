package j_oop.app;

import j_oop.app.model.*;
import j_oop.app.service.ConstantVelocityScheduler;
import j_oop.app.utils.TimeUtils;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo {
    private MoneyRate perHour(double amount) {
        return MoneyRate.hourly(new Money(new BigDecimal(amount)));
    }
    private List<Painter> createPainters(){
        return List.of(new ProportionalPainter("Koe",2.12,this.perHour(44)),
                new ProportionalPainter("Jill",4.16,this.perHour(60)),
                new ProportionalPainter("Jack",1.19,this.perHour(16)));
    }

    private List<Painter> createPainters2(){
        return List.of(new ProportionalPainter("Koe",2.12,this.perHour(44)),
                new ProportionalPainter("Jill",4.16,this.perHour(60)),
                new CompressorPainter("Jeff",Duration.ofMinutes(12),19,Duration.ofMinutes(27),9,this.perHour(70)));
    }

    private static Optional<Painter> findCheapest(double sqMeters, List<Painter> painters){
        return painters.stream()
                .min(Comparator.comparing(painter->painter.estimateCompensation(sqMeters)));
//                .reduce((acc,current)->acc.estimateCompensation(sqMeters)
//                        .compareTo(current.estimateCompensation(sqMeters))<=0 ? acc:current);
    }

    public static Optional<Painter> findCheapest2(double sqMeters,List<Painter> painters){
        return Painter.stream(painters)
                .available()
                .findCheapest(sqMeters);

    }

    private static Money getTotalCost(double sqMeters,List<Painter> painters){
        return painters.stream()
                .reduce(Money.ZERO,(acc,painter)->painter.estimateCompensation(sqMeters).add(acc),Money::add);
    }

    public void workTogether(double sqMeters,List<Painter> painters){
        Velocity groupVelocity = Painter.stream(painters).available()
                .map(e->e.estimateVelocity(sqMeters))
                .reduce(Velocity::add)
                .orElse(Velocity.ZERO);

        Painter.stream(painters).available()
                .forEach(painter -> {
                    double partialSqMeters = sqMeters * painter.estimateVelocity(sqMeters).divideBy(groupVelocity);
                    print(painter,partialSqMeters);
                });
    }

    private void print(Painter painter ,double partialSqMeters){
        Money compensation = painter.estimateCompensation(partialSqMeters);
        Duration totalTime = painter.estimateTimeToPaint(partialSqMeters);
        String formattedTime = TimeUtils.format(totalTime);

        System.out.printf(
                "Letting %s paint %.2f sq. meters during %s at total cost %s\n",
                painter.getName(), partialSqMeters, formattedTime, compensation);
    }

    public static void main(String[] args) {
        Demo demo= new Demo();
        demo.workTogether(200,demo.createPainters());

        System.out.println("***********");
        List<Painter> painters = demo.createPainters();
        Painter group1=CompositePainter.of(painters,new ConstantVelocityScheduler()).get();

        demo.print(group1,200);

        System.out.println("*************");
        List<Painter> painters1=demo.createPainters2();
        demo.workTogether(200,painters1);

        System.out.println("*************");
        Painter group2=CompositePainter.of(painters1,new ConstantVelocityScheduler()).get();
        demo.print(group2,200);

    }


}
