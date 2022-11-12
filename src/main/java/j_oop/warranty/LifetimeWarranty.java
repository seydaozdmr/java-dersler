package j_oop.warranty;

import java.time.LocalDate;
import java.util.Optional;

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
    public Optional<Warranty> filter(LocalDate date) {
        return date.compareTo(this.issuedOn) >= 0 ? Optional.of(this) : Optional.empty();
    }

    @Override
    public void claim(Runnable action) {
        Warranty.super.claim(action);
    }
}
