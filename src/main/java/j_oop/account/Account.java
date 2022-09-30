package j_oop.account;

import j_oop.account.accountstates.Active;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    //this account class delegates all transactions to account states
    private AccountState accountState;



    public Account(AccountUnFrozen onUnfrozen) {
        this.balance = BigDecimal.ZERO;
        this.accountState = new Active(onUnfrozen);
    }

    public void holderVerified(){
        this.accountState = this.accountState.holderVerified();
    }

    public void closeAccount(){
        this.accountState = this.accountState.closeAccount();
    }

    public void freezeAccount(){
        this.accountState =  this.accountState.freezeAccount();
    }

    public void deposit(BigDecimal amount){
        this.accountState = this.accountState.deposit(amount, this::addToBalance);
    }

    private void addToBalance(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }


    public void withdraw(BigDecimal amount){
        this.accountState = this.accountState.withdraw(amount,balance,this::subtractBalance);
    }

    private void subtractBalance(BigDecimal amonth){
        this.balance = this.balance.subtract(amonth);
    }



}
