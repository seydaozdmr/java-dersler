package j_oop.gumball;

public class WinnerState implements MachineState{
    private int count;

    public WinnerState(int count) {
        this.count = count;
    }

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
        this.releaseGumball();
        if(count==0)
            return new SoldOutState();
        else{
            this.releaseGumball();
            System.out.println("You're a winner! You got two gumballs for your quarter");
            if(count>0)
                return new NoQuarterState(count);
            else
                return new SoldOutState();
        }
    }

    @Override
    public void releaseGumball() {
        System.out.println("A gumball comes rolling out the slot");
        if(this.count>0)
            count-=1;
    }
}
