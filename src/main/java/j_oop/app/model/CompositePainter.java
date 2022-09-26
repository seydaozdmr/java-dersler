package j_oop.app.model;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositePainter implements Painter{
    private List<Painter> painters;

    public CompositePainter(List<Painter> painters) {
        this.painters = painters;
    }

    @Override
    public boolean isAvailable() {
        return Painter.stream(painters).anyMatch(Painter::isAvailable);
    }

    @Override
    public Duration estimateTimeToPaint(double sqMeters) {
        return estimateTimeToPaint(sqMeters,estimateTotalVelocity(sqMeters));
    }
    private Duration estimateTimeToPaint(double sqMeters,Velocity totalVelocity){
        return Painter.stream(this.painters)
                .available()
                .map(painter ->painter.estimateTimeToPaint(sqMeters *  painter.estimateVelocity(sqMeters).divideBy(totalVelocity)))
                .max(Duration::compareTo)
                .get();
    }

    private Velocity estimateTotalVelocity(double sqMeters){
        return Painter.stream(this.painters)
                .available()
                .map(painter -> painter.estimateVelocity(sqMeters))
                .reduce(Velocity::add)
                .orElse(Velocity.ZERO);
    }

    @Override
    public Money estimateCompensation(double sqMeters) {
        return this.estimateCompensation(sqMeters,this.estimateTotalVelocity(sqMeters));
    }
    private Money estimateCompensation(double sqMeters,Velocity totalVelocity){
        return Painter.stream(this.painters)
                .available()
                .map(painter -> painter.estimateCompensation(sqMeters*painter.estimateVelocity(sqMeters).divideBy(totalVelocity)))
                .reduce(Money::add)
                .orElse(Money.ZERO);
    }

    @Override
    public String getName() {
        return this.getPainterNames().collect(Collectors.joining(", ","{ "," }"));
    }

    private Stream<String> getPainterNames(){
        return Painter.stream(this.painters).map(Painter::getName);
    }
}
