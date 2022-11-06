package j_oop.gumball;

public class GumballMachine {
    private MachineState state;
    private int count;

    public GumballMachine(int numberGumballs) {
        if(numberGumballs>0)
            state=new NoQuarterState(count);
        else
            state= new SoldOutState();
    }

    public void insertQuarter(){
        this.state = state.insertQuarter();
    }

    public void ejectQuarter(){
        this.state = state.ejectQuarter();
    }

    public void turnCrank(){
        this.state = state.turnCrank();
        this.state = state.dispense();
    }

}
