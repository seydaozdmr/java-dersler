package j_oop.account;

import java.math.BigDecimal;

public class Account {
    private boolean isVerified;
    private boolean isClosed;
    private BigDecimal balance;
    private AccountUnFrozen onUnFrozen;
    private EnsureUnfrozen ensureUnfrozen;



    public Account(AccountUnFrozen accountUnFrozen) {
        this.balance = BigDecimal.ZERO;
        this.ensureUnfrozen = this::stayUnfrozen;
        this.onUnFrozen=accountUnFrozen;
    }

    public void holderVerified(){
        this.isVerified=true;
    }

    public void closeAccount(){
        this.isClosed=true;
    }

    public void freezeAccount(){
        if(this.isClosed)
            return;
        if(!this.isVerified)
            return;
        this.ensureUnfrozen = this::unFreeze;
    }

    public void deposit(BigDecimal amount){
        if(this.isClosed)
            return;
        this.ensureUnfrozen.execute();
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        if(!isVerified)
            return;
        if(this.isClosed)
            return;
        this.ensureUnfrozen.execute();
        this.balance = this.balance.subtract(amount);
    }

    public void unFreeze(){
        this.onUnFrozen.handle();
        this.ensureUnfrozen = this::stayUnfrozen;
    }

    private void stayUnfrozen(){
        //this.isFrozen=true;
    }


}
