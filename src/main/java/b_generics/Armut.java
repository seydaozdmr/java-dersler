package b_generics;

public class Armut implements Meyva{
    public Armut() {
    }

    @Override
    public void sat() {
        System.out.println("armut sat");
    }

    @Override
    public String getname() {
        return "Armut";
    }

    @Override
    public Class getType() {
        return Meyva.class;
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
