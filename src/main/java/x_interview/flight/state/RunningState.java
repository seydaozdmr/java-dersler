package x_interview.flight.state;

import x_interview.flight.State;

public class RunningState extends State {
    public RunningState(String message, int duration) {
        super(message, duration);
    }

    @Override
    public State process(String message, int duration) {
        return null;
    }


}
