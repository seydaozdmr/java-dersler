package j_oop.warranty;

import j_oop.warranty.rules.WithRule;
import j_oop.warranty.states.DeviceStatus;
import j_oop.warranty.states.OperationalStatus;

import java.util.Optional;

public interface ClaimingRule {
    Optional<Action> applicableTo(DeviceStatus status);

    default ClaimingRule orElse(ClaimingRule next){
        return new ChainedRule(this,next);
    }

    default ClaimingRule with(ClaimingRule other) {
        return new WithRule(this, other);
    }

}
