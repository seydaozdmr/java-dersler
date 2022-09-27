package j_oop.app.service;

import j_oop.app.model.Painter;
import j_oop.app.model.WorkAssignment;

import java.util.List;
import java.util.stream.Stream;

public interface PaintingScheduler {
    Stream<WorkAssignment> schedule (List<Painter> painters, double sqMeters);

}
