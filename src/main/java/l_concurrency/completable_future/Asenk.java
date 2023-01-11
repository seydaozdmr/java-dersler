package l_concurrency.completable_future;

import java.util.concurrent.CompletableFuture;

public class Asenk {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> first = CompletableFuture.runAsync(()->{
            System.out.println("İŞLEM -1 "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        first.thenRun(()->{
            System.out.println("İŞLEM -2 "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        first.thenRun(()->{
            System.out.println("İŞLEM -3 "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(7000);
    }
}
