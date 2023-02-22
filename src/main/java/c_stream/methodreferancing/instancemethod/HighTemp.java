package c_stream.methodreferancing.instancemethod;

public class HighTemp {
    private int hTemp;

    public HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    boolean sameTemp(HighTemp ht2){
        return hTemp==ht2.hTemp;
    }

    boolean lessThanTemp(HighTemp ht2){
        return this.hTemp < ht2.hTemp;
    }
}
