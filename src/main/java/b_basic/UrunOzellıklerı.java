package b_basic;

public class UrunOzellıklerı<T> {
    int Id;
    T eleman;
    double prıce;

    public UrunOzellıklerı(int id, T eleman, double prıce) {
        Id = id;
        this.eleman = eleman;
        this.prıce = prıce;
    }

    public double getPrıce(){

        return prıce;
    }
}
