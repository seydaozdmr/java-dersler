package j_oop.warranty;


import j_oop.warranty.states.DeviceStatus;
import j_oop.warranty.states.SensorFailedStatus;

import java.util.function.Consumer;

public interface ClaimingRulesBuilder {
    ClaimingRulesBuilder onMoneyBack(Consumer<DeviceStatus> action);
    ClaimingRulesBuilder onClaimExpress(Consumer<DeviceStatus> action);
    ClaimingRulesBuilder onClaimExtended(Consumer<SensorFailedStatus> action);
    ClaimingRule build();
}
