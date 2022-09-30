package j_oop.account.accountstates;

import j_oop.account.AccountState;
import j_oop.account.AccountUnFrozen;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Active implements AccountState {
    private AccountUnFrozen onUnfrozen;

    public Active(AccountUnFrozen onUnfrozen){
        this.onUnfrozen = onUnfrozen;
    }


    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        addToBalance.accept(amount);
        return this;
    }

    @Override
    public AccountState withdraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
        if(balance.compareTo(amount)>=0)
            subtractFromBalance.accept(amount);
        return this;
    }

    @Override
    public AccountState freezeAccount() {
        //geriye dondurulmuş bir hesap döner
        return new Frozen(onUnfrozen);
    }

    @Override
    public AccountState holderVerified() {
        return this;
    }

    @Override
    public AccountState closeAccount() {
        return new Closed();
    }
}
