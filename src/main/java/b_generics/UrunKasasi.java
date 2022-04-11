package b_generics;

import java.util.ArrayList;
import java.util.List;

public class UrunKasasi<T extends Urun> {

    List<T> list=new ArrayList<>();

    public void yaz(){
        for (T m:list) {
            System.out.println(m);
        }
    }

    public void ekle(T m){
        list.add(m);
    }

    public Integer fıyatgetır (T eleman){
        return eleman.prıce();
    }

    public T get(int ıd) {
        return list.get(ıd);
    }

    public <T extends Sebze> Integer dayaniklilikSuresi(T eleman){
        return eleman.dayaniklilikSuresi();
    }

    public Integer dayaniklilik(Sebze s){
        return s.dayaniklilikSuresi();
    }

    public  <R extends Urun>Integer sayıver(R urun){

        int count=0;
        for (T el:list){
            if (el.getClass().equals(urun.getClass())){
                count++;
            }
        }
        return count ;
    }
    /**
     * liste içerisindeki elemanların türüne bakarak kaç adet olduğunu veren method.
     */


}
