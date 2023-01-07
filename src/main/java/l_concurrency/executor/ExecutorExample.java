package l_concurrency.executor;

import l_concurrency.basics.Caller;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Runnable task=()->{
            IntStream.range(0,10).forEach(System.out::println);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Callable<String> callable=()->{
            Thread.sleep(6000);
            return "job is done";
        };


        Future<String> result = executorService.submit(callable);
        System.out.println(result.get(7000,TimeUnit.MILLISECONDS));
        //System.out.println(result.get());

        System.out.println("hi");
        //System.out.println(result.get());
//        executorService.submit(task);
//        executorService.submit(task);
//        executorService.execute(task);
        //List<Runnable> runnableList = executorService.shutdownNow();
        //System.out.println(runnableList);
        //executorService.shutdown();


    }
}
