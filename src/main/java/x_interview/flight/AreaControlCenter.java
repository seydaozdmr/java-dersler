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
    private int[] tableList;
    private int flightNumber;

    private int totalFlightDuration;


    public AreaControlCenter(String code) {
        this.code = code;
        this.airports = new ArrayList<>();
        this.readyQueue = new PriorityQueue<>();
        this.tableList=new int[1000];
    }

    public void addQueue(Flight flight){
        this.readyQueue.add(flight);
    }

    public String run(){
        //ACC
        int duration = 30;
        String result = "";
        while(flightNumber>0){
            Flight temp = readyQueue.poll(); //TODO poll ve offer yapısının düzeltilmesi gerekiyor
            if(readyQueue.size()>=0 && !temp.isProcessing()){
                if(temp.getAdmissionTime()>=duration){
                    temp.setAdmissionTime(temp.getAdmissionTime()-duration);

                    readyQueue.add(temp);
                    duration=30;
                }else if(temp.getAdmissionTime()>=0 && temp.getAdmissionTime() < duration){
                    int tempTime=temp.getAdmissionTime();
                    duration-= temp.getAdmissionTime();
                    temp.setAdmissionTime(temp.getAdmissionTime()-tempTime);
                    if(temp.getAdmissionTime()==0)
                        temp.start(); // kabul edildi ve işlenmeye başladı.
                    readyQueue.add(temp);
                }
            }else{
                if((readyQueue.size()>=0) && ((temp.stateNumber() < 3) || (temp.stateNumber() > 9 && temp.stateNumber() < 13) || (temp.stateNumber() > 19 && temp.stateNumber() < 21)) ){
                    if(temp.getCurrentState()>=duration){
                        temp.makeProcess(duration);
                        temp.addDurationToTotalFlight(duration);
                        readyQueue.add(temp);
                        duration=30;
                    }else if((temp.getCurrentState()>=0) && temp.getCurrentState() < duration){
                        int tempDuration = temp.getCurrentState();
                        temp.addDurationToTotalFlight(tempDuration);
                        temp.makeProcess(tempDuration);
                        duration-=tempDuration;
                        readyQueue.add(temp);
                    }
                }else if(readyQueue.size()>=0 && temp.stateNumber() >= 3 && temp.stateNumber()<=9){
                    temp.getLanding().addQueue(temp);
                    temp.getLanding().run();
                }else if(readyQueue.size()>=0 && temp.stateNumber() >=13 && temp.stateNumber() <=19){
                    temp.getTakeOff().addQueue(temp);
                    temp.getTakeOff().run();
                }else if(readyQueue.size()>=0 && temp.stateNumber() >= 21){
                    System.out.println("İşlem bitti");
                    if(flightNumber>1)
                        flightNumber--;
                    else{
                        int lastFlightTotalDuration= temp.getTotalFlight();
                        flightNumber--;
                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append(temp.getTakeOff().getAreaControlCenter().code);
                        stringBuilder.append(" ");
                        stringBuilder.append(String.valueOf(lastFlightTotalDuration));
                        stringBuilder.append(" ");
                        for(Airport airPort:temp.getTakeOff().getAreaControlCenter().getAirports()){
                            stringBuilder.append(airPort.getCode()+airPort.getAirTrafficCenter().getCode().substring(4));
                            stringBuilder.append(" ");
                        }
                        result = stringBuilder.toString();
                    }
                    //Bütün uçuş bilgileriyle birlikte dosyaya yazmak üzere ayıracağız
                }
            }



            //TODO eğer tüm işlemler bitmiş ise uçuşun toplam zamanınıistatistik sınıfına yaz.

        }
        return result;
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

    public int findAvailableSlot(int last3digits){
        boolean flag=true;
        int result=0;
        while(flag){
            if(this.tableList[last3digits]==0){
                result = last3digits;
                tableList[last3digits] =last3digits;
                flag=false;
            }else{
                last3digits++;
            }
        }
        return result;
    }
}
