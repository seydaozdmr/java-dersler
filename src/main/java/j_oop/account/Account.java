package j_oop.account;

import java.math.BigDecimal;

public class Account {
    private boolean isVerified;
    private boolean isClosed;
    private boolean isFrozen;
    private BigDecimal balance;
    private AccountUnFrozen onUnFrozen;


    public Account(AccountUnFrozen accountUnFrozen) {
        this.balance = BigDecimal.ZERO;
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
        this.isFrozen=true;
    }

    public void deposit(BigDecimal amount){
        if(this.isClosed)
            return;
        if(this.isFrozen){
            this.isFrozen = false;
            this.onUnFrozen.handle();
        }
        this.balance = this.balance.add(amount);


    }

    public void withdraw(BigDecimal amount){
        if(!isVerified)
            return;
        if(this.isClosed)
            return;
        if(this.isFrozen){
            this.isFrozen = false;
            this.onUnFrozen.handle();
        }
        this.balance = this.balance.subtract(amount);
    }

    private void ensureUnFrozen(){
        if(!this.isFrozen)
            return;
        this.isFrozen=false;
        this.onUnFrozen.handle();

    }


}
