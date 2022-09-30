package j_oop.account;

import j_oop.account.accountstates.Active;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    //this account class delegates all transactions to account states
    /**
     * Eğer bir sınıf işlemleri kendisi yapmaya çalışıyorsa ve bu durum sırasında şartlara göre hareket ediyorsa
     * bu şartlar sınıf için belirli durumlarda yönetilebilecek seviyede ise bu işleri durumlara delege etmek en mantıklısı.
     * Örneğin bu hesap sınıfın hesabın dondurulmuş,kapalı,onaylanmamış hallerinde farklı davranışlar sergiliyor.
     * Bu durumları sınıftan ayırıp her birinde nasıl davranacağını farklı sınıflar üzerinden ve tek bir arayüz aracığılığı
     * ile yönetebiliriz.
     */
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
