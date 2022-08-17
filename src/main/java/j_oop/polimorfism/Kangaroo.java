package j_oop.polimorfism;

public class Kangaroo extends Marsupial{
    protected int age = 6;
    public static boolean isBiped() {
        return true;
    }

    public boolean isBiped2() {
        return true;
    }
    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        Marsupial moey = joey;
        System.out.println(joey.isBiped());
        System.out.println(moey.isBiped());
        System.out.println(joey.age);
        System.out.println(moey.age);
        System.out.println(joey.isBiped2());
        System.out.println(moey.isBiped2());
    }}
