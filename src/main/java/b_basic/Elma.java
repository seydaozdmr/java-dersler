package b_basic;

public class Elma implements Meyva{

    @Override
    public void sat() {
        System.out.println("elma sattım");
    }

    @Override
    public String getname() {
        return "Elma";
    }

    @Override
    public int prıce() {
        return 5;
    }

    @Override
    public void urununAdiYaz() {
        System.out.println("elma");
    }
}
