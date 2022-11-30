package x_interview.flight;


public class Airport {
    private String code;
    private AirTrafficCenter airTrafficCenter;
    private AreaControlCenter areaControlCenter;

    public Airport(String code) {
        this.code = code;

    }

    public void createAirTrafficCenter()
    {
        char [] characters = code.toCharArray();
        int result=0;
        for(int i=0;i<3;i++){
            result += (int)((int) characters[i] * Math.pow(31,i));
        }
        String castString = String.valueOf(result);
        String last3digits;
        int getFreeSlot=0;
        if(castString.length()>3){
            last3digits=castString.substring(castString.length()-3);
            getFreeSlot = this.areaControlCenter.findAvailableSlot(Integer.parseInt(last3digits));
            if(getFreeSlot<100)
                last3digits = String.format("%03d",getFreeSlot);
            else
                last3digits=String.valueOf(getFreeSlot);
        }else{
            getFreeSlot = this.areaControlCenter.findAvailableSlot(result);
            last3digits = String.format("%03d",getFreeSlot);
        }

        this.airTrafficCenter = new AirTrafficCenter(this.areaControlCenter.getCode()+last3digits);
        airTrafficCenter.setAirport(this);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AirTrafficCenter getAirTrafficCenter() {
        return airTrafficCenter;
    }

    public void setAirTrafficCenter(AirTrafficCenter airTrafficCenter) {
        this.airTrafficCenter = airTrafficCenter;
    }

    public AreaControlCenter getAreaControlCenter() {
        return areaControlCenter;
    }

    public void setAreaControlCenter(AreaControlCenter areaControlCenter) {
        this.areaControlCenter = areaControlCenter;
    }

    public void run(){
        this.airTrafficCenter.run();
    }

    public void addQueue(Flight flight){
        this.airTrafficCenter.addQueue(flight);
    }
}
