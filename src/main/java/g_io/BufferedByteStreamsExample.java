package g_io;

import java.io.*;

public class BufferedByteStreamsExample {
    public static void main(String[] args) throws IOException {
        BufferedInputStream is=new BufferedInputStream(new FileInputStream("test.txt"));
        BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream("test5.txt"));

        try{
            int c;
            while((c=is.read())!=-1){
                os.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        is.close();
        os.close();
    }
}
