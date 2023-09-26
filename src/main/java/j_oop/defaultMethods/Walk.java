package j_oop.defaultMethods;

public interface Walk {
    default void move(){
        System.out.println("yürüyorum");
    }
}
