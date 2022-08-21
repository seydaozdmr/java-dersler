package b_generics.ocp;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    //void'den önce gelen <T> method parametresini ve geri dönüş tipinin içerdiği tipi sınırlandırıyor
    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }
    //geri dönüş tipinden sonra gelen <T> bu methodun hangi tipte geri döneceğini sınırlandırıyor.
    public static <T> List<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new ArrayList<>();
    }

    public static <T,U> List<U> sample(T param){
        return new ArrayList<U>();
    }

    /**
     * eğer sınıf generic olursa bu method compile ediliyor
     *  public T noGood(T t)
     *     {
     *         return t;}
     */

}
