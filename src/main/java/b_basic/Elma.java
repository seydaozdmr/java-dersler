package b_basic;

public class Elma implements Meyva{
    Class myClass;

    public Elma() {
        myClass=Meyva.class;

    }

    @Override
    public void sat() {
        System.out.println("elma sattım");
    }

    @Override
    public String getname() {
        return "Elma";
    }

    @Override
    public Class getType() {
        return this.myClass;
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
