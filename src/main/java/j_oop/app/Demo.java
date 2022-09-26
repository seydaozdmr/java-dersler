package j_oop.app;

import j_oop.app.model.Money;
import j_oop.app.model.Painter;

import java.util.Comparator;
import java.util.List;

public class Demo {
    private static Painter findCheapest(double sqMeters, List<Painter> painters){
        return painters.stream()
                .filter(Painter::isAvailable)
                //.min(Comparator.comparing(painter->painter.estimateCompensation(sqMeters)))
                .reduce((acc,current)->acc.estimateCompensation(sqMeters)
                        .compareTo(current.estimateCompensation(sqMeters))<=0 ? acc:current)

                .get();
    }

    private static Money getTotalCost(double sqMeters,List<Painter> painters){
        return painters.stream()
                .filter(Painter::isAvailable)
                .reduce(Money.ZERO,(acc,painter)->painter.estimateCompensation(sqMeters).add(acc),Money::add);
    }
}
