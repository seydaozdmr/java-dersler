package j_oop.app;

import j_oop.app.model.Money;
import j_oop.app.model.Painter;
import j_oop.app.model.Velocity;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo {
    private static Optional<Painter> findCheapest(double sqMeters, List<Painter> painters){
        return painters.stream()
                .filter(Painter::isAvailable)
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
                .filter(Painter::isAvailable)
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
                    Money partialCost = painter.estimateCompensation(partialSqMeters);
                    Duration partialTime = painter.estimateTimeToPaint(partialSqMeters);
                });
    }
}
