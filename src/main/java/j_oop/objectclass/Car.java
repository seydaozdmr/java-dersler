package j_oop.objectclass;

public class Car {
    int tekerlek;
    int koltuk;
    String marka;
    String model;

    @Override
    public String toString() {
        return "Car{" +
                "tekerlek=" + tekerlek +
                ", koltuk=" + koltuk +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
