package j_oop.gumball;

public class HasQuarterState implements MachineState{
    private int count;

    public HasQuarterState(int count) {
        this.count = count;
    }

    @Override
    public MachineState insertQuarter() {
        System.out.println("in this state if you want to insert coin nothing will be done, a coin has already inserted.");
        return this;
    }

    @Override
    public MachineState ejectQuarter() {
        System.out.println("Quarter returned. We give money back customer");
        return new NoQuarterState(count);
    }

    @Override
    public MachineState turnCrank() {
        System.out.println("Your turned..");
        return new SoldState(count);
    }

    @Override
    public MachineState dispense() {
        System.out.println("No gumball dispensed");
        return this;
    }

    @Override
    public void releaseGumball() {
        //Bu durumda bu method hiç bir şey yapmaz...
    }
}
