package x_interview.flight.state;

import x_interview.flight.State;

public class TerminatedState extends State {


    public TerminatedState(String message, int duration) {
        super(message, duration);
    }

    @Override
    public State process(String message, int duration) {
        return null;
    }
}
