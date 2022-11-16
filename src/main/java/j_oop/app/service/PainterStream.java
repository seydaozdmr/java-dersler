package j_oop.app.service;

import j_oop.app.model.CompositePainter;
import j_oop.app.model.Painter;

import java.time.Duration;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PainterStream implements ForwardingStream<Painter> {

    private Stream<Painter> stream;

    public PainterStream(Stream<Painter> stream) {
        this.stream = stream;
    }

    @Override
    public Stream<Painter> getStream() {
        return this.stream;
    }

    public PainterStream available(){
        return new PainterStream(this.getStream()
                .map(Painter::available)
                .filter(Optional::isPresent)
                .map(Optional::get));
    }

    public double estimateSqMeters (Duration time){
        return this.getStream()
                .mapToDouble(painter->painter.estimateSqMeters(time))
                .sum();
    }

    public Optional<Painter> findCheapest(double sqMeter){
        return stream.min(Comparator.comparing(e->e.estimateCompensation(sqMeter)));
    }

    public Optional<Painter> workTogether(PaintingScheduler scheduler) {
        return CompositePainter.of(this.stream.collect(Collectors.toList()), scheduler)
                .map((Function.identity()));
    }
}
