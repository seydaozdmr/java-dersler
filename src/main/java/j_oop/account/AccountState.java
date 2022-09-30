package j_oop.account;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {
    AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);
    AccountState withdraw(BigDecimal amount,BigDecimal balance,Consumer<BigDecimal> subtractFromBalance);
    AccountState freezeAccount();
    AccountState holderVerified();
    AccountState closeAccount();

}
