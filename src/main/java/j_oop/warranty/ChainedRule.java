package j_oop.warranty;

import j_oop.warranty.states.DeviceStatus;
import j_oop.warranty.states.OperationalStatus;

import java.util.Optional;

public class ChainedRule implements ClaimingRule{
    private ClaimingRule head;
    private ClaimingRule tail;

    public ChainedRule(ClaimingRule head, ClaimingRule tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Optional<Action> applicableTo(DeviceStatus status) {
        return this.head
                .applicableTo(status)
                .map(Optional::of)
                .orElse(tail.applicableTo(status));
    }
}
