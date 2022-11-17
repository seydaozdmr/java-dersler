package j_oop.warranty;

import j_oop.warranty.states.DeviceStatus;
import j_oop.warranty.states.OperationalStatus;

import java.util.Optional;

public class StatusEqualityRule implements ClaimingRule,Action {
    private OperationalStatus pattern;
    private Runnable action;

    private StatusEqualityRule(OperationalStatus pattern, Runnable action) {
        this.pattern = pattern;
        this.action = action;
    }

    //static factory method
    public static ClaimingRule match(OperationalStatus pattern, Runnable action){
        return new StatusEqualityRule(pattern,action);
    }


    @Override
    public Optional<Action> applicableTo(DeviceStatus status) {
        return this.pattern.equals(status)
                ? Optional.of(this)
                : Optional.empty();
    }

    @Override
    public void apply() {
        this.action.run();
    }
}
