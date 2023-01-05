package l_concurrency.producer_consumer;

public class Consumer implements Runnable{
    private Que que;
    private Thread t;

    public Consumer(Que que){
        this.que=que;
        this.t=new Thread(this,"Consumer");
    }

    @Override
    public void run() {
        while(true){
            que.get();
        }
    }

    public void startThread(){
        this.t.start();
    }
}
