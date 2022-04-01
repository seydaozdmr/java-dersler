package b_basic;

public class Armut implements Meyva{
    @Override
    public void sat() {
        System.out.println("armut sat");
    }

    @Override
    public String getname() {
        return "Armut";
    }

    @Override
    public int prıce() {
        return 10;
    }

    @Override
    public void urununAdiYaz() {
        System.out.println("armut");
    }
}
