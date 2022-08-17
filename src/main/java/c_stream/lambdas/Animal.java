package c_stream.lambdas;

public class Animal {
    private String name;
    private boolean canHop;
    private boolean isSwim;

    public Animal(String name, boolean canHop,boolean isSwim) {
        this.name = name;
        this.canHop = canHop;
        this.isSwim=isSwim;
    }

    public String getName() {
        return name;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isSwim(){
        return isSwim;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
