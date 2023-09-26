package j_oop.defaultMethods;

public class Frog implements Walk,Swim{

    @Override
    public void move() {
        Swim.super.move();
        System.out.println();
        Walk.super.move();
    }
}
