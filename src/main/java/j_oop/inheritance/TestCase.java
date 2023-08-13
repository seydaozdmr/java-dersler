package j_oop.inheritance;

public class TestCase {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.name = "Emre";
        employee.sayName();

        Person p1 = new Employee();
        p1.name = "Emre";
        Person p2 = new Manager();
        p2.name = "Ali";

        p1.sayName();
        p2.sayName();

        sayPersonName(p1);
        sayPersonName(p2);


    }

    private static void sayPersonName(Person person){
        person.sayName();
    }
}
