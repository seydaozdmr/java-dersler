package l_concurrency.basics;

public class Caller implements Runnable{
    public CallMe target;
    public String message;
    public Thread t;

    public Caller(CallMe target, String message) {
        this.target = target;
        this.message = message;
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        target.call(message);
    }
}
