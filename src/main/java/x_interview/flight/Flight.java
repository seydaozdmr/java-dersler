package x_interview.flight;

import x_interview.flight.state.NewState;

public class Flight implements Comparable<Flight> {
    private String flightCode;
    private State state;
    private int admissionTime;
    private int [] processTimes;
    private Airport landing;
    private Airport takeOff;
    private int totalFlight;
    private int stateNumber;

    public Flight(String flightCode, int admissionTime, int[] processTimes, Airport landing, Airport takeOff) {
        this.flightCode = flightCode;
        this.admissionTime = admissionTime;
        this.processTimes = processTimes;
        this.landing = landing;
        this.takeOff = takeOff;
        this.state=new NewState(null,0);
    }

    public Flight() {
        this.state=new NewState(null,0);
    }


    @Override
    public int compareTo(Flight o) {
        if(!this.state.isProcessing() && !o.state.isProcessing())
            return this.flightCode.compareTo(o.flightCode);
        else if(this.state.isProcessing() && !o.state.isProcessing())
            return -1;
        return 1;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(int admissionTime) {
        this.admissionTime = admissionTime;
    }

    public int[] getProcessTimes() {
        return processTimes;
    }

    public void setProcessTimes(int[] processTimes) {
        this.processTimes = processTimes;
    }

    public Airport getLanding() {
        return landing;
    }

    public void setLanding(Airport landing) {
        this.landing = landing;
    }

    public Airport getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(Airport takeOff) {
        this.takeOff = takeOff;
    }

    public int getTotalFlight() {
        return totalFlight;
    }

    public void setTotalFlight(int totalFlight) {
        this.totalFlight = totalFlight;
    }


    public void start(){
        this.state=this.state.start();
    }
}
