package o_nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class PathAndByteBuffer {
    public static void main(String[] args) {
        int count;
        Path filepath = null;

        try{
            filepath = Path.of("test.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error : "+e);
            return;
        }

        try(SeekableByteChannel fChan = Files.newByteChannel(filepath)){
            ByteBuffer mBuf = ByteBuffer.allocate(32);

            do{
                //Read buffer
                //fChan aracılığı ile buffer limiti kadar byte okuyor (okunacak byte kalmayınca -1 dönüyor)
                count = fChan.read(mBuf);

                if(count!=-1){
                    //buffer i geri sar
                    mBuf.rewind();

                    for(int i=0;i<count;i++){
                        System.out.println((char) mBuf.get());
                    }
                }
            }while (count!= -1 );

        }catch (IOException e){
            System.out.println("I/O exception "+ e);
        }
    }
}
