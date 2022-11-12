package j_oop.warranty;

import java.time.LocalDate;
import java.util.Optional;

public class Article {
    /**
     * Article nesnesi 2 adet garanti durumunu init edilirken constructor ına alıyor.
     */
    private Warranty moneyBackWarranty;
    private Warranty expressWarranty;

    private Warranty effectiveExpressWarranty = Warranty.VOID;
    private Optional<Part> sensor;
    private Warranty extendedWarranty;

    public Article(Warranty moneyBackWarranty, Warranty expressWarranty) {
        this(moneyBackWarranty,expressWarranty,Warranty.VOID,Optional.empty(),Warranty.VOID);
    }

    private Article (Warranty moneyBackWarranty,Warranty expressWarranty,Warranty effectiveExpressWarranty,Optional<Part> sensor,Warranty extendedWarranty) {
        if(moneyBackWarranty == null) throw new IllegalArgumentException("not null");
        if(expressWarranty ==null) throw new IllegalArgumentException("not null");
        this.moneyBackWarranty = moneyBackWarranty;
        this.expressWarranty = expressWarranty;
        this.effectiveExpressWarranty = effectiveExpressWarranty;
        this.sensor = sensor;
        this.extendedWarranty = extendedWarranty;
    }

    public Warranty getMoneyBackWarranty() {
        return moneyBackWarranty;
    }

    public Warranty getExpressWarranty() {
        return effectiveExpressWarranty;
    }
    public Warranty getExtendedWarranty(){
        //Sensöre vereceğim function ile sensörü değiştir ve geriye sensöre ait garanti bilgisini dön.
        return this.sensor.map(part->part.apply(this.extendedWarranty)).orElse(Warranty.VOID);
    }

    public Article withVisibleDamage(){
        /**
         * Visible damage olduğunda para iade garantisi olmuyor.
         */
        return new Article(Warranty.VOID,this.expressWarranty,this.effectiveExpressWarranty,this.sensor,this.extendedWarranty);
    }

    public Article notOperational(){
        return new Article(this.moneyBackWarranty,this.expressWarranty,this.expressWarranty,this.sensor,this.extendedWarranty);
    }

    public Article install (Part sensor,Warranty extendedWarranty){
        return new Article(this.moneyBackWarranty,this.expressWarranty,this.effectiveExpressWarranty,Optional.of(sensor),extendedWarranty);

    }

    public Article sensorNotOperational (LocalDate detectedOn){
        return this.sensor
                .map(part->part.defective(detectedOn))
                .map(defective->this.install(defective,this.extendedWarranty))
                .orElse(this);
    }
}
