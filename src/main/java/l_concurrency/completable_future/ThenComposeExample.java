package l_concurrency.completable_future;

import java.util.concurrent.CompletableFuture;

public class ThenComposeExample {
    public static void main(String[] args) {
        CompletableFuture<Void> first= CompletableFuture.runAsync(()->{
            System.out.println("İŞLEM -1 ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Void> second=first.thenCompose(elem->
            CompletableFuture.runAsync(()->{
                System.out.println("İŞLEM -2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            })
        );

        second.thenRun(()->{
            System.out.println("İŞLEM -3");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
