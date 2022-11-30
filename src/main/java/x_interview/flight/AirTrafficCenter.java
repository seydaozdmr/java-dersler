package x_interview.flight;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AirTrafficCenter implements Runnable{
    private String code;
    private Airport airport;
    private Queue<Flight> readyQueue;

    private boolean isFinished;

    public AirTrafficCenter(String code) {
        this.code = code;
        this.readyQueue = new ArrayDeque<>();

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Queue<Flight> getReadyQueue() {
        return readyQueue;
    }

    public void setReadyQueue(Queue<Flight> readyQueue) {
        this.readyQueue = readyQueue;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void addQueue(Flight flight){
        this.readyQueue.add(flight);
    }

    public void run(){
        while(!isFinished){
            //7 kere state arttıracak ve her bir statein süresini uçağın toplam zamanına ekleyecek
            //bitince bu uçağı geriye acc kuyruğuna gönderecek
            Flight getFromQueue = this.readyQueue.poll();
            if(getFromQueue!=null){
                for(int i=0;i<7;i++){
                    getFromQueue.addDurationToTotalFlight(getFromQueue.getCurrentState());
                    getFromQueue.makeProcess(getFromQueue.getCurrentState());
                }

                this.airport.getAreaControlCenter().addQueue(getFromQueue);
                isFinished=true;
            }
        }
        isFinished=false;
    }
}
