package j_oop.account;

public class FreezableActive implements Freezable{
    private AccountUnFrozen onUnfrozen;

    public FreezableActive (AccountUnFrozen onUnfrozen){
        this.onUnfrozen = onUnfrozen;
    }
    @Override
    public Freezable deposit() {
        return this;
    }

    @Override
    public Freezable withdraw() {
        return this;
    }

    @Override
    public Freezable freezeAccount() {
        //geriye dondurulmuş bir hesap döner
        return new FreezableFrozen(onUnfrozen);
    }
}
