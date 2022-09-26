package j_oop.app.model;

import j_oop.app.service.PainterStream;

import java.time.Duration;
import java.util.List;

public interface Painter {
    boolean isAvailable();
    Duration estimateTimeToPaint(double sqMeters);
    Money estimateCompensation(double sqMeters);
    String getName();

    public static PainterStream stream(List<Painter> painters){
        return new PainterStream(painters.stream());
    }
}
