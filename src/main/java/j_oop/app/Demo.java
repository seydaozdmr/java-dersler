package j_oop.app;

import j_oop.app.model.Money;
import j_oop.app.model.Painter;

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
}
