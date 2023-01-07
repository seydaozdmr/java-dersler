package l_concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class WaitForFinish {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= null;

        try{
            executorService= Executors.newSingleThreadExecutor();
            executorService.submit(()-> IntStream.range(0,50).forEach(System.out::println));//Bu iş 1 milisaniye sürüyor
            executorService.submit(()-> {
                IntStream.range(0,50).forEach(System.out::println);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }finally {
            if(executorService!=null) executorService.shutdown();
        }
        if(executorService!=null){
            executorService.awaitTermination(2001, TimeUnit.MILLISECONDS);

            if(executorService.isTerminated()) System.out.println("finished");
            else System.out.println("At least 1 task is running");
        }
    }
}
