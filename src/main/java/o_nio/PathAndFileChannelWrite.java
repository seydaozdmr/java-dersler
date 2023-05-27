package o_nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class PathAndFileChannelWrite {
    public static void main(String[] args) {

        try(FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("test4.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE)){
            ByteBuffer buffer = ByteBuffer.allocate(26);

            for(int i=0;i<26;i++){
                buffer.put((byte) ('A'+i));
            }

            buffer.rewind();
            fileChannel.write(buffer);

        }catch (InvalidPathException e){
            System.out.println("Path exception "+e);
        }catch (IOException e){
            System.out.println("I/O exception "+e);
        }
    }
}
