package l_concurrency.producer_consumer;

public class Que {
    private int n;

    public synchronized int get(){
        System.out.println("Get n :"+n);
        return this.n;
    }

    public synchronized void set(int n){
        this.n=n;
        System.out.println("Set n :"+n);
    }
}
