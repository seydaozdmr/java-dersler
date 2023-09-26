package j_oop.defaultMethods;

public class LittleBag<T> implements MyList<T>{
    private final int INITIAL_CAPACITY =100;
    T[] elems = (T[]) new Object[INITIAL_CAPACITY];
    private int index = 0;

    @Override
    public int size() {
        return elems.length;
    }

    @Override
    public void add(T elem) {
        if(index >= elems.length/2){
            T[] newElems = (T[]) new Object[elems.length * 2];
            int zero = 0;
            for(T e:elems){
                newElems[zero++] = e;
            }
            elems = newElems;
            newElems = null;
        }
        elems[index++] =elem;
    }

    @Override
    public boolean isEmpty() {
        return elems.length == 0;
    }

    @Override
    public String logo() {
        return null;
    }

}
