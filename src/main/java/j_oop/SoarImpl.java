package j_oop;

public class SoarImpl implements Soar,AnotherSoar {

    //If a class inherits two or more default methods with the same method signature, then the
    //class must override the method.
    @Override
    public void fly(int speed) {
        //direkt ulaşabiliyouz.
        System.out.println(Soar.MAX_HEIGHT);
    }

    @Override
    public void takeoff() {
        Soar.super.getMaxHeight();
        System.out.println(getMaxHeight());
    }

    @Override
    public double dive() {
        return 0;
    }

    @Override
    public int getMaxHeight() {
        return AnotherSoar.super.getMaxHeight();
    }
}
