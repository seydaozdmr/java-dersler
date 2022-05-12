package e_methodreferance;

import java.time.LocalDate;

@FunctionalInterface
public interface CarService {
    boolean isServiceTime(LocalDate tarih);
}
