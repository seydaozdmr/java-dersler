package g_io.basics.new_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEdit {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        String[]arr=new String[100];

        System.out.println("Enter lines of text");
        System.out.println("Enter stop to exit");
        for(int i=0;i<arr.length;i++){
            arr[i]=bufferedReader.readLine();
            if(arr[i].equals("stop"))
                break;
        }

        System.out.println("\nHere is your file:");
        // display the lines
        for(int i=0; i<100; i++) {
            if(arr[i].equals("stop")) break;
            System.out.println(arr[i]);
        }
    }
}
