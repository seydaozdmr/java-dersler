package j_oop.defaultMethods;

public interface Swim {

    default void move(){
        System.out.println("yüzüyorum");
    }
}
