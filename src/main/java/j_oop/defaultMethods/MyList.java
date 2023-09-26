package j_oop.defaultMethods;

public interface MyList<T> {
    int size();
    void add(T elem);
    boolean isEmpty();
    String logo();

    default int fee() {
        return 10;
    }

}
