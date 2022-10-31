package j_oop.warranty;

import java.time.LocalDate;

public class VoidWarranty implements Warranty{

    @Override
    public Warranty on(LocalDate date) {
        return this;
    }

    @Override
    public void claim(Runnable runnable){
    }
}
