package j_oop.observer;

public class Test {
    public static void main(String[] args) {
        Employee employee=new Employee();
        AccountPayable accountPayable = new AccountPayable();

        employee.addObserver(accountPayable);
        employee.pay();
    }
}
