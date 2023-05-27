package o_nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class PathAndMappedChannelWrite {
    public static void main(String[] args) {

        try(FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("newtest.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,26);

            for(int i=0;i<26;i++){
                mappedByteBuffer.put((byte) ('a'+i));
            }
        }catch (InvalidPathException e){
            System.out.println("path error "+e);
        }catch (IOException e){
            System.out.println("i/o error"+e);
        }
    }
}
