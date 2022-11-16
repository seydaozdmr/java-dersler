package j_oop.app.service;

import j_oop.app.model.Money;
import j_oop.app.model.WorkAssignment;


import java.util.stream.Stream;

public class WorkStream implements ForwardingStream<WorkAssignment> {
    private Stream<WorkAssignment> stream;

    public WorkStream(Stream<WorkAssignment> stream) {
        this.stream = stream;
    }

    @Override
    public Stream<WorkAssignment> getStream() { return this.stream; }

    public DurationStream timesToPaint() {
        return new DurationStream(this.stream.map(WorkAssignment::estimateTimeToPaint));
    }

    public  MoneyStream compensations() {
        return Money.stream(this.stream.map(WorkAssignment::estimateCompensations));
    }
}
