package l_concurrency.producer_consumer;

public class Producer implements Runnable{
    private Que que;
    private Thread t;

    public Producer(Que que) {
        this.que = que;
        t = new Thread(this,"Producer");
    }


    @Override
    public void run() {
        int i=0;
        while(true){
            que.set(i++);
        }
    }

    public void startThread(){
        this.t.start();
    }
}
