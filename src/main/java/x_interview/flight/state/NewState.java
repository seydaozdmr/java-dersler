package x_interview.flight.state;

import j_oop.gumball.SoldOutState;
import x_interview.flight.State;

public class NewState extends State {


    public NewState(String message, int duration) {
        super(message, duration);
    }

    @Override
    public State process(String message, int duration) {
        return null;
    }
}
