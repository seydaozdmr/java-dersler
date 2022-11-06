package j_oop.gumball;

public class SoldOutState implements MachineState {
    @Override
    public MachineState insertQuarter() {
        return this;
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
