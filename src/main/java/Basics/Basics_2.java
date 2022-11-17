package Basics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Basics_2 {
    public static void main(String[] args) {
//        int x=1;
//        int y=2;
//
//        int z = (x>y) ? x : y;
//
//        System.out.println(z);
//
//        System.out.println((10>9) ? "10 büyüktür 9 ": " 10 küçüktür 9");
//
//        Scanner sc = new Scanner(System.in);
////        System.out.println("Notunuzu giriniz");
////        int not = sc.nextInt();
////
////        if(not<45){
////            System.out.println("FF");
////        }else if(not<55){
////            System.out.println("DD");
////        } else if (not<70) {
////            System.out.println("BB");
////        }else{
////            System.out.println("AA");
////        }
//
////        System.out.println("Yaşınızı giriniz");
////        int yas = sc.nextInt();
////
////        System.out.println("Doğum tarihinizi giriniz");
////        int dogumTarihi = sc.nextInt();
////
////        int result = 2022 - dogumTarihi;
////        System.out.println("SONUC: "+result);
////        System.out.println((yas == result)?"doğum tarihi doğru":"doğum tarihi yanlış");
////
////        if(yas==20 && result==20){
////            System.out.println("doğru");
////        }else{
////            System.out.println("yanlış");
////        }
//
//        String day = "SALI";
//        double bill = 100;
//        switch (day){
//            case "PAZARTESİ" -> bill*=0.95;
//            case "SALI" -> bill*=0.91;
//            default-> {
//            }
//        }
//        System.out.println(bill);
//
//        for(int i=0;i<10;i+=1){
//            if(i%2==0)
//                System.out.println(i);
//        }
//        for(int i=0;i<100;i+=1){
//            if(i%2==0 && i%7==0)
//                System.out.println(i);
//        }
//
//        for(int i=0;i<100;i++){
//            if(i%3==0 || i%5==0)
//                System.out.println(i);
//        }
//
//        for(int i=0;i<10;i++){
//            for(int j=0;j<i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        int start=0;
//        while(start<10){
//            System.out.println(start++);
////            start++;
//        }
//
//        int fak=5;
//        int result=1;
//        while (fak>0){
//            result = result*fak;
//            fak--;
//        }
//        System.out.println(result);
//
//        Scanner sc1 = new Scanner(System.in);
        //int [] array=new int[10];
//        int result1=0;
//        for(int i=0;i<10;i++){
//            result1 += sc1.nextInt();;
//        }
//        System.out.println("SONUC:"+result1);
//        for(int i=0;i<10;i++){
//            System.out.println(array[i]);
//        }

//        int value =1;
//        while(value>0){
//            value = sc1.nextInt();
//            if(value>0)
//                System.out.println("sonuc:"+(value*value));
//        }

//        for(int i=1;i<1000;i++){
//            if(i%5!=0) {
//                //System.out.println("döngü bitti");
//                continue;//devam et
//            }else{
//                System.out.println(i);
//            }
//
//        }

        for(int i=1;i<=10;i++){
            for(int j=1;j<=10;j++){
                System.out.print((i*j)+" ");
            }

            System.out.println();
        }
        if(6>9)
            System.out.println("ifade");
            System.out.println("ifade");






    }

}
