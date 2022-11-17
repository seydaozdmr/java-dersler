package j_oop.warranty.rules;


import j_oop.warranty.states.DeviceStatus;
import j_oop.warranty.states.OperationalStatus;

public class State {
    public static RootCondition<DeviceStatus> matching(OperationalStatus status) {
        return matching(status, DeviceStatus.class);
    }

    public static RootCondition<DeviceStatus> doesNotInclude(OperationalStatus status) {
        return new InvertingCondition(
            new AppendingCondition<>(
                new StatusTypeCondition<>(DeviceStatus.class),
                new OperationalMaskCondition<>(status)));
    }

    public static <T extends DeviceStatus> RootCondition<T> matching(Class<T> stateType) {
        return new StatusTypeCondition<>(stateType);
    }

    public static RootCondition<DeviceStatus> includes(OperationalStatus status) {
        return new AppendingCondition<>(
            new StatusTypeCondition<>(DeviceStatus.class),
            new OperationalMaskCondition<>(status)
        );
    }

    public static <T extends DeviceStatus> RootCondition<T> matching(
            OperationalStatus pattern, Class<T> stateType) {
        return new AppendingCondition<>(
            new StatusTypeCondition<>(stateType),
            new OperationalCondition<>(pattern)
        );
    }
}




































