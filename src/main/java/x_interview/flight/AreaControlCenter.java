package x_interview.flight;

import java.time.Duration;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class AreaControlCenter {
    private String code;
    private List<Airport> airports;
    private PriorityQueue<Flight> readyQueue;
    private String[] tableList;
    private int flightNumber;


    public AreaControlCenter(String code, List<Airport> airports, PriorityQueue<Flight> readyQueue) {
        this.code = code;
        this.airports = airports;
        this.readyQueue = readyQueue;
        this.tableList=new String[1000];
    }

    public void addQueue(Flight flight){
        this.readyQueue.offer(flight);
    }

    public void start(){
        int duration = 30;
        while(duration>0){
            Flight temp = readyQueue.poll();
            if(temp.getAdmissionTime()>duration){
                temp.setAdmissionTime(temp.getAdmissionTime()-duration);
                readyQueue.offer(temp);
                continue;
            }else if(temp.getAdmissionTime() > 0){
                int tempAdmission = temp.getAdmissionTime();
                temp.setAdmissionTime(0);
                duration-=tempAdmission;
                temp.getState().isProcessing();

            }

            if(temp.getState().isProcessing()){
                temp.start();
            }






        }
    }






}
