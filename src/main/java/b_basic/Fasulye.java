package b_basic;

public class Fasulye implements Sebze{
    @Override
    public int prıce() {
        return 15;
    }

    @Override
    public void urununAdiYaz() {
        System.out.println("fasulye");
    }

    @Override
    public String getname() {
        return "Fasulye";
    }

    @Override
    public int dayaniklilikSuresi() {
        return 10;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
