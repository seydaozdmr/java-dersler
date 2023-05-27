package o_nio;

import java.io.IOException;
import java.nio.file.*;

public class PathAndCopyFiles {
    public static void main(String[] args) {

        try{
            Path source = Path.of("test.txt");
            Path destination = Path.of("dest.txt");

            Files.copy(source,destination, StandardCopyOption.REPLACE_EXISTING);
        }catch (InvalidPathException e){
            System.out.println("path error "+e);
        }catch (IOException e){
            System.out.println("i/o error "+e);
        }
    }
}
