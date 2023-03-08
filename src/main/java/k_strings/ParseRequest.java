package k_strings;

import java.io.UnsupportedEncodingException;

public class ParseRequest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String request = new String("Tümü".getBytes("iso-8859-1"),"UTF-8");
        System.out.println(request);
    }
}
