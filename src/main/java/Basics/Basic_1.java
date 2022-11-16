package Basics;

import java.util.Scanner;

public class Basic_1 {
    public static int a=10; //24

    public static int test(){
        //int a=12;
        return a;
    }
    public static void main(String[] args) {
        //int a=20;
        System.out.println(a);
        a=24;
        System.out.println(test());

        double t = 20.90;
        int r = (int) t;
        float b = (float)r;
        System.out.println(r);
        System.out.println(b);

        System.out.printf("sonuc= %f",t);
        System.out.println();
        System.out.printf("sonuc= %d %f",r,b);
        System.out.println();
        System.out.printf("%s tarafından %s imzalanmıştır. ",new String("GENCER"),"ONAY");
        System.out.println(new String("GENCER")+" tarafından "+new String("ONAY")+" onaylanmıştır.");
        System.out.println(formattedText("GENCER","RED"));
        System.out.println(formattedText("SEYDA","ONAY"));

        Scanner sc=new Scanner(System.in);
        System.out.println("1.Sayıyı giriniz: ");
        int sayi=sc.nextInt();

        System.out.println("2.Sayıyı giriniz: ");
        int sayi2=sc.nextInt();
        int result = sayi + sayi2;
        System.out.println("Toplam sayı : "+result);

        int x=6;
        int y=9;
        if(x>y){
            y=1;
        }else {
            x =0;
        }

        System.out.printf("X : %d  Y: %d",x,y);

    }

    public static String formattedText(String signer, String status){
        return String.format("%s tarafından %s durumda onaylanmıştır.",signer,status);
    }
}
