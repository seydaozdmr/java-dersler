package l_concurrency.producer_consumer;

public class Test {

    public static void main(String[] args) {
        Que que=new Que();
        Producer p = new Producer(que);
        Consumer c=new Consumer(que);

        p.startThread();
        c.startThread();
    }
}
