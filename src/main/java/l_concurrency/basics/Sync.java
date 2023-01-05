package l_concurrency.basics;

public class Sync {
    public static void main(String[] args) {
        CallMe callMe=new CallMe();
        Caller c1=new Caller(callMe,"Hello");
        Caller c2=new Caller(callMe,"World");
        Caller c3=new Caller(callMe,"Java");

        c1.t.start();
        c2.t.start();
        c3.t.start();

        try{
            c1.t.join();
            c2.t.join();
            c3.t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
