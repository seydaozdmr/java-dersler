package l_concurrency.basics;

public class CallMe {
    public void call(String message){
        System.out.print("["+message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("]");
    }
}
