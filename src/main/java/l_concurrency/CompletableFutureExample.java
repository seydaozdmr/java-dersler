package l_concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            executionThread1();
            sleep(2000);

            return "Educative";
        });
        //Burada birinci işlem bitince ikinciyi execute ediyoruz...
        Consumer<String> consumer = res -> {
            executionThread2();
            System.out.println("Future result - " + res);
        };

        completableFuture.thenAcceptAsync(consumer);
        sleep(2000);
        Thread.currentThread().join();
    }

    static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void executionThread1(){
        System.out.println("Thread execution - " + Thread.currentThread().getName());
    }

    static void executionThread2(){
        System.out.println("Thread execution - 2 " + Thread.currentThread().getName());
    }
}
