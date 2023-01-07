package l_concurrency.executor;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduled {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.schedule(()-> System.out.println("Started at :"+ LocalTime.now()),10, TimeUnit.SECONDS);
    }
}
