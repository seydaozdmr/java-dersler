package x_interview.flight;

import java.time.Duration;
import java.util.ArrayList;
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

    private int totalFlightDuration;


    public AreaControlCenter(String code) {
        this.code = code;
        this.airports = new ArrayList<>();
        this.readyQueue = new PriorityQueue<>();
        this.tableList=new String[1000];
    }

    public void addQueue(Flight flight){
        this.readyQueue.offer(flight);
    }

    public void run(){
        //ACC
        int duration = 30;
        while(flightNumber>0){
            Flight temp = readyQueue.poll(); //TODO poll ve offer yapısının düzeltilmesi gerekiyor
            if(!temp.isProcessing()){
                if(temp.getAdmissionTime()>=duration){
                    temp.setAdmissionTime(temp.getAdmissionTime()-duration);

                    readyQueue.offer(temp);
                    duration=30;
                }else if(temp.getAdmissionTime()>=0 && temp.getAdmissionTime() < duration){

                    duration-= temp.getAdmissionTime();
                    if(temp.getAdmissionTime()==0)
                        temp.start(); // kabul edildi ve işlenmeye başladı.
                    readyQueue.offer(temp);
                }
            }else{
                if((temp.stateNumber() < 3) || (temp.stateNumber() < 9 && temp.stateNumber() > 13) || temp.stateNumber() > 19 ){
                    if(temp.getCurrentState()>=duration){
                        temp.makeProcess(duration);
                        temp.addDurationToTotalFlight(duration);

                        readyQueue.offer(temp);
                        duration=30;
                    }else if(temp.getCurrentState()>0 && temp.getCurrentState() < duration){
                        int tempDuration = temp.getCurrentState();
                        temp.addDurationToTotalFlight(tempDuration);
                        temp.makeProcess(duration);
                        duration-=tempDuration;
                        if(temp.getCurrentState()==0)
                            temp.nextState();
                    }
                }else if(temp.stateNumber() >= 3 && temp.stateNumber()<=9){
                    temp.getLanding().getAirTrafficCenter().addQueue(temp);
                }else if(temp.stateNumber() >=13 && temp.stateNumber() <=19){
                    temp.getTakeOff().getAirTrafficCenter().addQueue(temp);
                }else if(temp.stateNumber() == 21){
                    if(flightNumber>1)
                        flightNumber--;
                    else{
                        int lastFlightTotalDuration= temp.getTotalFlight();
                        flightNumber--;
                    }
                    //Bütün uçuş bilgileriyle birlikte dosyaya yazmak üzere ayıracağız
                }
            }



            //TODO eğer tüm işlemler bitmiş ise uçuşun toplam zamanınıistatistik sınıfına yaz.

        }
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public PriorityQueue<Flight> getReadyQueue() {
        return readyQueue;
    }

    public void setReadyQueue(PriorityQueue<Flight> readyQueue) {
        this.readyQueue = readyQueue;
    }

    public String[] getTableList() {
        return tableList;
    }

    public void setTableList(String[] tableList) {
        this.tableList = tableList;
    }

    public int getTotalFlightDuration() {
        return totalFlightDuration;
    }

    public void setTotalFlightDuration(int totalFlightDuration) {
        this.totalFlightDuration = totalFlightDuration;
    }

    public void addFlightDuration(int duration){
        this.totalFlightDuration+=duration;
    }

    public void addAirPort(Airport airport) {
        this.airports.add(airport);
    }

    public void incFlightNumber() {
        this.flightNumber++;
    }
}
