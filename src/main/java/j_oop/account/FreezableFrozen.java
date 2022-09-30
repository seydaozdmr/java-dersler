package j_oop.account;

public class FreezableFrozen implements Freezable{

    private AccountUnFrozen onUnfrozen;
    public FreezableFrozen(AccountUnFrozen onUnfrozen){
        this.onUnfrozen = onUnfrozen;
    }
    @Override
    public Freezable deposit() {
        this.onUnfrozen.handle();
        return new FreezableActive(onUnfrozen);
    }

    @Override
    public Freezable withdraw() {
        this.onUnfrozen.handle();
        return new FreezableActive(onUnfrozen);
    }

    @Override
    public Freezable freezeAccount() {
        return this;
    }
}
