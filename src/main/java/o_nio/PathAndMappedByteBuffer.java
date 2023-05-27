package o_nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class PathAndMappedByteBuffer {
    public static void main(String[] args) {

        try(FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("test3.txt"))){
            long fSize = fileChannel.size();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,fSize);

            for(int i=0;i<fSize;i++){
                System.out.print((char) mappedByteBuffer.get());
            }
            System.out.println();
        }catch (InvalidPathException e){
            System.out.println("Path error "+e);
        }catch (IOException e){
            System.out.println("I/O error "+e);
        }
    }
}
