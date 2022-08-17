package j_oop;

public interface AnotherSoar {
    int MAX_HEIGHT=10; //public static final
    default int getMaxHeight(){
        return MAX_HEIGHT;
    }
}
