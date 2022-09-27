package j_oop.app.service;

import java.time.Duration;
import java.util.stream.Stream;

public class DurationStream implements ForwardingStream<Duration>{
    private Stream<Duration> stream;

    public DurationStream(Stream<Duration> durations){
        this.stream=durations;
    }

    public Stream<Duration> getStream(){
        return this.stream;
    }

    public Duration maxOfMany(){
        return this.stream.max(Duration::compareTo).get();
    }
}
