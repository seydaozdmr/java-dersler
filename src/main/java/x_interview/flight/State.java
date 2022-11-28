package x_interview.flight;

import x_interview.flight.state.ReadyState;

public abstract class State {
    private int duration;
    private String message;

    private String departure;
    private boolean isProcessing;

    public State(String message,int duration) {
        this.duration = duration;
        this.message = message;
    }

    public abstract State process(String message,int duration);
    public State start(){
        return new ReadyState(null,0);
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return " message";
    }



    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }

}
