package b_basic;

import java.util.ArrayList;
import java.util.List;

public class UrunFiyatlar <T extends Urun,R extends Double>{
    List<T> urunListesi;
    List<R> fiyatListesi;

    public UrunFiyatlar(){
        urunListesi=new ArrayList<>();
        fiyatListesi =new ArrayList<>();
    }

    public void urunekle(T urun) {
        urunListesi.add(urun);
        fiyatListesi.add((R) Double.valueOf(urun.prıce()));
    }

    public void fıyatbılgısıyazdır(){
        for (int j=0; j<urunListesi.size();j++){
            System.out.println(urunListesi.get(j).getname()+" : "+fiyatListesi.get(j));
        }
    }


}
