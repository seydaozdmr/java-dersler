package j_oop.warranty;

import java.util.Arrays;

public class DeviceStatus {
    public static final DeviceStatus ALL_FINE = new DeviceStatus(0);
    public static final DeviceStatus NOT_OPERATIONAL = new DeviceStatus(1);
    public static final DeviceStatus VISIBILITY_DAMAGED = new DeviceStatus(2);
    public static final DeviceStatus SENSOR_FAILED = new DeviceStatus(4);
    public static final DeviceStatus NOT_OPERATIONAL_DAMAGED = combine(NOT_OPERATIONAL,VISIBILITY_DAMAGED);
    public static final DeviceStatus NOT_OPERATIONAL_SENSOR_FAILED = combine(NOT_OPERATIONAL,SENSOR_FAILED);
    public static final DeviceStatus DAMAGED_SENSOR_FAILED = combine(VISIBILITY_DAMAGED,SENSOR_FAILED);
    public static final DeviceStatus NOT_OPERATIONAL_DAMAGED_SENSOR_FAILED = combine(NOT_OPERATIONAL,VISIBILITY_DAMAGED,SENSOR_FAILED);

    private static DeviceStatus combine (DeviceStatus... statuses){
        return new DeviceStatus(Arrays.stream(statuses).mapToInt(status->status.id).reduce(0,(a,b)-> a|b));
    }
    private final int id;

    public DeviceStatus(int id) {
        this.id = id;
    }



}
