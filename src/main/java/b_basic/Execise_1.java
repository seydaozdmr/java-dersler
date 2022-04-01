package b_basic;

import java.util.ArrayList;
import java.util.List;

public class Execise_1 {
    public static void main(String[] args) {
        List list= new ArrayList();
        list.add("1");
        list.add("ali");
        list.add("mehmet");
        list.add("hasan");
        list.add("hüseyin");

        for(Object e:list){
            System.out.println(e);
        }

        List<String> list2=new ArrayList<>();
        list2.add("ali");
        list2.add("hasan");
        for(String e:list2){
            System.out.println(e);
        }

        Araba araba=new Araba(1, "BMW");
        Araba araba2=new Araba(2, "Audı");
        Araba araba3=new Araba(3, "Opel");

        List list3 =new ArrayList();
        list3.add(1);
        list3.add(araba2);
        list3.add(araba3);

//        for(Object o:list3){
//            System.out.println((Araba)o);
//        }

        Meyva m1 =new Elma();
        Meyva m2= new Armut();
        Sebze s1=new Fasulye();
        UrunKasasi<Urun> kasa=new UrunKasasi();
        kasa.ekle(m1);
        kasa.ekle(m2);
        kasa.ekle(s1);
        kasa.yaz();
        System.out.println(kasa.sayıver(m1));
        UrunOzellıklerı<Meyva> elmaOzellik = new UrunOzellıklerı<>(1,m1,20.6);

        UrunOzellıklerı<Sebze> fasulyeOzellik= new UrunOzellıklerı<>(1,s1,10.5);

        System.out.println(kasa.get(0).prıce());

        karakterSayısı<String,Integer> karakterSayısıbul=new karakterSayısı<>("Abdullah");
        System.out.println(karakterSayısıbul.karakterSayısı());

        UrunFiyatlar<Meyva,Double> kasafıyatları=new UrunFiyatlar<>();
        kasafıyatları.urunekle(m1);
        kasafıyatları.urunekle(m2);

        kasafıyatları.fıyatbılgısıyazdır();

//        List<Number> isimler=List.of(1,2,3,4,5);
//        List<Integer> sayilar=isimler;
//
//        UrunKasasi<Sebze> sebzeKasasi=new UrunKasasi<>();
//        UrunKasasi<Meyva> meyvaUrunKasasi=new UrunKasasi<>();
//        UrunKasasi<Urun> urunUrunKasasi=new UrunKasasi<>();
//        urunUrunKasasi=sebzeKasasi;

        Sebze sebze=new Fasulye();
        Urun urun=sebze;

        Number number=new Integer(10);
        Integer number2=new Integer(10);
        number=number2;


    }
}
