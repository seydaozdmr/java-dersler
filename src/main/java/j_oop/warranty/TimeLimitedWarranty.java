package j_oop.warranty;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

public class TimeLimitedWarranty implements Warranty{
    private LocalDate dateIssued;
    private Duration validFor;

    public TimeLimitedWarranty(LocalDate dateIssued, Duration validFor) {
        this.dateIssued = dateIssued;
        this.validFor = validFor;
    }


    @Override
    public Warranty on(LocalDate date) {
        //Garantinin hangi durumlarda gerçekleşeceğine burada karar veriyoruz. Hangi Tip garanti döneceğine?
        return date.compareTo(this.dateIssued)<0 ? Warranty.VOID :
                date.compareTo(this.getExpiredDate()) > 0 ? Warranty.VOID
                :this;
    }

    @Override
    public Optional<Warranty> filter(LocalDate date) {
        return date.compareTo(this.dateIssued) >= 0 && date.compareTo(this.getExpiredDate()) <= 0
                ? Optional.of(this)
                : Optional.empty();
    }

    @Override
    public void claim(Runnable action) {
        Warranty.super.claim(action);
    }

    private LocalDate getExpiredDate(){
        //Satın alımdan itibaren garantinin sona ereceği günün hesaplayıp dönüyor
        return this.dateIssued.plusDays(this.getValidForDays());
    }

    private long getValidForDays(){
        //Örneğin 60 gün garanti geçerli
        return this.validFor.toDays();
    }
}
