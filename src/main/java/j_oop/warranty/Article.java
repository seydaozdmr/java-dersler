package j_oop.warranty;

public class Article {
    private Warranty moneyBackWarranty;
    private Warranty expressWarranty;

    private Warranty effectiveExpressWarranty = Warranty.VOID;

    public Article(Warranty moneyBackWarranty, Warranty expressWarranty) {
        this(moneyBackWarranty,expressWarranty,Warranty.VOID);
    }

    private Article (Warranty moneyBackWarranty,Warranty expressWarranty,Warranty effectiveExpressWarranty) {
        if(moneyBackWarranty == null) throw new IllegalArgumentException("not null");
        if(expressWarranty ==null) throw new IllegalArgumentException("not null");
        this.moneyBackWarranty = moneyBackWarranty;
        this.expressWarranty = expressWarranty;
        this.effectiveExpressWarranty = effectiveExpressWarranty;
    }

    public Warranty getMoneyBackWarranty() {
        return moneyBackWarranty;
    }

    public Warranty getExpressWarranty() {
        return effectiveExpressWarranty;
    }

    public Article withVisibleDamage(){
        return new Article(Warranty.VOID,this.expressWarranty,this.effectiveExpressWarranty);
    }

    public Article notOperational(){
        return new Article(this.moneyBackWarranty,this.expressWarranty,this.expressWarranty);
    }
}
