package j_oop.warranty.rules;

import j_oop.warranty.Action;
import j_oop.warranty.states.DeviceStatus;

import java.util.function.Consumer;

public class ReducedRule<T extends DeviceStatus> implements Action {
    private T status;
    private Consumer<T> action;

    public ReducedRule(T status, Consumer<T> action) {
        this.status = status;
        this.action = action;
    }

    @Override
    public void apply() {
        this.action.accept(this.status);
    }
}
































