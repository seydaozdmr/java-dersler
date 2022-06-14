package g_io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner=null;
        try{
//            scanner=new Scanner(new BufferedReader(new FileReader("test.txt")));
//
//            int count=0;
//            while(scanner.hasNext()){
//                count++;
//                System.out.println(scanner.next());
//            }
//            System.out.println(count);
            scanner=new Scanner(new FileInputStream("test.txt"));
            int c=0;
            while(scanner.hasNext()){
                System.out.println(scanner.nextInt());
            }
            //TODO Scanner ile byte okuma
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
