package j_oop.account.accountstates;

import j_oop.ConsumerPredicateExample;
import j_oop.account.AccountState;
import j_oop.account.AccountUnFrozen;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class NotVerified implements AccountState {
    private AccountUnFrozen onUnfrozen;

    public NotVerified(AccountUnFrozen onUnfrozen) {
        this.onUnfrozen = onUnfrozen;
    }

    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        addToBalance.accept(amount);
        return this;
    }

    @Override
    public AccountState withdraw(BigDecimal amount,BigDecimal balance,Consumer<BigDecimal> subtractFromBalance) {
        return this;
    }

    @Override
    public AccountState freezeAccount() {
        return this;
    }

    @Override
    public AccountState holderVerified() {
        return new Active(onUnfrozen);
    }

    @Override
    public AccountState closeAccount() {
        return new Closed();
    }
}
