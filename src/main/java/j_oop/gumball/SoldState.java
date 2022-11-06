package j_oop.gumball;

public class SoldState implements MachineState {
    private int count;

    public SoldState(int count) {
        this.count = count;
    }

    @Override
    public MachineState insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
        return this;
    }

    @Override
    public MachineState ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
        return this;
    }

    @Override
    public MachineState turnCrank() {
        System.out.println("Turning twice doesn't give you another gumball");
        return this;
    }

    @Override
    public MachineState dispense() {
        this.releaseGumball();
        if(this.count>0)
            return new NoQuarterState(count);
        else return new SoldOutState();
    }

    @Override
    public void releaseGumball() {
        System.out.println("A gumball comes rolling out the slot");
        if(this.count>0)
            count-=1;
    }
}
