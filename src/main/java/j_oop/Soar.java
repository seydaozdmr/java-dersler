package j_oop;

public interface Soar {
    int MAX_HEIGHT=10; //public static final

    final static boolean UNDERWATER=true;
    void fly(int speed); //abstract
    abstract void takeoff();
    public abstract double dive();

    default int getMaxHeight(){
        return MAX_HEIGHT;
    }
}
