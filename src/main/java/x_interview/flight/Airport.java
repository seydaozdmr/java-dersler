package x_interview.flight;


public class Airport {
    private String code;
    private AirTrafficCenter airTrafficCenter;
    private AreaControlCenter areaControlCenter;

    public Airport(String code) {
        this.code = code;
        this.airTrafficCenter = new AirTrafficCenter("AAA");
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
}
