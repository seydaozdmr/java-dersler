package j_oop.gumball;

public class NoQuarterState implements MachineState {
    private int count;

    public NoQuarterState(int count) {
        this.count = count;
    }

    @Override
    public MachineState insertQuarter() {
        System.out.println("A Quarter inserted..");
        return new HasQuarterState(count);
    }

    @Override
    public MachineState ejectQuarter() {
        return this;
    }

    @Override
    public MachineState turnCrank() {
        return this;
    }

    @Override
    public MachineState dispense() {
        return this;
    }

    @Override
    public void releaseGumball() {

    }
}
