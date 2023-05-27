package o_nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class PathAndByteBufferEnhanced {
    public static void main(String[] args) {

        int count;

        try(SeekableByteChannel seekableByteChannel = Files.newByteChannel(Path.of("test2.txt"))){
            ByteBuffer mBuf= ByteBuffer.allocate(32);

            do {
                count = seekableByteChannel.read(mBuf);
                if(count!=-1){
                    mBuf.rewind();
                    for(int i=0;i<count;i++){
                        System.out.print((char) mBuf.get());
                    }
                    System.out.println();
                }
            }while (count!=-1);
        }catch (InvalidPathException e){
            System.out.println("Path error :"+e);
        }catch (IOException e){
            System.out.println("I/O error: "+e);
        }
    }
}
