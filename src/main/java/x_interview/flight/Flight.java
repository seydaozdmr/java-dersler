package x_interview.flight;

import java.util.ArrayDeque;

public class Flight implements Comparable<Flight> {
    private String flightCode;
    private int [] states;
    private int currentState=0;
    private int admissionTime;
    private Airport landing;
    private Airport takeOff;
    private int totalFlight;
    private boolean isProcessing;
    private FlightMode flightMode;

    public Flight(String flightCode){
        this.flightCode= flightCode;
        this.states = new int[21];
    }

    public Flight(String flightCode, int admissionTime, Airport landing, Airport takeOff) {
        this.flightCode = flightCode;
        this.states = new int[21];
        this.admissionTime = admissionTime;
        this.landing = landing;
        this.takeOff = takeOff;
        this.totalFlight = 0;
    }

    /**
     * PriorityQueue'nun önceliği belirlemesi için iki koşul var
     * birisi uçuşların ikisi de yeniyse uçuş kodlarından küçük olan öncelikli
     * diğeri eğer diğer uçuş yeniyse öncelik ona ait.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Flight o) {
        if(!this.isProcessing && !o.isProcessing)
            return this.flightCode.compareTo(o.flightCode);
        else if(this.isProcessing && !o.isProcessing)
            return -1;
        return 1;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }


    public int getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(int admissionTime) {
        this.admissionTime = admissionTime;
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


    public void addDurationToTotalFlight(int duration) {
        this.totalFlight+=duration;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }


    public int getCurrentState(){ //current statein süresi
        return this.states[currentState];
    }

    //Sıradaki state'e geçmek için-process bittiğinde sıraki state'e geçmeliyiz.
    public void nextState(){
        currentState++;
    }

    public void makeProcess(int duration) {
        this.states[currentState] = this.states[currentState] - duration;
    }

    public void start() {
        this.isProcessing = true;
    }

    public int stateNumber(){
        return this.states.length;
    }

    public int[] getStates() {
        return states;
    }

    public void setStates(int[] states) {
        this.states = states;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public FlightMode getFlightMode() {
        return flightMode;
    }

    public void setFlightMode(FlightMode flightMode) {
        this.flightMode = flightMode;
    }

    public void addState(int state){
        this.states[currentState++] = state;
    }

    public enum FlightMode{
        DEPARTURE,LANDING
    }
}
