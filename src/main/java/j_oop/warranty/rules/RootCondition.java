package j_oop.warranty.rules;


import j_oop.warranty.ClaimingRule;
import j_oop.warranty.states.DeviceStatus;

import java.util.Optional;
import java.util.function.Consumer;

public interface RootCondition<T extends DeviceStatus> {
    Optional<T> applicableTo(DeviceStatus status);

    default ClaimingRule applies(Consumer<T> action) {
        return new RuleFixture<>(this, action);
    }
}



































