package j_oop.warranty;

import java.time.LocalDate;

public class LifetimeWarranty implements Warranty{

    private LocalDate issuedOn;

    public LifetimeWarranty(LocalDate issuedOn) {
        this.issuedOn = issuedOn;
    }


    @Override
    public Warranty on(LocalDate date) {
        return date.compareTo(issuedOn)>0 ? this : new VoidWarranty();
    }

    @Override
    public void claim(Runnable action) {
        Warranty.super.claim(action);
    }
}
