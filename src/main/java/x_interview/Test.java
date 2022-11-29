package x_interview;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    private ExecutorService executorService;
    private PriorityBlockingQueue<Runnable> queue;

    public Test() {
        queue = new PriorityBlockingQueue<>(1000, new WorkComparator());
        this.executorService = new ThreadPoolExecutor(1,1,30, TimeUnit.SECONDS,queue);
    }

    public static void main(String[] args) {
        MyWork work1 = new MyWork("Work-1");
        MyWork work2 = new MyWork("Work-1");
        MyWork work3 = new MyWork("Work-1");
        MyWork work4 = new MyWork("Work-1");

        Test test=new Test();
        test.executorService.submit(work1);
        test.executorService.submit(work2);
        test.executorService.submit(work3);
        test.executorService.submit(work4);
    }


    private static class MyWork implements Runnable{
        String name;
        int duration = 40;
        int stateNumber;
        boolean isFinished;

        public MyWork(String name) {
            this.name = name;
        }

        public int getStateNumber() {
            return stateNumber;
        }

        @Override
        public void run() {
            try{
                System.out.println("Work-1 Started");
                int current=0;
                for(int i=0;i<duration;i++){
                    try {
                        current++;
                        System.out.print(".");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                duration-=current;
                if(duration<=0)
                    System.out.println("Work-1 ended");
            }catch (Exception e){
                System.out.println("Work-1 Interrupted");
            }
        }
    }

    private static class WorkComparator implements Comparator<Runnable>{

        @Override
        public int compare(Runnable o1, Runnable o2) {
            MyWork durationO1=(MyWork) o1;
            MyWork durationO2=(MyWork) o2;
            return durationO1.getStateNumber()-durationO2.getStateNumber();
        }
    }
}
