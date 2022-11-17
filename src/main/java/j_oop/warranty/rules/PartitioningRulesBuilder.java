package j_oop.warranty.rules;

import j_oop.warranty.ClaimingRule;
import j_oop.warranty.ClaimingRulesBuilder;
import j_oop.warranty.states.DeviceStatus;
import j_oop.warranty.states.OperationalStatus;
import j_oop.warranty.states.SensorFailedStatus;

import java.util.function.Consumer;

public class PartitioningRulesBuilder implements ClaimingRulesBuilder {
    private Consumer<DeviceStatus> moneyBackAction = s -> { };
    private Consumer<DeviceStatus> expressAction = s -> { };
    private Consumer<SensorFailedStatus> extendedAction = s -> { };

    @Override
    public ClaimingRulesBuilder onMoneyBack(Consumer<DeviceStatus> action) {
        this.moneyBackAction = action;
        return this;
    }

    @Override
    public ClaimingRulesBuilder onClaimExpress(Consumer<DeviceStatus> action) {
        this.expressAction = action;
        return this;
    }

    @Override
    public ClaimingRulesBuilder onClaimExtended(Consumer<SensorFailedStatus> action) {
        this.extendedAction = action;
        return this;
    }

    @Override
    public ClaimingRule build() {
        return this.moneyBackRule()
            .with(this.expressRule())
            .with(this.extendedRule());
    }

    private ClaimingRule moneyBackRule() {
        return State.doesNotInclude(
            OperationalStatus.visiblyDamaged()).applies(
            this.moneyBackAction);
    }

    private ClaimingRule expressRule() {
        return State.includes(
            OperationalStatus.notOperational()).applies(
            this.expressAction);
    }

    private ClaimingRule extendedRule() {
        return State.matching(
            SensorFailedStatus.class).applies(
            this.extendedAction);
    }
}
