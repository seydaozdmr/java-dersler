package j_oop.app.service;

import j_oop.app.model.Painter;

import java.util.Comparator;
import java.util.Optional;
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
        return new PainterStream(stream.filter(Painter::isAvailable));
    }

    public Optional<Painter> findCheapest(double sqMeter){
        return stream.min(Comparator.comparing(e->e.estimateCompensation(sqMeter)));
    }
}
