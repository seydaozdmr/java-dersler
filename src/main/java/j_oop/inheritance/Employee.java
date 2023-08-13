package j_oop.inheritance;

public class Employee extends Person{

    @Override
    public void sayName() {
        System.out.println("Ben employee: "+name);
    }
}
