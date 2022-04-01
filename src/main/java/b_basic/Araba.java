package b_basic;

public class Araba {
    int id;
    String name;

    public Araba(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Araba{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
