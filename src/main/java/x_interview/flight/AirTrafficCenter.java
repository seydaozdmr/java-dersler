package x_interview.flight;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AirTrafficCenter {
    private String code;
    private Airport airport;
    private Queue<Flight> readyQueue;

    public AirTrafficCenter(String code, Queue<Flight> readyQueue) {
        this.code = code;
        this.readyQueue = readyQueue;

    }


}
