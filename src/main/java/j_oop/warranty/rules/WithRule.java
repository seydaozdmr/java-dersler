package j_oop.warranty.rules;

import j_oop.warranty.Action;
import j_oop.warranty.ClaimingRule;
import j_oop.warranty.states.DeviceStatus;

import java.util.Optional;

public class WithRule implements ClaimingRule {
    private ClaimingRule first;
    private ClaimingRule second;

    public WithRule(ClaimingRule first, ClaimingRule second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Optional<Action> applicableTo(DeviceStatus status) {
        return first.applicableTo(status)
            .map(firstAction -> this.applicableToFirst(firstAction, status))
            .orElse(this.second.applicableTo(status));
    }

    private Optional<Action> applicableToFirst(Action firstAction, DeviceStatus status) {
        return second.applicableTo(status)
            .map(secondAction -> Optional.of(this.both(firstAction, secondAction)))
            .orElse(Optional.of(firstAction));
    }

    private Action both(Action first, Action second) {
        return new Action() {
            @Override
            public void apply() {
                first.apply();
                second.apply();
            }
        };
    }
}
