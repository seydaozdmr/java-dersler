package j_oop.app.model;

import java.time.Duration;
import java.util.Optional;

public class ProportionalPainter implements Painter{
    private String name;
    private double sqMetersPerHour;
    private MoneyRate rate;

    public ProportionalPainter(String name, double sqMetersPerHour, MoneyRate rate) {
        this.name = name;
        this.sqMetersPerHour = sqMetersPerHour;
        this.rate = rate;
    }


    @Override
    public Optional<Painter> available() {
        return Optional.of(this);
    }

    @Override
    public Duration estimateTimeToPaint(double sqMeters) {
        return Duration.ofSeconds(this.getSecondsToPaint(sqMeters));
    }
    private int getSecondsToPaint(double sqMeters){
        return (int) (sqMeters/this.sqMetersPerHour*3600);
    }

    @Override
    public Money estimateCompensation(double sqMeters) {
        return this.rate.getTotalFor(this.estimateTimeToPaint(sqMeters));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double estimateSqMeters(Duration time) {
        return this.sqMetersPerHour * (time.getSeconds() / (double) 3600);
    }
}
