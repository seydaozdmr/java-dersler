package g_io;

import java.io.*;

public class CharacterStreamWithBufferedReaderAndWriter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("test.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("test5.txt"));
        //BufferedWriter -Buffered Input Stream (byte)
        String l;
        int count=0;
        while((l=bufferedReader.readLine())!=null){
            count++;
            System.out.println(l);
            writer.println(l);
        }
        System.out.println(count);
        //writer.flush();
        writer.close();
        bufferedReader.close();
    }
}
