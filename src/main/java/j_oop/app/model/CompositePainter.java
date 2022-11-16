package j_oop.app.model;

import c_stream.basics.collector.PartitioningExample;
import j_oop.app.service.ConstantVelocityScheduler;
import j_oop.app.service.PaintingScheduler;
import j_oop.app.service.WorkStream;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositePainter implements Painter{
    private List<Painter> painters;
    private PaintingScheduler scheduler;

    private CompositePainter(List<Painter> painters , PaintingScheduler scheduler) {
        this.painters = painters;
        this.scheduler=scheduler;
    }

    /**
     * Composite painter yaratılırken gelen listenin empty olup olmadığını boolean ile yönetmek yerine static of
     * methodu ile Optional bir nesne dönebilir. Böylece if else yapısından kurtuluruz.
     * @param painters
     * @param scheduler
     * @return
     */

    public static Optional<CompositePainter> of(List<Painter> painters ,PaintingScheduler scheduler){
        return painters.isEmpty() ?
                Optional.empty() :
                Optional.of(new CompositePainter(painters,scheduler));
    }

    public Optional<Painter> available(){
        return CompositePainter.of(Painter.stream(painters).available().collect(Collectors.toList()),
                        new ConstantVelocityScheduler())
                .map(Function.identity());
    }

    @Override
    public Duration estimateTimeToPaint(double sqMeters) {
        return this.scheduler.schedule(this.painters,sqMeters)
                .map(WorkAssignment::estimateTimeToPaint)
                .max(Duration::compareTo)
                .get();
    }

    @Override
    public Money estimateCompensation(double sqMeters) {
        return this.schedule(sqMeters)
                .map(WorkAssignment::estimateCompensations)
                .reduce(Money::add)
                .orElse(Money.ZERO);
    }

    private WorkStream schedule(double sqMeters){
        return this.scheduler.schedule(this.painters,sqMeters);
    }

    @Override
    public String getName() {
        return this.getPainterNames()
                .collect(Collectors.joining(", ","{ "," }"));
    }

    @Override
    public double estimateSqMeters(Duration time) {
        return Painter.stream(painters)
                .mapToDouble(painter -> painter.estimateSqMeters(time))
                .sum();
    }

    private Stream<String> getPainterNames(){
        return Painter.stream(this.painters).map(Painter::getName);
    }

    //gives area of work each painter

}
