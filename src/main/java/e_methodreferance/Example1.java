package e_methodreferance;

public class Example1 {
    public static void main(String[] args) {

        Sayable sayable=()-> System.out.println("asldjaslşd");

        Sayable sayable2=new Sayable() {
            @Override
            public void saySomething() {
                System.out.println("aslfjal");
            }
        };
        Sayable sayable1=new Sayable() {
            @Override
            public void saySomething() {

            }
        };

        sayable.saySomething();


        Sayable sayable3 = System.out::println;
        sayable3.saySomething();

//        CarService carService1=(t)-> t.getYear()<2022;
//        System.out.println(carService1.isServiceTime(LocalDate.of(2022,01,01)));

    }

    private static void doSomething(Sayable sayable){

    }

    public static void printMessage(){
        System.out.println("my message");
    }

    @FunctionalInterface
    interface Sayable{
        void saySomething();
    }
}
