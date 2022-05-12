package e_methodreferance;

public class Example2 {

    public void sayName(){
        System.out.println("ali");
    }

    public static void saySomething(){
        System.out.println("merhaba");
    }

    public static void main(String[] args) {
        Thread t = new Thread(()->saySomething());

        t.start();
        Thread t1=new Thread(()->System.out.println("asldjkalşsd"));
        t1.start();

        Thread t2=new Thread(Example2::saySomething);
        t2.start();

        Example2 example2=new Example2();
        Thread t3=new Thread(example2::sayName);
        t3.start();

    }
}
