package j_oop.defaultMethods;

import org.apache.http.ConnectionClosedException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.jar.JarException;

public class SpecialCalcute extends Calculate{

    @Override
    public Integer add(int a, int b) throws JarException {
        try {
            return  (Integer) super.add(a, b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
