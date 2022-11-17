package Basics;

public class Demo {
    public static void main(String[] args) {
        Course math=new Course();
        math.name = "Math";
        math.credits = 10;
        Course cs=new Course();
        cs.setName("kuntay");
        cs.setCredits(1);

        System.out.println(cs.getCredits());
        System.out.println(cs.getName());

    }
}
