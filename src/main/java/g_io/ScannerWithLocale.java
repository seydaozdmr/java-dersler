package g_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class ScannerWithLocale {
    public static void main(String[] args) {
        Scanner sc;
        double sum =0;

        //TODO US ile yazılmış bir dosyadaki para miktarlarını GERMAN'a çevirin

        try{
            sc=new Scanner(new BufferedReader(new FileReader("nums.txt")));
            sc.useLocale(Locale.GERMAN);

            while (sc.hasNext()){
                if(sc.hasNextDouble()){
                    sum+=sc.nextDouble();
                }else{
                    sc.next();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}
