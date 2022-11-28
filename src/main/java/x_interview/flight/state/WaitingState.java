package x_interview.flight.state;

import x_interview.flight.State;

public class WaitingState extends State {


    public WaitingState(String message, int duration) {
        super(message, duration);
    }

    @Override
    public State process(String message, int duration) {
        return null;
    }
}
