package l_concurrency.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureBase {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> start =CompletableFuture.supplyAsync(()->{
            System.out.println("1.İŞLEM BAŞLADI");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "success";
        });
        start.thenApply(e->{
            if(e.equals("success")){
                System.out.println("2.İŞLEM BAŞLADI");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                return "success";
            }else{
                System.out.println("FAİL");
                return "fail";
            }

        });

        start.thenApply(e->{
            if(e.equals("success")){
                System.out.println("3.İŞLEM BAŞLADI");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                return "success";
            }else{
                System.out.println("FAİL");
                return "fail";
            }
        });


       start.thenRun(()->{
            System.out.println("SON İŞLEM");
        });

        Thread.sleep(10000);

    }
}
