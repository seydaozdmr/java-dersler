package o_nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class PathAndInputStream {
    public static void main(String[] args) {

        int i;

        try(InputStream is = Files.newInputStream(Path.of("test.txt"))){
            while((i=is.read())!=-1){
                System.out.print((char) i);
            }
            System.out.println();

        }catch (InvalidPathException e){
            System.out.println("Path error "+e);
        }catch (IOException e){
            System.out.println("i/o error "+e);
        }
    }
}
