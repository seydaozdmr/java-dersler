package g_io;

import java.util.Scanner;

public class ScannerStart01 {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int result = 0;
        for (int i=0; i<5; i++){
            result=result+scan.nextInt();
        }
        System.out.println(result);
    }
}
