package x_interview.flight.state;

import x_interview.flight.State;

public class ReadyState extends State {


    public ReadyState(String message, int duration) {
        super(message, duration);
    }

    @Override
    public State process(String message,int duration) {
        return new RunningState(message,duration);
    }
}
