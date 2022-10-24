package j_oop.moreoojava;

import java.math.BigDecimal;
import java.util.Objects;

public class Currency implements Comparable<Currency> {
    private String symbol;

    public Currency(String symbol) {
        this.symbol = symbol;
    }

    public Money ZERO(){
        return new Money(BigDecimal.ZERO,this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(symbol, currency.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public int compareTo(Currency other) {
        return this.symbol.compareTo(other.symbol);
    }

    @Override
    public String toString() { return this.symbol; }
}
