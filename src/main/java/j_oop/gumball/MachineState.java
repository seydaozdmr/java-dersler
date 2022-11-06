package j_oop.gumball;


public interface MachineState {
    MachineState insertQuarter();
    MachineState ejectQuarter();
    MachineState turnCrank();
    MachineState dispense();
    void releaseGumball();
}
