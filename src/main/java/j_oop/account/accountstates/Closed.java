package j_oop.account.accountstates;

import j_oop.account.AccountState;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Closed implements AccountState {
    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        return this;
    }

    @Override
    public AccountState withdraw(BigDecimal amount, BigDecimal balance, Consumer<BigDecimal> subtractFromBalance) {
        return this;
    }

    @Override
    public AccountState freezeAccount() {
        return this;
    }

    @Override
    public AccountState holderVerified() {
        return this;
    }

    @Override
    public AccountState closeAccount() {
        return this;
    }
}
